package com.google.firebase.database.android;

import F0.AbstractC0008a;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.persistence.PersistenceStorageEngine;
import com.google.firebase.database.core.persistence.PruneForest;
import com.google.firebase.database.core.persistence.TrackedQuery;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.util.JsonMapper;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class SqlPersistenceStorageEngine implements PersistenceStorageEngine {
    private static final int CHILDREN_NODE_SPLIT_SIZE_THRESHOLD = 16384;
    private static final String CREATE_SERVER_CACHE = "CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);";
    private static final String CREATE_TRACKED_KEYS = "CREATE TABLE trackedKeys (id INTEGER, key TEXT);";
    private static final String CREATE_TRACKED_QUERIES = "CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);";
    private static final String CREATE_WRITES = "CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));";
    private static final String FIRST_PART_KEY = ".part-0000";
    private static final String LOGGER_COMPONENT = "Persistence";
    private static final String PART_KEY_FORMAT = ".part-%04d";
    private static final String PART_KEY_PREFIX = ".part-";
    private static final String PATH_COLUMN_NAME = "path";
    private static final String ROW_ID_COLUMN_NAME = "rowid";
    private static final int ROW_SPLIT_SIZE = 262144;
    private static final String SERVER_CACHE_TABLE = "serverCache";
    private static final String TRACKED_KEYS_ID_COLUMN_NAME = "id";
    private static final String TRACKED_KEYS_KEY_COLUMN_NAME = "key";
    private static final String TRACKED_KEYS_TABLE = "trackedKeys";
    private static final String TRACKED_QUERY_ACTIVE_COLUMN_NAME = "active";
    private static final String TRACKED_QUERY_COMPLETE_COLUMN_NAME = "complete";
    private static final String TRACKED_QUERY_ID_COLUMN_NAME = "id";
    private static final String TRACKED_QUERY_LAST_USE_COLUMN_NAME = "lastUse";
    private static final String TRACKED_QUERY_PARAMS_COLUMN_NAME = "queryParams";
    private static final String TRACKED_QUERY_PATH_COLUMN_NAME = "path";
    private static final String TRACKED_QUERY_TABLE = "trackedQueries";
    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");
    private static final String VALUE_COLUMN_NAME = "value";
    private static final String WRITES_TABLE = "writes";
    private static final String WRITE_ID_COLUMN_NAME = "id";
    private static final String WRITE_NODE_COLUMN_NAME = "node";
    private static final String WRITE_PART_COLUMN_NAME = "part";
    private static final String WRITE_TYPE_COLUMN_NAME = "type";
    private static final String WRITE_TYPE_MERGE = "m";
    private static final String WRITE_TYPE_OVERWRITE = "o";
    private final SQLiteDatabase database;
    private boolean insideTransaction;
    private final LogWrapper logger;
    private long transactionStart = 0;

    /* loaded from: classes.dex */
    public static class PersistentCacheOpenHelper extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 2;

        public PersistentCacheOpenHelper(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        }

        private void dropTable(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_SERVER_CACHE);
            sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_WRITES);
            sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_QUERIES);
            sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_KEYS);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i3) {
            boolean z3;
            if (i3 == 2) {
                z3 = true;
            } else {
                z3 = false;
            }
            Utilities.hardAssert(z3, "Why is onUpgrade() called with a different version?");
            if (i <= 1) {
                dropTable(sQLiteDatabase, SqlPersistenceStorageEngine.SERVER_CACHE_TABLE);
                sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_SERVER_CACHE);
                dropTable(sQLiteDatabase, SqlPersistenceStorageEngine.TRACKED_QUERY_COMPLETE_COLUMN_NAME);
                sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_KEYS);
                sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_QUERIES);
                return;
            }
            throw new AssertionError(e0.a.c(i3, "We don't handle upgrading to "));
        }
    }

    public SqlPersistenceStorageEngine(Context context, com.google.firebase.database.core.Context context2, String str) {
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            this.logger = context2.getLogger(LOGGER_COMPONENT);
            this.database = openDatabase(context, encode);
        } catch (IOException e4) {
            throw new RuntimeException(e4);
        }
    }

    private static String buildAncestorWhereClause(Path path, String[] strArr) {
        boolean z3 = true;
        int i = 0;
        if (strArr.length < path.size() + 1) {
            z3 = false;
        }
        Utilities.hardAssert(z3);
        StringBuilder sb = new StringBuilder("(");
        while (!path.isEmpty()) {
            sb.append("path = ? OR ");
            strArr[i] = pathToKey(path);
            path = path.getParent();
            i++;
        }
        sb.append("path = ?)");
        strArr[i] = pathToKey(Path.getEmptyPath());
        return sb.toString();
    }

    private String commaSeparatedList(Collection<Long> collection) {
        StringBuilder sb = new StringBuilder();
        Iterator<Long> it = collection.iterator();
        boolean z3 = true;
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            if (!z3) {
                sb.append(",");
            }
            sb.append(longValue);
            z3 = false;
        }
        return sb.toString();
    }

    private Node deserializeNode(byte[] bArr) {
        try {
            return NodeUtilities.NodeFromJSON(JsonMapper.parseJsonValue(new String(bArr, UTF8_CHARSET)));
        } catch (IOException e4) {
            throw new RuntimeException("Could not deserialize node: ".concat(new String(bArr, UTF8_CHARSET)), e4);
        }
    }

    private byte[] joinBytes(List<byte[]> list) {
        Iterator<byte[]> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().length;
        }
        byte[] bArr = new byte[i];
        int i3 = 0;
        for (byte[] bArr2 : list) {
            System.arraycopy(bArr2, 0, bArr, i3, bArr2.length);
            i3 += bArr2.length;
        }
        return bArr;
    }

    private Node loadNested(Path path) {
        long j2;
        Path path2;
        Node node;
        Path path3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor loadNestedQuery = loadNestedQuery(path, new String[]{"path", "value"});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        while (loadNestedQuery.moveToNext()) {
            try {
                arrayList.add(loadNestedQuery.getString(0));
                arrayList2.add(loadNestedQuery.getBlob(1));
            } catch (Throwable th) {
                loadNestedQuery.close();
                throw th;
            }
        }
        loadNestedQuery.close();
        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
        long currentTimeMillis5 = System.currentTimeMillis();
        Node Empty = EmptyNode.Empty();
        HashMap hashMap = new HashMap();
        int i = 0;
        boolean z3 = false;
        while (i < arrayList2.size()) {
            long j3 = currentTimeMillis;
            if (((String) arrayList.get(i)).endsWith(FIRST_PART_KEY)) {
                j2 = currentTimeMillis2;
                Path path4 = new Path(((String) arrayList.get(i)).substring(0, r5.length() - 10));
                int splitNodeRunLength = splitNodeRunLength(path4, arrayList, i);
                if (this.logger.logsDebug()) {
                    path3 = path4;
                    this.logger.debug(AbstractC0008a.j(splitNodeRunLength, "Loading split node with ", " parts."), new Object[0]);
                } else {
                    path3 = path4;
                }
                int i3 = splitNodeRunLength + i;
                Node deserializeNode = deserializeNode(joinBytes(arrayList2.subList(i, i3)));
                i = i3 - 1;
                node = deserializeNode;
                path2 = path3;
            } else {
                j2 = currentTimeMillis2;
                Node deserializeNode2 = deserializeNode((byte[]) arrayList2.get(i));
                path2 = new Path((String) arrayList.get(i));
                node = deserializeNode2;
            }
            if (path2.getBack() != null && path2.getBack().isPriorityChildName()) {
                hashMap.put(path2, node);
            } else if (path2.contains(path)) {
                Utilities.hardAssert(!z3, "Descendants of path must come after ancestors.");
                Empty = node.getChild(Path.getRelative(path2, path));
            } else if (path.contains(path2)) {
                Empty = Empty.updateChild(Path.getRelative(path, path2), node);
                z3 = true;
            } else {
                throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", path2, path));
            }
            i++;
            currentTimeMillis = j3;
            currentTimeMillis2 = j2;
        }
        long j4 = currentTimeMillis;
        long j5 = currentTimeMillis2;
        Node node2 = Empty;
        for (Map.Entry entry : hashMap.entrySet()) {
            node2 = node2.updateChild(Path.getRelative(path, (Path) entry.getKey()), (Node) entry.getValue());
        }
        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
        long currentTimeMillis7 = System.currentTimeMillis() - j4;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", Integer.valueOf(arrayList2.size()), Integer.valueOf(NodeSizeEstimator.nodeCount(node2)), path, Long.valueOf(currentTimeMillis7), Long.valueOf(j5), Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis6)), new Object[0]);
        }
        return node2;
    }

    private Cursor loadNestedQuery(Path path, String[] strArr) {
        String pathToKey = pathToKey(path);
        String pathPrefixStartToPrefixEnd = pathPrefixStartToPrefixEnd(pathToKey);
        String[] strArr2 = new String[path.size() + 3];
        String n4 = AbstractC0008a.n(buildAncestorWhereClause(path, strArr2), " OR (path > ? AND path < ?)");
        strArr2[path.size() + 1] = pathToKey;
        strArr2[path.size() + 2] = pathPrefixStartToPrefixEnd;
        return this.database.query(SERVER_CACHE_TABLE, strArr, n4, strArr2, null, null, "path");
    }

    private SQLiteDatabase openDatabase(Context context, String str) {
        try {
            SQLiteDatabase writableDatabase = new PersistentCacheOpenHelper(context, str).getWritableDatabase();
            writableDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", null).close();
            writableDatabase.beginTransaction();
            writableDatabase.endTransaction();
            return writableDatabase;
        } catch (SQLiteException e4) {
            if (e4 instanceof SQLiteDatabaseLockedException) {
                throw new DatabaseException("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e4);
            }
            throw e4;
        }
    }

    private String partKey(Path path, int i) {
        return pathToKey(path) + String.format(Locale.US, PART_KEY_FORMAT, Integer.valueOf(i));
    }

    private static String pathPrefixStartToPrefixEnd(String str) {
        Utilities.hardAssert(str.endsWith(RemoteSettings.FORWARD_SLASH_STRING), "Path keys must end with a '/'");
        return str.substring(0, str.length() - 1) + '0';
    }

    private static String pathToKey(Path path) {
        if (path.isEmpty()) {
            return RemoteSettings.FORWARD_SLASH_STRING;
        }
        return path.toString() + RemoteSettings.FORWARD_SLASH_STRING;
    }

    private void pruneTreeRecursive(Path path, final Path path2, ImmutableTree<Long> immutableTree, final ImmutableTree<Long> immutableTree2, PruneForest pruneForest, final List<Pair<Path, Node>> list) {
        if (immutableTree.getValue() != null) {
            Integer num = (Integer) pruneForest.foldKeptNodes(0, new ImmutableTree.TreeVisitor<Void, Integer>() { // from class: com.google.firebase.database.android.SqlPersistenceStorageEngine.1
                @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
                public Integer onNodeValue(Path path3, Void r22, Integer num2) {
                    return Integer.valueOf(immutableTree2.get(path3) == null ? num2.intValue() + 1 : num2.intValue());
                }
            });
            if (num.intValue() > 0) {
                Path child = path.child(path2);
                if (this.logger.logsDebug()) {
                    this.logger.debug(String.format(Locale.US, "Need to rewrite %d nodes below path %s", num, child), new Object[0]);
                }
                final Node loadNested = loadNested(child);
                pruneForest.foldKeptNodes(null, new ImmutableTree.TreeVisitor<Void, Void>() { // from class: com.google.firebase.database.android.SqlPersistenceStorageEngine.2
                    @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
                    public Void onNodeValue(Path path3, Void r4, Void r5) {
                        if (immutableTree2.get(path3) != null) {
                            return null;
                        }
                        list.add(new Pair(path2.child(path3), loadNested.getChild(path3)));
                        return null;
                    }
                });
                return;
            }
            return;
        }
        Iterator<Map.Entry<ChildKey, ImmutableTree<Long>>> it = immutableTree.getChildren().iterator();
        while (it.hasNext()) {
            Map.Entry<ChildKey, ImmutableTree<Long>> next = it.next();
            ChildKey key = next.getKey();
            pruneTreeRecursive(path, path2.child(key), next.getValue(), immutableTree2.getChild(key), pruneForest.child(next.getKey()), list);
        }
    }

    private int removeNested(String str, Path path) {
        String pathToKey = pathToKey(path);
        return this.database.delete(str, "path >= ? AND path < ?", new String[]{pathToKey, pathPrefixStartToPrefixEnd(pathToKey)});
    }

    private int saveNested(Path path, Node node) {
        long estimateSerializedNodeSize = NodeSizeEstimator.estimateSerializedNodeSize(node);
        if ((node instanceof ChildrenNode) && estimateSerializedNodeSize > 16384) {
            int i = 0;
            if (this.logger.logsDebug()) {
                this.logger.debug(String.format(Locale.US, "Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", path, Long.valueOf(estimateSerializedNodeSize), Integer.valueOf(CHILDREN_NODE_SPLIT_SIZE_THRESHOLD)), new Object[0]);
            }
            for (NamedNode namedNode : node) {
                i += saveNested(path.child(namedNode.getName()), namedNode.getNode());
            }
            if (!node.getPriority().isEmpty()) {
                saveNode(path.child(ChildKey.getPriorityKey()), node.getPriority());
                i++;
            }
            saveNode(path, EmptyNode.Empty());
            return i + 1;
        }
        saveNode(path, node);
        return 1;
    }

    private void saveNode(Path path, Node node) {
        byte[] serializeObject = serializeObject(node.getValue(true));
        if (serializeObject.length >= ROW_SPLIT_SIZE) {
            List<byte[]> splitBytes = splitBytes(serializeObject, ROW_SPLIT_SIZE);
            if (this.logger.logsDebug()) {
                this.logger.debug("Saving huge leaf node with " + splitBytes.size() + " parts.", new Object[0]);
            }
            for (int i = 0; i < splitBytes.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("path", partKey(path, i));
                contentValues.put("value", splitBytes.get(i));
                this.database.insertWithOnConflict(SERVER_CACHE_TABLE, null, contentValues, 5);
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("path", pathToKey(path));
        contentValues2.put("value", serializeObject);
        this.database.insertWithOnConflict(SERVER_CACHE_TABLE, null, contentValues2, 5);
    }

    private void saveWrite(Path path, long j2, String str, byte[] bArr) {
        verifyInsideTransaction();
        this.database.delete(WRITES_TABLE, "id = ?", new String[]{String.valueOf(j2)});
        if (bArr.length >= ROW_SPLIT_SIZE) {
            List<byte[]> splitBytes = splitBytes(bArr, ROW_SPLIT_SIZE);
            for (int i = 0; i < splitBytes.size(); i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("id", Long.valueOf(j2));
                contentValues.put("path", pathToKey(path));
                contentValues.put("type", str);
                contentValues.put(WRITE_PART_COLUMN_NAME, Integer.valueOf(i));
                contentValues.put(WRITE_NODE_COLUMN_NAME, splitBytes.get(i));
                this.database.insertWithOnConflict(WRITES_TABLE, null, contentValues, 5);
            }
            return;
        }
        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("id", Long.valueOf(j2));
        contentValues2.put("path", pathToKey(path));
        contentValues2.put("type", str);
        contentValues2.put(WRITE_PART_COLUMN_NAME, (Integer) null);
        contentValues2.put(WRITE_NODE_COLUMN_NAME, bArr);
        this.database.insertWithOnConflict(WRITES_TABLE, null, contentValues2, 5);
    }

    private byte[] serializeObject(Object obj) {
        try {
            return JsonMapper.serializeJsonValue(obj).getBytes(UTF8_CHARSET);
        } catch (IOException e4) {
            throw new RuntimeException("Could not serialize leaf node", e4);
        }
    }

    private static List<byte[]> splitBytes(byte[] bArr, int i) {
        int length = ((bArr.length - 1) / i) + 1;
        ArrayList arrayList = new ArrayList(length);
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * i;
            int min = Math.min(i, bArr.length - i4);
            byte[] bArr2 = new byte[min];
            System.arraycopy(bArr, i4, bArr2, 0, min);
            arrayList.add(bArr2);
        }
        return arrayList;
    }

    private int splitNodeRunLength(Path path, List<String> list, int i) {
        int i3 = i + 1;
        String pathToKey = pathToKey(path);
        if (list.get(i).startsWith(pathToKey)) {
            while (i3 < list.size() && list.get(i3).equals(partKey(path, i3 - i))) {
                i3++;
            }
            if (i3 < list.size()) {
                if (list.get(i3).startsWith(pathToKey + PART_KEY_PREFIX)) {
                    throw new IllegalStateException("Run did not finish with all parts");
                }
            }
            return i3 - i;
        }
        throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
    }

    private void updateServerCache(Path path, Node node, boolean z3) {
        int i;
        int i3;
        long currentTimeMillis = System.currentTimeMillis();
        if (!z3) {
            i3 = removeNested(SERVER_CACHE_TABLE, path);
            i = saveNested(path, node);
        } else {
            int i4 = 0;
            int i5 = 0;
            for (NamedNode namedNode : node) {
                i5 += removeNested(SERVER_CACHE_TABLE, path.child(namedNode.getName()));
                i4 += saveNested(path.child(namedNode.getName()), namedNode.getNode());
            }
            i = i4;
            i3 = i5;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Persisted a total of " + i + " rows and deleted " + i3 + " rows for a set at " + path.toString() + " in " + currentTimeMillis2 + "ms", new Object[0]);
        }
    }

    private void verifyInsideTransaction() {
        Utilities.hardAssert(this.insideTransaction, "Transaction expected to already be in progress.");
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void beginTransaction() {
        Utilities.hardAssert(!this.insideTransaction, "runInTransaction called when an existing transaction is already in progress.");
        if (this.logger.logsDebug()) {
            this.logger.debug("Starting transaction.", new Object[0]);
        }
        this.database.beginTransaction();
        this.insideTransaction = true;
        this.transactionStart = System.currentTimeMillis();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void close() {
        this.database.close();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void deleteTrackedQuery(long j2) {
        verifyInsideTransaction();
        String valueOf = String.valueOf(j2);
        this.database.delete(TRACKED_QUERY_TABLE, "id = ?", new String[]{valueOf});
        this.database.delete(TRACKED_KEYS_TABLE, "id = ?", new String[]{valueOf});
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void endTransaction() {
        this.database.endTransaction();
        this.insideTransaction = false;
        long currentTimeMillis = System.currentTimeMillis() - this.transactionStart;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Transaction completed. Elapsed: " + currentTimeMillis + "ms", new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public List<TrackedQuery> loadTrackedQueries() {
        boolean z3;
        boolean z4;
        String[] strArr = {"id", "path", TRACKED_QUERY_PARAMS_COLUMN_NAME, TRACKED_QUERY_LAST_USE_COLUMN_NAME, TRACKED_QUERY_COMPLETE_COLUMN_NAME, TRACKED_QUERY_ACTIVE_COLUMN_NAME};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.database.query(TRACKED_QUERY_TABLE, strArr, null, null, null, null, "id");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                long j2 = query.getLong(0);
                try {
                    QuerySpec fromPathAndQueryObject = QuerySpec.fromPathAndQueryObject(new Path(query.getString(1)), JsonMapper.parseJson(query.getString(2)));
                    long j3 = query.getLong(3);
                    if (query.getInt(4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (query.getInt(5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    arrayList.add(new TrackedQuery(j2, fromPathAndQueryObject, j3, z3, z4));
                } catch (IOException e4) {
                    throw new RuntimeException(e4);
                }
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Loaded " + arrayList.size() + " tracked queries in " + currentTimeMillis2 + "ms", new Object[0]);
        }
        query.close();
        return arrayList;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public Set<ChildKey> loadTrackedQueryKeys(long j2) {
        return loadTrackedQueryKeys(Collections.singleton(Long.valueOf(j2)));
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public List<UserWriteRecord> loadUserWrites() {
        byte[] joinBytes;
        UserWriteRecord userWriteRecord;
        String[] strArr = {"id", "path", "type", WRITE_PART_COLUMN_NAME, WRITE_NODE_COLUMN_NAME};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.database.query(WRITES_TABLE, strArr, null, null, null, null, "id, part");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                try {
                    long j2 = query.getLong(0);
                    Path path = new Path(query.getString(1));
                    String string = query.getString(2);
                    if (query.isNull(3)) {
                        joinBytes = query.getBlob(4);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        do {
                            arrayList2.add(query.getBlob(4));
                            if (!query.moveToNext()) {
                                break;
                            }
                        } while (query.getLong(0) == j2);
                        query.moveToPrevious();
                        joinBytes = joinBytes(arrayList2);
                    }
                    Object parseJsonValue = JsonMapper.parseJsonValue(new String(joinBytes, UTF8_CHARSET));
                    if (WRITE_TYPE_OVERWRITE.equals(string)) {
                        userWriteRecord = new UserWriteRecord(j2, path, NodeUtilities.NodeFromJSON(parseJsonValue), true);
                    } else if (WRITE_TYPE_MERGE.equals(string)) {
                        userWriteRecord = new UserWriteRecord(j2, path, CompoundWrite.fromValue((Map) parseJsonValue));
                    } else {
                        throw new IllegalStateException("Got invalid write type: " + string);
                    }
                    arrayList.add(userWriteRecord);
                } catch (IOException e4) {
                    throw new RuntimeException("Failed to load writes", e4);
                }
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Loaded " + arrayList.size() + " writes in " + currentTimeMillis2 + "ms", new Object[0]);
        }
        query.close();
        return arrayList;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void mergeIntoServerCache(Path path, Node node) {
        verifyInsideTransaction();
        updateServerCache(path, node, true);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void overwriteServerCache(Path path, Node node) {
        verifyInsideTransaction();
        updateServerCache(path, node, false);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void pruneCache(Path path, PruneForest pruneForest) {
        SqlPersistenceStorageEngine sqlPersistenceStorageEngine;
        int i;
        int i3;
        if (pruneForest.prunesAnything()) {
            verifyInsideTransaction();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor loadNestedQuery = loadNestedQuery(path, new String[]{ROW_ID_COLUMN_NAME, "path"});
            ImmutableTree<Long> immutableTree = new ImmutableTree<>(null);
            ImmutableTree<Long> immutableTree2 = new ImmutableTree<>(null);
            while (loadNestedQuery.moveToNext()) {
                long j2 = loadNestedQuery.getLong(0);
                Path path2 = new Path(loadNestedQuery.getString(1));
                if (!path.contains(path2)) {
                    this.logger.warn("We are pruning at " + path + " but we have data stored higher up at " + path2 + ". Ignoring.");
                } else {
                    Path relative = Path.getRelative(path, path2);
                    if (pruneForest.shouldPruneUnkeptDescendants(relative)) {
                        immutableTree = immutableTree.set(relative, Long.valueOf(j2));
                    } else if (pruneForest.shouldKeep(relative)) {
                        immutableTree2 = immutableTree2.set(relative, Long.valueOf(j2));
                    } else {
                        this.logger.warn("We are pruning at " + path + " and have data at " + path2 + " that isn't marked for pruning or keeping. Ignoring.");
                    }
                }
            }
            if (!immutableTree.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                sqlPersistenceStorageEngine = this;
                sqlPersistenceStorageEngine.pruneTreeRecursive(path, Path.getEmptyPath(), immutableTree, immutableTree2, pruneForest, arrayList);
                Collection<Long> values = immutableTree.values();
                sqlPersistenceStorageEngine.database.delete(SERVER_CACHE_TABLE, AbstractC0008a.u(new StringBuilder("rowid IN ("), commaSeparatedList(values), ")"), null);
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj = arrayList.get(i4);
                    i4++;
                    Pair pair = (Pair) obj;
                    saveNested(path.child((Path) pair.getFirst()), (Node) pair.getSecond());
                }
                i = values.size();
                i3 = arrayList.size();
            } else {
                sqlPersistenceStorageEngine = this;
                i = 0;
                i3 = 0;
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (sqlPersistenceStorageEngine.logger.logsDebug()) {
                LogWrapper logWrapper = sqlPersistenceStorageEngine.logger;
                Locale locale = Locale.US;
                StringBuilder sb = new StringBuilder("Pruned ");
                sb.append(i);
                sb.append(" rows with ");
                sb.append(i3);
                sb.append(" nodes resaved in ");
                logWrapper.debug(e0.a.g(sb, currentTimeMillis2, "ms"), new Object[0]);
            }
        }
    }

    public void purgeCache() {
        verifyInsideTransaction();
        this.database.delete(SERVER_CACHE_TABLE, null, null);
        this.database.delete(WRITES_TABLE, null, null);
        this.database.delete(TRACKED_QUERY_TABLE, null, null);
        this.database.delete(TRACKED_KEYS_TABLE, null, null);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void removeAllUserWrites() {
        verifyInsideTransaction();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.database.delete(WRITES_TABLE, null, null);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Deleted " + delete + " (all) write(s) in " + currentTimeMillis2 + "ms", new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void removeUserWrite(long j2) {
        verifyInsideTransaction();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.database.delete(WRITES_TABLE, "id = ?", new String[]{String.valueOf(j2)});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Deleted " + delete + " write(s) with writeId " + j2 + " in " + currentTimeMillis2 + "ms", new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void resetPreviouslyActiveTrackedQueries(long j2) {
        verifyInsideTransaction();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TRACKED_QUERY_ACTIVE_COLUMN_NAME, Boolean.FALSE);
        contentValues.put(TRACKED_QUERY_LAST_USE_COLUMN_NAME, Long.valueOf(j2));
        this.database.updateWithOnConflict(TRACKED_QUERY_TABLE, contentValues, "active = 1", new String[0], 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Reset active tracked queries in " + currentTimeMillis2 + "ms", new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void saveTrackedQuery(TrackedQuery trackedQuery) {
        verifyInsideTransaction();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(trackedQuery.id));
        contentValues.put("path", pathToKey(trackedQuery.querySpec.getPath()));
        contentValues.put(TRACKED_QUERY_PARAMS_COLUMN_NAME, trackedQuery.querySpec.getParams().toJSON());
        contentValues.put(TRACKED_QUERY_LAST_USE_COLUMN_NAME, Long.valueOf(trackedQuery.lastUse));
        contentValues.put(TRACKED_QUERY_COMPLETE_COLUMN_NAME, Boolean.valueOf(trackedQuery.complete));
        contentValues.put(TRACKED_QUERY_ACTIVE_COLUMN_NAME, Boolean.valueOf(trackedQuery.active));
        this.database.insertWithOnConflict(TRACKED_QUERY_TABLE, null, contentValues, 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Saved new tracked query in " + currentTimeMillis2 + "ms", new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void saveTrackedQueryKeys(long j2, Set<ChildKey> set) {
        verifyInsideTransaction();
        long currentTimeMillis = System.currentTimeMillis();
        this.database.delete(TRACKED_KEYS_TABLE, "id = ?", new String[]{String.valueOf(j2)});
        for (ChildKey childKey : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j2));
            contentValues.put("key", childKey.asString());
            this.database.insertWithOnConflict(TRACKED_KEYS_TABLE, null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Set " + set.size() + " tracked query keys for tracked query " + j2 + " in " + currentTimeMillis2 + "ms", new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void saveUserMerge(Path path, CompoundWrite compoundWrite, long j2) {
        verifyInsideTransaction();
        long currentTimeMillis = System.currentTimeMillis();
        saveWrite(path, j2, WRITE_TYPE_MERGE, serializeObject(compoundWrite.getValue(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Persisted user merge in " + currentTimeMillis2 + "ms", new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void saveUserOverwrite(Path path, Node node, long j2) {
        verifyInsideTransaction();
        long currentTimeMillis = System.currentTimeMillis();
        saveWrite(path, j2, WRITE_TYPE_OVERWRITE, serializeObject(node.getValue(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Persisted user overwrite in " + currentTimeMillis2 + "ms", new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public Node serverCache(Path path) {
        return loadNested(path);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public long serverCacheEstimatedSizeInBytes() {
        Cursor rawQuery = this.database.rawQuery("SELECT sum(length(value) + length(path)) FROM serverCache", null);
        try {
            if (rawQuery.moveToFirst()) {
                return rawQuery.getLong(0);
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            rawQuery.close();
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void setTransactionSuccessful() {
        this.database.setTransactionSuccessful();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void updateTrackedQueryKeys(long j2, Set<ChildKey> set, Set<ChildKey> set2) {
        verifyInsideTransaction();
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(j2);
        Iterator<ChildKey> it = set2.iterator();
        while (it.hasNext()) {
            this.database.delete(TRACKED_KEYS_TABLE, "id = ? AND key = ?", new String[]{valueOf, it.next().asString()});
        }
        for (ChildKey childKey : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j2));
            contentValues.put("key", childKey.asString());
            this.database.insertWithOnConflict(TRACKED_KEYS_TABLE, null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Updated tracked query keys (" + set.size() + " added, " + set2.size() + " removed) for tracked query id " + j2 + " in " + currentTimeMillis2 + "ms", new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public Set<ChildKey> loadTrackedQueryKeys(Set<Long> set) {
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.database.query(true, TRACKED_KEYS_TABLE, new String[]{"key"}, AbstractC0008a.u(new StringBuilder("id IN ("), commaSeparatedList(set), ")"), null, null, null, null, null);
        HashSet hashSet = new HashSet();
        while (query.moveToNext()) {
            try {
                hashSet.add(ChildKey.fromString(query.getString(0)));
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Loaded " + hashSet.size() + " tracked queries keys for tracked queries " + set.toString() + " in " + currentTimeMillis2 + "ms", new Object[0]);
        }
        query.close();
        return hashSet;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void mergeIntoServerCache(Path path, CompoundWrite compoundWrite) {
        verifyInsideTransaction();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        int i = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Map.Entry<Path, Node> next = it.next();
            i += removeNested(SERVER_CACHE_TABLE, path.child(next.getKey()));
            i3 += saveNested(path.child(next.getKey()), next.getValue());
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            Locale locale = Locale.US;
            logWrapper.debug("Persisted a total of " + i3 + " rows and deleted " + i + " rows for a merge at " + path.toString() + " in " + currentTimeMillis2 + "ms", new Object[0]);
        }
    }
}
