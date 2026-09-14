package w6;

/* loaded from: classes.dex */
public class z {

    /* renamed from: b, reason: collision with root package name */
    static z f15296b;

    /* renamed from: a, reason: collision with root package name */
    String f15297a = m.d();

    private z() {
    }

    public static z b() {
        if (f15296b == null) {
            f15296b = new z();
        }
        return f15296b;
    }

    public synchronized void a() {
        this.f15297a = null;
        m.c();
    }

    public synchronized String c() {
        if (this.f15297a == null) {
            this.f15297a = m.d();
        }
        return this.f15297a;
    }

    public synchronized boolean d() {
        String str = this.f15297a;
        if (str != null && str.length() > 0) {
            return true;
        }
        String d10 = m.d();
        this.f15297a = d10;
        if (d10 != null) {
            if (d10.length() != 0) {
                return true;
            }
        }
        return false;
    }

    public synchronized void e(boolean z10) {
        m.k0(z10);
    }

    public synchronized void f(String str) {
        this.f15297a = str;
        m.L0(str);
    }
}
