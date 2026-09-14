package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class Datastore$$Lambda$1 implements Continuation {
    private final Datastore arg$1;

    private Datastore$$Lambda$1(Datastore datastore) {
        this.arg$1 = datastore;
    }

    public static Continuation lambdaFactory$(Datastore datastore) {
        return new Datastore$$Lambda$1(datastore);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return Datastore.a(this.arg$1, task);
    }
}
