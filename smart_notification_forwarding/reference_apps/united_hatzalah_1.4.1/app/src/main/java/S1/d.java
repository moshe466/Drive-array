package S1;

import F0.AbstractC0008a;
import java.util.Objects;

/* loaded from: classes.dex */
public final class d extends L1.c {

    /* renamed from: b, reason: collision with root package name */
    public final int f2131b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2132c;

    /* renamed from: d, reason: collision with root package name */
    public final c f2133d;

    public d(int i, int i3, c cVar) {
        this.f2131b = i;
        this.f2132c = i3;
        this.f2133d = cVar;
    }

    public final int b() {
        c cVar = c.f2120f;
        int i = this.f2132c;
        c cVar2 = this.f2133d;
        if (cVar2 == cVar) {
            return i;
        }
        if (cVar2 == c.f2117c) {
            return i + 5;
        }
        if (cVar2 == c.f2118d) {
            return i + 5;
        }
        if (cVar2 == c.f2119e) {
            return i + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (dVar.f2131b != this.f2131b || dVar.b() != b() || dVar.f2133d != this.f2133d) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(d.class, Integer.valueOf(this.f2131b), Integer.valueOf(this.f2132c), this.f2133d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AES-CMAC Parameters (variant: ");
        sb.append(this.f2133d);
        sb.append(", ");
        sb.append(this.f2132c);
        sb.append("-byte tags, and ");
        return AbstractC0008a.r(sb, this.f2131b, "-byte key)");
    }
}
