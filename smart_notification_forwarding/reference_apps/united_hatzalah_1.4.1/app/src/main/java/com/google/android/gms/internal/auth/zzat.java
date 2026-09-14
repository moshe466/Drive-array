package com.google.android.gms.internal.auth;

import android.os.IInterface;
import com.google.android.gms.auth.api.accounttransfer.DeviceMetaData;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public interface zzat extends IInterface {
    void zzb(byte[] bArr);

    void zzc(DeviceMetaData deviceMetaData);

    void zzd(Status status);

    void zze();

    void zzf(Status status, com.google.android.gms.auth.api.accounttransfer.zzw zzwVar);

    void zzg(Status status, com.google.android.gms.auth.api.accounttransfer.zzo zzoVar);

    void zzh(Status status);
}
