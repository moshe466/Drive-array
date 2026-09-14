package ga;

import ga.t;
import ga.w;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.j;

/* loaded from: classes.dex */
public final class c extends i.d<c> {
    private static final c D;
    public static kotlin.reflect.jvm.internal.impl.protobuf.s<c> E = new a();
    private w A;
    private byte B;
    private int C;

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f9965g;

    /* renamed from: h, reason: collision with root package name */
    private int f9966h;

    /* renamed from: i, reason: collision with root package name */
    private int f9967i;

    /* renamed from: j, reason: collision with root package name */
    private int f9968j;

    /* renamed from: k, reason: collision with root package name */
    private int f9969k;

    /* renamed from: l, reason: collision with root package name */
    private List<s> f9970l;

    /* renamed from: m, reason: collision with root package name */
    private List<q> f9971m;

    /* renamed from: n, reason: collision with root package name */
    private List<Integer> f9972n;

    /* renamed from: o, reason: collision with root package name */
    private int f9973o;

    /* renamed from: p, reason: collision with root package name */
    private List<Integer> f9974p;

    /* renamed from: q, reason: collision with root package name */
    private int f9975q;

    /* renamed from: r, reason: collision with root package name */
    private List<d> f9976r;

    /* renamed from: s, reason: collision with root package name */
    private List<i> f9977s;

    /* renamed from: t, reason: collision with root package name */
    private List<n> f9978t;

    /* renamed from: u, reason: collision with root package name */
    private List<r> f9979u;

    /* renamed from: v, reason: collision with root package name */
    private List<g> f9980v;

    /* renamed from: w, reason: collision with root package name */
    private List<Integer> f9981w;

    /* renamed from: x, reason: collision with root package name */
    private int f9982x;

    /* renamed from: y, reason: collision with root package name */
    private t f9983y;

    /* renamed from: z, reason: collision with root package name */
    private List<Integer> f9984z;

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

    /* loaded from: classes.dex */
    public static final class b extends i.c<c, b> {

        /* renamed from: i, reason: collision with root package name */
        private int f9985i;

        /* renamed from: k, reason: collision with root package name */
        private int f9987k;

        /* renamed from: l, reason: collision with root package name */
        private int f9988l;

        /* renamed from: j, reason: collision with root package name */
        private int f9986j = 6;

        /* renamed from: m, reason: collision with root package name */
        private List<s> f9989m = Collections.emptyList();

        /* renamed from: n, reason: collision with root package name */
        private List<q> f9990n = Collections.emptyList();

        /* renamed from: o, reason: collision with root package name */
        private List<Integer> f9991o = Collections.emptyList();

        /* renamed from: p, reason: collision with root package name */
        private List<Integer> f9992p = Collections.emptyList();

        /* renamed from: q, reason: collision with root package name */
        private List<d> f9993q = Collections.emptyList();

        /* renamed from: r, reason: collision with root package name */
        private List<i> f9994r = Collections.emptyList();

        /* renamed from: s, reason: collision with root package name */
        private List<n> f9995s = Collections.emptyList();

        /* renamed from: t, reason: collision with root package name */
        private List<r> f9996t = Collections.emptyList();

        /* renamed from: u, reason: collision with root package name */
        private List<g> f9997u = Collections.emptyList();

        /* renamed from: v, reason: collision with root package name */
        private List<Integer> f9998v = Collections.emptyList();

        /* renamed from: w, reason: collision with root package name */
        private t f9999w = t.x();

        /* renamed from: x, reason: collision with root package name */
        private List<Integer> f10000x = Collections.emptyList();

        /* renamed from: y, reason: collision with root package name */
        private w f10001y = w.v();

        private b() {
            Q();
        }

        private static b A() {
            return new b();
        }

        private void B() {
            if ((this.f9985i & 128) != 128) {
                this.f9993q = new ArrayList(this.f9993q);
                this.f9985i |= 128;
            }
        }

        private void C() {
            if ((this.f9985i & 2048) != 2048) {
                this.f9997u = new ArrayList(this.f9997u);
                this.f9985i |= 2048;
            }
        }

        private void E() {
            if ((this.f9985i & 256) != 256) {
                this.f9994r = new ArrayList(this.f9994r);
                this.f9985i |= 256;
            }
        }

        private void F() {
            if ((this.f9985i & 64) != 64) {
                this.f9992p = new ArrayList(this.f9992p);
                this.f9985i |= 64;
            }
        }

