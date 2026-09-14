package J;

import android.os.Build;
import androidx.core.widget.NestedScrollView;

/* renamed from: J.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0137z {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0136y f1037a;

    public C0137z(NestedScrollView nestedScrollView) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f1037a = new C0135x(nestedScrollView);
        } else {
            this.f1037a = new A.n(3);
        }
    }
}
