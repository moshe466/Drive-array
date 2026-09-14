package K2;

import a.AbstractC0228a;
import java.util.Iterator;

/* loaded from: classes.dex */
public class d implements Iterable, G2.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f1118a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1119b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1120c;

    public d(int i, int i3, int i4) {
        if (i4 != 0) {
            if (i4 != Integer.MIN_VALUE) {
                this.f1118a = i;
                this.f1119b = AbstractC0228a.u(i, i3, i4);
                this.f1120c = i4;
                return;
            }
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        throw new IllegalArgumentException("Step must be non-zero.");
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (this.f1118a == dVar.f1118a && this.f1119b == dVar.f1119b && this.f1120c == dVar.f1120c) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f1118a * 31) + this.f1119b) * 31) + this.f1120c;
    }

    public boolean isEmpty() {
        int i = this.f1120c;
        int i3 = this.f1119b;
        int i4 = this.f1118a;
        if (i > 0) {
            if (i4 <= i3) {
                return false;
            }
            return true;
        }
        if (i4 >= i3) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new e(this.f1118a, this.f1119b, this.f1120c);
    }

    public String toString() {
        StringBuilder sb;
        int i = this.f1119b;
        int i3 = this.f1118a;
        int i4 = this.f1120c;
        if (i4 > 0) {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
            sb.append(i4);
        } else {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            sb.append(-i4);
        }
        return sb.toString();
    }
}
