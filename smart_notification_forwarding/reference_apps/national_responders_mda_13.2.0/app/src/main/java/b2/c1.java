package b2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import b2.c;

/* loaded from: classes.dex */
public final class c1 extends p0 {

    /* renamed from: g, reason: collision with root package name */
    public final IBinder f3951g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ c f3952h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(c cVar, int i10, IBinder iBinder, Bundle bundle) {
        super(cVar, i10, bundle);
        this.f3952h = cVar;
        this.f3951g = iBinder;
    }

    @Override // b2.p0
    protected final void f(com.google.android.gms.common.a aVar) {
        if (this.f3952h.f3941u != null) {
            this.f3952h.f3941u.n(aVar);
        }
        this.f3952h.Q(aVar);
    }

    @Override // b2.p0
    protected final boolean g() {
        c.a aVar;
        c.a aVar2;
        try {
            IBinder iBinder = this.f3951g;
            p.k(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f3952h.J().equals(interfaceDescriptor)) {
                String J = this.f3952h.J();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("service descriptor mismatch: ");
                sb2.append(J);
                sb2.append(" vs. ");
                sb2.append(interfaceDescriptor);
                return false;
            }
            IInterface x10 = this.f3952h.x(this.f3951g);
            if (x10 == null) {
                return false;
            }
            if (!c.l0(this.f3952h, 2, 4, x10) && !c.l0(this.f3952h, 3, 4, x10)) {
                return false;
            }
            this.f3952h.f3945y = null;
            Bundle C = this.f3952h.C();
            c cVar = this.f3952h;
            aVar = cVar.f3940t;
            if (aVar != null) {
                aVar2 = cVar.f3940t;
                aVar2.p(C);
            }
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }
}
