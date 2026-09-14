package z2;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class y<TResult, TContinuationResult> implements h<TContinuationResult>, g, e, j0 {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f16137a;

    /* renamed from: b, reason: collision with root package name */
    private final c f16138b;

    /* renamed from: c, reason: collision with root package name */
    private final o0 f16139c;

    public y(Executor executor, c cVar, o0 o0Var) {
        this.f16137a = executor;
        this.f16138b = cVar;
        this.f16139c = o0Var;
    }

    @Override // z2.e
    public final void a() {
        this.f16139c.u();
    }

    @Override // z2.h
    public final void b(TContinuationResult tcontinuationresult) {
        this.f16139c.t(tcontinuationresult);
    }

    @Override // z2.j0
    public final void c(l lVar) {
        this.f16137a.execute(new x(this, lVar));
    }

    @Override // z2.g
    public final void d(Exception exc) {
        this.f16139c.s(exc);
    }
}
