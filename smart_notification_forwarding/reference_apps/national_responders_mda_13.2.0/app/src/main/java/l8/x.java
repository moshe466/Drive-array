package l8;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class x<T> implements h<T>, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private x8.a<? extends T> f11825f;

    /* renamed from: g, reason: collision with root package name */
    private Object f11826g;

    public x(x8.a<? extends T> aVar) {
        y8.k.e(aVar, "initializer");
        this.f11825f = aVar;
        this.f11826g = u.f11823a;
    }

    public boolean a() {
        return this.f11826g != u.f11823a;
    }

    @Override // l8.h
    public T getValue() {
        if (this.f11826g == u.f11823a) {
            x8.a<? extends T> aVar = this.f11825f;
            y8.k.b(aVar);
            this.f11826g = aVar.b();
            this.f11825f = null;
        }
        return (T) this.f11826g;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
