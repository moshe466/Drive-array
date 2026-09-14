package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ArrayValue;
import com.google.firebase.firestore.model.value.FieldValue;

/* loaded from: classes2.dex */
public class InFilter extends FieldFilter {
    /* JADX INFO: Access modifiers changed from: package-private */
    public InFilter(FieldPath fieldPath, ArrayValue arrayValue) {
        super(fieldPath, Filter.Operator.IN, arrayValue);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        ArrayValue arrayValue = (ArrayValue) getValue();
        FieldValue field = document.getField(getField());
        return field != null && arrayValue.getInternalValue().contains(field);
    }
}
