package J;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class r0 extends q0 {
    @Override // p3.h
    public final void B(boolean z3) {
        Window window = this.f1028c;
        if (z3) {
            window.clearFlags(134217728);
            window.addFlags(Integer.MIN_VALUE);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            return;
        }
        View decorView2 = window.getDecorView();
        decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
    }
}
