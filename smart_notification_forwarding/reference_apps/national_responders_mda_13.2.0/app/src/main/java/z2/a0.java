package z2;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class a0 implements j0 {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f16079a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f16080b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private e f16081c;

    public a0(Executor executor, e eVar) {
        this.f16079a = executor;
        this.f16081c = eVar;
    }

    @Override // z2.j0
    public final void c(l lVar) {
        if (lVar.n()) {
            synchronized (this.f16080b) {
                if (this.f16081c == null) {
                    return;
                }
                this.f16079a.execute(new z(this));
            }
        }
    }
}
