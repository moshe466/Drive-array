package com.google.firebase.firestore.core;

/* loaded from: classes2.dex */
final /* synthetic */ class TransactionRunner$$Lambda$1 implements Runnable {
    private final TransactionRunner arg$1;

    private TransactionRunner$$Lambda$1(TransactionRunner transactionRunner) {
        this.arg$1 = transactionRunner;
    }

    public static Runnable lambdaFactory$(TransactionRunner transactionRunner) {
        return new TransactionRunner$$Lambda$1(transactionRunner);
    }

    @Override // java.lang.Runnable
    public void run() {
        TransactionRunner.a(this.arg$1);
    }
}
