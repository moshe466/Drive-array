package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
class ViewGroupUtils {
    private ViewGroupUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewGroupOverlayImpl a(@NonNull ViewGroup viewGroup) {
        return Build.VERSION.SDK_INT >= 18 ? new ViewGroupOverlayApi18(viewGroup) : ViewGroupOverlayApi14.a(viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(@NonNull ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            ViewGroupUtilsApi18.a(viewGroup, z);
        } else {
            ViewGroupUtilsApi14.a(viewGroup, z);
        }
    }
}
