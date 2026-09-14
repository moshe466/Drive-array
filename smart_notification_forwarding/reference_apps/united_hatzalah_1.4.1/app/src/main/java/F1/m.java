package F1;

import I1.z;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements IBinder.DeathRecipient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f743a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f744b;

    public /* synthetic */ m(Object obj, int i) {
        this.f743a = i;
        this.f744b = obj;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        switch (this.f743a) {
            case 0:
                q qVar = (q) this.f744b;
                int i = 0;
                qVar.f753b.y("reportBinderDeath", new Object[0]);
                if (qVar.i.get() == null) {
                    qVar.f753b.y("%s : Binder has died.", qVar.f754c);
                    ArrayList arrayList = qVar.f755d;
                    int size = arrayList.size();
                    while (i < size) {
                        Object obj = arrayList.get(i);
                        i++;
                        RemoteException remoteException = new RemoteException(String.valueOf(qVar.f754c).concat(" : Binder has died."));
                        TaskCompletionSource taskCompletionSource = ((l) obj).f742a;
                        if (taskCompletionSource != null) {
                            taskCompletionSource.trySetException(remoteException);
                        }
                    }
                    qVar.f755d.clear();
                    synchronized (qVar.f757f) {
                        qVar.d();
                    }
                    return;
                }
                throw new ClassCastException();
            default:
                I1.d dVar = (I1.d) this.f744b;
                int i3 = 0;
                dVar.f907b.b("reportBinderDeath", new Object[0]);
                if (dVar.f914j.get() == null) {
                    dVar.f907b.b("%s : Binder has died.", dVar.f908c);
                    ArrayList arrayList2 = dVar.f909d;
                    int size2 = arrayList2.size();
                    while (i3 < size2) {
                        Object obj2 = arrayList2.get(i3);
                        i3++;
                        ((z) obj2).a(new RemoteException(String.valueOf(dVar.f908c).concat(" : Binder has died.")));
                    }
                    dVar.f909d.clear();
                    synchronized (dVar.f911f) {
                        dVar.e();
                    }
                    return;
                }
                throw new ClassCastException();
        }
    }
}
