package n9;

import java.util.Map;

/* loaded from: classes.dex */
public final class g1 {

    /* renamed from: a, reason: collision with root package name */
    public static final g1 f12279a = new g1();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<h1, Integer> f12280b;

    /* loaded from: classes.dex */
    public static final class a extends h1 {

        /* renamed from: c, reason: collision with root package name */
        public static final a f12281c = new a();

        private a() {
            super("inherited", false);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends h1 {

        /* renamed from: c, reason: collision with root package name */
        public static final b f12282c = new b();

        private b() {
            super("internal", false);
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends h1 {

        /* renamed from: c, reason: collision with root package name */
        public static final c f12283c = new c();

        private c() {
            super("invisible_fake", false);
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends h1 {

        /* renamed from: c, reason: collision with root package name */
        public static final d f12284c = new d();

        private d() {
            super("local", false);
        }
    }

    /* loaded from: classes.dex */
    public static final class e extends h1 {

        /* renamed from: c, reason: collision with root package name */
        public static final e f12285c = new e();

        private e() {
            super("private", false);
        }
    }

    /* loaded from: classes.dex */
    public static final class f extends h1 {

        /* renamed from: c, reason: collision with root package name */
        public static final f f12286c = new f();

        private f() {
            super("private_to_this", false);
        }

        @Override // n9.h1
        public String b() {
            return "private/*private to this*/";
        }
    }

    /* loaded from: classes.dex */
    public static final class g extends h1 {

        /* renamed from: c, reason: collision with root package name */
        public static final g f12287c = new g();

        private g() {
            super("protected", true);
        }
    }

    /* loaded from: classes.dex */
    public static final class h extends h1 {

        /* renamed from: c, reason: collision with root package name */
        public static final h f12288c = new h();

        private h() {
            super("public", true);
        }
    }

    /* loaded from: classes.dex */
    public static final class i extends h1 {

        /* renamed from: c, reason: collision with root package name */
        public static final i f12289c = new i();

        private i() {
            super("unknown", false);
        }
    }

    static {
        Map c10 = m8.i0.c();
        c10.put(f.f12286c, 0);
        c10.put(e.f12285c, 0);
        c10.put(b.f12282c, 1);
        c10.put(g.f12287c, 1);
        c10.put(h.f12288c, 2);
        f12280b = m8.i0.b(c10);
    }

    private g1() {
    }

    public final Integer a(h1 h1Var, h1 h1Var2) {
        y8.k.e(h1Var, "first");
        y8.k.e(h1Var2, "second");
        if (h1Var == h1Var2) {
            return 0;
        }
        Map<h1, Integer> map = f12280b;
        Integer num = map.get(h1Var);
        Integer num2 = map.get(h1Var2);
        if (num == null || num2 == null || y8.k.a(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean b(h1 h1Var) {
        y8.k.e(h1Var, "visibility");
        return h1Var == e.f12285c || h1Var == f.f12286c;
    }
}
