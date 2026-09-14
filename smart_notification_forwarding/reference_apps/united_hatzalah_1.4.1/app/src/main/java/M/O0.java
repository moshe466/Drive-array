package m;

import F0.C0035g2;
import android.content.Context;
import android.os.Build;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class O0 extends I0 implements J0 {

    /* renamed from: F, reason: collision with root package name */
    public static final Method f5573F;

    /* renamed from: E, reason: collision with root package name */
    public C0035g2 f5574E;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f5573F = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    @Override // m.J0
    public final void e(l.m mVar, MenuItem menuItem) {
        C0035g2 c0035g2 = this.f5574E;
        if (c0035g2 != null) {
            c0035g2.e(mVar, menuItem);
        }
    }

    @Override // m.J0
    public final void m(l.m mVar, l.o oVar) {
        C0035g2 c0035g2 = this.f5574E;
        if (c0035g2 != null) {
            c0035g2.m(mVar, oVar);
        }
    }

    @Override // m.I0
    public final C0576w0 p(Context context, boolean z3) {
        N0 n02 = new N0(context, z3);
        n02.setHoverListener(this);
        return n02;
    }
}
