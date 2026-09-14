package h;

import F0.C0021d0;
import J.S;
import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class L extends m3.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4748d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ N f4749e;

    public /* synthetic */ L(N n4, int i) {
        this.f4748d = i;
        this.f4749e = n4;
    }

    @Override // J.Y
    public final void c() {
        View view;
        int i = this.f4748d;
        N n4 = this.f4749e;
        switch (i) {
            case 0:
                if (n4.f4770o && (view = n4.f4763g) != null) {
                    view.setTranslationY(0.0f);
                    n4.f4760d.setTranslationY(0.0f);
                }
                n4.f4760d.setVisibility(8);
                n4.f4760d.setTransitioning(false);
                n4.f4774t = null;
                C0021d0 c0021d0 = n4.f4766k;
                if (c0021d0 != null) {
                    c0021d0.e(n4.f4765j);
                    n4.f4765j = null;
                    n4.f4766k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = n4.f4759c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = S.f954a;
                    J.H.c(actionBarOverlayLayout);
                    return;
                }
                return;
            default:
                n4.f4774t = null;
                n4.f4760d.requestLayout();
                return;
        }
    }
}
