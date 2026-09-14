package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzadd extends zzgb implements zzade {
    public zzadd() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzade zzp(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        return queryLocalInterface instanceof zzade ? (zzade) queryLocalInterface : new zzadg(iBinder);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:1:0x0000. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        String zzct;
        IInterface zzcu;
        boolean zzp;
        switch (i) {
            case 1:
                zzct = zzct(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(zzct);
                return true;
            case 2:
                zzcu = zzcu(parcel.readString());
                parcel2.writeNoException();
                zzge.zza(parcel2, zzcu);
                return true;
            case 3:
                List<String> availableAssetNames = getAvailableAssetNames();
                parcel2.writeNoException();
                parcel2.writeStringList(availableAssetNames);
                return true;
            case 4:
                zzct = getCustomTemplateId();
                parcel2.writeNoException();
                parcel2.writeString(zzct);
                return true;
            case 5:
                performClick(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 7:
                zzcu = getVideoController();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzcu);
                return true;
            case 8:
                destroy();
                parcel2.writeNoException();
                return true;
            case 9:
                zzcu = zzrk();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzcu);
                return true;
            case 10:
                zzp = zzp(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, zzp);
                return true;
            case 11:
                zzcu = zzrf();
                parcel2.writeNoException();
                zzge.zza(parcel2, zzcu);
                return true;
            case 12:
                zzp = zzrl();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, zzp);
                return true;
            case 13:
                zzp = zzrm();
                parcel2.writeNoException();
                zzge.writeBoolean(parcel2, zzp);
                return true;
            case 14:
                zzq(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zzrn();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
