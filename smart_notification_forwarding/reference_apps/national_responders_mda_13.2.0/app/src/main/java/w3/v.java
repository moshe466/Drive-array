package w3;

import com.google.auto.value.AutoValue;
import java.nio.charset.Charset;
import w3.b;
import w3.c;
import w3.d;
import w3.e;
import w3.f;
import w3.g;
import w3.i;
import w3.j;
import w3.k;
import w3.l;
import w3.m;
import w3.n;
import w3.o;
import w3.p;
import w3.q;
import w3.r;
import w3.s;
import w3.t;
import w3.u;

@AutoValue
/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f15100a = Charset.forName("UTF-8");

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract v a();

        public abstract a b(String str);

        public abstract a c(String str);

        public abstract a d(String str);

        public abstract a e(String str);

        public abstract a f(c cVar);

        public abstract a g(int i10);

        public abstract a h(String str);

        public abstract a i(d dVar);
    }

    @AutoValue
    /* loaded from: classes.dex */
    public static abstract class b {

        @AutoValue.Builder
        /* loaded from: classes.dex */
        public static abstract class a {
            public abstract b a();

            public abstract a b(String str);

            public abstract a c(String str);
        }

        public static a a() {
            return new c.b();
        }

        public abstract String b();

        public abstract String c();
    }

    @AutoValue
    /* loaded from: classes.dex */
    public static abstract class c {

        @AutoValue.Builder
        /* loaded from: classes.dex */
        public static abstract class a {
            public abstract c a();

            public abstract a b(w<b> wVar);

            public abstract a c(String str);
        }

        @AutoValue
        /* loaded from: classes.dex */
        public static abstract class b {

            @AutoValue.Builder
            /* loaded from: classes.dex */
            public static abstract class a {
                public abstract b a();

                public abstract a b(byte[] bArr);

                public abstract a c(String str);
            }

            public static a a() {
                return new e.b();
            }

            public abstract byte[] b();

            public abstract String c();
        }

        public static a a() {
            return new d.b();
        }

        public abstract w<b> b();

        public abstract String c();
    }

    @AutoValue
    /* loaded from: classes.dex */
    public static abstract class d {

        @AutoValue
        /* loaded from: classes.dex */
        public static abstract class a {

            @AutoValue.Builder
            /* renamed from: w3.v$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static abstract class AbstractC0311a {
                public abstract a a();

                public abstract AbstractC0311a b(String str);

                public abstract AbstractC0311a c(String str);

                public abstract AbstractC0311a d(String str);

                public abstract AbstractC0311a e(String str);

                public abstract AbstractC0311a f(String str);

                public abstract AbstractC0311a g(String str);
            }

            @AutoValue
            /* loaded from: classes.dex */
            public static abstract class b {
                public abstract String a();
            }

            public static AbstractC0311a a() {
                return new g.b();
            }

            public abstract String b();

            public abstract String c();

            public abstract String d();

            public abstract String e();

            public abstract String f();

            public abstract b g();

            public abstract String h();
        }

        @AutoValue.Builder
        /* loaded from: classes.dex */
        public static abstract class b {
            public abstract d a();

            public abstract b b(a aVar);

            public abstract b c(boolean z10);

            public abstract b d(c cVar);

            public abstract b e(Long l10);

            public abstract b f(w<AbstractC0312d> wVar);

            public abstract b g(String str);

            public abstract b h(int i10);

            public abstract b i(String str);

            public b j(byte[] bArr) {
                return i(new String(bArr, v.f15100a));
            }

            public abstract b k(e eVar);

            public abstract b l(long j10);

            public abstract b m(f fVar);
        }

        @AutoValue
        /* loaded from: classes.dex */
        public static abstract class c {

            @AutoValue.Builder
            /* loaded from: classes.dex */
            public static abstract class a {
                public abstract c a();

                public abstract a b(int i10);

                public abstract a c(int i10);

                public abstract a d(long j10);

                public abstract a e(String str);

                public abstract a f(String str);

                public abstract a g(String str);

                public abstract a h(long j10);

                public abstract a i(boolean z10);

                public abstract a j(int i10);
            }

            public static a a() {
                return new i.b();
            }

            public abstract int b();

            public abstract int c();

            public abstract long d();

            public abstract String e();

            public abstract String f();

            public abstract String g();

            public abstract long h();

            public abstract int i();

            public abstract boolean j();
        }

        @AutoValue
        /* renamed from: w3.v$d$d, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static abstract class AbstractC0312d {

            @AutoValue
            /* renamed from: w3.v$d$d$a */
            /* loaded from: classes.dex */
            public static abstract class a {

                @AutoValue.Builder
                /* renamed from: w3.v$d$d$a$a, reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public static abstract class AbstractC0313a {
                    public abstract a a();

                    public abstract AbstractC0313a b(Boolean bool);

                    public abstract AbstractC0313a c(w<b> wVar);

                    public abstract AbstractC0313a d(b bVar);

                    public abstract AbstractC0313a e(int i10);
                }

                @AutoValue
                /* renamed from: w3.v$d$d$a$b */
                /* loaded from: classes.dex */
                public static abstract class b {

                    @AutoValue
                    /* renamed from: w3.v$d$d$a$b$a, reason: collision with other inner class name */
                    /* loaded from: classes.dex */
                    public static abstract class AbstractC0314a {

                        @AutoValue.Builder
                        /* renamed from: w3.v$d$d$a$b$a$a, reason: collision with other inner class name */
                        /* loaded from: classes.dex */
                        public static abstract class AbstractC0315a {
                            public abstract AbstractC0314a a();

                            public abstract AbstractC0315a b(long j10);

                            public abstract AbstractC0315a c(String str);

                            public abstract AbstractC0315a d(long j10);

                            public abstract AbstractC0315a e(String str);

                            public AbstractC0315a f(byte[] bArr) {
                                return e(new String(bArr, v.f15100a));
                            }
                        }

                        public static AbstractC0315a a() {
                            return new m.b();
                        }

                        public abstract long b();

                        public abstract String c();

                        public abstract long d();

                        public abstract String e();

                        public byte[] f() {
                            String e10 = e();
                            if (e10 != null) {
                                return e10.getBytes(v.f15100a);
                            }
                            return null;
                        }
                    }

                    @AutoValue.Builder
                    /* renamed from: w3.v$d$d$a$b$b, reason: collision with other inner class name */
                    /* loaded from: classes.dex */
                    public static abstract class AbstractC0316b {
                        public abstract b a();

                        public abstract AbstractC0316b b(w<AbstractC0314a> wVar);

                        public abstract AbstractC0316b c(c cVar);

                        public abstract AbstractC0316b d(AbstractC0318d abstractC0318d);

                        public abstract AbstractC0316b e(w<e> wVar);
                    }

                    @AutoValue
                    /* renamed from: w3.v$d$d$a$b$c */
                    /* loaded from: classes.dex */
                    public static abstract class c {

                        @AutoValue.Builder
                        /* renamed from: w3.v$d$d$a$b$c$a, reason: collision with other inner class name */
                        /* loaded from: classes.dex */
                        public static abstract class AbstractC0317a {
                            public abstract c a();

                            public abstract AbstractC0317a b(c cVar);

                            public abstract AbstractC0317a c(w<e.AbstractC0321b> wVar);

                            public abstract AbstractC0317a d(int i10);

                            public abstract AbstractC0317a e(String str);

                            public abstract AbstractC0317a f(String str);
                        }

                        public static AbstractC0317a a() {
                            return new n.b();
                        }

                        public abstract c b();

                        public abstract w<e.AbstractC0321b> c();

                        public abstract int d();

                        public abstract String e();

                        public abstract String f();
                    }

                    @AutoValue
                    /* renamed from: w3.v$d$d$a$b$d, reason: collision with other inner class name */
                    /* loaded from: classes.dex */
                    public static abstract class AbstractC0318d {

                        @AutoValue.Builder
                        /* renamed from: w3.v$d$d$a$b$d$a, reason: collision with other inner class name */
                        /* loaded from: classes.dex */
                        public static abstract class AbstractC0319a {
                            public abstract AbstractC0318d a();

                            public abstract AbstractC0319a b(long j10);

                            public abstract AbstractC0319a c(String str);

                            public abstract AbstractC0319a d(String str);
                        }

                        public static AbstractC0319a a() {
                            return new o.b();
                        }

                        public abstract long b();

                        public abstract String c();

                        public abstract String d();
                    }

                    @AutoValue
                    /* renamed from: w3.v$d$d$a$b$e */
                    /* loaded from: classes.dex */
                    public static abstract class e {

                        @AutoValue.Builder
                        /* renamed from: w3.v$d$d$a$b$e$a, reason: collision with other inner class name */
                        /* loaded from: classes.dex */
                        public static abstract class AbstractC0320a {
                            public abstract e a();

                            public abstract AbstractC0320a b(w<AbstractC0321b> wVar);

                            public abstract AbstractC0320a c(int i10);

                            public abstract AbstractC0320a d(String str);
                        }

                        @AutoValue
                        /* renamed from: w3.v$d$d$a$b$e$b, reason: collision with other inner class name */
                        /* loaded from: classes.dex */
                        public static abstract class AbstractC0321b {

                            @AutoValue.Builder
                            /* renamed from: w3.v$d$d$a$b$e$b$a, reason: collision with other inner class name */
                            /* loaded from: classes.dex */
                            public static abstract class AbstractC0322a {
                                public abstract AbstractC0321b a();

                                public abstract AbstractC0322a b(String str);

                                public abstract AbstractC0322a c(int i10);

                                public abstract AbstractC0322a d(long j10);

                                public abstract AbstractC0322a e(long j10);

                                public abstract AbstractC0322a f(String str);
                            }

                            public static AbstractC0322a a() {
                                return new q.b();
                            }

                            public abstract String b();

                            public abstract int c();

                            public abstract long d();

                            public abstract long e();

                            public abstract String f();
                        }

                        public static AbstractC0320a a() {
                            return new p.b();
                        }

                        public abstract w<AbstractC0321b> b();

                        public abstract int c();

                        public abstract String d();
                    }

                    public static AbstractC0316b a() {
                        return new l.b();
                    }

                    public abstract w<AbstractC0314a> b();

                    public abstract c c();

                    public abstract AbstractC0318d d();

                    public abstract w<e> e();
                }

                public static AbstractC0313a a() {
                    return new k.b();
                }

                public abstract Boolean b();

                public abstract w<b> c();

                public abstract b d();

                public abstract int e();

                public abstract AbstractC0313a f();
            }

            @AutoValue.Builder
            /* renamed from: w3.v$d$d$b */
            /* loaded from: classes.dex */
            public static abstract class b {
                public abstract AbstractC0312d a();

                public abstract b b(a aVar);

                public abstract b c(c cVar);

                public abstract b d(AbstractC0323d abstractC0323d);

                public abstract b e(long j10);

                public abstract b f(String str);
            }

            @AutoValue
            /* renamed from: w3.v$d$d$c */
            /* loaded from: classes.dex */
            public static abstract class c {

                @AutoValue.Builder
                /* renamed from: w3.v$d$d$c$a */
                /* loaded from: classes.dex */
                public static abstract class a {
                    public abstract c a();

                    public abstract a b(Double d10);

                    public abstract a c(int i10);

                    public abstract a d(long j10);

                    public abstract a e(int i10);

                    public abstract a f(boolean z10);

                    public abstract a g(long j10);
                }

                public static a a() {
                    return new r.b();
                }

                public abstract Double b();

                public abstract int c();

                public abstract long d();

                public abstract int e();

                public abstract long f();

                public abstract boolean g();
            }

            @AutoValue
            /* renamed from: w3.v$d$d$d, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public static abstract class AbstractC0323d {

                @AutoValue.Builder
                /* renamed from: w3.v$d$d$d$a */
                /* loaded from: classes.dex */
                public static abstract class a {
                    public abstract AbstractC0323d a();

                    public abstract a b(String str);
                }

                public static a a() {
                    return new s.b();
                }

                public abstract String b();
            }

            public static b a() {
                return new j.b();
            }

            public abstract a b();

            public abstract c c();

            public abstract AbstractC0323d d();

            public abstract long e();

            public abstract String f();

            public abstract b g();
        }

        @AutoValue
        /* loaded from: classes.dex */
        public static abstract class e {

            @AutoValue.Builder
            /* loaded from: classes.dex */
            public static abstract class a {
                public abstract e a();

                public abstract a b(String str);

                public abstract a c(boolean z10);

                public abstract a d(int i10);

                public abstract a e(String str);
            }

            public static a a() {
                return new t.b();
            }

            public abstract String b();

            public abstract int c();

            public abstract String d();

            public abstract boolean e();
        }

        @AutoValue
        /* loaded from: classes.dex */
        public static abstract class f {

            @AutoValue.Builder
            /* loaded from: classes.dex */
            public static abstract class a {
                public abstract f a();

                public abstract a b(String str);
            }

            public static a a() {
                return new u.b();
            }

            public abstract String b();
        }

        public static b a() {
            return new f.b().c(false);
        }

        public abstract a b();

        public abstract c c();

        public abstract Long d();

        public abstract w<AbstractC0312d> e();

        public abstract String f();

        public abstract int g();

        public abstract String h();

        public byte[] i() {
            return h().getBytes(v.f15100a);
        }

        public abstract e j();

        public abstract long k();

        public abstract f l();

        public abstract boolean m();

        public abstract b n();

        d o(w<AbstractC0312d> wVar) {
            return n().f(wVar).a();
        }

        d p(long j10, boolean z10, String str) {
            b n10 = n();
            n10.e(Long.valueOf(j10));
            n10.c(z10);
            if (str != null) {
                n10.m(f.a().b(str).a()).a();
            }
            return n10.a();
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        INCOMPLETE,
        JAVA,
        NATIVE
    }

    public static a b() {
        return new b.C0310b();
    }

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract c g();

    public abstract int h();

    public abstract String i();

    public abstract d j();

    public e k() {
        return j() != null ? e.JAVA : g() != null ? e.NATIVE : e.INCOMPLETE;
    }

    protected abstract a l();

    public v m(w<d.AbstractC0312d> wVar) {
        if (j() != null) {
            return l().i(j().o(wVar)).a();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    public v n(c cVar) {
        return l().i(null).f(cVar).a();
    }

    public v o(long j10, boolean z10, String str) {
        a l10 = l();
        if (j() != null) {
            l10.i(j().p(j10, z10, str));
        }
        return l10.a();
    }
}
