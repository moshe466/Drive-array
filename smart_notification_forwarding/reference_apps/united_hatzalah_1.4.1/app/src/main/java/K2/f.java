package K2;

/* loaded from: classes.dex */
public final class f extends d {

    /* renamed from: d, reason: collision with root package name */
    public static final f f1125d = new d(1, 0, 1);

    @Override // K2.d
    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            if (!isEmpty() || !((f) obj).isEmpty()) {
                f fVar = (f) obj;
                if (this.f1118a == fVar.f1118a && this.f1119b == fVar.f1119b) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // K2.d
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f1118a * 31) + this.f1119b;
    }

    @Override // K2.d
    public final boolean isEmpty() {
        if (this.f1118a > this.f1119b) {
            return true;
        }
        return false;
    }

    @Override // K2.d
    public final String toString() {
        return this.f1118a + ".." + this.f1119b;
    }
}
