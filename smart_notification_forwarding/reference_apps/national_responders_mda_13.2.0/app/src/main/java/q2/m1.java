package q2;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

/* loaded from: classes.dex */
public final class m1 extends b2.h {
    public m1(Context context, Looper looper, b2.e eVar, com.google.android.gms.common.api.internal.f fVar, com.google.android.gms.common.api.internal.o oVar) {
        super(context, looper, 23, eVar, fVar, oVar);
    }

    @Override // b2.c
    public final z1.c[] A() {
        return s2.z.f14069l;
    }

    @Override // b2.c
    protected final Bundle F() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", "activity_recognition");
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b2.c
    public final String J() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // b2.c
    protected final String K() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // b2.c
    public final boolean X() {
        return true;
    }

    @Override // b2.c
    public final int h() {
        return 11717000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b2.c
    public final /* synthetic */ IInterface x(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof v1 ? (v1) queryLocalInterface : new u1(iBinder);
    }
}
