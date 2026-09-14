package F;

import F0.C0035g2;
import android.os.CancellationSignal;
import q0.q;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public boolean f154a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f155b;

    /* renamed from: c, reason: collision with root package name */
    public Object f156c;

    /* renamed from: d, reason: collision with root package name */
    public Object f157d;

    public void a() {
        synchronized (this) {
            try {
                if (this.f154a) {
                    return;
                }
                this.f154a = true;
                this.f155b = true;
                C0035g2 c0035g2 = (C0035g2) this.f156c;
                CancellationSignal cancellationSignal = (CancellationSignal) this.f157d;
                if (c0035g2 != null) {
                    try {
                        ((q) c0035g2.f526b).d();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f155b = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (cancellationSignal != null) {
                    cancellationSignal.cancel();
                }
                synchronized (this) {
                    this.f155b = false;
                    notifyAll();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
