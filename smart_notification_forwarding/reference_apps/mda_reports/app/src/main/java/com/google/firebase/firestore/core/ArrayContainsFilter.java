package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;

/* loaded from: classes2.dex */
public class ArrayContainsFilter extends FieldFilter {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayContainsFilter(FieldPath fieldPath, FieldValue fieldValue) {
        super(fieldPath, Filter.Operator.ARRAY_CONTAINS, fieldValue);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        FieldValue field = document.getField(getField());
        return (field instanceof ArrayValue) && ((ArrayValue) field).getInternalValue().contains(getValue());
    }
}
