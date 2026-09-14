package l8;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
final class q<T> implements h<T>, Serializable {

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<q<?>, Object> f11814h;

    /* renamed from: f, reason: collision with root package name */
    private volatile x8.a<? extends T> f11815f;

    /* renamed from: g, reason: collision with root package name */
    private volatile Object f11816g;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    static {
        new a(null);
        f11814h = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "g");
    }

    public q(x8.a<? extends T> aVar) {
        y8.k.e(aVar, "initializer");
        this.f11815f = aVar;
        this.f11816g = u.f11823a;
    }

    public boolean a() {
        return this.f11816g != u.f11823a;
    }

    @Override // l8.h
    public T getValue() {
        T t10 = (T) this.f11816g;
        u uVar = u.f11823a;
        if (t10 != uVar) {
            return t10;
        }
        x8.a<? extends T> aVar = this.f11815f;
        if (aVar != null) {
            T b10 = aVar.b();
            if (f11814h.compareAndSet(this, uVar, b10)) {
                this.f11815f = null;
                return b10;
            }
        }
        return (T) this.f11816g;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
