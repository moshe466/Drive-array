package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;

/* loaded from: classes2.dex */
public abstract class NumberValue extends FieldValue {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.firebase.firestore.model.value.FieldValue, java.lang.Comparable
    public int compareTo(FieldValue fieldValue) {
        if (!(fieldValue instanceof NumberValue)) {
            return a(fieldValue);
        }
        if (this instanceof DoubleValue) {
            double internalValue = ((DoubleValue) this).getInternalValue();
            if (fieldValue instanceof DoubleValue) {
                return Util.compareDoubles(internalValue, ((DoubleValue) fieldValue).getInternalValue());
            }
            Assert.hardAssert(fieldValue instanceof IntegerValue, "Unknown NumberValue: %s", fieldValue);
            return Util.compareMixed(internalValue, ((IntegerValue) fieldValue).getInternalValue());
        }
        Assert.hardAssert(this instanceof IntegerValue, "Unknown NumberValue: %s", this);
        long internalValue2 = ((IntegerValue) this).getInternalValue();
        if (fieldValue instanceof IntegerValue) {
            return Util.compareLongs(internalValue2, ((IntegerValue) fieldValue).getInternalValue());
        }
        Assert.hardAssert(fieldValue instanceof DoubleValue, "Unknown NumberValue: %s", fieldValue);
        return Util.compareMixed(((DoubleValue) fieldValue).getInternalValue(), internalValue2) * (-1);
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int typeOrder() {
        return 2;
    }
}
