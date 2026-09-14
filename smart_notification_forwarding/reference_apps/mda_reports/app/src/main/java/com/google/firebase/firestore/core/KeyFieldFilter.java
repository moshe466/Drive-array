package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.value.ReferenceValue;

/* loaded from: classes2.dex */
public class KeyFieldFilter extends FieldFilter {
    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyFieldFilter(FieldPath fieldPath, Filter.Operator operator, ReferenceValue referenceValue) {
        super(fieldPath, operator, referenceValue);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        return a(document.getKey().compareTo(((ReferenceValue) getValue()).value()));
    }
}
