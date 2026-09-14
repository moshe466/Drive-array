package A1;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f33a;

    /* renamed from: b, reason: collision with root package name */
    public final t1.k f34b;

    /* renamed from: c, reason: collision with root package name */
    public final t1.j f35c;

    public b(long j2, t1.k kVar, t1.j jVar) {
        this.f33a = j2;
        this.f34b = kVar;
        this.f35c = jVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f33a == bVar.f33a && this.f34b.equals(bVar.f34b) && this.f35c.equals(bVar.f35c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f33a;
        return ((((((int) ((j2 >>> 32) ^ j2)) ^ 1000003) * 1000003) ^ this.f34b.hashCode()) * 1000003) ^ this.f35c.hashCode();
    }

    public final String toString() {
        return "PersistedEvent{id=" + this.f33a + ", transportContext=" + this.f34b + ", event=" + this.f35c + "}";
    }
}
