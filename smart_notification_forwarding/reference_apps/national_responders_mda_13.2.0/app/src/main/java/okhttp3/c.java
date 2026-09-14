package okhttp3;

import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f12686a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f12687b;

    /* renamed from: c, reason: collision with root package name */
    private final int f12688c;

    /* renamed from: d, reason: collision with root package name */
    private final int f12689d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f12690e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f12691f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f12692g;

    /* renamed from: h, reason: collision with root package name */
    private final int f12693h;

    /* renamed from: i, reason: collision with root package name */
    private final int f12694i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f12695j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f12696k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f12697l;

    /* renamed from: m, reason: collision with root package name */
    String f12698m;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f12699a;

        /* renamed from: b, reason: collision with root package name */
        boolean f12700b;

        /* renamed from: c, reason: collision with root package name */
        int f12701c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f12702d = -1;

        /* renamed from: e, reason: collision with root package name */
        int f12703e = -1;

        /* renamed from: f, reason: collision with root package name */
        boolean f12704f;

        /* renamed from: g, reason: collision with root package name */
        boolean f12705g;

        /* renamed from: h, reason: collision with root package name */
        boolean f12706h;

        public c a() {
            return new c(this);
        }

        public a b(int i10, TimeUnit timeUnit) {
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds(i10);
                this.f12702d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i10);
        }

        public a c() {
            this.f12699a = true;
            return this;
        }

        public a d() {
            this.f12704f = true;
            return this;
        }
    }

    static {
        new a().c().a();
        new a().d().b(Integer.MAX_VALUE, TimeUnit.SECONDS).a();
    }

    c(a aVar) {
        this.f12686a = aVar.f12699a;
        this.f12687b = aVar.f12700b;
        this.f12688c = aVar.f12701c;
        this.f12689d = -1;
        this.f12690e = false;
        this.f12691f = false;
        this.f12692g = false;
        this.f12693h = aVar.f12702d;
        this.f12694i = aVar.f12703e;
        this.f12695j = aVar.f12704f;
        this.f12696k = aVar.f12705g;
        this.f12697l = aVar.f12706h;
    }

    private c(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str) {
        this.f12686a = z10;
        this.f12687b = z11;
        this.f12688c = i10;
        this.f12689d = i11;
        this.f12690e = z12;
        this.f12691f = z13;
        this.f12692g = z14;
        this.f12693h = i12;
        this.f12694i = i13;
        this.f12695j = z15;
        this.f12696k = z16;
        this.f12697l = z17;
        this.f12698m = str;
    }

    private String a() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f12686a) {
            sb2.append("no-cache, ");
        }
        if (this.f12687b) {
            sb2.append("no-store, ");
        }
        if (this.f12688c != -1) {
            sb2.append("max-age=");
            sb2.append(this.f12688c);
            sb2.append(", ");
        }
        if (this.f12689d != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.f12689d);
            sb2.append(", ");
        }
        if (this.f12690e) {
            sb2.append("private, ");
        }
        if (this.f12691f) {
            sb2.append("public, ");
        }
        if (this.f12692g) {
            sb2.append("must-revalidate, ");
        }
        if (this.f12693h != -1) {
            sb2.append("max-stale=");
            sb2.append(this.f12693h);
            sb2.append(", ");
        }
        if (this.f12694i != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.f12694i);
            sb2.append(", ");
        }
        if (this.f12695j) {
            sb2.append("only-if-cached, ");
        }
        if (this.f12696k) {
            sb2.append("no-transform, ");
        }
        if (this.f12697l) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static okhttp3.c k(okhttp3.q r22) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.c.k(okhttp3.q):okhttp3.c");
    }

    public boolean b() {
        return this.f12690e;
    }

    public boolean c() {
        return this.f12691f;
    }

    public int d() {
        return this.f12688c;
    }

    public int e() {
        return this.f12693h;
    }

    public int f() {
        return this.f12694i;
    }

    public boolean g() {
        return this.f12692g;
    }

    public boolean h() {
        return this.f12686a;
    }

    public boolean i() {
        return this.f12687b;
    }

    public boolean j() {
        return this.f12695j;
    }

    public String toString() {
        String str = this.f12698m;
        if (str != null) {
            return str;
        }
        String a10 = a();
        this.f12698m = a10;
        return a10;
    }
}
