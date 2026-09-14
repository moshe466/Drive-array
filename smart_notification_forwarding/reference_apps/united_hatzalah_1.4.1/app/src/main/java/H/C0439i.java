package h;

import android.os.Bundle;
import com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserActivity;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import l0.C0514d;
import l0.InterfaceC0513c;

/* renamed from: h.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0439i implements InterfaceC0513c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4830a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4831b;

    public C0439i(C0514d c0514d) {
        this.f4830a = 1;
        this.f4831b = new LinkedHashSet();
        c0514d.c("androidx.savedstate.Restarter", this);
    }

    @Override // l0.InterfaceC0513c
    public final Bundle a() {
        switch (this.f4830a) {
            case 0:
                Bundle bundle = new Bundle();
                ((InAppBrowserActivity) this.f4831b).getDelegate().getClass();
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.f4831b));
                return bundle2;
        }
    }

    public C0439i(InAppBrowserActivity inAppBrowserActivity) {
        this.f4830a = 0;
        this.f4831b = inAppBrowserActivity;
    }
}
