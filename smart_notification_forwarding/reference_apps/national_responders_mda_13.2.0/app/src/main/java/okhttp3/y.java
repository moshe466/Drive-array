package okhttp3;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import okhttp3.q;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    final r f12891a;

    /* renamed from: b, reason: collision with root package name */
    final String f12892b;

    /* renamed from: c, reason: collision with root package name */
    final q f12893c;

    /* renamed from: d, reason: collision with root package name */
    final z f12894d;

    /* renamed from: e, reason: collision with root package name */
    final Map<Class<?>, Object> f12895e;

    /* renamed from: f, reason: collision with root package name */
    private volatile c f12896f;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        r f12897a;

        /* renamed from: b, reason: collision with root package name */
        String f12898b;

        /* renamed from: c, reason: collision with root package name */
        q.a f12899c;

        /* renamed from: d, reason: collision with root package name */
        z f12900d;

        /* renamed from: e, reason: collision with root package name */
        Map<Class<?>, Object> f12901e;

        public a() {
            this.f12901e = Collections.emptyMap();
            this.f12898b = "GET";
            this.f12899c = new q.a();
        }

        a(y yVar) {
            this.f12901e = Collections.emptyMap();
            this.f12897a = yVar.f12891a;
            this.f12898b = yVar.f12892b;
            this.f12900d = yVar.f12894d;
            this.f12901e = yVar.f12895e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(yVar.f12895e);
            this.f12899c = yVar.f12893c.f();
        }

        public y a() {
            if (this.f12897a != null) {
                return new y(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b(c cVar) {
            String cVar2 = cVar.toString();
            return cVar2.isEmpty() ? g("Cache-Control") : c("Cache-Control", cVar2);
        }

        public a c(String str, String str2) {
            this.f12899c.f(str, str2);
            return this;
        }

        public a d(q qVar) {
            this.f12899c = qVar.f();
            return this;
        }

        public a e(String str, z zVar) {
            Objects.requireNonNull(str, "method == null");
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (zVar != null && !vb.f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (zVar != null || !vb.f.e(str)) {
                this.f12898b = str;
                this.f12900d = zVar;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public a f(z zVar) {
            return e("POST", zVar);
        }

        public a g(String str) {
            this.f12899c.e(str);
            return this;
        }

        public a h(String str) {
            StringBuilder sb2;
            int i10;
            Objects.requireNonNull(str, "url == null");
            if (!str.regionMatches(true, 0, "ws:", 0, 3)) {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    sb2 = new StringBuilder();
                    sb2.append("https:");
                    i10 = 4;
                }
                return j(r.k(str));
            }
            sb2 = new StringBuilder();
            sb2.append("http:");
            i10 = 3;
            sb2.append(str.substring(i10));
            str = sb2.toString();
            return j(r.k(str));
        }

        public a i(URL url) {
            Objects.requireNonNull(url, "url == null");
            return j(r.k(url.toString()));
        }

        public a j(r rVar) {
            Objects.requireNonNull(rVar, "url == null");
            this.f12897a = rVar;
            return this;
        }
    }

    y(a aVar) {
        this.f12891a = aVar.f12897a;
        this.f12892b = aVar.f12898b;
        this.f12893c = aVar.f12899c.d();
        this.f12894d = aVar.f12900d;
        this.f12895e = sb.c.v(aVar.f12901e);
    }

    public z a() {
        return this.f12894d;
    }

    public c b() {
        c cVar = this.f12896f;
        if (cVar != null) {
            return cVar;
        }
        c k10 = c.k(this.f12893c);
        this.f12896f = k10;
        return k10;
    }

    public String c(String str) {
        return this.f12893c.c(str);
    }

    public q d() {
        return this.f12893c;
    }

    public boolean e() {
        return this.f12891a.m();
    }

    public String f() {
        return this.f12892b;
    }

    public a g() {
        return new a(this);
    }

    public r h() {
        return this.f12891a;
    }

    public String toString() {
        return "Request{method=" + this.f12892b + ", url=" + this.f12891a + ", tags=" + this.f12895e + '}';
    }
}
