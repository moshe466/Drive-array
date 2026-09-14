package J;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* loaded from: classes.dex */
public class s0 extends p3.h {

    /* renamed from: c, reason: collision with root package name */
    public final WindowInsetsController f1029c;

    /* renamed from: d, reason: collision with root package name */
    public final Window f1030d;

    public s0(Window window) {
        WindowInsetsController insetsController;
        insetsController = window.getInsetsController();
        this.f1029c = insetsController;
        this.f1030d = window;
    }

    @Override // p3.h
    public final void B(boolean z3) {
        Window window = this.f1030d;
        if (z3) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            }
            this.f1029c.setSystemBarsAppearance(16, 16);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-17));
        }
        this.f1029c.setSystemBarsAppearance(0, 16);
    }

    @Override // p3.h
    public final void C(boolean z3) {
        Window window = this.f1030d;
        if (z3) {
            if (window != null) {
                View decorView = window.getDecorView();
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | UserMetadata.MAX_INTERNAL_KEY_SIZE);
            }
            this.f1029c.setSystemBarsAppearance(8, 8);
            return;
        }
        if (window != null) {
            View decorView2 = window.getDecorView();
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
        }
        this.f1029c.setSystemBarsAppearance(0, 8);
    }
}
