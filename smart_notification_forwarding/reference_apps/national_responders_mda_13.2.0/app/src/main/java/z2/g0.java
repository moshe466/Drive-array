package z2;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g0 implements j0 {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f16095a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f16096b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private h f16097c;

    public g0(Executor executor, h hVar) {
        this.f16095a = executor;
        this.f16097c = hVar;
    }

    @Override // z2.j0
    public final void c(l lVar) {
        if (lVar.p()) {
            synchronized (this.f16096b) {
                if (this.f16097c == null) {
                    return;
                }
                this.f16095a.execute(new f0(this, lVar));
            }
        }
    }
}
