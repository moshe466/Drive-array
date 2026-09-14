package U1;

import K1.f;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final f f2333a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2334b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2335c;

    /* renamed from: d, reason: collision with root package name */
    public final String f2336d;

    public b(f fVar, int i, String str, String str2) {
        this.f2333a = fVar;
        this.f2334b = i;
        this.f2335c = str;
        this.f2336d = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f2333a != bVar.f2333a || this.f2334b != bVar.f2334b || !this.f2335c.equals(bVar.f2335c) || !this.f2336d.equals(bVar.f2336d)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(this.f2333a, Integer.valueOf(this.f2334b), this.f2335c, this.f2336d);
    }

    public final String toString() {
        return "(status=" + this.f2333a + ", keyId=" + this.f2334b + ", keyType='" + this.f2335c + "', keyPrefix='" + this.f2336d + "')";
    }
}
