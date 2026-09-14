package com.google.firebase.firestore.local;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteSchema$$Lambda$9 implements Runnable {
    private final SQLiteSchema arg$1;

    private SQLiteSchema$$Lambda$9(SQLiteSchema sQLiteSchema) {
        this.arg$1 = sQLiteSchema;
    }

    public static Runnable lambdaFactory$(SQLiteSchema sQLiteSchema) {
        return new SQLiteSchema$$Lambda$9(sQLiteSchema);
    }

    @Override // java.lang.Runnable
    public void run() {
        SQLiteSchema.e(this.arg$1);
    }
}
