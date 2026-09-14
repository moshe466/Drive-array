package F;

import android.os.Build;
import java.util.Locale;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153a = 0;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            B.c.b(30);
        }
        if (i >= 30) {
            B.c.b(31);
        }
        if (i >= 30) {
            B.c.b(33);
        }
        if (i >= 30) {
            B.c.b(1000000);
        }
    }

    public static final boolean a(String str) {
        Integer num;
        String buildCodename = Build.VERSION.CODENAME;
        Integer num2 = 0;
        j.e(buildCodename, "buildCodename");
        if (!"REL".equals(buildCodename)) {
            Locale locale = Locale.ROOT;
            String upperCase = buildCodename.toUpperCase(locale);
            j.d(upperCase, "toUpperCase(...)");
            if (upperCase.equals("BAKLAVA")) {
                num = num2;
            } else {
                num = null;
            }
            String upperCase2 = str.toUpperCase(locale);
            j.d(upperCase2, "toUpperCase(...)");
            if (!upperCase2.equals("BAKLAVA")) {
                num2 = null;
            }
            if (num != null && num2 != null) {
                if (num.intValue() >= num2.intValue()) {
                    return true;
                }
            } else if (num == null && num2 == null) {
                String upperCase3 = buildCodename.toUpperCase(locale);
                j.d(upperCase3, "toUpperCase(...)");
                String upperCase4 = str.toUpperCase(locale);
                j.d(upperCase4, "toUpperCase(...)");
                if (upperCase3.compareTo(upperCase4) >= 0) {
                    return true;
                }
            } else if (num != null) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b() {
        int i = Build.VERSION.SDK_INT;
        if (i < 33) {
            if (i >= 32) {
                String CODENAME = Build.VERSION.CODENAME;
                j.d(CODENAME, "CODENAME");
                if (!a("Tiramisu")) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }
}
