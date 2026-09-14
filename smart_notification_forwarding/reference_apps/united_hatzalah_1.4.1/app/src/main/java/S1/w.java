package s1;

/* loaded from: classes.dex */
public final class w extends AbstractC0659J {

    /* renamed from: a, reason: collision with root package name */
    public final EnumC0658I f6326a;

    /* renamed from: b, reason: collision with root package name */
    public final EnumC0657H f6327b;

    public w(EnumC0658I enumC0658I, EnumC0657H enumC0657H) {
        this.f6326a = enumC0658I;
        this.f6327b = enumC0657H;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC0659J) {
            AbstractC0659J abstractC0659J = (AbstractC0659J) obj;
            EnumC0658I enumC0658I = this.f6326a;
            if (enumC0658I != null ? enumC0658I.equals(((w) abstractC0659J).f6326a) : ((w) abstractC0659J).f6326a == null) {
                EnumC0657H enumC0657H = this.f6327b;
                if (enumC0657H != null ? enumC0657H.equals(((w) abstractC0659J).f6327b) : ((w) abstractC0659J).f6327b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int i = 0;
        EnumC0658I enumC0658I = this.f6326a;
        if (enumC0658I == null) {
            hashCode = 0;
        } else {
            hashCode = enumC0658I.hashCode();
        }
        int i3 = (hashCode ^ 1000003) * 1000003;
        EnumC0657H enumC0657H = this.f6327b;
        if (enumC0657H != null) {
            i = enumC0657H.hashCode();
        }
        return i ^ i3;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f6326a + ", mobileSubtype=" + this.f6327b + "}";
    }
}
