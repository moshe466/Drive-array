package com.google.firebase.firestore.model.value;

/* loaded from: classes2.dex */
public final class DoubleValue extends NumberValue {
    public static final DoubleValue NaN = new DoubleValue(Double.valueOf(Double.NaN));
    private final double internalValue;

    private DoubleValue(Double d) {
        this.internalValue = d.doubleValue();
    }

    public static DoubleValue valueOf(Double d) {
        return Double.isNaN(d.doubleValue()) ? NaN : new DoubleValue(d);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public boolean equals(Object obj) {
        return (obj instanceof DoubleValue) && Double.doubleToLongBits(this.internalValue) == Double.doubleToLongBits(((DoubleValue) obj).internalValue);
    }

    public double getInternalValue() {
        return this.internalValue;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.internalValue);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public Double value() {
        return Double.valueOf(this.internalValue);
    }
}
