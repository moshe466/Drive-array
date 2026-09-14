package gb;

import bb.b0;
import bb.i0;
import gb.b;
import n9.x;

/* loaded from: classes.dex */
public abstract class k implements gb.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f10391a;

    /* renamed from: b, reason: collision with root package name */
    private final x8.l<k9.h, b0> f10392b;

    /* renamed from: c, reason: collision with root package name */
    private final String f10393c;

    /* loaded from: classes.dex */
    public static final class a extends k {

        /* renamed from: d, reason: collision with root package name */
        public static final a f10394d = new a();

        /* renamed from: gb.k$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0184a extends y8.l implements x8.l<k9.h, b0> {

            /* renamed from: f, reason: collision with root package name */
            public static final C0184a f10395f = new C0184a();

            C0184a() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b0 h(k9.h hVar) {
                y8.k.e(hVar, "<this>");
                i0 n10 = hVar.n();
                y8.k.d(n10, "booleanType");
                return n10;
            }
        }

        private a() {
            super("Boolean", C0184a.f10395f, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends k {

        /* renamed from: d, reason: collision with root package name */
        public static final b f10396d = new b();

        /* loaded from: classes.dex */
        static final class a extends y8.l implements x8.l<k9.h, b0> {

            /* renamed from: f, reason: collision with root package name */
            public static final a f10397f = new a();

            a() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b0 h(k9.h hVar) {
                y8.k.e(hVar, "<this>");
                i0 D = hVar.D();
                y8.k.d(D, "intType");
                return D;
            }
        }

        private b() {
            super("Int", a.f10397f, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends k {

        /* renamed from: d, reason: collision with root package name */
        public static final c f10398d = new c();

        /* loaded from: classes.dex */
        static final class a extends y8.l implements x8.l<k9.h, b0> {

            /* renamed from: f, reason: collision with root package name */
            public static final a f10399f = new a();

            a() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b0 h(k9.h hVar) {
                y8.k.e(hVar, "<this>");
                i0 Y = hVar.Y();
                y8.k.d(Y, "unitType");
                return Y;
            }
        }

        private c() {
            super("Unit", a.f10399f, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private k(String str, x8.l<? super k9.h, ? extends b0> lVar) {
        this.f10391a = str;
        this.f10392b = lVar;
        this.f10393c = y8.k.j("must return ", str);
    }

    public /* synthetic */ k(String str, x8.l lVar, y8.g gVar) {
        this(str, lVar);
    }

    @Override // gb.b
    public String a() {
        return this.f10393c;
    }

    @Override // gb.b
    public boolean b(x xVar) {
        y8.k.e(xVar, "functionDescriptor");
        return y8.k.a(xVar.i(), this.f10392b.h(ra.a.g(xVar)));
    }

    @Override // gb.b
    public String c(x xVar) {
        return b.a.a(this, xVar);
    }
}
