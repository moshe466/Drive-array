package h;

import android.content.res.Configuration;
import android.os.LocaleList;

/* loaded from: classes.dex */
public abstract class s {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (!locales.equals(locales2)) {
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    public static F.f b(Configuration configuration) {
        return F.f.a(configuration.getLocales().toLanguageTags());
    }

    public static void c(F.f fVar) {
        LocaleList.setDefault(LocaleList.forLanguageTags(fVar.f162a.f163a.toLanguageTags()));
    }

    public static void d(Configuration configuration, F.f fVar) {
        configuration.setLocales(LocaleList.forLanguageTags(fVar.f162a.f163a.toLanguageTags()));
    }
}
