package bb;

import java.util.List;

/* loaded from: classes.dex */
public class s extends i0 {

    /* renamed from: g, reason: collision with root package name */
    private final t0 f4253g;

    /* renamed from: h, reason: collision with root package name */
    private final ua.h f4254h;

    /* renamed from: i, reason: collision with root package name */
    private final List<v0> f4255i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f4256j;

    /* renamed from: k, reason: collision with root package name */
    private final String f4257k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(t0 t0Var, ua.h hVar) {
        this(t0Var, hVar, null, false, null, 28, null);
        y8.k.e(t0Var, "constructor");
        y8.k.e(hVar, "memberScope");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(t0 t0Var, ua.h hVar, List<? extends v0> list, boolean z10) {
        this(t0Var, hVar, list, z10, null, 16, null);
        y8.k.e(t0Var, "constructor");
        y8.k.e(hVar, "memberScope");
        y8.k.e(list, "arguments");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s(t0 t0Var, ua.h hVar, List<? extends v0> list, boolean z10, String str) {
        y8.k.e(t0Var, "constructor");
        y8.k.e(hVar, "memberScope");
        y8.k.e(list, "arguments");
        y8.k.e(str, "presentableName");
        this.f4253g = t0Var;
        this.f4254h = hVar;
        this.f4255i = list;
        this.f4256j = z10;
        this.f4257k = str;
    }

    public /* synthetic */ s(t0 t0Var, ua.h hVar, List list, boolean z10, String str, int i10, y8.g gVar) {
        this(t0Var, hVar, (i10 & 4) != 0 ? m8.q.d() : list, (i10 & 8) != 0 ? false : z10, (i10 & 16) != 0 ? "???" : str);
    }

    @Override // bb.b0
    public ua.h A() {
        return this.f4254h;
    }

    @Override // bb.b0
    public List<v0> V0() {
        return this.f4255i;
    }

    @Override // bb.b0
    public t0 W0() {
        return this.f4253g;
    }

    @Override // bb.b0
    public boolean X0() {
        return this.f4256j;
    }

    @Override // bb.g1
    /* renamed from: d1 */
    public i0 a1(boolean z10) {
        return new s(W0(), A(), V0(), z10, null, 16, null);
    }

    @Override // bb.g1
    /* renamed from: e1 */
    public i0 c1(kotlin.reflect.jvm.internal.impl.descriptors.annotations.g gVar) {
        y8.k.e(gVar, "newAnnotations");
        return this;
    }

    public String f1() {
        return this.f4257k;
    }

    @Override // bb.g1
    public s g1(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // bb.i0
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(W0());
        sb2.append(V0().isEmpty() ? "" : m8.y.P(V0(), ", ", "<", ">", -1, "...", null));
        return sb2.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.g u() {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.g.f11362b.b();
    }
}
