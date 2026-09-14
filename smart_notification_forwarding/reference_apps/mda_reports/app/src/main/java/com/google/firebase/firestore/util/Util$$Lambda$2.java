package com.google.firebase.firestore.util;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes2.dex */
final /* synthetic */ class Util$$Lambda$2 implements Continuation {
    private static final Util$$Lambda$2 instance = new Util$$Lambda$2();

    private Util$$Lambda$2() {
    }

    public static Continuation lambdaFactory$() {
        return instance;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return Util.a(task);
    }
}
