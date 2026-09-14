package I1;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f925a;

    /* renamed from: b, reason: collision with root package name */
    public final long f926b;

    public l(int i, long j2) {
        this.f925a = i;
        this.f926b = j2;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof l) {
                l lVar = (l) obj;
                if (this.f925a == lVar.f925a && this.f926b == lVar.f926b) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        long j2 = this.f926b;
        return ((int) ((j2 >>> 32) ^ j2)) ^ ((this.f925a ^ 1000003) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventRecord{eventType=");
        sb.append(this.f925a);
        sb.append(", eventTimestamp=");
        return e0.a.g(sb, this.f926b, "}");
    }
}
