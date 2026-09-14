package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzalu extends zzgb implements zzalr {
    public zzalu() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public static zzalr zzac(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
        return queryLocalInterface instanceof zzalr ? (zzalr) queryLocalInterface : new zzalt(iBinder);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:1:0x0000. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        String headline;
        IInterface zzrg;
        boolean overrideImpressionRecording;
        switch (i) {
            case 2:
                headline = getHeadline();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 3:
                List images = getImages();
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
                zzrg = zzrh();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 13:
                zzrg = zzsu();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 14:
                zzrg = zzsv();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 15:
                zzrg = zzri();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 16:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzge.zzb(parcel2, extras);
                return true;
            case 17:
                overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, overrideImpressionRecording);
                return true;
            case 18:
                overrideImpressionRecording = getOverrideClickHandling();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, overrideImpressionRecording);
                return true;
            case 19:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 20:
                zzu(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 21:
                zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 22:
                zzw(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 23:
                float mediaContentAspectRatio = getMediaContentAspectRatio();
                parcel2.writeNoException();
                parcel2.writeFloat(mediaContentAspectRatio);
                return true;
            default:
                return false;
        }
    }
}
