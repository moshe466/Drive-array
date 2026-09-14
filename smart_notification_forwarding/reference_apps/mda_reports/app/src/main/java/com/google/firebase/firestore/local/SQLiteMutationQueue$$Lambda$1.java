package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteMutationQueue$$Lambda$1 implements Consumer {
    private final SQLiteMutationQueue arg$1;

    private SQLiteMutationQueue$$Lambda$1(SQLiteMutationQueue sQLiteMutationQueue) {
        this.arg$1 = sQLiteMutationQueue;
    }

    public static Consumer lambdaFactory$(SQLiteMutationQueue sQLiteMutationQueue) {
        return new SQLiteMutationQueue$$Lambda$1(sQLiteMutationQueue);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteMutationQueue.c(this.arg$1, (Cursor) obj);
    }
}
