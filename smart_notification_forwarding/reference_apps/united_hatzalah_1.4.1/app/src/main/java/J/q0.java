package J;

import android.view.View;
import android.view.Window;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;

/* loaded from: classes.dex */
public class q0 extends p3.h {

    /* renamed from: c, reason: collision with root package name */
    public final Window f1028c;

    public q0(Window window) {
        this.f1028c = window;
    }

    @Override // p3.h
    public final void C(boolean z3) {
        Window window = this.f1028c;
        if (z3) {
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | UserMetadata.MAX_INTERNAL_KEY_SIZE);
            return;
        }
        View decorView2 = window.getDecorView();
        decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() & (-8193));
    }
}
