package s0;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes.dex */
class k0 implements l0 {

    /* renamed from: a, reason: collision with root package name */
    private final WindowId f13943a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(View view) {
        this.f13943a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof k0) && ((k0) obj).f13943a.equals(this.f13943a);
    }

    public int hashCode() {
        return this.f13943a.hashCode();
    }
}
