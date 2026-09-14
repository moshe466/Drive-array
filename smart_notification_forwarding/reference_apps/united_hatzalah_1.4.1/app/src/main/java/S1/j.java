package S1;

import F0.AbstractC0008a;
import java.util.Objects;

/* loaded from: classes.dex */
public final class j extends L1.c {

    /* renamed from: b, reason: collision with root package name */
    public final int f2141b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2142c;

    /* renamed from: d, reason: collision with root package name */
    public final c f2143d;

    /* renamed from: e, reason: collision with root package name */
    public final c f2144e;

    public j(int i, int i3, c cVar, c cVar2) {
        this.f2141b = i;
        this.f2142c = i3;
        this.f2143d = cVar;
        this.f2144e = cVar2;
    }

    public final int b() {
        c cVar = c.f2128o;
        int i = this.f2142c;
        c cVar2 = this.f2143d;
        if (cVar2 == cVar) {
            return i;
        }
        if (cVar2 == c.f2125l) {
            return i + 5;
        }
        if (cVar2 == c.f2126m) {
            return i + 5;
        }
        if (cVar2 == c.f2127n) {
            return i + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar.f2141b != this.f2141b || jVar.b() != b() || jVar.f2143d != this.f2143d || jVar.f2144e != this.f2144e) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(j.class, Integer.valueOf(this.f2141b), Integer.valueOf(this.f2142c), this.f2143d, this.f2144e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("HMAC Parameters (variant: ");
        sb.append(this.f2143d);
        sb.append(", hashType: ");
        sb.append(this.f2144e);
        sb.append(", ");
        sb.append(this.f2142c);
        sb.append("-byte tags, and ");
        return AbstractC0008a.r(sb, this.f2141b, "-byte key)");
    }
}
