package okhttp3;

import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okio.Buffer;
import okio.BufferedSource;

/* loaded from: classes3.dex */
public final class Response implements Closeable {
    final Request a;
    final Protocol b;
    final int c;

    @Nullable
    private volatile CacheControl cacheControl;
    final String d;

    @Nullable
    final Handshake e;
    final Headers f;

    @Nullable
    final ResponseBody g;

    @Nullable
    final Response h;

    @Nullable
    final Response i;

    @Nullable
    final Response j;
    final long k;
    final long l;

    /* loaded from: classes3.dex */
    public static class Builder {

        @Nullable
        Request a;

        @Nullable
        Protocol b;
        int c;
        String d;

        @Nullable
        Handshake e;
        Headers.Builder f;

        @Nullable
        ResponseBody g;

        @Nullable
        Response h;

        @Nullable
        Response i;

        @Nullable
        Response j;
        long k;
        long l;

        public Builder() {
            this.c = -1;
            this.f = new Headers.Builder();
        }

        Builder(Response response) {
            this.c = -1;
            this.a = response.a;
            this.b = response.b;
            this.c = response.c;
            this.d = response.d;
            this.e = response.e;
            this.f = response.f.newBuilder();
            this.g = response.g;
            this.h = response.h;
            this.i = response.i;
            this.j = response.j;
            this.k = response.k;
            this.l = response.l;
        }

        private void checkPriorResponse(Response response) {
            if (response.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void checkSupportResponse(String str, Response response) {
            if (response.g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (response.h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (response.i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (response.j == null) {
                return;
            }
            throw new IllegalArgumentException(str + ".priorResponse != null");
        }

        public Builder addHeader(String str, String str2) {
            this.f.add(str, str2);
            return this;
        }

        public Builder body(@Nullable ResponseBody responseBody) {
            this.g = responseBody;
            return this;
        }

        public Response build() {
            if (this.a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.c >= 0) {
                if (this.d != null) {
                    return new Response(this);
                }
                throw new IllegalStateException("message == null");
            }
            throw new IllegalStateException("code < 0: " + this.c);
        }

        public Builder cacheResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.i = response;
            return this;
        }

        public Builder code(int i) {
            this.c = i;
            return this;
        }

        public Builder handshake(@Nullable Handshake handshake) {
            this.e = handshake;
            return this;
        }

        public Builder header(String str, String str2) {
            this.f.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.f = headers.newBuilder();
            return this;
        }

        public Builder message(String str) {
            this.d = str;
            return this;
        }

        public Builder networkResponse(@Nullable Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.h = response;
            return this;
        }

        public Builder priorResponse(@Nullable Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.j = response;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.b = protocol;
            return this;
        }

        public Builder receivedResponseAtMillis(long j) {
            this.l = j;
            return this;
        }

        public Builder removeHeader(String str) {
            this.f.removeAll(str);
            return this;
        }

        public Builder request(Request request) {
            this.a = request;
            return this;
        }

        public Builder sentRequestAtMillis(long j) {
            this.k = j;
            return this;
        }
    }

    Response(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f.build();
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
    }

    @Nullable
    public ResponseBody body() {
        return this.g;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.f);
        this.cacheControl = parse;
        return parse;
    }

    @Nullable
    public Response cacheResponse() {
        return this.i;
    }

    public List<Challenge> challenges() {
        String str;
        int i = this.c;
        if (i == 401) {
            str = HttpHeaders.WWW_AUTHENTICATE;
        } else {
            if (i != 407) {
                return Collections.emptyList();
            }
            str = HttpHeaders.PROXY_AUTHENTICATE;
        }
        return okhttp3.internal.http.HttpHeaders.parseChallenges(headers(), str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.g;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        responseBody.close();
    }

    public int code() {
        return this.c;
    }

    @Nullable
    public Handshake handshake() {
        return this.e;
    }

    @Nullable
    public String header(String str) {
        return header(str, null);
    }

    @Nullable
    public String header(String str, @Nullable String str2) {
        String str3 = this.f.get(str);
        return str3 != null ? str3 : str2;
    }

    public List<String> headers(String str) {
        return this.f.values(str);
    }

    public Headers headers() {
        return this.f;
    }

    public boolean isRedirect() {
        int i = this.c;
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case NOTICE_VALUE:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public boolean isSuccessful() {
        int i = this.c;
        return i >= 200 && i < 300;
    }

    public String message() {
        return this.d;
    }

    @Nullable
    public Response networkResponse() {
        return this.h;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public ResponseBody peekBody(long j) {
        BufferedSource source = this.g.source();
        source.request(j);
        Buffer clone = source.buffer().clone();
        if (clone.size() > j) {
            Buffer buffer = new Buffer();
            buffer.write(clone, j);
            clone.clear();
            clone = buffer;
        }
        return ResponseBody.create(this.g.contentType(), clone.size(), clone);
    }

    @Nullable
    public Response priorResponse() {
        return this.j;
    }

    public Protocol protocol() {
        return this.b;
    }

    public long receivedResponseAtMillis() {
        return this.l;
    }

    public Request request() {
        return this.a;
    }

    public long sentRequestAtMillis() {
        return this.k;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.url() + '}';
    }
}
