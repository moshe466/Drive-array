package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class ArrayContainsAnyFilter extends FieldFilter {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayContainsAnyFilter(FieldPath fieldPath, FieldValue fieldValue) {
        super(fieldPath, Filter.Operator.ARRAY_CONTAINS_ANY, fieldValue);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        ArrayValue arrayValue = (ArrayValue) getValue();
        FieldValue field = document.getField(getField());
        if (!(field instanceof ArrayValue)) {
            return false;
        }
        Iterator<FieldValue> it = ((ArrayValue) field).getInternalValue().iterator();
        while (it.hasNext()) {
            if (arrayValue.getInternalValue().contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}
