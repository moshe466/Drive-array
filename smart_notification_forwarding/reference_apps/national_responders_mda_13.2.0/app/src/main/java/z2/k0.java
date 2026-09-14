package z2;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f16103a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private Queue f16104b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f16105c;

    public final void a(j0 j0Var) {
        synchronized (this.f16103a) {
            if (this.f16104b == null) {
                this.f16104b = new ArrayDeque();
            }
            this.f16104b.add(j0Var);
        }
    }

    public final void b(l lVar) {
        j0 j0Var;
        synchronized (this.f16103a) {
            if (this.f16104b != null && !this.f16105c) {
                this.f16105c = true;
                while (true) {
                    synchronized (this.f16103a) {
                        j0Var = (j0) this.f16104b.poll();
                        if (j0Var == null) {
                            this.f16105c = false;
                            return;
                        }
                    }
                    j0Var.c(lVar);
                }
            }
        }
    }
}
