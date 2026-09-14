package w6;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import java.util.Locale;

/* loaded from: classes.dex */
public class n {
    public static String a(Context context) {
        return b(context, Locale.getDefault().getLanguage());
    }

    private static String b(Context context, String str) {
        return m.u().getCode();
    }

    public static Context c(Context context) {
        return f(context, b(context, Locale.getDefault().getLanguage()));
    }

    public static Context d(Context context, String str) {
        return f(context, b(context, str));
    }

    private static void e(Context context, String str) {
        m.l0(com.groboot.mdaemergency.enums.e.getByCode(str));
    }

    public static Context f(Context context, String str) {
        e(context, str);
        return Build.VERSION.SDK_INT >= 24 ? g(context, str) : h(context, str);
    }

    @TargetApi(24)
    private static Context g(Context context, String str) {
        if (context == null) {
            context = l0.v();
        }
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
        return context.createConfigurationContext(configuration);
    }

    private static Context h(Context context, String str) {
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Resources resources = (context != null ? context : l0.v()).getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLayoutDirection(locale);
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}
