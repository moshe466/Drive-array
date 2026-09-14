package com.google.firebase.firestore.local;

import android.database.sqlite.SQLiteStatement;
import com.google.firebase.firestore.local.MemoryIndexManager;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class SQLiteSchema$$Lambda$10 implements Consumer {
    private final MemoryIndexManager.MemoryCollectionParentIndex arg$1;
    private final SQLiteStatement arg$2;

    private SQLiteSchema$$Lambda$10(MemoryIndexManager.MemoryCollectionParentIndex memoryCollectionParentIndex, SQLiteStatement sQLiteStatement) {
        this.arg$1 = memoryCollectionParentIndex;
        this.arg$2 = sQLiteStatement;
    }

    public static Consumer lambdaFactory$(MemoryIndexManager.MemoryCollectionParentIndex memoryCollectionParentIndex, SQLiteStatement sQLiteStatement) {
        return new SQLiteSchema$$Lambda$10(memoryCollectionParentIndex, sQLiteStatement);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteSchema.a(this.arg$1, this.arg$2, (ResourcePath) obj);
    }
}
