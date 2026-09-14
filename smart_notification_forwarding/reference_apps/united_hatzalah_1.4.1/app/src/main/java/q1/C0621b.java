package q1;

/* renamed from: q1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0621b {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f6148a;

    public C0621b(Integer num) {
        this.f6148a = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0621b)) {
            return false;
        }
        C0621b c0621b = (C0621b) obj;
        Integer num = this.f6148a;
        if (num == null) {
            if (c0621b.f6148a == null) {
                return true;
            }
            return false;
        }
        return num.equals(c0621b.f6148a);
    }

    public final int hashCode() {
        int hashCode;
        Integer num = this.f6148a;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return hashCode ^ 1000003;
    }

    public final String toString() {
        return "ProductData{productId=" + this.f6148a + "}";
    }
}
