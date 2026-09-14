package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzalo extends zzgb implements zzall {
    public zzalo() {
        super("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
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
                double starRating = getStarRating();
                parcel2.writeNoException();
                parcel2.writeDouble(starRating);
                return true;
            case 8:
                headline = getStore();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 9:
                headline = getPrice();
                parcel2.writeNoException();
                parcel2.writeString(headline);
                return true;
            case 10:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 11:
                zzu(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 12:
                zzv(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 13:
                overrideImpressionRecording = getOverrideImpressionRecording();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, overrideImpressionRecording);
                return true;
            case 14:
                overrideImpressionRecording = getOverrideClickHandling();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, overrideImpressionRecording);
                return true;
            case 15:
                Bundle extras = getExtras();
                parcel2.writeNoException();
                zzge.zzb(parcel2, extras);
                return true;
            case 16:
                zzw(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 17:
                zzrg = getVideoController();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 18:
                zzrg = zzsu();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 19:
                zzrg = zzrh();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 20:
                zzrg = zzsv();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 21:
                zzrg = zzri();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzrg);
                return true;
            case 22:
                zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
