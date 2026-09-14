package q1;

import F0.AbstractC0008a;

/* renamed from: q1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0622c {

    /* renamed from: a, reason: collision with root package name */
    public final String f6149a;

    public C0622c(String str) {
        if (str != null) {
            this.f6149a = str;
            return;
        }
        throw new NullPointerException("name is null");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0622c)) {
            return false;
        }
        return this.f6149a.equals(((C0622c) obj).f6149a);
    }

    public final int hashCode() {
        return this.f6149a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return AbstractC0008a.u(new StringBuilder("Encoding{name=\""), this.f6149a, "\"}");
    }
}
