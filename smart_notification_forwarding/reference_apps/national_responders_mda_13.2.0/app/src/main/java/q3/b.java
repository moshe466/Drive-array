package q3;

import android.os.Bundle;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import v2.i;
import v2.k;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Set<String> f13559a = new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));

    /* renamed from: b, reason: collision with root package name */
    private static final List<String> f13560b = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f13561c = Arrays.asList("auto", "app", "am");

    /* renamed from: d, reason: collision with root package name */
    private static final List<String> f13562d = Arrays.asList("_r", "_dbg");

    /* renamed from: e, reason: collision with root package name */
    private static final List<String> f13563e = Arrays.asList((String[]) g2.b.a(k.f14631a, k.f14632b));

    /* renamed from: f, reason: collision with root package name */
    private static final List<String> f13564f = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static boolean a(String str) {
        return !f13561c.contains(str);
    }

    public static boolean b(String str, Bundle bundle) {
        if (f13560b.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        Iterator<String> it = f13562d.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (f13563e.contains(str2)) {
            return false;
        }
        Iterator<String> it = f13564f.iterator();
        while (it.hasNext()) {
            if (str2.matches(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(String str, String str2, Bundle bundle) {
        String str3;
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!a(str) || bundle == null) {
            return false;
        }
        Iterator<String> it = f13562d.iterator();
        while (it.hasNext()) {
            if (bundle.containsKey(it.next())) {
                return false;
            }
        }
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case 101200:
                if (str.equals("fcm")) {
                    c10 = 0;
                    break;
                }
                break;
            case 101230:
                if (str.equals("fdl")) {
                    c10 = 1;
                    break;
                }
                break;
            case 3142703:
                if (str.equals("fiam")) {
                    c10 = 2;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                str3 = "fcm_integration";
                break;
            case 1:
                str3 = "fdl_integration";
                break;
            case 2:
                str3 = "fiam_integration";
                break;
            default:
                return false;
        }
        bundle.putString("_cis", str3);
        return true;
    }

    public static void e(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    public static boolean f(String str) {
        return !f13559a.contains(str);
    }

    public static String g(String str) {
        String a10 = i.a(str);
        return a10 != null ? a10 : str;
    }
}
