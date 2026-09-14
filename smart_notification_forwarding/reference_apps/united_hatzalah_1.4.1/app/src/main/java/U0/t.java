package u0;

import android.webkit.SafeBrowsingResponse;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* loaded from: classes.dex */
public final class t extends t0.f {

    /* renamed from: a, reason: collision with root package name */
    public SafeBrowsingResponse f6570a;

    /* renamed from: b, reason: collision with root package name */
    public SafeBrowsingResponseBoundaryInterface f6571b;

    @Override // t0.f
    public final void a(boolean z3) {
        C0724b c0724b = F.f6540r;
        if (c0724b.a()) {
            AbstractC0731i.e(c(), z3);
        } else {
            if (c0724b.b()) {
                b().showInterstitial(z3);
                return;
            }
            throw F.a();
        }
    }

    public final SafeBrowsingResponseBoundaryInterface b() {
        if (this.f6571b == null) {
            J j2 = G.f6548a;
            this.f6571b = (SafeBrowsingResponseBoundaryInterface) m3.b.d(SafeBrowsingResponseBoundaryInterface.class, ((WebkitToCompatConverterBoundaryInterface) j2.f6552b).convertSafeBrowsingResponse(this.f6570a));
        }
        return this.f6571b;
    }

    public final SafeBrowsingResponse c() {
        if (this.f6570a == null) {
            J j2 = G.f6548a;
            this.f6570a = com.google.android.gms.dynamite.a.b(((WebkitToCompatConverterBoundaryInterface) j2.f6552b).convertSafeBrowsingResponse(Proxy.getInvocationHandler(this.f6571b)));
        }
        return this.f6570a;
    }
}
