package ga;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.j;

/* loaded from: classes.dex */
public final class s extends i.d<s> {

    /* renamed from: r, reason: collision with root package name */
    private static final s f10264r;

    /* renamed from: s, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<s> f10265s = new a();

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10266g;

    /* renamed from: h, reason: collision with root package name */
    private int f10267h;

    /* renamed from: i, reason: collision with root package name */
    private int f10268i;

    /* renamed from: j, reason: collision with root package name */
    private int f10269j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f10270k;

    /* renamed from: l, reason: collision with root package name */
    private c f10271l;

    /* renamed from: m, reason: collision with root package name */
    private List<q> f10272m;

    /* renamed from: n, reason: collision with root package name */
    private List<Integer> f10273n;

    /* renamed from: o, reason: collision with root package name */
    private int f10274o;

    /* renamed from: p, reason: collision with root package name */
    private byte f10275p;

    /* renamed from: q, reason: collision with root package name */
    private int f10276q;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<s> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public s c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new s(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.c<s, b> {

        /* renamed from: i, reason: collision with root package name */
        private int f10277i;

        /* renamed from: j, reason: collision with root package name */
        private int f10278j;

        /* renamed from: k, reason: collision with root package name */
        private int f10279k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f10280l;

        /* renamed from: m, reason: collision with root package name */
        private c f10281m = c.INV;

        /* renamed from: n, reason: collision with root package name */
        private List<q> f10282n = Collections.emptyList();

        /* renamed from: o, reason: collision with root package name */
        private List<Integer> f10283o = Collections.emptyList();

        private b() {
            E();
        }

        private static b A() {
            return new b();
        }

        private void B() {
            if ((this.f10277i & 32) != 32) {
                this.f10283o = new ArrayList(this.f10283o);
                this.f10277i |= 32;
            }
        }

        private void C() {
            if ((this.f10277i & 16) != 16) {
                this.f10282n = new ArrayList(this.f10282n);
                this.f10277i |= 16;
            }
        }

        private void E() {
        }

        static /* synthetic */ b w() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public b p(s sVar) {
            if (sVar == s.M()) {
                return this;
            }
            if (sVar.W()) {
                I(sVar.O());
            }
            if (sVar.X()) {
                J(sVar.P());
            }
            if (sVar.Y()) {
                K(sVar.Q());
            }
            if (sVar.Z()) {
                L(sVar.V());
            }
            if (!sVar.f10272m.isEmpty()) {
                if (this.f10282n.isEmpty()) {
                    this.f10282n = sVar.f10272m;
                    this.f10277i &= -17;
                } else {
                    C();
                    this.f10282n.addAll(sVar.f10272m);
                }
            }
            if (!sVar.f10273n.isEmpty()) {
                if (this.f10283o.isEmpty()) {
                    this.f10283o = sVar.f10273n;
                    this.f10277i &= -33;
                } else {
                    B();
                    this.f10283o.addAll(sVar.f10273n);
                }
            }
            u(sVar);
            q(o().f(sVar.f10266g));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.s.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.s> r1 = ga.s.f10265s     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.s r3 = (ga.s) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.s r4 = (ga.s) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.s.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.s$b");
        }

        public b I(int i10) {
            this.f10277i |= 1;
            this.f10278j = i10;
            return this;
        }

        public b J(int i10) {
            this.f10277i |= 2;
            this.f10279k = i10;
            return this;
        }

        public b K(boolean z10) {
            this.f10277i |= 4;
            this.f10280l = z10;
            return this;
        }

        public b L(c cVar) {
            Objects.requireNonNull(cVar);
            this.f10277i |= 8;
            this.f10281m = cVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public s c() {
            s y10 = y();
            if (y10.k()) {
                return y10;
            }
            throw a.AbstractC0232a.m(y10);
        }

        public s y() {
            s sVar = new s(this);
            int i10 = this.f10277i;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            sVar.f10268i = this.f10278j;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            sVar.f10269j = this.f10279k;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            sVar.f10270k = this.f10280l;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            sVar.f10271l = this.f10281m;
            if ((this.f10277i & 16) == 16) {
                this.f10282n = Collections.unmodifiableList(this.f10282n);
                this.f10277i &= -17;
            }
            sVar.f10272m = this.f10282n;
            if ((this.f10277i & 32) == 32) {
                this.f10283o = Collections.unmodifiableList(this.f10283o);
                this.f10277i &= -33;
            }
            sVar.f10273n = this.f10283o;
            sVar.f10267h = i11;
            return sVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b n() {
            return A().p(y());
        }
    }

    /* loaded from: classes.dex */
    public enum c implements j.a {
        IN(0, 0),
        OUT(1, 1),
        INV(2, 2);

        private static j.b<c> internalValueMap = new a();
        private final int value;

        /* loaded from: classes.dex */
        static class a implements j.b<c> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i10) {
                return c.valueOf(i10);
            }
        }

        c(int i10, int i11) {
            this.value = i11;
        }

        public static c valueOf(int i10) {
            if (i10 == 0) {
                return IN;
            }
            if (i10 == 1) {
                return OUT;
            }
            if (i10 != 2) {
                return null;
            }
            return INV;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        s sVar = new s(true);
        f10264r = sVar;
        sVar.a0();
    }

    private s(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        List list;
        Object u10;
        this.f10274o = -1;
        this.f10275p = (byte) -1;
        this.f10276q = -1;
        a0();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    int K = eVar.K();
                    if (K != 0) {
                        if (K == 8) {
                            this.f10267h |= 1;
                            this.f10268i = eVar.s();
                        } else if (K == 16) {
                            this.f10267h |= 2;
                            this.f10269j = eVar.s();
                        } else if (K == 24) {
                            this.f10267h |= 4;
                            this.f10270k = eVar.k();
                        } else if (K != 32) {
                            if (K == 42) {
                                if ((i10 & 16) != 16) {
                                    this.f10272m = new ArrayList();
                                    i10 |= 16;
                                }
                                list = this.f10272m;
                                u10 = eVar.u(q.f10192z, gVar);
                            } else if (K == 48) {
                                if ((i10 & 32) != 32) {
                                    this.f10273n = new ArrayList();
                                    i10 |= 32;
                                }
                                list = this.f10273n;
                                u10 = Integer.valueOf(eVar.s());
                            } else if (K == 50) {
                                int j10 = eVar.j(eVar.A());
                                if ((i10 & 32) != 32 && eVar.e() > 0) {
                                    this.f10273n = new ArrayList();
                                    i10 |= 32;
                                }
                                while (eVar.e() > 0) {
                                    this.f10273n.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j10);
                            } else if (!q(eVar, J, gVar, K)) {
                            }
                            list.add(u10);
                        } else {
                            int n10 = eVar.n();
                            c valueOf = c.valueOf(n10);
                            if (valueOf == null) {
                                J.o0(K);
                                J.o0(n10);
                            } else {
                                this.f10267h |= 8;
                                this.f10271l = valueOf;
                            }
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((i10 & 16) == 16) {
                        this.f10272m = Collections.unmodifiableList(this.f10272m);
                    }
                    if ((i10 & 32) == 32) {
                        this.f10273n = Collections.unmodifiableList(this.f10273n);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f10266g = A.j();
                        throw th2;
                    }
                    this.f10266g = A.j();
                    n();
                    throw th;
                }
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
            }
        }
        if ((i10 & 16) == 16) {
            this.f10272m = Collections.unmodifiableList(this.f10272m);
        }
        if ((i10 & 32) == 32) {
            this.f10273n = Collections.unmodifiableList(this.f10273n);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10266g = A.j();
            throw th3;
        }
        this.f10266g = A.j();
        n();
    }

    private s(i.c<s, ?> cVar) {
        super(cVar);
        this.f10274o = -1;
        this.f10275p = (byte) -1;
        this.f10276q = -1;
        this.f10266g = cVar.o();
    }

    private s(boolean z10) {
        this.f10274o = -1;
        this.f10275p = (byte) -1;
        this.f10276q = -1;
        this.f10266g = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static s M() {
        return f10264r;
    }

    private void a0() {
        this.f10268i = 0;
        this.f10269j = 0;
        this.f10270k = false;
        this.f10271l = c.INV;
        this.f10272m = Collections.emptyList();
        this.f10273n = Collections.emptyList();
    }

    public static b b0() {
        return b.w();
    }

    public static b c0(s sVar) {
        return b0().p(sVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public s b() {
        return f10264r;
    }

    public int O() {
        return this.f10268i;
    }

    public int P() {
        return this.f10269j;
    }

    public boolean Q() {
        return this.f10270k;
    }

    public q R(int i10) {
        return this.f10272m.get(i10);
    }

    public int S() {
        return this.f10272m.size();
    }

    public List<Integer> T() {
        return this.f10273n;
    }

    public List<q> U() {
        return this.f10272m;
    }

    public c V() {
        return this.f10271l;
    }

    public boolean W() {
        return (this.f10267h & 1) == 1;
    }

    public boolean X() {
        return (this.f10267h & 2) == 2;
    }

    public boolean Y() {
        return (this.f10267h & 4) == 4;
    }

    public boolean Z() {
        return (this.f10267h & 8) == 8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10276q;
        if (i10 != -1) {
            return i10;
        }
        int o10 = (this.f10267h & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f10268i) + 0 : 0;
        if ((this.f10267h & 2) == 2) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.f10269j);
        }
        if ((this.f10267h & 4) == 4) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.a(3, this.f10270k);
        }
        if ((this.f10267h & 8) == 8) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.h(4, this.f10271l.getNumber());
        }
        for (int i11 = 0; i11 < this.f10272m.size(); i11++) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(5, this.f10272m.get(i11));
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f10273n.size(); i13++) {
            i12 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.f10273n.get(i13).intValue());
        }
        int i14 = o10 + i12;
        if (!T().isEmpty()) {
            i14 = i14 + 1 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(i12);
        }
        this.f10274o = i12;
        int u10 = i14 + u() + this.f10266g.size();
        this.f10276q = u10;
        return u10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public b h() {
        return b0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        i.d<MessageType>.a z10 = z();
        if ((this.f10267h & 1) == 1) {
            fVar.a0(1, this.f10268i);
        }
        if ((this.f10267h & 2) == 2) {
            fVar.a0(2, this.f10269j);
        }
        if ((this.f10267h & 4) == 4) {
            fVar.L(3, this.f10270k);
        }
        if ((this.f10267h & 8) == 8) {
            fVar.S(4, this.f10271l.getNumber());
        }
        for (int i10 = 0; i10 < this.f10272m.size(); i10++) {
            fVar.d0(5, this.f10272m.get(i10));
        }
        if (T().size() > 0) {
            fVar.o0(50);
            fVar.o0(this.f10274o);
        }
        for (int i11 = 0; i11 < this.f10273n.size(); i11++) {
            fVar.b0(this.f10273n.get(i11).intValue());
        }
        z10.a(1000, fVar);
        fVar.i0(this.f10266g);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return c0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<s> i() {
        return f10265s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10275p;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!W()) {
            this.f10275p = (byte) 0;
            return false;
        }
        if (!X()) {
            this.f10275p = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < S(); i10++) {
            if (!R(i10).k()) {
                this.f10275p = (byte) 0;
                return false;
            }
        }
        if (t()) {
            this.f10275p = (byte) 1;
            return true;
        }
        this.f10275p = (byte) 0;
        return false;
    }
}
