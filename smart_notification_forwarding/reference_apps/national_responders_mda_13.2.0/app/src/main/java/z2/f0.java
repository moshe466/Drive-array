package z2;

/* loaded from: classes.dex */
final class f0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ l f16093f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ g0 f16094g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(g0 g0Var, l lVar) {
        this.f16094g = g0Var;
        this.f16093f = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        h hVar;
        h hVar2;
        obj = this.f16094g.f16096b;
        synchronized (obj) {
            g0 g0Var = this.f16094g;
            hVar = g0Var.f16097c;
            if (hVar != null) {
                hVar2 = g0Var.f16097c;
                hVar2.b(this.f16093f.l());
            }
        }
    }
}
