package M;

import androidx.core.widget.NestedScrollView;

/* loaded from: classes.dex */
public abstract class f {
    public static void a(NestedScrollView nestedScrollView, float f4) {
        try {
            nestedScrollView.setFrameContentVelocity(f4);
        } catch (LinkageError unused) {
        }
    }
}
