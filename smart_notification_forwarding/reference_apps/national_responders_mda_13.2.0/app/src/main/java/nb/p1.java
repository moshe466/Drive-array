package nb;

/* loaded from: classes.dex */
public final class p1 extends u {

    /* renamed from: g, reason: collision with root package name */
    public static final p1 f12417g = new p1();

    private p1() {
    }

    @Override // nb.u
    public boolean a0(p8.f fVar) {
        return false;
    }

    @Override // nb.u
    public void c(p8.f fVar, Runnable runnable) {
        if (((s1) fVar.get(s1.f12426f)) == null) {
            throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
        }
    }

    @Override // nb.u
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
