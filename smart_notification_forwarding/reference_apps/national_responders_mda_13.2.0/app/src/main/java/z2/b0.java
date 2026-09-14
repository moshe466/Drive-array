package z2;

/* loaded from: classes.dex */
final class b0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ l f16083f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ c0 f16084g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(c0 c0Var, l lVar) {
        this.f16084g = c0Var;
        this.f16083f = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        f fVar;
        f fVar2;
        obj = this.f16084g.f16086b;
        synchronized (obj) {
            c0 c0Var = this.f16084g;
            fVar = c0Var.f16087c;
            if (fVar != null) {
                fVar2 = c0Var.f16087c;
                fVar2.a(this.f16083f);
            }
        }
    }
}
