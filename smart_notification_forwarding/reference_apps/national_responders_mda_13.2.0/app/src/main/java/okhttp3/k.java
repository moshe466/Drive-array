package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: j, reason: collision with root package name */
    private static final Pattern f12767j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k, reason: collision with root package name */
    private static final Pattern f12768k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l, reason: collision with root package name */
    private static final Pattern f12769l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m, reason: collision with root package name */
    private static final Pattern f12770m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* renamed from: a, reason: collision with root package name */
    private final String f12771a;

    /* renamed from: b, reason: collision with root package name */
    private final String f12772b;

    /* renamed from: c, reason: collision with root package name */
    private final long f12773c;

    /* renamed from: d, reason: collision with root package name */
    private final String f12774d;

    /* renamed from: e, reason: collision with root package name */
    private final String f12775e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f12776f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f12777g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f12778h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f12779i;

    private k(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.f12771a = str;
        this.f12772b = str2;
        this.f12773c = j10;
        this.f12774d = str3;
        this.f12775e = str4;
        this.f12776f = z10;
        this.f12777g = z11;
        this.f12779i = z12;
        this.f12778h = z13;
    }

    private static int a(String str, int i10, int i11, boolean z10) {
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z10)) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    private static boolean b(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !sb.c.J(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static okhttp3.k d(long r23, okhttp3.r r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.k.d(long, okhttp3.r, java.lang.String):okhttp3.k");
    }

    public static k e(r rVar, String str) {
        return d(System.currentTimeMillis(), rVar, str);
    }

    public static List<k> f(r rVar, q qVar) {
        List<String> j10 = qVar.j("Set-Cookie");
        int size = j10.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            k e10 = e(rVar, j10.get(i10));
            if (e10 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(e10);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    private static String g(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String d10 = sb.c.d(str);
        if (d10 != null) {
            return d10;
        }
        throw new IllegalArgumentException();
    }

    private static long h(String str, int i10, int i11) {
        int a10 = a(str, i10, i11, false);
        Matcher matcher = f12770m.matcher(str);
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        while (a10 < i11) {
            int a11 = a(str, a10 + 1, i11, true);
            matcher.region(a10, a11);
            if (i13 == -1 && matcher.usePattern(f12770m).matches()) {
                i13 = Integer.parseInt(matcher.group(1));
                i16 = Integer.parseInt(matcher.group(2));
                i17 = Integer.parseInt(matcher.group(3));
            } else if (i14 == -1 && matcher.usePattern(f12769l).matches()) {
                i14 = Integer.parseInt(matcher.group(1));
            } else {
                if (i15 == -1) {
                    Pattern pattern = f12768k;
                    if (matcher.usePattern(pattern).matches()) {
                        i15 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i12 == -1 && matcher.usePattern(f12767j).matches()) {
                    i12 = Integer.parseInt(matcher.group(1));
                }
            }
            a10 = a(str, a11 + 1, i11, false);
        }
        if (i12 >= 70 && i12 <= 99) {
            i12 += 1900;
        }
        if (i12 >= 0 && i12 <= 69) {
            i12 += 2000;
        }
        if (i12 < 1601) {
            throw new IllegalArgumentException();
        }
        if (i15 == -1) {
            throw new IllegalArgumentException();
        }
        if (i14 < 1 || i14 > 31) {
            throw new IllegalArgumentException();
        }
        if (i13 < 0 || i13 > 23) {
            throw new IllegalArgumentException();
        }
        if (i16 < 0 || i16 > 59) {
            throw new IllegalArgumentException();
        }
        if (i17 < 0 || i17 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(sb.c.f14209n);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i12);
        gregorianCalendar.set(2, i15 - 1);
        gregorianCalendar.set(5, i14);
        gregorianCalendar.set(11, i13);
        gregorianCalendar.set(12, i16);
        gregorianCalendar.set(13, i17);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    private static long i(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e10) {
            if (str.matches("-?\\d+")) {
                return str.startsWith("-") ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e10;
        }
    }

    public String c() {
        return this.f12771a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return kVar.f12771a.equals(this.f12771a) && kVar.f12772b.equals(this.f12772b) && kVar.f12774d.equals(this.f12774d) && kVar.f12775e.equals(this.f12775e) && kVar.f12773c == this.f12773c && kVar.f12776f == this.f12776f && kVar.f12777g == this.f12777g && kVar.f12778h == this.f12778h && kVar.f12779i == this.f12779i;
    }

    public int hashCode() {
        int hashCode = (((((((527 + this.f12771a.hashCode()) * 31) + this.f12772b.hashCode()) * 31) + this.f12774d.hashCode()) * 31) + this.f12775e.hashCode()) * 31;
        long j10 = this.f12773c;
        return ((((((((hashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (!this.f12776f ? 1 : 0)) * 31) + (!this.f12777g ? 1 : 0)) * 31) + (!this.f12778h ? 1 : 0)) * 31) + (!this.f12779i ? 1 : 0);
    }

    String j(boolean z10) {
        String a10;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f12771a);
        sb2.append('=');
        sb2.append(this.f12772b);
        if (this.f12778h) {
            if (this.f12773c == Long.MIN_VALUE) {
                a10 = "; max-age=0";
            } else {
                sb2.append("; expires=");
                a10 = vb.d.a(new Date(this.f12773c));
            }
            sb2.append(a10);
        }
        if (!this.f12779i) {
            sb2.append("; domain=");
            if (z10) {
                sb2.append(".");
            }
            sb2.append(this.f12774d);
        }
        sb2.append("; path=");
        sb2.append(this.f12775e);
        if (this.f12776f) {
            sb2.append("; secure");
        }
        if (this.f12777g) {
            sb2.append("; httponly");
        }
        return sb2.toString();
    }

    public String k() {
        return this.f12772b;
    }

    public String toString() {
        return j(false);
    }
}
