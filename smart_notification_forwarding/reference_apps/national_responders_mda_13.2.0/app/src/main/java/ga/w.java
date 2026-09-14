package ga;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;

/* loaded from: classes.dex */
public final class w extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* renamed from: j, reason: collision with root package name */
    private static final w f10333j;

    /* renamed from: k, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<w> f10334k = new a();

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f10335f;

    /* renamed from: g, reason: collision with root package name */
    private List<v> f10336g;

    /* renamed from: h, reason: collision with root package name */
    private byte f10337h;

    /* renamed from: i, reason: collision with root package name */
    private int f10338i;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<w> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public w c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new w(eVar, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends i.b<w, b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* renamed from: g, reason: collision with root package name */
        private int f10339g;

        /* renamed from: h, reason: collision with root package name */
        private List<v> f10340h = Collections.emptyList();

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
            if ((this.f10339g & 1) != 1) {
                this.f10340h = new ArrayList(this.f10340h);
                this.f10339g |= 1;
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
        public ga.w.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.w> r1 = ga.w.f10334k     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.w r3 = (ga.w) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.w r4 = (ga.w) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.w.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.w$b");
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public w c() {
            w t10 = t();
            if (t10.k()) {
                return t10;
            }
            throw a.AbstractC0232a.m(t10);
        }

        public w t() {
            w wVar = new w(this);
            if ((this.f10339g & 1) == 1) {
                this.f10340h = Collections.unmodifiableList(this.f10340h);
                this.f10339g &= -2;
            }
            wVar.f10336g = this.f10340h;
            return wVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b n() {
            return w().p(t());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public b p(w wVar) {
            if (wVar == w.v()) {
                return this;
            }
            if (!wVar.f10336g.isEmpty()) {
                if (this.f10340h.isEmpty()) {
                    this.f10340h = wVar.f10336g;
                    this.f10339g &= -2;
                } else {
                    x();
                    this.f10340h.addAll(wVar.f10336g);
                }
            }
            q(o().f(wVar.f10335f));
            return this;
        }
    }

    static {
        w wVar = new w(true);
        f10333j = wVar;
        wVar.y();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private w(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.f10337h = (byte) -1;
        this.f10338i = -1;
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
                                if (!(z11 & true)) {
                                    this.f10336g = new ArrayList();
                                    z11 |= true;
                                }
                                this.f10336g.add(eVar.u(v.f10315q, gVar));
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
                    this.f10336g = Collections.unmodifiableList(this.f10336g);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f10335f = A.j();
                    throw th2;
                }
                this.f10335f = A.j();
                n();
                throw th;
            }
        }
        if (z11 & true) {
            this.f10336g = Collections.unmodifiableList(this.f10336g);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f10335f = A.j();
            throw th3;
        }
        this.f10335f = A.j();
        n();
    }

    private w(i.b bVar) {
        super(bVar);
        this.f10337h = (byte) -1;
        this.f10338i = -1;
        this.f10335f = bVar.o();
    }

    private w(boolean z10) {
        this.f10337h = (byte) -1;
        this.f10338i = -1;
        this.f10335f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static b A(w wVar) {
        return z().p(wVar);
    }

    public static w v() {
        return f10333j;
    }

    private void y() {
        this.f10336g = Collections.emptyList();
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
        int i10 = this.f10338i;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f10336g.size(); i12++) {
            i11 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(1, this.f10336g.get(i12));
        }
        int size = i11 + this.f10335f.size();
        this.f10338i = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        for (int i10 = 0; i10 < this.f10336g.size(); i10++) {
            fVar.d0(1, this.f10336g.get(i10));
        }
        fVar.i0(this.f10335f);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<w> i() {
        return f10334k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f10337h;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        this.f10337h = (byte) 1;
        return true;
    }

    public int w() {
        return this.f10336g.size();
    }

    public List<v> x() {
        return this.f10336g;
    }
}
