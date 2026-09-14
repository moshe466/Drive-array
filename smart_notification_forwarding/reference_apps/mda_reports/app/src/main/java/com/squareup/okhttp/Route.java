package com.squareup.okhttp;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes2.dex */
public final class Route {
    final Address a;
    final Proxy b;
    final InetSocketAddress c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.a = address;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        return this.a.equals(route.a) && this.b.equals(route.b) && this.c.equals(route.c);
    }

    public Address getAddress() {
        return this.a;
    }

    public Proxy getProxy() {
        return this.b;
    }

    public InetSocketAddress getSocketAddress() {
        return this.c;
    }

    public int hashCode() {
        return ((((527 + this.a.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public boolean requiresTunnel() {
        return this.a.i != null && this.b.type() == Proxy.Type.HTTP;
    }
}
