package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* loaded from: classes2.dex */
public final /* synthetic */ class TransactionRunner$$Lambda$2 implements OnCompleteListener {
    private final TransactionRunner arg$1;
    private final Transaction arg$2;

    private TransactionRunner$$Lambda$2(TransactionRunner transactionRunner, Transaction transaction) {
        this.arg$1 = transactionRunner;
        this.arg$2 = transaction;
    }

    public static OnCompleteListener lambdaFactory$(TransactionRunner transactionRunner, Transaction transaction) {
        return new TransactionRunner$$Lambda$2(transactionRunner, transaction);
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        TransactionRunner.a(this.arg$1, this.arg$2, task);
    }
}
