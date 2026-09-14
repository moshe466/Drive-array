package J;

import android.view.View;
import android.view.ViewTreeObserver;

/* renamed from: J.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewTreeObserverOnPreDrawListenerC0134w implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f1033a;

    /* renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f1034b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f1035c;

    public ViewTreeObserverOnPreDrawListenerC0134w(View view, Runnable runnable) {
        this.f1033a = view;
        this.f1034b = view.getViewTreeObserver();
        this.f1035c = runnable;
    }

    public static void a(View view, Runnable runnable) {
        if (view != null) {
            ViewTreeObserverOnPreDrawListenerC0134w viewTreeObserverOnPreDrawListenerC0134w = new ViewTreeObserverOnPreDrawListenerC0134w(view, runnable);
            view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0134w);
            view.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC0134w);
            return;
        }
        throw new NullPointerException("view == null");
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        boolean isAlive = this.f1034b.isAlive();
        View view = this.f1033a;
        if (isAlive) {
            this.f1034b.removeOnPreDrawListener(this);
        } else {
            view.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view.removeOnAttachStateChangeListener(this);
        this.f1035c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f1034b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean isAlive = this.f1034b.isAlive();
        View view2 = this.f1033a;
        if (isAlive) {
            this.f1034b.removeOnPreDrawListener(this);
        } else {
            view2.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        view2.removeOnAttachStateChangeListener(this);
    }
}
