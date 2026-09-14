package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class T implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o0 f3324a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ U f3325b;

    public T(U u3, o0 o0Var) {
        this.f3325b = u3;
        this.f3324a = o0Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        o0 o0Var = this.f3324a;
        G g3 = o0Var.f3473c;
        o0Var.i();
        C0281p.j((ViewGroup) g3.mView.getParent(), this.f3325b.f3326a).i();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
