package ja;

import ga.l;
import ga.n;
import ga.q;
import ga.s;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.g;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.j;
import kotlin.reflect.jvm.internal.impl.protobuf.k;
import kotlin.reflect.jvm.internal.impl.protobuf.r;
import kotlin.reflect.jvm.internal.impl.protobuf.z;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final i.f<ga.d, c> f10973a;

    /* renamed from: b, reason: collision with root package name */
    public static final i.f<ga.i, c> f10974b;

    /* renamed from: c, reason: collision with root package name */
    public static final i.f<ga.i, Integer> f10975c;

    /* renamed from: d, reason: collision with root package name */
    public static final i.f<n, d> f10976d;

    /* renamed from: e, reason: collision with root package name */
    public static final i.f<n, Integer> f10977e;

    /* renamed from: f, reason: collision with root package name */
    public static final i.f<q, List<ga.b>> f10978f;

    /* renamed from: g, reason: collision with root package name */
    public static final i.f<q, Boolean> f10979g;

    /* renamed from: h, reason: collision with root package name */
    public static final i.f<s, List<ga.b>> f10980h;

    /* renamed from: i, reason: collision with root package name */
    public static final i.f<ga.c, Integer> f10981i;

    /* renamed from: j, reason: collision with root package name */
    public static final i.f<ga.c, List<n>> f10982j;

    /* renamed from: k, reason: collision with root package name */
    public static final i.f<ga.c, Integer> f10983k;

    /* renamed from: l, reason: collision with root package name */
    public static final i.f<ga.c, Integer> f10984l;

    /* renamed from: m, reason: collision with root package name */
    public static final i.f<l, Integer> f10985m;

    /* renamed from: n, reason: collision with root package name */
    public static final i.f<l, List<n>> f10986n;

    /* loaded from: classes.dex */
    public static final class b extends i implements r {

        /* renamed from: l, reason: collision with root package name */
        private static final b f10987l;

        /* renamed from: m, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<b> f10988m = new C0214a();

        /* renamed from: f, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.protobuf.d f10989f;

        /* renamed from: g, reason: collision with root package name */
        private int f10990g;

        /* renamed from: h, reason: collision with root package name */
        private int f10991h;

        /* renamed from: i, reason: collision with root package name */
        private int f10992i;

        /* renamed from: j, reason: collision with root package name */
        private byte f10993j;

        /* renamed from: k, reason: collision with root package name */
        private int f10994k;

        /* renamed from: ja.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0214a extends kotlin.reflect.jvm.internal.impl.protobuf.b<b> {
            C0214a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public b c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
                return new b(eVar, gVar);
            }
        }

        /* renamed from: ja.a$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0215b extends i.b<b, C0215b> implements r {

            /* renamed from: g, reason: collision with root package name */
            private int f10995g;

            /* renamed from: h, reason: collision with root package name */
            private int f10996h;

            /* renamed from: i, reason: collision with root package name */
            private int f10997i;

            private C0215b() {
                x();
            }

            static /* synthetic */ C0215b r() {
                return w();
            }

            private static C0215b w() {
                return new C0215b();
            }

            private void x() {
            }

            public C0215b A(int i10) {
                this.f10995g |= 2;
                this.f10997i = i10;
                return this;
            }

            public C0215b B(int i10) {
                this.f10995g |= 1;
                this.f10996h = i10;
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
                int i10 = this.f10995g;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                bVar.f10991h = this.f10996h;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                bVar.f10992i = this.f10997i;
                bVar.f10990g = i11;
                return bVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public C0215b n() {
                return w().p(t());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public C0215b p(b bVar) {
                if (bVar == b.w()) {
                    return this;
                }
                if (bVar.A()) {
                    B(bVar.y());
                }
                if (bVar.z()) {
                    A(bVar.x());
                }
                q(o().f(bVar.f10989f));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ja.a.b.C0215b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.s<ja.a$b> r1 = ja.a.b.f10988m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    ja.a$b r3 = (ja.a.b) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                    ja.a$b r4 = (ja.a.b) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ja.a.b.C0215b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ja.a$b$b");
            }
        }

        static {
            b bVar = new b(true);
            f10987l = bVar;
            bVar.B();
        }

        private b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
            this.f10993j = (byte) -1;
            this.f10994k = -1;
            B();
            d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
            f J = f.J(A, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                this.f10990g |= 1;
                                this.f10991h = eVar.s();
                            } else if (K == 16) {
                                this.f10990g |= 2;
                                this.f10992i = eVar.s();
                            } else if (!q(eVar, J, gVar, K)) {
                            }
                        }
                        z10 = true;
                    } catch (k e10) {
                        throw e10.i(this);
                    } catch (IOException e11) {
                        throw new k(e11.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f10989f = A.j();
                        throw th2;
                    }
                    this.f10989f = A.j();
                    n();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f10989f = A.j();
                throw th3;
            }
            this.f10989f = A.j();
            n();
        }

        private b(i.b bVar) {
            super(bVar);
            this.f10993j = (byte) -1;
            this.f10994k = -1;
            this.f10989f = bVar.o();
        }

        private b(boolean z10) {
            this.f10993j = (byte) -1;
            this.f10994k = -1;
            this.f10989f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
        }

        private void B() {
            this.f10991h = 0;
            this.f10992i = 0;
        }

        public static C0215b C() {
            return C0215b.r();
        }

        public static C0215b E(b bVar) {
            return C().p(bVar);
        }

        public static b w() {
            return f10987l;
        }

        public boolean A() {
            return (this.f10990g & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public C0215b h() {
            return C();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public C0215b d() {
            return E(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int a() {
            int i10 = this.f10994k;
            if (i10 != -1) {
                return i10;
            }
            int o10 = (this.f10990g & 1) == 1 ? 0 + f.o(1, this.f10991h) : 0;
            if ((this.f10990g & 2) == 2) {
                o10 += f.o(2, this.f10992i);
            }
            int size = o10 + this.f10989f.size();
            this.f10994k = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void e(f fVar) {
            a();
            if ((this.f10990g & 1) == 1) {
                fVar.a0(1, this.f10991h);
            }
            if ((this.f10990g & 2) == 2) {
                fVar.a0(2, this.f10992i);
            }
            fVar.i0(this.f10989f);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<b> i() {
            return f10988m;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
        public final boolean k() {
            byte b10 = this.f10993j;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f10993j = (byte) 1;
            return true;
        }

        public int x() {
            return this.f10992i;
        }

        public int y() {
            return this.f10991h;
        }

        public boolean z() {
            return (this.f10990g & 2) == 2;
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends i implements r {

        /* renamed from: l, reason: collision with root package name */
        private static final c f10998l;

        /* renamed from: m, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<c> f10999m = new C0216a();

        /* renamed from: f, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.protobuf.d f11000f;

        /* renamed from: g, reason: collision with root package name */
        private int f11001g;

        /* renamed from: h, reason: collision with root package name */
        private int f11002h;

        /* renamed from: i, reason: collision with root package name */
        private int f11003i;

        /* renamed from: j, reason: collision with root package name */
        private byte f11004j;

        /* renamed from: k, reason: collision with root package name */
        private int f11005k;

        /* renamed from: ja.a$c$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0216a extends kotlin.reflect.jvm.internal.impl.protobuf.b<c> {
            C0216a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public c c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
                return new c(eVar, gVar);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends i.b<c, b> implements r {

            /* renamed from: g, reason: collision with root package name */
            private int f11006g;

            /* renamed from: h, reason: collision with root package name */
            private int f11007h;

            /* renamed from: i, reason: collision with root package name */
            private int f11008i;

            private b() {
                x();
            }

            static /* synthetic */ b r() {
                return w();
            }

            private static b w() {
                return new b();
            }

            private void x() {
            }

            public b A(int i10) {
                this.f11006g |= 2;
                this.f11008i = i10;
                return this;
            }

            public b B(int i10) {
                this.f11006g |= 1;
                this.f11007h = i10;
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
                int i10 = this.f11006g;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                cVar.f11002h = this.f11007h;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                cVar.f11003i = this.f11008i;
                cVar.f11001g = i11;
                return cVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b n() {
                return w().p(t());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: y, reason: merged with bridge method [inline-methods] */
            public b p(c cVar) {
                if (cVar == c.w()) {
                    return this;
                }
                if (cVar.A()) {
                    B(cVar.y());
                }
                if (cVar.z()) {
                    A(cVar.x());
                }
                q(o().f(cVar.f11000f));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ja.a.c.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.s<ja.a$c> r1 = ja.a.c.f10999m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    ja.a$c r3 = (ja.a.c) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                    ja.a$c r4 = (ja.a.c) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ja.a.c.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ja.a$c$b");
            }
        }

        static {
            c cVar = new c(true);
            f10998l = cVar;
            cVar.B();
        }

        private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
            this.f11004j = (byte) -1;
            this.f11005k = -1;
            B();
            d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
            f J = f.J(A, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                this.f11001g |= 1;
                                this.f11002h = eVar.s();
                            } else if (K == 16) {
                                this.f11001g |= 2;
                                this.f11003i = eVar.s();
                            } else if (!q(eVar, J, gVar, K)) {
                            }
                        }
                        z10 = true;
                    } catch (k e10) {
                        throw e10.i(this);
                    } catch (IOException e11) {
                        throw new k(e11.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f11000f = A.j();
                        throw th2;
                    }
                    this.f11000f = A.j();
                    n();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f11000f = A.j();
                throw th3;
            }
            this.f11000f = A.j();
            n();
        }

        private c(i.b bVar) {
            super(bVar);
            this.f11004j = (byte) -1;
            this.f11005k = -1;
            this.f11000f = bVar.o();
        }

        private c(boolean z10) {
            this.f11004j = (byte) -1;
            this.f11005k = -1;
            this.f11000f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
        }

        private void B() {
            this.f11002h = 0;
            this.f11003i = 0;
        }

        public static b C() {
            return b.r();
        }

        public static b E(c cVar) {
            return C().p(cVar);
        }

        public static c w() {
            return f10998l;
        }

        public boolean A() {
            return (this.f11001g & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public b h() {
            return C();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public b d() {
            return E(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int a() {
            int i10 = this.f11005k;
            if (i10 != -1) {
                return i10;
            }
            int o10 = (this.f11001g & 1) == 1 ? 0 + f.o(1, this.f11002h) : 0;
            if ((this.f11001g & 2) == 2) {
                o10 += f.o(2, this.f11003i);
            }
            int size = o10 + this.f11000f.size();
            this.f11005k = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void e(f fVar) {
            a();
            if ((this.f11001g & 1) == 1) {
                fVar.a0(1, this.f11002h);
            }
            if ((this.f11001g & 2) == 2) {
                fVar.a0(2, this.f11003i);
            }
            fVar.i0(this.f11000f);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<c> i() {
            return f10999m;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
        public final boolean k() {
            byte b10 = this.f11004j;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f11004j = (byte) 1;
            return true;
        }

        public int x() {
            return this.f11003i;
        }

        public int y() {
            return this.f11002h;
        }

        public boolean z() {
            return (this.f11001g & 2) == 2;
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends i implements r {

        /* renamed from: n, reason: collision with root package name */
        private static final d f11009n;

        /* renamed from: o, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<d> f11010o = new C0217a();

        /* renamed from: f, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.protobuf.d f11011f;

        /* renamed from: g, reason: collision with root package name */
        private int f11012g;

        /* renamed from: h, reason: collision with root package name */
        private b f11013h;

        /* renamed from: i, reason: collision with root package name */
        private c f11014i;

        /* renamed from: j, reason: collision with root package name */
        private c f11015j;

        /* renamed from: k, reason: collision with root package name */
        private c f11016k;

        /* renamed from: l, reason: collision with root package name */
        private byte f11017l;

        /* renamed from: m, reason: collision with root package name */
        private int f11018m;

        /* renamed from: ja.a$d$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0217a extends kotlin.reflect.jvm.internal.impl.protobuf.b<d> {
            C0217a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public d c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
                return new d(eVar, gVar);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends i.b<d, b> implements r {

            /* renamed from: g, reason: collision with root package name */
            private int f11019g;

            /* renamed from: h, reason: collision with root package name */
            private b f11020h = b.w();

            /* renamed from: i, reason: collision with root package name */
            private c f11021i = c.w();

            /* renamed from: j, reason: collision with root package name */
            private c f11022j = c.w();

            /* renamed from: k, reason: collision with root package name */
            private c f11023k = c.w();

            private b() {
                x();
            }

            static /* synthetic */ b r() {
                return w();
            }

            private static b w() {
                return new b();
            }

            private void x() {
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ja.a.d.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.s<ja.a$d> r1 = ja.a.d.f11010o     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    ja.a$d r3 = (ja.a.d) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                    ja.a$d r4 = (ja.a.d) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ja.a.d.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ja.a$d$b");
            }

            public b B(c cVar) {
                if ((this.f11019g & 4) == 4 && this.f11022j != c.w()) {
                    cVar = c.E(this.f11022j).p(cVar).t();
                }
                this.f11022j = cVar;
                this.f11019g |= 4;
                return this;
            }

            public b C(c cVar) {
                if ((this.f11019g & 8) == 8 && this.f11023k != c.w()) {
                    cVar = c.E(this.f11023k).p(cVar).t();
                }
                this.f11023k = cVar;
                this.f11019g |= 8;
                return this;
            }

            public b E(c cVar) {
                if ((this.f11019g & 2) == 2 && this.f11021i != c.w()) {
                    cVar = c.E(this.f11021i).p(cVar).t();
                }
                this.f11021i = cVar;
                this.f11019g |= 2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public d c() {
                d t10 = t();
                if (t10.k()) {
                    return t10;
                }
                throw a.AbstractC0232a.m(t10);
            }

            public d t() {
                d dVar = new d(this);
                int i10 = this.f11019g;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                dVar.f11013h = this.f11020h;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                dVar.f11014i = this.f11021i;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                dVar.f11015j = this.f11022j;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                dVar.f11016k = this.f11023k;
                dVar.f11012g = i11;
                return dVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b n() {
                return w().p(t());
            }

            public b y(b bVar) {
                if ((this.f11019g & 1) == 1 && this.f11020h != b.w()) {
                    bVar = b.E(this.f11020h).p(bVar).t();
                }
                this.f11020h = bVar;
                this.f11019g |= 1;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: z, reason: merged with bridge method [inline-methods] */
            public b p(d dVar) {
                if (dVar == d.y()) {
                    return this;
                }
                if (dVar.E()) {
                    y(dVar.z());
                }
                if (dVar.H()) {
                    E(dVar.C());
                }
                if (dVar.F()) {
                    B(dVar.A());
                }
                if (dVar.G()) {
                    C(dVar.B());
                }
                q(o().f(dVar.f11011f));
                return this;
            }
        }

        static {
            d dVar = new d(true);
            f11009n = dVar;
            dVar.I();
        }

        private d(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
            int i10;
            int i11;
            this.f11017l = (byte) -1;
            this.f11018m = -1;
            I();
            d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
            f J = f.J(A, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K != 10) {
                                    if (K == 18) {
                                        i10 = 2;
                                        c.b d10 = (this.f11012g & 2) == 2 ? this.f11014i.d() : null;
                                        c cVar = (c) eVar.u(c.f10999m, gVar);
                                        this.f11014i = cVar;
                                        if (d10 != null) {
                                            d10.p(cVar);
                                            this.f11014i = d10.t();
                                        }
                                        i11 = this.f11012g;
                                    } else if (K == 26) {
                                        i10 = 4;
                                        c.b d11 = (this.f11012g & 4) == 4 ? this.f11015j.d() : null;
                                        c cVar2 = (c) eVar.u(c.f10999m, gVar);
                                        this.f11015j = cVar2;
                                        if (d11 != null) {
                                            d11.p(cVar2);
                                            this.f11015j = d11.t();
                                        }
                                        i11 = this.f11012g;
                                    } else if (K == 34) {
                                        i10 = 8;
                                        c.b d12 = (this.f11012g & 8) == 8 ? this.f11016k.d() : null;
                                        c cVar3 = (c) eVar.u(c.f10999m, gVar);
                                        this.f11016k = cVar3;
                                        if (d12 != null) {
                                            d12.p(cVar3);
                                            this.f11016k = d12.t();
                                        }
                                        i11 = this.f11012g;
                                    } else if (!q(eVar, J, gVar, K)) {
                                    }
                                    this.f11012g = i11 | i10;
                                } else {
                                    b.C0215b d13 = (this.f11012g & 1) == 1 ? this.f11013h.d() : null;
                                    b bVar = (b) eVar.u(b.f10988m, gVar);
                                    this.f11013h = bVar;
                                    if (d13 != null) {
                                        d13.p(bVar);
                                        this.f11013h = d13.t();
                                    }
                                    this.f11012g |= 1;
                                }
                            }
                            z10 = true;
                        } catch (IOException e10) {
                            throw new k(e10.getMessage()).i(this);
                        }
                    } catch (k e11) {
                        throw e11.i(this);
                    }
                } catch (Throwable th) {
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f11011f = A.j();
                        throw th2;
                    }
                    this.f11011f = A.j();
                    n();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f11011f = A.j();
                throw th3;
            }
            this.f11011f = A.j();
            n();
        }

        private d(i.b bVar) {
            super(bVar);
            this.f11017l = (byte) -1;
            this.f11018m = -1;
            this.f11011f = bVar.o();
        }

        private d(boolean z10) {
            this.f11017l = (byte) -1;
            this.f11018m = -1;
            this.f11011f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
        }

        private void I() {
            this.f11013h = b.w();
            this.f11014i = c.w();
            this.f11015j = c.w();
            this.f11016k = c.w();
        }

        public static b J() {
            return b.r();
        }

        public static b K(d dVar) {
            return J().p(dVar);
        }

        public static d y() {
            return f11009n;
        }

        public c A() {
            return this.f11015j;
        }

        public c B() {
            return this.f11016k;
        }

        public c C() {
            return this.f11014i;
        }

        public boolean E() {
            return (this.f11012g & 1) == 1;
        }

        public boolean F() {
            return (this.f11012g & 4) == 4;
        }

        public boolean G() {
            return (this.f11012g & 8) == 8;
        }

        public boolean H() {
            return (this.f11012g & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: L, reason: merged with bridge method [inline-methods] */
        public b h() {
            return J();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: M, reason: merged with bridge method [inline-methods] */
        public b d() {
            return K(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int a() {
            int i10 = this.f11018m;
            if (i10 != -1) {
                return i10;
            }
            int s10 = (this.f11012g & 1) == 1 ? 0 + f.s(1, this.f11013h) : 0;
            if ((this.f11012g & 2) == 2) {
                s10 += f.s(2, this.f11014i);
            }
            if ((this.f11012g & 4) == 4) {
                s10 += f.s(3, this.f11015j);
            }
            if ((this.f11012g & 8) == 8) {
                s10 += f.s(4, this.f11016k);
            }
            int size = s10 + this.f11011f.size();
            this.f11018m = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void e(f fVar) {
            a();
            if ((this.f11012g & 1) == 1) {
                fVar.d0(1, this.f11013h);
            }
            if ((this.f11012g & 2) == 2) {
                fVar.d0(2, this.f11014i);
            }
            if ((this.f11012g & 4) == 4) {
                fVar.d0(3, this.f11015j);
            }
            if ((this.f11012g & 8) == 8) {
                fVar.d0(4, this.f11016k);
            }
            fVar.i0(this.f11011f);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<d> i() {
            return f11010o;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
        public final boolean k() {
            byte b10 = this.f11017l;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f11017l = (byte) 1;
            return true;
        }

        public b z() {
            return this.f11013h;
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends i implements r {

        /* renamed from: l, reason: collision with root package name */
        private static final e f11024l;

        /* renamed from: m, reason: collision with root package name */
        public static kotlin.reflect.jvm.internal.impl.protobuf.s<e> f11025m = new C0218a();

        /* renamed from: f, reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.protobuf.d f11026f;

        /* renamed from: g, reason: collision with root package name */
        private List<c> f11027g;

        /* renamed from: h, reason: collision with root package name */
        private List<Integer> f11028h;

        /* renamed from: i, reason: collision with root package name */
        private int f11029i;

        /* renamed from: j, reason: collision with root package name */
        private byte f11030j;

        /* renamed from: k, reason: collision with root package name */
        private int f11031k;

        /* renamed from: ja.a$e$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static class C0218a extends kotlin.reflect.jvm.internal.impl.protobuf.b<e> {
            C0218a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public e c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
                return new e(eVar, gVar);
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends i.b<e, b> implements r {

            /* renamed from: g, reason: collision with root package name */
            private int f11032g;

            /* renamed from: h, reason: collision with root package name */
            private List<c> f11033h = Collections.emptyList();

            /* renamed from: i, reason: collision with root package name */
            private List<Integer> f11034i = Collections.emptyList();

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
                if ((this.f11032g & 2) != 2) {
                    this.f11034i = new ArrayList(this.f11034i);
                    this.f11032g |= 2;
                }
            }

            private void y() {
                if ((this.f11032g & 1) != 1) {
                    this.f11033h = new ArrayList(this.f11033h);
                    this.f11032g |= 1;
                }
            }

            private void z() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: A, reason: merged with bridge method [inline-methods] */
            public b p(e eVar) {
                if (eVar == e.x()) {
                    return this;
                }
                if (!eVar.f11027g.isEmpty()) {
                    if (this.f11033h.isEmpty()) {
                        this.f11033h = eVar.f11027g;
                        this.f11032g &= -2;
                    } else {
                        y();
                        this.f11033h.addAll(eVar.f11027g);
                    }
                }
                if (!eVar.f11028h.isEmpty()) {
                    if (this.f11034i.isEmpty()) {
                        this.f11034i = eVar.f11028h;
                        this.f11032g &= -3;
                    } else {
                        x();
                        this.f11034i.addAll(eVar.f11028h);
                    }
                }
                q(o().f(eVar.f11026f));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
            /* renamed from: B, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ja.a.e.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.s<ja.a$e> r1 = ja.a.e.f11025m     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                    ja.a$e r3 = (ja.a.e) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                    ja.a$e r4 = (ja.a.e) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ja.a.e.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ja.a$e$b");
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q.a
            /* renamed from: s, reason: merged with bridge method [inline-methods] */
            public e c() {
                e t10 = t();
                if (t10.k()) {
                    return t10;
                }
                throw a.AbstractC0232a.m(t10);
            }

            public e t() {
                e eVar = new e(this);
                if ((this.f11032g & 1) == 1) {
                    this.f11033h = Collections.unmodifiableList(this.f11033h);
                    this.f11032g &= -2;
                }
                eVar.f11027g = this.f11033h;
                if ((this.f11032g & 2) == 2) {
                    this.f11034i = Collections.unmodifiableList(this.f11034i);
                    this.f11032g &= -3;
                }
                eVar.f11028h = this.f11034i;
                return eVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b n() {
                return w().p(t());
            }
        }

        /* loaded from: classes.dex */
        public static final class c extends i implements r {

            /* renamed from: r, reason: collision with root package name */
            private static final c f11035r;

            /* renamed from: s, reason: collision with root package name */
            public static kotlin.reflect.jvm.internal.impl.protobuf.s<c> f11036s = new C0219a();

            /* renamed from: f, reason: collision with root package name */
            private final kotlin.reflect.jvm.internal.impl.protobuf.d f11037f;

            /* renamed from: g, reason: collision with root package name */
            private int f11038g;

            /* renamed from: h, reason: collision with root package name */
            private int f11039h;

            /* renamed from: i, reason: collision with root package name */
            private int f11040i;

            /* renamed from: j, reason: collision with root package name */
            private Object f11041j;

            /* renamed from: k, reason: collision with root package name */
            private EnumC0220c f11042k;

            /* renamed from: l, reason: collision with root package name */
            private List<Integer> f11043l;

            /* renamed from: m, reason: collision with root package name */
            private int f11044m;

            /* renamed from: n, reason: collision with root package name */
            private List<Integer> f11045n;

            /* renamed from: o, reason: collision with root package name */
            private int f11046o;

            /* renamed from: p, reason: collision with root package name */
            private byte f11047p;

            /* renamed from: q, reason: collision with root package name */
            private int f11048q;

            /* renamed from: ja.a$e$c$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            static class C0219a extends kotlin.reflect.jvm.internal.impl.protobuf.b<c> {
                C0219a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.s
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public c c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
                    return new c(eVar, gVar);
                }
            }

            /* loaded from: classes.dex */
            public static final class b extends i.b<c, b> implements r {

                /* renamed from: g, reason: collision with root package name */
                private int f11049g;

                /* renamed from: i, reason: collision with root package name */
                private int f11051i;

                /* renamed from: h, reason: collision with root package name */
                private int f11050h = 1;

                /* renamed from: j, reason: collision with root package name */
                private Object f11052j = "";

                /* renamed from: k, reason: collision with root package name */
                private EnumC0220c f11053k = EnumC0220c.NONE;

                /* renamed from: l, reason: collision with root package name */
                private List<Integer> f11054l = Collections.emptyList();

                /* renamed from: m, reason: collision with root package name */
                private List<Integer> f11055m = Collections.emptyList();

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
                    if ((this.f11049g & 32) != 32) {
                        this.f11055m = new ArrayList(this.f11055m);
                        this.f11049g |= 32;
                    }
                }

                private void y() {
                    if ((this.f11049g & 16) != 16) {
                        this.f11054l = new ArrayList(this.f11054l);
                        this.f11049g |= 16;
                    }
                }

                private void z() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                /* renamed from: A, reason: merged with bridge method [inline-methods] */
                public b p(c cVar) {
                    if (cVar == c.E()) {
                        return this;
                    }
                    if (cVar.Q()) {
                        F(cVar.H());
                    }
                    if (cVar.P()) {
                        E(cVar.G());
                    }
                    if (cVar.R()) {
                        this.f11049g |= 4;
                        this.f11052j = cVar.f11041j;
                    }
                    if (cVar.O()) {
                        C(cVar.F());
                    }
                    if (!cVar.f11043l.isEmpty()) {
                        if (this.f11054l.isEmpty()) {
                            this.f11054l = cVar.f11043l;
                            this.f11049g &= -17;
                        } else {
                            y();
                            this.f11054l.addAll(cVar.f11043l);
                        }
                    }
                    if (!cVar.f11045n.isEmpty()) {
                        if (this.f11055m.isEmpty()) {
                            this.f11055m = cVar.f11045n;
                            this.f11049g &= -33;
                        } else {
                            x();
                            this.f11055m.addAll(cVar.f11045n);
                        }
                    }
                    q(o().f(cVar.f11037f));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0232a
                /* renamed from: B, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public ja.a.e.c.b l(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.g r4) {
                    /*
                        r2 = this;
                        r0 = 0
                        kotlin.reflect.jvm.internal.impl.protobuf.s<ja.a$e$c> r1 = ja.a.e.c.f11036s     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
                        ja.a$e$c r3 = (ja.a.e.c) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.k -> L11
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
                        ja.a$e$c r4 = (ja.a.e.c) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: ja.a.e.c.b.l(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.g):ja.a$e$c$b");
                }

                public b C(EnumC0220c enumC0220c) {
                    Objects.requireNonNull(enumC0220c);
                    this.f11049g |= 8;
                    this.f11053k = enumC0220c;
                    return this;
                }

                public b E(int i10) {
                    this.f11049g |= 2;
                    this.f11051i = i10;
                    return this;
                }

                public b F(int i10) {
                    this.f11049g |= 1;
                    this.f11050h = i10;
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
                    int i10 = this.f11049g;
                    int i11 = (i10 & 1) != 1 ? 0 : 1;
                    cVar.f11039h = this.f11050h;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    cVar.f11040i = this.f11051i;
                    if ((i10 & 4) == 4) {
                        i11 |= 4;
                    }
                    cVar.f11041j = this.f11052j;
                    if ((i10 & 8) == 8) {
                        i11 |= 8;
                    }
                    cVar.f11042k = this.f11053k;
                    if ((this.f11049g & 16) == 16) {
                        this.f11054l = Collections.unmodifiableList(this.f11054l);
                        this.f11049g &= -17;
                    }
                    cVar.f11043l = this.f11054l;
                    if ((this.f11049g & 32) == 32) {
                        this.f11055m = Collections.unmodifiableList(this.f11055m);
                        this.f11049g &= -33;
                    }
                    cVar.f11045n = this.f11055m;
                    cVar.f11038g = i11;
                    return cVar;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                /* renamed from: u, reason: merged with bridge method [inline-methods] */
                public b n() {
                    return w().p(t());
                }
            }

            /* renamed from: ja.a$e$c$c, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public enum EnumC0220c implements j.a {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);

                private static j.b<EnumC0220c> internalValueMap = new C0221a();
                private final int value;

                /* renamed from: ja.a$e$c$c$a, reason: collision with other inner class name */
                /* loaded from: classes.dex */
                static class C0221a implements j.b<EnumC0220c> {
                    C0221a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.b
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public EnumC0220c a(int i10) {
                        return EnumC0220c.valueOf(i10);
                    }
                }

                EnumC0220c(int i10, int i11) {
                    this.value = i11;
                }

                public static EnumC0220c valueOf(int i10) {
                    if (i10 == 0) {
                        return NONE;
                    }
                    if (i10 == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i10 != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.j.a
                public final int getNumber() {
                    return this.value;
                }
            }

            static {
                c cVar = new c(true);
                f11035r = cVar;
                cVar.S();
            }

            private c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
                List<Integer> list;
                Integer valueOf;
                int j10;
                this.f11044m = -1;
                this.f11046o = -1;
                this.f11047p = (byte) -1;
                this.f11048q = -1;
                S();
                d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
                f J = f.J(A, 1);
                boolean z10 = false;
                int i10 = 0;
                while (!z10) {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.f11038g |= 1;
                                    this.f11039h = eVar.s();
                                } else if (K == 16) {
                                    this.f11038g |= 2;
                                    this.f11040i = eVar.s();
                                } else if (K != 24) {
                                    if (K != 32) {
                                        if (K == 34) {
                                            j10 = eVar.j(eVar.A());
                                            if ((i10 & 16) != 16 && eVar.e() > 0) {
                                                this.f11043l = new ArrayList();
                                                i10 |= 16;
                                            }
                                            while (eVar.e() > 0) {
                                                this.f11043l.add(Integer.valueOf(eVar.s()));
                                            }
                                        } else if (K == 40) {
                                            if ((i10 & 32) != 32) {
                                                this.f11045n = new ArrayList();
                                                i10 |= 32;
                                            }
                                            list = this.f11045n;
                                            valueOf = Integer.valueOf(eVar.s());
                                        } else if (K == 42) {
                                            j10 = eVar.j(eVar.A());
                                            if ((i10 & 32) != 32 && eVar.e() > 0) {
                                                this.f11045n = new ArrayList();
                                                i10 |= 32;
                                            }
                                            while (eVar.e() > 0) {
                                                this.f11045n.add(Integer.valueOf(eVar.s()));
                                            }
                                        } else if (K == 50) {
                                            kotlin.reflect.jvm.internal.impl.protobuf.d l10 = eVar.l();
                                            this.f11038g |= 4;
                                            this.f11041j = l10;
                                        } else if (!q(eVar, J, gVar, K)) {
                                        }
                                        eVar.i(j10);
                                    } else {
                                        if ((i10 & 16) != 16) {
                                            this.f11043l = new ArrayList();
                                            i10 |= 16;
                                        }
                                        list = this.f11043l;
                                        valueOf = Integer.valueOf(eVar.s());
                                    }
                                    list.add(valueOf);
                                } else {
                                    int n10 = eVar.n();
                                    EnumC0220c valueOf2 = EnumC0220c.valueOf(n10);
                                    if (valueOf2 == null) {
                                        J.o0(K);
                                        J.o0(n10);
                                    } else {
                                        this.f11038g |= 8;
                                        this.f11042k = valueOf2;
                                    }
                                }
                            }
                            z10 = true;
                        } catch (Throwable th) {
                            if ((i10 & 16) == 16) {
                                this.f11043l = Collections.unmodifiableList(this.f11043l);
                            }
                            if ((i10 & 32) == 32) {
                                this.f11045n = Collections.unmodifiableList(this.f11045n);
                            }
                            try {
                                J.I();
                            } catch (IOException unused) {
                            } catch (Throwable th2) {
                                this.f11037f = A.j();
                                throw th2;
                            }
                            this.f11037f = A.j();
                            n();
                            throw th;
                        }
                    } catch (k e10) {
                        throw e10.i(this);
                    } catch (IOException e11) {
                        throw new k(e11.getMessage()).i(this);
                    }
                }
                if ((i10 & 16) == 16) {
                    this.f11043l = Collections.unmodifiableList(this.f11043l);
                }
                if ((i10 & 32) == 32) {
                    this.f11045n = Collections.unmodifiableList(this.f11045n);
                }
                try {
                    J.I();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f11037f = A.j();
                    throw th3;
                }
                this.f11037f = A.j();
                n();
            }

            private c(i.b bVar) {
                super(bVar);
                this.f11044m = -1;
                this.f11046o = -1;
                this.f11047p = (byte) -1;
                this.f11048q = -1;
                this.f11037f = bVar.o();
            }

            private c(boolean z10) {
                this.f11044m = -1;
                this.f11046o = -1;
                this.f11047p = (byte) -1;
                this.f11048q = -1;
                this.f11037f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
            }

            public static c E() {
                return f11035r;
            }

            private void S() {
                this.f11039h = 1;
                this.f11040i = 0;
                this.f11041j = "";
                this.f11042k = EnumC0220c.NONE;
                this.f11043l = Collections.emptyList();
                this.f11045n = Collections.emptyList();
            }

            public static b T() {
                return b.r();
            }

            public static b U(c cVar) {
                return T().p(cVar);
            }

            public EnumC0220c F() {
                return this.f11042k;
            }

            public int G() {
                return this.f11040i;
            }

            public int H() {
                return this.f11039h;
            }

            public int I() {
                return this.f11045n.size();
            }

            public List<Integer> J() {
                return this.f11045n;
            }

            public String K() {
                Object obj = this.f11041j;
                if (obj instanceof String) {
                    return (String) obj;
                }
                kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
                String G = dVar.G();
                if (dVar.x()) {
                    this.f11041j = G;
                }
                return G;
            }

            public kotlin.reflect.jvm.internal.impl.protobuf.d L() {
                Object obj = this.f11041j;
                if (!(obj instanceof String)) {
                    return (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
                }
                kotlin.reflect.jvm.internal.impl.protobuf.d s10 = kotlin.reflect.jvm.internal.impl.protobuf.d.s((String) obj);
                this.f11041j = s10;
                return s10;
            }

            public int M() {
                return this.f11043l.size();
            }

            public List<Integer> N() {
                return this.f11043l;
            }

            public boolean O() {
                return (this.f11038g & 8) == 8;
            }

            public boolean P() {
                return (this.f11038g & 2) == 2;
            }

            public boolean Q() {
                return (this.f11038g & 1) == 1;
            }

            public boolean R() {
                return (this.f11038g & 4) == 4;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            /* renamed from: V, reason: merged with bridge method [inline-methods] */
            public b h() {
                return T();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            /* renamed from: W, reason: merged with bridge method [inline-methods] */
            public b d() {
                return U(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            public int a() {
                int i10 = this.f11048q;
                if (i10 != -1) {
                    return i10;
                }
                int o10 = (this.f11038g & 1) == 1 ? f.o(1, this.f11039h) + 0 : 0;
                if ((this.f11038g & 2) == 2) {
                    o10 += f.o(2, this.f11040i);
                }
                if ((this.f11038g & 8) == 8) {
                    o10 += f.h(3, this.f11042k.getNumber());
                }
                int i11 = 0;
                for (int i12 = 0; i12 < this.f11043l.size(); i12++) {
                    i11 += f.p(this.f11043l.get(i12).intValue());
                }
                int i13 = o10 + i11;
                if (!N().isEmpty()) {
                    i13 = i13 + 1 + f.p(i11);
                }
                this.f11044m = i11;
                int i14 = 0;
                for (int i15 = 0; i15 < this.f11045n.size(); i15++) {
                    i14 += f.p(this.f11045n.get(i15).intValue());
                }
                int i16 = i13 + i14;
                if (!J().isEmpty()) {
                    i16 = i16 + 1 + f.p(i14);
                }
                this.f11046o = i14;
                if ((this.f11038g & 4) == 4) {
                    i16 += f.d(6, L());
                }
                int size = i16 + this.f11037f.size();
                this.f11048q = size;
                return size;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            public void e(f fVar) {
                a();
                if ((this.f11038g & 1) == 1) {
                    fVar.a0(1, this.f11039h);
                }
                if ((this.f11038g & 2) == 2) {
                    fVar.a0(2, this.f11040i);
                }
                if ((this.f11038g & 8) == 8) {
                    fVar.S(3, this.f11042k.getNumber());
                }
                if (N().size() > 0) {
                    fVar.o0(34);
                    fVar.o0(this.f11044m);
                }
                for (int i10 = 0; i10 < this.f11043l.size(); i10++) {
                    fVar.b0(this.f11043l.get(i10).intValue());
                }
                if (J().size() > 0) {
                    fVar.o0(42);
                    fVar.o0(this.f11046o);
                }
                for (int i11 = 0; i11 < this.f11045n.size(); i11++) {
                    fVar.b0(this.f11045n.get(i11).intValue());
                }
                if ((this.f11038g & 4) == 4) {
                    fVar.O(6, L());
                }
                fVar.i0(this.f11037f);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
            public kotlin.reflect.jvm.internal.impl.protobuf.s<c> i() {
                return f11036s;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
            public final boolean k() {
                byte b10 = this.f11047p;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                this.f11047p = (byte) 1;
                return true;
            }
        }

        static {
            e eVar = new e(true);
            f11024l = eVar;
            eVar.A();
        }

        private e(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, g gVar) {
            List list;
            Object u10;
            this.f11029i = -1;
            this.f11030j = (byte) -1;
            this.f11031k = -1;
            A();
            d.b A = kotlin.reflect.jvm.internal.impl.protobuf.d.A();
            f J = f.J(A, 1);
            boolean z10 = false;
            int i10 = 0;
            while (!z10) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 10) {
                                if ((i10 & 1) != 1) {
                                    this.f11027g = new ArrayList();
                                    i10 |= 1;
                                }
                                list = this.f11027g;
                                u10 = eVar.u(c.f11036s, gVar);
                            } else if (K == 40) {
                                if ((i10 & 2) != 2) {
                                    this.f11028h = new ArrayList();
                                    i10 |= 2;
                                }
                                list = this.f11028h;
                                u10 = Integer.valueOf(eVar.s());
                            } else if (K == 42) {
                                int j10 = eVar.j(eVar.A());
                                if ((i10 & 2) != 2 && eVar.e() > 0) {
                                    this.f11028h = new ArrayList();
                                    i10 |= 2;
                                }
                                while (eVar.e() > 0) {
                                    this.f11028h.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j10);
                            } else if (!q(eVar, J, gVar, K)) {
                            }
                            list.add(u10);
                        }
                        z10 = true;
                    } catch (Throwable th) {
                        if ((i10 & 1) == 1) {
                            this.f11027g = Collections.unmodifiableList(this.f11027g);
                        }
                        if ((i10 & 2) == 2) {
                            this.f11028h = Collections.unmodifiableList(this.f11028h);
                        }
                        try {
                            J.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f11026f = A.j();
                            throw th2;
                        }
                        this.f11026f = A.j();
                        n();
                        throw th;
                    }
                } catch (k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new k(e11.getMessage()).i(this);
                }
            }
            if ((i10 & 1) == 1) {
                this.f11027g = Collections.unmodifiableList(this.f11027g);
            }
            if ((i10 & 2) == 2) {
                this.f11028h = Collections.unmodifiableList(this.f11028h);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f11026f = A.j();
                throw th3;
            }
            this.f11026f = A.j();
            n();
        }

        private e(i.b bVar) {
            super(bVar);
            this.f11029i = -1;
            this.f11030j = (byte) -1;
            this.f11031k = -1;
            this.f11026f = bVar.o();
        }

        private e(boolean z10) {
            this.f11029i = -1;
            this.f11030j = (byte) -1;
            this.f11031k = -1;
            this.f11026f = kotlin.reflect.jvm.internal.impl.protobuf.d.f11383f;
        }

        private void A() {
            this.f11027g = Collections.emptyList();
            this.f11028h = Collections.emptyList();
        }

        public static b B() {
            return b.r();
        }

        public static b C(e eVar) {
            return B().p(eVar);
        }

        public static e F(InputStream inputStream, g gVar) {
            return f11025m.a(inputStream, gVar);
        }

        public static e x() {
            return f11024l;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public b h() {
            return B();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public b d() {
            return C(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public int a() {
            int i10 = this.f11031k;
            if (i10 != -1) {
                return i10;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.f11027g.size(); i12++) {
                i11 += f.s(1, this.f11027g.get(i12));
            }
            int i13 = 0;
            for (int i14 = 0; i14 < this.f11028h.size(); i14++) {
                i13 += f.p(this.f11028h.get(i14).intValue());
            }
            int i15 = i11 + i13;
            if (!y().isEmpty()) {
                i15 = i15 + 1 + f.p(i13);
            }
            this.f11029i = i13;
            int size = i15 + this.f11026f.size();
            this.f11031k = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        public void e(f fVar) {
            a();
            for (int i10 = 0; i10 < this.f11027g.size(); i10++) {
                fVar.d0(1, this.f11027g.get(i10));
            }
            if (y().size() > 0) {
                fVar.o0(42);
                fVar.o0(this.f11029i);
            }
            for (int i11 = 0; i11 < this.f11028h.size(); i11++) {
                fVar.b0(this.f11028h.get(i11).intValue());
            }
            fVar.i0(this.f11026f);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i, kotlin.reflect.jvm.internal.impl.protobuf.q
        public kotlin.reflect.jvm.internal.impl.protobuf.s<e> i() {
            return f11025m;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.r
        public final boolean k() {
            byte b10 = this.f11030j;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f11030j = (byte) 1;
            return true;
        }

        public List<Integer> y() {
            return this.f11028h;
        }

        public List<c> z() {
            return this.f11027g;
        }
    }

    static {
        ga.d J = ga.d.J();
        c w10 = c.w();
        c w11 = c.w();
        z.b bVar = z.b.MESSAGE;
        f10973a = i.p(J, w10, w11, null, 100, bVar, c.class);
        f10974b = i.p(ga.i.U(), c.w(), c.w(), null, 100, bVar, c.class);
        ga.i U = ga.i.U();
        z.b bVar2 = z.b.INT32;
        f10975c = i.p(U, 0, null, null, 101, bVar2, Integer.class);
        f10976d = i.p(n.S(), d.y(), d.y(), null, 100, bVar, d.class);
        f10977e = i.p(n.S(), 0, null, null, 101, bVar2, Integer.class);
        f10978f = i.o(q.Z(), ga.b.A(), null, 100, bVar, false, ga.b.class);
        f10979g = i.p(q.Z(), Boolean.FALSE, null, null, 101, z.b.BOOL, Boolean.class);
        f10980h = i.o(s.M(), ga.b.A(), null, 100, bVar, false, ga.b.class);
        f10981i = i.p(ga.c.j0(), 0, null, null, 101, bVar2, Integer.class);
        f10982j = i.o(ga.c.j0(), n.S(), null, 102, bVar, false, n.class);
        f10983k = i.p(ga.c.j0(), 0, null, null, 103, bVar2, Integer.class);
        f10984l = i.p(ga.c.j0(), 0, null, null, 104, bVar2, Integer.class);
        f10985m = i.p(l.M(), 0, null, null, 101, bVar2, Integer.class);
        f10986n = i.o(l.M(), n.S(), null, 102, bVar, false, n.class);
    }

    public static void a(g gVar) {
        gVar.a(f10973a);
        gVar.a(f10974b);
        gVar.a(f10975c);
        gVar.a(f10976d);
        gVar.a(f10977e);
        gVar.a(f10978f);
        gVar.a(f10979g);
        gVar.a(f10980h);
        gVar.a(f10981i);
        gVar.a(f10982j);
        gVar.a(f10983k);
        gVar.a(f10984l);
        gVar.a(f10985m);
        gVar.a(f10986n);
    }
}
