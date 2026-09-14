package t0;

import android.webkit.WebSettings;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import u0.AbstractC0730h;
import u0.AbstractC0734l;
import u0.C0724b;
import u0.F;
import u0.G;
import u0.J;

/* loaded from: classes.dex */
public abstract class r {
    public static J a(WebSettings webSettings) {
        return new J((WebSettingsBoundaryInterface) m3.b.d(WebSettingsBoundaryInterface.class, ((WebkitToCompatConverterBoundaryInterface) G.f6548a.f6552b).convertSettings(webSettings)), 4);
    }

    public static void b(WebSettings webSettings, int i) {
        C0724b c0724b = F.f6516G;
        if (c0724b.a()) {
            AbstractC0734l.d(webSettings, i);
        } else {
            if (c0724b.b()) {
                ((WebSettingsBoundaryInterface) a(webSettings).f6552b).setForceDark(i);
                return;
            }
            throw F.a();
        }
    }

    public static void c(WebSettings webSettings, boolean z3) {
        C0724b c0724b = F.f6526b;
        if (c0724b.a()) {
            AbstractC0730h.e(webSettings, z3);
        } else {
            if (c0724b.b()) {
                ((WebSettingsBoundaryInterface) a(webSettings).f6552b).setSafeBrowsingEnabled(z3);
                return;
            }
            throw F.a();
        }
    }
}
