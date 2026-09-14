package m9;

import ab.n;
import java.util.List;
import m8.p;
import m8.q;
import n9.a0;
import n9.a1;
import n9.b;
import n9.d1;
import n9.s0;
import n9.t;
import n9.v0;
import n9.x;
import p9.f0;
import y8.k;

/* loaded from: classes.dex */
public final class a extends ua.e {

    /* renamed from: e, reason: collision with root package name */
    public static final C0251a f12051e = new C0251a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final la.e f12052f;

    /* renamed from: m9.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0251a {
        private C0251a() {
        }

        public /* synthetic */ C0251a(y8.g gVar) {
            this();
        }

        public final la.e a() {
            return a.f12052f;
        }
    }

    static {
        la.e r10 = la.e.r("clone");
        k.d(r10, "identifier(\"clone\")");
        f12052f = r10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(n nVar, n9.e eVar) {
        super(nVar, eVar);
        k.e(nVar, "storageManager");
        k.e(eVar, "containingClass");
    }

    @Override // ua.e
    protected List<x> i() {
        List<? extends a1> d10;
        List<d1> d11;
        List<x> b10;
        f0 w12 = f0.w1(l(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b(), f12051e.a(), b.a.DECLARATION, v0.f12324a);
        s0 T0 = l().T0();
        d10 = q.d();
        d11 = q.d();
        w12.c1(null, T0, d10, d11, ra.a.g(l()).i(), a0.OPEN, t.f12301c);
        b10 = p.b(w12);
        return b10;
    }
}
