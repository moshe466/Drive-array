package atlow.chemi.mymada.helpers;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import com.google.android.play.core.splitcompat.SplitCompat;
import java.util.Locale;

public class LocalHelper {
    private static final String SELECTED_LANGUAGE = "lng";

    public static String getLanguage(Context context) {
        String lang = getPersistedData(context, "iw");
        if ("he".equalsIgnoreCase(lang)) {
            lang = "iw";
        }
        return lang;
    }

    private static String getPersistedData(Context context, String defaultLanguage) {
        return context.getSharedPreferences("Settings", 0).getString(SELECTED_LANGUAGE, defaultLanguage);
    }

    public static Context onAttach(Context context) {
        String persistedData = getPersistedData(context, "iw");
        try {
            SplitCompat.install(context);
        } catch (Throwable ignored) {
        }
        return setLocale(context, persistedData);
    }

    public static Context onAttach(Context context, String defaultLanguage) {
        String persistedData = getPersistedData(context, defaultLanguage);
        try {
            SplitCompat.install(context);
        } catch (Throwable ignored) {
        }
        return setLocale(context, persistedData);
    }

    private static void persist(Context context, String language) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Settings", 0).edit();
        edit.putString(SELECTED_LANGUAGE, language);
        edit.apply();
    }

    public static Context setLocale(Context context, String language) {
        persist(context, language);
        if (Build.VERSION.SDK_INT >= 24) {
            return updateResources(context, language);
        }
        return updateResourcesLegacy(context, language);
    }

    @TargetApi(24)
    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);
        LocaleList localeList = new LocaleList(locale);
        LocaleList.setDefault(localeList);
        configuration.setLocales(localeList);
        
        Resources resources = context.getResources();
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context.createConfigurationContext(configuration);
    }

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
