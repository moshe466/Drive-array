package J;

import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class X {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f964a;

    public X(View view) {
        this.f964a = new WeakReference(view);
    }

    public final void a(float f4) {
        View view = (View) this.f964a.get();
        if (view != null) {
            view.animate().alpha(f4);
        }
    }

    public final void b() {
        View view = (View) this.f964a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j2) {
        View view = (View) this.f964a.get();
        if (view != null) {
            view.animate().setDuration(j2);
        }
    }

    public final void d(Y y) {
        View view = (View) this.f964a.get();
        if (view != null) {
            if (y != null) {
                view.animate().setListener(new W(y, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f4) {
        View view = (View) this.f964a.get();
        if (view != null) {
            view.animate().translationY(f4);
        }
    }
}
