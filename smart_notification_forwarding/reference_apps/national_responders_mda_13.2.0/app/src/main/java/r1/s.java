package r1;

import r1.b0;

/* loaded from: classes.dex */
final /* synthetic */ class s implements b0.d {

    /* renamed from: a, reason: collision with root package name */
    private final h0 f13702a;

    private s(h0 h0Var) {
        this.f13702a = h0Var;
    }

    public static b0.d b(h0 h0Var) {
        return new s(h0Var);
    }

    @Override // r1.b0.d
    public Object a() {
        return this.f13702a.getWritableDatabase();
    }
}
