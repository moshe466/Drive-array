package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    final a f12707a;

    /* renamed from: b, reason: collision with root package name */
    final Proxy f12708b;

    /* renamed from: c, reason: collision with root package name */
    final InetSocketAddress f12709c;

    public c0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        Objects.requireNonNull(aVar, "address == null");
        Objects.requireNonNull(proxy, "proxy == null");
        Objects.requireNonNull(inetSocketAddress, "inetSocketAddress == null");
        this.f12707a = aVar;
        this.f12708b = proxy;
        this.f12709c = inetSocketAddress;
    }

    public a a() {
        return this.f12707a;
    }

    public Proxy b() {
        return this.f12708b;
    }

    public boolean c() {
        return this.f12707a.f12654i != null && this.f12708b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.f12709c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c0) {
            c0 c0Var = (c0) obj;
            if (c0Var.f12707a.equals(this.f12707a) && c0Var.f12708b.equals(this.f12708b) && c0Var.f12709c.equals(this.f12709c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f12707a.hashCode()) * 31) + this.f12708b.hashCode()) * 31) + this.f12709c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f12709c + "}";
    }
}
