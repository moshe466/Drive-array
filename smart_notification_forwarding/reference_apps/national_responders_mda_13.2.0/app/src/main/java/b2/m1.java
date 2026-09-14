package b2;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m1 extends i {

    /* renamed from: f, reason: collision with root package name */
    private final HashMap f4034f = new HashMap();

    /* renamed from: g, reason: collision with root package name */
    private final Context f4035g;

    /* renamed from: h, reason: collision with root package name */
    private volatile Handler f4036h;

    /* renamed from: i, reason: collision with root package name */
    private final l1 f4037i;

    /* renamed from: j, reason: collision with root package name */
    private final f2.a f4038j;

    /* renamed from: k, reason: collision with root package name */
    private final long f4039k;

    /* renamed from: l, reason: collision with root package name */
    private final long f4040l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m1(Context context, Looper looper) {
        l1 l1Var = new l1(this, null);
        this.f4037i = l1Var;
        this.f4035g = context.getApplicationContext();
        this.f4036h = new o2.i(looper, l1Var);
        this.f4038j = f2.a.b();
        this.f4039k = 5000L;
        this.f4040l = 300000L;
    }

    @Override // b2.i
    protected final void d(i1 i1Var, ServiceConnection serviceConnection, String str) {
        p.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f4034f) {
            j1 j1Var = (j1) this.f4034f.get(i1Var);
            if (j1Var == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + i1Var.toString());
            }
            if (!j1Var.h(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + i1Var.toString());
            }
            j1Var.f(serviceConnection, str);
            if (j1Var.i()) {
                this.f4036h.sendMessageDelayed(this.f4036h.obtainMessage(0, i1Var), this.f4039k);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b2.i
    public final boolean f(i1 i1Var, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean j10;
        p.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f4034f) {
            j1 j1Var = (j1) this.f4034f.get(i1Var);
            if (j1Var == null) {
                j1Var = new j1(this, i1Var);
                j1Var.d(serviceConnection, serviceConnection, str);
                j1Var.e(str, executor);
                this.f4034f.put(i1Var, j1Var);
            } else {
                this.f4036h.removeMessages(0, i1Var);
                if (j1Var.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + i1Var.toString());
                }
                j1Var.d(serviceConnection, serviceConnection, str);
                int a10 = j1Var.a();
                if (a10 == 1) {
                    serviceConnection.onServiceConnected(j1Var.b(), j1Var.c());
                } else if (a10 == 2) {
                    j1Var.e(str, executor);
                }
            }
            j10 = j1Var.j();
        }
        return j10;
    }
}
