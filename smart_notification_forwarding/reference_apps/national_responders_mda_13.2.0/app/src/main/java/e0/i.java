package e0;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import y8.k;

/* loaded from: classes.dex */
public final class i extends h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Fragment fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to add fragment " + fragment + " to container " + viewGroup + " which is not a FragmentContainerView");
        k.e(fragment, "fragment");
        k.e(viewGroup, "container");
    }
}
