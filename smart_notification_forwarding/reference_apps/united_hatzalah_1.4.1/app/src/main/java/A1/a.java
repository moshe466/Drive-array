package A1;

import F0.AbstractC0008a;
import org.apache.tika.pipes.PipesConfigBase;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f27f = new a(10485760, 604800000, 200, PipesConfigBase.DEFAULT_MAX_FILES_PROCESSED_PER_PROCESS, 81920);

    /* renamed from: a, reason: collision with root package name */
    public final long f28a;

    /* renamed from: b, reason: collision with root package name */
    public final int f29b;

    /* renamed from: c, reason: collision with root package name */
    public final int f30c;

    /* renamed from: d, reason: collision with root package name */
    public final long f31d;

    /* renamed from: e, reason: collision with root package name */
    public final int f32e;

    public a(long j2, long j3, int i, int i3, int i4) {
        this.f28a = j2;
        this.f29b = i;
        this.f30c = i3;
        this.f31d = j3;
        this.f32e = i4;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f28a == aVar.f28a && this.f29b == aVar.f29b && this.f30c == aVar.f30c && this.f31d == aVar.f31d && this.f32e == aVar.f32e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f28a;
        int i = (((((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f29b) * 1000003) ^ this.f30c) * 1000003;
        long j3 = this.f31d;
        return ((i ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ this.f32e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EventStoreConfig{maxStorageSizeInBytes=");
        sb.append(this.f28a);
        sb.append(", loadBatchSize=");
        sb.append(this.f29b);
        sb.append(", criticalSectionEnterTimeoutMs=");
        sb.append(this.f30c);
        sb.append(", eventCleanUpAge=");
        sb.append(this.f31d);
        sb.append(", maxBlobByteSizePerRow=");
        return AbstractC0008a.r(sb, this.f32e, "}");
    }
}
