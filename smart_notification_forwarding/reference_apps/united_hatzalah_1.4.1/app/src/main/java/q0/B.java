package q0;

import android.view.View;
import android.view.ViewGroup;
import com.uh.sf.R;

/* loaded from: classes.dex */
public final class B extends r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f6052a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f6053b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f6054c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ h f6055d;

    public B(h hVar, ViewGroup viewGroup, View view, View view2) {
        this.f6055d = hVar;
        this.f6052a = viewGroup;
        this.f6053b = view;
        this.f6054c = view2;
    }

    @Override // q0.r, q0.p
    public final void b() {
        this.f6052a.getOverlay().remove(this.f6053b);
    }

    @Override // q0.r, q0.p
    public final void d() {
        View view = this.f6053b;
        if (view.getParent() == null) {
            this.f6052a.getOverlay().add(view);
        } else {
            this.f6055d.d();
        }
    }

    @Override // q0.p
    public final void e(q qVar) {
        this.f6054c.setTag(R.id.save_overlay_view, null);
        this.f6052a.getOverlay().remove(this.f6053b);
        qVar.w(this);
    }
}
