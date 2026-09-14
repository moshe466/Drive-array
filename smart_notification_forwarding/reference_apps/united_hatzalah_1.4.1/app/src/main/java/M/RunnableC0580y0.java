package m;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

/* renamed from: m.y0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0580y0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5842a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractViewOnTouchListenerC0582z0 f5843b;

    public /* synthetic */ RunnableC0580y0(AbstractViewOnTouchListenerC0582z0 abstractViewOnTouchListenerC0582z0, int i) {
        this.f5842a = i;
        this.f5843b = abstractViewOnTouchListenerC0582z0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5842a) {
            case 0:
                ViewParent parent = this.f5843b.f5847d.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    return;
                }
                return;
            default:
                AbstractViewOnTouchListenerC0582z0 abstractViewOnTouchListenerC0582z0 = this.f5843b;
                abstractViewOnTouchListenerC0582z0.a();
                View view = abstractViewOnTouchListenerC0582z0.f5847d;
                if (view.isEnabled() && !view.isLongClickable() && abstractViewOnTouchListenerC0582z0.c()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    abstractViewOnTouchListenerC0582z0.f5850j = true;
                    return;
                }
                return;
        }
    }
}
