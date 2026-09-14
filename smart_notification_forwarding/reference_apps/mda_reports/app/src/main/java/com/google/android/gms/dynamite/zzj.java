package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes.dex */
public final class zzj extends com.google.android.gms.internal.common.zza implements zzi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final int zza(IObjectWrapper iObjectWrapper, String str, boolean z) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zza(zza, iObjectWrapper);
        zza.writeString(str);
        com.google.android.gms.internal.common.zzc.writeBoolean(zza, z);
        Parcel a = a(3, zza);
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final IObjectWrapper zza(IObjectWrapper iObjectWrapper, String str, int i) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zza(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i);
        Parcel a = a(2, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final int zzak() {
        Parcel a = a(6, zza());
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final int zzb(IObjectWrapper iObjectWrapper, String str, boolean z) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zza(zza, iObjectWrapper);
        zza.writeString(str);
        com.google.android.gms.internal.common.zzc.writeBoolean(zza, z);
        Parcel a = a(5, zza);
        int readInt = a.readInt();
        a.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.dynamite.zzi
    public final IObjectWrapper zzb(IObjectWrapper iObjectWrapper, String str, int i) {
        Parcel zza = zza();
        com.google.android.gms.internal.common.zzc.zza(zza, iObjectWrapper);
        zza.writeString(str);
        zza.writeInt(i);
        Parcel a = a(4, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a.readStrongBinder());
        a.recycle();
        return asInterface;
    }
}
