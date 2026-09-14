package com.google.firebase.firestore.model;

/* loaded from: classes2.dex */
public final class NoDocument extends MaybeDocument {
    private boolean hasCommittedMutations;

    public NoDocument(DocumentKey documentKey, SnapshotVersion snapshotVersion, boolean z) {
        super(documentKey, snapshotVersion);
        this.hasCommittedMutations = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NoDocument.class != obj.getClass()) {
            return false;
        }
        NoDocument noDocument = (NoDocument) obj;
        return this.hasCommittedMutations == noDocument.hasCommittedMutations && getVersion().equals(noDocument.getVersion()) && getKey().equals(noDocument.getKey());
    }

    public boolean hasCommittedMutations() {
        return this.hasCommittedMutations;
    }

    @Override // com.google.firebase.firestore.model.MaybeDocument
    public boolean hasPendingWrites() {
        return hasCommittedMutations();
    }

    public int hashCode() {
        return (((getKey().hashCode() * 31) + (this.hasCommittedMutations ? 1 : 0)) * 31) + getVersion().hashCode();
    }

    public String toString() {
        return "NoDocument{key=" + getKey() + ", version=" + getVersion() + ", hasCommittedMutations=" + hasCommittedMutations() + "}";
    }
}
