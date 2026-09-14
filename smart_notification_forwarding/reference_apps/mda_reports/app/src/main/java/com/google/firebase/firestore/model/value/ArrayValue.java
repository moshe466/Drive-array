package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ArrayValue extends FieldValue {
    private final List<FieldValue> internalValue;

    private ArrayValue(List<FieldValue> list) {
        this.internalValue = Collections.unmodifiableList(list);
    }

    public static ArrayValue fromList(List<FieldValue> list) {
        return new ArrayValue(list);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.firebase.firestore.model.value.FieldValue, java.lang.Comparable
    public int compareTo(FieldValue fieldValue) {
        if (!(fieldValue instanceof ArrayValue)) {
            return a(fieldValue);
        }
        ArrayValue arrayValue = (ArrayValue) fieldValue;
        int min = Math.min(this.internalValue.size(), arrayValue.internalValue.size());
        for (int i = 0; i < min; i++) {
            int compareTo = this.internalValue.get(i).compareTo(arrayValue.internalValue.get(i));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Util.compareIntegers(this.internalValue.size(), arrayValue.internalValue.size());
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public boolean equals(Object obj) {
        return (obj instanceof ArrayValue) && this.internalValue.equals(((ArrayValue) obj).internalValue);
    }

    public List<FieldValue> getInternalValue() {
        return this.internalValue;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int hashCode() {
        return this.internalValue.hashCode();
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public int typeOrder() {
        return 8;
    }

    @Override // com.google.firebase.firestore.model.value.FieldValue
    public List<Object> value() {
        ArrayList arrayList = new ArrayList(this.internalValue.size());
        Iterator<FieldValue> it = this.internalValue.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().value());
        }
        return arrayList;
    }
}
