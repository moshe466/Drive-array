package s0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes.dex */
class v implements w {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f13994a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(ViewGroup viewGroup) {
        this.f13994a = viewGroup.getOverlay();
    }

    @Override // s0.w
    public void a(View view) {
        this.f13994a.add(view);
    }

    @Override // s0.c0
    public void b(Drawable drawable) {
        this.f13994a.add(drawable);
    }

    @Override // s0.w
    public void c(View view) {
        this.f13994a.remove(view);
    }

    @Override // s0.c0
    public void d(Drawable drawable) {
        this.f13994a.remove(drawable);
    }
}
