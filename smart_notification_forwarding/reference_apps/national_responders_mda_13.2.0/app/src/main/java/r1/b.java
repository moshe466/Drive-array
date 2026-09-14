package r1;

import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends i {

    /* renamed from: a, reason: collision with root package name */
    private final long f13656a;

    /* renamed from: b, reason: collision with root package name */
    private final k1.m f13657b;

    /* renamed from: c, reason: collision with root package name */
    private final k1.h f13658c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(long j10, k1.m mVar, k1.h hVar) {
        this.f13656a = j10;
        Objects.requireNonNull(mVar, "Null transportContext");
        this.f13657b = mVar;
        Objects.requireNonNull(hVar, "Null event");
        this.f13658c = hVar;
    }

    @Override // r1.i
    public k1.h b() {
        return this.f13658c;
    }

    @Override // r1.i
    public long c() {
        return this.f13656a;
    }

    @Override // r1.i
    public k1.m d() {
        return this.f13657b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f13656a == iVar.c() && this.f13657b.equals(iVar.d()) && this.f13658c.equals(iVar.b());
    }

    public int hashCode() {
        long j10 = this.f13656a;
        return this.f13658c.hashCode() ^ ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f13657b.hashCode()) * 1000003);
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f13656a + ", transportContext=" + this.f13657b + ", event=" + this.f13658c + "}";
    }
}
