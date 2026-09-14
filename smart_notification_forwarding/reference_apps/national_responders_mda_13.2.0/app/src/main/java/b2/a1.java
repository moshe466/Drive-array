package b2;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes.dex */
public final class a1 extends q0 {

    /* renamed from: a, reason: collision with root package name */
    private c f3915a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3916b;

    public a1(c cVar, int i10) {
        this.f3915a = cVar;
        this.f3916b = i10;
    }

    @Override // b2.l
    public final void P(int i10, IBinder iBinder, e1 e1Var) {
        c cVar = this.f3915a;
        p.l(cVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        p.k(e1Var);
        c.h0(cVar, e1Var);
        u0(i10, iBinder, e1Var.f3972f);
    }

    @Override // b2.l
    public final void X(int i10, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // b2.l
    public final void u0(int i10, IBinder iBinder, Bundle bundle) {
        p.l(this.f3915a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f3915a.S(i10, iBinder, bundle, this.f3916b);
        this.f3915a = null;
    }
}
