package u0;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class D extends AbstractC0725c {

    /* renamed from: d, reason: collision with root package name */
    public final Pattern f6509d;

    public D() {
        super("ALGORITHMIC_DARKENING", "ALGORITHMIC_DARKENING");
        this.f6509d = Pattern.compile("\\A\\d+");
    }

    @Override // u0.AbstractC0725c
    public final boolean a() {
        if (Build.VERSION.SDK_INT >= 33) {
            return true;
        }
        return false;
    }

    @Override // u0.AbstractC0725c
    public final boolean b() {
        int i;
        PackageInfo packageInfo;
        boolean b4 = super.b();
        if (b4 && (i = Build.VERSION.SDK_INT) < 29) {
            Uri uri = t0.y.f6390a;
            if (i >= 26) {
                packageInfo = AbstractC0730h.a();
            } else {
                try {
                    packageInfo = t0.y.c();
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    packageInfo = null;
                }
            }
            if (packageInfo != null) {
                Matcher matcher = this.f6509d.matcher(packageInfo.versionName);
                if (matcher.find() && Integer.parseInt(packageInfo.versionName.substring(matcher.start(), matcher.end())) >= 105) {
                    return true;
                }
            }
            return false;
        }
        return b4;
    }
}
