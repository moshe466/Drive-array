package z;

import android.content.res.Resources;
import java.util.Objects;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Resources f6793a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f6794b;

    public i(Resources resources, Resources.Theme theme) {
        this.f6793a = resources;
        this.f6794b = theme;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f6793a.equals(iVar.f6793a) && Objects.equals(this.f6794b, iVar.f6794b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f6793a, this.f6794b);
    }
}
