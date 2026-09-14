package com.squareup.okhttp.internal.http;

import com.google.common.net.HttpHeaders;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.http.CacheStrategy;
import com.squareup.okhttp.internal.io.RealConnection;
import io.fabric.sdk.android.services.network.HttpRequest;
import java.io.Closeable;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: classes2.dex */
public final class HttpEngine {
    private static final ResponseBody EMPTY_BODY = new ResponseBody() { // from class: com.squareup.okhttp.internal.http.HttpEngine.1
        @Override // com.squareup.okhttp.ResponseBody
        public long contentLength() {
            return 0L;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public MediaType contentType() {
            return null;
        }

        @Override // com.squareup.okhttp.ResponseBody
        public BufferedSource source() {
            return new Buffer();
        }
    };
    public static final int MAX_FOLLOW_UPS = 20;
    final OkHttpClient a;
    long b = -1;
    public final boolean bufferRequestBody;
    private BufferedSink bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    private final boolean callerWritesRequestBody;
    private final boolean forWebSocket;
    private HttpStream httpStream;
    private Request networkRequest;
    private final Response priorResponse;
    private Sink requestBodyOut;
    private CacheRequest storeRequest;
    public final StreamAllocation streamAllocation;
    private boolean transparentGzip;
    private final Request userRequest;
    private Response userResponse;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class NetworkInterceptorChain implements Interceptor.Chain {
        private int calls;
        private final int index;
        private final Request request;

        NetworkInterceptorChain(int i, Request request) {
            this.index = i;
            this.request = request;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Connection connection() {
            return HttpEngine.this.streamAllocation.connection();
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response proceed(Request request) {
            this.calls++;
            if (this.index > 0) {
                Interceptor interceptor = HttpEngine.this.a.networkInterceptors().get(this.index - 1);
                Address address = connection().getRoute().getAddress();
                if (!request.httpUrl().host().equals(address.getUriHost()) || request.httpUrl().port() != address.getUriPort()) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                }
                if (this.calls > 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
            }
            if (this.index < HttpEngine.this.a.networkInterceptors().size()) {
                NetworkInterceptorChain networkInterceptorChain = new NetworkInterceptorChain(this.index + 1, request);
                Interceptor interceptor2 = HttpEngine.this.a.networkInterceptors().get(this.index);
                Response intercept = interceptor2.intercept(networkInterceptorChain);
                if (networkInterceptorChain.calls != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor2 + " must call proceed() exactly once");
                }
                if (intercept != null) {
                    return intercept;
                }
                throw new NullPointerException("network interceptor " + interceptor2 + " returned null");
            }
            HttpEngine.this.httpStream.writeRequestHeaders(request);
            HttpEngine.this.networkRequest = request;
            if (HttpEngine.this.a(request) && request.body() != null) {
                BufferedSink buffer = Okio.buffer(HttpEngine.this.httpStream.createRequestBody(request, request.body().contentLength()));
                request.body().writeTo(buffer);
                buffer.close();
            }
            Response readNetworkResponse = HttpEngine.this.readNetworkResponse();
            int code = readNetworkResponse.code();
            if ((code != 204 && code != 205) || readNetworkResponse.body().contentLength() <= 0) {
                return readNetworkResponse;
            }
            throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + readNetworkResponse.body().contentLength());
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Request request() {
            return this.request;
        }
    }

    public HttpEngine(OkHttpClient okHttpClient, Request request, boolean z, boolean z2, boolean z3, StreamAllocation streamAllocation, RetryableSink retryableSink, Response response) {
        this.a = okHttpClient;
        this.userRequest = request;
        this.bufferRequestBody = z;
        this.callerWritesRequestBody = z2;
        this.forWebSocket = z3;
        this.streamAllocation = streamAllocation == null ? new StreamAllocation(okHttpClient.getConnectionPool(), createAddress(okHttpClient, request)) : streamAllocation;
        this.requestBodyOut = retryableSink;
        this.priorResponse = response;
    }

    private Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) {
        Sink body;
        if (cacheRequest == null || (body = cacheRequest.body()) == null) {
            return response;
        }
        final BufferedSource source = response.body().source();
        final BufferedSink buffer = Okio.buffer(body);
        return response.newBuilder().body(new RealResponseBody(response.headers(), Okio.buffer(new Source(this) { // from class: com.squareup.okhttp.internal.http.HttpEngine.2
            boolean a;

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                if (!this.a && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    this.a = true;
                    cacheRequest.abort();
                }
                source.close();
            }

            @Override // okio.Source
            public long read(Buffer buffer2, long j) {
                try {
                    long read = source.read(buffer2, j);
                    if (read != -1) {
                        buffer2.copyTo(buffer.buffer(), buffer2.size() - read, read);
                        buffer.emitCompleteSegments();
                        return read;
                    }
                    if (!this.a) {
                        this.a = true;
                        buffer.close();
                    }
                    return -1L;
                } catch (IOException e) {
                    if (!this.a) {
                        this.a = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            @Override // okio.Source
            public Timeout timeout() {
                return source.timeout();
            }
        }))).build();
    }

    private static Headers combine(Headers headers, Headers headers2) {
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if ((!HttpHeaders.WARNING.equalsIgnoreCase(name) || !value.startsWith("1")) && (!OkHeaders.a(name) || headers2.get(name) == null)) {
                builder.add(name, value);
            }
        }
        int size2 = headers2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            String name2 = headers2.name(i2);
            if (!"Content-Length".equalsIgnoreCase(name2) && OkHeaders.a(name2)) {
                builder.add(name2, headers2.value(i2));
            }
        }
        return builder.build();
    }

    private HttpStream connect() {
        return this.streamAllocation.newStream(this.a.getConnectTimeout(), this.a.getReadTimeout(), this.a.getWriteTimeout(), this.a.getRetryOnConnectionFailure(), !this.networkRequest.method().equals(HttpRequest.METHOD_GET));
    }

    private static Address createAddress(OkHttpClient okHttpClient, Request request) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        if (request.isHttps()) {
            SSLSocketFactory sslSocketFactory = okHttpClient.getSslSocketFactory();
            hostnameVerifier = okHttpClient.getHostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = okHttpClient.getCertificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(request.httpUrl().host(), request.httpUrl().port(), okHttpClient.getDns(), okHttpClient.getSocketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.getAuthenticator(), okHttpClient.getProxy(), okHttpClient.getProtocols(), okHttpClient.getConnectionSpecs(), okHttpClient.getProxySelector());
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals(HttpRequest.METHOD_HEAD)) {
            return false;
        }
        int code = response.code();
        return (((code >= 100 && code < 200) || code == 204 || code == 304) && OkHeaders.contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header(HttpHeaders.TRANSFER_ENCODING))) ? false : true;
    }

    private void maybeCache() {
        InternalCache internalCache = Internal.instance.internalCache(this.a);
        if (internalCache == null) {
            return;
        }
        if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
            this.storeRequest = internalCache.put(stripBody(this.userResponse));
        } else if (HttpMethod.invalidatesCache(this.networkRequest.method())) {
            try {
                internalCache.remove(this.networkRequest);
            } catch (IOException unused) {
            }
        }
    }

    private Request networkRequest(Request request) {
        Request.Builder newBuilder = request.newBuilder();
        if (request.header(HttpHeaders.HOST) == null) {
            newBuilder.header(HttpHeaders.HOST, Util.hostHeader(request.httpUrl()));
        }
        if (request.header(HttpHeaders.CONNECTION) == null) {
            newBuilder.header(HttpHeaders.CONNECTION, "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null) {
            this.transparentGzip = true;
            newBuilder.header("Accept-Encoding", HttpRequest.ENCODING_GZIP);
        }
        CookieHandler cookieHandler = this.a.getCookieHandler();
        if (cookieHandler != null) {
            OkHeaders.addCookies(newBuilder, cookieHandler.get(request.uri(), OkHeaders.toMultimap(newBuilder.build().headers(), null)));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Version.userAgent());
        }
        return newBuilder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response readNetworkResponse() {
        this.httpStream.finishRequest();
        Response build = this.httpStream.readResponseHeaders().request(this.networkRequest).handshake(this.streamAllocation.connection().getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.b)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        if (!this.forWebSocket) {
            build = build.newBuilder().body(this.httpStream.openResponseBody(build)).build();
        }
        if ("close".equalsIgnoreCase(build.request().header(HttpHeaders.CONNECTION)) || "close".equalsIgnoreCase(build.header(HttpHeaders.CONNECTION))) {
            this.streamAllocation.noNewStreams();
        }
        return build;
    }

    private static Response stripBody(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    private Response unzip(Response response) {
        if (!this.transparentGzip || !HttpRequest.ENCODING_GZIP.equalsIgnoreCase(this.userResponse.header("Content-Encoding")) || response.body() == null) {
            return response;
        }
        GzipSource gzipSource = new GzipSource(response.body().source());
        Headers build = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
        return response.newBuilder().headers(build).body(new RealResponseBody(build, Okio.buffer(gzipSource))).build();
    }

    private static boolean validate(Response response, Response response2) {
        Date date;
        if (response2.code() == 304) {
            return true;
        }
        Date date2 = response.headers().getDate("Last-Modified");
        return (date2 == null || (date = response2.headers().getDate("Last-Modified")) == null || date.getTime() >= date2.getTime()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Request request) {
        return HttpMethod.permitsRequestBody(request.method());
    }

    public void cancel() {
        this.streamAllocation.cancel();
    }

    public StreamAllocation close() {
        Closeable closeable = this.bufferedRequestBody;
        if (closeable != null || (closeable = this.requestBodyOut) != null) {
            Util.closeQuietly(closeable);
        }
        Response response = this.userResponse;
        if (response != null) {
            Util.closeQuietly(response.body());
        } else {
            this.streamAllocation.connectionFailed();
        }
        return this.streamAllocation;
    }

    public Request followUpRequest() {
        String header;
        HttpUrl resolve;
        if (this.userResponse == null) {
            throw new IllegalStateException();
        }
        RealConnection connection = this.streamAllocation.connection();
        Route route = connection != null ? connection.getRoute() : null;
        Proxy proxy = route != null ? route.getProxy() : this.a.getProxy();
        int code = this.userResponse.code();
        String method = this.userRequest.method();
        if (code != 307 && code != 308) {
            if (code != 401) {
                if (code != 407) {
                    switch (code) {
                        case NOTICE_VALUE:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                } else if (proxy.type() != Proxy.Type.HTTP) {
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
            }
            return OkHeaders.processAuthHeader(this.a.getAuthenticator(), this.userResponse, proxy);
        }
        if (!method.equals(HttpRequest.METHOD_GET) && !method.equals(HttpRequest.METHOD_HEAD)) {
            return null;
        }
        if (!this.a.getFollowRedirects() || (header = this.userResponse.header("Location")) == null || (resolve = this.userRequest.httpUrl().resolve(header)) == null) {
            return null;
        }
        if (!resolve.scheme().equals(this.userRequest.httpUrl().scheme()) && !this.a.getFollowSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = this.userRequest.newBuilder();
        if (HttpMethod.permitsRequestBody(method)) {
            if (HttpMethod.redirectsToGet(method)) {
                newBuilder.method(HttpRequest.METHOD_GET, null);
            } else {
                newBuilder.method(method, null);
            }
            newBuilder.removeHeader(HttpHeaders.TRANSFER_ENCODING);
            newBuilder.removeHeader("Content-Length");
            newBuilder.removeHeader("Content-Type");
        }
        if (!sameConnection(resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    public BufferedSink getBufferedRequestBody() {
        BufferedSink bufferedSink = this.bufferedRequestBody;
        if (bufferedSink != null) {
            return bufferedSink;
        }
        Sink requestBody = getRequestBody();
        if (requestBody == null) {
            return null;
        }
        BufferedSink buffer = Okio.buffer(requestBody);
        this.bufferedRequestBody = buffer;
        return buffer;
    }

    public Connection getConnection() {
        return this.streamAllocation.connection();
    }

    public Request getRequest() {
        return this.userRequest;
    }

    public Sink getRequestBody() {
        if (this.cacheStrategy != null) {
            return this.requestBodyOut;
        }
        throw new IllegalStateException();
    }

    public Response getResponse() {
        Response response = this.userResponse;
        if (response != null) {
            return response;
        }
        throw new IllegalStateException();
    }

    public boolean hasResponse() {
        return this.userResponse != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void readResponse() {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.HttpEngine.readResponse():void");
    }

    public void receiveHeaders(Headers headers) {
        CookieHandler cookieHandler = this.a.getCookieHandler();
        if (cookieHandler != null) {
            cookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(headers, null));
        }
    }

    public HttpEngine recover(RouteException routeException) {
        if (!this.streamAllocation.recover(routeException) || !this.a.getRetryOnConnectionFailure()) {
            return null;
        }
        return new HttpEngine(this.a, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), (RetryableSink) this.requestBodyOut, this.priorResponse);
    }

    public HttpEngine recover(IOException iOException) {
        return recover(iOException, this.requestBodyOut);
    }

    public HttpEngine recover(IOException iOException, Sink sink) {
        if (!this.streamAllocation.recover(iOException, sink) || !this.a.getRetryOnConnectionFailure()) {
            return null;
        }
        return new HttpEngine(this.a, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), (RetryableSink) sink, this.priorResponse);
    }

    public void releaseStreamAllocation() {
        this.streamAllocation.release();
    }

    public boolean sameConnection(HttpUrl httpUrl) {
        HttpUrl httpUrl2 = this.userRequest.httpUrl();
        return httpUrl2.host().equals(httpUrl.host()) && httpUrl2.port() == httpUrl.port() && httpUrl2.scheme().equals(httpUrl.scheme());
    }

    public void sendRequest() {
        Sink createRequestBody;
        if (this.cacheStrategy != null) {
            return;
        }
        if (this.httpStream != null) {
            throw new IllegalStateException();
        }
        Request networkRequest = networkRequest(this.userRequest);
        InternalCache internalCache = Internal.instance.internalCache(this.a);
        Response response = internalCache != null ? internalCache.get(networkRequest) : null;
        this.cacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), networkRequest, response).get();
        CacheStrategy cacheStrategy = this.cacheStrategy;
        this.networkRequest = cacheStrategy.networkRequest;
        this.cacheResponse = cacheStrategy.cacheResponse;
        if (internalCache != null) {
            internalCache.trackResponse(cacheStrategy);
        }
        if (response != null && this.cacheResponse == null) {
            Util.closeQuietly(response.body());
        }
        if (this.networkRequest == null) {
            Response response2 = this.cacheResponse;
            this.userResponse = (response2 != null ? response2.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)) : new Response.Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY)).build();
            this.userResponse = unzip(this.userResponse);
            return;
        }
        this.httpStream = connect();
        this.httpStream.setHttpEngine(this);
        if (this.callerWritesRequestBody && a(this.networkRequest) && this.requestBodyOut == null) {
            long contentLength = OkHeaders.contentLength(networkRequest);
            if (!this.bufferRequestBody) {
                this.httpStream.writeRequestHeaders(this.networkRequest);
                createRequestBody = this.httpStream.createRequestBody(this.networkRequest, contentLength);
            } else {
                if (contentLength > 2147483647L) {
                    throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                }
                if (contentLength != -1) {
                    this.httpStream.writeRequestHeaders(this.networkRequest);
                    this.requestBodyOut = new RetryableSink((int) contentLength);
                    return;
                }
                createRequestBody = new RetryableSink();
            }
            this.requestBodyOut = createRequestBody;
        }
    }

    public void writingRequestHeaders() {
        if (this.b != -1) {
            throw new IllegalStateException();
        }
        this.b = System.currentTimeMillis();
    }
}
