package t6;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public class e {

    /* loaded from: classes.dex */
    public static class a {
        public static int a(Context context) {
            return 3;
        }

        public static int b(Context context, int i10) {
            return i10 <= 0 ? context.getResources().getInteger(R.integer.pkey_display_max_retries_default) : i10;
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static char[] a(Context context) {
            try {
                String string = e.b(context).getString(context.getString(R.string.pkey_sys_encrypter_class), null);
                if (string == null) {
                    return null;
                }
                return string.toCharArray();
            } catch (Exception unused) {
                return null;
            }
        }

        public static char[] b(Context context) {
            try {
                String string = e.b(context).getString(context.getString(R.string.pkey_sys_pattern), null);
                if (string == null) {
                    return null;
                }
                return string.toCharArray();
            } catch (Exception unused) {
                return null;
            }
        }

        public static boolean c(Context context) {
            return e.b(context).getBoolean(context.getString(R.string.pkey_sys_auto_save_pattern), context.getResources().getBoolean(R.bool.pkey_sys_auto_save_pattern_default));
        }

        public static void d(Context context, boolean z10) {
            e.b(context).edit().putBoolean(context.getString(R.string.pkey_sys_auto_save_pattern), z10).commit();
            if (z10) {
                return;
            }
            e(context, null);
        }

        public static void e(Context context, char[] cArr) {
            e.b(context).edit().putString(context.getString(R.string.pkey_sys_pattern), cArr != null ? new String(cArr) : null).commit();
        }
    }

    public static final String a() {
        return String.format("%s_%s", "android-lockpattern", "a6eedbe5-1cf9-4684-8134-ad4ec9f6a131");
    }

    @TargetApi(11)
    public static SharedPreferences b(Context context) {
        return context.getApplicationContext().getSharedPreferences(a(), 4);
    }
}
