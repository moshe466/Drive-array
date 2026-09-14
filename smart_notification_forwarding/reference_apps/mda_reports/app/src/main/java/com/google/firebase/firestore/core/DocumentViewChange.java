package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;

/* loaded from: classes2.dex */
public class DocumentViewChange {
    private final Document document;
    private final Type type;

    /* loaded from: classes2.dex */
    public enum Type {
        REMOVED,
        ADDED,
        MODIFIED,
        METADATA
    }

    private DocumentViewChange(Type type, Document document) {
        this.type = type;
        this.document = document;
    }

    public static DocumentViewChange create(Type type, Document document) {
        return new DocumentViewChange(type, document);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DocumentViewChange)) {
            return false;
        }
        DocumentViewChange documentViewChange = (DocumentViewChange) obj;
        return this.type.equals(documentViewChange.type) && this.document.equals(documentViewChange.document);
    }

    public Document getDocument() {
        return this.document;
    }

    public Type getType() {
        return this.type;
    }

    public int hashCode() {
        return ((1891 + this.type.hashCode()) * 31) + this.document.hashCode();
    }

    public String toString() {
        return "DocumentViewChange(" + this.document + "," + this.type + ")";
    }
}
