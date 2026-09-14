package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzacz extends zzgb implements zzada {
    public zzacz() {
        super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:1:0x0000. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface zzrf;
        String headline;
        switch (i) {
            case 2:
                zzrf = zzrf();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrf);
                return true;
            case 3:
                headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 4:
                List images = getImages();
                parcel2.writeNoException();
                parcel2.writeList(images);
                return true;
            case 5:
                headline = getBody();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 6:
                zzrf = zzrj();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrf);
                return true;
            case 7:
                headline = getCallToAction();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 8:
                headline = getAdvertiser();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 9:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzge.zzb(parcel2, extras);
                return true;
            case 10:
                destroy();
                parcel2.writeNoException();
                return true;
            case 11:
                zzrf = getVideoController();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrf);
                return true;
            case 12:
                performClick((Bundle) zzge.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                boolean recordImpression = recordImpression((Bundle) zzge.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, recordImpression);
                return true;
            case 14:
                reportTouchEvent((Bundle) zzge.zza(parcel, Bundle.CREATOR));
                parcel2.writeNoException();
                return true;
            case 15:
                zzrf = zzrh();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrf);
                return true;
            case 16:
                zzrf = zzri();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrf);
                return true;
            case 17:
                headline = getMediationAdapterClassName();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            default:
                return false;
        }
    }
}
