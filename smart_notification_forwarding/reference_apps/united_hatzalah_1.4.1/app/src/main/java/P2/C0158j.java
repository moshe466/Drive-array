package P2;

import java.util.concurrent.ScheduledFuture;

/* renamed from: P2.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0158j implements InterfaceC0160k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1667a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1668b;

    public /* synthetic */ C0158j(Object obj, int i) {
        this.f1667a = i;
        this.f1668b = obj;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [F2.l, kotlin.jvm.internal.k] */
    @Override // P2.InterfaceC0160k
    public final void a(Throwable th) {
        switch (this.f1667a) {
            case 0:
                if (th != null) {
                    ((ScheduledFuture) this.f1668b).cancel(false);
                    return;
                }
                return;
            case 1:
                ((kotlin.jvm.internal.k) this.f1668b).invoke(th);
                return;
            default:
                ((Q) this.f1668b).dispose();
                return;
        }
    }

    public final String toString() {
        switch (this.f1667a) {
            case 0:
                return "CancelFutureOnCancel[" + ((ScheduledFuture) this.f1668b) + ']';
            case 1:
                return "CancelHandler.UserSupplied[" + ((kotlin.jvm.internal.k) this.f1668b).getClass().getSimpleName() + '@' + G.l(this) + ']';
            default:
                return "DisposeOnCancel[" + ((Q) this.f1668b) + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0158j(F2.l lVar) {
        this.f1667a = 1;
        this.f1668b = (kotlin.jvm.internal.k) lVar;
    }
}
