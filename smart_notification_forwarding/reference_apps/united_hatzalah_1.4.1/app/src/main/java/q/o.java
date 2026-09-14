package q;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6033a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f6034b;

    public o(p pVar) {
        this.f6033a = 0;
        this.f6034b = new WeakReference(pVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6033a) {
            case 0:
                WeakReference weakReference = this.f6034b;
                if (weakReference.get() != null) {
                    ((p) weakReference.get()).n();
                    return;
                }
                return;
            case 1:
                WeakReference weakReference2 = this.f6034b;
                if (weakReference2.get() != null) {
                    ((C0601A) weakReference2.get()).f6001n = false;
                    return;
                }
                return;
            default:
                WeakReference weakReference3 = this.f6034b;
                if (weakReference3.get() != null) {
                    ((C0601A) weakReference3.get()).f6002o = false;
                    return;
                }
                return;
        }
    }

    public o(C0601A c0601a, int i) {
        this.f6033a = i;
        switch (i) {
            case 2:
                this.f6034b = new WeakReference(c0601a);
                return;
            default:
                this.f6034b = new WeakReference(c0601a);
                return;
        }
    }
}
