package androidx.core.text;

import android.annotation.SuppressLint;
import android.icu.util.ULocale;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static Method f2473a;

    /* renamed from: b, reason: collision with root package name */
    private static Method f2474b;

    /* renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0035a {
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    /* loaded from: classes.dex */
    static class b {
        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 21) {
            if (i10 < 24) {
                try {
                    f2474b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
                    return;
                } catch (Exception e10) {
                    throw new IllegalStateException(e10);
                }
            }
            return;
        }
        try {
            Class<?> cls = Class.forName("libcore.icu.ICU");
            f2473a = cls.getMethod("getScript", String.class);
            f2474b = cls.getMethod("addLikelySubtags", String.class);
        } catch (Exception unused) {
            f2473a = null;
            f2474b = null;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String a(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = f2474b;
            if (method != null) {
                return (String) method.invoke(null, locale2);
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return locale2;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static String b(String str) {
        try {
            Method method = f2473a;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
        return null;
    }

    public static String c(Locale locale) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            return b.c(b.a(b.b(locale)));
        }
        if (i10 >= 21) {
            try {
                return C0035a.a((Locale) f2474b.invoke(null, locale));
            } catch (IllegalAccessException | InvocationTargetException unused) {
                return C0035a.a(locale);
            }
        }
        String a10 = a(locale);
        if (a10 != null) {
            return b(a10);
        }
        return null;
    }
}
