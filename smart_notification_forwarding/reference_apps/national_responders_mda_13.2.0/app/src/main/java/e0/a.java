package e0;

import androidx.fragment.app.Fragment;
import y8.k;

/* loaded from: classes.dex */
public final class a extends h {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Fragment fragment, String str) {
        super(fragment, "Attempting to reuse fragment " + fragment + " with previous ID " + str);
        k.e(fragment, "fragment");
        k.e(str, "previousFragmentId");
    }
}
