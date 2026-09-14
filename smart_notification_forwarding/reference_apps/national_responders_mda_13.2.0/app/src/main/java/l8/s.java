package l8;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class s<A, B, C> implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    private final A f11820f;

    /* renamed from: g, reason: collision with root package name */
    private final B f11821g;

    /* renamed from: h, reason: collision with root package name */
    private final C f11822h;

    public s(A a10, B b10, C c10) {
        this.f11820f = a10;
        this.f11821g = b10;
        this.f11822h = c10;
    }

    public final A a() {
        return this.f11820f;
    }

    public final B b() {
        return this.f11821g;
    }

    public final C c() {
        return this.f11822h;
    }

    public final C d() {
        return this.f11822h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return y8.k.a(this.f11820f, sVar.f11820f) && y8.k.a(this.f11821g, sVar.f11821g) && y8.k.a(this.f11822h, sVar.f11822h);
    }

    public int hashCode() {
        A a10 = this.f11820f;
        int hashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.f11821g;
        int hashCode2 = (hashCode + (b10 == null ? 0 : b10.hashCode())) * 31;
        C c10 = this.f11822h;
        return hashCode2 + (c10 != null ? c10.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f11820f + ", " + this.f11821g + ", " + this.f11822h + ')';
    }
}
