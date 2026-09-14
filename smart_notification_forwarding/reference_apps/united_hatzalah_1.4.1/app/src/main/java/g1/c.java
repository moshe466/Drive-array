package g1;

import java.util.List;
import t2.C0716r;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f4668c;

    /* renamed from: a, reason: collision with root package name */
    public final Object f4669a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4670b;

    static {
        C0716r c0716r = C0716r.f6476a;
        f4668c = new c(c0716r, c0716r);
    }

    public c(List list, List list2) {
        this.f4669a = list;
        this.f4670b = list2;
    }

    public final boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (!this.f4669a.equals(cVar.f4669a) || !this.f4670b.equals(cVar.f4670b)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f4670b.hashCode() + (this.f4669a.hashCode() * 31);
    }

    public final String toString() {
        return "CpuInfo(commonInfo=" + this.f4669a + ", perProcessorInfo=" + this.f4670b + ')';
    }
}
