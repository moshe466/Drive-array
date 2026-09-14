package s1;

/* loaded from: classes.dex */
public final class r extends AbstractC0653D {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f6309a;

    public r(Integer num) {
        this.f6309a = num;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0653D)) {
            return false;
        }
        Integer num = this.f6309a;
        r rVar = (r) ((AbstractC0653D) obj);
        if (num == null) {
            if (rVar.f6309a == null) {
                return true;
            }
            return false;
        }
        return num.equals(rVar.f6309a);
    }

    public final int hashCode() {
        int hashCode;
        Integer num = this.f6309a;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return hashCode ^ 1000003;
    }

    public final String toString() {
        return "ExternalPRequestContext{originAssociatedProductId=" + this.f6309a + "}";
    }
}
