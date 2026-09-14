package gb;

import gb.b;
import n9.x;

/* loaded from: classes.dex */
public abstract class f implements gb.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f10354a;

    /* loaded from: classes.dex */
    public static final class a extends f {

        /* renamed from: b, reason: collision with root package name */
        public static final a f10355b = new a();

        private a() {
            super("must be a member function", null);
        }

        @Override // gb.b
        public boolean b(x xVar) {
            y8.k.e(xVar, "functionDescriptor");
            return xVar.K() != null;
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends f {

        /* renamed from: b, reason: collision with root package name */
        public static final b f10356b = new b();

        private b() {
            super("must be a member or an extension function", null);
        }

        @Override // gb.b
        public boolean b(x xVar) {
            y8.k.e(xVar, "functionDescriptor");
            return (xVar.K() == null && xVar.U() == null) ? false : true;
        }
    }

    private f(String str) {
        this.f10354a = str;
    }

    public /* synthetic */ f(String str, y8.g gVar) {
        this(str);
    }

    @Override // gb.b
    public String a() {
        return this.f10354a;
    }

    @Override // gb.b
    public String c(x xVar) {
        return b.a.a(this, xVar);
    }
}
