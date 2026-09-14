package com.google.firebase.firestore.model.value;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;

/* loaded from: classes2.dex */
public abstract class FieldValue implements Comparable<FieldValue> {
    /* JADX INFO: Access modifiers changed from: protected */
    public int a(FieldValue fieldValue) {
        int compareIntegers = Util.compareIntegers(typeOrder(), fieldValue.typeOrder());
        Assert.hardAssert(compareIntegers != 0, "Default compareTo should not be used for values of same type.", new Object[0]);
        return compareIntegers;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Comparable
    public abstract int compareTo(@NonNull FieldValue fieldValue);

    public abstract boolean equals(Object obj);

    public abstract int hashCode();

    public String toString() {
        Object value = value();
        return value == null ? "null" : value.toString();
    }

    public abstract int typeOrder();

    @Nullable
    public abstract Object value();
}
