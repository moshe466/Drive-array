package I;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final float f884a;

    /* renamed from: b, reason: collision with root package name */
    public final float f885b;

    public c(float f4, float f5) {
        d.b("width", f4);
        this.f884a = f4;
        d.b("height", f5);
        this.f885b = f5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (cVar.f884a == this.f884a && cVar.f885b == this.f885b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f884a) ^ Float.floatToIntBits(this.f885b);
    }

    public final String toString() {
        return this.f884a + "x" + this.f885b;
    }
}
