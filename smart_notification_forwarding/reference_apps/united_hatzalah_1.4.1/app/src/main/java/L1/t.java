package L1;

import F0.AbstractC0008a;
import java.util.Objects;

/* loaded from: classes.dex */
public final class t extends c {

    /* renamed from: b, reason: collision with root package name */
    public final int f1340b;

    /* renamed from: c, reason: collision with root package name */
    public final j f1341c;

    public t(int i, j jVar) {
        this.f1340b = i;
        this.f1341c = jVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (tVar.f1340b != this.f1340b || tVar.f1341c != this.f1341c) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(t.class, Integer.valueOf(this.f1340b), this.f1341c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesGcmSiv Parameters (variant: ");
        sb.append(this.f1341c);
        sb.append(", ");
        return AbstractC0008a.r(sb, this.f1340b, "-byte key)");
    }
}
