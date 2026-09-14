package L1;

import F0.AbstractC0008a;
import java.util.Objects;

/* loaded from: classes.dex */
public final class k extends c {

    /* renamed from: b, reason: collision with root package name */
    public final int f1315b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1316c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1317d;

    /* renamed from: e, reason: collision with root package name */
    public final j f1318e;

    /* renamed from: f, reason: collision with root package name */
    public final j f1319f;

    public k(int i, int i3, int i4, j jVar, j jVar2) {
        this.f1315b = i;
        this.f1316c = i3;
        this.f1317d = i4;
        this.f1318e = jVar;
        this.f1319f = jVar2;
    }

    public final int b() {
        j jVar = j.f1299j;
        int i = this.f1317d;
        j jVar2 = this.f1318e;
        if (jVar2 == jVar) {
            return i + 16;
        }
        if (jVar2 != j.f1298h && jVar2 != j.i) {
            throw new IllegalStateException("Unknown variant");
        }
        return i + 21;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (kVar.f1315b != this.f1315b || kVar.f1316c != this.f1316c || kVar.b() != b() || kVar.f1318e != this.f1318e || kVar.f1319f != this.f1319f) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(k.class, Integer.valueOf(this.f1315b), Integer.valueOf(this.f1316c), Integer.valueOf(this.f1317d), this.f1318e, this.f1319f);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesCtrHmacAead Parameters (variant: ");
        sb.append(this.f1318e);
        sb.append(", hashType: ");
        sb.append(this.f1319f);
        sb.append(", ");
        sb.append(this.f1317d);
        sb.append("-byte tags, and ");
        sb.append(this.f1315b);
        sb.append("-byte AES key, and ");
        return AbstractC0008a.r(sb, this.f1316c, "-byte HMAC key)");
    }
}
