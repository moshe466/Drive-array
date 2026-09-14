package m;

import android.view.View;

/* renamed from: m.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0544g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final C0540e f5664a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0548i f5665b;

    public RunnableC0544g(C0548i c0548i, C0540e c0540e) {
        this.f5665b = c0548i;
        this.f5664a = c0540e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l.k kVar;
        C0548i c0548i = this.f5665b;
        l.m mVar = c0548i.f5670c;
        if (mVar != null && (kVar = mVar.f5404e) != null) {
            kVar.f(mVar);
        }
        View view = (View) c0548i.f5675k;
        if (view != null && view.getWindowToken() != null) {
            C0540e c0540e = this.f5664a;
            if (!c0540e.b()) {
                if (c0540e.f5466e != null) {
                    c0540e.d(0, 0, false, false);
                }
            }
            c0548i.f5685v = c0540e;
        }
        c0548i.f5687x = null;
    }
}
