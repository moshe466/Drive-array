package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class zzxe extends zzgb implements zzxb {
    public zzxe() {
        super("com.google.android.gms.ads.internal.client.IVideoController");
    }

    public static zzxb zzj(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoController");
        return queryLocalInterface instanceof zzxb ? (zzxb) queryLocalInterface : new zzxd(iBinder);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:1:0x0000. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean isMuted;
        float zzpk;
        zzxg zzxiVar;
        switch (i) {
            case 1:
                play();
                parcel2.writeNoException();
                return true;
            case 2:
                pause();
                parcel2.writeNoException();
                return true;
            case 3:
                mute(zzge.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 4:
                isMuted = isMuted();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, isMuted);
                return true;
            case 5:
                int playbackState = getPlaybackState();
                parcel2.writeNoException();
                parcel2.writeInt(playbackState);
                return true;
            case 6:
                zzpk = zzpk();
                parcel2.writeNoException();
                parcel2.writeFloat(zzpk);
                return true;
            case 7:
                zzpk = zzpl();
                parcel2.writeNoException();
                parcel2.writeFloat(zzpk);
                return true;
            case 8:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzxiVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
                    zzxiVar = queryLocalInterface instanceof zzxg ? (zzxg) queryLocalInterface : new zzxi(readStrongBinder);
                }
                zza(zzxiVar);
                parcel2.writeNoException();
                return true;
            case 9:
                zzpk = getAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(zzpk);
                return true;
            case 10:
                isMuted = isCustomControlsEnabled();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, isMuted);
                return true;
            case 11:
                zzxg zzpm = zzpm();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzpm);
                return true;
            case 12:
                isMuted = isClickToExpandEnabled();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, isMuted);
                return true;
            case 13:
                stop();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
