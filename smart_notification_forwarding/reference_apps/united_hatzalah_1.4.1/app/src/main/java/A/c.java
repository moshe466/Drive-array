package A;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f1e = new c(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f2a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5d;

    public c(int i, int i3, int i4, int i5) {
        this.f2a = i;
        this.f3b = i3;
        this.f4c = i4;
        this.f5d = i5;
    }

    public static c a(int i, int i3, int i4, int i5) {
        if (i == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return f1e;
        }
        return new c(i, i3, i4, i5);
    }

    public static c b(Insets insets) {
        int i;
        int i3;
        int i4;
        int i5;
        i = insets.left;
        i3 = insets.top;
        i4 = insets.right;
        i5 = insets.bottom;
        return a(i, i3, i4, i5);
    }

    public final Insets c() {
        return b.b(this.f2a, this.f3b, this.f4c, this.f5d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f5d == cVar.f5d && this.f2a == cVar.f2a && this.f4c == cVar.f4c && this.f3b == cVar.f3b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((((this.f2a * 31) + this.f3b) * 31) + this.f4c) * 31) + this.f5d;
    }

    public final String toString() {
        return "Insets{left=" + this.f2a + ", top=" + this.f3b + ", right=" + this.f4c + ", bottom=" + this.f5d + '}';
    }
}
