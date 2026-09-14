package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class GhostViewUtils {
    private GhostViewUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostViewImpl a(View view, ViewGroup viewGroup, Matrix matrix) {
        return Build.VERSION.SDK_INT >= 21 ? GhostViewApi21.a(view, viewGroup, matrix) : GhostViewApi14.a(view, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            GhostViewApi21.a(view);
        } else {
            GhostViewApi14.b(view);
        }
    }
}
