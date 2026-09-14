package q2;

import android.app.PendingIntent;
import android.os.IInterface;
import com.google.android.gms.location.LocationRequest;

/* loaded from: classes.dex */
public interface v1 extends IInterface {
    @Deprecated
    b2.k F(s2.g gVar, x1 x1Var);

    @Deprecated
    void S(s0 s0Var);

    void T(s2.e eVar, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.i iVar);

    void a0(o0 o0Var, com.google.android.gms.common.api.internal.i iVar);

    void b0(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.i iVar);

    void c0(PendingIntent pendingIntent, t1 t1Var, String str);

    void d0(o0 o0Var, LocationRequest locationRequest, com.google.android.gms.common.api.internal.i iVar);

    void n0(s2.m mVar, PendingIntent pendingIntent, t1 t1Var);
}
