package y3;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.c;
import okhttp3.r;
import okhttp3.t;
import okhttp3.u;
import okhttp3.v;
import okhttp3.y;
import okhttp3.z;

/* loaded from: classes.dex */
public class b {

    /* renamed from: f, reason: collision with root package name */
    private static final v f15904f = new v().u().b(10000, TimeUnit.MILLISECONDS).a();

    /* renamed from: a, reason: collision with root package name */
    private final a f15905a;

    /* renamed from: b, reason: collision with root package name */
    private final String f15906b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, String> f15907c;

    /* renamed from: e, reason: collision with root package name */
    private u.a f15909e = null;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, String> f15908d = new HashMap();

    public b(a aVar, String str, Map<String, String> map) {
        this.f15905a = aVar;
        this.f15906b = str;
        this.f15907c = map;
    }

    private y a() {
        y.a b10 = new y.a().b(new c.a().c().a());
        r.a o10 = r.q(this.f15906b).o();
        for (Map.Entry<String, String> entry : this.f15907c.entrySet()) {
            o10 = o10.a(entry.getKey(), entry.getValue());
        }
        y.a j10 = b10.j(o10.b());
        for (Map.Entry<String, String> entry2 : this.f15908d.entrySet()) {
            j10 = j10.c(entry2.getKey(), entry2.getValue());
        }
        u.a aVar = this.f15909e;
        return j10.e(this.f15905a.name(), aVar == null ? null : aVar.d()).a();
    }

    private u.a c() {
        if (this.f15909e == null) {
            this.f15909e = new u.a().e(u.f12821f);
        }
        return this.f15909e;
    }

    public d b() {
        return d.c(f15904f.w(a()).f());
    }

    public b d(String str, String str2) {
        this.f15908d.put(str, str2);
        return this;
    }

    public b e(Map.Entry<String, String> entry) {
        return d(entry.getKey(), entry.getValue());
    }

    public String f() {
        return this.f15905a.name();
    }

    public b g(String str, String str2) {
        this.f15909e = c().a(str, str2);
        return this;
    }

    public b h(String str, String str2, String str3, File file) {
        this.f15909e = c().b(str, str2, z.c(t.d(str3), file));
        return this;
    }
}
