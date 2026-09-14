package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.UnknownDocument;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public final class PatchMutation extends Mutation {
    private final FieldMask mask;
    private final ObjectValue value;

    public PatchMutation(DocumentKey documentKey, ObjectValue objectValue, FieldMask fieldMask, Precondition precondition) {
        super(documentKey, precondition);
        this.value = objectValue;
        this.mask = fieldMask;
    }

    private ObjectValue patchDocument(@Nullable MaybeDocument maybeDocument) {
        return patchObject(maybeDocument instanceof Document ? ((Document) maybeDocument).getData() : ObjectValue.emptyObject());
    }

    private ObjectValue patchObject(ObjectValue objectValue) {
        for (FieldPath fieldPath : this.mask.getMask()) {
            if (!fieldPath.isEmpty()) {
                FieldValue fieldValue = this.value.get(fieldPath);
                objectValue = fieldValue == null ? objectValue.delete(fieldPath) : objectValue.set(fieldPath, fieldValue);
            }
        }
        return objectValue;
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    @Nullable
    public MaybeDocument applyToLocalView(@Nullable MaybeDocument maybeDocument, @Nullable MaybeDocument maybeDocument2, Timestamp timestamp) {
        a(maybeDocument);
        if (!getPrecondition().isValidFor(maybeDocument)) {
            return maybeDocument;
        }
        return new Document(getKey(), Mutation.b(maybeDocument), Document.DocumentState.LOCAL_MUTATIONS, patchDocument(maybeDocument));
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public MaybeDocument applyToRemoteDocument(@Nullable MaybeDocument maybeDocument, MutationResult mutationResult) {
        a(maybeDocument);
        Assert.hardAssert(mutationResult.getTransformResults() == null, "Transform results received by PatchMutation.", new Object[0]);
        if (getPrecondition().isValidFor(maybeDocument)) {
            return new Document(getKey(), mutationResult.getVersion(), Document.DocumentState.COMMITTED_MUTATIONS, patchDocument(maybeDocument));
        }
        return new UnknownDocument(getKey(), mutationResult.getVersion());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PatchMutation.class != obj.getClass()) {
            return false;
        }
        PatchMutation patchMutation = (PatchMutation) obj;
        return a(patchMutation) && this.value.equals(patchMutation.value);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    @Nullable
    public ObjectValue extractBaseValue(@Nullable MaybeDocument maybeDocument) {
        return null;
    }

    public FieldMask getMask() {
        return this.mask;
    }

    public ObjectValue getValue() {
        return this.value;
    }

    public int hashCode() {
        return (a() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "PatchMutation{" + b() + ", mask=" + this.mask + ", value=" + this.value + "}";
    }
}
