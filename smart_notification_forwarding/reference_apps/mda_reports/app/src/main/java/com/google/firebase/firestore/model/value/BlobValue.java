package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.Blob;

/* loaded from: classes2.dex */
public class BlobValue extends FieldValue {
    private final Blob internalValue;

    private BlobValue(Blob blob) {
        this.internalValue = blob;
    }

    public static BlobValue valueOf(Blob blob) {
        return new BlobValue(blob);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.firebase.firestore.model.value.FieldValue, java.lang.Comparable
    public int compareTo(FieldValue fieldValue) {
        return fieldValue instanceof BlobValue ? this.internalValue.compareTo(((BlobValue) fieldValue).internalValue) : a(fieldValue);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public boolean equals(Object obj) {
        return (obj instanceof BlobValue) && this.internalValue.equals(((BlobValue) obj).internalValue);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int hashCode() {
        return this.internalValue.hashCode();
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int typeOrder() {
        return 5;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public Blob value() {
        return this.internalValue;
    }
}
