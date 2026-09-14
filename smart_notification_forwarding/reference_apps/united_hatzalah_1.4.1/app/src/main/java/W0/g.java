package W0;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2458a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2459b;

    public g(Object obj, Object obj2) {
        this.f2458a = obj;
        this.f2459b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        Object obj2 = gVar.f2459b;
        Object obj3 = gVar.f2458a;
        Object obj4 = this.f2458a;
        if (obj4 == null) {
            if (obj3 != null) {
                return false;
            }
        } else if (!obj4.equals(obj3)) {
            return false;
        }
        Object obj5 = this.f2459b;
        if (obj5 == null) {
            if (obj2 != null) {
                return false;
            }
        } else if (!obj5.equals(obj2)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        Object obj = this.f2458a;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        int i3 = (hashCode + 31) * 31;
        Object obj2 = this.f2459b;
        if (obj2 != null) {
            i = obj2.hashCode();
        }
        return i3 + i;
    }
}
