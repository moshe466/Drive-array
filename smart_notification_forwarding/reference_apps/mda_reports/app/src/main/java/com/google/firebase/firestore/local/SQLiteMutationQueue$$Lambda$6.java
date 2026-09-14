package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.common.base.Function;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteMutationQueue$$Lambda$6 implements Function {
    private static final SQLiteMutationQueue$$Lambda$6 instance = new SQLiteMutationQueue$$Lambda$6();

    private SQLiteMutationQueue$$Lambda$6() {
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return SQLiteMutationQueue.a((Cursor) obj);
    }
}
