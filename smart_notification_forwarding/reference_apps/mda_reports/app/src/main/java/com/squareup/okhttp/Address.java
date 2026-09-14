package com.squareup.okhttp;

import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public final class Address {
    final HttpUrl a;
    final Dns b;
    final SocketFactory c;
    final Authenticator d;
    final List<Protocol> e;
    final List<ConnectionSpec> f;
    final ProxySelector g;
    final Proxy h;
    final SSLSocketFactory i;
    final HostnameVerifier j;
    final CertificatePinner k;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.a = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i).build();
        if (dns == null) {
            throw new IllegalArgumentException("dns == null");
        }
        this.b = dns;
        if (socketFactory == null) {
            throw new IllegalArgumentException("socketFactory == null");
        }
        this.c = socketFactory;
        if (authenticator == null) {
            throw new IllegalArgumentException("authenticator == null");
        }
        this.d = authenticator;
        if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        this.e = Util.immutableList(list);
        if (list2 == null) {
            throw new IllegalArgumentException("connectionSpecs == null");
        }
        this.f = Util.immutableList(list2);
        if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = certificatePinner;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return this.a.equals(address.a) && this.b.equals(address.b) && this.d.equals(address.d) && this.e.equals(address.e) && this.f.equals(address.f) && this.g.equals(address.g) && Util.equal(this.h, address.h) && Util.equal(this.i, address.i) && Util.equal(this.j, address.j) && Util.equal(this.k, address.k);
    }

    public Authenticator getAuthenticator() {
        return this.d;
    }

    public CertificatePinner getCertificatePinner() {
        return this.k;
    }

    public List<ConnectionSpec> getConnectionSpecs() {
        return this.f;
    }

    public Dns getDns() {
        return this.b;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.j;
    }

    public List<Protocol> getProtocols() {
        return this.e;
    }

    public Proxy getProxy() {
        return this.h;
    }

    public ProxySelector getProxySelector() {
        return this.g;
    }

    public SocketFactory getSocketFactory() {
        return this.c;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.i;
    }

    @Deprecated
    public String getUriHost() {
        return this.a.host();
    }

    @Deprecated
    public int getUriPort() {
        return this.a.port();
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

    public HttpUrl url() {
        return this.a;
    }
}
