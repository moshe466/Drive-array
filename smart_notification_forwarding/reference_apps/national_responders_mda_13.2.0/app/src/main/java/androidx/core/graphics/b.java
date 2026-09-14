package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f2363e = new b(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f2364a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2365b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2366c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2367d;

    /* loaded from: classes.dex */
    static class a {
        static Insets a(int i10, int i11, int i12, int i13) {
            return Insets.of(i10, i11, i12, i13);
        }
    }

    private b(int i10, int i11, int i12, int i13) {
        this.f2364a = i10;
        this.f2365b = i11;
        this.f2366c = i12;
        this.f2367d = i13;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f2364a, bVar2.f2364a), Math.max(bVar.f2365b, bVar2.f2365b), Math.max(bVar.f2366c, bVar2.f2366c), Math.max(bVar.f2367d, bVar2.f2367d));
    }

    public static b b(int i10, int i11, int i12, int i13) {
        return (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) ? f2363e : new b(i10, i11, i12, i13);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return a.a(this.f2364a, this.f2365b, this.f2366c, this.f2367d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2367d == bVar.f2367d && this.f2364a == bVar.f2364a && this.f2366c == bVar.f2366c && this.f2365b == bVar.f2365b;
    }

    public int hashCode() {
        return (((((this.f2364a * 31) + this.f2365b) * 31) + this.f2366c) * 31) + this.f2367d;
    }

    public String toString() {
        return "Insets{left=" + this.f2364a + ", top=" + this.f2365b + ", right=" + this.f2366c + ", bottom=" + this.f2367d + '}';
    }
}
