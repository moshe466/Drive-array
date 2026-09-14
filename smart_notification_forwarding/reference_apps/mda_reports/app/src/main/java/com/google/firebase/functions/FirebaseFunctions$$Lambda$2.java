package com.google.firebase.functions;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes2.dex */
public final /* synthetic */ class FirebaseFunctions$$Lambda$2 implements Continuation {
    private final FirebaseFunctions arg$1;

    private FirebaseFunctions$$Lambda$2(FirebaseFunctions firebaseFunctions) {
        this.arg$1 = firebaseFunctions;
    }

    public static Continuation lambdaFactory$(FirebaseFunctions firebaseFunctions) {
        return new FirebaseFunctions$$Lambda$2(firebaseFunctions);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        Task context;
        context = this.arg$1.contextProvider.getContext();
        return context;
    }
}
