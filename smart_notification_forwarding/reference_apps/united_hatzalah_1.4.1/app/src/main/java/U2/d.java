package U2;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2345a = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f2346b = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public d(s sVar) {
        this._prev$volatile = sVar;
    }

    public final void b() {
        f2346b.set(this, null);
    }

    public final d c() {
        Object obj = f2345a.get(this);
        if (obj == a.f2338b) {
            return null;
        }
        return (d) obj;
    }

    public abstract boolean d();

    public final void e() {
        d dVar;
        d c4;
        if (c() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f2346b;
            d dVar2 = (d) atomicReferenceFieldUpdater.get(this);
            while (dVar2 != null && dVar2.d()) {
                dVar2 = (d) atomicReferenceFieldUpdater.get(dVar2);
            }
            d c5 = c();
            kotlin.jvm.internal.j.b(c5);
            while (c5.d() && (c4 = c5.c()) != null) {
                c5 = c4;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(c5);
                if (((d) obj) == null) {
                    dVar = null;
                } else {
                    dVar = dVar2;
                }
                while (!atomicReferenceFieldUpdater.compareAndSet(c5, obj, dVar)) {
                    if (atomicReferenceFieldUpdater.get(c5) != obj) {
                        break;
                    }
                }
            }
            if (dVar2 != null) {
                f2345a.set(dVar2, c5);
            }
            if (!c5.d() || c5.c() == null) {
                if (dVar2 == null || !dVar2.d()) {
                    return;
                }
            }
        }
    }
}
