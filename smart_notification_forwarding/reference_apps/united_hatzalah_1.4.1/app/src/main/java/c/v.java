package c;

import t2.C0704f;

/* loaded from: classes.dex */
public final class v implements InterfaceC0326b {

    /* renamed from: a, reason: collision with root package name */
    public final p f3853a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f3854b;

    public v(x xVar, p onBackPressedCallback) {
        kotlin.jvm.internal.j.e(onBackPressedCallback, "onBackPressedCallback");
        this.f3854b = xVar;
        this.f3853a = onBackPressedCallback;
    }

    @Override // c.InterfaceC0326b
    public final void cancel() {
        x xVar = this.f3854b;
        C0704f c0704f = xVar.f3857b;
        p pVar = this.f3853a;
        c0704f.remove(pVar);
        if (kotlin.jvm.internal.j.a(xVar.f3858c, pVar)) {
            pVar.handleOnBackCancelled();
            xVar.f3858c = null;
        }
        pVar.removeCancellable(this);
        F2.a enabledChangedCallback$activity_release = pVar.getEnabledChangedCallback$activity_release();
        if (enabledChangedCallback$activity_release != null) {
            enabledChangedCallback$activity_release.invoke();
        }
        pVar.setEnabledChangedCallback$activity_release(null);
    }
}