        private void G() {
            if ((this.f9985i & 512) != 512) {
                this.f9995s = new ArrayList(this.f9995s);
                this.f9985i |= 512;
            }
        }

        private void I() {
            if ((this.f9985i & 4096) != 4096) {
                this.f9998v = new ArrayList(this.f9998v);
                this.f9985i |= 4096;
            }
        }

        private void J() {
            if ((this.f9985i & 32) != 32) {
                this.f9991o = new ArrayList(this.f9991o);
                this.f9985i |= 32;
            }
        }

        private void K() {
            if ((this.f9985i & 16) != 16) {
                this.f9990n = new ArrayList(this.f9990n);
                this.f9985i |= 16;
            }
        }

        private void L() {
            if ((this.f9985i & 1024) != 1024) {
                this.f9996t = new ArrayList(this.f9996t);
                this.f9985i |= 1024;
            }
        }

        private void O() {
            if ((this.f9985i & 8) != 8) {
                this.f9989m = new ArrayList(this.f9989m);
                this.f9985i |= 8;
            }
        }

        private void P() {
            if ((this.f9985i & 16384) != 16384) {
                this.f10000x = new ArrayList(this.f10000x);
                this.f9985i |= 16384;
            }
        }

        private void Q() {
        }

        static /* synthetic */ b w() {
            return A();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: R, reason: merged with bridge method [inline-methods] */
        public b p(c cVar) {
            if (cVar == c.j0()) {
                return this;
            }
            if (cVar.M0()) {
                W(cVar.o0());
            }
            if (cVar.N0()) {
                X(cVar.p0());
            }
            if (cVar.L0()) {
                V(cVar.f0());
            }
            if (!cVar.f9970l.isEmpty()) {
                if (this.f9989m.isEmpty()) {
                    this.f9989m = cVar.f9970l;
                    this.f9985i &= -9;
                } else {
                    O();
                    this.f9989m.addAll(cVar.f9970l);
                }
            }
            if (!cVar.f9971m.isEmpty()) {
                if (this.f9990n.isEmpty()) {
                    this.f9990n = cVar.f9971m;
                    this.f9985i &= -17;
                } else {
                    K();
                    this.f9990n.addAll(cVar.f9971m);
                }
            }
            if (!cVar.f9972n.isEmpty()) {
                if (this.f9991o.isEmpty()) {
                    this.f9991o = cVar.f9972n;
                    this.f9985i &= -33;
                } else {
                    J();
                    this.f9991o.addAll(cVar.f9972n);
                }
            }
            if (!cVar.f9974p.isEmpty()) {
                if (this.f9992p.isEmpty()) {
                    this.f9992p = cVar.f9974p;
                    this.f9985i &= -65;
                } else {
                    F();
                    this.f9992p.addAll(cVar.f9974p);
                }
            }
            if (!cVar.f9976r.isEmpty()) {
                if (this.f9993q.isEmpty()) {
                    this.f9993q = cVar.f9976r;
                    this.f9985i &= -129;
                } else {
                    B();
                    this.f9993q.addAll(cVar.f9976r);
                }
            }
            if (!cVar.f9977s.isEmpty()) {
                if (this.f9994r.isEmpty()) {
                    this.f9994r = cVar.f9977s;
                    this.f9985i &= -257;
                } else {
                    E();
                    this.f9994r.addAll(cVar.f9977s);
                }
            }
            if (!cVar.f9978t.isEmpty()) {
                if (this.f9995s.isEmpty()) {
                    this.f9995s = cVar.f9978t;
                    this.f9985i &= -513;
                } else {
                    G();
                    this.f9995s.addAll(cVar.f9978t);
                }
            }
            if (!cVar.f9979u.isEmpty()) {
                if (this.f9996t.isEmpty()) {
                    this.f9996t = cVar.f9979u;
                    this.f9985i &= -1025;
                } else {
                    L();
                    this.f9996t.addAll(cVar.f9979u);
                }
            }
            if (!cVar.f9980v.isEmpty()) {
                if (this.f9997u.isEmpty()) {
                    this.f9997u = cVar.f9980v;
                    this.f9985i &= -2049;
                } else {
                    C();
                    this.f9997u.addAll(cVar.f9980v);
                }
            }
            if (!cVar.f9981w.isEmpty()) {
                if (this.f9998v.isEmpty()) {
                    this.f9998v = cVar.f9981w;
                    this.f9985i &= -4097;
                } else {
                    I();
                    this.f9998v.addAll(cVar.f9981w);
                }
            }
            if (cVar.O0()) {
                T(cVar.I0());
            }
            if (!cVar.f9984z.isEmpty()) {
                if (this.f10000x.isEmpty()) {
                    this.f10000x = cVar.f9984z;
                    this.f9985i &= -16385;
                } else {
                    P();
                    this.f10000x.addAll(cVar.f9984z);
                }
            }
            if (cVar.P0()) {
                U(cVar.K0());
            }
            u(cVar);
            q(o().f(cVar.f9965g));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
        /* renamed from: S, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ga.c.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
            /*
                r2 = this;
                r0 = 0
                kotlin.reflect.jvm.internal.impl.protobuf.s<ga.c> r1 = ga.c.E     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                ga.c r3 = (ga.c) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                ga.c r4 = (ga.c) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ga.c.b.D(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ga.c$b");
        }

        public b T(t tVar) {
            if ((this.f9985i & 8192) == 8192 && this.f9999w != t.x()) {
                tVar = t.G(this.f9999w).p(tVar).t();
            }
            this.f9999w = tVar;
            this.f9985i |= 8192;
            return this;
        }

        public b U(w wVar) {
            if ((this.f9985i & 32768) == 32768 && this.f10001y != w.v()) {
                wVar = w.A(this.f10001y).p(wVar).t();
            }
            this.f10001y = wVar;
            this.f9985i |= 32768;
            return this;
        }

        public b V(int i10) {
            this.f9985i |= 4;
            this.f9988l = i10;
            return this;
        }

        public b W(int i10) {
            this.f9985i |= 1;
            this.f9986j = i10;
            return this;
        }

        public b X(int i10) {
            this.f9985i |= 2;
            this.f9987k = i10;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public c c() {
            c y10 = y();
            if (y10.k()) {
                return y10;
            }
            throw a.AbstractC0232a.m(y10);
        }

        public c y() {
            c cVar = new c(this);
            int i10 = this.f9985i;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            cVar.f9967i = this.f9986j;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            cVar.f9968j = this.f9987k;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            cVar.f9969k = this.f9988l;
            if ((this.f9985i & 8) == 8) {
                this.f9989m = Collections.unmodifiableList(this.f9989m);
                this.f9985i &= -9;
            }
            cVar.f9970l = this.f9989m;
            if ((this.f9985i & 16) == 16) {
                this.f9990n = Collections.unmodifiableList(this.f9990n);
                this.f9985i &= -17;
            }
            cVar.f9971m = this.f9990n;
            if ((this.f9985i & 32) == 32) {
                this.f9991o = Collections.unmodifiableList(this.f9991o);
                this.f9985i &= -33;
            }
            cVar.f9972n = this.f9991o;
            if ((this.f9985i & 64) == 64) {
                this.f9992p = Collections.unmodifiableList(this.f9992p);
                this.f9985i &= -65;
            }
            cVar.f9974p = this.f9992p;
            if ((this.f9985i & 128) == 128) {
                this.f9993q = Collections.unmodifiableList(this.f9993q);
                this.f9985i &= -129;
            }
            cVar.f9976r = this.f9993q;
            if ((this.f9985i & 256) == 256) {
                this.f9994r = Collections.unmodifiableList(this.f9994r);
                this.f9985i &= -257;
            }
            cVar.f9977s = this.f9994r;
            if ((this.f9985i & 512) == 512) {
                this.f9995s = Collections.unmodifiableList(this.f9995s);
                this.f9985i &= -513;
            }
            cVar.f9978t = this.f9995s;
            if ((this.f9985i & 1024) == 1024) {
                this.f9996t = Collections.unmodifiableList(this.f9996t);
                this.f9985i &= -1025;
            }
            cVar.f9979u = this.f9996t;
            if ((this.f9985i & 2048) == 2048) {
                this.f9997u = Collections.unmodifiableList(this.f9997u);
                this.f9985i &= -2049;
            }
            cVar.f9980v = this.f9997u;
            if ((this.f9985i & 4096) == 4096) {
                this.f9998v = Collections.unmodifiableList(this.f9998v);
                this.f9985i &= -4097;
            }
            cVar.f9981w = this.f9998v;
            if ((i10 & 8192) == 8192) {
                i11 |= 8;
            }
            cVar.f9983y = this.f9999w;
            if ((this.f9985i & 16384) == 16384) {
                this.f10000x = Collections.unmodifiableList(this.f10000x);
                this.f9985i &= -16385;
            }
            cVar.f9984z = this.f10000x;
            if ((i10 & 32768) == 32768) {
                i11 |= 16;
            }
            cVar.A = this.f10001y;
            cVar.f9966h = i11;
            return cVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
        /* renamed from: z, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public b n() {
            return A().p(y());
        }
    }

    /* renamed from: ga.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0180c implements j.a {
        CLASS(0, 0),
        INTERFACE(1, 1),
        ENUM_CLASS(2, 2),
        ENUM_ENTRY(3, 3),
        ANNOTATION_CLASS(4, 4),
        OBJECT(5, 5),
        COMPANION_OBJECT(6, 6);

        private static j.b<EnumC0180c> internalValueMap = new a();
        private final int value;

        /* renamed from: ga.c$c$a */
        /* loaded from: classes.dex */
        static class a implements j.b<EnumC0180c> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public EnumC0180c a(int i10) {
                return EnumC0180c.valueOf(i10);
            }
        }

        EnumC0180c(int i10, int i11) {
            this.value = i11;
        }

        public static EnumC0180c valueOf(int i10) {
            switch (i10) {
                case 0:
                    return CLASS;
                case 1:
                    return INTERFACE;
                case 2:
                    return ENUM_CLASS;
                case 3:
                    return ENUM_ENTRY;
                case 4:
                    return ANNOTATION_CLASS;
                case 5:
                    return OBJECT;
                case 6:
                    return COMPANION_OBJECT;
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
        D = cVar;
        cVar.Q0();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0038. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v11, types: [kotlin.reflect.jvm.internal.impl.protobuf.q] */
    /* JADX WARN: Type inference failed for: r11v14, types: [kotlin.reflect.jvm.internal.impl.protobuf.q] */
    /* JADX WARN: Type inference failed for: r11v25, types: [kotlin.reflect.jvm.internal.impl.protobuf.q] */
    /* JADX WARN: Type inference failed for: r11v28, types: [kotlin.reflect.jvm.internal.impl.protobuf.q] */
    /* JADX WARN: Type inference failed for: r11v30, types: [kotlin.reflect.jvm.internal.impl.protobuf.q] */
    /* JADX WARN: Type inference failed for: r11v32, types: [kotlin.reflect.jvm.internal.impl.protobuf.q] */
    /* JADX WARN: Type inference failed for: r11v34, types: [kotlin.reflect.jvm.internal.impl.protobuf.q] */
    private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        List list;
        int j10;
        Integer num;
        this.f9973o = -1;
        this.f9975q = -1;
        this.f9982x = -1;
        this.B = (byte) -1;
        this.C = -1;
        Q0();
        d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
        kotlin.reflect.jvm.internal.impl.protobuf.f J = kotlin.reflect.jvm.internal.impl.protobuf.f.J(A, 1);
        boolean z10 = false;
        int i10 = 0;
        while (!z10) {
            try {
                try {
                    int K = eVar.K();
                    switch (K) {
                        case 0:
                            z10 = true;
                        case 8:
                            this.f9966h |= 1;
                            this.f9967i = eVar.s();
                        case 16:
                            if ((i10 & 32) != 32) {
                                this.f9972n = new ArrayList();
                                i10 |= 32;
                            }
                            list = this.f9972n;
                            num = Integer.valueOf(eVar.s());
                            list.add(num);
                        case 18:
                            j10 = eVar.j(eVar.A());
                            if ((i10 & 32) != 32 && eVar.e() > 0) {
                                this.f9972n = new ArrayList();
                                i10 |= 32;
                            }
                            while (eVar.e() > 0) {
                                this.f9972n.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j10);
                            break;
                        case 24:
                            this.f9966h |= 2;
                            this.f9968j = eVar.s();
                        case 32:
                            this.f9966h |= 4;
                            this.f9969k = eVar.s();
                        case androidx.constraintlayout.widget.j.f1931a5 /* 42 */:
                            if ((i10 & 8) != 8) {
                                this.f9970l = new ArrayList();
                                i10 |= 8;
                            }
                            list = this.f9970l;
                            num = eVar.u(s.f10265s, gVar);
                            list.add(num);
                        case androidx.constraintlayout.widget.j.f1995i5 /* 50 */:
                            if ((i10 & 16) != 16) {
                                this.f9971m = new ArrayList();
                                i10 |= 16;
                            }
                            list = this.f9971m;
                            num = eVar.u(q.f10192z, gVar);
                            list.add(num);
                        case 56:
                            if ((i10 & 64) != 64) {
                                this.f9974p = new ArrayList();
                                i10 |= 64;
                            }
                            list = this.f9974p;
                            num = Integer.valueOf(eVar.s());
                            list.add(num);
                        case 58:
                            j10 = eVar.j(eVar.A());
                            if ((i10 & 64) != 64 && eVar.e() > 0) {
                                this.f9974p = new ArrayList();
                                i10 |= 64;
                            }
                            while (eVar.e() > 0) {
                                this.f9974p.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j10);
                            break;
                        case 66:
                            if ((i10 & 128) != 128) {
                                this.f9976r = new ArrayList();
                                i10 |= 128;
                            }
                            list = this.f9976r;
                            num = eVar.u(d.f10003o, gVar);
                            list.add(num);
                        case 74:
                            if ((i10 & 256) != 256) {
                                this.f9977s = new ArrayList();
                                i10 |= 256;
                            }
                            list = this.f9977s;
                            num = eVar.u(i.f10069x, gVar);
                            list.add(num);
                        case 82:
                            if ((i10 & 512) != 512) {
                                this.f9978t = new ArrayList();
                                i10 |= 512;
                            }
                            list = this.f9978t;
                            num = eVar.u(n.f10132x, gVar);
                            list.add(num);
                        case 90:
                            if ((i10 & 1024) != 1024) {
                                this.f9979u = new ArrayList();
                                i10 |= 1024;
                            }
                            list = this.f9979u;
                            num = eVar.u(r.f10240u, gVar);
                            list.add(num);
                        case 106:
                            if ((i10 & 2048) != 2048) {
                                this.f9980v = new ArrayList();
                                i10 |= 2048;
                            }
                            list = this.f9980v;
                            num = eVar.u(g.f10039m, gVar);
                            list.add(num);
                        case 128:
                            if ((i10 & 4096) != 4096) {
                                this.f9981w = new ArrayList();
                                i10 |= 4096;
                            }
                            list = this.f9981w;
                            num = Integer.valueOf(eVar.s());
                            list.add(num);
                        case 130:
                            j10 = eVar.j(eVar.A());
                            if ((i10 & 4096) != 4096 && eVar.e() > 0) {
                                this.f9981w = new ArrayList();
                                i10 |= 4096;
                            }
                            while (eVar.e() > 0) {
                                this.f9981w.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j10);
                            break;
                        case 242:
                            t.b d10 = (this.f9966h & 8) == 8 ? this.f9983y.d() : null;
                            t tVar = (t) eVar.u(t.f10285m, gVar);
                            this.f9983y = tVar;
                            if (d10 != null) {
                                d10.p(tVar);
                                this.f9983y = d10.t();
                            }
                            this.f9966h |= 8;
                        case 248:
                            if ((i10 & 16384) != 16384) {
                                this.f9984z = new ArrayList();
                                i10 |= 16384;
                            }
                            list = this.f9984z;
                            num = Integer.valueOf(eVar.s());
                            list.add(num);
                        case 250:
                            int j11 = eVar.j(eVar.A());
                            if ((i10 & 16384) != 16384 && eVar.e() > 0) {
                                this.f9984z = new ArrayList();
                                i10 |= 16384;
                            }
                            while (eVar.e() > 0) {
                                this.f9984z.add(Integer.valueOf(eVar.s()));
                            }
                            eVar.i(j11);
                            break;
                        case 258:
                            w.b d11 = (this.f9966h & 16) == 16 ? this.A.d() : null;
                            w wVar = (w) eVar.u(w.f10334k, gVar);
                            this.A = wVar;
                            if (d11 != null) {
                                d11.p(wVar);
                                this.A = d11.t();
                            }
                            this.f9966h |= 16;
                        default:
                            if (q(eVar, J, gVar, K)) {
                            }
                            z10 = true;
                    }
                } catch (Throwable th) {
                    if ((i10 & 32) == 32) {
                        this.f9972n = Collections.unmodifiableList(this.f9972n);
                    }
                    if ((i10 & 8) == 8) {
                        this.f9970l = Collections.unmodifiableList(this.f9970l);
                    }
                    if ((i10 & 16) == 16) {
                        this.f9971m = Collections.unmodifiableList(this.f9971m);
                    }
                    if ((i10 & 64) == 64) {
                        this.f9974p = Collections.unmodifiableList(this.f9974p);
                    }
                    if ((i10 & 128) == 128) {
                        this.f9976r = Collections.unmodifiableList(this.f9976r);
                    }
                    if ((i10 & 256) == 256) {
                        this.f9977s = Collections.unmodifiableList(this.f9977s);
                    }
                    if ((i10 & 512) == 512) {
                        this.f9978t = Collections.unmodifiableList(this.f9978t);
                    }
                    if ((i10 & 1024) == 1024) {
                        this.f9979u = Collections.unmodifiableList(this.f9979u);
                    }
                    if ((i10 & 2048) == 2048) {
                        this.f9980v = Collections.unmodifiableList(this.f9980v);
                    }
                    if ((i10 & 4096) == 4096) {
                        this.f9981w = Collections.unmodifiableList(this.f9981w);
                    }
                    if ((i10 & 16384) == 16384) {
                        this.f9984z = Collections.unmodifiableList(this.f9984z);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f9965g = A.j();
                        throw th2;
                    }
                    this.f9965g = A.j();
                    n();
                    throw th;
                }
            } catch (kotlin.reflect.jvm.internal.impl.protobuf.k e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new kotlin.reflect.jvm.internal.impl.protobuf.k(e11.getMessage()).i(this);
            }
        }
        if ((i10 & 32) == 32) {
            this.f9972n = Collections.unmodifiableList(this.f9972n);
        }
        if ((i10 & 8) == 8) {
            this.f9970l = Collections.unmodifiableList(this.f9970l);
        }
        if ((i10 & 16) == 16) {
            this.f9971m = Collections.unmodifiableList(this.f9971m);
        }
        if ((i10 & 64) == 64) {
            this.f9974p = Collections.unmodifiableList(this.f9974p);
        }
        if ((i10 & 128) == 128) {
            this.f9976r = Collections.unmodifiableList(this.f9976r);
        }
        if ((i10 & 256) == 256) {
            this.f9977s = Collections.unmodifiableList(this.f9977s);
        }
        if ((i10 & 512) == 512) {
            this.f9978t = Collections.unmodifiableList(this.f9978t);
        }
        if ((i10 & 1024) == 1024) {
            this.f9979u = Collections.unmodifiableList(this.f9979u);
        }
        if ((i10 & 2048) == 2048) {
            this.f9980v = Collections.unmodifiableList(this.f9980v);
        }
        if ((i10 & 4096) == 4096) {
            this.f9981w = Collections.unmodifiableList(this.f9981w);
        }
        if ((i10 & 16384) == 16384) {
            this.f9984z = Collections.unmodifiableList(this.f9984z);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f9965g = A.j();
            throw th3;
        }
        this.f9965g = A.j();
        n();
    }

    private c(i.c<c, ?> cVar) {
        super(cVar);
        this.f9973o = -1;
        this.f9975q = -1;
        this.f9982x = -1;
        this.B = (byte) -1;
        this.C = -1;
        this.f9965g = cVar.o();
    }

    private c(boolean z10) {
        this.f9973o = -1;
        this.f9975q = -1;
        this.f9982x = -1;
        this.B = (byte) -1;
        this.C = -1;
        this.f9965g = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
    }

    private void Q0() {
        this.f9967i = 6;
        this.f9968j = 0;
        this.f9969k = 0;
        this.f9970l = Collections.emptyList();
        this.f9971m = Collections.emptyList();
        this.f9972n = Collections.emptyList();
        this.f9974p = Collections.emptyList();
        this.f9976r = Collections.emptyList();
        this.f9977s = Collections.emptyList();
        this.f9978t = Collections.emptyList();
        this.f9979u = Collections.emptyList();
        this.f9980v = Collections.emptyList();
        this.f9981w = Collections.emptyList();
        this.f9983y = t.x();
        this.f9984z = Collections.emptyList();
        this.A = w.v();
    }

    public static b R0() {
        return b.w();
    }

    public static b S0(c cVar) {
        return R0().p(cVar);
    }

    public static c U0(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.g gVar) {
        return E.b(inputStream, gVar);
    }

    public static c j0() {
        return D;
    }

    public List<Integer> A0() {
        return this.f9972n;
    }

    public List<q> B0() {
        return this.f9971m;
    }

    public r C0(int i10) {
        return this.f9979u.get(i10);
    }

    public int D0() {
        return this.f9979u.size();
    }

    public List<r> E0() {
        return this.f9979u;
    }

    public s F0(int i10) {
        return this.f9970l.get(i10);
    }

    public int G0() {
        return this.f9970l.size();
    }

    public List<s> H0() {
        return this.f9970l;
    }

    public t I0() {
        return this.f9983y;
    }

    public List<Integer> J0() {
        return this.f9984z;
    }

    public w K0() {
        return this.A;
    }

    public boolean L0() {
        return (this.f9966h & 4) == 4;
    }

    public boolean M0() {
        return (this.f9966h & 1) == 1;
    }

    public boolean N0() {
        return (this.f9966h & 2) == 2;
    }

    public boolean O0() {
        return (this.f9966h & 8) == 8;
    }

    public boolean P0() {
        return (this.f9966h & 16) == 16;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public b h() {
        return R0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return S0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public int a() {
        int i10 = this.C;
        if (i10 != -1) {
            return i10;
        }
        int o10 = (this.f9966h & 1) == 1 ? kotlin.reflect.jvm.internal.impl.protobuf.f.o(1, this.f9967i) + 0 : 0;
        int i11 = 0;
        for (int i12 = 0; i12 < this.f9972n.size(); i12++) {
            i11 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.f9972n.get(i12).intValue());
        }
        int i13 = o10 + i11;
        if (!A0().isEmpty()) {
            i13 = i13 + 1 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(i11);
        }
        this.f9973o = i11;
        if ((this.f9966h & 2) == 2) {
            i13 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(3, this.f9968j);
        }
        if ((this.f9966h & 4) == 4) {
            i13 += kotlin.reflect.jvm.internal.impl.protobuf.f.o(4, this.f9969k);
        }
        for (int i14 = 0; i14 < this.f9970l.size(); i14++) {
            i13 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(5, this.f9970l.get(i14));
        }
        for (int i15 = 0; i15 < this.f9971m.size(); i15++) {
            i13 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(6, this.f9971m.get(i15));
        }
        int i16 = 0;
        for (int i17 = 0; i17 < this.f9974p.size(); i17++) {
            i16 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.f9974p.get(i17).intValue());
        }
        int i18 = i13 + i16;
        if (!t0().isEmpty()) {
            i18 = i18 + 1 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(i16);
        }
        this.f9975q = i16;
        for (int i19 = 0; i19 < this.f9976r.size(); i19++) {
            i18 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(8, this.f9976r.get(i19));
        }
        for (int i20 = 0; i20 < this.f9977s.size(); i20++) {
            i18 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(9, this.f9977s.get(i20));
        }
        for (int i21 = 0; i21 < this.f9978t.size(); i21++) {
            i18 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(10, this.f9978t.get(i21));
        }
        for (int i22 = 0; i22 < this.f9979u.size(); i22++) {
            i18 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(11, this.f9979u.get(i22));
        }
        for (int i23 = 0; i23 < this.f9980v.size(); i23++) {
            i18 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(13, this.f9980v.get(i23));
        }
        int i24 = 0;
        for (int i25 = 0; i25 < this.f9981w.size(); i25++) {
            i24 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.f9981w.get(i25).intValue());
        }
        int i26 = i18 + i24;
        if (!x0().isEmpty()) {
            i26 = i26 + 2 + kotlin.reflect.jvm.internal.impl.protobuf.f.p(i24);
        }
        this.f9982x = i24;
        if ((this.f9966h & 8) == 8) {
            i26 += kotlin.reflect.jvm.internal.impl.protobuf.f.s(30, this.f9983y);
        }
        int i27 = 0;
        for (int i28 = 0; i28 < this.f9984z.size(); i28++) {
            i27 += kotlin.reflect.jvm.internal.impl.protobuf.f.p(this.f9984z.get(i28).intValue());
        }
        int size = i26 + i27 + (J0().size() * 2);
        if ((this.f9966h & 16) == 16) {
            size += kotlin.reflect.jvm.internal.impl.protobuf.f.s(32, this.A);
        }
        int u10 = size + u() + this.f9965g.size();
        this.C = u10;
        return u10;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
    public void e(kotlin.reflect.jvm.internal.impl.protobuf.f fVar) {
        a();
        i.d<MessageType>.a z10 = z();
        if ((this.f9966h & 1) == 1) {
            fVar.a0(1, this.f9967i);
        }
        if (A0().size() > 0) {
            fVar.o0(18);
            fVar.o0(this.f9973o);
        }
        for (int i10 = 0; i10 < this.f9972n.size(); i10++) {
            fVar.b0(this.f9972n.get(i10).intValue());
        }
        if ((this.f9966h & 2) == 2) {
            fVar.a0(3, this.f9968j);
        }
        if ((this.f9966h & 4) == 4) {
            fVar.a0(4, this.f9969k);
        }
        for (int i11 = 0; i11 < this.f9970l.size(); i11++) {
            fVar.d0(5, this.f9970l.get(i11));
        }
        for (int i12 = 0; i12 < this.f9971m.size(); i12++) {
            fVar.d0(6, this.f9971m.get(i12));
        }
        if (t0().size() > 0) {
            fVar.o0(58);
            fVar.o0(this.f9975q);
        }
        for (int i13 = 0; i13 < this.f9974p.size(); i13++) {
            fVar.b0(this.f9974p.get(i13).intValue());
        }
        for (int i14 = 0; i14 < this.f9976r.size(); i14++) {
            fVar.d0(8, this.f9976r.get(i14));
        }
        for (int i15 = 0; i15 < this.f9977s.size(); i15++) {
            fVar.d0(9, this.f9977s.get(i15));
        }
        for (int i16 = 0; i16 < this.f9978t.size(); i16++) {
            fVar.d0(10, this.f9978t.get(i16));
        }
        for (int i17 = 0; i17 < this.f9979u.size(); i17++) {
            fVar.d0(11, this.f9979u.get(i17));
        }
        for (int i18 = 0; i18 < this.f9980v.size(); i18++) {
            fVar.d0(13, this.f9980v.get(i18));
        }
        if (x0().size() > 0) {
            fVar.o0(130);
            fVar.o0(this.f9982x);
        }
        for (int i19 = 0; i19 < this.f9981w.size(); i19++) {
            fVar.b0(this.f9981w.get(i19).intValue());
        }
        if ((this.f9966h & 8) == 8) {
            fVar.d0(30, this.f9983y);
        }
        for (int i20 = 0; i20 < this.f9984z.size(); i20++) {
            fVar.a0(31, this.f9984z.get(i20).intValue());
        }
        if ((this.f9966h & 16) == 16) {
            fVar.d0(32, this.A);
        }
        z10.a(19000, fVar);
        fVar.i0(this.f9965g);
    }

    public int f0() {
        return this.f9969k;
    }

    public d g0(int i10) {
        return this.f9976r.get(i10);
    }

    public int h0() {
        return this.f9976r.size();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
    public kotlin.reflect.jvm.internal.impl.protobuf.s<c> i() {
        return E;
    }

    public List<d> i0() {
        return this.f9976r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    public final boolean k() {
        byte b10 = this.B;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!N0()) {
            this.B = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < G0(); i10++) {
            if (!F0(i10).k()) {
                this.B = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < z0(); i11++) {
            if (!y0(i11).k()) {
                this.B = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < h0(); i12++) {
            if (!g0(i12).k()) {
                this.B = (byte) 0;
                return false;
            }
        }
        for (int i13 = 0; i13 < r0(); i13++) {
            if (!q0(i13).k()) {
                this.B = (byte) 0;
                return false;
            }
        }
        for (int i14 = 0; i14 < v0(); i14++) {
            if (!u0(i14).k()) {
                this.B = (byte) 0;
                return false;
            }
        }
        for (int i15 = 0; i15 < D0(); i15++) {
            if (!C0(i15).k()) {
                this.B = (byte) 0;
                return false;
            }
        }
        for (int i16 = 0; i16 < m0(); i16++) {
            if (!l0(i16).k()) {
                this.B = (byte) 0;
                return false;
            }
        }
        if (O0() && !I0().k()) {
            this.B = (byte) 0;
            return false;
        }
        if (t()) {
            this.B = (byte) 1;
            return true;
        }
        this.B = (byte) 0;
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public c b() {
        return D;
    }

    public g l0(int i10) {
        return this.f9980v.get(i10);
    }

    public int m0() {
        return this.f9980v.size();
    }

    public List<g> n0() {
        return this.f9980v;
    }

    public int o0() {
        return this.f9967i;
    }

    public int p0() {
        return this.f9968j;
    }

    public i q0(int i10) {
        return this.f9977s.get(i10);
    }

    public int r0() {
        return this.f9977s.size();
    }

    public List<i> s0() {
        return this.f9977s;
    }

    public List<Integer> t0() {
        return this.f9974p;
    }

    public n u0(int i10) {
        return this.f9978t.get(i10);
    }

    public int v0() {
        return this.f9978t.size();
    }

    public List<n> w0() {
        return this.f9978t;
    }

    public List<Integer> x0() {
        return this.f9981w;
    }

    public q y0(int i10) {
        return this.f9971m.get(i10);
    }

    public int z0() {
        return this.f9971m.size();
    }
}
