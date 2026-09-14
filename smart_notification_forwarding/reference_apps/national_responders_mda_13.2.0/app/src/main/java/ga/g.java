package ga;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* loaded from: classes.dex */
public final class g extends i.d<g> {

    /* renamed from: l, reason: collision with root package name */
    private static final g f10038l;

    /* renamed from: m, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<g> f10039m = new a();

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10040g;

    /* renamed from: h, reason: collision with root package name */
    private int f10041h;

    /* renamed from: i, reason: collision with root package name */
    private int f10042i;

    /* renamed from: j, reason: collision with root package name */
    private byte f10043j;

    /* renamed from: k, reason: collision with root package name */
    private int f10044k;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<g> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public g c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new g(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.c<g, b> {

        /* renamed from: i, reason: collision with root package name */
        private int f10045i;

        /* renamed from: j, reason: collision with root package name */
        private int f10046j;

        private b() {
            B();
        }

        private static b A() {
            return new b();
        }

        private void B() {
        }

        static /* synthetic */ b w() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public b p(g gVar) {
            if (gVar == g.F()) {
                return this;
            }
            if (gVar.I()) {
                F(gVar.H());
            }
            u(gVar);
            q(o().f(gVar.f10040g));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.g.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.g> r1 = ga.g.f10039m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.g r3 = (ga.g) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.g r4 = (ga.g) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.g.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.g$b");
        }

        public b F(int i10) {
            this.f10045i |= 1;
            this.f10046j = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public g c() {
            g y10 = y();
            if (y10.k()) {
                return y10;
            }
            throw a.AbstractC0232a.m(y10);
        }

        public g y() {
            g gVar = new g(this);
            int i10 = (this.f10045i & 1) != 1 ? 0 : 1;
            gVar.f10042i = this.f10046j;
            gVar.f10041h = i10;
            return gVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b n() {
            return A().p(y());
        }
    }

    static {
        g gVar = new g(true);
        f10038l = gVar;
        gVar.J();
    }

    private g(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.f10043j = (byte) -1;
        this.f10044k = -1;
        J();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int K = eVar.K();
                    if (K != 0) {
                        if (K == 8) {
                            this.f10041h |= 1;
                            this.f10042i = eVar.s();
                        } else if (!q(eVar, J, gVar, K)) {
                        }
                    }
                    z10 = true;
                } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
                }
            } catch (Throwable th) {
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f10040g = A.j();
                    throw th2;
                }
                this.f10040g = A.j();
                n();
                throw th;
            }
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10040g = A.j();
            throw th3;
        }
        this.f10040g = A.j();
        n();
    }

    private g(i.c<g, ?> cVar) {
        super(cVar);
        this.f10043j = (byte) -1;
        this.f10044k = -1;
        this.f10040g = cVar.o();
    }

    private g(boolean z10) {
        this.f10043j = (byte) -1;
        this.f10044k = -1;
        this.f10040g = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static g F() {
        return f10038l;
    }

    private void J() {
        this.f10042i = 0;
    }

    public static b K() {
        return b.w();
    }

    public static b L(g gVar) {
        return K().p(gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public g b() {
        return f10038l;
    }

    public int H() {
        return this.f10042i;
    }

    public boolean I() {
        return (this.f10041h & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public b h() {
        return K();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public b d() {
        return L(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f10044k;
        if (i10 != -1) {
            return i10;
        }
        int o10 = ((this.f10041h & 1) == 1 ? 0 + kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f10042i) : 0) + u() + this.f10040g.size();
        this.f10044k = o10;
        return o10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        i.d<MessageType>.a z10 = z();
        if ((this.f10041h & 1) == 1) {
            fVar.a0(1, this.f10042i);
        }
        z10.a(200, fVar);
        fVar.i0(this.f10040g);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<g> i() {
        return f10039m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10043j;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (t()) {
            this.f10043j = (byte) 1;
            return true;
        }
        this.f10043j = (byte) 0;
        return false;
    }
}
