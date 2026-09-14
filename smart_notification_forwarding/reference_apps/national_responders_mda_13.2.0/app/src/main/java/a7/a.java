package a7;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final float f327a;

    /* renamed from: b, reason: collision with root package name */
    private final float f328b;

    public a(float f10, float f11) {
        this.f327a = f10;
        this.f328b = f11;
    }

    public float a() {
        return this.f328b;
    }

    public float b() {
        return this.f327a;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f327a == aVar.f327a && this.f328b == aVar.f328b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f327a) ^ Float.floatToIntBits(this.f328b);
    }

    public String toString() {
        return this.f327a + "x" + this.f328b;
    }
}
