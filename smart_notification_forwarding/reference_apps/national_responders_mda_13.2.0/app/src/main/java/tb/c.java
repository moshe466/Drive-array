package tb;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.a0;
import okhttp3.q;
import okhttp3.y;
import vb.e;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final y f14318a;

    /* renamed from: b, reason: collision with root package name */
    public final a0 f14319b;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final long f14320a;

        /* renamed from: b, reason: collision with root package name */
        final y f14321b;

        /* renamed from: c, reason: collision with root package name */
        final a0 f14322c;

        /* renamed from: d, reason: collision with root package name */
        private Date f14323d;

        /* renamed from: e, reason: collision with root package name */
        private String f14324e;

        /* renamed from: f, reason: collision with root package name */
        private Date f14325f;

        /* renamed from: g, reason: collision with root package name */
        private String f14326g;

        /* renamed from: h, reason: collision with root package name */
        private Date f14327h;

        /* renamed from: i, reason: collision with root package name */
        private long f14328i;

        /* renamed from: j, reason: collision with root package name */
        private long f14329j;

        /* renamed from: k, reason: collision with root package name */
        private String f14330k;

        /* renamed from: l, reason: collision with root package name */
        private int f14331l;

        public a(long j10, y yVar, a0 a0Var) {
            this.f14331l = -1;
            this.f14320a = j10;
            this.f14321b = yVar;
            this.f14322c = a0Var;
            if (a0Var != null) {
                this.f14328i = a0Var.b0();
                this.f14329j = a0Var.O();
                q D = a0Var.D();
                int h10 = D.h();
                for (int i10 = 0; i10 < h10; i10++) {
                    String e10 = D.e(i10);
                    String i11 = D.i(i10);
                    if ("Date".equalsIgnoreCase(e10)) {
                        this.f14323d = vb.d.b(i11);
                        this.f14324e = i11;
                    } else if ("Expires".equalsIgnoreCase(e10)) {
                        this.f14327h = vb.d.b(i11);
                    } else if ("Last-Modified".equalsIgnoreCase(e10)) {
                        this.f14325f = vb.d.b(i11);
                        this.f14326g = i11;
                    } else if ("ETag".equalsIgnoreCase(e10)) {
                        this.f14330k = i11;
                    } else if ("Age".equalsIgnoreCase(e10)) {
                        this.f14331l = e.d(i11, -1);
                    }
                }
            }
        }

        private long a() {
            Date date = this.f14323d;
            long max = date != null ? Math.max(0L, this.f14329j - date.getTime()) : 0L;
            int i10 = this.f14331l;
            if (i10 != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i10));
            }
            long j10 = this.f14329j;
            return max + (j10 - this.f14328i) + (this.f14320a - j10);
        }

        private long b() {
            if (this.f14322c.d().d() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.d());
            }
            if (this.f14327h != null) {
                Date date = this.f14323d;
                long time = this.f14327h.getTime() - (date != null ? date.getTime() : this.f14329j);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.f14325f == null || this.f14322c.a0().h().y() != null) {
                return 0L;
            }
            Date date2 = this.f14323d;
            long time2 = (date2 != null ? date2.getTime() : this.f14328i) - this.f14325f.getTime();
            if (time2 > 0) {
                return time2 / 10;
            }
            return 0L;
        }

        private c d() {
            if (this.f14322c == null) {
                return new c(this.f14321b, null);
            }
            if ((!this.f14321b.e() || this.f14322c.g() != null) && c.a(this.f14322c, this.f14321b)) {
                okhttp3.c b10 = this.f14321b.b();
                if (b10.h() || e(this.f14321b)) {
                    return new c(this.f14321b, null);
                }
                okhttp3.c d10 = this.f14322c.d();
                long a10 = a();
                long b11 = b();
                if (b10.d() != -1) {
                    b11 = Math.min(b11, TimeUnit.SECONDS.toMillis(b10.d()));
                }
                long j10 = 0;
                long millis = b10.f() != -1 ? TimeUnit.SECONDS.toMillis(b10.f()) : 0L;
                if (!d10.g() && b10.e() != -1) {
                    j10 = TimeUnit.SECONDS.toMillis(b10.e());
                }
                if (!d10.h()) {
                    long j11 = millis + a10;
                    if (j11 < j10 + b11) {
                        a0.a M = this.f14322c.M();
                        if (j11 >= b11) {
                            M.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (a10 > 86400000 && f()) {
                            M.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new c(null, M.c());
                    }
                }
                String str = this.f14330k;
                String str2 = "If-Modified-Since";
                if (str != null) {
                    str2 = "If-None-Match";
                } else if (this.f14325f != null) {
                    str = this.f14326g;
                } else {
                    if (this.f14323d == null) {
                        return new c(this.f14321b, null);
                    }
                    str = this.f14324e;
                }
                q.a f10 = this.f14321b.d().f();
                sb.a.f14194a.b(f10, str2, str);
                return new c(this.f14321b.g().d(f10.d()).a(), this.f14322c);
            }
            return new c(this.f14321b, null);
        }

        private static boolean e(y yVar) {
            return (yVar.c("If-Modified-Since") == null && yVar.c("If-None-Match") == null) ? false : true;
        }

        private boolean f() {
            return this.f14322c.d().d() == -1 && this.f14327h == null;
        }

        public c c() {
            c d10 = d();
            return (d10.f14318a == null || !this.f14321b.b().j()) ? d10 : new c(null, null);
        }
    }

    c(y yVar, a0 a0Var) {
        this.f14318a = yVar;
        this.f14319b = a0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.d().b() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(okhttp3.a0 r3, okhttp3.y r4) {
        /*
            int r0 = r3.f()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.j(r0)
            if (r0 != 0) goto L5a
            okhttp3.c r0 = r3.d()
            int r0 = r0.d()
            r1 = -1
            if (r0 != r1) goto L5a
            okhttp3.c r0 = r3.d()
            boolean r0 = r0.c()
            if (r0 != 0) goto L5a
            okhttp3.c r0 = r3.d()
            boolean r0 = r0.b()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            okhttp3.c r3 = r3.d()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            okhttp3.c r3 = r4.b()
            boolean r3 = r3.i()
            if (r3 != 0) goto L6f
            r2 = 1
        L6f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.c.a(okhttp3.a0, okhttp3.y):boolean");
    }
}
