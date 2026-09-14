package F1;

import I1.C0112b;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes.dex */
public final class p implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f749a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f750b;

    public /* synthetic */ p(Object obj, int i) {
        this.f749a = i;
        this.f750b = obj;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        switch (this.f749a) {
            case 0:
                q qVar = (q) this.f750b;
                qVar.f753b.y("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
                qVar.a().post(new o(this, iBinder));
                return;
            default:
                I1.d dVar = (I1.d) this.f750b;
                dVar.f907b.b("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
                dVar.a().post(new C0112b(this, iBinder));
                return;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        switch (this.f749a) {
            case 0:
                q qVar = (q) this.f750b;
                qVar.f753b.y("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
                qVar.a().post(new n(this, 1));
                return;
            default:
                I1.d dVar = (I1.d) this.f750b;
                dVar.f907b.b("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
                dVar.a().post(new I1.c(this, 0));
                return;
        }
    }
}
