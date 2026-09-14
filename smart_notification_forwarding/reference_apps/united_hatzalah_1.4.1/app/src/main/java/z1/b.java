package z1;

import java.util.Set;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f6841a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6842b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f6843c;

    public b(long j2, long j3, Set set) {
        this.f6841a = j2;
        this.f6842b = j3;
        this.f6843c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f6841a == bVar.f6841a && this.f6842b == bVar.f6842b && this.f6843c.equals(bVar.f6843c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f6841a;
        int i = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        long j3 = this.f6842b;
        return ((i ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f6843c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f6841a + ", maxAllowedDelay=" + this.f6842b + ", flags=" + this.f6843c + "}";
    }
}
