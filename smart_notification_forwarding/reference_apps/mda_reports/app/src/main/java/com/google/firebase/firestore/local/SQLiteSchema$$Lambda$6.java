package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class SQLiteSchema$$Lambda$6 implements Consumer {
    private final SQLiteSchema arg$1;

    private SQLiteSchema$$Lambda$6(SQLiteSchema sQLiteSchema) {
        this.arg$1 = sQLiteSchema;
    }

    public static Consumer lambdaFactory$(SQLiteSchema sQLiteSchema) {
        return new SQLiteSchema$$Lambda$6(sQLiteSchema);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        SQLiteSchema.a(this.arg$1, (Cursor) obj);
    }
}
