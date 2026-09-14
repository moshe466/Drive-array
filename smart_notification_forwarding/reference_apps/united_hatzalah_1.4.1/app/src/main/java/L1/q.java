package L1;

import F0.AbstractC0008a;
import java.util.Objects;

/* loaded from: classes.dex */
public final class q extends c {

    /* renamed from: b, reason: collision with root package name */
    public final int f1332b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1333c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1334d;

    /* renamed from: e, reason: collision with root package name */
    public final j f1335e;

    public q(int i, int i3, int i4, j jVar) {
        this.f1332b = i;
        this.f1333c = i3;
        this.f1334d = i4;
        this.f1335e = jVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (qVar.f1332b != this.f1332b || qVar.f1333c != this.f1333c || qVar.f1334d != this.f1334d || qVar.f1335e != this.f1335e) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(q.class, Integer.valueOf(this.f1332b), Integer.valueOf(this.f1333c), Integer.valueOf(this.f1334d), this.f1335e);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AesGcm Parameters (variant: ");
        sb.append(this.f1335e);
        sb.append(", ");
        sb.append(this.f1333c);
        sb.append("-byte IV, ");
        sb.append(this.f1334d);
        sb.append("-byte tag, and ");
        return AbstractC0008a.r(sb, this.f1332b, "-byte key)");
    }
}
