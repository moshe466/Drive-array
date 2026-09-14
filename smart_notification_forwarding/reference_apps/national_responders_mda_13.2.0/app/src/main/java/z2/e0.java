package z2;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e0 implements j0 {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f16090a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f16091b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private g f16092c;

    public e0(Executor executor, g gVar) {
        this.f16090a = executor;
        this.f16092c = gVar;
    }

    @Override // z2.j0
    public final void c(l lVar) {
        if (lVar.p() || lVar.n()) {
            return;
        }
        synchronized (this.f16091b) {
            if (this.f16092c == null) {
                return;
            }
            this.f16090a.execute(new d0(this, lVar));
        }
    }
}
