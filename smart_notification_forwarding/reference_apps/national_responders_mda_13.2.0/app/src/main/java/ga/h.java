package ga;

import ga.q;
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
public final class h extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* renamed from: q, reason: collision with root package name */
    private static final h f10047q;

    /* renamed from: r, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<h> f10048r = new a();

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10049f;

    /* renamed from: g, reason: collision with root package name */
    private int f10050g;

    /* renamed from: h, reason: collision with root package name */
    private int f10051h;

    /* renamed from: i, reason: collision with root package name */
    private int f10052i;

    /* renamed from: j, reason: collision with root package name */
    private c f10053j;

    /* renamed from: k, reason: collision with root package name */
    private q f10054k;

    /* renamed from: l, reason: collision with root package name */
    private int f10055l;

    /* renamed from: m, reason: collision with root package name */
    private List<h> f10056m;

    /* renamed from: n, reason: collision with root package name */
    private List<h> f10057n;

    /* renamed from: o, reason: collision with root package name */
    private byte f10058o;

    /* renamed from: p, reason: collision with root package name */
    private int f10059p;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<h> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public h c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new h(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.b<h, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* renamed from: g, reason: collision with root package name */
        private int f10060g;

        /* renamed from: h, reason: collision with root package name */
        private int f10061h;

        /* renamed from: i, reason: collision with root package name */
        private int f10062i;

        /* renamed from: l, reason: collision with root package name */
        private int f10065l;

        /* renamed from: j, reason: collision with root package name */
        private c f10063j = c.TRUE;

        /* renamed from: k, reason: collision with root package name */
        private q f10064k = q.Z();

        /* renamed from: m, reason: collision with root package name */
        private List<h> f10066m = Collections.emptyList();

        /* renamed from: n, reason: collision with root package name */
        private List<h> f10067n = Collections.emptyList();

        private b() {
            z();
        }

        static /* synthetic */ b r() {
            return w();
        }

        private static b w() {
            return new b();
        }

        private void x() {
            if ((this.f10060g & 32) != 32) {
                this.f10066m = new ArrayList(this.f10066m);
                this.f10060g |= 32;
            }
        }

        private void y() {
            if ((this.f10060g & 64) != 64) {
                this.f10067n = new ArrayList(this.f10067n);
                this.f10060g |= 64;
            }
        }

        private void z() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: A, reason: merged with bridge method [inline-methods] */
        public b p(h hVar) {
            if (hVar == h.H()) {
                return this;
            }
            if (hVar.P()) {
                F(hVar.I());
            }
            if (hVar.S()) {
                I(hVar.N());
            }
            if (hVar.O()) {
                E(hVar.G());
            }
            if (hVar.Q()) {
                C(hVar.J());
            }
            if (hVar.R()) {
                G(hVar.K());
            }
            if (!hVar.f10056m.isEmpty()) {
                if (this.f10066m.isEmpty()) {
                    this.f10066m = hVar.f10056m;
                    this.f10060g &= -33;
                } else {
                    x();
                    this.f10066m.addAll(hVar.f10056m);
                }
            }
            if (!hVar.f10057n.isEmpty()) {
                if (this.f10067n.isEmpty()) {
                    this.f10067n = hVar.f10057n;
                    this.f10060g &= -65;
                } else {
                    y();
                    this.f10067n.addAll(hVar.f10057n);
                }
            }
            q(o().f(hVar.f10049f));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.h.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.h> r1 = ga.h.f10048r     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.h r3 = (ga.h) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.h r4 = (ga.h) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.h.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.h$b");
        }

        public b C(q qVar) {
            if ((this.f10060g & 8) == 8 && this.f10064k != q.Z()) {
                qVar = q.A0(this.f10064k).p(qVar).y();
            }
            this.f10064k = qVar;
            this.f10060g |= 8;
            return this;
        }

        public b E(c cVar) {
            Objects.requireNonNull(cVar);
            this.f10060g |= 4;
            this.f10063j = cVar;
            return this;
        }

        public b F(int i10) {
            this.f10060g |= 1;
            this.f10061h = i10;
            return this;
        }

        public b G(int i10) {
            this.f10060g |= 16;
            this.f10065l = i10;
            return this;
        }

        public b I(int i10) {
            this.f10060g |= 2;
            this.f10062i = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public h c() {
            h t10 = t();
            if (t10.k()) {
                return t10;
            }
            throw a.AbstractC0232a.m(t10);
        }

        public h t() {
            h hVar = new h(this);
            int i10 = this.f10060g;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            hVar.f10051h = this.f10061h;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            hVar.f10052i = this.f10062i;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            hVar.f10053j = this.f10063j;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            hVar.f10054k = this.f10064k;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            hVar.f10055l = this.f10065l;
            if ((this.f10060g & 32) == 32) {
                this.f10066m = Collections.unmodifiableList(this.f10066m);
                this.f10060g &= -33;
            }
            hVar.f10056m = this.f10066m;
            if ((this.f10060g & 64) == 64) {
                this.f10067n = Collections.unmodifiableList(this.f10067n);
                this.f10060g &= -65;
            }
            hVar.f10057n = this.f10067n;
            hVar.f10050g = i11;
            return hVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b n() {
            return w().p(t());
        }
    }

    /* loaded from: classes.dex */
    public enum c implements j.a {
        TRUE(0, 0),
        FALSE(1, 1),
        NULL(2, 2);

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
                return TRUE;
            }
            if (i10 == 1) {
                return FALSE;
            }
            if (i10 != 2) {
                return null;
            }
            return NULL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
        public final int getNumber() {
            return this.value;
        }
    }

    static {
        h hVar = new h(true);
        f10047q = hVar;
        hVar.T();
    }

    private h(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        List list;
        kotlin.reflect.jvm.internal.impl.protobuf.q u10;
        this.f10058o = (byte) -1;
        this.f10059p = -1;
        T();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                this.f10050g |= 1;
                                this.f10051h = eVar.s();
                            } else if (K == 16) {
                                this.f10050g |= 2;
                                this.f10052i = eVar.s();
                            } else if (K == 24) {
                                int n10 = eVar.n();
                                c valueOf = c.valueOf(n10);
                                if (valueOf == null) {
                                    J.o0(K);
                                    J.o0(n10);
                                } else {
                                    this.f10050g |= 4;
                                    this.f10053j = valueOf;
                                }
                            } else if (K == 34) {
                                q.c d10 = (this.f10050g & 8) == 8 ? this.f10054k.d() : null;
                                q qVar = (q) eVar.u(q.f10192z, gVar);
                                this.f10054k = qVar;
                                if (d10 != null) {
                                    d10.p(qVar);
                                    this.f10054k = d10.y();
                                }
                                this.f10050g |= 8;
                            } else if (K != 40) {
                                if (K == 50) {
                                    if ((i10 & 32) != 32) {
                                        this.f10056m = new ArrayList();
                                        i10 |= 32;
                                    }
                                    list = this.f10056m;
                                    u10 = eVar.u(f10048r, gVar);
                                } else if (K == 58) {
                                    if ((i10 & 64) != 64) {
                                        this.f10057n = new ArrayList();
                                        i10 |= 64;
                                    }
                                    list = this.f10057n;
                                    u10 = eVar.u(f10048r, gVar);
                                } else if (!q(eVar, J, gVar, K)) {
                                }
                                list.add(u10);
                            } else {
                                this.f10050g |= 16;
                                this.f10055l = eVar.s();
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
                if ((i10 & 32) == 32) {
                    this.f10056m = Collections.unmodifiableList(this.f10056m);
                }
                if ((i10 & 64) == 64) {
                    this.f10057n = Collections.unmodifiableList(this.f10057n);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f10049f = A.j();
                    throw th2;
                }
                this.f10049f = A.j();
                n();
                throw th;
            }
        }
        if ((i10 & 32) == 32) {
            this.f10056m = Collections.unmodifiableList(this.f10056m);
        }
        if ((i10 & 64) == 64) {
            this.f10057n = Collections.unmodifiableList(this.f10057n);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10049f = A.j();
            throw th3;
        }
        this.f10049f = A.j();
        n();
    }

    private h(i.b bVar) {
        super(bVar);
        this.f10058o = (byte) -1;
        this.f10059p = -1;
        this.f10049f = bVar.o();
    }

    private h(boolean z10) {
        this.f10058o = (byte) -1;
        this.f10059p = -1;
        this.f10049f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static h H() {
        return f10047q;
    }

    private void T() {
        this.f10051h = 0;
        this.f10052i = 0;
        this.f10053j = c.TRUE;
        this.f10054k = q.Z();
        this.f10055l = 0;
        this.f10056m = Collections.emptyList();
        this.f10057n = Collections.emptyList();
    }

    public static b U() {
        return b.r();
    }

    public static b V(h hVar) {
        return U().p(hVar);
    }

    public h E(int i10) {
        return this.f10056m.get(i10);
    }

    public int F() {
        return this.f10056m.size();
    }

    public c G() {
        return this.f10053j;
    }

    public int I() {
        return this.f10051h;
    }

    public q J() {
        return this.f10054k;
    }

    public int K() {
        return this.f10055l;
    }

    public h L(int i10) {
        return this.f10057n.get(i10);
    }

    public int M() {
        return this.f10057n.size();
    }

    public int N() {
        return this.f10052i;
    }

    public boolean O() {
        return (this.f10050g & 4) == 4;
    }

    public boolean P() {
        return (this.f10050g & 1) == 1;
    }

    public boolean Q() {
        return (this.f10050g & 8) == 8;
    }

    public boolean R() {
        return (this.f10050g & 16) == 16;
    }

    public boolean S() {
        return (this.f10050g & 2) == 2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public b h() {
        return U();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public b d() {
        return V(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10059p;
        if (i10 != -1) {
            return i10;
        }
        int o10 = (this.f10050g & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f10051h) + 0 : 0;
        if ((this.f10050g & 2) == 2) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(2, this.f10052i);
        }
        if ((this.f10050g & 4) == 4) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.h(3, this.f10053j.getNumber());
        }
        if ((this.f10050g & 8) == 8) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(4, this.f10054k);
        }
        if ((this.f10050g & 16) == 16) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(5, this.f10055l);
        }
        for (int i11 = 0; i11 < this.f10056m.size(); i11++) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(6, this.f10056m.get(i11));
        }
        for (int i12 = 0; i12 < this.f10057n.size(); i12++) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(7, this.f10057n.get(i12));
        }
        int size = o10 + this.f10049f.size();
        this.f10059p = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        if ((this.f10050g & 1) == 1) {
            fVar.a0(1, this.f10051h);
        }
        if ((this.f10050g & 2) == 2) {
            fVar.a0(2, this.f10052i);
        }
        if ((this.f10050g & 4) == 4) {
            fVar.S(3, this.f10053j.getNumber());
        }
        if ((this.f10050g & 8) == 8) {
            fVar.d0(4, this.f10054k);
        }
        if ((this.f10050g & 16) == 16) {
            fVar.a0(5, this.f10055l);
        }
        for (int i10 = 0; i10 < this.f10056m.size(); i10++) {
            fVar.d0(6, this.f10056m.get(i10));
        }
        for (int i11 = 0; i11 < this.f10057n.size(); i11++) {
            fVar.d0(7, this.f10057n.get(i11));
        }
        fVar.i0(this.f10049f);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<h> i() {
        return f10048r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10058o;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (Q() && !J().k()) {
            this.f10058o = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < F(); i10++) {
            if (!E(i10).k()) {
                this.f10058o = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < M(); i11++) {
            if (!L(i11).k()) {
                this.f10058o = (byte) 0;
                return false;
            }
        }
        this.f10058o = (byte) 1;
        return true;
    }
}
