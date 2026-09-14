package l;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: l.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC0507e implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5357a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f5358b;

    public /* synthetic */ ViewOnAttachStateChangeListenerC0507e(u uVar, int i) {
        this.f5357a = i;
        this.f5358b = uVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        int i = this.f5357a;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        switch (this.f5357a) {
            case 0:
                ViewOnKeyListenerC0509g viewOnKeyListenerC0509g = (ViewOnKeyListenerC0509g) this.f5358b;
                ViewTreeObserver viewTreeObserver = viewOnKeyListenerC0509g.f5362A;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        viewOnKeyListenerC0509g.f5362A = view.getViewTreeObserver();
                    }
                    viewOnKeyListenerC0509g.f5362A.removeGlobalOnLayoutListener(viewOnKeyListenerC0509g.f5372l);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
            default:
                ViewOnKeyListenerC0501E viewOnKeyListenerC0501E = (ViewOnKeyListenerC0501E) this.f5358b;
                ViewTreeObserver viewTreeObserver2 = viewOnKeyListenerC0501E.f5331r;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        viewOnKeyListenerC0501E.f5331r = view.getViewTreeObserver();
                    }
                    viewOnKeyListenerC0501E.f5331r.removeGlobalOnLayoutListener(viewOnKeyListenerC0501E.f5326l);
                }
                view.removeOnAttachStateChangeListener(this);
                return;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }
}
