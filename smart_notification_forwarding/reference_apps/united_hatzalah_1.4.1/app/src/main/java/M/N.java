package m;

import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import l.ViewTreeObserverOnGlobalLayoutListenerC0506d;

/* loaded from: classes.dex */
public final class N implements PopupWindow.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC0506d f5563a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ O f5564b;

    public N(O o2, ViewTreeObserverOnGlobalLayoutListenerC0506d viewTreeObserverOnGlobalLayoutListenerC0506d) {
        this.f5564b = o2;
        this.f5563a = viewTreeObserverOnGlobalLayoutListenerC0506d;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        ViewTreeObserver viewTreeObserver = this.f5564b.f5572I.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f5563a);
        }
    }
}
