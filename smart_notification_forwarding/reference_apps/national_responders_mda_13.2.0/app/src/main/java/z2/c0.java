package z2;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class c0 implements j0 {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f16085a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f16086b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private f f16087c;

    public c0(Executor executor, f fVar) {
        this.f16085a = executor;
        this.f16087c = fVar;
    }

    @Override // z2.j0
    public final void c(l lVar) {
        synchronized (this.f16086b) {
            if (this.f16087c == null) {
                return;
            }
            this.f16085a.execute(new b0(this, lVar));
        }
    }
}
