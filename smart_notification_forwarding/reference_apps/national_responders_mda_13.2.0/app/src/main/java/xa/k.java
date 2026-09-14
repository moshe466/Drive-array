package xa;

/* loaded from: classes.dex */
public interface k {

    /* loaded from: classes.dex */
    public static final class a implements k {

        /* renamed from: a, reason: collision with root package name */
        public static final a f15605a = new a();

        private a() {
        }

        @Override // xa.k
        public boolean a() {
            return b.b(this);
        }

        @Override // xa.k
        public boolean b() {
            return b.a(this);
        }

        @Override // xa.k
        public boolean c() {
            return b.f(this);
        }

        @Override // xa.k
        public boolean d() {
            return b.g(this);
        }

        @Override // xa.k
        public boolean e() {
            return b.e(this);
        }

        @Override // xa.k
        public boolean f() {
            return b.c(this);
        }

        @Override // xa.k
        public boolean g() {
            return b.d(this);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static boolean a(k kVar) {
            y8.k.e(kVar, "this");
            return false;
        }

        public static boolean b(k kVar) {
            y8.k.e(kVar, "this");
            return false;
        }

        public static boolean c(k kVar) {
            y8.k.e(kVar, "this");
            return false;
        }

        public static boolean d(k kVar) {
            y8.k.e(kVar, "this");
            return false;
        }

        public static boolean e(k kVar) {
            y8.k.e(kVar, "this");
            return false;
        }

        public static boolean f(k kVar) {
            y8.k.e(kVar, "this");
            return false;
        }

        public static boolean g(k kVar) {
            y8.k.e(kVar, "this");
            return true;
        }
    }

    boolean a();

    boolean b();

    boolean c();

    boolean d();

    boolean e();

    boolean f();

    boolean g();
}
