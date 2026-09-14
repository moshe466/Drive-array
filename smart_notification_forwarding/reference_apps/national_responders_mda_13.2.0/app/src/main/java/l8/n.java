package l8;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class n<A, B> implements Serializable {

    /* renamed from: f, reason: collision with root package name */
    private final A f11810f;

    /* renamed from: g, reason: collision with root package name */
    private final B f11811g;

    public n(A a10, B b10) {
        this.f11810f = a10;
        this.f11811g = b10;
    }

    public final A a() {
        return this.f11810f;
    }

    public final B b() {
        return this.f11811g;
    }

    public final A c() {
        return this.f11810f;
    }

    public final B d() {
        return this.f11811g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return y8.k.a(this.f11810f, nVar.f11810f) && y8.k.a(this.f11811g, nVar.f11811g);
    }

    public int hashCode() {
        A a10 = this.f11810f;
        int hashCode = (a10 == null ? 0 : a10.hashCode()) * 31;
        B b10 = this.f11811g;
        return hashCode + (b10 != null ? b10.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f11810f + ", " + this.f11811g + ')';
    }
}
