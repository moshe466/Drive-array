package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Preconditions;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Util;

/* loaded from: classes2.dex */
public class CollectionReference extends Query {
    /* JADX INFO: Access modifiers changed from: package-private */
    public CollectionReference(ResourcePath resourcePath, FirebaseFirestore firebaseFirestore) {
        super(com.google.firebase.firestore.core.Query.atPath(resourcePath), firebaseFirestore);
        if (resourcePath.length() % 2 == 1) {
            return;
        }
        throw new IllegalArgumentException("Invalid collection reference. Collection references must have an odd number of segments, but " + resourcePath.canonicalString() + " has " + resourcePath.length());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ DocumentReference a(DocumentReference documentReference, Task task) {
        task.getResult();
        return documentReference;
    }

    @NonNull
    public Task<DocumentReference> add(@NonNull Object obj) {
        Preconditions.checkNotNull(obj, "Provided data must not be null.");
        DocumentReference document = document();
        return document.set(obj).continueWith(Executors.DIRECT_EXECUTOR, CollectionReference$$Lambda$1.lambdaFactory$(document));
    }

    @NonNull
    public DocumentReference document() {
        return document(Util.autoId());
    }

    @NonNull
    public DocumentReference document(@NonNull String str) {
        Preconditions.checkNotNull(str, "Provided document path must not be null.");
        return DocumentReference.a(this.a.getPath().append(ResourcePath.fromString(str)), this.b);
    }

    @NonNull
    public String getId() {
        return this.a.getPath().getLastSegment();
    }

    @Nullable
    public DocumentReference getParent() {
        ResourcePath popLast = this.a.getPath().popLast();
        if (popLast.isEmpty()) {
            return null;
        }
        return new DocumentReference(DocumentKey.fromPath(popLast), this.b);
    }

    @NonNull
    public String getPath() {
        return this.a.getPath().canonicalString();
    }
}
