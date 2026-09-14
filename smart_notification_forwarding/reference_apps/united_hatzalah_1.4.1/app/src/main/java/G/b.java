package G;

import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public String f766a;

    /* renamed from: b, reason: collision with root package name */
    public String f767b;

    /* renamed from: c, reason: collision with root package name */
    public List f768c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (Objects.equals(this.f766a, bVar.f766a) && Objects.equals(this.f767b, bVar.f767b) && Objects.equals(this.f768c, bVar.f768c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f766a, this.f767b, this.f768c);
    }
}
