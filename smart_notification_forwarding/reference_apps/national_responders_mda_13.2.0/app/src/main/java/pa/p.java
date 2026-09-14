package pa;

import bb.b0;
import bb.t0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import n9.a1;
import n9.d0;

/* loaded from: classes.dex */
public final class p implements t0 {

    /* renamed from: a, reason: collision with root package name */
    private final long f13345a;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f13346b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<b0> f13347c;

    @Override // bb.t0
    /* renamed from: A */
    public /* bridge */ /* synthetic */ n9.h o() {
        return (n9.h) b();
    }

    @Override // bb.t0
    public List<a1> B() {
        List<a1> d10;
        d10 = m8.q.d();
        return d10;
    }

    public Void b() {
        return null;
    }

    public String toString() {
        return "IntegerValueType(" + this.f13345a + ')';
    }

    @Override // bb.t0
    public k9.h w() {
        return this.f13346b.w();
    }

    @Override // bb.t0
    public Collection<b0> x() {
        return this.f13347c;
    }

    @Override // bb.t0
    public t0 y(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // bb.t0
    public boolean z() {
        return false;
    }
}
