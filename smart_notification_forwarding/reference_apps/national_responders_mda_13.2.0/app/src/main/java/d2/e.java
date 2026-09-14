package d2;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import b2.h;
import b2.v;
import com.google.android.gms.common.api.internal.f;
import com.google.android.gms.common.api.internal.o;

/* loaded from: classes.dex */
public final class e extends h {
    private final v F;

    public e(Context context, Looper looper, b2.e eVar, v vVar, f fVar, o oVar) {
        super(context, looper, 270, eVar, fVar, oVar);
        this.F = vVar;
    }

    @Override // b2.c
    public final z1.c[] A() {
        return m2.f.f12013b;
    }

    @Override // b2.c
    protected final Bundle F() {
        return this.F.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b2.c
    public final String J() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // b2.c
    protected final String K() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // b2.c
    protected final boolean N() {
        return true;
    }

    @Override // b2.c
    public final int h() {
        return 203400000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b2.c
    public final /* synthetic */ IInterface x(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return queryLocalInterface instanceof a ? (a) queryLocalInterface : new a(iBinder);
    }
}
