package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzaef extends zzgb implements zzaeg {
    public zzaef() {
        super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:1:0x0000. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        String headline;
        List images;
        IInterface zzrg;
        boolean recordImpression;
        zzaeb zzaedVar;
        switch (i) {
            case 2:
                headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 3:
                images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                return true;
            case 4:
                headline = getBody();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 5:
                zzrg = zzrg();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 6:
                headline = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 7:
                headline = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 8:
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                return true;
            case 9:
                headline = getStore();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 10:
                headline = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 11:
                zzrg = getVideoController();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 12:
                headline = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 13:
                destroy();
                parcel2.writeNoException();
                return true;
            case 14:
                zzrg = zzrh();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 15:
                performClick((Bundle) zzge.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 16:
                recordImpression = recordImpression((Bundle) zzge.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, recordImpression);
                return true;
            case 17:
                reportTouchEvent((Bundle) zzge.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 18:
                zzrg = zzrf();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 19:
                zzrg = zzri();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 20:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzge.zzb(parcel2, extras);
                return true;
            case 21:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzaedVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
                    zzaedVar = queryLocalInterface instanceof zzaeb ? (zzaeb) queryLocalInterface : new zzaed(readStrongBinder);
                }
                zza(zzaedVar);
                parcel2.writeNoException();
                return true;
            case 22:
                cancelUnconfirmedClick();
                parcel2.writeNoException();
                return true;
            case 23:
                images = getMuteThisAdReasons();
                parcel2.writeNoException();
                parcel2.writeList(images);
                return true;
            case 24:
                recordImpression = isCustomMuteThisAdEnabled();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, recordImpression);
                return true;
            case 25:
                zza(zzwu.zzg(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 26:
                zza(zzwq.zzf(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 27:
                zzrp();
                parcel2.writeNoException();
                return true;
            case 28:
                recordCustomClickGesture();
                parcel2.writeNoException();
                return true;
            case 29:
                zzrg = zzrq();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 30:
                recordImpression = isCustomClickGestureEnabled();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, recordImpression);
                return true;
            case 31:
                zzrg = zzkb();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            default:
                return false;
        }
    }
}
