package ga;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* loaded from: classes.dex */
public final class p extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* renamed from: j, reason: collision with root package name */
    private static final p f10183j;

    /* renamed from: k, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<p> f10184k = new a();

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10185f;

    /* renamed from: g, reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.protobuf.o f10186g;

    /* renamed from: h, reason: collision with root package name */
    private byte f10187h;

    /* renamed from: i, reason: collision with root package name */
    private int f10188i;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<p> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public p c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new p(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.b<p, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* renamed from: g, reason: collision with root package name */
        private int f10189g;

        /* renamed from: h, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.protobuf.o f10190h = kotlin.reflect.jvm.internal.impl.protobuf.n.f11447g;

        private b() {
            y();
        }

        static /* synthetic */ b r() {
            return w();
        }

        private static b w() {
            return new b();
        }

        private void x() {
            if ((this.f10189g & 1) != 1) {
                this.f10190h = new kotlin.reflect.jvm.internal.impl.protobuf.n(this.f10190h);
                this.f10189g |= 1;
            }
        }

        private void y() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.p.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.p> r1 = ga.p.f10184k     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.p r3 = (ga.p) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                if (r3 == 0) goto Le
                r2.p(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                kotlin.reflect.jvm.internal.impl.protobuf.q r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                ga.p r4 = (ga.p) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.p(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ga.p.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.p$b");
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public p c() {
            p t10 = t();
            if (t10.k()) {
                return t10;
            }
            throw a.AbstractC0232a.m(t10);
        }

        public p t() {
            p pVar = new p(this);
            if ((this.f10189g & 1) == 1) {
                this.f10190h = this.f10190h.m();
                this.f10189g &= -2;
            }
            pVar.f10186g = this.f10190h;
            return pVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b n() {
            return w().p(t());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b p(p pVar) {
            if (pVar == p.v()) {
                return this;
            }
            if (!pVar.f10186g.isEmpty()) {
                if (this.f10190h.isEmpty()) {
                    this.f10190h = pVar.f10186g;
                    this.f10189g &= -2;
                } else {
                    x();
                    this.f10190h.addAll(pVar.f10186g);
                }
            }
            q(o().f(pVar.f10185f));
            return this;
        }
    }

    static {
        p pVar = new p(true);
        f10183j = pVar;
        pVar.y();
    }

    private p(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.f10187h = (byte) -1;
        this.f10188i = -1;
        y();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        boolean z11 = false;
        while (!z10) {
            try {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 10) {
                                kotlin.reflect.jvm.internal.impl.protobuf.d l10 = eVar.l();
                                if (!(z11 & true)) {
                                    this.f10186g = new kotlin.reflect.jvm.internal.impl.protobuf.n();
                                    z11 |= true;
                                }
                                this.f10186g.q(l10);
                            } else if (!q(eVar, J, gVar, K)) {
                            }
                        }
                        z10 = true;
                    } catch (IOException e10) {
                        throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e10.getMessage()).i(this);
                    }
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e11) {
                    throw e11.i(this);
                }
            } catch (Throwable th) {
                if (z11 & true) {
                    this.f10186g = this.f10186g.m();
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f10185f = A.j();
                    throw th2;
                }
                this.f10185f = A.j();
                n();
                throw th;
            }
        }
        if (z11 & true) {
            this.f10186g = this.f10186g.m();
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10185f = A.j();
            throw th3;
        }
        this.f10185f = A.j();
        n();
    }

    private p(i.b bVar) {
        super(bVar);
        this.f10187h = (byte) -1;
        this.f10188i = -1;
        this.f10185f = bVar.o();
    }

    private p(boolean z10) {
        this.f10187h = (byte) -1;
        this.f10188i = -1;
        this.f10185f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static b A(p pVar) {
        return z().p(pVar);
    }

    public static p v() {
        return f10183j;
    }

    private void y() {
        this.f10186g = kotlin.reflect.jvm.internal.impl.protobuf.n.f11447g;
    }

    public static b z() {
        return b.r();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public b h() {
        return z();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public b d() {
        return A(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10188i;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f10186g.size(); i12++) {
            i11 += kotlin.reflect.jvm.internal.impl.protobuf.f.e(this.f10186g.k(i12));
        }
        int size = 0 + i11 + (x().size() * 1) + this.f10185f.size();
        this.f10188i = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        for (int i10 = 0; i10 < this.f10186g.size(); i10++) {
            fVar.O(1, this.f10186g.k(i10));
        }
        fVar.i0(this.f10185f);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<p> i() {
        return f10184k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10187h;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        this.f10187h = (byte) 1;
        return true;
    }

    public String w(int i10) {
        return this.f10186g.get(i10);
    }

    public kotlin.reflect.jvm.internal.impl.protobuf.t x() {
        return this.f10186g;
    }
}
