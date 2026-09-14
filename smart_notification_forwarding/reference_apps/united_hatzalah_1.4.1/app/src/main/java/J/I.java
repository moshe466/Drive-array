package J;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public final class I implements View.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public p0 f947a = null;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f948b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0132u f949c;

    public I(View view, InterfaceC0132u interfaceC0132u) {
        this.f948b = view;
        this.f949c = interfaceC0132u;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        p0 c4 = p0.c(windowInsets, view);
        int i = Build.VERSION.SDK_INT;
        InterfaceC0132u interfaceC0132u = this.f949c;
        if (i < 30) {
            J.a(windowInsets, this.f948b);
            if (c4.equals(this.f947a)) {
                return ((h.q) interfaceC0132u).a(view, c4).b();
            }
        }
        this.f947a = c4;
        p0 a2 = ((h.q) interfaceC0132u).a(view, c4);
        if (i >= 30) {
            return a2.b();
        }
        H.c(view);
        return a2.b();
    }
}
