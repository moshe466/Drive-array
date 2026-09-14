package s1;

/* renamed from: s1.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0675o extends z {

    /* renamed from: a, reason: collision with root package name */
    public final C0673m f6305a;

    public C0675o(C0673m c0673m) {
        this.f6305a = c0673m;
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof z) {
                z zVar = (z) obj;
                ((C0675o) zVar).getClass();
                Object obj2 = y.f6328a;
                if (obj2.equals(obj2)) {
                    if (this.f6305a.equals(((C0675o) zVar).f6305a)) {
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
        return ((y.f6328a.hashCode() ^ 1000003) * 1000003) ^ this.f6305a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + y.f6328a + ", androidClientInfo=" + this.f6305a + "}";
    }
}
