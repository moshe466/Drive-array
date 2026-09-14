package W2;

import P2.G;

/* loaded from: classes.dex */
public final class k extends i {

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f2539c;

    public k(Runnable runnable, long j2, j jVar) {
        super(j2, jVar);
        this.f2539c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f2539c.run();
        } finally {
            this.f2537b.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f2539c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(G.l(runnable));
        sb.append(", ");
        sb.append(this.f2536a);
        sb.append(", ");
        sb.append(this.f2537b);
        sb.append(']');
        return sb.toString();
    }
}
