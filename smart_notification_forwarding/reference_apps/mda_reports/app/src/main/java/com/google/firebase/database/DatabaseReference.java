package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.PushIdGenerator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/* loaded from: classes2.dex */
public class DatabaseReference extends Query {
    private static DatabaseConfig defaultConfig;

    /* renamed from: com.google.firebase.database.DatabaseReference$5, reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass5 implements Runnable {
        final /* synthetic */ boolean a;
        final /* synthetic */ DatabaseReference b;

        @Override // java.lang.Runnable
        public void run() {
            this.b.a.setHijackHash(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public interface CompletionListener {
        void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DatabaseReference(Repo repo, Path path) {
        super(repo, path);
    }

    private DatabaseReference(ParsedUrl parsedUrl, DatabaseConfig databaseConfig) {
        this(RepoManager.getRepo(databaseConfig, parsedUrl.repoInfo), parsedUrl.path);
    }

    static void a(DatabaseConfig databaseConfig) {
        RepoManager.interrupt(databaseConfig);
    }

    static void b(DatabaseConfig databaseConfig) {
        RepoManager.resume(databaseConfig);
    }

    private static synchronized DatabaseConfig getDefaultConfig() {
        DatabaseConfig databaseConfig;
        synchronized (DatabaseReference.class) {
            if (defaultConfig == null) {
                defaultConfig = new DatabaseConfig();
            }
            databaseConfig = defaultConfig;
        }
        return databaseConfig;
    }

    public static void goOffline() {
        a(getDefaultConfig());
    }

    public static void goOnline() {
        b(getDefaultConfig());
    }

    private Task<Void> setPriorityInternal(final Node node, CompletionListener completionListener) {
        Validation.validateWritablePath(getPath());
        final Pair<Task<Void>, CompletionListener> wrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.a.scheduleNow(new Runnable() { // from class: com.google.firebase.database.DatabaseReference.2
            @Override // java.lang.Runnable
            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.a.setValue(databaseReference.getPath().child(ChildKey.getPriorityKey()), node, (CompletionListener) wrapOnComplete.getSecond());
            }
        });
        return wrapOnComplete.getFirst();
    }

    private Task<Void> setValueInternal(Object obj, Node node, CompletionListener completionListener) {
        Validation.validateWritablePath(getPath());
        ValidationPath.validateWithObject(getPath(), obj);
        Object convertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(obj);
        Validation.validateWritableObject(convertToPlainJavaTypes);
        final Node NodeFromJSON = NodeUtilities.NodeFromJSON(convertToPlainJavaTypes, node);
        final Pair<Task<Void>, CompletionListener> wrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.a.scheduleNow(new Runnable() { // from class: com.google.firebase.database.DatabaseReference.1
            @Override // java.lang.Runnable
            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.a.setValue(databaseReference.getPath(), NodeFromJSON, (CompletionListener) wrapOnComplete.getSecond());
            }
        });
        return wrapOnComplete.getFirst();
    }

    private Task<Void> updateChildrenInternal(Map<String, Object> map, CompletionListener completionListener) {
        if (map == null) {
            throw new NullPointerException("Can't pass null for argument 'update' in updateChildren()");
        }
        final Map<String, Object> convertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(map);
        final CompoundWrite fromPathMerge = CompoundWrite.fromPathMerge(Validation.parseAndValidateUpdate(getPath(), convertToPlainJavaTypes));
        final Pair<Task<Void>, CompletionListener> wrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.a.scheduleNow(new Runnable() { // from class: com.google.firebase.database.DatabaseReference.3
            @Override // java.lang.Runnable
            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.a.updateChildren(databaseReference.getPath(), fromPathMerge, (CompletionListener) wrapOnComplete.getSecond(), convertToPlainJavaTypes);
            }
        });
        return wrapOnComplete.getFirst();
    }

    @NonNull
    public DatabaseReference child(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in child()");
        }
        if (getPath().isEmpty()) {
            Validation.validateRootPathString(str);
        } else {
            Validation.validatePathString(str);
        }
        return new DatabaseReference(this.a, getPath().child(new Path(str)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof DatabaseReference) && toString().equals(obj.toString());
    }

    @NonNull
    public FirebaseDatabase getDatabase() {
        return this.a.getDatabase();
    }

    @Nullable
    public String getKey() {
        if (getPath().isEmpty()) {
            return null;
        }
        return getPath().getBack().asString();
    }

    @Nullable
    public DatabaseReference getParent() {
        Path parent = getPath().getParent();
        if (parent != null) {
            return new DatabaseReference(this.a, parent);
        }
        return null;
    }

    @NonNull
    public DatabaseReference getRoot() {
        return new DatabaseReference(this.a, new Path(""));
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @NonNull
    public OnDisconnect onDisconnect() {
        Validation.validateWritablePath(getPath());
        return new OnDisconnect(this.a, getPath());
    }

    @NonNull
    public DatabaseReference push() {
        return new DatabaseReference(this.a, getPath().child(ChildKey.fromString(PushIdGenerator.generatePushChildName(this.a.getServerTime()))));
    }

    @NonNull
    public Task<Void> removeValue() {
        return setValue(null);
    }

    public void removeValue(@Nullable CompletionListener completionListener) {
        setValue((Object) null, completionListener);
    }

    public void runTransaction(@NonNull Transaction.Handler handler) {
        runTransaction(handler, true);
    }

    public void runTransaction(@NonNull final Transaction.Handler handler, final boolean z) {
        if (handler == null) {
            throw new NullPointerException("Can't pass null for argument 'handler' in runTransaction()");
        }
        Validation.validateWritablePath(getPath());
        this.a.scheduleNow(new Runnable() { // from class: com.google.firebase.database.DatabaseReference.4
            @Override // java.lang.Runnable
            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.a.startTransaction(databaseReference.getPath(), handler, z);
            }
        });
    }

    @NonNull
    public Task<Void> setPriority(@Nullable Object obj) {
        return setPriorityInternal(PriorityUtilities.parsePriority(this.b, obj), null);
    }

    public void setPriority(@Nullable Object obj, @Nullable CompletionListener completionListener) {
        setPriorityInternal(PriorityUtilities.parsePriority(this.b, obj), completionListener);
    }

    @NonNull
    public Task<Void> setValue(@Nullable Object obj) {
        return setValueInternal(obj, PriorityUtilities.parsePriority(this.b, null), null);
    }

    @NonNull
    public Task<Void> setValue(@Nullable Object obj, @Nullable Object obj2) {
        return setValueInternal(obj, PriorityUtilities.parsePriority(this.b, obj2), null);
    }

    public void setValue(@Nullable Object obj, @Nullable CompletionListener completionListener) {
        setValueInternal(obj, PriorityUtilities.parsePriority(this.b, null), completionListener);
    }

    public void setValue(@Nullable Object obj, @Nullable Object obj2, @Nullable CompletionListener completionListener) {
        setValueInternal(obj, PriorityUtilities.parsePriority(this.b, obj2), completionListener);
    }

    public String toString() {
        DatabaseReference parent = getParent();
        if (parent == null) {
            return this.a.toString();
        }
        try {
            return parent.toString() + "/" + URLEncoder.encode(getKey(), HttpRequest.CHARSET_UTF8).replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new DatabaseException("Failed to URLEncode key: " + getKey(), e);
        }
    }

    @NonNull
    public Task<Void> updateChildren(@NonNull Map<String, Object> map) {
        return updateChildrenInternal(map, null);
    }

    public void updateChildren(@NonNull Map<String, Object> map, @Nullable CompletionListener completionListener) {
        updateChildrenInternal(map, completionListener);
    }
}
