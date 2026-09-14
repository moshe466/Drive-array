package r1;

import android.database.sqlite.SQLiteDatabase;
import r1.b0;

/* loaded from: classes.dex */
final /* synthetic */ class w implements b0.b {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f13706a;

    /* renamed from: b, reason: collision with root package name */
    private final k1.m f13707b;

    /* renamed from: c, reason: collision with root package name */
    private final k1.h f13708c;

    private w(b0 b0Var, k1.m mVar, k1.h hVar) {
        this.f13706a = b0Var;
        this.f13707b = mVar;
        this.f13708c = hVar;
    }

    public static b0.b a(b0 b0Var, k1.m mVar, k1.h hVar) {
        return new w(b0Var, mVar, hVar);
    }

    @Override // r1.b0.b
    public Object apply(Object obj) {
        return b0.l0(this.f13706a, this.f13707b, this.f13708c, (SQLiteDatabase) obj);
    }
}
