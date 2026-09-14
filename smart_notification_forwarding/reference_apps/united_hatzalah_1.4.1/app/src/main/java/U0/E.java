package u0;

import android.net.Uri;

/* loaded from: classes.dex */
public final class E extends C0724b {
    @Override // u0.AbstractC0725c
    public final boolean b() {
        if (super.b() && t0.d.a("MULTI_PROCESS")) {
            Uri uri = t0.y.f6390a;
            if (F.f6515F.b()) {
                return H.f6549a.getStatics().isMultiProcessEnabled();
            }
            throw F.a();
        }
        return false;
    }
}
