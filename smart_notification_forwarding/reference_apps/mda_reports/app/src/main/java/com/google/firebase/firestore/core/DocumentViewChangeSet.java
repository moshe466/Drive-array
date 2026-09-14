package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class DocumentViewChangeSet {
    private final TreeMap<DocumentKey, DocumentViewChange> changes = new TreeMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<DocumentViewChange> a() {
        return new ArrayList(this.changes.values());
    }

    public void addChange(DocumentViewChange documentViewChange) {
        DocumentKey key = documentViewChange.getDocument().getKey();
        DocumentViewChange documentViewChange2 = this.changes.get(key);
        if (documentViewChange2 == null) {
            this.changes.put(key, documentViewChange);
            return;
        }
        DocumentViewChange.Type type = documentViewChange2.getType();
        DocumentViewChange.Type type2 = documentViewChange.getType();
        if (type2 == DocumentViewChange.Type.ADDED || type != DocumentViewChange.Type.METADATA) {
            if (type2 != DocumentViewChange.Type.METADATA || type == DocumentViewChange.Type.REMOVED) {
                DocumentViewChange.Type type3 = DocumentViewChange.Type.MODIFIED;
                if ((type2 == type3 && type == type3) || (type2 == DocumentViewChange.Type.MODIFIED && type == (type3 = DocumentViewChange.Type.ADDED))) {
                    documentViewChange = DocumentViewChange.create(type3, documentViewChange.getDocument());
                } else if (type2 == DocumentViewChange.Type.REMOVED && type == DocumentViewChange.Type.ADDED) {
                    this.changes.remove(key);
                    return;
                } else if (type2 == DocumentViewChange.Type.REMOVED && type == DocumentViewChange.Type.MODIFIED) {
                    documentViewChange = DocumentViewChange.create(DocumentViewChange.Type.REMOVED, documentViewChange2.getDocument());
                } else {
                    if (type2 != DocumentViewChange.Type.ADDED || type != DocumentViewChange.Type.REMOVED) {
                        throw Assert.fail("Unsupported combination of changes %s after %s", type2, type);
                    }
                    documentViewChange = DocumentViewChange.create(DocumentViewChange.Type.MODIFIED, documentViewChange.getDocument());
                }
            } else {
                documentViewChange = DocumentViewChange.create(type, documentViewChange.getDocument());
            }
        }
        this.changes.put(key, documentViewChange);
    }
}
