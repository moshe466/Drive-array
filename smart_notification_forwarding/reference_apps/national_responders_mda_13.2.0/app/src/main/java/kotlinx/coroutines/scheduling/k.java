package kotlinx.coroutines.scheduling;

import nb.e0;

/* loaded from: classes.dex */
public final class k extends h {

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f11698h;

    public k(Runnable runnable, long j10, i iVar) {
        super(j10, iVar);
        this.f11698h = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f11698h.run();
        } finally {
            this.f11696g.a();
        }
    }

    public String toString() {
        return "Task[" + e0.a(this.f11698h) + '@' + e0.b(this.f11698h) + ", " + this.f11695f + ", " + this.f11696g + ']';
    }
}
