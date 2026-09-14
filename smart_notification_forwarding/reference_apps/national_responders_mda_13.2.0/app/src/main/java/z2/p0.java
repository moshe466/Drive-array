package z2;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ o0 f16118f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ Callable f16119g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p0(o0 o0Var, Callable callable) {
        this.f16118f = o0Var;
        this.f16119g = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f16118f.t(this.f16119g.call());
        } catch (Exception e10) {
            this.f16118f.s(e10);
        } catch (Throwable th) {
            this.f16118f.s(new RuntimeException(th));
        }
    }
}
