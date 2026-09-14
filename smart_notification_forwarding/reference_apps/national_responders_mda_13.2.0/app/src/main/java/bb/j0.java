package bb;

import bb.t;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j0 extends i0 {

    /* renamed from: g, reason: collision with root package name */
    private final t0 f4223g;

    /* renamed from: h, reason: collision with root package name */
    private final List<v0> f4224h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f4225i;

    /* renamed from: j, reason: collision with root package name */
    private final ua.h f4226j;

    /* renamed from: k, reason: collision with root package name */
    private final x8.l<kotlin.reflect.jvm.internal.impl.types.checker.g, i0> f4227k;

    /* JADX WARN: Multi-variable type inference failed */
    public j0(t0 t0Var, List<? extends v0> list, boolean z10, ua.h hVar, x8.l<? super kotlin.reflect.jvm.internal.impl.types.checker.g, ? extends i0> lVar) {
        y8.k.e(t0Var, "constructor");
        y8.k.e(list, "arguments");
        y8.k.e(hVar, "memberScope");
        y8.k.e(lVar, "refinedTypeFactory");
        this.f4223g = t0Var;
        this.f4224h = list;
        this.f4225i = z10;
        this.f4226j = hVar;
        this.f4227k = lVar;
        if (A() instanceof t.d) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + A() + '\n' + W0());
        }
    }

    @Override // bb.b0
    public ua.h A() {
        return this.f4226j;
    }

    @Override // bb.b0
    public List<v0> V0() {
        return this.f4224h;
    }

    @Override // bb.b0
    public t0 W0() {
        return this.f4223g;
    }

    @Override // bb.b0
    public boolean X0() {
        return this.f4225i;
    }

    @Override // bb.g1
    /* renamed from: d1 */
    public i0 a1(boolean z10) {
        return z10 == X0() ? this : z10 ? new g0(this) : new f0(this);
    }

    @Override // bb.g1
    /* renamed from: e1 */
    public i0 c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "newAnnotations");
        return gVar.isEmpty() ? this : new h(this, gVar);
    }

    @Override // bb.g1
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public i0 g1(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        i0 h10 = this.f4227k.h(gVar);
        return h10 == null ? this : h10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
    }
}
