package com.google.firebase.firestore.model;

/* loaded from: classes2.dex */
public abstract class MaybeDocument {
    private final DocumentKey key;
    private final SnapshotVersion version;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaybeDocument(DocumentKey documentKey, SnapshotVersion snapshotVersion) {
        this.key = documentKey;
        this.version = snapshotVersion;
    }

    public DocumentKey getKey() {
        return this.key;
    }

    public SnapshotVersion getVersion() {
        return this.version;
    }

    public abstract boolean hasPendingWrites();
}
