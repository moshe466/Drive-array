package s1;

/* loaded from: classes.dex */
public final class p extends AbstractC0651B {

    /* renamed from: a, reason: collision with root package name */
    public final s f6306a;

    public p(s sVar) {
        EnumC0650A enumC0650A = EnumC0650A.f6237a;
        this.f6306a = sVar;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof AbstractC0651B) {
                AbstractC0651B abstractC0651B = (AbstractC0651B) obj;
                if (this.f6306a.equals(((p) abstractC0651B).f6306a)) {
                    Object obj2 = EnumC0650A.f6237a;
                    ((p) abstractC0651B).getClass();
                    if (obj2.equals(obj2)) {
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.f6306a.hashCode() ^ 1000003) * 1000003) ^ EnumC0650A.f6237a.hashCode();
    }

    public final String toString() {
        return "ComplianceData{privacyContext=" + this.f6306a + ", productIdOrigin=" + EnumC0650A.f6237a + "}";
    }
}
