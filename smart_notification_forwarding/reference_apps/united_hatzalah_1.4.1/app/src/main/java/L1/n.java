package L1;

import F0.AbstractC0008a;
import java.util.Objects;

/* loaded from: classes.dex */
public final class n extends c {

    /* renamed from: b, reason: collision with root package name */
    public final int f1324b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1325c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1326d;

    /* renamed from: e, reason: collision with root package name */
    public final j f1327e;

    public n(int i, int i3, int i4, j jVar) {
        this.f1324b = i;
        this.f1325c = i3;
        this.f1326d = i4;
        this.f1327e = jVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        if (nVar.f1324b != this.f1324b || nVar.f1325c != this.f1325c || nVar.f1326d != this.f1326d || nVar.f1327e != this.f1327e) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(n.class, Integer.valueOf(this.f1324b), Integer.valueOf(this.f1325c), Integer.valueOf(this.f1326d), this.f1327e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesEax Parameters (variant: ");
        sb.append(this.f1327e);
        sb.append(", ");
        sb.append(this.f1325c);
        sb.append("-byte IV, ");
        sb.append(this.f1326d);
        sb.append("-byte tag, and ");
        return AbstractC0008a.r(sb, this.f1324b, "-byte key)");
    }
}
