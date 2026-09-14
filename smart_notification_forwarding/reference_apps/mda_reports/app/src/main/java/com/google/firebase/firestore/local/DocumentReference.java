package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Util;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class DocumentReference {
    static final Comparator<DocumentReference> a;
    static final Comparator<DocumentReference> b;
    private final DocumentKey key;
    private final int targetOrBatchId;

    static {
        Comparator<DocumentReference> comparator;
        Comparator<DocumentReference> comparator2;
        comparator = DocumentReference$$Lambda$1.instance;
        a = comparator;
        comparator2 = DocumentReference$$Lambda$2.instance;
        b = comparator2;
    }

    public DocumentReference(DocumentKey documentKey, int i) {
        this.key = documentKey;
        this.targetOrBatchId = i;
    }

    public static /* synthetic */ int a(DocumentReference documentReference, DocumentReference documentReference2) {
        int compareTo = documentReference.key.compareTo(documentReference2.key);
        return compareTo != 0 ? compareTo : Util.compareIntegers(documentReference.targetOrBatchId, documentReference2.targetOrBatchId);
    }

    public static /* synthetic */ int b(DocumentReference documentReference, DocumentReference documentReference2) {
        int compareIntegers = Util.compareIntegers(documentReference.targetOrBatchId, documentReference2.targetOrBatchId);
        return compareIntegers != 0 ? compareIntegers : documentReference.key.compareTo(documentReference2.key);
    }

    public int a() {
        return this.targetOrBatchId;
    }

    public DocumentKey b() {
        return this.key;
    }
}
