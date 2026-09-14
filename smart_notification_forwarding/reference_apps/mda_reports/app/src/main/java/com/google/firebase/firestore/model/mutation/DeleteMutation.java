package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.NoDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public final class DeleteMutation extends Mutation {
    public DeleteMutation(DocumentKey documentKey, Precondition precondition) {
        super(documentKey, precondition);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    @Nullable
    public MaybeDocument applyToLocalView(@Nullable MaybeDocument maybeDocument, @Nullable MaybeDocument maybeDocument2, Timestamp timestamp) {
        a(maybeDocument);
        return !getPrecondition().isValidFor(maybeDocument) ? maybeDocument : new NoDocument(getKey(), SnapshotVersion.NONE, false);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public MaybeDocument applyToRemoteDocument(@Nullable MaybeDocument maybeDocument, MutationResult mutationResult) {
        a(maybeDocument);
        Assert.hardAssert(mutationResult.getTransformResults() == null, "Transform results received by DeleteMutation.", new Object[0]);
        return new NoDocument(getKey(), mutationResult.getVersion(), true);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DeleteMutation.class != obj.getClass()) {
            return false;
        }
        return a((DeleteMutation) obj);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    @Nullable
    public ObjectValue extractBaseValue(@Nullable MaybeDocument maybeDocument) {
        return null;
    }

    public int hashCode() {
        return a();
    }

    public String toString() {
        return "DeleteMutation{" + b() + "}";
    }
}
