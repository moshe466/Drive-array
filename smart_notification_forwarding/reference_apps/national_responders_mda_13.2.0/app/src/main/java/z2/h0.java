package z2;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class h0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ l f16098f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ i0 f16099g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(i0 i0Var, l lVar) {
        this.f16099g = i0Var;
        this.f16098f = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k kVar;
        try {
            kVar = this.f16099g.f16101b;
            l a10 = kVar.a(this.f16098f.l());
            if (a10 == null) {
                this.f16099g.d(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = n.f16109b;
            a10.f(executor, this.f16099g);
            a10.d(executor, this.f16099g);
            a10.a(executor, this.f16099g);
        } catch (CancellationException unused) {
            this.f16099g.a();
        } catch (j e10) {
            if (e10.getCause() instanceof Exception) {
                this.f16099g.d((Exception) e10.getCause());
            } else {
                this.f16099g.d(e10);
            }
        } catch (Exception e11) {
            this.f16099g.d(e11);
        }
    }
}
