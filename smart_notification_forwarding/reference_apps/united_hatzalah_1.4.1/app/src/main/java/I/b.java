package I;

import java.util.Objects;
import org.apache.tika.utils.StringUtils;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f882a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f883b;

    public b(Object obj, Object obj2) {
        this.f882a = obj;
        this.f883b = obj2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!Objects.equals(bVar.f882a, this.f882a) || !Objects.equals(bVar.f883b, this.f883b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        Object obj = this.f882a;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        Object obj2 = this.f883b;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return i ^ hashCode;
    }

    public final String toString() {
        return "Pair{" + this.f882a + StringUtils.SPACE + this.f883b + "}";
    }
}
