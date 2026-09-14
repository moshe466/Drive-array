package atlow.chemi.mymada.helpers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.play.core.splitcompat.SplitCompat;
import java.util.Locale;

public class LocalHelper {
    private static final String SELECTED_LANGUAGE = "lng";

    public static String getLanguage(Context context) {
        if (context == null) return "iw";
        String lang = getPersistedData(context, "iw");
        if ("he".equalsIgnoreCase(lang)) {
            lang = "iw";
        }
        return lang;
    }

    public static boolean isRTL(Context context) {
        String lang = getLanguage(context);
        return "iw".equalsIgnoreCase(lang) || "he".equalsIgnoreCase(lang) || "ar".equalsIgnoreCase(lang);
    }

    private static String getPersistedData(Context context, String defaultLanguage) {
        if (context == null) return defaultLanguage;
        SharedPreferences sp = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);
        return sp.getString(SELECTED_LANGUAGE, defaultLanguage);
    }

    public static Context onAttach(Context context) {
        String lang = getPersistedData(context, "iw");
        try {
            SplitCompat.install(context);
        } catch (Throwable ignored) {
        }
        return setLocale(context, lang);
    }

    public static Context onAttach(Context context, String defaultLanguage) {
        String lang = getPersistedData(context, defaultLanguage);
        try {
            SplitCompat.install(context);
        } catch (Throwable ignored) {
        }
        return setLocale(context, lang);
    }

    public static void persist(Context context, String language) {
        if (context == null) return;
        SharedPreferences.Editor edit = context.getSharedPreferences("Settings", Context.MODE_PRIVATE).edit();
        edit.putString(SELECTED_LANGUAGE, language);
        edit.apply();
    }

    public static Context setLocale(Context context, String language) {
        if ("he".equalsIgnoreCase(language)) {
            language = "iw";
        }
        persist(context, language);

        if (Build.VERSION.SDK_INT >= 24) {
            return updateResources(context, language);
        }
        return updateResourcesLegacy(context, language);
    }

    public static void applyLocale(Activity activity) {
        if (activity == null) return;
        String lang = getLanguage(activity);
        setLocale(activity, lang);
        
        boolean rtl = isRTL(activity);
        int layoutDirection = rtl ? View.LAYOUT_DIRECTION_RTL : View.LAYOUT_DIRECTION_LTR;
        
        try {
            if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
                activity.getWindow().getDecorView().setLayoutDirection(layoutDirection);
            }
        } catch (Exception ignored) {
        }
    }

    @TargetApi(24)
    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources res = context.getResources();
        Configuration configuration = new Configuration(res.getConfiguration());
        configuration.setLocale(locale);
        
        LocaleList localeList = new LocaleList(locale);
        LocaleList.setDefault(localeList);
        configuration.setLocales(localeList);
        configuration.setLayoutDirection(locale);

        DisplayMetrics dm = res.getDisplayMetrics();
        res.updateConfiguration(configuration, dm);

        // Also update Application Context resources if possible
        try {
            Context appCtx = context.getApplicationContext();
            if (appCtx != null && appCtx != context) {
                Resources appRes = appCtx.getResources();
                Configuration appConfig = new Configuration(appRes.getConfiguration());
                appConfig.setLocale(locale);
                appConfig.setLocales(localeList);
                appConfig.setLayoutDirection(locale);
                appRes.updateConfiguration(appConfig, appRes.getDisplayMetrics());
            }
        } catch (Exception ignored) {
        }

        return context.createConfigurationContext(configuration);
    }

    @SuppressWarnings("deprecation")
    private static Context updateResourcesLegacy(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        if (Build.VERSION.SDK_INT >= 17) {
            configuration.setLayoutDirection(locale);
        }
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}
