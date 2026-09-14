package com.google.firebase.firestore.model;

/* loaded from: classes2.dex */
public final class UnknownDocument extends MaybeDocument {
    public UnknownDocument(DocumentKey documentKey, SnapshotVersion snapshotVersion) {
        super(documentKey, snapshotVersion);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || UnknownDocument.class != obj.getClass()) {
            return false;
        }
        UnknownDocument unknownDocument = (UnknownDocument) obj;
        return getVersion().equals(unknownDocument.getVersion()) && getKey().equals(unknownDocument.getKey());
    }

    @Override // com.google.firebase.firestore.model.MaybeDocument
    public boolean hasPendingWrites() {
        return true;
    }

    public int hashCode() {
        return (getKey().hashCode() * 31) + getVersion().hashCode();
    }

    public String toString() {
        return "UnknownDocument{key=" + getKey() + ", version=" + getVersion() + '}';
    }
}
