package y9;

import ab.n;
import n9.d0;
import v9.w;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final b f15990a;

    /* renamed from: b, reason: collision with root package name */
    private final k f15991b;

    /* renamed from: c, reason: collision with root package name */
    private final l8.h<w> f15992c;

    /* renamed from: d, reason: collision with root package name */
    private final l8.h f15993d;

    /* renamed from: e, reason: collision with root package name */
    private final aa.c f15994e;

    public g(b bVar, k kVar, l8.h<w> hVar) {
        y8.k.e(bVar, "components");
        y8.k.e(kVar, "typeParameterResolver");
        y8.k.e(hVar, "delegateForDefaultTypeQualifiers");
        this.f15990a = bVar;
        this.f15991b = kVar;
        this.f15992c = hVar;
        this.f15993d = hVar;
        this.f15994e = new aa.c(this, kVar);
    }

    public final b a() {
        return this.f15990a;
    }

    public final w b() {
        return (w) this.f15993d.getValue();
    }

    public final l8.h<w> c() {
        return this.f15992c;
    }

    public final d0 d() {
        return this.f15990a.l();
    }

    public final n e() {
        return this.f15990a.t();
    }

    public final k f() {
        return this.f15991b;
    }

    public final aa.c g() {
        return this.f15994e;
    }
}
