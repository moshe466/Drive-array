package j1;

import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
final class d extends j {

    /* renamed from: a, reason: collision with root package name */
    private final List<m> f10926a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(List<m> list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.f10926a = list;
    }

    @Override // j1.j
    public List<m> c() {
        return this.f10926a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return this.f10926a.equals(((j) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f10926a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f10926a + "}";
    }
}
