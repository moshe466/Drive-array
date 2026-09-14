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
public final class b extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

    /* renamed from: l, reason: collision with root package name */
    private static final b f9914l;

    /* renamed from: m, reason: collision with root package name */
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<b> f9915m = new a();

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f9916f;

    /* renamed from: g, reason: collision with root package name */
    private int f9917g;

    /* renamed from: h, reason: collision with root package name */
    private int f9918h;

    /* renamed from: i, reason: collision with root package name */
    private List<C0176b> f9919i;

    /* renamed from: j, reason: collision with root package name */
    private byte f9920j;

    /* renamed from: k, reason: collision with root package name */
    private int f9921k;

    /* loaded from: classes.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<b> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public b c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            return new b(eVar, gVar);
        }
    }

    /* renamed from: ga.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0176b extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* renamed from: l, reason: collision with root package name */
        private static final C0176b f9922l;

        /* renamed from: m, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<C0176b> f9923m = new a();

        /* renamed from: f, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.protobuf.d f9924f;

        /* renamed from: g, reason: collision with root package name */
        private int f9925g;

        /* renamed from: h, reason: collision with root package name */
        private int f9926h;

        /* renamed from: i, reason: collision with root package name */
        private c f9927i;

        /* renamed from: j, reason: collision with root package name */
        private byte f9928j;

        /* renamed from: k, reason: collision with root package name */
        private int f9929k;

        /* renamed from: ga.b$b$a */
        /* loaded from: classes.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<C0176b> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public C0176b c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
                return new C0176b(eVar, gVar);
            }
        }

        /* renamed from: ga.b$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0177b extends i.b<C0176b, C0177b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

            /* renamed from: g, reason: collision with root package name */
            private int f9930g;

            /* renamed from: h, reason: collision with root package name */
            private int f9931h;

            /* renamed from: i, reason: collision with root package name */
            private c f9932i = c.N();

            private C0177b() {
                x();
            }

            static /* synthetic */ C0177b r() {
                return w();
            }

            private static C0177b w() {
                return new C0177b();
            }

            private void x() {
            }

            public C0177b A(c cVar) {
                if ((this.f9930g & 2) == 2 && this.f9932i != c.N()) {
                    cVar = c.h0(this.f9932i).p(cVar).t();
                }
                this.f9932i = cVar;
                this.f9930g |= 2;
                return this;
            }

            public C0177b B(int i10) {
                this.f9930g |= 1;
                this.f9931h = i10;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public C0176b c() {
                C0176b t10 = t();
                if (t10.k()) {
                    return t10;
                }
                throw a.AbstractC0232a.m(t10);
            }

            public C0176b t() {
                C0176b c0176b = new C0176b(this);
                int i10 = this.f9930g;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                c0176b.f9926h = this.f9931h;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                c0176b.f9927i = this.f9932i;
                c0176b.f9925g = i11;
                return c0176b;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public C0177b n() {
                return w().p(t());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public C0177b p(C0176b c0176b) {
                if (c0176b == C0176b.w()) {
                    return this;
                }
                if (c0176b.z()) {
                    B(c0176b.x());
                }
                if (c0176b.A()) {
                    A(c0176b.y());
                }
                q(o().f(c0176b.f9924f));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ga.b.C0176b.C0177b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.s<ga.b$b> r1 = ga.b.C0176b.f9923m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    ga.b$b r3 = (ga.b.C0176b) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                    ga.b$b r4 = (ga.b.C0176b) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ga.b.C0176b.C0177b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.b$b$b");
            }
        }

        /* renamed from: ga.b$b$c */
        /* loaded from: classes.dex */
        public static final class c extends kotlin.reflect.jvm.internal.impl.protobuf.i implements kotlin.reflect.jvm.internal.impl.protobuf.r {

            /* renamed from: u, reason: collision with root package name */
            private static final c f9933u;

            /* renamed from: v, reason: collision with root package name */
            public static kotlin.reflect.jvm.internal.impl.protobuf.s<c> f9934v = new a();

            /* renamed from: f, reason: collision with root package name */
            private final kotlin.reflect.jvm.internal.impl.protobuf.d f9935f;

            /* renamed from: g, reason: collision with root package name */
            private int f9936g;

            /* renamed from: h, reason: collision with root package name */
            private EnumC0179c f9937h;

            /* renamed from: i, reason: collision with root package name */
            private long f9938i;

            /* renamed from: j, reason: collision with root package name */
            private float f9939j;

            /* renamed from: k, reason: collision with root package name */
            private double f9940k;

            /* renamed from: l, reason: collision with root package name */
            private int f9941l;

            /* renamed from: m, reason: collision with root package name */
            private int f9942m;

            /* renamed from: n, reason: collision with root package name */
            private int f9943n;

            /* renamed from: o, reason: collision with root package name */
            private b f9944o;

            /* renamed from: p, reason: collision with root package name */
            private List<c> f9945p;

            /* renamed from: q, reason: collision with root package name */
            private int f9946q;

            /* renamed from: r, reason: collision with root package name */
            private int f9947r;

            /* renamed from: s, reason: collision with root package name */
            private byte f9948s;

            /* renamed from: t, reason: collision with root package name */
            private int f9949t;

            /* renamed from: ga.b$b$c$a */
            /* loaded from: classes.dex */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<c> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public c c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
                    return new c(eVar, gVar);
                }
            }

            /* renamed from: ga.b$b$c$b, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static final class C0178b extends i.b<c, C0178b> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

                /* renamed from: g, reason: collision with root package name */
                private int f9950g;

                /* renamed from: i, reason: collision with root package name */
                private long f9952i;

                /* renamed from: j, reason: collision with root package name */
                private float f9953j;

                /* renamed from: k, reason: collision with root package name */
                private double f9954k;

                /* renamed from: l, reason: collision with root package name */
                private int f9955l;

                /* renamed from: m, reason: collision with root package name */
                private int f9956m;

                /* renamed from: n, reason: collision with root package name */
                private int f9957n;

                /* renamed from: q, reason: collision with root package name */
                private int f9960q;

                /* renamed from: r, reason: collision with root package name */
                private int f9961r;

                /* renamed from: h, reason: collision with root package name */
                private EnumC0179c f9951h = EnumC0179c.BYTE;

                /* renamed from: o, reason: collision with root package name */
                private b f9958o = b.A();

                /* renamed from: p, reason: collision with root package name */
                private List<c> f9959p = Collections.emptyList();

                private C0178b() {
                    y();
                }

                static /* synthetic */ C0178b r() {
                    return w();
                }

                private static C0178b w() {
                    return new C0178b();
                }

                private void x() {
                    if ((this.f9950g & 256) != 256) {
                        this.f9959p = new ArrayList(this.f9959p);
                        this.f9950g |= 256;
                    }
                }

                private void y() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                /* renamed from: A, reason: merged with bridge method [inline-methods] */
                public C0178b p(c cVar) {
                    if (cVar == c.N()) {
                        return this;
                    }
                    if (cVar.e0()) {
                        O(cVar.U());
                    }
                    if (cVar.c0()) {
                        K(cVar.S());
                    }
                    if (cVar.b0()) {
                        J(cVar.R());
                    }
                    if (cVar.Y()) {
                        F(cVar.O());
                    }
                    if (cVar.d0()) {
                        L(cVar.T());
                    }
                    if (cVar.X()) {
                        E(cVar.M());
                    }
                    if (cVar.Z()) {
                        G(cVar.P());
                    }
                    if (cVar.V()) {
                        z(cVar.H());
                    }
                    if (!cVar.f9945p.isEmpty()) {
                        if (this.f9959p.isEmpty()) {
                            this.f9959p = cVar.f9945p;
                            this.f9950g &= -257;
                        } else {
                            x();
                            this.f9959p.addAll(cVar.f9945p);
                        }
                    }
                    if (cVar.W()) {
                        C(cVar.I());
                    }
                    if (cVar.a0()) {
                        I(cVar.Q());
                    }
                    q(o().f(cVar.f9935f));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
                /* renamed from: B, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public ga.b.C0176b.c.C0178b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
                    /*
                        r2 = this;
                        r0 = 0
                        kotlin.reflect.jvm.internal.impl.protobuf.s<ga.b$b$c> r1 = ga.b.C0176b.c.f9934v     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                        ga.b$b$c r3 = (ga.b.C0176b.c) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                        ga.b$b$c r4 = (ga.b.C0176b.c) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: ga.b.C0176b.c.C0178b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.b$b$c$b");
                }

                public C0178b C(int i10) {
                    this.f9950g |= 512;
                    this.f9960q = i10;
                    return this;
                }

                public C0178b E(int i10) {
                    this.f9950g |= 32;
                    this.f9956m = i10;
                    return this;
                }

                public C0178b F(double d10) {
                    this.f9950g |= 8;
                    this.f9954k = d10;
                    return this;
                }

                public C0178b G(int i10) {
                    this.f9950g |= 64;
                    this.f9957n = i10;
                    return this;
                }

                public C0178b I(int i10) {
                    this.f9950g |= 1024;
                    this.f9961r = i10;
                    return this;
                }

                public C0178b J(float f10) {
                    this.f9950g |= 4;
                    this.f9953j = f10;
                    return this;
                }

                public C0178b K(long j10) {
                    this.f9950g |= 2;
                    this.f9952i = j10;
                    return this;
                }

                public C0178b L(int i10) {
                    this.f9950g |= 16;
                    this.f9955l = i10;
                    return this;
                }

                public C0178b O(EnumC0179c enumC0179c) {
                    Objects.requireNonNull(enumC0179c);
                    this.f9950g |= 1;
                    this.f9951h = enumC0179c;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
                /* renamed from: s, reason: merged with bridge method [inline-methods] */
                public c c() {
                    c t10 = t();
                    if (t10.k()) {
                        return t10;
                    }
                    throw a.AbstractC0232a.m(t10);
                }

                public c t() {
                    c cVar = new c(this);
                    int i10 = this.f9950g;
                    int i11 = (i10 & 1) != 1 ? 0 : 1;
                    cVar.f9937h = this.f9951h;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    cVar.f9938i = this.f9952i;
                    if ((i10 & 4) == 4) {
                        i11 |= 4;
                    }
                    cVar.f9939j = this.f9953j;
                    if ((i10 & 8) == 8) {
                        i11 |= 8;
                    }
                    cVar.f9940k = this.f9954k;
                    if ((i10 & 16) == 16) {
                        i11 |= 16;
                    }
                    cVar.f9941l = this.f9955l;
                    if ((i10 & 32) == 32) {
                        i11 |= 32;
                    }
                    cVar.f9942m = this.f9956m;
                    if ((i10 & 64) == 64) {
                        i11 |= 64;
                    }
                    cVar.f9943n = this.f9957n;
                    if ((i10 & 128) == 128) {
                        i11 |= 128;
                    }
                    cVar.f9944o = this.f9958o;
                    if ((this.f9950g & 256) == 256) {
                        this.f9959p = Collections.unmodifiableList(this.f9959p);
                        this.f9950g &= -257;
                    }
                    cVar.f9945p = this.f9959p;
                    if ((i10 & 512) == 512) {
                        i11 |= 256;
                    }
                    cVar.f9946q = this.f9960q;
                    if ((i10 & 1024) == 1024) {
                        i11 |= 512;
                    }
                    cVar.f9947r = this.f9961r;
                    cVar.f9936g = i11;
                    return cVar;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                /* renamed from: u, reason: merged with bridge method [inline-methods] */
                public C0178b n() {
                    return w().p(t());
                }

                public C0178b z(b bVar) {
                    if ((this.f9950g & 128) == 128 && this.f9958o != b.A()) {
                        bVar = b.G(this.f9958o).p(bVar).t();
                    }
                    this.f9958o = bVar;
                    this.f9950g |= 128;
                    return this;
                }
            }

            /* renamed from: ga.b$b$c$c, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public enum EnumC0179c implements j.a {
                BYTE(0, 0),
                CHAR(1, 1),
                SHORT(2, 2),
                INT(3, 3),
                LONG(4, 4),
                FLOAT(5, 5),
                DOUBLE(6, 6),
                BOOLEAN(7, 7),
                STRING(8, 8),
                CLASS(9, 9),
                ENUM(10, 10),
                ANNOTATION(11, 11),
                ARRAY(12, 12);

                private static j.b<EnumC0179c> internalValueMap = new a();
                private final int value;

                /* renamed from: ga.b$b$c$c$a */
                /* loaded from: classes.dex */
                static class a implements j.b<EnumC0179c> {
                    a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public EnumC0179c a(int i10) {
                        return EnumC0179c.valueOf(i10);
                    }
                }

                EnumC0179c(int i10, int i11) {
                    this.value = i11;
                }

                public static EnumC0179c valueOf(int i10) {
                    switch (i10) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case 11:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
                public final int getNumber() {
                    return this.value;
                }
            }

            static {
                c cVar = new c(true);
                f9933u = cVar;
                cVar.f0();
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001e. Please report as an issue. */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
            private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
                this.f9948s = (byte) -1;
                this.f9949t = -1;
                f0();
                d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
                kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
                boolean z10 = false;
                int i10 = 0;
                while (true) {
                    ?? r52 = 256;
                    if (z10) {
                        if ((i10 & 256) == 256) {
                            this.f9945p = Collections.unmodifiableList(this.f9945p);
                        }
                        try {
                            J.I();
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            this.f9935f = A.j();
                            throw th;
                        }
                        this.f9935f = A.j();
                        n();
                        return;
                    }
                    try {
                        try {
                            int K = eVar.K();
                            switch (K) {
                                case 0:
                                    z10 = true;
                                case 8:
                                    int n10 = eVar.n();
                                    EnumC0179c valueOf = EnumC0179c.valueOf(n10);
                                    if (valueOf == null) {
                                        J.o0(K);
                                        J.o0(n10);
                                    } else {
                                        this.f9936g |= 1;
                                        this.f9937h = valueOf;
                                    }
                                case 16:
                                    this.f9936g |= 2;
                                    this.f9938i = eVar.H();
                                case 29:
                                    this.f9936g |= 4;
                                    this.f9939j = eVar.q();
                                case 33:
                                    this.f9936g |= 8;
                                    this.f9940k = eVar.m();
                                case androidx.constraintlayout.widget.j.Y4 /* 40 */:
                                    this.f9936g |= 16;
                                    this.f9941l = eVar.s();
                                case androidx.constraintlayout.widget.j.f1979g5 /* 48 */:
                                    this.f9936g |= 32;
                                    this.f9942m = eVar.s();
                                case 56:
                                    this.f9936g |= 64;
                                    this.f9943n = eVar.s();
                                case 66:
                                    c d10 = (this.f9936g & 128) == 128 ? this.f9944o.d() : null;
                                    b bVar = (b) eVar.u(b.f9915m, gVar);
                                    this.f9944o = bVar;
                                    if (d10 != null) {
                                        d10.p(bVar);
                                        this.f9944o = d10.t();
                                    }
                                    this.f9936g |= 128;
                                case 74:
                                    if ((i10 & 256) != 256) {
                                        this.f9945p = new ArrayList();
                                        i10 |= 256;
                                    }
                                    this.f9945p.add(eVar.u(f9934v, gVar));
                                case 80:
                                    this.f9936g |= 512;
                                    this.f9947r = eVar.s();
                                case 88:
                                    this.f9936g |= 256;
                                    this.f9946q = eVar.s();
                                default:
                                    r52 = q(eVar, J, gVar, K);
                                    if (r52 == 0) {
                                        z10 = true;
                                    }
                            }
                        } catch (Throwable th2) {
                            if ((i10 & 256) == r52) {
                                this.f9945p = Collections.unmodifiableList(this.f9945p);
                            }
                            try {
                                J.I();
                            } catch (IOException unused2) {
                            } catch (Throwable th3) {
                                this.f9935f = A.j();
                                throw th3;
                            }
                            this.f9935f = A.j();
                            n();
                            throw th2;
                        }
                    } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                        throw e10.i(this);
                    } catch (IOException e11) {
                        throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
                    }
                }
            }

            private c(i.b bVar) {
                super(bVar);
                this.f9948s = (byte) -1;
                this.f9949t = -1;
                this.f9935f = bVar.o();
            }

            private c(boolean z10) {
                this.f9948s = (byte) -1;
                this.f9949t = -1;
                this.f9935f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
            }

            public static c N() {
                return f9933u;
            }

            private void f0() {
                this.f9937h = EnumC0179c.BYTE;
                this.f9938i = 0L;
                this.f9939j = 0.0f;
                this.f9940k = 0.0d;
                this.f9941l = 0;
                this.f9942m = 0;
                this.f9943n = 0;
                this.f9944o = b.A();
                this.f9945p = Collections.emptyList();
                this.f9946q = 0;
                this.f9947r = 0;
            }

            public static C0178b g0() {
                return C0178b.r();
            }

            public static C0178b h0(c cVar) {
                return g0().p(cVar);
            }

            public b H() {
                return this.f9944o;
            }

            public int I() {
                return this.f9946q;
            }

            public c J(int i10) {
                return this.f9945p.get(i10);
            }

            public int K() {
                return this.f9945p.size();
            }

            public List<c> L() {
                return this.f9945p;
            }

            public int M() {
                return this.f9942m;
            }

            public double O() {
                return this.f9940k;
            }

            public int P() {
                return this.f9943n;
            }

            public int Q() {
                return this.f9947r;
            }

            public float R() {
                return this.f9939j;
            }

            public long S() {
                return this.f9938i;
            }

            public int T() {
                return this.f9941l;
            }

            public EnumC0179c U() {
                return this.f9937h;
            }

            public boolean V() {
                return (this.f9936g & 128) == 128;
            }

            public boolean W() {
                return (this.f9936g & 256) == 256;
            }

            public boolean X() {
                return (this.f9936g & 32) == 32;
            }

            public boolean Y() {
                return (this.f9936g & 8) == 8;
            }

            public boolean Z() {
                return (this.f9936g & 64) == 64;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            public int a() {
                int i10 = this.f9949t;
                if (i10 != -1) {
                    return i10;
                }
                int h10 = (this.f9936g & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.h(1, this.f9937h.getNumber()) + 0 : 0;
                if ((this.f9936g & 2) == 2) {
                    h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.A(2, this.f9938i);
                }
                if ((this.f9936g & 4) == 4) {
                    h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.l(3, this.f9939j);
                }
                if ((this.f9936g & 8) == 8) {
                    h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.f(4, this.f9940k);
                }
                if ((this.f9936g & 16) == 16) {
                    h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(5, this.f9941l);
                }
                if ((this.f9936g & 32) == 32) {
                    h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(6, this.f9942m);
                }
                if ((this.f9936g & 64) == 64) {
                    h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(7, this.f9943n);
                }
                if ((this.f9936g & 128) == 128) {
                    h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(8, this.f9944o);
                }
                for (int i11 = 0; i11 < this.f9945p.size(); i11++) {
                    h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(9, this.f9945p.get(i11));
                }
                if ((this.f9936g & 512) == 512) {
                    h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(10, this.f9947r);
                }
                if ((this.f9936g & 256) == 256) {
                    h10 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(11, this.f9946q);
                }
                int size = h10 + this.f9935f.size();
                this.f9949t = size;
                return size;
            }

            public boolean a0() {
                return (this.f9936g & 512) == 512;
            }

            public boolean b0() {
                return (this.f9936g & 4) == 4;
            }

            public boolean c0() {
                return (this.f9936g & 2) == 2;
            }

            public boolean d0() {
                return (this.f9936g & 16) == 16;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
                a();
                if ((this.f9936g & 1) == 1) {
                    fVar.S(1, this.f9937h.getNumber());
                }
                if ((this.f9936g & 2) == 2) {
                    fVar.t0(2, this.f9938i);
                }
                if ((this.f9936g & 4) == 4) {
                    fVar.W(3, this.f9939j);
                }
                if ((this.f9936g & 8) == 8) {
                    fVar.Q(4, this.f9940k);
                }
                if ((this.f9936g & 16) == 16) {
                    fVar.a0(5, this.f9941l);
                }
                if ((this.f9936g & 32) == 32) {
                    fVar.a0(6, this.f9942m);
                }
                if ((this.f9936g & 64) == 64) {
                    fVar.a0(7, this.f9943n);
                }
                if ((this.f9936g & 128) == 128) {
                    fVar.d0(8, this.f9944o);
                }
                for (int i10 = 0; i10 < this.f9945p.size(); i10++) {
                    fVar.d0(9, this.f9945p.get(i10));
                }
                if ((this.f9936g & 512) == 512) {
                    fVar.a0(10, this.f9947r);
                }
                if ((this.f9936g & 256) == 256) {
                    fVar.a0(11, this.f9946q);
                }
                fVar.i0(this.f9935f);
            }

            public boolean e0() {
                return (this.f9936g & 1) == 1;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
            public kotlin.reflect.jvm.internal.impl.protobuf.s<c> i() {
                return f9934v;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            /* renamed from: i0, reason: merged with bridge method [inline-methods] */
            public C0178b h() {
                return g0();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            /* renamed from: j0, reason: merged with bridge method [inline-methods] */
            public C0178b d() {
                return h0(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
            public final boolean k() {
                byte b10 = this.f9948s;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                if (V() && !H().k()) {
                    this.f9948s = (byte) 0;
                    return false;
                }
                for (int i10 = 0; i10 < K(); i10++) {
                    if (!J(i10).k()) {
                        this.f9948s = (byte) 0;
                        return false;
                    }
                }
                this.f9948s = (byte) 1;
                return true;
            }
        }

        static {
            C0176b c0176b = new C0176b(true);
            f9922l = c0176b;
            c0176b.B();
        }

        private C0176b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
            this.f9928j = (byte) -1;
            this.f9929k = -1;
            B();
            d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
            kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.f9925g |= 1;
                                    this.f9926h = eVar.s();
                                } else if (K == 18) {
                                    c.C0178b d10 = (this.f9925g & 2) == 2 ? this.f9927i.d() : null;
                                    c cVar = (c) eVar.u(c.f9934v, gVar);
                                    this.f9927i = cVar;
                                    if (d10 != null) {
                                        d10.p(cVar);
                                        this.f9927i = d10.t();
                                    }
                                    this.f9925g |= 2;
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
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f9924f = A.j();
                        throw th2;
                    }
                    this.f9924f = A.j();
                    n();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f9924f = A.j();
                throw th3;
            }
            this.f9924f = A.j();
            n();
        }

        private C0176b(i.b bVar) {
            super(bVar);
            this.f9928j = (byte) -1;
            this.f9929k = -1;
            this.f9924f = bVar.o();
        }

        private C0176b(boolean z10) {
            this.f9928j = (byte) -1;
            this.f9929k = -1;
            this.f9924f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
        }

        private void B() {
            this.f9926h = 0;
            this.f9927i = c.N();
        }

        public static C0177b C() {
            return C0177b.r();
        }

        public static C0177b E(C0176b c0176b) {
            return C().p(c0176b);
        }

        public static C0176b w() {
            return f9922l;
        }

        public boolean A() {
            return (this.f9925g & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public C0177b h() {
            return C();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public C0177b d() {
            return E(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int a() {
            int i10 = this.f9929k;
            if (i10 != -1) {
                return i10;
            }
            int o10 = (this.f9925g & 1) == 1 ? 0 + kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f9926h) : 0;
            if ((this.f9925g & 2) == 2) {
                o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.f9927i);
            }
            int size = o10 + this.f9924f.size();
            this.f9929k = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
            a();
            if ((this.f9925g & 1) == 1) {
                fVar.a0(1, this.f9926h);
            }
            if ((this.f9925g & 2) == 2) {
                fVar.d0(2, this.f9927i);
            }
            fVar.i0(this.f9924f);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<C0176b> i() {
            return f9923m;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
        public final boolean k() {
            byte b10 = this.f9928j;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (!z()) {
                this.f9928j = (byte) 0;
                return false;
            }
            if (!A()) {
                this.f9928j = (byte) 0;
                return false;
            }
            if (y().k()) {
                this.f9928j = (byte) 1;
                return true;
            }
            this.f9928j = (byte) 0;
            return false;
        }

        public int x() {
            return this.f9926h;
        }

        public c y() {
            return this.f9927i;
        }

        public boolean z() {
            return (this.f9925g & 1) == 1;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends i.b<b, c> implements kotlin.reflect.jvm.internal.impl.protobuf.r {

        /* renamed from: g, reason: collision with root package name */
        private int f9962g;

        /* renamed from: h, reason: collision with root package name */
        private int f9963h;

        /* renamed from: i, reason: collision with root package name */
        private List<C0176b> f9964i = Collections.emptyList();

        private c() {
            y();
        }

        static /* synthetic */ c r() {
            return w();
        }

        private static c w() {
            return new c();
        }

        private void x() {
            if ((this.f9962g & 2) != 2) {
                this.f9964i = new ArrayList(this.f9964i);
                this.f9962g |= 2;
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
        public ga.b.c l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.b> r1 = ga.b.f9915m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.b r3 = (ga.b) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.b r4 = (ga.b) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.b.c.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.b$c");
        }

        public c B(int i10) {
            this.f9962g |= 1;
            this.f9963h = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public b c() {
            b t10 = t();
            if (t10.k()) {
                return t10;
            }
            throw a.AbstractC0232a.m(t10);
        }

        public b t() {
            b bVar = new b(this);
            int i10 = (this.f9962g & 1) != 1 ? 0 : 1;
            bVar.f9918h = this.f9963h;
            if ((this.f9962g & 2) == 2) {
                this.f9964i = Collections.unmodifiableList(this.f9964i);
                this.f9962g &= -3;
            }
            bVar.f9919i = this.f9964i;
            bVar.f9917g = i10;
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public c n() {
            return w().p(t());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] */
        public c p(b bVar) {
            if (bVar == b.A()) {
                return this;
            }
            if (bVar.C()) {
                B(bVar.B());
            }
            if (!bVar.f9919i.isEmpty()) {
                if (this.f9964i.isEmpty()) {
                    this.f9964i = bVar.f9919i;
                    this.f9962g &= -3;
                } else {
                    x();
                    this.f9964i.addAll(bVar.f9919i);
                }
            }
            q(o().f(bVar.f9916f));
            return this;
        }
    }

    static {
        b bVar = new b(true);
        f9914l = bVar;
        bVar.E();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        this.f9920j = (byte) -1;
        this.f9921k = -1;
        E();
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
                            this.f9917g |= 1;
                            this.f9918h = eVar.s();
                        } else if (K == 18) {
                            if ((i10 & 2) != 2) {
                                this.f9919i = new ArrayList();
                                i10 |= 2;
                            }
                            this.f9919i.add(eVar.u(C0176b.f9923m, gVar));
                        } else if (!q(eVar, J, gVar, K)) {
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((i10 & 2) == 2) {
                        this.f9919i = Collections.unmodifiableList(this.f9919i);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f9916f = A.j();
                        throw th2;
                    }
                    this.f9916f = A.j();
                    n();
                    throw th;
                }
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
            }
        }
        if ((i10 & 2) == 2) {
            this.f9919i = Collections.unmodifiableList(this.f9919i);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f9916f = A.j();
            throw th3;
        }
        this.f9916f = A.j();
        n();
    }

    private b(i.b bVar) {
        super(bVar);
        this.f9920j = (byte) -1;
        this.f9921k = -1;
        this.f9916f = bVar.o();
    }

    private b(boolean z10) {
        this.f9920j = (byte) -1;
        this.f9921k = -1;
        this.f9916f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    public static b A() {
        return f9914l;
    }

    private void E() {
        this.f9918h = 0;
        this.f9919i = Collections.emptyList();
    }

    public static c F() {
        return c.r();
    }

    public static c G(b bVar) {
        return F().p(bVar);
    }

    public int B() {
        return this.f9918h;
    }

    public boolean C() {
        return (this.f9917g & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public c h() {
        return F();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public c d() {
        return G(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.f9921k;
        if (i10 != -1) {
            return i10;
        }
        int o10 = (this.f9917g & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f9918h) + 0 : 0;
        for (int i11 = 0; i11 < this.f9919i.size(); i11++) {
            o10 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(2, this.f9919i.get(i11));
        }
        int size = o10 + this.f9916f.size();
        this.f9921k = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        if ((this.f9917g & 1) == 1) {
            fVar.a0(1, this.f9918h);
        }
        for (int i10 = 0; i10 < this.f9919i.size(); i10++) {
            fVar.d0(2, this.f9919i.get(i10));
        }
        fVar.i0(this.f9916f);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<b> i() {
        return f9915m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.f9920j;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!C()) {
            this.f9920j = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < y(); i10++) {
            if (!x(i10).k()) {
                this.f9920j = (byte) 0;
                return false;
            }
        }
        this.f9920j = (byte) 1;
        return true;
    }

    public C0176b x(int i10) {
        return this.f9919i.get(i10);
    }

    public int y() {
        return this.f9919i.size();
    }

    public List<C0176b> z() {
        return this.f9919i;
    }
}
