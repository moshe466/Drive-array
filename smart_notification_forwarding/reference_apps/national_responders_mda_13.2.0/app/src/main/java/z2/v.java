package z2;

/* loaded from: classes.dex */
final class v implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ l f16130f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ w f16131g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(w wVar, l lVar) {
        this.f16131g = wVar;
        this.f16130f = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o0 o0Var;
        o0 o0Var2;
        o0 o0Var3;
        c cVar;
        o0 o0Var4;
        o0 o0Var5;
        if (this.f16130f.n()) {
            o0Var5 = this.f16131g.f16134c;
            o0Var5.u();
            return;
        }
        try {
            cVar = this.f16131g.f16133b;
            Object a10 = cVar.a(this.f16130f);
            o0Var4 = this.f16131g.f16134c;
            o0Var4.t(a10);
        } catch (j e10) {
            if (e10.getCause() instanceof Exception) {
                o0Var3 = this.f16131g.f16134c;
                o0Var3.s((Exception) e10.getCause());
            } else {
                o0Var2 = this.f16131g.f16134c;
                o0Var2.s(e10);
            }
        } catch (Exception e11) {
            o0Var = this.f16131g.f16134c;
            o0Var.s(e11);
        }
    }
}
