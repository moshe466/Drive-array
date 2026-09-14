package okhttp3;

import io.fabric.sdk.android.services.network.HttpRequest;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

/* loaded from: classes3.dex */
public final class Request {
    final HttpUrl a;
    final String b;
    final Headers c;

    @Nullable
    private volatile CacheControl cacheControl;

    @Nullable
    final RequestBody d;
    final Map<Class<?>, Object> e;

    /* loaded from: classes3.dex */
    public static class Builder {

        @Nullable
        HttpUrl a;
        String b;
        Headers.Builder c;

        @Nullable
        RequestBody d;
        Map<Class<?>, Object> e;

        public Builder() {
            this.e = Collections.emptyMap();
            this.b = HttpRequest.METHOD_GET;
            this.c = new Headers.Builder();
        }

        Builder(Request request) {
            this.e = Collections.emptyMap();
            this.a = request.a;
            this.b = request.b;
            this.d = request.d;
            this.e = request.e.isEmpty() ? Collections.emptyMap() : new LinkedHashMap<>(request.e);
            this.c = request.c.newBuilder();
        }

        public Builder addHeader(String str, String str2) {
            this.c.add(str, str2);
            return this;
        }

        public Request build() {
            if (this.a != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.isEmpty() ? removeHeader("Cache-Control") : header("Cache-Control", cacheControl2);
        }

        public Builder delete() {
            return delete(Util.EMPTY_REQUEST);
        }

        public Builder delete(@Nullable RequestBody requestBody) {
            return method(HttpRequest.METHOD_DELETE, requestBody);
        }

        public Builder get() {
            return method(HttpRequest.METHOD_GET, null);
        }

        public Builder head() {
            return method(HttpRequest.METHOD_HEAD, null);
        }

        public Builder header(String str, String str2) {
            this.c.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.c = headers.newBuilder();
            return this;
        }

        public Builder method(String str, @Nullable RequestBody requestBody) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (requestBody != null || !HttpMethod.requiresRequestBody(str)) {
                this.b = str;
                this.d = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method " + str + " must have a request body.");
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            return method(HttpRequest.METHOD_PUT, requestBody);
        }

        public Builder removeHeader(String str) {
            this.c.removeAll(str);
            return this;
        }

        public <T> Builder tag(Class<? super T> cls, @Nullable T t) {
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
            if (t == null) {
                this.e.remove(cls);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                this.e.put(cls, cls.cast(t));
            }
            return this;
        }

        public Builder tag(@Nullable Object obj) {
            return tag(Object.class, obj);
        }

        public Builder url(String str) {
            StringBuilder sb;
            int i;
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (!str.regionMatches(true, 0, "ws:", 0, 3)) {
                if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    sb = new StringBuilder();
                    sb.append("https:");
                    i = 4;
                }
                return url(HttpUrl.get(str));
            }
            sb = new StringBuilder();
            sb.append("http:");
            i = 3;
            sb.append(str.substring(i));
            str = sb.toString();
            return url(HttpUrl.get(str));
        }

        public Builder url(URL url) {
            if (url != null) {
                return url(HttpUrl.get(url.toString()));
            }
            throw new NullPointerException("url == null");
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl == null) {
                throw new NullPointerException("url == null");
            }
            this.a = httpUrl;
            return this;
        }
    }

    Request(Builder builder) {
        this.a = builder.a;
        this.b = builder.b;
        this.c = builder.c.build();
        this.d = builder.d;
        this.e = Util.immutableMap(builder.e);
    }

    @Nullable
    public RequestBody body() {
        return this.d;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.parse(this.c);
        this.cacheControl = parse;
        return parse;
    }

    @Nullable
    public String header(String str) {
        return this.c.get(str);
    }

    public List<String> headers(String str) {
        return this.c.values(str);
    }

    public Headers headers() {
        return this.c;
    }

    public boolean isHttps() {
        return this.a.isHttps();
    }

    public String method() {
        return this.b;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    @Nullable
    public Object tag() {
        return tag(Object.class);
    }

    @Nullable
    public <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.e.get(cls));
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.a + ", tags=" + this.e + '}';
    }

    public HttpUrl url() {
        return this.a;
    }
}
