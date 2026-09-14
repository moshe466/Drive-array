package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.common.base.Function;
import com.google.firebase.firestore.model.mutation.MutationBatch;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteMutationQueue$$Lambda$5 implements Function {
    private final SQLiteMutationQueue arg$1;

    private SQLiteMutationQueue$$Lambda$5(SQLiteMutationQueue sQLiteMutationQueue) {
        this.arg$1 = sQLiteMutationQueue;
    }

    public static Function lambdaFactory$(SQLiteMutationQueue sQLiteMutationQueue) {
        return new SQLiteMutationQueue$$Lambda$5(sQLiteMutationQueue);
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        MutationBatch decodeInlineMutationBatch;
        decodeInlineMutationBatch = this.arg$1.decodeInlineMutationBatch(r2.getInt(0), ((Cursor) obj).getBlob(1));
        return decodeInlineMutationBatch;
    }
}
