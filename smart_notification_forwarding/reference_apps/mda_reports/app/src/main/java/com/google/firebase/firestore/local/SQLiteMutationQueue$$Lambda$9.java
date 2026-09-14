package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteMutationQueue$$Lambda$9 implements Consumer {
    private final SQLiteMutationQueue arg$1;
    private final Set arg$2;
    private final List arg$3;

    private SQLiteMutationQueue$$Lambda$9(SQLiteMutationQueue sQLiteMutationQueue, Set set, List list) {
        this.arg$1 = sQLiteMutationQueue;
        this.arg$2 = set;
        this.arg$3 = list;
    }

    public static Consumer lambdaFactory$(SQLiteMutationQueue sQLiteMutationQueue, Set set, List list) {
        return new SQLiteMutationQueue$$Lambda$9(sQLiteMutationQueue, set, list);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteMutationQueue.a(this.arg$1, this.arg$2, this.arg$3, (Cursor) obj);
    }
}
