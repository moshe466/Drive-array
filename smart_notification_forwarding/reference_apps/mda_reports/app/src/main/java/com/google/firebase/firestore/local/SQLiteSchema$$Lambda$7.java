package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.common.base.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class SQLiteSchema$$Lambda$7 implements Function {
    private static final SQLiteSchema$$Lambda$7 instance = new SQLiteSchema$$Lambda$7();

    private SQLiteSchema$$Lambda$7() {
    }

    public static Function lambdaFactory$() {
        return instance;
    }

    @Override // com.google.common.base.Function
    public Object apply(Object obj) {
        Long valueOf;
        valueOf = Long.valueOf(((Cursor) obj).getLong(0));
        return valueOf;
    }
}
