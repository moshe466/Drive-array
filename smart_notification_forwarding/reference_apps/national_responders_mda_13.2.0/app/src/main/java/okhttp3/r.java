package okhttp3;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: j, reason: collision with root package name */
    private static final char[] f12797j = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    final String f12798a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12799b;

    /* renamed from: c, reason: collision with root package name */
    private final String f12800c;

    /* renamed from: d, reason: collision with root package name */
    final String f12801d;

    /* renamed from: e, reason: collision with root package name */
    final int f12802e;

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f12803f;

    /* renamed from: g, reason: collision with root package name */
    private final List<String> f12804g;

    /* renamed from: h, reason: collision with root package name */
    private final String f12805h;

    /* renamed from: i, reason: collision with root package name */
    private final String f12806i;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        String f12807a;

        /* renamed from: d, reason: collision with root package name */
        String f12810d;

        /* renamed from: f, reason: collision with root package name */
        final List<String> f12812f;

        /* renamed from: g, reason: collision with root package name */
        List<String> f12813g;

        /* renamed from: h, reason: collision with root package name */
        String f12814h;

        /* renamed from: b, reason: collision with root package name */
        String f12808b = "";

        /* renamed from: c, reason: collision with root package name */
        String f12809c = "";

        /* renamed from: e, reason: collision with root package name */
        int f12811e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f12812f = arrayList;
            arrayList.add("");
        }

        private static String c(String str, int i10, int i11) {
            return sb.c.d(r.s(str, i10, i11, false));
        }

        private boolean g(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean h(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int j(String str, int i10, int i11) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(r.a(str, i10, i11, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private void l() {
            if (!this.f12812f.remove(r0.size() - 1).isEmpty() || this.f12812f.isEmpty()) {
                this.f12812f.add("");
            } else {
                this.f12812f.set(r0.size() - 1, "");
            }
        }

        private static int n(String str, int i10, int i11) {
            while (i10 < i11) {
                char charAt = str.charAt(i10);
                if (charAt == ':') {
                    return i10;
                }
                if (charAt != '[') {
                    i10++;
                }
                do {
                    i10++;
                    if (i10 < i11) {
                    }
                    i10++;
                } while (str.charAt(i10) != ']');
                i10++;
            }
            return i11;
        }

        private void o(String str, int i10, int i11, boolean z10, boolean z11) {
            String a10 = r.a(str, i10, i11, " \"<>^`{}|/\\?#", z11, false, false, true, null);
            if (g(a10)) {
                return;
            }
            if (h(a10)) {
                l();
                return;
            }
            if (this.f12812f.get(r11.size() - 1).isEmpty()) {
                this.f12812f.set(r11.size() - 1, a10);
            } else {
                this.f12812f.add(a10);
            }
            if (z10) {
                this.f12812f.add("");
            }
        }

        private void q(String str, int i10, int i11) {
            if (i10 == i11) {
                return;
            }
            char charAt = str.charAt(i10);
            if (charAt == '/' || charAt == '\\') {
                this.f12812f.clear();
                this.f12812f.add("");
                i10++;
            } else {
                List<String> list = this.f12812f;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i12 = i10;
                if (i12 >= i11) {
                    return;
                }
                i10 = sb.c.o(str, i12, i11, "/\\");
                boolean z10 = i10 < i11;
                o(str, i12, i10, z10, true);
                if (z10) {
                    i10++;
                }
            }
        }

        private static int s(String str, int i10, int i11) {
            if (i11 - i10 < 2) {
                return -1;
            }
            char charAt = str.charAt(i10);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i10++;
                    if (i10 >= i11) {
                        break;
                    }
                    char charAt2 = str.charAt(i10);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i10;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int t(String str, int i10, int i11) {
            int i12 = 0;
            while (i10 < i11) {
                char charAt = str.charAt(i10);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i12++;
                i10++;
            }
            return i12;
        }

        public a a(String str, String str2) {
            Objects.requireNonNull(str, "encodedName == null");
            if (this.f12813g == null) {
                this.f12813g = new ArrayList();
            }
            this.f12813g.add(r.b(str, " \"'<>#&=", true, false, true, true));
            this.f12813g.add(str2 != null ? r.b(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public r b() {
            if (this.f12807a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.f12810d != null) {
                return new r(this);
            }
            throw new IllegalStateException("host == null");
        }

        int d() {
            int i10 = this.f12811e;
            return i10 != -1 ? i10 : r.d(this.f12807a);
        }

        public a e(String str) {
            this.f12813g = str != null ? r.z(r.b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a f(String str) {
            Objects.requireNonNull(str, "host == null");
            String c10 = c(str, 0, str.length());
            if (c10 != null) {
                this.f12810d = c10;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        a i(r rVar, String str) {
            int o10;
            int i10;
            int E = sb.c.E(str, 0, str.length());
            int F = sb.c.F(str, E, str.length());
            int s10 = s(str, E, F);
            if (s10 != -1) {
                if (str.regionMatches(true, E, "https:", 0, 6)) {
                    this.f12807a = "https";
                    E += 6;
                } else {
                    if (!str.regionMatches(true, E, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, s10) + "'");
                    }
                    this.f12807a = "http";
                    E += 5;
                }
            } else {
                if (rVar == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f12807a = rVar.f12798a;
            }
            int t10 = t(str, E, F);
            char c10 = '?';
            char c11 = '#';
            if (t10 >= 2 || rVar == null || !rVar.f12798a.equals(this.f12807a)) {
                int i11 = E + t10;
                boolean z10 = false;
                boolean z11 = false;
                while (true) {
                    o10 = sb.c.o(str, i11, F, "@/\\?#");
                    char charAt = o10 != F ? str.charAt(o10) : (char) 65535;
                    if (charAt == 65535 || charAt == c11 || charAt == '/' || charAt == '\\' || charAt == c10) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z10) {
                            i10 = o10;
                            this.f12809c += "%40" + r.a(str, i11, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int n10 = sb.c.n(str, i11, o10, ':');
                            i10 = o10;
                            String a10 = r.a(str, i11, n10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z11) {
                                a10 = this.f12808b + "%40" + a10;
                            }
                            this.f12808b = a10;
                            if (n10 != i10) {
                                this.f12809c = r.a(str, n10 + 1, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z10 = true;
                            }
                            z11 = true;
                        }
                        i11 = i10 + 1;
                    }
                    c10 = '?';
                    c11 = '#';
                }
                int n11 = n(str, i11, o10);
                int i12 = n11 + 1;
                if (i12 < o10) {
                    this.f12810d = c(str, i11, n11);
                    int j10 = j(str, i12, o10);
                    this.f12811e = j10;
                    if (j10 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i12, o10) + '\"');
                    }
                } else {
                    this.f12810d = c(str, i11, n11);
                    this.f12811e = r.d(this.f12807a);
                }
                if (this.f12810d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i11, n11) + '\"');
                }
                E = o10;
            } else {
                this.f12808b = rVar.j();
                this.f12809c = rVar.f();
                this.f12810d = rVar.f12801d;
                this.f12811e = rVar.f12802e;
                this.f12812f.clear();
                this.f12812f.addAll(rVar.h());
                if (E == F || str.charAt(E) == '#') {
                    e(rVar.i());
                }
            }
            int o11 = sb.c.o(str, E, F, "?#");
            q(str, E, o11);
            if (o11 < F && str.charAt(o11) == '?') {
                int n12 = sb.c.n(str, o11, F, '#');
                this.f12813g = r.z(r.a(str, o11 + 1, n12, " \"'<>#", true, false, true, true, null));
                o11 = n12;
            }
            if (o11 < F && str.charAt(o11) == '#') {
                this.f12814h = r.a(str, 1 + o11, F, "", true, false, false, false, null);
            }
            return this;
        }

        public a k(String str) {
            Objects.requireNonNull(str, "password == null");
            this.f12809c = r.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a m(int i10) {
            if (i10 > 0 && i10 <= 65535) {
                this.f12811e = i10;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i10);
        }

        a p() {
            int size = this.f12812f.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f12812f.set(i10, r.b(this.f12812f.get(i10), "[]", true, true, false, true));
            }
            List<String> list = this.f12813g;
            if (list != null) {
                int size2 = list.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    String str = this.f12813g.get(i11);
                    if (str != null) {
                        this.f12813g.set(i11, r.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.f12814h;
            if (str2 != null) {
                this.f12814h = r.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a r(String str) {
            Objects.requireNonNull(str, "scheme == null");
            String str2 = "http";
            if (!str.equalsIgnoreCase("http")) {
                str2 = "https";
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
            }
            this.f12807a = str2;
            return this;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            String str2 = this.f12807a;
            if (str2 != null) {
                sb2.append(str2);
                str = "://";
            } else {
                str = "//";
            }
            sb2.append(str);
            if (!this.f12808b.isEmpty() || !this.f12809c.isEmpty()) {
                sb2.append(this.f12808b);
                if (!this.f12809c.isEmpty()) {
                    sb2.append(':');
                    sb2.append(this.f12809c);
                }
                sb2.append('@');
            }
            String str3 = this.f12810d;
            if (str3 != null) {
                if (str3.indexOf(58) != -1) {
                    sb2.append('[');
                    sb2.append(this.f12810d);
                    sb2.append(']');
                } else {
                    sb2.append(this.f12810d);
                }
            }
            if (this.f12811e != -1 || this.f12807a != null) {
                int d10 = d();
                String str4 = this.f12807a;
                if (str4 == null || d10 != r.d(str4)) {
                    sb2.append(':');
                    sb2.append(d10);
                }
            }
            r.r(sb2, this.f12812f);
            if (this.f12813g != null) {
                sb2.append('?');
                r.n(sb2, this.f12813g);
            }
            if (this.f12814h != null) {
                sb2.append('#');
                sb2.append(this.f12814h);
            }
            return sb2.toString();
        }

        public a u(String str) {
            Objects.requireNonNull(str, "username == null");
            this.f12808b = r.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }
    }

    r(a aVar) {
        this.f12798a = aVar.f12807a;
        this.f12799b = t(aVar.f12808b, false);
        this.f12800c = t(aVar.f12809c, false);
        this.f12801d = aVar.f12810d;
        this.f12802e = aVar.d();
        this.f12803f = u(aVar.f12812f, false);
        List<String> list = aVar.f12813g;
        this.f12804g = list != null ? u(list, true) : null;
        String str = aVar.f12814h;
        this.f12805h = str != null ? t(str, false) : null;
        this.f12806i = aVar.toString();
    }

    static String a(String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        int i12 = i10;
        while (i12 < i11) {
            int codePointAt = str.codePointAt(i12);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z13)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z10 && (!z11 || w(str, i12, i11)))) && (codePointAt != 43 || !z12))) {
                    i12 += Character.charCount(codePointAt);
                }
            }
            bc.c cVar = new bc.c();
            cVar.B0(str, i10, i12);
            c(cVar, str, i12, i11, str2, z10, z11, z12, z13, charset);
            return cVar.k0();
        }
        return str.substring(i10, i11);
    }

    static String b(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13) {
        return a(str, 0, str.length(), str2, z10, z11, z12, z13, null);
    }

    static void c(bc.c cVar, String str, int i10, int i11, String str2, boolean z10, boolean z11, boolean z12, boolean z13, Charset charset) {
        bc.c cVar2 = null;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (!z10 || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z12) {
                    cVar.S(z10 ? "+" : "%2B");
                } else if (codePointAt < 32 || codePointAt == 127 || ((codePointAt >= 128 && z13) || str2.indexOf(codePointAt) != -1 || (codePointAt == 37 && (!z10 || (z11 && !w(str, i10, i11)))))) {
                    if (cVar2 == null) {
                        cVar2 = new bc.c();
                    }
                    if (charset == null || charset.equals(sb.c.f14204i)) {
                        cVar2.C0(codePointAt);
                    } else {
                        cVar2.z0(str, i10, Character.charCount(codePointAt) + i10, charset);
                    }
                    while (!cVar2.z()) {
                        int Z = cVar2.Z() & 255;
                        cVar.A(37);
                        char[] cArr = f12797j;
                        cVar.A(cArr[(Z >> 4) & 15]);
                        cVar.A(cArr[Z & 15]);
                    }
                } else {
                    cVar.C0(codePointAt);
                }
            }
            i10 += Character.charCount(codePointAt);
        }
    }

    public static int d(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static r k(String str) {
        return new a().i(null, str).b();
    }

    static void n(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10 += 2) {
            String str = list.get(i10);
            String str2 = list.get(i10 + 1);
            if (i10 > 0) {
                sb2.append('&');
            }
            sb2.append(str);
            if (str2 != null) {
                sb2.append('=');
                sb2.append(str2);
            }
        }
    }

    public static r q(String str) {
        try {
            return k(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    static void r(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            sb2.append('/');
            sb2.append(list.get(i10));
        }
    }

    static String s(String str, int i10, int i11, boolean z10) {
        for (int i12 = i10; i12 < i11; i12++) {
            char charAt = str.charAt(i12);
            if (charAt == '%' || (charAt == '+' && z10)) {
                bc.c cVar = new bc.c();
                cVar.B0(str, i10, i12);
                v(cVar, str, i12, i11, z10);
                return cVar.k0();
            }
        }
        return str.substring(i10, i11);
    }

    static String t(String str, boolean z10) {
        return s(str, 0, str.length(), z10);
    }

    private List<String> u(List<String> list, boolean z10) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i10 = 0; i10 < size; i10++) {
            String str = list.get(i10);
            arrayList.add(str != null ? t(str, z10) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void v(bc.c cVar, String str, int i10, int i11, boolean z10) {
        int i12;
        while (i10 < i11) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt != 37 || (i12 = i10 + 2) >= i11) {
                if (codePointAt == 43 && z10) {
                    cVar.A(32);
                }
                cVar.C0(codePointAt);
            } else {
                int k10 = sb.c.k(str.charAt(i10 + 1));
                int k11 = sb.c.k(str.charAt(i12));
                if (k10 != -1 && k11 != -1) {
                    cVar.A((k10 << 4) + k11);
                    i10 = i12;
                }
                cVar.C0(codePointAt);
            }
            i10 += Character.charCount(codePointAt);
        }
    }

    static boolean w(String str, int i10, int i11) {
        int i12 = i10 + 2;
        return i12 < i11 && str.charAt(i10) == '%' && sb.c.k(str.charAt(i10 + 1)) != -1 && sb.c.k(str.charAt(i12)) != -1;
    }

    static List<String> z(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 <= str.length()) {
            int indexOf = str.indexOf(38, i10);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i10);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i10, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i10, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i10 = indexOf + 1;
        }
        return arrayList;
    }

    public String A() {
        return p("/...").u("").k("").b().toString();
    }

    public r B(String str) {
        a p10 = p(str);
        if (p10 != null) {
            return p10.b();
        }
        return null;
    }

    public String C() {
        return this.f12798a;
    }

    public URI D() {
        String aVar = o().p().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e10) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    public String e() {
        if (this.f12805h == null) {
            return null;
        }
        return this.f12806i.substring(this.f12806i.indexOf(35) + 1);
    }

    public boolean equals(Object obj) {
        return (obj instanceof r) && ((r) obj).f12806i.equals(this.f12806i);
    }

    public String f() {
        if (this.f12800c.isEmpty()) {
            return "";
        }
        return this.f12806i.substring(this.f12806i.indexOf(58, this.f12798a.length() + 3) + 1, this.f12806i.indexOf(64));
    }

    public String g() {
        int indexOf = this.f12806i.indexOf(47, this.f12798a.length() + 3);
        String str = this.f12806i;
        return this.f12806i.substring(indexOf, sb.c.o(str, indexOf, str.length(), "?#"));
    }

    public List<String> h() {
        int indexOf = this.f12806i.indexOf(47, this.f12798a.length() + 3);
        String str = this.f12806i;
        int o10 = sb.c.o(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < o10) {
            int i10 = indexOf + 1;
            int n10 = sb.c.n(this.f12806i, i10, o10, '/');
            arrayList.add(this.f12806i.substring(i10, n10));
            indexOf = n10;
        }
        return arrayList;
    }

    public int hashCode() {
        return this.f12806i.hashCode();
    }

    public String i() {
        if (this.f12804g == null) {
            return null;
        }
        int indexOf = this.f12806i.indexOf(63) + 1;
        String str = this.f12806i;
        return this.f12806i.substring(indexOf, sb.c.n(str, indexOf, str.length(), '#'));
    }

    public String j() {
        if (this.f12799b.isEmpty()) {
            return "";
        }
        int length = this.f12798a.length() + 3;
        String str = this.f12806i;
        return this.f12806i.substring(length, sb.c.o(str, length, str.length(), ":@"));
    }

    public String l() {
        return this.f12801d;
    }

    public boolean m() {
        return this.f12798a.equals("https");
    }

    public a o() {
        a aVar = new a();
        aVar.f12807a = this.f12798a;
        aVar.f12808b = j();
        aVar.f12809c = f();
        aVar.f12810d = this.f12801d;
        aVar.f12811e = this.f12802e != d(this.f12798a) ? this.f12802e : -1;
        aVar.f12812f.clear();
        aVar.f12812f.addAll(h());
        aVar.e(i());
        aVar.f12814h = e();
        return aVar;
    }

    public a p(String str) {
        try {
            return new a().i(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String toString() {
        return this.f12806i;
    }

    public int x() {
        return this.f12802e;
    }

    public String y() {
        if (this.f12804g == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        n(sb2, this.f12804g);
        return sb2.toString();
    }
}
