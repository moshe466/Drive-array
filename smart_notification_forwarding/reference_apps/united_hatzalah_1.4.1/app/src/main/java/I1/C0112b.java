package I1;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.ArrayList;

/* renamed from: I1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0112b extends z {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ IBinder f901j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ F1.p f902k;

    public C0112b(F1.p pVar, IBinder iBinder) {
        this.f902k = pVar;
        this.f901j = iBinder;
    }

    @Override // I1.z
    public final void b() {
        d dVar = (d) this.f902k.f750b;
        dVar.f918n = (IInterface) dVar.i.a(this.f901j);
        y yVar = dVar.f907b;
        int i = 0;
        yVar.b("linkToDeath", new Object[0]);
        try {
            dVar.f918n.asBinder().linkToDeath(dVar.f915k, 0);
        } catch (RemoteException e4) {
            yVar.a(e4, "linkToDeath failed", new Object[0]);
        }
        dVar.f912g = false;
        ArrayList arrayList = dVar.f909d;
        int size = arrayList.size();
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Runnable) obj).run();
        }
        dVar.f909d.clear();
    }
}
