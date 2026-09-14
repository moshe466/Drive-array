package q0;

import android.view.ViewGroup;
import android.view.WindowId;

/* loaded from: classes.dex */
public final class E {

    /* renamed from: a, reason: collision with root package name */
    public final WindowId f6068a;

    public E(ViewGroup viewGroup) {
        this.f6068a = viewGroup.getWindowId();
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof E) && ((E) obj).f6068a.equals(this.f6068a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6068a.hashCode();
    }
}
