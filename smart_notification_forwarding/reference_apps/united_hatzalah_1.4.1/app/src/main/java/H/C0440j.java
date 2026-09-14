package h;

import android.view.LayoutInflater;
import com.pichillilorenzo.flutter_inappwebview_android.in_app_browser.InAppBrowserActivity;

/* renamed from: h.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0440j implements d.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InAppBrowserActivity f4832a;

    public C0440j(InAppBrowserActivity inAppBrowserActivity) {
        this.f4832a = inAppBrowserActivity;
    }

    @Override // d.b
    public final void a(c.m mVar) {
        InAppBrowserActivity inAppBrowserActivity = this.f4832a;
        o delegate = inAppBrowserActivity.getDelegate();
        y yVar = (y) delegate;
        LayoutInflater from = LayoutInflater.from(yVar.f4912n);
        if (from.getFactory() == null) {
            from.setFactory2(yVar);
        } else {
            from.getFactory2();
        }
        inAppBrowserActivity.getSavedStateRegistry().a("androidx:appcompat");
        delegate.c();
    }
}
