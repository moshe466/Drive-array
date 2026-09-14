package F;

import android.os.LocaleList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    public static final f f161b = new f(new g(new LocaleList(new Locale[0])));

    /* renamed from: a, reason: collision with root package name */
    public final g f162a;

    public f(g gVar) {
        this.f162a = gVar;
    }

    public static f a(String str) {
        if (str != null && !str.isEmpty()) {
            String[] split = str.split(",", -1);
            int length = split.length;
            Locale[] localeArr = new Locale[length];
            for (int i = 0; i < length; i++) {
                String str2 = split[i];
                int i3 = e.f160a;
                localeArr[i] = Locale.forLanguageTag(str2);
            }
            return new f(new g(new LocaleList(localeArr)));
        }
        return f161b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            if (this.f162a.equals(((f) obj).f162a)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.f162a.f163a.hashCode();
    }

    public final String toString() {
        return this.f162a.f163a.toString();
    }
}
