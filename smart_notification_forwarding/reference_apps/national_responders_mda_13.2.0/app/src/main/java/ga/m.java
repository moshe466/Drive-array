package ga;

import ga.l;
import ga.o;
import ga.p;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* loaded from: classes.dex */
public final class m extends i.d<m> {

    /* renamed from: o, reason: collision with root package name */
    private static final m f10116o;

    /* renamed from: p, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<m> f10117p = new a();

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10118g;

    /* renamed from: h, reason: collision with root package name */
    private int f10119h;

    /* renamed from: i, reason: collision with root package name */
    private p f10120i;

    /* renamed from: j, reason: collision with root package name */
    private o f10121j;

    /* renamed from: k, reason: collision with root package name */
    private l f10122k;

    /* renamed from: l, reason: collision with root package name */
    private List<c> f10123l;

    /* renamed from: m, reason: collision with root package name */
    private byte f10124m;

    /* renamed from: n, reason: collision with root package name */
    private int f10125n;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<m> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public m c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new m(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.c<m, b> {

        /* renamed from: i, reason: collision with root package name */
        private int f10126i;

        /* renamed from: j, reason: collision with root package name */
        private p f10127j = p.v();

        /* renamed from: k, reason: collision with root package name */
        private o f10128k = o.v();

        /* renamed from: l, reason: collision with root package name */
        private l f10129l = l.M();

        /* renamed from: m, reason: collision with root package name */
        private List<c> f10130m = Collections.emptyList();

        private b() {
            C();
        }

        private static b A() {
            return new b();
        }

        private void B() {
            if ((this.f10126i & 8) != 8) {
                this.f10130m = new ArrayList(this.f10130m);
                this.f10126i |= 8;
            }
        }

        private void C() {
        }

        static /* synthetic */ b w() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public b p(m mVar) {
            if (mVar == m.M()) {
                return this;
            }
            if (mVar.T()) {
                J(mVar.Q());
            }
            if (mVar.S()) {
                I(mVar.P());
            }
            if (mVar.R()) {
                G(mVar.O());
            }
            if (!mVar.f10123l.isEmpty()) {
                if (this.f10130m.isEmpty()) {
                    this.f10130m = mVar.f10123l;
                    this.f10126i &= -9;
                } else {
                    B();
                    this.f10130m.addAll(mVar.f10123l);
                }
            }
            u(mVar);
            q(o().f(mVar.f10118g));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.m.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.m> r1 = ga.m.f10117p     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.m r3 = (ga.m) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.m r4 = (ga.m) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.m.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.m$b");
        }

        public b G(l lVar) {
            if ((this.f10126i & 4) == 4 && this.f10129l != l.M()) {
                lVar = l.d0(this.f10129l).p(lVar).y();
            }
            this.f10129l = lVar;
            this.f10126i |= 4;
            return this;
        }

        public b I(o oVar) {
            if ((this.f10126i & 2) == 2 && this.f10128k != o.v()) {
                oVar = o.A(this.f10128k).p(oVar).t();
            }
            this.f10128k = oVar;
            this.f10126i |= 2;
            return this;
        }

        public b J(p pVar) {
            if ((this.f10126i & 1) == 1 && this.f10127j != p.v()) {
                pVar = p.A(this.f10127j).p(pVar).t();
            }
            this.f10127j = pVar;
            this.f10126i |= 1;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public m c() {
            m y10 = y();
            if (y10.k()) {
                return y10;
            }
            throw a.AbstractC0232a.m(y10);
        }

        public m y() {
            m mVar = new m(this);
            int i10 = this.f10126i;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            mVar.f10120i = this.f10127j;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            mVar.f10121j = this.f10128k;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            mVar.f10122k = this.f10129l;
            if ((this.f10126i & 8) == 8) {
                this.f10130m = Collections.unmodifiableList(this.f10130m);
                this.f10126i &= -9;
            }
            mVar.f10123l = this.f10130m;
            mVar.f10119h = i11;
            return mVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b n() {
            return A().p(y());
        }
    }

    static {
        m mVar = new m(true);
        f10116o = mVar;
        mVar.U();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private m(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        int i10;
        int i11;
        this.f10124m = (byte) -1;
        this.f10125n = -1;
        U();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        int i12 = 0;
        while (!z10) {
            try {
                try {
                    int K = eVar.K();
                    if (K != 0) {
                        if (K != 10) {
                            if (K == 18) {
                                i10 = 2;
                                o.b d10 = (this.f10119h & 2) == 2 ? this.f10121j.d() : null;
                                o oVar = (o) eVar.u(o.f10163k, gVar);
                                this.f10121j = oVar;
                                if (d10 != null) {
                                    d10.p(oVar);
                                    this.f10121j = d10.t();
                                }
                                i11 = this.f10119h;
                            } else if (K == 26) {
                                i10 = 4;
                                l.b d11 = (this.f10119h & 4) == 4 ? this.f10122k.d() : null;
                                l lVar = (l) eVar.u(l.f10100q, gVar);
                                this.f10122k = lVar;
                                if (d11 != null) {
                                    d11.p(lVar);
                                    this.f10122k = d11.y();
                                }
                                i11 = this.f10119h;
                            } else if (K == 34) {
                                if ((i12 & 8) != 8) {
                                    this.f10123l = new ArrayList();
                                    i12 |= 8;
                                }
                                this.f10123l.add(eVar.u(c.E, gVar));
                            } else if (!q(eVar, J, gVar, K)) {
                            }
                            this.f10119h = i11 | i10;
                        } else {
                            p.b d12 = (this.f10119h & 1) == 1 ? this.f10120i.d() : null;
                            p pVar = (p) eVar.u(p.f10184k, gVar);
                            this.f10120i = pVar;
                            if (d12 != null) {
                                d12.p(pVar);
                                this.f10120i = d12.t();
                            }
                            this.f10119h |= 1;
                        }
                    }
                    z10 = true;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if ((i12 & 8) == 8) {
                    this.f10123l = Collections.unmodifiableList(this.f10123l);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f10118g = A.j();
                    throw th2;
                }
                this.f10118g = A.j();
                n();
                throw th;
            }
        }
        if ((i12 & 8) == 8) {
            this.f10123l = Collections.unmodifiableList(this.f10123l);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10118g = A.j();
            throw th3;
        }
        this.f10118g = A.j();
        n();
    }

    private m(i.c<m, ?> cVar) {
        super(cVar);
        this.f10124m = (byte) -1;
        this.f10125n = -1;
        this.f10118g = cVar.o();
    }

    private m(boolean z10) {
        this.f10124m = (byte) -1;
        this.f10125n = -1;
        this.f10118g = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static m M() {
        return f10116o;
    }

    private void U() {
        this.f10120i = p.v();
        this.f10121j = o.v();
        this.f10122k = l.M();
        this.f10123l = Collections.emptyList();
    }

    public static b V() {
        return b.w();
    }

    public static b W(m mVar) {
        return V().p(mVar);
    }

    public static m Y(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        return f10117p.b(inputStream, gVar);
    }

    public c J(int i10) {
        return this.f10123l.get(i10);
    }

    public int K() {
        return this.f10123l.size();
    }

    public List<c> L() {
        return this.f10123l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public m b() {
        return f10116o;
    }

    public l O() {
        return this.f10122k;
    }

    public o P() {
        return this.f10121j;
    }

    public p Q() {
        return this.f10120i;
    }

    public boolean R() {
        return (this.f10119h & 4) == 4;
    }

    public boolean S() {
        return (this.f10119h & 2) == 2;
    }

    public boolean T() {
        return (this.f10119h & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public b h() {
        return V();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public b d() {
        return W(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10125n;
        if (i10 != -1) {
            return i10;
        }
        int s10 = (this.f10119h & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.s(1, this.f10120i) + 0 : 0;
        if ((this.f10119h & 2) == 2) {
            s10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.f10121j);
        }
        if ((this.f10119h & 4) == 4) {
            s10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(3, this.f10122k);
        }
        for (int i11 = 0; i11 < this.f10123l.size(); i11++) {
            s10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.f10123l.get(i11));
        }
        int u10 = s10 + u() + this.f10118g.size();
        this.f10125n = u10;
        return u10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        i.d<MessageType>.a z10 = z();
        if ((this.f10119h & 1) == 1) {
            fVar.d0(1, this.f10120i);
        }
        if ((this.f10119h & 2) == 2) {
            fVar.d0(2, this.f10121j);
        }
        if ((this.f10119h & 4) == 4) {
            fVar.d0(3, this.f10122k);
        }
        for (int i10 = 0; i10 < this.f10123l.size(); i10++) {
            fVar.d0(4, this.f10123l.get(i10));
        }
        z10.a(200, fVar);
        fVar.i0(this.f10118g);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<m> i() {
        return f10117p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10124m;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (S() && !P().k()) {
            this.f10124m = (byte) 0;
            return false;
        }
        if (R() && !O().k()) {
            this.f10124m = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < K(); i10++) {
            if (!J(i10).k()) {
                this.f10124m = (byte) 0;
                return false;
            }
        }
        if (t()) {
            this.f10124m = (byte) 1;
            return true;
        }
        this.f10124m = (byte) 0;
        return false;
    }
}
