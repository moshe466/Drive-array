package z2;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class x implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ l f16135f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ y f16136g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(y yVar, l lVar) {
        this.f16136g = yVar;
        this.f16135f = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o0 o0Var;
        o0 o0Var2;
        o0 o0Var3;
        c cVar;
        try {
            cVar = this.f16136g.f16138b;
            l lVar = (l) cVar.a(this.f16135f);
            if (lVar == null) {
                this.f16136g.d(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = n.f16109b;
            lVar.f(executor, this.f16136g);
            lVar.d(executor, this.f16136g);
            lVar.a(executor, this.f16136g);
        } catch (j e10) {
            if (e10.getCause() instanceof Exception) {
                o0Var3 = this.f16136g.f16139c;
                o0Var3.s((Exception) e10.getCause());
            } else {
                o0Var2 = this.f16136g.f16139c;
                o0Var2.s(e10);
            }
        } catch (Exception e11) {
            o0Var = this.f16136g.f16139c;
            o0Var.s(e11);
        }
    }
}
