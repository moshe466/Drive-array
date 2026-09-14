package n5;

/* loaded from: classes.dex */
public class e {

    /* renamed from: f, reason: collision with root package name */
    private static e f12228f;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f12229a = null;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f12230b = null;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f12231c = null;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f12232d = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f12233e = false;

    private e() {
    }

    public static e k() {
        if (f12228f == null) {
            f12228f = new e();
        }
        return f12228f;
    }

    private void l(boolean z10) {
        if (!z10 || this.f12233e) {
            return;
        }
        this.f12229a = null;
        this.f12230b = null;
        this.f12231c = null;
        this.f12232d = null;
        this.f12233e = true;
    }

    public byte[] a(boolean z10) {
        l(z10);
        if (this.f12229a == null) {
            this.f12229a = c.d().c();
        }
        return this.f12229a;
    }

    public byte[] b(boolean z10) {
        return b.d(h(z10), d.h().f(z10));
    }

    public byte[] c(boolean z10) {
        return b.d(b.a(d(z10), h(z10)), i(z10));
    }

    public byte[] d(boolean z10) {
        l(z10);
        if (this.f12230b == null) {
            this.f12230b = c.d().c();
        }
        return this.f12230b;
    }

    public byte[] e(boolean z10) {
        return b.d(b.d(b.b(a(z10)), d.h().f(z10)), b.b(j(z10)));
    }

    public byte[] f(boolean z10) {
        return b.a(b.c(b.b(d.h().f(z10)), d.h().g(z10)), d(z10));
    }

    public byte[] g(boolean z10) {
        return b.d(b.b(d.h().g(z10)), b.a(a(z10), b(z10)));
    }

    public byte[] h(boolean z10) {
        l(z10);
        if (this.f12231c == null) {
            this.f12231c = c.d().c();
        }
        return this.f12231c;
    }

    public byte[] i(boolean z10) {
        return b.d(b.b(j(z10)), d.h().g(z10));
    }

    public byte[] j(boolean z10) {
        l(z10);
        if (this.f12232d == null) {
            byte[] c10 = c.d().c();
            this.f12232d = c10;
            c10[0] = 0;
            if (m5.a.b().a()) {
                this.f12232d[0] = Byte.MAX_VALUE;
            }
        }
        return this.f12232d;
    }
}
