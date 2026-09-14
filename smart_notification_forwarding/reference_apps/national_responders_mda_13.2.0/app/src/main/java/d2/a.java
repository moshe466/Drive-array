package d2;

import android.os.IBinder;
import android.os.Parcel;
import b2.t;

/* loaded from: classes.dex */
public final class a extends m2.a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    public final void z(t tVar) {
        Parcel i10 = i();
        m2.c.d(i10, tVar);
        p(1, i10);
    }
}
