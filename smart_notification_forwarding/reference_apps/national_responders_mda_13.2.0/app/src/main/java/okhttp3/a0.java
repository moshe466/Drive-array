package okhttp3;

import java.io.Closeable;
import okhttp3.q;

/* loaded from: classes.dex */
public final class a0 implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    final y f12657f;

    /* renamed from: g, reason: collision with root package name */
    final w f12658g;

    /* renamed from: h, reason: collision with root package name */
    final int f12659h;

    /* renamed from: i, reason: collision with root package name */
    final String f12660i;

    /* renamed from: j, reason: collision with root package name */
    final p f12661j;

    /* renamed from: k, reason: collision with root package name */
    final q f12662k;

    /* renamed from: l, reason: collision with root package name */
    final b0 f12663l;

    /* renamed from: m, reason: collision with root package name */
    final a0 f12664m;

    /* renamed from: n, reason: collision with root package name */
    final a0 f12665n;

    /* renamed from: o, reason: collision with root package name */
    final a0 f12666o;

    /* renamed from: p, reason: collision with root package name */
    final long f12667p;

    /* renamed from: q, reason: collision with root package name */
    final long f12668q;

    /* renamed from: r, reason: collision with root package name */
    private volatile c f12669r;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        y f12670a;

        /* renamed from: b, reason: collision with root package name */
        w f12671b;

        /* renamed from: c, reason: collision with root package name */
        int f12672c;

        /* renamed from: d, reason: collision with root package name */
        String f12673d;

        /* renamed from: e, reason: collision with root package name */
        p f12674e;

        /* renamed from: f, reason: collision with root package name */
        q.a f12675f;

        /* renamed from: g, reason: collision with root package name */
        b0 f12676g;

        /* renamed from: h, reason: collision with root package name */
        a0 f12677h;

        /* renamed from: i, reason: collision with root package name */
        a0 f12678i;

        /* renamed from: j, reason: collision with root package name */
        a0 f12679j;

        /* renamed from: k, reason: collision with root package name */
        long f12680k;

        /* renamed from: l, reason: collision with root package name */
        long f12681l;

        public a() {
            this.f12672c = -1;
            this.f12675f = new q.a();
        }

        a(a0 a0Var) {
            this.f12672c = -1;
            this.f12670a = a0Var.f12657f;
            this.f12671b = a0Var.f12658g;
            this.f12672c = a0Var.f12659h;
            this.f12673d = a0Var.f12660i;
            this.f12674e = a0Var.f12661j;
            this.f12675f = a0Var.f12662k.f();
            this.f12676g = a0Var.f12663l;
            this.f12677h = a0Var.f12664m;
            this.f12678i = a0Var.f12665n;
            this.f12679j = a0Var.f12666o;
            this.f12680k = a0Var.f12667p;
            this.f12681l = a0Var.f12668q;
        }

        private void e(a0 a0Var) {
            if (a0Var.f12663l != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void f(String str, a0 a0Var) {
            if (a0Var.f12663l != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (a0Var.f12664m != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (a0Var.f12665n != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (a0Var.f12666o == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public a a(String str, String str2) {
            this.f12675f.a(str, str2);
            return this;
        }

        public a b(b0 b0Var) {
            this.f12676g = b0Var;
            return this;
        }

        public a0 c() {
            if (this.f12670a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f12671b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f12672c >= 0) {
                if (this.f12673d != null) {
                    return new a0(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.f12672c);
        }

        public a d(a0 a0Var) {
            if (a0Var != null) {
                f("cacheResponse", a0Var);
            }
            this.f12678i = a0Var;
            return this;
        }

        public a g(int i10) {
            this.f12672c = i10;
            return this;
        }

        public a h(p pVar) {
            this.f12674e = pVar;
            return this;
        }

        public a i(String str, String str2) {
            this.f12675f.f(str, str2);
            return this;
        }

        public a j(q qVar) {
            this.f12675f = qVar.f();
            return this;
        }

        public a k(String str) {
            this.f12673d = str;
            return this;
        }

        public a l(a0 a0Var) {
            if (a0Var != null) {
                f("networkResponse", a0Var);
            }
            this.f12677h = a0Var;
            return this;
        }

        public a m(a0 a0Var) {
            if (a0Var != null) {
                e(a0Var);
            }
            this.f12679j = a0Var;
            return this;
        }

        public a n(w wVar) {
            this.f12671b = wVar;
            return this;
        }

        public a o(long j10) {
            this.f12681l = j10;
            return this;
        }

        public a p(y yVar) {
            this.f12670a = yVar;
            return this;
        }

        public a q(long j10) {
            this.f12680k = j10;
            return this;
        }
    }

    a0(a aVar) {
        this.f12657f = aVar.f12670a;
        this.f12658g = aVar.f12671b;
        this.f12659h = aVar.f12672c;
        this.f12660i = aVar.f12673d;
        this.f12661j = aVar.f12674e;
        this.f12662k = aVar.f12675f.d();
        this.f12663l = aVar.f12676g;
        this.f12664m = aVar.f12677h;
        this.f12665n = aVar.f12678i;
        this.f12666o = aVar.f12679j;
        this.f12667p = aVar.f12680k;
        this.f12668q = aVar.f12681l;
    }

    public q D() {
        return this.f12662k;
    }

    public boolean H() {
        int i10 = this.f12659h;
        return i10 >= 200 && i10 < 300;
    }

    public a M() {
        return new a(this);
    }

    public a0 N() {
        return this.f12666o;
    }

    public long O() {
        return this.f12668q;
    }

    public y a0() {
        return this.f12657f;
    }

    public long b0() {
        return this.f12667p;
    }

    public b0 c() {
        return this.f12663l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b0 b0Var = this.f12663l;
        if (b0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        b0Var.close();
    }

    public c d() {
        c cVar = this.f12669r;
        if (cVar != null) {
            return cVar;
        }
        c k10 = c.k(this.f12662k);
        this.f12669r = k10;
        return k10;
    }

    public int f() {
        return this.f12659h;
    }

    public p g() {
        return this.f12661j;
    }

    public String j(String str) {
        return v(str, null);
    }

    public String toString() {
        return "Response{protocol=" + this.f12658g + ", code=" + this.f12659h + ", message=" + this.f12660i + ", url=" + this.f12657f.h() + '}';
    }

    public String v(String str, String str2) {
        String c10 = this.f12662k.c(str);
        return c10 != null ? c10 : str2;
    }
}
