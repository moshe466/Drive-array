package bb;

import java.util.List;

/* loaded from: classes.dex */
public final class f1 extends s {

    /* renamed from: l, reason: collision with root package name */
    private final String f4202l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(String str, t0 t0Var, ua.h hVar, List<? extends v0> list, boolean z10) {
        super(t0Var, hVar, list, z10, null, 16, null);
        y8.k.e(str, "presentableName");
        y8.k.e(t0Var, "constructor");
        y8.k.e(hVar, "memberScope");
        y8.k.e(list, "arguments");
        this.f4202l = str;
    }

    @Override // bb.s, bb.g1
    /* renamed from: d1 */
    public i0 a1(boolean z10) {
        return new f1(f1(), W0(), A(), V0(), z10);
    }

    @Override // bb.s
    public String f1() {
        return this.f4202l;
    }

    @Override // bb.s
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public f1 g1(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        y8.k.e(gVar, "kotlinTypeRefiner");
        return this;
    }
}
