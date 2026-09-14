package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public interface QueryCache {
    void addMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i);

    void addQueryData(QueryData queryData);

    boolean containsKey(DocumentKey documentKey);

    void forEachTarget(Consumer<QueryData> consumer);

    long getHighestListenSequenceNumber();

    int getHighestTargetId();

    SnapshotVersion getLastRemoteSnapshotVersion();

    ImmutableSortedSet<DocumentKey> getMatchingKeysForTargetId(int i);

    @Nullable
    QueryData getQueryData(Target target);

    long getTargetCount();

    void removeMatchingKeys(ImmutableSortedSet<DocumentKey> immutableSortedSet, int i);

    void removeQueryData(QueryData queryData);

    void setLastRemoteSnapshotVersion(SnapshotVersion snapshotVersion);

    void updateQueryData(QueryData queryData);
}
