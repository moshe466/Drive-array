package l;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import m.AbstractViewOnTouchListenerC0582z0;
import m.C0540e;
import m.C0542f;
import m.C0546h;
import m.C0548i;

/* renamed from: l.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0504b extends AbstractViewOnTouchListenerC0582z0 {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f5353m = 0;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ View f5354n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0504b(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f5354n = actionMenuItemView;
    }

    @Override // m.AbstractViewOnTouchListenerC0582z0
    public final InterfaceC0500D b() {
        C0540e c0540e;
        switch (this.f5353m) {
            case 0:
                AbstractC0505c abstractC0505c = ((ActionMenuItemView) this.f5354n).p;
                if (abstractC0505c != null && (c0540e = ((C0542f) abstractC0505c).f5648a.f5686w) != null) {
                    return c0540e.a();
                }
                return null;
            default:
                C0540e c0540e2 = ((C0546h) this.f5354n).f5667d.f5685v;
                if (c0540e2 == null) {
                    return null;
                }
                return c0540e2.a();
        }
    }

    @Override // m.AbstractViewOnTouchListenerC0582z0
    public final boolean c() {
        InterfaceC0500D b4;
        switch (this.f5353m) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.f5354n;
                l lVar = actionMenuItemView.f2774n;
                if (lVar != null && lVar.a(actionMenuItemView.f2771k) && (b4 = b()) != null && b4.a()) {
                    return true;
                }
                return false;
            default:
                ((C0546h) this.f5354n).f5667d.l();
                return true;
        }
    }

    @Override // m.AbstractViewOnTouchListenerC0582z0
    public boolean d() {
        switch (this.f5353m) {
            case 1:
                C0548i c0548i = ((C0546h) this.f5354n).f5667d;
                if (c0548i.f5687x != null) {
                    return false;
                }
                c0548i.g();
                return true;
            default:
                return super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0504b(C0546h c0546h, C0546h c0546h2) {
        super(c0546h2);
        this.f5354n = c0546h;
    }
}
