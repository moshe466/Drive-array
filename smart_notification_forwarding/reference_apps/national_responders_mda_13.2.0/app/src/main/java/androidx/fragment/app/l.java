package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* loaded from: classes.dex */
public abstract class l {
    @Deprecated
    public Fragment c(Context context, String str, Bundle bundle) {
        return Fragment.l0(context, str, bundle);
    }

    public abstract View d(int i10);

    public abstract boolean g();
}
