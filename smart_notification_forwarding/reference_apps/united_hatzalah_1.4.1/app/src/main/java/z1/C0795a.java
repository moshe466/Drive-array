package z1;

import A.n;
import java.util.HashMap;

/* renamed from: z1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0795a {

    /* renamed from: a, reason: collision with root package name */
    public final n f6839a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f6840b;

    public C0795a(n nVar, HashMap hashMap) {
        this.f6839a = nVar;
        this.f6840b = hashMap;
    }

    public final long a(q1.d dVar, long j2, int i) {
        long j3;
        long d2 = j2 - this.f6839a.d();
        b bVar = (b) this.f6840b.get(dVar);
        long j4 = bVar.f6841a;
        int i3 = i - 1;
        if (j4 > 1) {
            j3 = j4;
        } else {
            j3 = 2;
        }
        return Math.min(Math.max((long) (Math.pow(3.0d, i3) * j4 * Math.max(1.0d, Math.log(10000.0d) / Math.log(j3 * i3))), d2), bVar.f6842b);
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof C0795a) {
                C0795a c0795a = (C0795a) obj;
                if (this.f6839a.equals(c0795a.f6839a) && this.f6840b.equals(c0795a.f6840b)) {
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.f6839a.hashCode() ^ 1000003) * 1000003) ^ this.f6840b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f6839a + ", values=" + this.f6840b + "}";
    }
}
