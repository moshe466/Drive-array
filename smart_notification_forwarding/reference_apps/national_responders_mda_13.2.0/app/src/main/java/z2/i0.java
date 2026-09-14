package z2;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class i0<TResult, TContinuationResult> implements h<TContinuationResult>, g, e, j0 {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f16100a;

    /* renamed from: b, reason: collision with root package name */
    private final k f16101b;

    /* renamed from: c, reason: collision with root package name */
    private final o0 f16102c;

    public i0(Executor executor, k kVar, o0 o0Var) {
        this.f16100a = executor;
        this.f16101b = kVar;
        this.f16102c = o0Var;
    }

    @Override // z2.e
    public final void a() {
        this.f16102c.u();
    }

    @Override // z2.h
    public final void b(TContinuationResult tcontinuationresult) {
        this.f16102c.t(tcontinuationresult);
    }

    @Override // z2.j0
    public final void c(l lVar) {
        this.f16100a.execute(new h0(this, lVar));
    }

    @Override // z2.g
    public final void d(Exception exc) {
        this.f16102c.s(exc);
    }
}
