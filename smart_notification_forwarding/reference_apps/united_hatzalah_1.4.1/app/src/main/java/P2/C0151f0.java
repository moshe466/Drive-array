package P2;

/* renamed from: P2.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0151f0 implements InterfaceC0153g0 {

    /* renamed from: a, reason: collision with root package name */
    public final F2.l f1658a;

    public C0151f0(F2.l lVar) {
        this.f1658a = lVar;
    }

    @Override // P2.InterfaceC0153g0
    public final void a(Throwable th) {
        this.f1658a.invoke(th);
    }

    public final String toString() {
        return "InternalCompletionHandler.UserSupplied[" + this.f1658a.getClass().getSimpleName() + '@' + G.l(this) + ']';
    }
}
