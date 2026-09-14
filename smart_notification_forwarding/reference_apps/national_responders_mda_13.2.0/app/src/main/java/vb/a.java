package vb;

import java.util.List;
import okhttp3.a0;
import okhttp3.l;
import okhttp3.s;
import okhttp3.t;
import okhttp3.y;
import okhttp3.z;

/* loaded from: classes.dex */
public final class a implements s {

    /* renamed from: a, reason: collision with root package name */
    private final l f14850a;

    public a(l lVar) {
        this.f14850a = lVar;
    }

    private String b(List<okhttp3.k> list) {
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                sb2.append("; ");
            }
            okhttp3.k kVar = list.get(i10);
            sb2.append(kVar.c());
            sb2.append('=');
            sb2.append(kVar.k());
        }
        return sb2.toString();
    }

    @Override // okhttp3.s
    public a0 a(s.a aVar) {
        y e10 = aVar.e();
        y.a g10 = e10.g();
        z a10 = e10.a();
        if (a10 != null) {
            t b10 = a10.b();
            if (b10 != null) {
                g10.c("Content-Type", b10.toString());
            }
            long a11 = a10.a();
            if (a11 != -1) {
                g10.c("Content-Length", Long.toString(a11));
                g10.g("Transfer-Encoding");
            } else {
                g10.c("Transfer-Encoding", "chunked");
                g10.g("Content-Length");
            }
        }
        boolean z10 = false;
        if (e10.c("Host") == null) {
            g10.c("Host", sb.c.s(e10.h(), false));
        }
        if (e10.c("Connection") == null) {
            g10.c("Connection", "Keep-Alive");
        }
        if (e10.c("Accept-Encoding") == null && e10.c("Range") == null) {
            z10 = true;
            g10.c("Accept-Encoding", "gzip");
        }
        List<okhttp3.k> a12 = this.f14850a.a(e10.h());
        if (!a12.isEmpty()) {
            g10.c("Cookie", b(a12));
        }
        if (e10.c("User-Agent") == null) {
            g10.c("User-Agent", sb.d.a());
        }
        a0 d10 = aVar.d(g10.a());
        e.e(this.f14850a, e10.h(), d10.D());
        a0.a p10 = d10.M().p(e10);
        if (z10 && "gzip".equalsIgnoreCase(d10.j("Content-Encoding")) && e.c(d10)) {
            bc.j jVar = new bc.j(d10.c().v());
            p10.j(d10.D().f().e("Content-Encoding").e("Content-Length").d());
            p10.b(new h(d10.j("Content-Type"), -1L, bc.l.b(jVar)));
        }
        return p10.c();
    }
}
