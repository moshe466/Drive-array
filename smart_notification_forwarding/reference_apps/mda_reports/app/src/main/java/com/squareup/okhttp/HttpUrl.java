package com.squareup.okhttp;

import io.grpc.internal.GrpcUtil;
import java.net.IDN;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.text.Typography;
import okio.Buffer;

/* loaded from: classes2.dex */
public final class HttpUrl {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String fragment;
    private final String host;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.squareup.okhttp.HttpUrl$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Builder.ParseResult.values().length];

        static {
            try {
                a[Builder.ParseResult.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Builder.ParseResult.INVALID_HOST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Builder.ParseResult.UNSUPPORTED_SCHEME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Builder.ParseResult.MISSING_SCHEME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Builder.ParseResult.INVALID_PORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        String a;
        String d;
        List<String> g;
        String h;
        String b = "";
        String c = "";
        int e = -1;
        final List<String> f = new ArrayList();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public enum ParseResult {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public Builder() {
            this.f.add("");
        }

        private static String canonicalizeHost(String str, int i, int i2) {
            String a = HttpUrl.a(str, i, i2, false);
            if (!a.startsWith("[") || !a.endsWith("]")) {
                return domainToAscii(a);
            }
            InetAddress decodeIpv6 = decodeIpv6(a, 1, a.length() - 1);
            if (decodeIpv6 == null) {
                return null;
            }
            byte[] address = decodeIpv6.getAddress();
            if (address.length == 16) {
                return inet6AddressToAscii(address);
            }
            throw new AssertionError();
        }

        private static boolean containsInvalidHostnameAsciiCodes(String str) {
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        private static boolean decodeIpv4Suffix(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                        return false;
                    }
                    i5++;
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            return i4 == i3 + 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x007a, code lost:
        
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.net.InetAddress decodeIpv6(java.lang.String r10, int r11, int r12) {
            /*
                r0 = 16
                byte[] r0 = new byte[r0]
                r1 = -1
                r2 = 0
                r3 = 0
                r4 = -1
                r5 = -1
            L9:
                r6 = 0
                if (r11 >= r12) goto L7b
                int r7 = r0.length
                if (r3 != r7) goto L10
                return r6
            L10:
                int r7 = r11 + 2
                if (r7 > r12) goto L28
                r8 = 2
                java.lang.String r9 = "::"
                boolean r8 = r10.regionMatches(r11, r9, r2, r8)
                if (r8 == 0) goto L28
                if (r4 == r1) goto L20
                return r6
            L20:
                int r3 = r3 + 2
                r4 = r3
                if (r7 != r12) goto L26
                goto L7b
            L26:
                r5 = r7
                goto L4c
            L28:
                if (r3 == 0) goto L4b
                r7 = 1
                java.lang.String r8 = ":"
                boolean r8 = r10.regionMatches(r11, r8, r2, r7)
                if (r8 == 0) goto L36
                int r11 = r11 + 1
                goto L4b
            L36:
                java.lang.String r8 = "."
                boolean r11 = r10.regionMatches(r11, r8, r2, r7)
                if (r11 == 0) goto L4a
                int r11 = r3 + (-2)
                boolean r10 = decodeIpv4Suffix(r10, r5, r12, r0, r11)
                if (r10 != 0) goto L47
                return r6
            L47:
                int r3 = r3 + 2
                goto L7b
            L4a:
                return r6
            L4b:
                r5 = r11
            L4c:
                r11 = r5
                r7 = 0
            L4e:
                if (r11 >= r12) goto L61
                char r8 = r10.charAt(r11)
                int r8 = com.squareup.okhttp.HttpUrl.a(r8)
                if (r8 != r1) goto L5b
                goto L61
            L5b:
                int r7 = r7 << 4
                int r7 = r7 + r8
                int r11 = r11 + 1
                goto L4e
            L61:
                int r8 = r11 - r5
                if (r8 == 0) goto L7a
                r9 = 4
                if (r8 <= r9) goto L69
                goto L7a
            L69:
                int r6 = r3 + 1
                int r8 = r7 >>> 8
                r8 = r8 & 255(0xff, float:3.57E-43)
                byte r8 = (byte) r8
                r0[r3] = r8
                int r3 = r6 + 1
                r7 = r7 & 255(0xff, float:3.57E-43)
                byte r7 = (byte) r7
                r0[r6] = r7
                goto L9
            L7a:
                return r6
            L7b:
                int r10 = r0.length
                if (r3 == r10) goto L8e
                if (r4 != r1) goto L81
                return r6
            L81:
                int r10 = r0.length
                int r11 = r3 - r4
                int r10 = r10 - r11
                java.lang.System.arraycopy(r0, r4, r0, r10, r11)
                int r10 = r0.length
                int r10 = r10 - r3
                int r10 = r10 + r4
                java.util.Arrays.fill(r0, r4, r10, r2)
            L8e:
                java.net.InetAddress r10 = java.net.InetAddress.getByAddress(r0)     // Catch: java.net.UnknownHostException -> L93
                return r10
            L93:
                java.lang.AssertionError r10 = new java.lang.AssertionError
                r10.<init>()
                goto L9a
            L99:
                throw r10
            L9a:
                goto L99
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.HttpUrl.Builder.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
        }

        private static String domainToAscii(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private static String inet6AddressToAscii(byte[] bArr) {
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            int i4 = 0;
            while (i2 < bArr.length) {
                int i5 = i2;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i2;
                if (i6 > i4) {
                    i3 = i2;
                    i4 = i6;
                }
                i2 = i5 + 2;
            }
            Buffer buffer = new Buffer();
            while (i < bArr.length) {
                if (i == i3) {
                    buffer.writeByte(58);
                    i += i4;
                    if (i == 16) {
                        buffer.writeByte(58);
                    }
                } else {
                    if (i > 0) {
                        buffer.writeByte(58);
                    }
                    buffer.writeHexadecimalUnsignedLong(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                    i += 2;
                }
            }
            return buffer.readUtf8();
        }

        private boolean isDot(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean isDotDot(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int parsePort(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(HttpUrl.a(str, i, i2, "", false, false, true));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private void pop() {
            if (!this.f.remove(r0.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
            } else {
                this.f.set(r0.size() - 1, "");
            }
        }

        private static int portColonOffset(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt != '[') {
                    i++;
                }
                do {
                    i++;
                    if (i < i2) {
                    }
                    i++;
                } while (str.charAt(i) != ']');
                i++;
            }
            return i2;
        }

        private void push(String str, int i, int i2, boolean z, boolean z2) {
            String a = HttpUrl.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, true);
            if (isDot(a)) {
                return;
            }
            if (isDotDot(a)) {
                pop();
                return;
            }
            if (this.f.get(r9.size() - 1).isEmpty()) {
                this.f.set(r9.size() - 1, a);
            } else {
                this.f.add(a);
            }
            if (z) {
                this.f.add("");
            }
        }

        private void removeAllCanonicalQueryParameters(String str) {
            for (int size = this.g.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.g.get(size))) {
                    this.g.remove(size + 1);
                    this.g.remove(size);
                    if (this.g.isEmpty()) {
                        this.g = null;
                        return;
                    }
                }
            }
        }

        private void resolvePath(String str, int i, int i2) {
            if (i == i2) {
                return;
            }
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '\\') {
                this.f.clear();
                this.f.add("");
                i++;
            } else {
                List<String> list = this.f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i3 = i;
                if (i3 >= i2) {
                    return;
                }
                i = HttpUrl.delimiterOffset(str, i3, i2, "/\\");
                boolean z = i < i2;
                push(str, i3, i, z, true);
                if (z) {
                    i++;
                }
            }
        }

        private static int schemeDelimiterOffset(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private int skipLeadingAsciiWhitespace(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i;
                }
                i++;
            }
            return i2;
        }

        private int skipTrailingAsciiWhitespace(String str, int i, int i2) {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                char charAt = str.charAt(i3);
                if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                    return i3 + 1;
                }
            }
            return i;
        }

        private static int slashCount(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        int a() {
            int i = this.e;
            return i != -1 ? i : HttpUrl.defaultPort(this.a);
        }

        ParseResult a(HttpUrl httpUrl, String str) {
            int delimiterOffset;
            int i;
            int skipLeadingAsciiWhitespace = skipLeadingAsciiWhitespace(str, 0, str.length());
            int skipTrailingAsciiWhitespace = skipTrailingAsciiWhitespace(str, skipLeadingAsciiWhitespace, str.length());
            if (schemeDelimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace) != -1) {
                if (str.regionMatches(true, skipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.a = "https";
                    skipLeadingAsciiWhitespace += 6;
                } else {
                    if (!str.regionMatches(true, skipLeadingAsciiWhitespace, "http:", 0, 5)) {
                        return ParseResult.UNSUPPORTED_SCHEME;
                    }
                    this.a = "http";
                    skipLeadingAsciiWhitespace += 5;
                }
            } else {
                if (httpUrl == null) {
                    return ParseResult.MISSING_SCHEME;
                }
                this.a = httpUrl.scheme;
            }
            int slashCount = slashCount(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace);
            char c = '?';
            char c2 = '#';
            if (slashCount >= 2 || httpUrl == null || !httpUrl.scheme.equals(this.a)) {
                int i2 = skipLeadingAsciiWhitespace + slashCount;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    delimiterOffset = HttpUrl.delimiterOffset(str, i2, skipTrailingAsciiWhitespace, "@/\\?#");
                    char charAt = delimiterOffset != skipTrailingAsciiWhitespace ? str.charAt(delimiterOffset) : (char) 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z) {
                            i = delimiterOffset;
                            this.c += "%40" + HttpUrl.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                        } else {
                            int delimiterOffset2 = HttpUrl.delimiterOffset(str, i2, delimiterOffset, ":");
                            i = delimiterOffset;
                            String a = HttpUrl.a(str, i2, delimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                            if (z2) {
                                a = this.b + "%40" + a;
                            }
                            this.b = a;
                            if (delimiterOffset2 != i) {
                                this.c = HttpUrl.a(str, delimiterOffset2 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
                                z = true;
                            }
                            z2 = true;
                        }
                        i2 = i + 1;
                    }
                    c = '?';
                    c2 = '#';
                }
                int portColonOffset = portColonOffset(str, i2, delimiterOffset);
                int i3 = portColonOffset + 1;
                this.d = canonicalizeHost(str, i2, portColonOffset);
                if (i3 < delimiterOffset) {
                    this.e = parsePort(str, i3, delimiterOffset);
                    if (this.e == -1) {
                        return ParseResult.INVALID_PORT;
                    }
                } else {
                    this.e = HttpUrl.defaultPort(this.a);
                }
                if (this.d == null) {
                    return ParseResult.INVALID_HOST;
                }
                skipLeadingAsciiWhitespace = delimiterOffset;
            } else {
                this.b = httpUrl.encodedUsername();
                this.c = httpUrl.encodedPassword();
                this.d = httpUrl.host;
                this.e = httpUrl.port;
                this.f.clear();
                this.f.addAll(httpUrl.encodedPathSegments());
                if (skipLeadingAsciiWhitespace == skipTrailingAsciiWhitespace || str.charAt(skipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int delimiterOffset3 = HttpUrl.delimiterOffset(str, skipLeadingAsciiWhitespace, skipTrailingAsciiWhitespace, "?#");
            resolvePath(str, skipLeadingAsciiWhitespace, delimiterOffset3);
            if (delimiterOffset3 < skipTrailingAsciiWhitespace && str.charAt(delimiterOffset3) == '?') {
                int delimiterOffset4 = HttpUrl.delimiterOffset(str, delimiterOffset3, skipTrailingAsciiWhitespace, "#");
                this.g = HttpUrl.b(HttpUrl.a(str, delimiterOffset3 + 1, delimiterOffset4, " \"'<>#", true, true, true));
                delimiterOffset3 = delimiterOffset4;
            }
            if (delimiterOffset3 < skipTrailingAsciiWhitespace && str.charAt(delimiterOffset3) == '#') {
                this.h = HttpUrl.a(str, 1 + delimiterOffset3, skipTrailingAsciiWhitespace, "", true, false, false);
            }
            return ParseResult.SUCCESS;
        }

        public Builder addEncodedPathSegment(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPathSegment == null");
            }
            push(str, 0, str.length(), false, true);
            return this;
        }

        public Builder addEncodedQueryParameter(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("encodedName == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(HttpUrl.a(str, " \"'<>#&=", true, true, true));
            this.g.add(str2 != null ? HttpUrl.a(str2, " \"'<>#&=", true, true, true) : null);
            return this;
        }

        public Builder addPathSegment(String str) {
            if (str == null) {
                throw new IllegalArgumentException("pathSegment == null");
            }
            push(str, 0, str.length(), false, false);
            return this;
        }

        public Builder addQueryParameter(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add(HttpUrl.a(str, " \"'<>#&=", false, true, true));
            this.g.add(str2 != null ? HttpUrl.a(str2, " \"'<>#&=", false, true, true) : null);
            return this;
        }

        Builder b() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, HttpUrl.a(this.f.get(i), "[]", true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, HttpUrl.a(str, "\\^`{|}", true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = HttpUrl.a(str2, " \"#<>\\^`{|}", true, false, false);
            }
            return this;
        }

        public HttpUrl build() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.d != null) {
                return new HttpUrl(this, null);
            }
            throw new IllegalStateException("host == null");
        }

        public Builder encodedFragment(String str) {
            this.h = str != null ? HttpUrl.a(str, "", true, false, false) : null;
            return this;
        }

        public Builder encodedPassword(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPassword == null");
            }
            this.c = HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
            return this;
        }

        public Builder encodedPath(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPath == null");
            }
            if (str.startsWith("/")) {
                resolvePath(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException("unexpected encodedPath: " + str);
        }

        public Builder encodedQuery(String str) {
            this.g = str != null ? HttpUrl.b(HttpUrl.a(str, " \"'<>#", true, true, true)) : null;
            return this;
        }

        public Builder encodedUsername(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedUsername == null");
            }
            this.b = HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
            return this;
        }

        public Builder fragment(String str) {
            this.h = str != null ? HttpUrl.a(str, "", false, false, false) : null;
            return this;
        }

        public Builder host(String str) {
            if (str == null) {
                throw new IllegalArgumentException("host == null");
            }
            String canonicalizeHost = canonicalizeHost(str, 0, str.length());
            if (canonicalizeHost != null) {
                this.d = canonicalizeHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public Builder password(String str) {
            if (str == null) {
                throw new IllegalArgumentException("password == null");
            }
            this.c = HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, true);
            return this;
        }

        public Builder port(int i) {
            if (i > 0 && i <= 65535) {
                this.e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        public Builder query(String str) {
            this.g = str != null ? HttpUrl.b(HttpUrl.a(str, " \"'<>#", false, true, true)) : null;
            return this;
        }

        public Builder removeAllEncodedQueryParameters(String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedName == null");
            }
            if (this.g == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(HttpUrl.a(str, " \"'<>#&=", true, true, true));
            return this;
        }

        public Builder removeAllQueryParameters(String str) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (this.g == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(HttpUrl.a(str, " \"'<>#&=", false, true, true));
            return this;
        }

        public Builder removePathSegment(int i) {
            this.f.remove(i);
            if (this.f.isEmpty()) {
                this.f.add("");
            }
            return this;
        }

        public Builder scheme(String str) {
            if (str == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            String str2 = "http";
            if (!str.equalsIgnoreCase("http")) {
                str2 = "https";
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
            }
            this.a = str2;
            return this;
        }

        public Builder setEncodedPathSegment(int i, String str) {
            if (str == null) {
                throw new IllegalArgumentException("encodedPathSegment == null");
            }
            String a = HttpUrl.a(str, 0, str.length(), " \"<>^`{}|/\\?#", true, false, true);
            this.f.set(i, a);
            if (!isDot(a) && !isDotDot(a)) {
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        public Builder setEncodedQueryParameter(String str, String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public Builder setPathSegment(int i, String str) {
            if (str == null) {
                throw new IllegalArgumentException("pathSegment == null");
            }
            String a = HttpUrl.a(str, 0, str.length(), " \"<>^`{}|/\\?#", false, false, true);
            if (!isDot(a) && !isDotDot(a)) {
                this.f.set(i, a);
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        public Builder setQueryParameter(String str, String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append("://");
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(':');
                    sb.append(this.c);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.d);
                sb.append(']');
            } else {
                sb.append(this.d);
            }
            int a = a();
            if (a != HttpUrl.defaultPort(this.a)) {
                sb.append(':');
                sb.append(a);
            }
            HttpUrl.b(sb, this.f);
            if (this.g != null) {
                sb.append('?');
                HttpUrl.a(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }

        public Builder username(String str) {
            if (str == null) {
                throw new IllegalArgumentException("username == null");
            }
            this.b = HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#", false, false, true);
            return this;
        }
    }

    private HttpUrl(Builder builder) {
        this.scheme = builder.a;
        this.username = a(builder.b, false);
        this.password = a(builder.c, false);
        this.host = builder.d;
        this.port = builder.a();
        this.pathSegments = percentDecode(builder.f, false);
        List<String> list = builder.g;
        this.queryNamesAndValues = list != null ? percentDecode(list, true) : null;
        String str = builder.h;
        this.fragment = str != null ? a(str, false) : null;
        this.url = builder.toString();
    }

    /* synthetic */ HttpUrl(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HttpUrl a(String str) {
        Builder builder = new Builder();
        Builder.ParseResult a = builder.a(null, str);
        int i = AnonymousClass1.a[a.ordinal()];
        if (i == 1) {
            return builder.build();
        }
        if (i == 2) {
            throw new UnknownHostException("Invalid host: " + str);
        }
        throw new MalformedURLException("Invalid URL: " + a + " for " + str);
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z3) || str2.indexOf(codePointAt) != -1 || ((codePointAt == 37 && !z) || (codePointAt == 43 && z2)))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                a(buffer, str, i3, i2, str2, z, z2, z3);
                return buffer.readUtf8();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    static String a(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                a(buffer, str, i3, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    static String a(String str, String str2, boolean z, boolean z2, boolean z3) {
        return a(str, 0, str.length(), str2, z, z2, z3);
    }

    static String a(String str, boolean z) {
        return a(str, 0, str.length(), z);
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append(Typography.amp);
            }
            sb.append(str);
            if (str2 != null) {
                sb.append('=');
                sb.append(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z2) {
                    buffer.writeUtf8(z ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z3) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && !z))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(codePointAt);
                    while (!buffer2.exhausted()) {
                        int readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        buffer.writeByte((int) HEX_DIGITS[(readByte >> 4) & 15]);
                        buffer.writeByte((int) HEX_DIGITS[readByte & 15]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(codePointAt);
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    static void a(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt != 37 || (i3 = i + 2) >= i2) {
                if (codePointAt == 43 && z) {
                    buffer.writeByte(32);
                }
                buffer.writeUtf8CodePoint(codePointAt);
            } else {
                int a = a(str.charAt(i + 1));
                int a2 = a(str.charAt(i3));
                if (a != -1 && a2 != -1) {
                    buffer.writeByte((a << 4) + a2);
                    i = i3;
                }
                buffer.writeUtf8CodePoint(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    static List<String> b(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i = indexOf + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append('/');
            sb.append(list.get(i));
        }
    }

    public static int defaultPort(String str) {
        if (str.equals("http")) {
            return 80;
        }
        if (str.equals("https")) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int delimiterOffset(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    public static HttpUrl get(URL url) {
        return parse(url.toString());
    }

    public static HttpUrl parse(String str) {
        Builder builder = new Builder();
        if (builder.a(null, str) == Builder.ParseResult.SUCCESS) {
            return builder.build();
        }
        return null;
    }

    private List<String> percentDecode(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? a(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    public String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, this.url.indexOf(64));
    }

    public String encodedPath() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        return this.url.substring(indexOf, delimiterOffset(str, indexOf, str.length(), "?#"));
    }

    public List<String> encodedPathSegments() {
        int indexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        int delimiterOffset = delimiterOffset(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < delimiterOffset) {
            int i = indexOf + 1;
            int delimiterOffset2 = delimiterOffset(this.url, i, delimiterOffset, "/");
            arrayList.add(this.url.substring(i, delimiterOffset2));
            indexOf = delimiterOffset2;
        }
        return arrayList;
    }

    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int indexOf = this.url.indexOf(63) + 1;
        String str = this.url;
        return this.url.substring(indexOf, delimiterOffset(str, indexOf + 1, str.length(), "#"));
    }

    public String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return this.url.substring(length, delimiterOffset(str, length, str.length(), ":@"));
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).url.equals(this.url);
    }

    public String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String host() {
        return this.host;
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.a = this.scheme;
        builder.b = encodedUsername();
        builder.c = encodedPassword();
        builder.d = this.host;
        builder.e = this.port != defaultPort(this.scheme) ? this.port : -1;
        builder.f.clear();
        builder.f.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.h = encodedFragment();
        return builder;
    }

    public String password() {
        return this.password;
    }

    public List<String> pathSegments() {
        return this.pathSegments;
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    public int port() {
        return this.port;
    }

    public String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        a(sb, this.queryNamesAndValues);
        return sb.toString();
    }

    public String queryParameter(String str) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.queryNamesAndValues.get(i))) {
                return this.queryNamesAndValues.get(i + 1);
            }
        }
        return null;
    }

    public String queryParameterName(int i) {
        return this.queryNamesAndValues.get(i * 2);
    }

    public Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public String queryParameterValue(int i) {
        return this.queryNamesAndValues.get((i * 2) + 1);
    }

    public List<String> queryParameterValues(String str) {
        if (this.queryNamesAndValues == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.queryNamesAndValues.size();
        for (int i = 0; i < size; i += 2) {
            if (str.equals(this.queryNamesAndValues.get(i))) {
                arrayList.add(this.queryNamesAndValues.get(i + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public HttpUrl resolve(String str) {
        Builder builder = new Builder();
        if (builder.a(this, str) == Builder.ParseResult.SUCCESS) {
            return builder.build();
        }
        return null;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public URI uri() {
        try {
            return new URI(newBuilder().b().toString());
        } catch (URISyntaxException unused) {
            throw new IllegalStateException("not valid as a java.net.URI: " + this.url);
        }
    }

    public URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String username() {
        return this.username;
    }
}
