package l8;

import java.io.Serializable;

/* loaded from: classes.dex */
final class r<T> implements h<T>, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private x8.a<? extends T> f11817f;

    /* renamed from: g, reason: collision with root package name */
    private volatile Object f11818g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f11819h;

    public r(x8.a<? extends T> aVar, Object obj) {
        y8.k.e(aVar, "initializer");
        this.f11817f = aVar;
        this.f11818g = u.f11823a;
        this.f11819h = obj == null ? this : obj;
    }

    public /* synthetic */ r(x8.a aVar, Object obj, int i10, y8.g gVar) {
        this(aVar, (i10 & 2) != 0 ? null : obj);
    }

    public boolean a() {
        return this.f11818g != u.f11823a;
    }

    @Override // l8.h
    public T getValue() {
        T t10;
        T t11 = (T) this.f11818g;
        u uVar = u.f11823a;
        if (t11 != uVar) {
            return t11;
        }
        synchronized (this.f11819h) {
            t10 = (T) this.f11818g;
            if (t10 == uVar) {
                x8.a<? extends T> aVar = this.f11817f;
                y8.k.b(aVar);
                t10 = aVar.b();
                this.f11818g = t10;
                this.f11817f = null;
            }
        }
        return t10;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
