package P1;

import F0.AbstractC0008a;
import java.util.Objects;

/* loaded from: classes.dex */
public final class c extends K1.b {

    /* renamed from: b, reason: collision with root package name */
    public final int f1581b;

    /* renamed from: c, reason: collision with root package name */
    public final b f1582c;

    public c(int i, b bVar) {
        this.f1581b = i;
        this.f1582c = bVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar.f1581b != this.f1581b || cVar.f1582c != this.f1582c) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(c.class, Integer.valueOf(this.f1581b), this.f1582c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesSiv Parameters (variant: ");
        sb.append(this.f1582c);
        sb.append(", ");
        return AbstractC0008a.r(sb, this.f1581b, "-byte key)");
    }
}
