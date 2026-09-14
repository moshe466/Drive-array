package za;

import bb.b0;
import ga.q;
import ga.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import m8.p;
import m8.r;
import m8.y;

/* loaded from: classes.dex */
public final class m extends p9.b {

    /* renamed from: p, reason: collision with root package name */
    private final xa.l f16492p;

    /* renamed from: q, reason: collision with root package name */
    private final s f16493q;

    /* renamed from: r, reason: collision with root package name */
    private final za.a f16494r;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> b() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> n02;
            n02 = y.n0(m.this.f16492p.c().d().a(m.this.Z0(), m.this.f16492p.g()));
            return n02;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public m(xa.l r11, ga.s r12, int r13) {
        /*
            r10 = this;
            java.lang.String r0 = "c"
            y8.k.e(r11, r0)
            java.lang.String r0 = "proto"
            y8.k.e(r12, r0)
            ab.n r2 = r11.h()
            n9.m r3 = r11.e()
            ia.c r0 = r11.g()
            int r1 = r12.P()
            la.e r4 = xa.v.b(r0, r1)
            xa.y r0 = xa.y.f15666a
            ga.s$c r1 = r12.V()
            java.lang.String r5 = "proto.variance"
            y8.k.d(r1, r5)
            bb.h1 r5 = r0.d(r1)
            boolean r6 = r12.Q()
            n9.v0 r8 = n9.v0.f12324a
            n9.y0$a r9 = n9.y0.a.f12328a
            r1 = r10
            r7 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r10.f16492p = r11
            r10.f16493q = r12
            za.a r12 = new za.a
            ab.n r11 = r11.h()
            za.m$a r13 = new za.m$a
            r13.<init>()
            r12.<init>(r11, r13)
            r10.f16494r = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: za.m.<init>(xa.l, ga.s, int):void");
    }

    @Override // p9.e
    protected List<b0> W0() {
        int n10;
        List<b0> b10;
        List<q> o10 = ia.f.o(this.f16493q, this.f16492p.j());
        if (o10.isEmpty()) {
            b10 = p.b(ra.a.g(this).y());
            return b10;
        }
        xa.b0 i10 = this.f16492p.i();
        n10 = r.n(o10, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator<T> it = o10.iterator();
        while (it.hasNext()) {
            arrayList.add(i10.p((q) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.b, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public za.a u() {
        return this.f16494r;
    }

    public final s Z0() {
        return this.f16493q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // p9.e
    /* renamed from: a1, reason: merged with bridge method [inline-methods] */
    public Void V0(b0 b0Var) {
        y8.k.e(b0Var, "type");
        throw new IllegalStateException(y8.k.j("There should be no cycles for deserialized type parameters, but found for: ", this));
    }
}
