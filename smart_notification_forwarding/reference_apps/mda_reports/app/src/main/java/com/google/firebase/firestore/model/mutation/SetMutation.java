package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public final class SetMutation extends Mutation {
    private final ObjectValue value;

    public SetMutation(DocumentKey documentKey, ObjectValue objectValue, Precondition precondition) {
        super(documentKey, precondition);
        this.value = objectValue;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    @Nullable
    public MaybeDocument applyToLocalView(@Nullable MaybeDocument maybeDocument, @Nullable MaybeDocument maybeDocument2, Timestamp timestamp) {
        a(maybeDocument);
        if (!getPrecondition().isValidFor(maybeDocument)) {
            return maybeDocument;
        }
        return new Document(getKey(), Mutation.b(maybeDocument), Document.DocumentState.LOCAL_MUTATIONS, this.value);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public MaybeDocument applyToRemoteDocument(@Nullable MaybeDocument maybeDocument, MutationResult mutationResult) {
        a(maybeDocument);
        Assert.hardAssert(mutationResult.getTransformResults() == null, "Transform results received by SetMutation.", new Object[0]);
        return new Document(getKey(), mutationResult.getVersion(), Document.DocumentState.COMMITTED_MUTATIONS, this.value);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SetMutation.class != obj.getClass()) {
            return false;
        }
        SetMutation setMutation = (SetMutation) obj;
        return a(setMutation) && this.value.equals(setMutation.value);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    @Nullable
    public ObjectValue extractBaseValue(@Nullable MaybeDocument maybeDocument) {
        return null;
    }

    public ObjectValue getValue() {
        return this.value;
    }

    public int hashCode() {
        return (a() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "SetMutation{" + b() + ", value=" + this.value + "}";
    }
}
