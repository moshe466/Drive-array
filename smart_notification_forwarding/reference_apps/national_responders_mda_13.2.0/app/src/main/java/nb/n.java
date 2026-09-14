package nb;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public class n {

    /* renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f12407b = AtomicIntegerFieldUpdater.newUpdater(n.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f12408a;

    public n(Throwable th, boolean z10) {
        this.f12408a = th;
        this._handled = z10 ? 1 : 0;
    }

    public /* synthetic */ n(Throwable th, boolean z10, int i10, y8.g gVar) {
        this(th, (i10 & 2) != 0 ? false : z10);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return f12407b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return e0.a(this) + '[' + this.f12408a + ']';
    }
}
