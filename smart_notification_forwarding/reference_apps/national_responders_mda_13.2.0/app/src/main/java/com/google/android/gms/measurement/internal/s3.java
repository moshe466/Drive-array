package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import b2.c;

/* loaded from: classes.dex */
public final class s3 extends b2.c<v2.c> {
    public s3(Context context, Looper looper, c.a aVar, c.b bVar) {
        super(context, looper, 93, aVar, bVar, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // b2.c
    public final String J() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override // b2.c
    protected final String K() {
        return "com.google.android.gms.measurement.START";
    }

    @Override // b2.c
    public final int h() {
        return com.google.android.gms.common.e.f5095a;
    }

    @Override // b2.c
    public final /* synthetic */ v2.c x(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return queryLocalInterface instanceof v2.c ? (v2.c) queryLocalInterface : new m3(iBinder);
    }
}
