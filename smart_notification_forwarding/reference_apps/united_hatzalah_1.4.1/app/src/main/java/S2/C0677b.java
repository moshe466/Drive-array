package s2;

import kotlin.jvm.internal.j;

/* renamed from: s2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0677b implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final C0677b f6330b = new C0677b();

    /* renamed from: a, reason: collision with root package name */
    public final int f6331a = 131604;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0677b other = (C0677b) obj;
        j.e(other, "other");
        return this.f6331a - other.f6331a;
    }

    public final boolean equals(Object obj) {
        C0677b c0677b;
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0677b) {
            c0677b = (C0677b) obj;
        } else {
            c0677b = null;
        }
        if (c0677b != null && this.f6331a == c0677b.f6331a) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6331a;
    }

    public final String toString() {
        return "2.2.20";
    }
}
