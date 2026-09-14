package androidx.core.os;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: classes.dex */
final class h implements i {

    /* renamed from: b, reason: collision with root package name */
    private static final Locale[] f2425b = new Locale[0];

    /* renamed from: a, reason: collision with root package name */
    private final Locale[] f2426a;

    static {
        new Locale("en", "XA");
        new Locale("ar", "XB");
        g.b("en-Latn");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f2426a = f2425b;
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < localeArr.length; i10++) {
            Locale locale = localeArr[i10];
            if (locale == null) {
                throw new NullPointerException("list[" + i10 + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                b(sb2, locale2);
                if (i10 < localeArr.length - 1) {
                    sb2.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f2426a = (Locale[]) arrayList.toArray(new Locale[0]);
    }

    static void b(StringBuilder sb2, Locale locale) {
        sb2.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb2.append('-');
        sb2.append(locale.getCountry());
    }

    @Override // androidx.core.os.i
    public Object a() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        Locale[] localeArr = ((h) obj).f2426a;
        if (this.f2426a.length != localeArr.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            Locale[] localeArr2 = this.f2426a;
            if (i10 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i10].equals(localeArr[i10])) {
                return false;
            }
            i10++;
        }
    }

    @Override // androidx.core.os.i
    public Locale get(int i10) {
        if (i10 >= 0) {
            Locale[] localeArr = this.f2426a;
            if (i10 < localeArr.length) {
                return localeArr[i10];
            }
        }
        return null;
    }

    public int hashCode() {
        int i10 = 1;
        for (Locale locale : this.f2426a) {
            i10 = (i10 * 31) + locale.hashCode();
        }
        return i10;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        int i10 = 0;
        while (true) {
            Locale[] localeArr = this.f2426a;
            if (i10 >= localeArr.length) {
                sb2.append("]");
                return sb2.toString();
            }
            sb2.append(localeArr[i10]);
            if (i10 < this.f2426a.length - 1) {
                sb2.append(',');
            }
            i10++;
        }
    }
}
