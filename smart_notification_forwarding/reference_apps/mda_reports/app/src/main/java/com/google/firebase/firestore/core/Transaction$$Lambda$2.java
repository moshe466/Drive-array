package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class Transaction$$Lambda$2 implements Continuation {
    private static final Transaction$$Lambda$2 instance = new Transaction$$Lambda$2();

    private Transaction$$Lambda$2() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return Transaction.a(task);
    }
}
