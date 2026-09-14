package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.common.base.Function;

/* loaded from: classes2.dex */
public final /* synthetic */ class SQLitePersistence$$Lambda$1 implements Function {
    private static final SQLitePersistence$$Lambda$1 instance = new SQLitePersistence$$Lambda$1();

    private SQLitePersistence$$Lambda$1() {
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
