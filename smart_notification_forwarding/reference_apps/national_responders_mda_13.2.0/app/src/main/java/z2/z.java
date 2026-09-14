package z2;

/* loaded from: classes.dex */
final class z implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ a0 f16140f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(a0 a0Var) {
        this.f16140f = a0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        e eVar;
        e eVar2;
        obj = this.f16140f.f16080b;
        synchronized (obj) {
            a0 a0Var = this.f16140f;
            eVar = a0Var.f16081c;
            if (eVar != null) {
                eVar2 = a0Var.f16081c;
                eVar2.a();
            }
        }
    }
}
