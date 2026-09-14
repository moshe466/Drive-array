package com.google.firebase.firestore;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes2.dex */
final /* synthetic */ class CollectionReference$$Lambda$1 implements Continuation {
    private final DocumentReference arg$1;

    private CollectionReference$$Lambda$1(DocumentReference documentReference) {
        this.arg$1 = documentReference;
    }

    public static Continuation lambdaFactory$(DocumentReference documentReference) {
        return new CollectionReference$$Lambda$1(documentReference);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        DocumentReference documentReference = this.arg$1;
        CollectionReference.a(documentReference, task);
        return documentReference;
    }
}
