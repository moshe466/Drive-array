package oa;

import bb.b0;
import bb.h1;
import bb.v0;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.checker.j;
import m8.p;
import m8.q;
import n9.a1;
import n9.h;
import y8.k;

/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    private final v0 f12638a;

    /* renamed from: b, reason: collision with root package name */
    private j f12639b;

    public c(v0 v0Var) {
        k.e(v0Var, "projection");
        this.f12638a = v0Var;
        a().c();
        h1 h1Var = h1.INVARIANT;
    }

    @Override // bb.t0
    /* renamed from: A */
    public /* bridge */ /* synthetic */ h o() {
        return (h) b();
    }

    @Override // bb.t0
    public List<a1> B() {
        List<a1> d10;
        d10 = q.d();
        return d10;
    }

    @Override // oa.b
    public v0 a() {
        return this.f12638a;
    }

    public Void b() {
        return null;
    }

    public final j c() {
        return this.f12639b;
    }

    @Override // bb.t0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public c y(g gVar) {
        k.e(gVar, "kotlinTypeRefiner");
        v0 y10 = a().y(gVar);
        k.d(y10, "projection.refine(kotlinTypeRefiner)");
        return new c(y10);
    }

    public final void e(j jVar) {
        this.f12639b = jVar;
    }

    public String toString() {
        return "CapturedTypeConstructor(" + a() + ')';
    }

    @Override // bb.t0
    public k9.h w() {
        k9.h w10 = a().b().W0().w();
        k.d(w10, "projection.type.constructor.builtIns");
        return w10;
    }

    @Override // bb.t0
    public Collection<b0> x() {
        List b10;
        b0 b11 = a().c() == h1.OUT_VARIANCE ? a().b() : w().I();
        k.d(b11, "if (projection.projectionKind == Variance.OUT_VARIANCE)\n            projection.type\n        else\n            builtIns.nullableAnyType");
        b10 = p.b(b11);
        return b10;
    }

    @Override // bb.t0
    public boolean z() {
        return false;
    }
}
