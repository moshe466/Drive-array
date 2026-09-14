package ga;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* loaded from: classes.dex */
public final class d extends i.d<d> {

    /* renamed from: n, reason: collision with root package name */
    private static final d f10002n;

    /* renamed from: o, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<d> f10003o = new a();

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10004g;

    /* renamed from: h, reason: collision with root package name */
    private int f10005h;

    /* renamed from: i, reason: collision with root package name */
    private int f10006i;

    /* renamed from: j, reason: collision with root package name */
    private List<u> f10007j;

    /* renamed from: k, reason: collision with root package name */
    private List<Integer> f10008k;

    /* renamed from: l, reason: collision with root package name */
    private byte f10009l;

    /* renamed from: m, reason: collision with root package name */
    private int f10010m;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<d> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public d c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new d(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.c<d, b> {

        /* renamed from: i, reason: collision with root package name */
        private int f10011i;

        /* renamed from: j, reason: collision with root package name */
        private int f10012j = 6;

        /* renamed from: k, reason: collision with root package name */
        private List<u> f10013k = Collections.emptyList();

        /* renamed from: l, reason: collision with root package name */
        private List<Integer> f10014l = Collections.emptyList();

        private b() {
            E();
        }

        private static b A() {
            return new b();
        }

        private void B() {
            if ((this.f10011i & 2) != 2) {
                this.f10013k = new ArrayList(this.f10013k);
                this.f10011i |= 2;
            }
        }

        private void C() {
            if ((this.f10011i & 4) != 4) {
                this.f10014l = new ArrayList(this.f10014l);
                this.f10011i |= 4;
            }
        }

        private void E() {
        }

        static /* synthetic */ b w() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public b p(d dVar) {
            if (dVar == d.J()) {
                return this;
            }
            if (dVar.Q()) {
                I(dVar.L());
            }
            if (!dVar.f10007j.isEmpty()) {
                if (this.f10013k.isEmpty()) {
                    this.f10013k = dVar.f10007j;
                    this.f10011i &= -3;
                } else {
                    B();
                    this.f10013k.addAll(dVar.f10007j);
                }
            }
            if (!dVar.f10008k.isEmpty()) {
                if (this.f10014l.isEmpty()) {
                    this.f10014l = dVar.f10008k;
                    this.f10011i &= -5;
                } else {
                    C();
                    this.f10014l.addAll(dVar.f10008k);
                }
            }
            u(dVar);
            q(o().f(dVar.f10004g));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.d.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.d> r1 = ga.d.f10003o     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.d r3 = (ga.d) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.d r4 = (ga.d) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.d.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.d$b");
        }

        public b I(int i10) {
            this.f10011i |= 1;
            this.f10012j = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public d c() {
            d y10 = y();
            if (y10.k()) {
                return y10;
            }
            throw a.AbstractC0232a.m(y10);
        }

        public d y() {
            d dVar = new d(this);
            int i10 = (this.f10011i & 1) != 1 ? 0 : 1;
            dVar.f10006i = this.f10012j;
            if ((this.f10011i & 2) == 2) {
                this.f10013k = Collections.unmodifiableList(this.f10013k);
                this.f10011i &= -3;
            }
            dVar.f10007j = this.f10013k;
            if ((this.f10011i & 4) == 4) {
                this.f10014l = Collections.unmodifiableList(this.f10014l);
                this.f10011i &= -5;
            }
            dVar.f10008k = this.f10014l;
            dVar.f10005h = i10;
            return dVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b n() {
            return A().p(y());
        }
    }

    static {
        d dVar = new d(true);
        f10002n = dVar;
        dVar.R();
    }

    private d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        List list;
        Object u10;
        this.f10009l = (byte) -1;
        this.f10010m = -1;
        R();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    int K = eVar.K();
                    if (K != 0) {
                        if (K != 8) {
                            if (K == 18) {
                                if ((i10 & 2) != 2) {
                                    this.f10007j = new ArrayList();
                                    i10 |= 2;
                                }
                                list = this.f10007j;
                                u10 = eVar.u(u.f10296r, gVar);
                            } else if (K == 248) {
                                if ((i10 & 4) != 4) {
                                    this.f10008k = new ArrayList();
                                    i10 |= 4;
                                }
                                list = this.f10008k;
                                u10 = Integer.valueOf(eVar.s());
                            } else if (K == 250) {
                                int j10 = eVar.j(eVar.A());
                                if ((i10 & 4) != 4 && eVar.e() > 0) {
                                    this.f10008k = new ArrayList();
                                    i10 |= 4;
                                }
                                while (eVar.e() > 0) {
                                    this.f10008k.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j10);
                            } else if (!q(eVar, J, gVar, K)) {
                            }
                            list.add(u10);
                        } else {
                            this.f10005h |= 1;
                            this.f10006i = eVar.s();
                        }
                    }
                    z10 = true;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if ((i10 & 2) == 2) {
                    this.f10007j = Collections.unmodifiableList(this.f10007j);
                }
                if ((i10 & 4) == 4) {
                    this.f10008k = Collections.unmodifiableList(this.f10008k);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f10004g = A.j();
                    throw th2;
                }
                this.f10004g = A.j();
                n();
                throw th;
            }
        }
        if ((i10 & 2) == 2) {
            this.f10007j = Collections.unmodifiableList(this.f10007j);
        }
        if ((i10 & 4) == 4) {
            this.f10008k = Collections.unmodifiableList(this.f10008k);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10004g = A.j();
            throw th3;
        }
        this.f10004g = A.j();
        n();
    }

