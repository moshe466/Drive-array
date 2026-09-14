package androidx.core.text;

import android.os.Build;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final Locale f2494a = new Locale("", "");

    /* loaded from: classes.dex */
    static class a {
        static int a(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }

    private static int a(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName(locale).charAt(0));
        return (directionality == 1 || directionality == 2) ? 1 : 0;
    }

    public static int b(Locale locale) {
        if (Build.VERSION.SDK_INT >= 17) {
            return a.a(locale);
        }
        if (locale == null || locale.equals(f2494a)) {
            return 0;
        }
        String c10 = androidx.core.text.a.c(locale);
        return c10 == null ? a(locale) : (c10.equalsIgnoreCase("Arab") || c10.equalsIgnoreCase("Hebr")) ? 1 : 0;
    }
}
