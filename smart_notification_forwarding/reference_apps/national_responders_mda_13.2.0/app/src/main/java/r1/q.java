package r1;

import android.database.sqlite.SQLiteDatabase;
import r1.b0;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class q implements b0.d {

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f13700a;

    private q(SQLiteDatabase sQLiteDatabase) {
        this.f13700a = sQLiteDatabase;
    }

    public static b0.d b(SQLiteDatabase sQLiteDatabase) {
        return new q(sQLiteDatabase);
    }

    @Override // r1.b0.d
    public Object a() {
        return b0.a0(this.f13700a);
    }
}
