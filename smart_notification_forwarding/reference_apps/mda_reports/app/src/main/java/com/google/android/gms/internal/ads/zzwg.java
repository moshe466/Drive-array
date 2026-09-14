package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public abstract class zzwg extends zzgb implements zzwd {
    public zzwg() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.internal.ads.zzgb
    protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface zza;
        switch (i) {
            case 1:
                zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzuj) zzge.zza(parcel, zzuj.CREATOR), parcel.readString(), zzalb.zzaa(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 2:
                zza = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzuj) zzge.zza(parcel, zzuj.CREATOR), parcel.readString(), zzalb.zzaa(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzalb.zzaa(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 4:
                zza = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 5:
                zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 6:
                zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzalb.zzaa(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 7:
                zza = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 8:
                zza = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 9:
                zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzuj) zzge.zza(parcel, zzuj.CREATOR), parcel.readString(), parcel.readInt());
                break;
            case 11:
                zza = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 12:
                zza = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzalb.zzaa(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 13:
                zza = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzuj) zzge.zza(parcel, zzuj.CREATOR), parcel.readString(), zzalb.zzaa(parcel.readStrongBinder()), parcel.readInt());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        zzge.zza(parcel2, zza);
        return true;
    }
}
