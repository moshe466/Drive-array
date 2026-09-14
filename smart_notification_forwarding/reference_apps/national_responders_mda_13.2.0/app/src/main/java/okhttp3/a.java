package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.r;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    final r f12646a;

    /* renamed from: b, reason: collision with root package name */
    final n f12647b;

    /* renamed from: c, reason: collision with root package name */
    final SocketFactory f12648c;

    /* renamed from: d, reason: collision with root package name */
    final b f12649d;

    /* renamed from: e, reason: collision with root package name */
    final List<w> f12650e;

    /* renamed from: f, reason: collision with root package name */
    final List<j> f12651f;

    /* renamed from: g, reason: collision with root package name */
    final ProxySelector f12652g;

    /* renamed from: h, reason: collision with root package name */
    final Proxy f12653h;

    /* renamed from: i, reason: collision with root package name */
    final SSLSocketFactory f12654i;

    /* renamed from: j, reason: collision with root package name */
    final HostnameVerifier f12655j;

    /* renamed from: k, reason: collision with root package name */
    final f f12656k;

    public a(String str, int i10, n nVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, f fVar, b bVar, Proxy proxy, List<w> list, List<j> list2, ProxySelector proxySelector) {
        this.f12646a = new r.a().r(sSLSocketFactory != null ? "https" : "http").f(str).m(i10).b();
        Objects.requireNonNull(nVar, "dns == null");
        this.f12647b = nVar;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.f12648c = socketFactory;
        Objects.requireNonNull(bVar, "proxyAuthenticator == null");
        this.f12649d = bVar;
        Objects.requireNonNull(list, "protocols == null");
        this.f12650e = sb.c.t(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f12651f = sb.c.t(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.f12652g = proxySelector;
        this.f12653h = proxy;
        this.f12654i = sSLSocketFactory;
        this.f12655j = hostnameVerifier;
        this.f12656k = fVar;
    }

    public f a() {
        return this.f12656k;
    }

    public List<j> b() {
        return this.f12651f;
    }

    public n c() {
        return this.f12647b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(a aVar) {
        return this.f12647b.equals(aVar.f12647b) && this.f12649d.equals(aVar.f12649d) && this.f12650e.equals(aVar.f12650e) && this.f12651f.equals(aVar.f12651f) && this.f12652g.equals(aVar.f12652g) && sb.c.q(this.f12653h, aVar.f12653h) && sb.c.q(this.f12654i, aVar.f12654i) && sb.c.q(this.f12655j, aVar.f12655j) && sb.c.q(this.f12656k, aVar.f12656k) && l().x() == aVar.l().x();
    }

    public HostnameVerifier e() {
        return this.f12655j;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f12646a.equals(aVar.f12646a) && d(aVar)) {
                return true;
            }
        }
        return false;
    }

    public List<w> f() {
        return this.f12650e;
    }

    public Proxy g() {
        return this.f12653h;
    }

    public b h() {
        return this.f12649d;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f12646a.hashCode()) * 31) + this.f12647b.hashCode()) * 31) + this.f12649d.hashCode()) * 31) + this.f12650e.hashCode()) * 31) + this.f12651f.hashCode()) * 31) + this.f12652g.hashCode()) * 31;
        Proxy proxy = this.f12653h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f12654i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f12655j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        f fVar = this.f12656k;
        return hashCode4 + (fVar != null ? fVar.hashCode() : 0);
    }

    public ProxySelector i() {
        return this.f12652g;
    }

    public SocketFactory j() {
        return this.f12648c;
    }

    public SSLSocketFactory k() {
        return this.f12654i;
    }

    public r l() {
        return this.f12646a;
    }

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Address{");
        sb2.append(this.f12646a.l());
        sb2.append(":");
        sb2.append(this.f12646a.x());
        if (this.f12653h != null) {
            sb2.append(", proxy=");
            obj = this.f12653h;
        } else {
            sb2.append(", proxySelector=");
            obj = this.f12652g;
        }
        sb2.append(obj);
        sb2.append("}");
        return sb2.toString();
    }
}
