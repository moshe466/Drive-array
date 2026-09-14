package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class SQLiteMutationQueue$$Lambda$3 implements Consumer {
    private final SQLiteMutationQueue arg$1;

    private SQLiteMutationQueue$$Lambda$3(SQLiteMutationQueue sQLiteMutationQueue) {
        this.arg$1 = sQLiteMutationQueue;
    }

    public static Consumer lambdaFactory$(SQLiteMutationQueue sQLiteMutationQueue) {
        return new SQLiteMutationQueue$$Lambda$3(sQLiteMutationQueue);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteMutationQueue.b(this.arg$1, (Cursor) obj);
    }
}
