package w3;

import w3.v;

/* loaded from: classes.dex */
final class h extends v.d.a.b {

    /* renamed from: a, reason: collision with root package name */
    private final String f14991a;

    @Override // w3.v.d.a.b
    public String a() {
        return this.f14991a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v.d.a.b) {
            return this.f14991a.equals(((v.d.a.b) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f14991a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Organization{clsId=" + this.f14991a + "}";
    }
}
