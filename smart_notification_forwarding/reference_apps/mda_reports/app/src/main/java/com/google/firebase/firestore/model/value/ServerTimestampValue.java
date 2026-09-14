package com.google.firebase.firestore.model.value;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;

/* loaded from: classes2.dex */
public final class ServerTimestampValue extends FieldValue {
    private final Timestamp localWriteTime;

    @Nullable
    private final FieldValue previousValue;

    public ServerTimestampValue(Timestamp timestamp, @Nullable FieldValue fieldValue) {
        this.localWriteTime = timestamp;
        this.previousValue = fieldValue;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.firebase.firestore.model.value.FieldValue, java.lang.Comparable
    public int compareTo(FieldValue fieldValue) {
        if (fieldValue instanceof ServerTimestampValue) {
            return this.localWriteTime.compareTo(((ServerTimestampValue) fieldValue).localWriteTime);
        }
        if (fieldValue instanceof TimestampValue) {
            return 1;
        }
        return a(fieldValue);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public boolean equals(Object obj) {
        return (obj instanceof ServerTimestampValue) && this.localWriteTime.equals(((ServerTimestampValue) obj).localWriteTime);
    }

    public Timestamp getLocalWriteTime() {
        return this.localWriteTime;
    }

    @Nullable
    public Object getPreviousValue() {
        FieldValue fieldValue = this.previousValue;
        if (fieldValue instanceof ServerTimestampValue) {
            return ((ServerTimestampValue) fieldValue).getPreviousValue();
        }
        if (fieldValue != null) {
            return fieldValue.value();
        }
        return null;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int hashCode() {
        return this.localWriteTime.hashCode();
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public String toString() {
        return "<ServerTimestamp localTime=" + this.localWriteTime.toString() + ">";
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int typeOrder() {
        return 3;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    @Nullable
    public Object value() {
        return null;
    }
}