    private d(i.c<d, ?> cVar) {
        super(cVar);
        this.f10009l = (byte) -1;
        this.f10010m = -1;
        this.f10004g = cVar.o();
    }

    private d(boolean z10) {
        this.f10009l = (byte) -1;
        this.f10010m = -1;
        this.f10004g = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static d J() {
        return f10002n;
    }

    private void R() {
        this.f10006i = 6;
        this.f10007j = Collections.emptyList();
        this.f10008k = Collections.emptyList();
    }

    public static b S() {
        return b.w();
    }

    public static b T(d dVar) {
        return S().p(dVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public d b() {
        return f10002n;
    }

    public int L() {
        return this.f10006i;
    }

    public u M(int i10) {
        return this.f10007j.get(i10);
    }

    public int N() {
        return this.f10007j.size();
    }

    public List<u> O() {
        return this.f10007j;
    }

    public List<Integer> P() {
        return this.f10008k;
    }

    public boolean Q() {
        return (this.f10005h & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public b h() {
        return S();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public b d() {
        return T(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10010m;
        if (i10 != -1) {
            return i10;
        }
        int o10 = (this.f10005h & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f10006i) + 0 : 0;
        for (int i11 = 0; i11 < this.f10007j.size(); i11++) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.f10007j.get(i11));
        }
        int i12 = 0;
        for (int i13 = 0; i13 < this.f10008k.size(); i13++) {
            i12 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.f10008k.get(i13).intValue());
        }
        int size = o10 + i12 + (P().size() * 2) + u() + this.f10004g.size();
        this.f10010m = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        i.d<MessageType>.a z10 = z();
        if ((this.f10005h & 1) == 1) {
            fVar.a0(1, this.f10006i);
        }
        for (int i10 = 0; i10 < this.f10007j.size(); i10++) {
            fVar.d0(2, this.f10007j.get(i10));
        }
        for (int i11 = 0; i11 < this.f10008k.size(); i11++) {
            fVar.a0(31, this.f10008k.get(i11).intValue());
        }
        z10.a(19000, fVar);
        fVar.i0(this.f10004g);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<d> i() {
        return f10003o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10009l;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        for (int i10 = 0; i10 < N(); i10++) {
            if (!M(i10).k()) {
                this.f10009l = (byte) 0;
                return false;
            }
        }
        if (t()) {
            this.f10009l = (byte) 1;
            return true;
        }
        this.f10009l = (byte) 0;
        return false;
    }
}
