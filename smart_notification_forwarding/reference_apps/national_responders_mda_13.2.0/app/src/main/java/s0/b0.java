package s0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes.dex */
class b0 implements c0 {

    /* renamed from: a, reason: collision with root package name */
    private final ViewOverlay f13869a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(View view) {
        this.f13869a = view.getOverlay();
    }

    @Override // s0.c0
    public void b(Drawable drawable) {
        this.f13869a.add(drawable);
    }

    @Override // s0.c0
    public void d(Drawable drawable) {
        this.f13869a.remove(drawable);
    }
}
