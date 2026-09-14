package com.google.firebase.firestore.model.value;

import androidx.annotation.NonNull;
import com.google.firebase.Timestamp;

/* loaded from: classes2.dex */
public final class TimestampValue extends FieldValue {
    private final Timestamp internalValue;

    TimestampValue(Timestamp timestamp) {
        this.internalValue = timestamp;
    }

    public static TimestampValue valueOf(Timestamp timestamp) {
        return new TimestampValue(timestamp);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.firebase.firestore.model.value.FieldValue, java.lang.Comparable
    public int compareTo(FieldValue fieldValue) {
        if (fieldValue instanceof TimestampValue) {
            return this.internalValue.compareTo(((TimestampValue) fieldValue).internalValue);
        }
        if (fieldValue instanceof ServerTimestampValue) {
            return -1;
        }
        return a(fieldValue);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public boolean equals(Object obj) {
        return (obj instanceof TimestampValue) && this.internalValue.equals(((TimestampValue) obj).internalValue);
    }

    public Timestamp getInternalValue() {
        return this.internalValue;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int hashCode() {
        return this.internalValue.hashCode();
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public String toString() {
        return this.internalValue.toString();
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int typeOrder() {
        return 3;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    @NonNull
    public Timestamp value() {
        return this.internalValue;
    }
}
