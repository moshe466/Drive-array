package l;

import android.view.CollapsibleActionView;
import android.view.View;
import android.widget.FrameLayout;
import k.InterfaceC0459c;

/* loaded from: classes.dex */
public final class q extends FrameLayout implements InterfaceC0459c {

    /* renamed from: a, reason: collision with root package name */
    public final CollapsibleActionView f5453a;

    /* JADX WARN: Multi-variable type inference failed */
    public q(View view) {
        super(view.getContext());
        this.f5453a = (CollapsibleActionView) view;
        addView(view);
    }

    @Override // k.InterfaceC0459c
    public final void onActionViewCollapsed() {
        this.f5453a.onActionViewCollapsed();
    }

    @Override // k.InterfaceC0459c
    public final void onActionViewExpanded() {
        this.f5453a.onActionViewExpanded();
    }
}
