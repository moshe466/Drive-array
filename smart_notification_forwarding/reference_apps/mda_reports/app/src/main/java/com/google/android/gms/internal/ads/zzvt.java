package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class zzvt extends zzgb implements zzvu {
    public zzvt() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzvu zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return queryLocalInterface instanceof zzvu ? (zzvu) queryLocalInterface : new zzvw(iBinder);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0001. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface zzjx;
        boolean isReady;
        Parcelable zzjz;
        String mediationAdapterClassName;
        zzvh zzvhVar = null;
        zzvx zzvxVar = null;
        zzwi zzwiVar = null;
        zzvg zzvgVar = null;
        zzwc zzwcVar = null;
        switch (i) {
            case 1:
                zzjx = zzjx();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzjx);
                return true;
            case 2:
                destroy();
                parcel2.writeNoException();
                return true;
            case 3:
                isReady = isReady();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, isReady);
                return true;
            case 4:
                isReady = zza((zzug) zzge.zza(parcel, zzug.CREATOR));
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, isReady);
                return true;
            case 5:
                pause();
                parcel2.writeNoException();
                return true;
            case 6:
                resume();
                parcel2.writeNoException();
                return true;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdListener");
                    zzvhVar = queryLocalInterface instanceof zzvh ? (zzvh) queryLocalInterface : new zzvj(readStrongBinder);
                }
                zza(zzvhVar);
                parcel2.writeNoException();
                return true;
            case 8:
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
                    zzwcVar = queryLocalInterface2 instanceof zzwc ? (zzwc) queryLocalInterface2 : new zzwe(readStrongBinder2);
                }
                zza(zzwcVar);
                parcel2.writeNoException();
                return true;
            case 9:
                showInterstitial();
                parcel2.writeNoException();
                return true;
            case 10:
                stopLoading();
                parcel2.writeNoException();
                return true;
            case 11:
                zzjy();
                parcel2.writeNoException();
                return true;
            case 12:
                zzjz = zzjz();
                parcel2.writeNoException();
                zzge.zzb(parcel2, zzjz);
                return true;
            case 13:
                zza((zzuj) zzge.zza(parcel, zzuj.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                zza(zzapb.zzaf(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zza(zzaph.zzah(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 16:
            case 17:
            case 27:
            case 28:
            default:
                return false;
            case 18:
                mediationAdapterClassName = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 19:
                zza(zzaaj.zzk(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdClickListener");
                    zzvgVar = queryLocalInterface3 instanceof zzvg ? (zzvg) queryLocalInterface3 : new zzvi(readStrongBinder3);
                }
                zza(zzvgVar);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.client.ICorrelationIdProvider");
                    zzwiVar = queryLocalInterface4 instanceof zzwi ? (zzwi) queryLocalInterface4 : new zzwh(readStrongBinder4);
                }
                zza(zzwiVar);
                parcel2.writeNoException();
                return true;
            case 22:
                setManualImpressionsEnabled(zzge.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 23:
                isReady = isLoading();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, isReady);
                return true;
            case 24:
                zza(zzarr.zzaj(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 25:
                setUserId(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 26:
                zzjx = getVideoController();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzjx);
                return true;
            case 29:
                zza((zzyw) zzge.zza(parcel, zzyw.CREATOR));
                parcel2.writeNoException();
                return true;
            case 30:
                zza((zzxh) zzge.zza(parcel, zzxh.CREATOR));
                parcel2.writeNoException();
                return true;
            case 31:
                mediationAdapterClassName = getAdUnitId();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 32:
                zzjx = zzkc();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzjx);
                return true;
            case 33:
                zzjx = zzkd();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzjx);
                return true;
            case 34:
                setImmersiveMode(zzge.zza(parcel));
                parcel2.writeNoException();
                return true;
            case 35:
                mediationAdapterClassName = zzka();
                parcel2.writeNoException();
                parcel2.writeString(mediationAdapterClassName);
                return true;
            case 36:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdMetadataListener");
                    zzvxVar = queryLocalInterface5 instanceof zzvx ? (zzvx) queryLocalInterface5 : new zzvz(readStrongBinder5);
                }
                zza(zzvxVar);
                parcel2.writeNoException();
                return true;
            case 37:
                zzjz = getAdMetadata();
                parcel2.writeNoException();
                zzge.zzb(parcel2, zzjz);
                return true;
            case 38:
                zzbr(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 39:
                zza((zzuo) zzge.zza(parcel, zzuo.CREATOR));
                parcel2.writeNoException();
                return true;
            case 40:
                zza(zzrj.zzb(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 41:
                zzjx = zzkb();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzjx);
                return true;
        }
    }
}
