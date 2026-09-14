package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final i f2424a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    static {
        a(new Locale[0]);
    }

    private g(i iVar) {
        this.f2424a = iVar;
    }

    public static g a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? d(a.a(localeArr)) : new g(new h(localeArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static g d(LocaleList localeList) {
        return new g(new j(localeList));
    }

    public Locale c(int i10) {
        return this.f2424a.get(i10);
    }

    public boolean equals(Object obj) {
        return (obj instanceof g) && this.f2424a.equals(((g) obj).f2424a);
    }

    public int hashCode() {
        return this.f2424a.hashCode();
    }

    public String toString() {
        return this.f2424a.toString();
    }
}
