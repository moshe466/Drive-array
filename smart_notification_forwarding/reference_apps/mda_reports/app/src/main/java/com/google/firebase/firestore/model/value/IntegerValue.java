package com.google.firebase.firestore.model.value;

/* loaded from: classes2.dex */
public final class IntegerValue extends NumberValue {
    private final long internalValue;

    private IntegerValue(Long l) {
        this.internalValue = l.longValue();
    }

    public static IntegerValue valueOf(Long l) {
        return new IntegerValue(l);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public boolean equals(Object obj) {
        return (obj instanceof IntegerValue) && this.internalValue == ((IntegerValue) obj).internalValue;
    }

    public long getInternalValue() {
        return this.internalValue;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int hashCode() {
        long j = this.internalValue;
        return (int) (j ^ (j >>> 32));
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public Long value() {
        return Long.valueOf(this.internalValue);
    }
}
