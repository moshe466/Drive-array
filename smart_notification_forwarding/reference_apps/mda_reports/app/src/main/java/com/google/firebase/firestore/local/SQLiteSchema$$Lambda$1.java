package com.google.firebase.firestore.local;

/* loaded from: classes2.dex */
final /* synthetic */ class SQLiteSchema$$Lambda$1 implements Runnable {
    private final SQLiteSchema arg$1;

    private SQLiteSchema$$Lambda$1(SQLiteSchema sQLiteSchema) {
        this.arg$1 = sQLiteSchema;
    }

    public static Runnable lambdaFactory$(SQLiteSchema sQLiteSchema) {
        return new SQLiteSchema$$Lambda$1(sQLiteSchema);
    }

    @Override // java.lang.Runnable
    public void run() {
        SQLiteSchema.b(this.arg$1);
    }
}
