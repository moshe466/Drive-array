package r1;

import android.database.sqlite.SQLiteDatabase;
import r1.b0;

/* loaded from: classes.dex */
final /* synthetic */ class a0 implements b0.b {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f13654a;

    /* renamed from: b, reason: collision with root package name */
    private final k1.m f13655b;

    private a0(b0 b0Var, k1.m mVar) {
        this.f13654a = b0Var;
        this.f13655b = mVar;
    }

    public static b0.b a(b0 b0Var, k1.m mVar) {
        return new a0(b0Var, mVar);
    }

    @Override // r1.b0.b
    public Object apply(Object obj) {
        return b0.f0(this.f13654a, this.f13655b, (SQLiteDatabase) obj);
    }
}
