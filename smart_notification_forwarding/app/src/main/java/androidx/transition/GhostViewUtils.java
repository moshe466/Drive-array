package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
class GhostViewUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostViewImpl addGhost(View view, ViewGroup viewGroup, Matrix matrix) {
        return GhostViewApi21.addGhost(view, viewGroup, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void removeGhost(View view) {
        GhostViewApi21.removeGhost(view);
    }

    private GhostViewUtils() {
    }
}
