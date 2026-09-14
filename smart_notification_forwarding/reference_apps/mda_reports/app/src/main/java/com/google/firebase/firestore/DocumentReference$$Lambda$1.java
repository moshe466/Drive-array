package com.google.firebase.firestore;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* loaded from: classes2.dex */
public final /* synthetic */ class DocumentReference$$Lambda$1 implements Continuation {
    private final DocumentReference arg$1;

    private DocumentReference$$Lambda$1(DocumentReference documentReference) {
        this.arg$1 = documentReference;
    }

    public static Continuation lambdaFactory$(DocumentReference documentReference) {
        return new DocumentReference$$Lambda$1(documentReference);
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        return DocumentReference.a(this.arg$1, task);
    }
}
