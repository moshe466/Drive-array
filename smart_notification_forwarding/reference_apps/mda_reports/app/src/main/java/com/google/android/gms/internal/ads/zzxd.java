package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class zzxd extends zzgc implements zzxb {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzxd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoController");
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final float getAspectRatio() {
        Parcel a = a(9, c());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final int getPlaybackState() {
        Parcel a = a(5, c());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean isClickToExpandEnabled() {
        Parcel a = a(12, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean isCustomControlsEnabled() {
        Parcel a = a(10, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final boolean isMuted() {
        Parcel a = a(4, c());
        boolean zza = zzge.zza(a);
        a.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void mute(boolean z) {
        Parcel c = c();
        zzge.writeBoolean(c, z);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void pause() {
        b(2, c());
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void play() {
        b(1, c());
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void stop() {
        b(13, c());
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final void zza(zzxg zzxgVar) {
        Parcel c = c();
        zzge.zza(c, zzxgVar);
        b(8, c);
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final float zzpk() {
        Parcel a = a(6, c());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final float zzpl() {
        Parcel a = a(7, c());
        float readFloat = a.readFloat();
        a.recycle();
        return readFloat;
    }

    @Override // com.google.android.gms.internal.ads.zzxb
    public final zzxg zzpm() {
        zzxg zzxiVar;
        Parcel a = a(11, c());
        IBinder readStrongBinder = a.readStrongBinder();
        if (readStrongBinder == null) {
            zzxiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
            zzxiVar = queryLocalInterface instanceof zzxg ? (zzxg) queryLocalInterface : new zzxi(readStrongBinder);
        }
        a.recycle();
        return zzxiVar;
    }
}
