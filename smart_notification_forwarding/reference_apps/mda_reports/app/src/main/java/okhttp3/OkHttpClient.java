package okhttp3;

import io.fabric.sdk.android.services.common.AbstractSpiCall;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* loaded from: classes3.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    static final List<Protocol> C = Util.immutableList(Protocol.HTTP_2, Protocol.HTTP_1_1);
    static final List<ConnectionSpec> D = Util.immutableList(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT);
    final int A;
    final int B;
    final Dispatcher a;

    @Nullable
    final Proxy b;
    final List<Protocol> c;
    final List<ConnectionSpec> d;
    final List<Interceptor> e;
    final List<Interceptor> f;
    final EventListener.Factory g;
    final ProxySelector h;
    final CookieJar i;

    @Nullable
    final Cache j;

    @Nullable
    final InternalCache k;
    final SocketFactory l;
    final SSLSocketFactory m;
    final CertificateChainCleaner n;
    final HostnameVerifier o;
    final CertificatePinner p;
    final Authenticator q;
    final Authenticator r;
    final ConnectionPool s;
    final Dns t;
    final boolean u;
    final boolean v;
    final boolean w;
    final int x;
    final int y;
    final int z;

    /* loaded from: classes3.dex */
    public static final class Builder {
        int A;
        int B;
        Dispatcher a;

        @Nullable
        Proxy b;
        List<Protocol> c;
        List<ConnectionSpec> d;
        final List<Interceptor> e;
        final List<Interceptor> f;
        EventListener.Factory g;
        ProxySelector h;
        CookieJar i;

        @Nullable
        Cache j;

        @Nullable
        InternalCache k;
        SocketFactory l;

        @Nullable
        SSLSocketFactory m;

        @Nullable
        CertificateChainCleaner n;
        HostnameVerifier o;
        CertificatePinner p;
        Authenticator q;
        Authenticator r;
        ConnectionPool s;
        Dns t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        int y;
        int z;

        public Builder() {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.a = new Dispatcher();
            this.c = OkHttpClient.C;
            this.d = OkHttpClient.D;
            this.g = EventListener.a(EventListener.NONE);
            this.h = ProxySelector.getDefault();
            if (this.h == null) {
                this.h = new NullProxySelector();
            }
            this.i = CookieJar.NO_COOKIES;
            this.l = SocketFactory.getDefault();
            this.o = OkHostnameVerifier.INSTANCE;
            this.p = CertificatePinner.DEFAULT;
            Authenticator authenticator = Authenticator.NONE;
            this.q = authenticator;
            this.r = authenticator;
            this.s = new ConnectionPool();
            this.t = Dns.SYSTEM;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 0;
            this.y = AbstractSpiCall.DEFAULT_TIMEOUT;
            this.z = AbstractSpiCall.DEFAULT_TIMEOUT;
            this.A = AbstractSpiCall.DEFAULT_TIMEOUT;
            this.B = 0;
        }

        Builder(OkHttpClient okHttpClient) {
            this.e = new ArrayList();
            this.f = new ArrayList();
            this.a = okHttpClient.a;
            this.b = okHttpClient.b;
            this.c = okHttpClient.c;
            this.d = okHttpClient.d;
            this.e.addAll(okHttpClient.e);
            this.f.addAll(okHttpClient.f);
            this.g = okHttpClient.g;
            this.h = okHttpClient.h;
            this.i = okHttpClient.i;
            this.k = okHttpClient.k;
            this.j = okHttpClient.j;
            this.l = okHttpClient.l;
            this.m = okHttpClient.m;
            this.n = okHttpClient.n;
            this.o = okHttpClient.o;
            this.p = okHttpClient.p;
            this.q = okHttpClient.q;
            this.r = okHttpClient.r;
            this.s = okHttpClient.s;
            this.t = okHttpClient.t;
            this.u = okHttpClient.u;
            this.v = okHttpClient.v;
            this.w = okHttpClient.w;
            this.x = okHttpClient.x;
            this.y = okHttpClient.y;
            this.z = okHttpClient.z;
            this.A = okHttpClient.A;
            this.B = okHttpClient.B;
        }

        void a(@Nullable InternalCache internalCache) {
            this.k = internalCache;
            this.j = null;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.e.add(interceptor);
            return this;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor == null) {
                throw new IllegalArgumentException("interceptor == null");
            }
            this.f.add(interceptor);
            return this;
        }

        public Builder authenticator(Authenticator authenticator) {
            if (authenticator == null) {
                throw new NullPointerException("authenticator == null");
            }
            this.r = authenticator;
            return this;
        }

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }

        public Builder cache(@Nullable Cache cache) {
            this.j = cache;
            this.k = null;
            return this;
        }

        public Builder callTimeout(long j, TimeUnit timeUnit) {
            this.x = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder callTimeout(Duration duration) {
            this.x = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder certificatePinner(CertificatePinner certificatePinner) {
            if (certificatePinner == null) {
                throw new NullPointerException("certificatePinner == null");
            }
            this.p = certificatePinner;
            return this;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.y = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder connectTimeout(Duration duration) {
            this.y = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder connectionPool(ConnectionPool connectionPool) {
            if (connectionPool == null) {
                throw new NullPointerException("connectionPool == null");
            }
            this.s = connectionPool;
            return this;
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.d = Util.immutableList(list);
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar) {
            if (cookieJar == null) {
                throw new NullPointerException("cookieJar == null");
            }
            this.i = cookieJar;
            return this;
        }

        public Builder dispatcher(Dispatcher dispatcher) {
            if (dispatcher == null) {
                throw new IllegalArgumentException("dispatcher == null");
            }
            this.a = dispatcher;
            return this;
        }

        public Builder dns(Dns dns) {
            if (dns == null) {
                throw new NullPointerException("dns == null");
            }
            this.t = dns;
            return this;
        }

        public Builder eventListener(EventListener eventListener) {
            if (eventListener == null) {
                throw new NullPointerException("eventListener == null");
            }
            this.g = EventListener.a(eventListener);
            return this;
        }

        public Builder eventListenerFactory(EventListener.Factory factory) {
            if (factory == null) {
                throw new NullPointerException("eventListenerFactory == null");
            }
            this.g = factory;
            return this;
        }

        public Builder followRedirects(boolean z) {
            this.v = z;
            return this;
        }

        public Builder followSslRedirects(boolean z) {
            this.u = z;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            if (hostnameVerifier == null) {
                throw new NullPointerException("hostnameVerifier == null");
            }
            this.o = hostnameVerifier;
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.e;
        }

        public List<Interceptor> networkInterceptors() {
            return this.f;
        }

        public Builder pingInterval(long j, TimeUnit timeUnit) {
            this.B = Util.checkDuration("interval", j, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder pingInterval(Duration duration) {
            this.B = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder protocols(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            }
            if (arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            }
            if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            }
            if (arrayList.contains(null)) {
                throw new IllegalArgumentException("protocols must not contain null");
            }
            arrayList.remove(Protocol.SPDY_3);
            this.c = Collections.unmodifiableList(arrayList);
            return this;
        }

        public Builder proxy(@Nullable Proxy proxy) {
            this.b = proxy;
            return this;
        }

        public Builder proxyAuthenticator(Authenticator authenticator) {
            if (authenticator == null) {
                throw new NullPointerException("proxyAuthenticator == null");
            }
            this.q = authenticator;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector) {
            if (proxySelector == null) {
                throw new NullPointerException("proxySelector == null");
            }
            this.h = proxySelector;
            return this;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.z = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder readTimeout(Duration duration) {
            this.z = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder retryOnConnectionFailure(boolean z) {
            this.w = z;
            return this;
        }

        public Builder socketFactory(SocketFactory socketFactory) {
            if (socketFactory == null) {
                throw new NullPointerException("socketFactory == null");
            }
            this.l = socketFactory;
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            this.m = sSLSocketFactory;
            this.n = Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            }
            if (x509TrustManager == null) {
                throw new NullPointerException("trustManager == null");
            }
            this.m = sSLSocketFactory;
            this.n = CertificateChainCleaner.get(x509TrustManager);
            return this;
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.A = Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        @IgnoreJRERequirement
        public Builder writeTimeout(Duration duration) {
            this.A = Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }
    }

    static {
        Internal.instance = new Internal() { // from class: okhttp3.OkHttpClient.1
            @Override // okhttp3.internal.Internal
            public void addLenient(Headers.Builder builder, String str) {
                builder.a(str);
            }

            @Override // okhttp3.internal.Internal
            public void addLenient(Headers.Builder builder, String str, String str2) {
                builder.a(str, str2);
            }

            @Override // okhttp3.internal.Internal
            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.a(sSLSocket, z);
            }

            @Override // okhttp3.internal.Internal
            public int code(Response.Builder builder) {
                return builder.c;
            }

            @Override // okhttp3.internal.Internal
            public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.a(realConnection);
            }

            @Override // okhttp3.internal.Internal
            public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.a(address, streamAllocation);
            }

            @Override // okhttp3.internal.Internal
            public boolean equalsNonHost(Address address, Address address2) {
                return address.a(address2);
            }

            @Override // okhttp3.internal.Internal
            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                return connectionPool.a(address, streamAllocation, route);
            }

            @Override // okhttp3.internal.Internal
            public boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
                return illegalArgumentException.getMessage().startsWith("Invalid URL host");
            }

            @Override // okhttp3.internal.Internal
            public Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
                return RealCall.a(okHttpClient, request, true);
            }

            @Override // okhttp3.internal.Internal
            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.b(realConnection);
            }

            @Override // okhttp3.internal.Internal
            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.a;
            }

            @Override // okhttp3.internal.Internal
            public void setCache(Builder builder, InternalCache internalCache) {
                builder.a(internalCache);
            }

            @Override // okhttp3.internal.Internal
            public StreamAllocation streamAllocation(Call call) {
                return ((RealCall) call).c();
            }

            @Override // okhttp3.internal.Internal
            @Nullable
            public IOException timeoutExit(Call call, @Nullable IOException iOException) {
                return ((RealCall) call).a(iOException);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    OkHttpClient(Builder builder) {
        boolean z;
        CertificateChainCleaner certificateChainCleaner;
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = Util.immutableList(builder.e);
        this.f = Util.immutableList(builder.f);
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        Iterator<ConnectionSpec> it = this.d.iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                z = z || it.next().isTls();
            }
        }
        if (builder.m == null && z) {
            X509TrustManager platformTrustManager = Util.platformTrustManager();
            this.m = newSslSocketFactory(platformTrustManager);
            certificateChainCleaner = CertificateChainCleaner.get(platformTrustManager);
        } else {
            this.m = builder.m;
            certificateChainCleaner = builder.n;
        }
        this.n = certificateChainCleaner;
        if (this.m != null) {
            Platform.get().configureSslSocketFactory(this.m);
        }
        this.o = builder.o;
        this.p = builder.p.a(this.n);
        this.q = builder.q;
        this.r = builder.r;
        this.s = builder.s;
        this.t = builder.t;
        this.u = builder.u;
        this.v = builder.v;
        this.w = builder.w;
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
        this.A = builder.A;
        this.B = builder.B;
        if (this.e.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.e);
        }
        if (this.f.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f);
        }
    }

    private static SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw Util.assertionError("No System TLS", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InternalCache a() {
        Cache cache = this.j;
        return cache != null ? cache.a : this.k;
    }

    public Authenticator authenticator() {
        return this.r;
    }

    @Nullable
    public Cache cache() {
        return this.j;
    }

    public int callTimeoutMillis() {
        return this.x;
    }

    public CertificatePinner certificatePinner() {
        return this.p;
    }

    public int connectTimeoutMillis() {
        return this.y;
    }

    public ConnectionPool connectionPool() {
        return this.s;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.d;
    }

    public CookieJar cookieJar() {
        return this.i;
    }

    public Dispatcher dispatcher() {
        return this.a;
    }

    public Dns dns() {
        return this.t;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.g;
    }

    public boolean followRedirects() {
        return this.v;
    }

    public boolean followSslRedirects() {
        return this.u;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.o;
    }

    public List<Interceptor> interceptors() {
        return this.e;
    }

    public List<Interceptor> networkInterceptors() {
        return this.f;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Override // okhttp3.Call.Factory
    public Call newCall(Request request) {
        return RealCall.a(this, request, false);
    }

    @Override // okhttp3.WebSocket.Factory
    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new Random(), this.B);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public int pingIntervalMillis() {
        return this.B;
    }

    public List<Protocol> protocols() {
        return this.c;
    }

    @Nullable
    public Proxy proxy() {
        return this.b;
    }

    public Authenticator proxyAuthenticator() {
        return this.q;
    }

    public ProxySelector proxySelector() {
        return this.h;
    }

    public int readTimeoutMillis() {
        return this.z;
    }

    public boolean retryOnConnectionFailure() {
        return this.w;
    }

    public SocketFactory socketFactory() {
        return this.l;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.m;
    }

    public int writeTimeoutMillis() {
        return this.A;
    }
}
