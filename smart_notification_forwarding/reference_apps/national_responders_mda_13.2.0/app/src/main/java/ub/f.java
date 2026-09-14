package ub;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.c0;
import okhttp3.o;
import okhttp3.r;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final okhttp3.a f14578a;

    /* renamed from: b, reason: collision with root package name */
    private final d f14579b;

    /* renamed from: c, reason: collision with root package name */
    private final okhttp3.d f14580c;

    /* renamed from: d, reason: collision with root package name */
    private final o f14581d;

    /* renamed from: f, reason: collision with root package name */
    private int f14583f;

    /* renamed from: e, reason: collision with root package name */
    private List<Proxy> f14582e = Collections.emptyList();

    /* renamed from: g, reason: collision with root package name */
    private List<InetSocketAddress> f14584g = Collections.emptyList();

    /* renamed from: h, reason: collision with root package name */
    private final List<c0> f14585h = new ArrayList();

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<c0> f14586a;

        /* renamed from: b, reason: collision with root package name */
        private int f14587b = 0;

        a(List<c0> list) {
            this.f14586a = list;
        }

        public List<c0> a() {
            return new ArrayList(this.f14586a);
        }

        public boolean b() {
            return this.f14587b < this.f14586a.size();
        }

        public c0 c() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            List<c0> list = this.f14586a;
            int i10 = this.f14587b;
            this.f14587b = i10 + 1;
            return list.get(i10);
        }
    }

    public f(okhttp3.a aVar, d dVar, okhttp3.d dVar2, o oVar) {
        this.f14578a = aVar;
        this.f14579b = dVar;
        this.f14580c = dVar2;
        this.f14581d = oVar;
        h(aVar.l(), aVar.g());
    }

    static String b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    private boolean d() {
        return this.f14583f < this.f14582e.size();
    }

    private Proxy f() {
        if (d()) {
            List<Proxy> list = this.f14582e;
            int i10 = this.f14583f;
            this.f14583f = i10 + 1;
            Proxy proxy = list.get(i10);
            g(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f14578a.l().l() + "; exhausted proxy configurations: " + this.f14582e);
    }

    private void g(Proxy proxy) {
        String l10;
        int x10;
        this.f14584g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            l10 = this.f14578a.l().l();
            x10 = this.f14578a.l().x();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            l10 = b(inetSocketAddress);
            x10 = inetSocketAddress.getPort();
        }
        if (x10 < 1 || x10 > 65535) {
            throw new SocketException("No route to " + l10 + ":" + x10 + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f14584g.add(InetSocketAddress.createUnresolved(l10, x10));
            return;
        }
        this.f14581d.j(this.f14580c, l10);
        List<InetAddress> a10 = this.f14578a.c().a(l10);
        if (a10.isEmpty()) {
            throw new UnknownHostException(this.f14578a.c() + " returned no addresses for " + l10);
        }
        this.f14581d.i(this.f14580c, l10, a10);
        int size = a10.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f14584g.add(new InetSocketAddress(a10.get(i10), x10));
        }
    }

    private void h(r rVar, Proxy proxy) {
        List<Proxy> u10;
        if (proxy != null) {
            u10 = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f14578a.i().select(rVar.D());
            u10 = (select == null || select.isEmpty()) ? sb.c.u(Proxy.NO_PROXY) : sb.c.t(select);
        }
        this.f14582e = u10;
        this.f14583f = 0;
    }

    public void a(c0 c0Var, IOException iOException) {
        if (c0Var.b().type() != Proxy.Type.DIRECT && this.f14578a.i() != null) {
            this.f14578a.i().connectFailed(this.f14578a.l().D(), c0Var.b().address(), iOException);
        }
        this.f14579b.b(c0Var);
    }

    public boolean c() {
        return d() || !this.f14585h.isEmpty();
    }

    public a e() {
        if (!c()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (d()) {
            Proxy f10 = f();
            int size = this.f14584g.size();
            for (int i10 = 0; i10 < size; i10++) {
                c0 c0Var = new c0(this.f14578a, f10, this.f14584g.get(i10));
                if (this.f14579b.c(c0Var)) {
                    this.f14585h.add(c0Var);
                } else {
                    arrayList.add(c0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f14585h);
            this.f14585h.clear();
        }
        return new a(arrayList);
    }
}
