package e0;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import y8.k;

/* loaded from: classes.dex */
public final class e extends h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Fragment fragment, ViewGroup viewGroup) {
        super(fragment, "Attempting to use <fragment> tag to add fragment " + fragment + " to container " + viewGroup);
        k.e(fragment, "fragment");
    }
}
