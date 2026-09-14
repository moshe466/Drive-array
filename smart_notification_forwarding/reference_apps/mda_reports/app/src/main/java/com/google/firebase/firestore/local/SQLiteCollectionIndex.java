package com.google.firebase.firestore.local;

import com.google.firebase.firestore.core.IndexRange;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.value.FieldValue;

/* loaded from: classes2.dex */
public class SQLiteCollectionIndex {
    private final SQLitePersistence db;
    private final String uid;

    public void addEntry(FieldPath fieldPath, FieldValue fieldValue, DocumentKey documentKey) {
        throw new RuntimeException("Not yet implemented.");
    }

    public IndexCursor getCursor(ResourcePath resourcePath, IndexRange indexRange) {
        throw new RuntimeException("Not yet implemented.");
    }

    public void removeEntry(FieldPath fieldPath, FieldValue fieldValue, DocumentKey documentKey) {
        throw new RuntimeException("Not yet implemented.");
    }
}
