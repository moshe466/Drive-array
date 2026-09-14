package com.google.firebase.firestore.model.value;

import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class NullValue extends FieldValue {
    private static final NullValue INSTANCE = new NullValue();

    private NullValue() {
    }

    public static NullValue nullValue() {
        return INSTANCE;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.firebase.firestore.model.value.FieldValue, java.lang.Comparable
    public int compareTo(FieldValue fieldValue) {
        if (fieldValue instanceof NullValue) {
            return 0;
        }
        return a(fieldValue);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public boolean equals(Object obj) {
        return obj instanceof NullValue;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int hashCode() {
        return -1;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int typeOrder() {
        return 0;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    @Nullable
    public Object value() {
        return null;
    }
}
