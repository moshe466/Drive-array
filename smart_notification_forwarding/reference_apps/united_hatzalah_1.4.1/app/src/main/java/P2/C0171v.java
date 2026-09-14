package P2;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* renamed from: P2.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0171v {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f1706b = AtomicIntegerFieldUpdater.newUpdater(C0171v.class, "_handled$volatile");
    private volatile /* synthetic */ int _handled$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f1707a;

    public C0171v(Throwable th, boolean z3) {
        this.f1707a = th;
        this._handled$volatile = z3 ? 1 : 0;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f1707a + ']';
    }
}
