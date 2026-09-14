package com.google.firebase.firestore.local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteProgram;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteStatement;
import android.database.sqlite.SQLiteTransactionListener;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.common.base.Function;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.FileUtil;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class SQLitePersistence extends Persistence {
    private SQLiteDatabase db;
    private final SQLiteIndexManager indexManager;
    private final SQLiteOpenHelper opener;
    private final SQLiteQueryCache queryCache;
    private final SQLiteLruReferenceDelegate referenceDelegate;
    private final SQLiteRemoteDocumentCache remoteDocumentCache;
    private final LocalSerializer serializer;
    private boolean started;
    private final SQLiteTransactionListener transactionListener;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.local.SQLitePersistence$1 */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements SQLiteTransactionListener {
        AnonymousClass1() {
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onBegin() {
            SQLitePersistence.this.referenceDelegate.onTransactionStarted();
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onCommit() {
            SQLitePersistence.this.referenceDelegate.onTransactionCommitted();
        }

        @Override // android.database.sqlite.SQLiteTransactionListener
        public void onRollback() {
        }
    }

    /* loaded from: classes2.dex */
    static class LongQuery {
        private static final int LIMIT = 900;
        private final List<Object> argsHead;
        private final Iterator<Object> argsIter;
        private final SQLitePersistence db;
        private final String head;
        private int subqueriesPerformed;
        private final String tail;

        public LongQuery(SQLitePersistence sQLitePersistence, String str, List<Object> list, String str2) {
            this.subqueriesPerformed = 0;
            this.db = sQLitePersistence;
            this.head = str;
            this.argsHead = Collections.emptyList();
            this.tail = str2;
            this.argsIter = list.iterator();
        }

        public LongQuery(SQLitePersistence sQLitePersistence, String str, List<Object> list, List<Object> list2, String str2) {
            this.subqueriesPerformed = 0;
            this.db = sQLitePersistence;
            this.head = str;
            this.argsHead = list;
            this.tail = str2;
            this.argsIter = list2.iterator();
        }

        public int a() {
            return this.subqueriesPerformed;
        }

        public boolean b() {
            return this.argsIter.hasNext();
        }

        public Query c() {
            this.subqueriesPerformed++;
            ArrayList arrayList = new ArrayList(this.argsHead);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; this.argsIter.hasNext() && i < 900 - this.argsHead.size(); i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append("?");
                arrayList.add(this.argsIter.next());
            }
            String sb2 = sb.toString();
            return this.db.b(this.head + sb2 + this.tail).a(arrayList.toArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class OpenHelper extends SQLiteOpenHelper {
        private boolean configured;

        OpenHelper(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 10);
        }

        private void ensureConfigured(SQLiteDatabase sQLiteDatabase) {
            if (this.configured) {
                return;
            }
            onConfigure(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            this.configured = true;
            sQLiteDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", new String[0]).close();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            ensureConfigured(sQLiteDatabase);
            new SQLiteSchema(sQLiteDatabase).a(0);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            ensureConfigured(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            ensureConfigured(sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            ensureConfigured(sQLiteDatabase);
            new SQLiteSchema(sQLiteDatabase).a(i);
        }
    }

    /* loaded from: classes2.dex */
    public static class Query {
        private SQLiteDatabase.CursorFactory cursorFactory;
        private final SQLiteDatabase db;
        private final String sql;

        public Query(SQLiteDatabase sQLiteDatabase, String str) {
            this.db = sQLiteDatabase;
            this.sql = str;
        }

        public static /* synthetic */ Cursor a(Object[] objArr, SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            SQLitePersistence.bind(sQLiteQuery, objArr);
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }

        private Cursor startQuery() {
            SQLiteDatabase.CursorFactory cursorFactory = this.cursorFactory;
            return cursorFactory != null ? this.db.rawQueryWithFactory(cursorFactory, this.sql, null, null) : this.db.rawQuery(this.sql, null);
        }

        public int a(Consumer<Cursor> consumer) {
            Cursor cursor;
            try {
                cursor = startQuery();
                try {
                    if (!cursor.moveToFirst()) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return 0;
                    }
                    consumer.accept(cursor);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return 1;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        }

        public Query a(Object... objArr) {
            this.cursorFactory = SQLitePersistence$Query$$Lambda$1.lambdaFactory$(objArr);
            return this;
        }

        @Nullable
        public <T> T a(Function<Cursor, T> function) {
            Cursor cursor;
            try {
                cursor = startQuery();
                try {
                    if (!cursor.moveToFirst()) {
                        if (cursor != null) {
                            cursor.close();
                        }
                        return null;
                    }
                    T apply = function.apply(cursor);
                    if (cursor != null) {
                        cursor.close();
                    }
                    return apply;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        }

        public boolean a() {
            Cursor cursor;
            try {
                cursor = startQuery();
                try {
                    boolean z = !cursor.moveToFirst();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return z;
                } catch (Throwable th) {
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        }

        public int b(Consumer<Cursor> consumer) {
            Cursor startQuery = startQuery();
            int i = 0;
            while (startQuery.moveToNext()) {
                try {
                    i++;
                    consumer.accept(startQuery);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (startQuery != null) {
                            try {
                                startQuery.close();
                            } catch (Throwable unused) {
                            }
                        }
                        throw th2;
                    }
                }
            }
            if (startQuery != null) {
                startQuery.close();
            }
            return i;
        }
    }

    public SQLitePersistence(Context context, String str, DatabaseId databaseId, LocalSerializer localSerializer, LruGarbageCollector.Params params) {
        this(localSerializer, params, new OpenHelper(context, databaseName(str, databaseId)));
    }

    public SQLitePersistence(LocalSerializer localSerializer, LruGarbageCollector.Params params, SQLiteOpenHelper sQLiteOpenHelper) {
        this.transactionListener = new SQLiteTransactionListener() { // from class: com.google.firebase.firestore.local.SQLitePersistence.1
            AnonymousClass1() {
            }

            @Override // android.database.sqlite.SQLiteTransactionListener
            public void onBegin() {
                SQLitePersistence.this.referenceDelegate.onTransactionStarted();
            }

            @Override // android.database.sqlite.SQLiteTransactionListener
            public void onCommit() {
                SQLitePersistence.this.referenceDelegate.onTransactionCommitted();
            }

            @Override // android.database.sqlite.SQLiteTransactionListener
            public void onRollback() {
            }
        };
        this.opener = sQLiteOpenHelper;
        this.serializer = localSerializer;
        this.queryCache = new SQLiteQueryCache(this, this.serializer);
        this.indexManager = new SQLiteIndexManager(this);
        this.remoteDocumentCache = new SQLiteRemoteDocumentCache(this, this.serializer);
        this.referenceDelegate = new SQLiteLruReferenceDelegate(this, params);
    }

    public static void bind(SQLiteProgram sQLiteProgram, Object[] objArr) {
        int i;
        long longValue;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj == null) {
                sQLiteProgram.bindNull(i2 + 1);
            } else if (obj instanceof String) {
                sQLiteProgram.bindString(i2 + 1, (String) obj);
            } else {
                if (obj instanceof Integer) {
                    i = i2 + 1;
                    longValue = ((Integer) obj).intValue();
                } else if (obj instanceof Long) {
                    i = i2 + 1;
                    longValue = ((Long) obj).longValue();
                } else if (obj instanceof Double) {
                    sQLiteProgram.bindDouble(i2 + 1, ((Double) obj).doubleValue());
                } else {
                    if (!(obj instanceof byte[])) {
                        throw Assert.fail("Unknown argument %s of type %s", obj, obj.getClass());
                    }
                    sQLiteProgram.bindBlob(i2 + 1, (byte[]) obj);
                }
                sQLiteProgram.bindLong(i, longValue);
            }
        }
    }

    public static void clearPersistence(Context context, DatabaseId databaseId, String str) {
        String path = context.getDatabasePath(databaseName(str, databaseId)).getPath();
        String str2 = path + "-wal";
        File file = new File(path);
        File file2 = new File(path + "-journal");
        File file3 = new File(str2);
        try {
            FileUtil.delete(file);
            FileUtil.delete(file2);
            FileUtil.delete(file3);
        } catch (IOException e) {
            throw new FirebaseFirestoreException("Failed to clear persistence." + e, FirebaseFirestoreException.Code.UNKNOWN);
        }
    }

    @VisibleForTesting
    public static String databaseName(String str, DatabaseId databaseId) {
        try {
            return "firestore." + URLEncoder.encode(str, "utf-8") + "." + URLEncoder.encode(databaseId.getProjectId(), "utf-8") + "." + URLEncoder.encode(databaseId.getDatabaseId(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    private long getPageCount() {
        Function function;
        Query b = b("PRAGMA page_count");
        function = SQLitePersistence$$Lambda$2.instance;
        return ((Long) b.a(function)).longValue();
    }

    private long getPageSize() {
        Function function;
        Query b = b("PRAGMA page_size");
        function = SQLitePersistence$$Lambda$1.instance;
        return ((Long) b.a(function)).longValue();
    }

    public int a(SQLiteStatement sQLiteStatement, Object... objArr) {
        sQLiteStatement.clearBindings();
        bind(sQLiteStatement, objArr);
        return sQLiteStatement.executeUpdateDelete();
    }

    public SQLiteStatement a(String str) {
        return this.db.compileStatement(str);
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public IndexManager a() {
        return this.indexManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public MutationQueue a(User user) {
        return new SQLiteMutationQueue(this, this.serializer, user);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public <T> T a(String str, Supplier<T> supplier) {
        Logger.debug(Persistence.a, "Starting transaction: %s", str);
        this.db.beginTransactionWithListener(this.transactionListener);
        try {
            T t = supplier.get();
            this.db.setTransactionSuccessful();
            return t;
        } finally {
            this.db.endTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.local.Persistence
    public void a(String str, Runnable runnable) {
        Logger.debug(Persistence.a, "Starting transaction: %s", str);
        this.db.beginTransactionWithListener(this.transactionListener);
        try {
            runnable.run();
            this.db.setTransactionSuccessful();
        } finally {
            this.db.endTransaction();
        }
    }

    public void a(String str, Object... objArr) {
        this.db.execSQL(str, objArr);
    }

    public Query b(String str) {
        return new Query(this.db, str);
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public SQLiteQueryCache b() {
        return this.queryCache;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public RemoteDocumentCache c() {
        return this.remoteDocumentCache;
    }

    public long d() {
        return getPageCount() * getPageSize();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public SQLiteLruReferenceDelegate getReferenceDelegate() {
        return this.referenceDelegate;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public boolean isStarted() {
        return this.started;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public void shutdown() {
        Assert.hardAssert(this.started, "SQLitePersistence shutdown without start!", new Object[0]);
        this.started = false;
        this.db.close();
        this.db = null;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public void start() {
        Assert.hardAssert(!this.started, "SQLitePersistence double-started!", new Object[0]);
        this.started = true;
        try {
            this.db = this.opener.getWritableDatabase();
            this.queryCache.a();
            this.referenceDelegate.a(this.queryCache.getHighestListenSequenceNumber());
        } catch (SQLiteDatabaseLockedException e) {
            throw new RuntimeException("Failed to gain exclusive lock to the Cloud Firestore client's offline persistence. This generally means you are using Cloud Firestore from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing Cloud Firestore in your Application class. If you are intentionally using Cloud Firestore from multiple processes, you can only enable offline persistence (that is, call setPersistenceEnabled(true)) in one of them.", e);
        }
    }
}
