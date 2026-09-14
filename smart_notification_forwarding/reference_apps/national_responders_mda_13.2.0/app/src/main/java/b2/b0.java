package b2;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    private static final l.g f3917a = new l.g();

    /* renamed from: b, reason: collision with root package name */
    private static Locale f3918b;

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return i2.c.a(context).d(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(x1.b.f15394g);
    }

    public static String c(Context context, int i10) {
        return context.getResources().getString(i10 != 1 ? i10 != 2 ? i10 != 3 ? R.string.ok : x1.b.f15388a : x1.b.f15397j : x1.b.f15391d);
    }

    public static String d(Context context, int i10) {
        Resources resources = context.getResources();
        String a10 = a(context);
        if (i10 == 1) {
            return resources.getString(x1.b.f15392e, a10);
        }
        if (i10 == 2) {
            return g2.i.d(context) ? resources.getString(x1.b.f15401n) : resources.getString(x1.b.f15398k, a10);
        }
        if (i10 == 3) {
            return resources.getString(x1.b.f15389b, a10);
        }
        if (i10 == 5) {
            return h(context, "common_google_play_services_invalid_account_text", a10);
        }
        if (i10 == 7) {
            return h(context, "common_google_play_services_network_error_text", a10);
        }
        if (i10 == 9) {
            return resources.getString(x1.b.f15396i, a10);
        }
        if (i10 == 20) {
            return h(context, "common_google_play_services_restricted_profile_text", a10);
        }
        switch (i10) {
            case 16:
                return h(context, "common_google_play_services_api_unavailable_text", a10);
            case 17:
                return h(context, "common_google_play_services_sign_in_failed_text", a10);
            case 18:
                return resources.getString(x1.b.f15400m, a10);
            default:
                return resources.getString(z1.e.f16071a, a10);
        }
    }

    public static String e(Context context, int i10) {
        return (i10 == 6 || i10 == 19) ? h(context, "common_google_play_services_resolution_required_text", a(context)) : d(context, i10);
    }

    public static String f(Context context, int i10) {
        String i11 = i10 == 6 ? i(context, "common_google_play_services_resolution_required_title") : g(context, i10);
        return i11 == null ? context.getResources().getString(x1.b.f15395h) : i11;
    }

    public static String g(Context context, int i10) {
        Resources resources = context.getResources();
        switch (i10) {
            case 1:
                return resources.getString(x1.b.f15393f);
            case 2:
                return resources.getString(x1.b.f15399l);
            case 3:
                return resources.getString(x1.b.f15390c);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                return i(context, "common_google_play_services_invalid_account_title");
            case 7:
                return i(context, "common_google_play_services_network_error_title");
            case 8:
            case 9:
            case 10:
            case 11:
            case 16:
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected error code ");
                sb2.append(i10);
                return null;
            case 17:
                return i(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                return i(context, "common_google_play_services_restricted_profile_title");
        }
    }

    private static String h(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String i10 = i(context, str);
        if (i10 == null) {
            i10 = resources.getString(z1.e.f16071a);
        }
        return String.format(resources.getConfiguration().locale, i10, str2);
    }

    private static String i(Context context, String str) {
        l.g gVar = f3917a;
        synchronized (gVar) {
            Locale c10 = androidx.core.os.f.a(context.getResources().getConfiguration()).c(0);
            if (!c10.equals(f3918b)) {
                gVar.clear();
                f3918b = c10;
            }
            String str2 = (String) gVar.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources e10 = com.google.android.gms.common.d.e(context);
            if (e10 == null) {
                return null;
            }
            int identifier = e10.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Missing resource: ");
                sb2.append(str);
                return null;
            }
            String string = e10.getString(identifier);
            if (!TextUtils.isEmpty(string)) {
                gVar.put(str, string);
                return string;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Got empty resource: ");
            sb3.append(str);
            return null;
        }
    }
}
