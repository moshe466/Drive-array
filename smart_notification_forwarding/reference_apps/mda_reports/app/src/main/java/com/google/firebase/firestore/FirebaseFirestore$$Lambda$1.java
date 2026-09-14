package com.google.firebase.firestore;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.base.Function;
import com.google.firebase.firestore.Transaction;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final /* synthetic */ class FirebaseFirestore$$Lambda$1 implements Function {
    private final FirebaseFirestore arg$1;
    private final Executor arg$2;
    private final Transaction.Function arg$3;

    private FirebaseFirestore$$Lambda$1(FirebaseFirestore firebaseFirestore, Executor executor, Transaction.Function function) {
        this.arg$1 = firebaseFirestore;
        this.arg$2 = executor;
        this.arg$3 = function;
    }

    public static Function lambdaFactory$(FirebaseFirestore firebaseFirestore, Executor executor, Transaction.Function function) {
        return new FirebaseFirestore$$Lambda$1(firebaseFirestore, executor, function);
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        Task call;
        call = Tasks.call(this.arg$2, FirebaseFirestore$$Lambda$5.lambdaFactory$(this.arg$1, this.arg$3, (com.google.firebase.firestore.core.Transaction) obj));
        return call;
    }
}
