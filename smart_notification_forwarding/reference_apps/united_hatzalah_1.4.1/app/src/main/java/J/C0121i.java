package J;

import android.view.DisplayCutout;
import java.util.Objects;

/* renamed from: J.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0121i {

    /* renamed from: a, reason: collision with root package name */
    public final DisplayCutout f1003a;

    public C0121i(DisplayCutout displayCutout) {
        this.f1003a = displayCutout;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C0121i.class == obj.getClass()) {
            return Objects.equals(this.f1003a, ((C0121i) obj).f1003a);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        hashCode = this.f1003a.hashCode();
        return hashCode;
    }

    public final String toString() {
        return "DisplayCutoutCompat{" + this.f1003a + "}";
    }
}
