package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.UnknownDocument;
import com.google.firebase.firestore.model.value.FieldValue;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class TransformMutation extends Mutation {
    private final List<FieldTransform> fieldTransforms;

    public TransformMutation(DocumentKey documentKey, List<FieldTransform> list) {
        super(documentKey, Precondition.exists(true));
        this.fieldTransforms = list;
    }

    private List<FieldValue> localTransformResults(Timestamp timestamp, @Nullable MaybeDocument maybeDocument, @Nullable MaybeDocument maybeDocument2) {
        ArrayList arrayList = new ArrayList(this.fieldTransforms.size());
        for (FieldTransform fieldTransform : this.fieldTransforms) {
            TransformOperation operation = fieldTransform.getOperation();
            FieldValue field = maybeDocument instanceof Document ? ((Document) maybeDocument).getField(fieldTransform.getFieldPath()) : null;
            if (field == null && (maybeDocument2 instanceof Document)) {
                field = ((Document) maybeDocument2).getField(fieldTransform.getFieldPath());
            }
            arrayList.add(operation.applyToLocalView(field, timestamp));
        }
        return arrayList;
    }

    private Document requireDocument(@Nullable MaybeDocument maybeDocument) {
        Assert.hardAssert(maybeDocument instanceof Document, "Unknown MaybeDocument type %s", maybeDocument);
        Document document = (Document) maybeDocument;
        Assert.hardAssert(document.getKey().equals(getKey()), "Can only transform a document with the same key", new Object[0]);
        return document;
    }

    private List<FieldValue> serverTransformResults(@Nullable MaybeDocument maybeDocument, List<FieldValue> list) {
        ArrayList arrayList = new ArrayList(this.fieldTransforms.size());
        Assert.hardAssert(this.fieldTransforms.size() == list.size(), "server transform count (%d) should match field transform count (%d)", Integer.valueOf(list.size()), Integer.valueOf(this.fieldTransforms.size()));
        for (int i = 0; i < list.size(); i++) {
            FieldTransform fieldTransform = this.fieldTransforms.get(i);
            TransformOperation operation = fieldTransform.getOperation();
            FieldValue fieldValue = null;
            if (maybeDocument instanceof Document) {
                fieldValue = ((Document) maybeDocument).getField(fieldTransform.getFieldPath());
            }
            arrayList.add(operation.applyToRemoteDocument(fieldValue, list.get(i)));
        }
        return arrayList;
    }

    private ObjectValue transformObject(ObjectValue objectValue, List<FieldValue> list) {
        Assert.hardAssert(list.size() == this.fieldTransforms.size(), "Transform results length mismatch.", new Object[0]);
        for (int i = 0; i < this.fieldTransforms.size(); i++) {
            objectValue = objectValue.set(this.fieldTransforms.get(i).getFieldPath(), list.get(i));
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
        Document requireDocument = requireDocument(maybeDocument);
        return new Document(getKey(), requireDocument.getVersion(), Document.DocumentState.LOCAL_MUTATIONS, transformObject(requireDocument.getData(), localTransformResults(timestamp, maybeDocument, maybeDocument2)));
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    public MaybeDocument applyToRemoteDocument(@Nullable MaybeDocument maybeDocument, MutationResult mutationResult) {
        a(maybeDocument);
        Assert.hardAssert(mutationResult.getTransformResults() != null, "Transform results missing for TransformMutation.", new Object[0]);
        if (!getPrecondition().isValidFor(maybeDocument)) {
            return new UnknownDocument(getKey(), mutationResult.getVersion());
        }
        Document requireDocument = requireDocument(maybeDocument);
        return new Document(getKey(), mutationResult.getVersion(), Document.DocumentState.COMMITTED_MUTATIONS, transformObject(requireDocument.getData(), serverTransformResults(requireDocument, mutationResult.getTransformResults())));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TransformMutation.class != obj.getClass()) {
            return false;
        }
        TransformMutation transformMutation = (TransformMutation) obj;
        return a(transformMutation) && this.fieldTransforms.equals(transformMutation.fieldTransforms);
    }

    @Override // com.google.firebase.firestore.model.mutation.Mutation
    @Nullable
    public ObjectValue extractBaseValue(@Nullable MaybeDocument maybeDocument) {
        ObjectValue objectValue = null;
        for (FieldTransform fieldTransform : this.fieldTransforms) {
            FieldValue computeBaseValue = fieldTransform.getOperation().computeBaseValue(maybeDocument instanceof Document ? ((Document) maybeDocument).getField(fieldTransform.getFieldPath()) : null);
            if (computeBaseValue != null) {
                if (objectValue == null) {
                    objectValue = ObjectValue.emptyObject();
                }
                objectValue = objectValue.set(fieldTransform.getFieldPath(), computeBaseValue);
            }
        }
        return objectValue;
    }

    public List<FieldTransform> getFieldTransforms() {
        return this.fieldTransforms;
    }

    public int hashCode() {
        return (a() * 31) + this.fieldTransforms.hashCode();
    }

    public String toString() {
        return "TransformMutation{" + b() + ", fieldTransforms=" + this.fieldTransforms + "}";
    }
}
