package atlow.chemi.mymada.helpers;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.play.core.splitcompat.SplitCompat;
import java.util.Locale;

/* loaded from: classes.dex */
public class LocalHelper {
    private static String SELECTED_LANGUAGE = "lng";

    public static String getLanguage(Context context) {
        return getPersistedData(context, Locale.getDefault().getLanguage());
    }

    private static String getPersistedData(Context context, String str) {
        return context.getSharedPreferences("Settings", 0).getString(SELECTED_LANGUAGE, str);
    }

    public static Context onAttach(Context context) {
        String persistedData = getPersistedData(context, Locale.getDefault().getLanguage());
        SplitCompat.install(context);
        return setLocale(context, persistedData);
    }

    public static Context onAttach(Context context, String str) {
        String persistedData = getPersistedData(context, str);
        SplitCompat.install(context);
        return setLocale(context, persistedData);
    }

    private static void persist(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("Settings", 0).edit();
        edit.putString(SELECTED_LANGUAGE, str);
        edit.apply();
    }

    public static Context setLocale(Context context, String str) {
        persist(context, str);
        return Build.VERSION.SDK_INT >= 24 ? updateResources(context, str) : updateResourcesLegacy(context, str);
    }

    @TargetApi(24)
    private static Context updateResources(Context context, String str) {
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(Locale.forLanguageTag(str));
        return context.createConfigurationContext(configuration);
    }

    private static Context updateResourcesLegacy(Context context, String str) {
        Locale locale = new Locale(str);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        configuration.setLayoutDirection(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        return context;
    }
}
