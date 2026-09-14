package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
final /* synthetic */ class zzasz implements zzayw {
    static final zzayw a = new zzasz();

    private zzasz() {
    }

    @Override // com.google.android.gms.internal.ads.zzayw
    public final Object apply(Object obj) {
        IBinder iBinder = (IBinder) obj;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCreator");
        return queryLocalInterface instanceof zzasm ? (zzasm) queryLocalInterface : new zzasp(iBinder);
    }
}
