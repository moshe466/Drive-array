package F1;

import F0.C0035g2;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class o extends l {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBinder f747b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f748c;

    public o(p pVar, IBinder iBinder) {
        this.f748c = pVar;
        this.f747b = iBinder;
    }

    @Override // F1.l
    public final void a() {
        h fVar;
        q qVar = (q) this.f748c.f750b;
        int i = g.f738a;
        IBinder iBinder = this.f747b;
        if (iBinder == null) {
            fVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
            if (queryLocalInterface instanceof h) {
                fVar = (h) queryLocalInterface;
            } else {
                fVar = new f(iBinder);
            }
        }
        qVar.f763m = fVar;
        C0035g2 c0035g2 = qVar.f753b;
        int i3 = 0;
        c0035g2.y("linkToDeath", new Object[0]);
        try {
            qVar.f763m.asBinder().linkToDeath(qVar.f760j, 0);
        } catch (RemoteException e4) {
            c0035g2.x(e4, "linkToDeath failed", new Object[0]);
        }
        qVar.f758g = false;
        ArrayList arrayList = qVar.f755d;
        int size = arrayList.size();
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((Runnable) obj).run();
        }
        qVar.f755d.clear();
    }
}
