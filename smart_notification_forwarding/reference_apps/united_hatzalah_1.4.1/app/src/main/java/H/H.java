package h;

import androidx.appcompat.widget.ActionMenuView;
import m.C0540e;
import m.C0548i;

/* loaded from: classes.dex */
public final class H implements l.y {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4732a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ I f4733b;

    public H(I i) {
        this.f4733b = i;
    }

    @Override // l.y
    public final void b(l.m mVar, boolean z3) {
        C0548i c0548i;
        if (this.f4732a) {
            return;
        }
        this.f4732a = true;
        I i = this.f4733b;
        ActionMenuView actionMenuView = i.f4734a.f5772a.f2986a;
        if (actionMenuView != null && (c0548i = actionMenuView.f2861w) != null) {
            c0548i.g();
            C0540e c0540e = c0548i.f5686w;
            if (c0540e != null && c0540e.b()) {
                c0540e.i.dismiss();
            }
        }
        i.f4735b.onPanelClosed(108, mVar);
        this.f4732a = false;
    }

    @Override // l.y
    public final boolean d(l.m mVar) {
        this.f4733b.f4735b.onMenuOpened(108, mVar);
        return true;
    }
}
