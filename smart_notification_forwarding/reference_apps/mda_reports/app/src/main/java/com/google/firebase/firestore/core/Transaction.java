package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.DeleteMutation;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class Transaction {
    private static final Executor defaultExecutor = createDefaultExecutor();
    private boolean committed;
    private final Datastore datastore;
    private FirebaseFirestoreException lastWriteError;
    private final HashMap<DocumentKey, SnapshotVersion> readVersions = new HashMap<>();
    private final ArrayList<Mutation> mutations = new ArrayList<>();
    private Set<DocumentKey> writtenDocs = new HashSet();

    public Transaction(Datastore datastore) {
        this.datastore = datastore;
    }

    public static /* synthetic */ Task a(Task task) {
        return task.isSuccessful() ? Tasks.forResult(null) : Tasks.forException(task.getException());
    }

    public static /* synthetic */ Task a(Transaction transaction, Task task) {
        if (task.isSuccessful()) {
            Iterator it = ((List) task.getResult()).iterator();
            while (it.hasNext()) {
                transaction.recordVersion((MaybeDocument) it.next());
            }
        }
        return task;
    }

    private static Executor createDefaultExecutor() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    private void ensureCommitNotCalled() {
        Assert.hardAssert(!this.committed, "A transaction object cannot be used after its update callback has been invoked.", new Object[0]);
    }

    public static Executor getDefaultExecutor() {
        return defaultExecutor;
    }

    private Precondition precondition(DocumentKey documentKey) {
        SnapshotVersion snapshotVersion = this.readVersions.get(documentKey);
        return (this.writtenDocs.contains(documentKey) || snapshotVersion == null) ? Precondition.NONE : Precondition.updateTime(snapshotVersion);
    }

    private Precondition preconditionForUpdate(DocumentKey documentKey) {
        SnapshotVersion snapshotVersion = this.readVersions.get(documentKey);
        if (this.writtenDocs.contains(documentKey) || snapshotVersion == null) {
            return Precondition.exists(true);
        }
        if (snapshotVersion == null || !snapshotVersion.equals(SnapshotVersion.NONE)) {
            return Precondition.updateTime(snapshotVersion);
        }
        throw new FirebaseFirestoreException("Can't update a document that doesn't exist.", FirebaseFirestoreException.Code.INVALID_ARGUMENT);
    }

    private void recordVersion(MaybeDocument maybeDocument) {
        SnapshotVersion snapshotVersion;
        if (maybeDocument instanceof Document) {
            snapshotVersion = maybeDocument.getVersion();
        } else {
            if (!(maybeDocument instanceof NoDocument)) {
                throw Assert.fail("Unexpected document type in transaction: " + maybeDocument.getClass().getCanonicalName(), new Object[0]);
            }
            snapshotVersion = SnapshotVersion.NONE;
        }
        if (!this.readVersions.containsKey(maybeDocument.getKey())) {
            this.readVersions.put(maybeDocument.getKey(), snapshotVersion);
        } else if (!this.readVersions.get(maybeDocument.getKey()).equals(maybeDocument.getVersion())) {
            throw new FirebaseFirestoreException("Document version changed between two reads.", FirebaseFirestoreException.Code.ABORTED);
        }
    }

    private void write(List<Mutation> list) {
        ensureCommitNotCalled();
        this.mutations.addAll(list);
    }

    public Task<Void> commit() {
        Continuation<List<MutationResult>, Task<TContinuationResult>> continuation;
        ensureCommitNotCalled();
        FirebaseFirestoreException firebaseFirestoreException = this.lastWriteError;
        if (firebaseFirestoreException != null) {
            return Tasks.forException(firebaseFirestoreException);
        }
        HashSet hashSet = new HashSet(this.readVersions.keySet());
        Iterator<Mutation> it = this.mutations.iterator();
        while (it.hasNext()) {
            hashSet.remove(it.next().getKey());
        }
        if (hashSet.size() > 0) {
            return Tasks.forException(new FirebaseFirestoreException("Every document read in a transaction must also be written.", FirebaseFirestoreException.Code.INVALID_ARGUMENT));
        }
        this.committed = true;
        Task<List<MutationResult>> commit = this.datastore.commit(this.mutations);
        Executor executor = Executors.DIRECT_EXECUTOR;
        continuation = Transaction$$Lambda$2.instance;
        return commit.continueWithTask(executor, continuation);
    }

    public void delete(DocumentKey documentKey) {
        write(Collections.singletonList(new DeleteMutation(documentKey, precondition(documentKey))));
        this.writtenDocs.add(documentKey);
    }

    public Task<List<MaybeDocument>> lookup(List<DocumentKey> list) {
        ensureCommitNotCalled();
        return this.mutations.size() != 0 ? Tasks.forException(new FirebaseFirestoreException("Firestore transactions require all reads to be executed before all writes.", FirebaseFirestoreException.Code.INVALID_ARGUMENT)) : this.datastore.lookup(list).continueWithTask(Executors.DIRECT_EXECUTOR, Transaction$$Lambda$1.lambdaFactory$(this));
    }

    public void set(DocumentKey documentKey, UserData.ParsedSetData parsedSetData) {
        write(parsedSetData.toMutationList(documentKey, precondition(documentKey)));
        this.writtenDocs.add(documentKey);
    }

    public void update(DocumentKey documentKey, UserData.ParsedUpdateData parsedUpdateData) {
        try {
            write(parsedUpdateData.toMutationList(documentKey, preconditionForUpdate(documentKey)));
        } catch (FirebaseFirestoreException e) {
            this.lastWriteError = e;
        }
        this.writtenDocs.add(documentKey);
    }
}
