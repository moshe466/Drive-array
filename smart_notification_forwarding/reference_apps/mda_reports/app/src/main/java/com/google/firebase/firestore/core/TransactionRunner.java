package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.common.base.Function;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.ExponentialBackoff;

/* loaded from: classes2.dex */
public class TransactionRunner<TResult> {
    private static final int RETRY_COUNT = 5;
    private AsyncQueue asyncQueue;
    private ExponentialBackoff backoff;
    private RemoteStore remoteStore;
    private Function<Transaction, Task<TResult>> updateFunction;
    private TaskCompletionSource<TResult> taskSource = new TaskCompletionSource<>();
    private int retriesLeft = 5;

    public TransactionRunner(AsyncQueue asyncQueue, RemoteStore remoteStore, Function<Transaction, Task<TResult>> function) {
        this.asyncQueue = asyncQueue;
        this.remoteStore = remoteStore;
        this.updateFunction = function;
        this.backoff = new ExponentialBackoff(asyncQueue, AsyncQueue.TimerId.RETRY_TRANSACTION);
    }

    public static /* synthetic */ void a(TransactionRunner transactionRunner) {
        Transaction createTransaction = transactionRunner.remoteStore.createTransaction();
        transactionRunner.updateFunction.apply(createTransaction).addOnCompleteListener(transactionRunner.asyncQueue.getExecutor(), TransactionRunner$$Lambda$2.lambdaFactory$(transactionRunner, createTransaction));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(TransactionRunner transactionRunner, Task task, Task task2) {
        if (task2.isSuccessful()) {
            transactionRunner.taskSource.setResult(task.getResult());
        } else {
            transactionRunner.handleTransactionError(task2);
        }
    }

    public static /* synthetic */ void a(TransactionRunner transactionRunner, Transaction transaction, Task task) {
        if (task.isSuccessful()) {
            transaction.commit().addOnCompleteListener(transactionRunner.asyncQueue.getExecutor(), TransactionRunner$$Lambda$3.lambdaFactory$(transactionRunner, task));
        } else {
            transactionRunner.handleTransactionError(task);
        }
    }

    private void handleTransactionError(Task task) {
        if (this.retriesLeft <= 0 || !isRetryableTransactionError(task.getException())) {
            this.taskSource.setException(task.getException());
        } else {
            this.retriesLeft--;
            runWithBackoff();
        }
    }

    private static boolean isRetryableTransactionError(Exception exc) {
        if (!(exc instanceof FirebaseFirestoreException)) {
            return false;
        }
        FirebaseFirestoreException firebaseFirestoreException = (FirebaseFirestoreException) exc;
        FirebaseFirestoreException.Code code = firebaseFirestoreException.getCode();
        return code == FirebaseFirestoreException.Code.ABORTED || code == FirebaseFirestoreException.Code.FAILED_PRECONDITION || !Datastore.isPermanentError(firebaseFirestoreException.getCode());
    }

    private void runWithBackoff() {
        this.backoff.backoffAndRun(TransactionRunner$$Lambda$1.lambdaFactory$(this));
    }

    public Task<TResult> run() {
        runWithBackoff();
        return this.taskSource.getTask();
    }
}
