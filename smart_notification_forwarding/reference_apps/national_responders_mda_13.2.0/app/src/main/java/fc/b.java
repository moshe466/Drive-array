package fc;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class b<L, M, R> implements Comparable<b<L, M, R>>, Serializable {
    public static <L, M, R> b<L, M, R> o(L l10, M m10, R r10) {
        return new a(l10, m10, r10);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Objects.equals(k(), bVar.k()) && Objects.equals(l(), bVar.l()) && Objects.equals(n(), bVar.n());
    }

    public int hashCode() {
        return (Objects.hashCode(k()) ^ Objects.hashCode(l())) ^ Objects.hashCode(n());
    }

    @Override // java.lang.Comparable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(b<L, M, R> bVar) {
        return new dc.a().g(k(), bVar.k()).g(l(), bVar.l()).g(n(), bVar.n()).u();
    }

    public abstract L k();

    public abstract M l();

    public abstract R n();

    public String toString() {
        return "(" + k() + "," + l() + "," + n() + ")";
    }
}
