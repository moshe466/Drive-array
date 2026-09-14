package l;

import F0.C0047j2;
import android.view.ActionProvider;
import android.view.View;

/* loaded from: classes.dex */
public final class p implements ActionProvider.VisibilityListener {

    /* renamed from: a, reason: collision with root package name */
    public final ActionProvider f5451a;

    /* renamed from: b, reason: collision with root package name */
    public C0047j2 f5452b;

    public p(t tVar, ActionProvider actionProvider) {
        this.f5451a = actionProvider;
    }

    public final View a(o oVar) {
        return this.f5451a.onCreateActionView(oVar);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public final void onActionProviderVisibilityChanged(boolean z3) {
        C0047j2 c0047j2 = this.f5452b;
        if (c0047j2 != null) {
            m mVar = ((o) c0047j2.f546b).f5440n;
            mVar.f5407h = true;
            mVar.p(true);
        }
    }
}
