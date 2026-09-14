package q2;

import android.os.RemoteException;
import com.google.android.gms.location.LocationResult;

/* loaded from: classes.dex */
final class b0 extends s2.n {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ z2.m f13471a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ n0 f13472b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(n0 n0Var, z2.m mVar) {
        this.f13472b = n0Var;
        this.f13471a = mVar;
    }

    @Override // s2.n
    public final void b(LocationResult locationResult) {
        this.f13471a.e(locationResult.g());
        try {
            this.f13472b.q0(com.google.android.gms.common.api.internal.m.c(this, "GetCurrentLocation"), false, new z2.m());
        } catch (RemoteException unused) {
        }
    }
}
