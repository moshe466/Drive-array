package io.fabric.sdk.android.services.network;

import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public class HttpRequest {
    private static final String BOUNDARY = "00content0boundary00";
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    public static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_MULTIPART = "multipart/form-data; boundary=00content0boundary00";
    private static final String CRLF = "\r\n";
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_CONTENT_LENGTH = "Content-Length";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_DATE = "Date";
    public static final String HEADER_ETAG = "ETag";
    public static final String HEADER_EXPIRES = "Expires";
    public static final String HEADER_IF_NONE_MATCH = "If-None-Match";
    public static final String HEADER_LAST_MODIFIED = "Last-Modified";
    public static final String HEADER_LOCATION = "Location";
    public static final String HEADER_PROXY_AUTHORIZATION = "Proxy-Authorization";
    public static final String HEADER_REFERER = "Referer";
    public static final String HEADER_SERVER = "Server";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_OPTIONS = "OPTIONS";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_TRACE = "TRACE";
    public static final String PARAM_CHARSET = "charset";
    private boolean form;
    private String httpProxyHost;
    private int httpProxyPort;
    private boolean multipart;
    private RequestOutputStream output;
    private final String requestMethod;
    public final URL url;
    private static final String[] EMPTY_STRINGS = new String[0];
    private static ConnectionFactory CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
    private HttpURLConnection connection = null;
    private boolean ignoreCloseExceptions = true;
    private boolean uncompress = false;
    private int bufferSize = 8192;

    /* loaded from: classes2.dex */
    public static class Base64 {
        private static final byte EQUALS_SIGN = 61;
        private static final String PREFERRED_ENCODING = "US-ASCII";
        private static final byte[] _STANDARD_ALPHABET = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        private Base64() {
        }

        public static String encode(String str) {
            byte[] bytes;
            try {
                bytes = str.getBytes(PREFERRED_ENCODING);
            } catch (UnsupportedEncodingException unused) {
                bytes = str.getBytes();
            }
            return encodeBytes(bytes);
        }

        private static byte[] encode3to4(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            byte[] bArr3 = _STANDARD_ALPHABET;
            int i4 = (i2 > 0 ? (bArr[i] << Ascii.CAN) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << Ascii.CAN) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << Ascii.CAN) >>> 24 : 0);
            if (i2 == 1) {
                bArr2[i3] = bArr3[i4 >>> 18];
                bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = EQUALS_SIGN;
                bArr2[i3 + 3] = EQUALS_SIGN;
                return bArr2;
            }
            if (i2 == 2) {
                bArr2[i3] = bArr3[i4 >>> 18];
                bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
                bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
                bArr2[i3 + 3] = EQUALS_SIGN;
                return bArr2;
            }
            if (i2 != 3) {
                return bArr2;
            }
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
            bArr2[i3 + 3] = bArr3[i4 & 63];
            return bArr2;
        }

        public static String encodeBytes(byte[] bArr) {
            return encodeBytes(bArr, 0, bArr.length);
        }

        public static String encodeBytes(byte[] bArr, int i, int i2) {
            byte[] encodeBytesToBytes = encodeBytesToBytes(bArr, i, i2);
            try {
                return new String(encodeBytesToBytes, PREFERRED_ENCODING);
            } catch (UnsupportedEncodingException unused) {
                return new String(encodeBytesToBytes);
            }
        }

        public static byte[] encodeBytesToBytes(byte[] bArr, int i, int i2) {
            if (bArr == null) {
                throw new NullPointerException("Cannot serialize a null array.");
            }
            if (i < 0) {
                throw new IllegalArgumentException("Cannot have negative offset: " + i);
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Cannot have length offset: " + i2);
            }
            if (i + i2 > bArr.length) {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Cannot have offset of %d and length of %d with array of length %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(bArr.length)));
            }
            byte[] bArr2 = new byte[((i2 / 3) * 4) + (i2 % 3 <= 0 ? 0 : 4)];
            int i3 = i2 - 2;
            int i4 = 0;
            int i5 = 0;
            while (i4 < i3) {
                encode3to4(bArr, i4 + i, 3, bArr2, i5);
                i4 += 3;
                i5 += 4;
            }
            if (i4 < i2) {
                encode3to4(bArr, i + i4, i2 - i4, bArr2, i5);
                i5 += 4;
            }
            if (i5 > bArr2.length - 1) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i5];
            System.arraycopy(bArr2, 0, bArr3, 0, i5);
            return bArr3;
        }
    }

    /* loaded from: classes2.dex */
    protected static abstract class CloseOperation<V> extends Operation<V> {
        private final Closeable closeable;
        private final boolean ignoreCloseExceptions;

        protected CloseOperation(Closeable closeable, boolean z) {
            this.closeable = closeable;
            this.ignoreCloseExceptions = z;
        }

        @Override // io.fabric.sdk.android.services.network.HttpRequest.Operation
        protected void a() {
            Closeable closeable = this.closeable;
            if (closeable instanceof Flushable) {
                ((Flushable) closeable).flush();
            }
            if (!this.ignoreCloseExceptions) {
                this.closeable.close();
            } else {
                try {
                    this.closeable.close();
                } catch (IOException unused) {
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface ConnectionFactory {
        public static final ConnectionFactory DEFAULT = new ConnectionFactory() { // from class: io.fabric.sdk.android.services.network.HttpRequest.ConnectionFactory.1
            @Override // io.fabric.sdk.android.services.network.HttpRequest.ConnectionFactory
            public HttpURLConnection create(URL url) {
                return (HttpURLConnection) url.openConnection();
            }

            @Override // io.fabric.sdk.android.services.network.HttpRequest.ConnectionFactory
            public HttpURLConnection create(URL url, Proxy proxy) {
                return (HttpURLConnection) url.openConnection(proxy);
            }
        };

        HttpURLConnection create(URL url);

        HttpURLConnection create(URL url, Proxy proxy);
    }

    /* loaded from: classes2.dex */
    protected static abstract class FlushOperation<V> extends Operation<V> {
        private final Flushable flushable;

        protected FlushOperation(Flushable flushable) {
            this.flushable = flushable;
        }

        @Override // io.fabric.sdk.android.services.network.HttpRequest.Operation
        protected void a() {
            this.flushable.flush();
        }
    }

    /* loaded from: classes2.dex */
    public static class HttpRequestException extends RuntimeException {
        private static final long serialVersionUID = -1170466989781746231L;

        protected HttpRequestException(IOException iOException) {
            super(iOException);
        }

        @Override // java.lang.Throwable
        public IOException getCause() {
            return (IOException) super.getCause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static abstract class Operation<V> implements Callable<V> {
        protected Operation() {
        }

        protected abstract void a();

        @Override // java.util.concurrent.Callable
        public V call() {
            Throwable th;
            boolean z = true;
            try {
                try {
                    V run = run();
                    try {
                        a();
                        return run;
                    } catch (IOException e) {
                        throw new HttpRequestException(e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        a();
                    } catch (IOException e2) {
                        if (!z) {
                            throw new HttpRequestException(e2);
                        }
                    }
                    throw th;
                }
            } catch (HttpRequestException e3) {
                throw e3;
            } catch (IOException e4) {
                throw new HttpRequestException(e4);
            } catch (Throwable th3) {
                th = th3;
                z = false;
                a();
                throw th;
            }
        }

        protected abstract V run();
    }

    /* loaded from: classes2.dex */
    public static class RequestOutputStream extends BufferedOutputStream {
        private final CharsetEncoder encoder;

        public RequestOutputStream(OutputStream outputStream, String str, int i) {
            super(outputStream, i);
            this.encoder = Charset.forName(HttpRequest.getValidCharset(str)).newEncoder();
        }

        public RequestOutputStream write(String str) {
            ByteBuffer encode = this.encoder.encode(CharBuffer.wrap(str));
            super.write(encode.array(), 0, encode.limit());
            return this;
        }
    }

    public HttpRequest(CharSequence charSequence, String str) {
        try {
            this.url = new URL(charSequence.toString());
            this.requestMethod = str;
        } catch (MalformedURLException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest(URL url, String str) {
        this.url = url;
        this.requestMethod = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
    
        if (r4 != '&') goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.StringBuilder addParamPrefix(java.lang.String r4, java.lang.StringBuilder r5) {
        /*
            r0 = 63
            int r1 = r4.indexOf(r0)
            int r2 = r5.length()
            int r2 = r2 + (-1)
            r3 = -1
            if (r1 != r3) goto L13
        Lf:
            r5.append(r0)
            goto L1e
        L13:
            if (r1 >= r2) goto L1e
            char r4 = r4.charAt(r2)
            r0 = 38
            if (r4 == r0) goto L1e
            goto Lf
        L1e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.fabric.sdk.android.services.network.HttpRequest.addParamPrefix(java.lang.String, java.lang.StringBuilder):java.lang.StringBuilder");
    }

    private static StringBuilder addPathSeparator(String str, StringBuilder sb) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            sb.append('/');
        }
        return sb;
    }

    public static String append(CharSequence charSequence, Map<?, ?> map) {
        String charSequence2 = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return charSequence2;
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        addPathSeparator(charSequence2, sb);
        addParamPrefix(charSequence2, sb);
        Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
        Map.Entry<?, ?> next = it.next();
        sb.append(next.getKey().toString());
        sb.append('=');
        Object value = next.getValue();
        if (value != null) {
            sb.append(value);
        }
        while (it.hasNext()) {
            sb.append(Typography.amp);
            Map.Entry<?, ?> next2 = it.next();
            sb.append(next2.getKey().toString());
            sb.append('=');
            Object value2 = next2.getValue();
            if (value2 != null) {
                sb.append(value2);
            }
        }
        return sb.toString();
    }

    public static String append(CharSequence charSequence, Object... objArr) {
        String charSequence2 = charSequence.toString();
        if (objArr == null || objArr.length == 0) {
            return charSequence2;
        }
        if (objArr.length % 2 != 0) {
            throw new IllegalArgumentException("Must specify an even number of parameter names/values");
        }
        StringBuilder sb = new StringBuilder(charSequence2);
        addPathSeparator(charSequence2, sb);
        addParamPrefix(charSequence2, sb);
        sb.append(objArr[0]);
        sb.append('=');
        Object obj = objArr[1];
        if (obj != null) {
            sb.append(obj);
        }
        for (int i = 2; i < objArr.length; i += 2) {
            sb.append(Typography.amp);
            sb.append(objArr[i]);
            sb.append('=');
            Object obj2 = objArr[i + 1];
            if (obj2 != null) {
                sb.append(obj2);
            }
        }
        return sb.toString();
    }

    private HttpURLConnection createConnection() {
        try {
            HttpURLConnection create = this.httpProxyHost != null ? CONNECTION_FACTORY.create(this.url, createProxy()) : CONNECTION_FACTORY.create(this.url);
            create.setRequestMethod(this.requestMethod);
            return create;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    private Proxy createProxy() {
        return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.httpProxyHost, this.httpProxyPort));
    }

    public static HttpRequest delete(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_DELETE);
    }

    public static HttpRequest delete(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String append = append(charSequence, map);
        if (z) {
            append = encode(append);
        }
        return delete(append);
    }

    public static HttpRequest delete(CharSequence charSequence, boolean z, Object... objArr) {
        String append = append(charSequence, objArr);
        if (z) {
            append = encode(append);
        }
        return delete(append);
    }

    public static HttpRequest delete(URL url) {
        return new HttpRequest(url, METHOD_DELETE);
    }

    public static String encode(CharSequence charSequence) {
        int i;
        try {
            URL url = new URL(charSequence.toString());
            String host = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                host = host + ':' + Integer.toString(port);
            }
            try {
                String aSCIIString = new URI(url.getProtocol(), host, url.getPath(), url.getQuery(), url.getRef()).toASCIIString();
                int indexOf = aSCIIString.indexOf(63);
                if (indexOf <= 0 || (i = indexOf + 1) >= aSCIIString.length()) {
                    return aSCIIString;
                }
                return aSCIIString.substring(0, i) + aSCIIString.substring(i).replace("+", "%2B").replace("#", "%23");
            } catch (URISyntaxException e) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(e);
                throw new HttpRequestException(iOException);
            }
        } catch (IOException e2) {
            throw new HttpRequestException(e2);
        }
    }

    public static HttpRequest get(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_GET);
    }

    public static HttpRequest get(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String append = append(charSequence, map);
        if (z) {
            append = encode(append);
        }
        return get(append);
    }

    public static HttpRequest get(CharSequence charSequence, boolean z, Object... objArr) {
        String append = append(charSequence, objArr);
        if (z) {
            append = encode(append);
        }
        return get(append);
    }

    public static HttpRequest get(URL url) {
        return new HttpRequest(url, METHOD_GET);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getValidCharset(String str) {
        return (str == null || str.length() <= 0) ? CHARSET_UTF8 : str;
    }

    public static HttpRequest head(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_HEAD);
    }

    public static HttpRequest head(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String append = append(charSequence, map);
        if (z) {
            append = encode(append);
        }
        return head(append);
    }

    public static HttpRequest head(CharSequence charSequence, boolean z, Object... objArr) {
        String append = append(charSequence, objArr);
        if (z) {
            append = encode(append);
        }
        return head(append);
    }

    public static HttpRequest head(URL url) {
        return new HttpRequest(url, METHOD_HEAD);
    }

    public static void keepAlive(boolean z) {
        setProperty("http.keepAlive", Boolean.toString(z));
    }

    public static void nonProxyHosts(String... strArr) {
        String str;
        if (strArr == null || strArr.length <= 0) {
            str = null;
        } else {
            StringBuilder sb = new StringBuilder();
            int length = strArr.length - 1;
            for (int i = 0; i < length; i++) {
                sb.append(strArr[i]);
                sb.append('|');
            }
            sb.append(strArr[length]);
            str = sb.toString();
        }
        setProperty("http.nonProxyHosts", str);
    }

    public static HttpRequest options(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_OPTIONS);
    }

    public static HttpRequest options(URL url) {
        return new HttpRequest(url, METHOD_OPTIONS);
    }

    public static HttpRequest post(CharSequence charSequence) {
        return new HttpRequest(charSequence, "POST");
    }

    public static HttpRequest post(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String append = append(charSequence, map);
        if (z) {
            append = encode(append);
        }
        return post(append);
    }

    public static HttpRequest post(CharSequence charSequence, boolean z, Object... objArr) {
        String append = append(charSequence, objArr);
        if (z) {
            append = encode(append);
        }
        return post(append);
    }

    public static HttpRequest post(URL url) {
        return new HttpRequest(url, "POST");
    }

    public static void proxyHost(String str) {
        setProperty("http.proxyHost", str);
        setProperty("https.proxyHost", str);
    }

    public static void proxyPort(int i) {
        String num = Integer.toString(i);
        setProperty("http.proxyPort", num);
        setProperty("https.proxyPort", num);
    }

    public static HttpRequest put(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_PUT);
    }

    public static HttpRequest put(CharSequence charSequence, Map<?, ?> map, boolean z) {
        String append = append(charSequence, map);
        if (z) {
            append = encode(append);
        }
        return put(append);
    }

    public static HttpRequest put(CharSequence charSequence, boolean z, Object... objArr) {
        String append = append(charSequence, objArr);
        if (z) {
            append = encode(append);
        }
        return put(append);
    }

    public static HttpRequest put(URL url) {
        return new HttpRequest(url, METHOD_PUT);
    }

    public static void setConnectionFactory(ConnectionFactory connectionFactory) {
        if (connectionFactory == null) {
            connectionFactory = ConnectionFactory.DEFAULT;
        }
        CONNECTION_FACTORY = connectionFactory;
    }

    private static String setProperty(final String str, final String str2) {
        return (String) AccessController.doPrivileged(str2 != null ? new PrivilegedAction<String>() { // from class: io.fabric.sdk.android.services.network.HttpRequest.1
            @Override // java.security.PrivilegedAction
            public String run() {
                return System.setProperty(str, str2);
            }
        } : new PrivilegedAction<String>() { // from class: io.fabric.sdk.android.services.network.HttpRequest.2
            @Override // java.security.PrivilegedAction
            public String run() {
                return System.clearProperty(str);
            }
        });
    }

    public static HttpRequest trace(CharSequence charSequence) {
        return new HttpRequest(charSequence, METHOD_TRACE);
    }

    public static HttpRequest trace(URL url) {
        return new HttpRequest(url, METHOD_TRACE);
    }

    protected HttpRequest a(final InputStream inputStream, final OutputStream outputStream) {
        return new CloseOperation<HttpRequest>(inputStream, this.ignoreCloseExceptions) { // from class: io.fabric.sdk.android.services.network.HttpRequest.6
            @Override // io.fabric.sdk.android.services.network.HttpRequest.Operation
            public HttpRequest run() {
                byte[] bArr = new byte[HttpRequest.this.bufferSize];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        return HttpRequest.this;
                    }
                    outputStream.write(bArr, 0, read);
                }
            }
        }.call();
    }

    protected HttpRequest a(final Reader reader, final Writer writer) {
        return new CloseOperation<HttpRequest>(reader, this.ignoreCloseExceptions) { // from class: io.fabric.sdk.android.services.network.HttpRequest.7
            @Override // io.fabric.sdk.android.services.network.HttpRequest.Operation
            public HttpRequest run() {
                char[] cArr = new char[HttpRequest.this.bufferSize];
                while (true) {
                    int read = reader.read(cArr);
                    if (read == -1) {
                        return HttpRequest.this;
                    }
                    writer.write(cArr, 0, read);
                }
            }
        }.call();
    }

    protected HttpRequest a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=\"");
        sb.append(str);
        if (str2 != null) {
            sb.append("\"; filename=\"");
            sb.append(str2);
        }
        sb.append(Typography.quote);
        partHeader(HttpHeaders.CONTENT_DISPOSITION, sb.toString());
        if (str3 != null) {
            partHeader("Content-Type", str3);
        }
        return send(CRLF);
    }

    protected ByteArrayOutputStream a() {
        int contentLength = contentLength();
        return contentLength > 0 ? new ByteArrayOutputStream(contentLength) : new ByteArrayOutputStream();
    }

    protected String a(String str, String str2) {
        String trim;
        int length;
        if (str != null && str.length() != 0) {
            int length2 = str.length();
            int indexOf = str.indexOf(59) + 1;
            if (indexOf != 0 && indexOf != length2) {
                int indexOf2 = str.indexOf(59, indexOf);
                if (indexOf2 == -1) {
                    indexOf2 = length2;
                }
                while (indexOf < indexOf2) {
                    int indexOf3 = str.indexOf(61, indexOf);
                    if (indexOf3 != -1 && indexOf3 < indexOf2 && str2.equals(str.substring(indexOf, indexOf3).trim()) && (length = (trim = str.substring(indexOf3 + 1, indexOf2).trim()).length()) != 0) {
                        if (length > 2 && '\"' == trim.charAt(0)) {
                            int i = length - 1;
                            if ('\"' == trim.charAt(i)) {
                                return trim.substring(1, i);
                            }
                        }
                        return trim;
                    }
                    indexOf = indexOf2 + 1;
                    indexOf2 = str.indexOf(59, indexOf);
                    if (indexOf2 == -1) {
                        indexOf2 = length2;
                    }
                }
            }
        }
        return null;
    }

    protected Map<String, String> a(String str) {
        String trim;
        int length;
        if (str == null || str.length() == 0) {
            return Collections.emptyMap();
        }
        int length2 = str.length();
        int indexOf = str.indexOf(59) + 1;
        if (indexOf == 0 || indexOf == length2) {
            return Collections.emptyMap();
        }
        int indexOf2 = str.indexOf(59, indexOf);
        if (indexOf2 == -1) {
            indexOf2 = length2;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (indexOf < indexOf2) {
            int indexOf3 = str.indexOf(61, indexOf);
            if (indexOf3 != -1 && indexOf3 < indexOf2) {
                String trim2 = str.substring(indexOf, indexOf3).trim();
                if (trim2.length() > 0 && (length = (trim = str.substring(indexOf3 + 1, indexOf2).trim()).length()) != 0) {
                    if (length > 2 && '\"' == trim.charAt(0)) {
                        int i = length - 1;
                        if ('\"' == trim.charAt(i)) {
                            trim = trim.substring(1, i);
                        }
                    }
                    linkedHashMap.put(trim2, trim);
                }
            }
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(59, indexOf);
            if (indexOf2 == -1) {
                indexOf2 = length2;
            }
        }
        return linkedHashMap;
    }

    public HttpRequest accept(String str) {
        return header("Accept", str);
    }

    public HttpRequest acceptCharset(String str) {
        return header("Accept-Charset", str);
    }

    public HttpRequest acceptEncoding(String str) {
        return header("Accept-Encoding", str);
    }

    public HttpRequest acceptGzipEncoding() {
        return acceptEncoding(ENCODING_GZIP);
    }

    public HttpRequest acceptJson() {
        return accept("application/json");
    }

    public HttpRequest authorization(String str) {
        return header("Authorization", str);
    }

    protected HttpRequest b() {
        RequestOutputStream requestOutputStream = this.output;
        if (requestOutputStream == null) {
            return this;
        }
        if (this.multipart) {
            requestOutputStream.write("\r\n--00content0boundary00--\r\n");
        }
        if (this.ignoreCloseExceptions) {
            try {
                this.output.close();
            } catch (IOException unused) {
            }
        } else {
            this.output.close();
        }
        this.output = null;
        return this;
    }

    public boolean badRequest() {
        return 400 == code();
    }

    public HttpRequest basic(String str, String str2) {
        return authorization("Basic " + Base64.encode(str + ':' + str2));
    }

    public HttpRequest body(AtomicReference<String> atomicReference) {
        atomicReference.set(body());
        return this;
    }

    public HttpRequest body(AtomicReference<String> atomicReference, String str) {
        atomicReference.set(body(str));
        return this;
    }

    public String body() {
        return body(charset());
    }

    public String body(String str) {
        ByteArrayOutputStream a = a();
        try {
            a(buffer(), a);
            return a.toString(getValidCharset(str));
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public BufferedInputStream buffer() {
        return new BufferedInputStream(stream(), this.bufferSize);
    }

    public int bufferSize() {
        return this.bufferSize;
    }

    public HttpRequest bufferSize(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("Size must be greater than zero");
        }
        this.bufferSize = i;
        return this;
    }

    public BufferedReader bufferedReader() {
        return bufferedReader(charset());
    }

    public BufferedReader bufferedReader(String str) {
        return new BufferedReader(reader(str), this.bufferSize);
    }

    public byte[] bytes() {
        ByteArrayOutputStream a = a();
        try {
            a(buffer(), a);
            return a.toByteArray();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected HttpRequest c() {
        try {
            return b();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String cacheControl() {
        return header("Cache-Control");
    }

    public String charset() {
        return parameter("Content-Type", PARAM_CHARSET);
    }

    public HttpRequest chunk(int i) {
        getConnection().setChunkedStreamingMode(i);
        return this;
    }

    public int code() {
        try {
            b();
            return getConnection().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest code(AtomicInteger atomicInteger) {
        atomicInteger.set(code());
        return this;
    }

    public HttpRequest connectTimeout(int i) {
        getConnection().setConnectTimeout(i);
        return this;
    }

    public String contentEncoding() {
        return header("Content-Encoding");
    }

    public int contentLength() {
        return intHeader("Content-Length");
    }

    public HttpRequest contentLength(int i) {
        getConnection().setFixedLengthStreamingMode(i);
        return this;
    }

    public HttpRequest contentLength(String str) {
        return contentLength(Integer.parseInt(str));
    }

    public HttpRequest contentType(String str) {
        return contentType(str, null);
    }

    public HttpRequest contentType(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return header("Content-Type", str);
        }
        return header("Content-Type", str + "; charset=" + str2);
    }

    public String contentType() {
        return header("Content-Type");
    }

    public boolean created() {
        return 201 == code();
    }

    protected HttpRequest d() {
        if (this.output != null) {
            return this;
        }
        getConnection().setDoOutput(true);
        this.output = new RequestOutputStream(getConnection().getOutputStream(), a(getConnection().getRequestProperty("Content-Type"), PARAM_CHARSET), this.bufferSize);
        return this;
    }

    public long date() {
        return dateHeader("Date");
    }

    public long dateHeader(String str) {
        return dateHeader(str, -1L);
    }

    public long dateHeader(String str, long j) {
        c();
        return getConnection().getHeaderFieldDate(str, j);
    }

    public HttpRequest disconnect() {
        getConnection().disconnect();
        return this;
    }

    protected HttpRequest e() {
        RequestOutputStream requestOutputStream;
        String str;
        if (this.multipart) {
            requestOutputStream = this.output;
            str = "\r\n--00content0boundary00\r\n";
        } else {
            this.multipart = true;
            contentType(CONTENT_TYPE_MULTIPART).d();
            requestOutputStream = this.output;
            str = "--00content0boundary00\r\n";
        }
        requestOutputStream.write(str);
        return this;
    }

    public String eTag() {
        return header("ETag");
    }

    public long expires() {
        return dateHeader("Expires");
    }

    public HttpRequest followRedirects(boolean z) {
        getConnection().setInstanceFollowRedirects(z);
        return this;
    }

    public HttpRequest form(Object obj, Object obj2) {
        return form(obj, obj2, CHARSET_UTF8);
    }

    public HttpRequest form(Object obj, Object obj2, String str) {
        boolean z = !this.form;
        if (z) {
            contentType(CONTENT_TYPE_FORM, str);
            this.form = true;
        }
        String validCharset = getValidCharset(str);
        try {
            d();
            if (!z) {
                this.output.write(38);
            }
            this.output.write(URLEncoder.encode(obj.toString(), validCharset));
            this.output.write(61);
            if (obj2 != null) {
                this.output.write(URLEncoder.encode(obj2.toString(), validCharset));
            }
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest form(Map.Entry<?, ?> entry) {
        return form(entry, CHARSET_UTF8);
    }

    public HttpRequest form(Map.Entry<?, ?> entry, String str) {
        return form(entry.getKey(), entry.getValue(), str);
    }

    public HttpRequest form(Map<?, ?> map) {
        return form(map, CHARSET_UTF8);
    }

    public HttpRequest form(Map<?, ?> map, String str) {
        if (!map.isEmpty()) {
            Iterator<Map.Entry<?, ?>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                form(it.next(), str);
            }
        }
        return this;
    }

    public HttpURLConnection getConnection() {
        if (this.connection == null) {
            this.connection = createConnection();
        }
        return this.connection;
    }

    public HttpRequest header(String str, Number number) {
        return header(str, number != null ? number.toString() : null);
    }

    public HttpRequest header(String str, String str2) {
        getConnection().setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest header(Map.Entry<String, String> entry) {
        return header(entry.getKey(), entry.getValue());
    }

    public String header(String str) {
        c();
        return getConnection().getHeaderField(str);
    }

    public HttpRequest headers(Map<String, String> map) {
        if (!map.isEmpty()) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                header(it.next());
            }
        }
        return this;
    }

    public Map<String, List<String>> headers() {
        c();
        return getConnection().getHeaderFields();
    }

    public String[] headers(String str) {
        Map<String, List<String>> headers = headers();
        if (headers == null || headers.isEmpty()) {
            return EMPTY_STRINGS;
        }
        List<String> list = headers.get(str);
        return (list == null || list.isEmpty()) ? EMPTY_STRINGS : (String[]) list.toArray(new String[list.size()]);
    }

    public HttpRequest ifModifiedSince(long j) {
        getConnection().setIfModifiedSince(j);
        return this;
    }

    public HttpRequest ifNoneMatch(String str) {
        return header("If-None-Match", str);
    }

    public HttpRequest ignoreCloseExceptions(boolean z) {
        this.ignoreCloseExceptions = z;
        return this;
    }

    public boolean ignoreCloseExceptions() {
        return this.ignoreCloseExceptions;
    }

    public int intHeader(String str) {
        return intHeader(str, -1);
    }

    public int intHeader(String str, int i) {
        c();
        return getConnection().getHeaderFieldInt(str, i);
    }

    public boolean isBodyEmpty() {
        return contentLength() == 0;
    }

    public long lastModified() {
        return dateHeader("Last-Modified");
    }

    public String location() {
        return header("Location");
    }

    public String message() {
        try {
            b();
            return getConnection().getResponseMessage();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String method() {
        return getConnection().getRequestMethod();
    }

    public boolean notFound() {
        return 404 == code();
    }

    public boolean notModified() {
        return 304 == code();
    }

    public boolean ok() {
        return 200 == code();
    }

    public String parameter(String str, String str2) {
        return a(header(str), str2);
    }

    public Map<String, String> parameters(String str) {
        return a(header(str));
    }

    public HttpRequest part(String str, File file) {
        return part(str, (String) null, file);
    }

    public HttpRequest part(String str, InputStream inputStream) {
        return part(str, (String) null, (String) null, inputStream);
    }

    public HttpRequest part(String str, Number number) {
        return part(str, (String) null, number);
    }

    public HttpRequest part(String str, String str2) {
        return part(str, (String) null, str2);
    }

    public HttpRequest part(String str, String str2, File file) {
        return part(str, str2, (String) null, file);
    }

    public HttpRequest part(String str, String str2, Number number) {
        return part(str, str2, number != null ? number.toString() : null);
    }

    public HttpRequest part(String str, String str2, String str3) {
        return part(str, str2, (String) null, str3);
    }

    public HttpRequest part(String str, String str2, String str3, File file) {
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            HttpRequest part = part(str, str2, str3, bufferedInputStream);
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
            }
            return part;
        } catch (IOException e2) {
            e = e2;
            throw new HttpRequestException(e);
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public HttpRequest part(String str, String str2, String str3, InputStream inputStream) {
        try {
            e();
            a(str, str2, str3);
            a(inputStream, this.output);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest part(String str, String str2, String str3, String str4) {
        try {
            e();
            a(str, str2, str3);
            this.output.write(str4);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest partHeader(String str, String str2) {
        return send(str).send(": ").send(str2).send(CRLF);
    }

    public HttpRequest proxyAuthorization(String str) {
        return header("Proxy-Authorization", str);
    }

    public HttpRequest proxyBasic(String str, String str2) {
        return proxyAuthorization("Basic " + Base64.encode(str + ':' + str2));
    }

    public HttpRequest readTimeout(int i) {
        getConnection().setReadTimeout(i);
        return this;
    }

    public InputStreamReader reader() {
        return reader(charset());
    }

    public InputStreamReader reader(String str) {
        try {
            return new InputStreamReader(stream(), getValidCharset(str));
        } catch (UnsupportedEncodingException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest receive(File file) {
        try {
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.bufferSize);
            return new CloseOperation<HttpRequest>(bufferedOutputStream, this.ignoreCloseExceptions) { // from class: io.fabric.sdk.android.services.network.HttpRequest.3
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // io.fabric.sdk.android.services.network.HttpRequest.Operation
                public HttpRequest run() {
                    return HttpRequest.this.receive(bufferedOutputStream);
                }
            }.call();
        } catch (FileNotFoundException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest receive(OutputStream outputStream) {
        try {
            return a(buffer(), outputStream);
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest receive(PrintStream printStream) {
        return receive((OutputStream) printStream);
    }

    public HttpRequest receive(final Writer writer) {
        final BufferedReader bufferedReader = bufferedReader();
        return new CloseOperation<HttpRequest>(bufferedReader, this.ignoreCloseExceptions) { // from class: io.fabric.sdk.android.services.network.HttpRequest.5
            @Override // io.fabric.sdk.android.services.network.HttpRequest.Operation
            public HttpRequest run() {
                return HttpRequest.this.a(bufferedReader, writer);
            }
        }.call();
    }

    public HttpRequest receive(final Appendable appendable) {
        final BufferedReader bufferedReader = bufferedReader();
        return new CloseOperation<HttpRequest>(bufferedReader, this.ignoreCloseExceptions) { // from class: io.fabric.sdk.android.services.network.HttpRequest.4
            @Override // io.fabric.sdk.android.services.network.HttpRequest.Operation
            public HttpRequest run() {
                CharBuffer allocate = CharBuffer.allocate(HttpRequest.this.bufferSize);
                while (true) {
                    int read = bufferedReader.read(allocate);
                    if (read == -1) {
                        return HttpRequest.this;
                    }
                    allocate.rewind();
                    appendable.append(allocate, 0, read);
                    allocate.rewind();
                }
            }
        }.call();
    }

    public HttpRequest referer(String str) {
        return header("Referer", str);
    }

    public HttpRequest send(File file) {
        try {
            return send(new BufferedInputStream(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest send(InputStream inputStream) {
        try {
            d();
            a(inputStream, this.output);
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest send(final Reader reader) {
        try {
            d();
            RequestOutputStream requestOutputStream = this.output;
            final OutputStreamWriter outputStreamWriter = new OutputStreamWriter(requestOutputStream, requestOutputStream.encoder.charset());
            return new FlushOperation<HttpRequest>(outputStreamWriter) { // from class: io.fabric.sdk.android.services.network.HttpRequest.8
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // io.fabric.sdk.android.services.network.HttpRequest.Operation
                public HttpRequest run() {
                    return HttpRequest.this.a(reader, outputStreamWriter);
                }
            }.call();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest send(CharSequence charSequence) {
        try {
            d();
            this.output.write(charSequence.toString());
            return this;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest send(byte[] bArr) {
        return send(new ByteArrayInputStream(bArr));
    }

    public String server() {
        return header("Server");
    }

    public boolean serverError() {
        return 500 == code();
    }

    public InputStream stream() {
        InputStream inputStream;
        if (code() < 400) {
            try {
                inputStream = getConnection().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        } else {
            inputStream = getConnection().getErrorStream();
            if (inputStream == null) {
                try {
                    inputStream = getConnection().getInputStream();
                } catch (IOException e2) {
                    throw new HttpRequestException(e2);
                }
            }
        }
        if (!this.uncompress || !ENCODING_GZIP.equals(contentEncoding())) {
            return inputStream;
        }
        try {
            return new GZIPInputStream(inputStream);
        } catch (IOException e3) {
            throw new HttpRequestException(e3);
        }
    }

    public String toString() {
        return method() + ' ' + url();
    }

    public HttpRequest trustAllCerts() {
        return this;
    }

    public HttpRequest trustAllHosts() {
        return this;
    }

    public HttpRequest uncompress(boolean z) {
        this.uncompress = z;
        return this;
    }

    public URL url() {
        return getConnection().getURL();
    }

    public HttpRequest useCaches(boolean z) {
        getConnection().setUseCaches(z);
        return this;
    }

    public HttpRequest useProxy(String str, int i) {
        if (this.connection != null) {
            throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
        }
        this.httpProxyHost = str;
        this.httpProxyPort = i;
        return this;
    }

    public HttpRequest userAgent(String str) {
        return header("User-Agent", str);
    }

    public OutputStreamWriter writer() {
        try {
            d();
            return new OutputStreamWriter(this.output, this.output.encoder.charset());
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }
}
