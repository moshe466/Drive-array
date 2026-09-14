package com.google.firebase.firestore.local;

import com.google.firebase.firestore.local.MemoryIndexManager;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class SQLiteIndexManager implements IndexManager {
    private final MemoryIndexManager.MemoryCollectionParentIndex collectionParentsCache = new MemoryIndexManager.MemoryCollectionParentIndex();
    private final SQLitePersistence db;

    public SQLiteIndexManager(SQLitePersistence sQLitePersistence) {
        this.db = sQLitePersistence;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addToCollectionParentIndex(ResourcePath resourcePath) {
        Assert.hardAssert(resourcePath.length() % 2 == 1, "Expected a collection path.", new Object[0]);
        if (this.collectionParentsCache.a(resourcePath)) {
            this.db.a("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)", resourcePath.getLastSegment(), EncodedPath.a(resourcePath.popLast()));
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public List<ResourcePath> getCollectionParents(String str) {
        ArrayList arrayList = new ArrayList();
        this.db.b("SELECT parent FROM collection_parents WHERE collection_id = ?").a(str).b(SQLiteIndexManager$$Lambda$1.lambdaFactory$(arrayList));
        return arrayList;
    }
}
