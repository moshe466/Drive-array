package z2;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class w implements j0 {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f16132a;

    /* renamed from: b, reason: collision with root package name */
    private final c f16133b;

    /* renamed from: c, reason: collision with root package name */
    private final o0 f16134c;

    public w(Executor executor, c cVar, o0 o0Var) {
        this.f16132a = executor;
        this.f16133b = cVar;
        this.f16134c = o0Var;
    }

    @Override // z2.j0
    public final void c(l lVar) {
        this.f16132a.execute(new v(this, lVar));
    }
}
