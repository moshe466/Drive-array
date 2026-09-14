package r1;

import android.database.sqlite.SQLiteDatabase;
import r1.b0;

/* loaded from: classes.dex */
final /* synthetic */ class k implements b0.b {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f13691a;

    /* renamed from: b, reason: collision with root package name */
    private final k1.m f13692b;

    private k(b0 b0Var, k1.m mVar) {
        this.f13691a = b0Var;
        this.f13692b = mVar;
    }

    public static b0.b a(b0 b0Var, k1.m mVar) {
        return new k(b0Var, mVar);
    }

    @Override // r1.b0.b
    public Object apply(Object obj) {
        return b0.i0(this.f13691a, this.f13692b, (SQLiteDatabase) obj);
    }
}
