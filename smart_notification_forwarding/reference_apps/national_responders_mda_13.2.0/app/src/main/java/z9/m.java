package z9;

import bb.b0;
import bb.c0;
import bb.h1;
import bb.i0;
import ca.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import m8.p;
import m8.r;
import n9.v0;

/* loaded from: classes.dex */
public final class m extends p9.b {

    /* renamed from: p, reason: collision with root package name */
    private final y9.g f16378p;

    /* renamed from: q, reason: collision with root package name */
    private final y f16379q;

    /* renamed from: r, reason: collision with root package name */
    private final y9.d f16380r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(y9.g gVar, y yVar, int i10, n9.m mVar) {
        super(gVar.e(), mVar, yVar.c(), h1.INVARIANT, false, i10, v0.f12324a, gVar.a().u());
        y8.k.e(gVar, "c");
        y8.k.e(yVar, "javaTypeParameter");
        y8.k.e(mVar, "containingDeclaration");
        this.f16378p = gVar;
        this.f16379q = yVar;
        this.f16380r = new y9.d(gVar, yVar, false, 4, null);
    }

    private final List<b0> X0() {
        int n10;
        List<b0> b10;
        Collection<ca.j> upperBounds = this.f16379q.getUpperBounds();
        if (upperBounds.isEmpty()) {
            c0 c0Var = c0.f4165a;
            i0 i10 = this.f16378p.d().w().i();
            y8.k.d(i10, "c.module.builtIns.anyType");
            i0 I = this.f16378p.d().w().I();
            y8.k.d(I, "c.module.builtIns.nullableAnyType");
            b10 = p.b(c0.d(i10, I));
            return b10;
        }
        n10 = r.n(upperBounds, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f16378p.g().n((ca.j) it.next(), aa.d.f(w9.k.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    @Override // p9.e
    protected List<b0> U0(List<? extends b0> list) {
        y8.k.e(list, "bounds");
        return this.f16378p.a().q().g(this, list, this.f16378p);
    }

    @Override // p9.e
    protected void V0(b0 b0Var) {
        y8.k.e(b0Var, "type");
    }

    @Override // p9.e
    protected List<b0> W0() {
        return X0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public y9.d u() {
        return this.f16380r;
    }
}
