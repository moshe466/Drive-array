package sb;

import bc.e;
import bc.f;
import bc.s;
import bc.t;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.b0;
import okhttp3.q;
import okhttp3.r;
import okhttp3.z;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f14196a;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f14197b = new String[0];

    /* renamed from: c, reason: collision with root package name */
    public static final b0 f14198c;

    /* renamed from: d, reason: collision with root package name */
    private static final f f14199d;

    /* renamed from: e, reason: collision with root package name */
    private static final f f14200e;

    /* renamed from: f, reason: collision with root package name */
    private static final f f14201f;

    /* renamed from: g, reason: collision with root package name */
    private static final f f14202g;

    /* renamed from: h, reason: collision with root package name */
    private static final f f14203h;

    /* renamed from: i, reason: collision with root package name */
    public static final Charset f14204i;

    /* renamed from: j, reason: collision with root package name */
    private static final Charset f14205j;

    /* renamed from: k, reason: collision with root package name */
    private static final Charset f14206k;

    /* renamed from: l, reason: collision with root package name */
    private static final Charset f14207l;

    /* renamed from: m, reason: collision with root package name */
    private static final Charset f14208m;

    /* renamed from: n, reason: collision with root package name */
    public static final TimeZone f14209n;

    /* renamed from: o, reason: collision with root package name */
    public static final Comparator<String> f14210o;

    /* renamed from: p, reason: collision with root package name */
    private static final Method f14211p;

    /* renamed from: q, reason: collision with root package name */
    private static final Pattern f14212q;

    /* loaded from: classes.dex */
    class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* loaded from: classes.dex */
    class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14213a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f14214b;

        b(String str, boolean z10) {
            this.f14213a = str;
            this.f14214b = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f14213a);
            thread.setDaemon(this.f14214b);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f14196a = bArr;
        Method method = null;
        f14198c = b0.j(null, bArr);
        z.e(null, bArr);
        f14199d = f.o("efbbbf");
        f14200e = f.o("feff");
        f14201f = f.o("fffe");
        f14202g = f.o("0000ffff");
        f14203h = f.o("ffff0000");
        f14204i = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        f14205j = Charset.forName("UTF-16BE");
        f14206k = Charset.forName("UTF-16LE");
        f14207l = Charset.forName("UTF-32BE");
        f14208m = Charset.forName("UTF-32LE");
        f14209n = TimeZone.getTimeZone("GMT");
        f14210o = new a();
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f14211p = method;
        f14212q = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static boolean A(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean B(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static X509TrustManager C() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e10) {
            throw b("No System TLS", e10);
        }
    }

    public static boolean D(s sVar, int i10, TimeUnit timeUnit) {
        long nanoTime = System.nanoTime();
        long c10 = sVar.e().e() ? sVar.e().c() - nanoTime : Long.MAX_VALUE;
        sVar.e().d(Math.min(c10, timeUnit.toNanos(i10)) + nanoTime);
        try {
            bc.c cVar = new bc.c();
            while (sVar.G(cVar, 8192L) != -1) {
                cVar.d();
            }
            t e10 = sVar.e();
            if (c10 == Long.MAX_VALUE) {
                e10.a();
            } else {
                e10.d(nanoTime + c10);
            }
            return true;
        } catch (InterruptedIOException unused) {
            t e11 = sVar.e();
            if (c10 == Long.MAX_VALUE) {
                e11.a();
            } else {
                e11.d(nanoTime + c10);
            }
            return false;
        } catch (Throwable th) {
            t e12 = sVar.e();
            if (c10 == Long.MAX_VALUE) {
                e12.a();
            } else {
                e12.d(nanoTime + c10);
            }
            throw th;
        }
    }

    public static int E(String str, int i10, int i11) {
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static int F(String str, int i10, int i11) {
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            char charAt = str.charAt(i12);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i12 + 1;
            }
        }
        return i10;
    }

    public static ThreadFactory G(String str, boolean z10) {
        return new b(str, z10);
    }

    public static q H(List<xb.c> list) {
        q.a aVar = new q.a();
        for (xb.c cVar : list) {
            sb.a.f14194a.b(aVar, cVar.f15679a.G(), cVar.f15680b.G());
        }
        return aVar.d();
    }

    public static String I(String str, int i10, int i11) {
        int E = E(str, i10, i11);
        return str.substring(E, F(str, E, i11));
    }

    public static boolean J(String str) {
        return f14212q.matcher(str).matches();
    }

    public static void a(Throwable th, Throwable th2) {
        Method method = f14211p;
        if (method != null) {
            try {
                method.invoke(th, th2);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static AssertionError b(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static Charset c(e eVar, Charset charset) {
        if (eVar.T(0L, f14199d)) {
            eVar.q(r0.B());
            return f14204i;
        }
        if (eVar.T(0L, f14200e)) {
            eVar.q(r0.B());
            return f14205j;
        }
        if (eVar.T(0L, f14201f)) {
            eVar.q(r0.B());
            return f14206k;
        }
        if (eVar.T(0L, f14202g)) {
            eVar.q(r0.B());
            return f14207l;
        }
        if (!eVar.T(0L, f14203h)) {
            return charset;
        }
        eVar.q(r0.B());
        return f14208m;
    }

    public static String d(String str) {
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (j(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress m10 = (str.startsWith("[") && str.endsWith("]")) ? m(str, 1, str.length() - 1) : m(str, 0, str.length());
        if (m10 == null) {
            return null;
        }
        byte[] address = m10.getAddress();
        if (address.length == 16) {
            return y(address);
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + "'");
    }

    public static int e(String str, long j10, TimeUnit timeUnit) {
        if (j10 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        Objects.requireNonNull(timeUnit, "unit == null");
        long millis = timeUnit.toMillis(j10);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j10 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    public static void f(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void g(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static void h(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e10) {
                if (!A(e10)) {
                    throw e10;
                }
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static String[] i(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    private static boolean j(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int k(char c10) {
        if (c10 >= '0' && c10 <= '9') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (c10 < 'a' || c10 > 'f') {
            c11 = 'A';
            if (c10 < 'A' || c10 > 'F') {
                return -1;
            }
        }
        return (c10 - c11) + 10;
    }

    private static boolean l(String str, int i10, int i11, byte[] bArr, int i12) {
        int i13 = i12;
        while (i10 < i11) {
            if (i13 == bArr.length) {
                return false;
            }
            if (i13 != i12) {
                if (str.charAt(i10) != '.') {
                    return false;
                }
                i10++;
            }
            int i14 = i10;
            int i15 = 0;
            while (i14 < i11) {
                char charAt = str.charAt(i14);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                if ((i15 == 0 && i10 != i14) || (i15 = ((i15 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i14++;
            }
            if (i14 - i10 == 0) {
                return false;
            }
            bArr[i13] = (byte) i15;
            i13++;
            i10 = i14;
        }
        return i13 == i12 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.net.InetAddress m(java.lang.String r11, int r12, int r13) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
        L9:
            r7 = 0
            if (r12 >= r13) goto L7a
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r12 + 2
            if (r8 > r13) goto L27
            java.lang.String r9 = "::"
            r10 = 2
            boolean r9 = r11.regionMatches(r12, r9, r3, r10)
            if (r9 == 0) goto L27
            if (r5 == r2) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r13) goto L25
            goto L7a
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L4a
            java.lang.String r8 = ":"
            r9 = 1
            boolean r8 = r11.regionMatches(r12, r8, r3, r9)
            if (r8 == 0) goto L35
            int r12 = r12 + 1
            goto L4a
        L35:
            java.lang.String r8 = "."
            boolean r12 = r11.regionMatches(r12, r8, r3, r9)
            if (r12 == 0) goto L49
            int r12 = r4 + (-2)
            boolean r11 = l(r11, r6, r13, r1, r12)
            if (r11 != 0) goto L46
            return r7
        L46:
            int r4 = r4 + 2
            goto L7a
        L49:
            return r7
        L4a:
            r6 = r12
        L4b:
            r12 = r6
            r8 = 0
        L4d:
            if (r12 >= r13) goto L60
            char r9 = r11.charAt(r12)
            int r9 = k(r9)
            if (r9 != r2) goto L5a
            goto L60
        L5a:
            int r8 = r8 << 4
            int r8 = r8 + r9
            int r12 = r12 + 1
            goto L4d
        L60:
            int r9 = r12 - r6
            if (r9 == 0) goto L79
            r10 = 4
            if (r9 <= r10) goto L68
            goto L79
        L68:
            int r7 = r4 + 1
            int r9 = r8 >>> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r1[r4] = r9
            int r4 = r7 + 1
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L79:
            return r7
        L7a:
            if (r4 == r0) goto L8b
            if (r5 != r2) goto L7f
            return r7
        L7f:
            int r11 = r4 - r5
            int r12 = 16 - r11
            java.lang.System.arraycopy(r1, r5, r1, r12, r11)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r3)
        L8b:
            java.net.InetAddress r11 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L90
            return r11
        L90:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: sb.c.m(java.lang.String, int, int):java.net.InetAddress");
    }

    public static int n(String str, int i10, int i11, char c10) {
        while (i10 < i11) {
            if (str.charAt(i10) == c10) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static int o(String str, int i10, int i11, String str2) {
        while (i10 < i11) {
            if (str2.indexOf(str.charAt(i10)) != -1) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    public static boolean p(s sVar, int i10, TimeUnit timeUnit) {
        try {
            return D(sVar, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean q(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static String r(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static String s(r rVar, boolean z10) {
        String l10;
        if (rVar.l().contains(":")) {
            l10 = "[" + rVar.l() + "]";
        } else {
            l10 = rVar.l();
        }
        if (!z10 && rVar.x() == r.d(rVar.C())) {
            return l10;
        }
        return l10 + ":" + rVar.x();
    }

    public static <T> List<T> t(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> u(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> v(Map<K, V> map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static int w(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (comparator.compare(strArr[i10], str) == 0) {
                return i10;
            }
        }
        return -1;
    }

    public static int x(String str) {
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt <= 31 || charAt >= 127) {
                return i10;
            }
        }
        return -1;
    }

    private static String y(byte[] bArr) {
        int i10 = 0;
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        while (i12 < bArr.length) {
            int i14 = i12;
            while (i14 < 16 && bArr[i14] == 0 && bArr[i14 + 1] == 0) {
                i14 += 2;
            }
            int i15 = i14 - i12;
            if (i15 > i13 && i15 >= 4) {
                i11 = i12;
                i13 = i15;
            }
            i12 = i14 + 2;
        }
        bc.c cVar = new bc.c();
        while (i10 < bArr.length) {
            if (i10 == i11) {
                cVar.A(58);
                i10 += i13;
                if (i10 == 16) {
                    cVar.A(58);
                }
            } else {
                if (i10 > 0) {
                    cVar.A(58);
                }
                cVar.o(((bArr[i10] & 255) << 8) | (bArr[i10 + 1] & 255));
                i10 += 2;
            }
        }
        return cVar.k0();
    }

    public static String[] z(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i10]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i10++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }
}
