package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.util.Util;

/* loaded from: classes2.dex */
public class BooleanValue extends FieldValue {
    private final boolean internalValue;
    private static final BooleanValue TRUE_VALUE = new BooleanValue(Boolean.TRUE);
    private static final BooleanValue FALSE_VALUE = new BooleanValue(Boolean.FALSE);

    private BooleanValue(Boolean bool) {
        this.internalValue = bool.booleanValue();
    }

    public static BooleanValue valueOf(Boolean bool) {
        return bool.booleanValue() ? TRUE_VALUE : FALSE_VALUE;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.firebase.firestore.model.value.FieldValue, java.lang.Comparable
    public int compareTo(FieldValue fieldValue) {
        return fieldValue instanceof BooleanValue ? Util.compareBooleans(this.internalValue, ((BooleanValue) fieldValue).internalValue) : a(fieldValue);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int hashCode() {
        return this.internalValue ? 1 : 0;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int typeOrder() {
        return 1;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public Boolean value() {
        return Boolean.valueOf(this.internalValue);
    }
}
