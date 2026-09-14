package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzsr {

    @VisibleForTesting
    zzgf a;

    @VisibleForTesting
    boolean b;

    public zzsr() {
    }

    public zzsr(Context context) {
        zzzn.initialize(context);
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcnw)).booleanValue()) {
            try {
                this.a = (zzgf) zzayx.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzst.a);
                ObjectWrapper.wrap(context);
                this.a.zza(ObjectWrapper.wrap(context), "GMA_SDK");
                this.b = true;
            } catch (RemoteException | zzayz | NullPointerException unused) {
                zzayu.zzea("Cannot dynamite load clearcut");
            }
        }
    }

    public zzsr(Context context, String str, String str2) {
        zzzn.initialize(context);
        try {
            this.a = (zzgf) zzayx.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzsu.a);
            ObjectWrapper.wrap(context);
            this.a.zza(ObjectWrapper.wrap(context), str, null);
            this.b = true;
        } catch (RemoteException | zzayz | NullPointerException unused) {
            zzayu.zzea("Cannot dynamite load clearcut");
        }
    }

    public final zzsv zzf(byte[] bArr) {
        return new zzsv(this, bArr);
    }
}
