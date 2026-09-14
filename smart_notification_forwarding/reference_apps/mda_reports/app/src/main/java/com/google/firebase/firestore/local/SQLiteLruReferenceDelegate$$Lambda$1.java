package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.common.base.Function;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteLruReferenceDelegate$$Lambda$1 implements Function {
    private static final SQLiteLruReferenceDelegate$$Lambda$1 instance = new SQLiteLruReferenceDelegate$$Lambda$1();

    private SQLiteLruReferenceDelegate$$Lambda$1() {
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        return SQLiteLruReferenceDelegate.a((Cursor) obj);
    }
}
