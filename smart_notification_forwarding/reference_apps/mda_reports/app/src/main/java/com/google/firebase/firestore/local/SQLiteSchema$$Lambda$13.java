package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class SQLiteSchema$$Lambda$13 implements Consumer {
    private final SQLiteSchema arg$1;
    private final String arg$2;

    private SQLiteSchema$$Lambda$13(SQLiteSchema sQLiteSchema, String str) {
        this.arg$1 = sQLiteSchema;
        this.arg$2 = str;
    }

    public static Consumer lambdaFactory$(SQLiteSchema sQLiteSchema, String str) {
        return new SQLiteSchema$$Lambda$13(sQLiteSchema, str);
    }

    @Override // com.google.firebase.firestore.util.Consumer
    public void accept(Object obj) {
        this.arg$1.removeMutationBatch(this.arg$2, ((Cursor) obj).getInt(0));
    }
}
