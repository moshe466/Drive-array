package b2;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public final class b1 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final int f3919a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f3920b;

    public b1(c cVar, int i10) {
        this.f3920b = cVar;
        this.f3919a = i10;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Object obj;
        c cVar = this.f3920b;
        if (iBinder == null) {
            c.i0(cVar, 16);
            return;
        }
        obj = cVar.f3933m;
        synchronized (obj) {
            c cVar2 = this.f3920b;
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            cVar2.f3934n = (queryLocalInterface == null || !(queryLocalInterface instanceof m)) ? new r0(iBinder) : (m) queryLocalInterface;
        }
        this.f3920b.j0(0, null, this.f3919a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Object obj;
        obj = this.f3920b.f3933m;
        synchronized (obj) {
            this.f3920b.f3934n = null;
        }
        Handler handler = this.f3920b.f3931k;
        handler.sendMessage(handler.obtainMessage(6, this.f3919a, 1));
    }
}
