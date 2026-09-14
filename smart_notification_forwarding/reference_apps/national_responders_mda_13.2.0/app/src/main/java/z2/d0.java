package z2;

/* loaded from: classes.dex */
final class d0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ l f16088f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ e0 f16089g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(e0 e0Var, l lVar) {
        this.f16089g = e0Var;
        this.f16088f = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        g gVar;
        g gVar2;
        obj = this.f16089g.f16091b;
        synchronized (obj) {
            e0 e0Var = this.f16089g;
            gVar = e0Var.f16092c;
            if (gVar != null) {
                gVar2 = e0Var.f16092c;
                gVar2.d((Exception) b2.p.k(this.f16088f.k()));
            }
        }
    }
}
