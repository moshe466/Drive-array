package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
public final class Address {
    final HttpUrl a;
    final Dns b;
    final SocketFactory c;
    final Authenticator d;
    final List<Protocol> e;
    final List<ConnectionSpec> f;
    final ProxySelector g;

    @Nullable
    final Proxy h;

    @Nullable
    final SSLSocketFactory i;

    @Nullable
    final HostnameVerifier j;

    @Nullable
    final CertificatePinner k;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable CertificatePinner certificatePinner, Authenticator authenticator, @Nullable Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.a = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i).build();
        if (dns == null) {
            throw new NullPointerException("dns == null");
        }
        this.b = dns;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.c = socketFactory;
        if (authenticator == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.d = authenticator;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.e = Util.immutableList(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f = Util.immutableList(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = certificatePinner;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Address address) {
        return this.b.equals(address.b) && this.d.equals(address.d) && this.e.equals(address.e) && this.f.equals(address.f) && this.g.equals(address.g) && Util.equal(this.h, address.h) && Util.equal(this.i, address.i) && Util.equal(this.j, address.j) && Util.equal(this.k, address.k) && url().port() == address.url().port();
    }

    @Nullable
    public CertificatePinner certificatePinner() {
        return this.k;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f;
    }

    public Dns dns() {
        return this.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (this.a.equals(address.a) && a(address)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Proxy proxy = this.h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.k;
        return hashCode4 + (certificatePinner != null ? certificatePinner.hashCode() : 0);
    }

    @Nullable
    public HostnameVerifier hostnameVerifier() {
        return this.j;
    }

    public List<Protocol> protocols() {
        return this.e;
    }

    @Nullable
    public Proxy proxy() {
        return this.h;
    }

    public Authenticator proxyAuthenticator() {
        return this.d;
    }

    public ProxySelector proxySelector() {
        return this.g;
    }

    public SocketFactory socketFactory() {
        return this.c;
    }

    @Nullable
    public SSLSocketFactory sslSocketFactory() {
        return this.i;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.a.host());
        sb.append(":");
        sb.append(this.a.port());
        if (this.h != null) {
            sb.append(", proxy=");
            obj = this.h;
        } else {
            sb.append(", proxySelector=");
            obj = this.g;
        }
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }

    public HttpUrl url() {
        return this.a;
    }
}
