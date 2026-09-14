package com.google.firebase.firestore;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes2.dex */
final /* synthetic */ class Transaction$$Lambda$1 implements Continuation {
    private final Transaction arg$1;

    private Transaction$$Lambda$1(Transaction transaction) {
        this.arg$1 = transaction;
    }

    public static Continuation lambdaFactory$(Transaction transaction) {
        return new Transaction$$Lambda$1(transaction);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return Transaction.a(this.arg$1, task);
    }
}
