package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.value.ObjectValue;
import com.google.firebase.firestore.util.Assert;

/* loaded from: classes2.dex */
public abstract class Mutation {
    private final DocumentKey key;
    private final Precondition precondition;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mutation(DocumentKey documentKey, Precondition precondition) {
        this.key = documentKey;
        this.precondition = precondition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SnapshotVersion b(@Nullable MaybeDocument maybeDocument) {
        return maybeDocument instanceof Document ? maybeDocument.getVersion() : SnapshotVersion.NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return (getKey().hashCode() * 31) + this.precondition.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@Nullable MaybeDocument maybeDocument) {
        if (maybeDocument != null) {
            Assert.hardAssert(maybeDocument.getKey().equals(getKey()), "Can only apply a mutation to a document with the same key", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Mutation mutation) {
        return this.key.equals(mutation.key) && this.precondition.equals(mutation.precondition);
    }

    @Nullable
    public abstract MaybeDocument applyToLocalView(@Nullable MaybeDocument maybeDocument, @Nullable MaybeDocument maybeDocument2, Timestamp timestamp);

    public abstract MaybeDocument applyToRemoteDocument(@Nullable MaybeDocument maybeDocument, MutationResult mutationResult);

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return "key=" + this.key + ", precondition=" + this.precondition;
    }

    @Nullable
    public abstract ObjectValue extractBaseValue(@Nullable MaybeDocument maybeDocument);

    public DocumentKey getKey() {
        return this.key;
    }

    public Precondition getPrecondition() {
        return this.precondition;
    }
}
