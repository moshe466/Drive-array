package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzeq extends com.google.android.gms.internal.measurement.zza implements zzeo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final List<zzkl> zza(zzm zzmVar, boolean z) {
        Parcel c = c();
        com.google.android.gms.internal.measurement.zzb.zza(c, zzmVar);
        com.google.android.gms.internal.measurement.zzb.zza(c, z);
        Parcel a = a(7, c);
        ArrayList createTypedArrayList = a.createTypedArrayList(zzkl.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final List<zzv> zza(String str, String str2, zzm zzmVar) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        com.google.android.gms.internal.measurement.zzb.zza(c, zzmVar);
        Parcel a = a(16, c);
        ArrayList createTypedArrayList = a.createTypedArrayList(zzv.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final List<zzv> zza(String str, String str2, String str3) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        c.writeString(str3);
        Parcel a = a(17, c);
        ArrayList createTypedArrayList = a.createTypedArrayList(zzv.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final List<zzkl> zza(String str, String str2, String str3, boolean z) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        c.writeString(str3);
        com.google.android.gms.internal.measurement.zzb.zza(c, z);
        Parcel a = a(15, c);
        ArrayList createTypedArrayList = a.createTypedArrayList(zzkl.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final List<zzkl> zza(String str, String str2, boolean z, zzm zzmVar) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        com.google.android.gms.internal.measurement.zzb.zza(c, z);
        com.google.android.gms.internal.measurement.zzb.zza(c, zzmVar);
        Parcel a = a(14, c);
        ArrayList createTypedArrayList = a.createTypedArrayList(zzkl.CREATOR);
        a.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final void zza(long j, String str, String str2, String str3) {
        Parcel c = c();
        c.writeLong(j);
        c.writeString(str);
        c.writeString(str2);
        c.writeString(str3);
        b(10, c);
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final void zza(zzan zzanVar, zzm zzmVar) {
        Parcel c = c();
        com.google.android.gms.internal.measurement.zzb.zza(c, zzanVar);
        com.google.android.gms.internal.measurement.zzb.zza(c, zzmVar);
        b(1, c);
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final void zza(zzan zzanVar, String str, String str2) {
        Parcel c = c();
        com.google.android.gms.internal.measurement.zzb.zza(c, zzanVar);
        c.writeString(str);
        c.writeString(str2);
        b(5, c);
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final void zza(zzkl zzklVar, zzm zzmVar) {
        Parcel c = c();
        com.google.android.gms.internal.measurement.zzb.zza(c, zzklVar);
        com.google.android.gms.internal.measurement.zzb.zza(c, zzmVar);
        b(2, c);
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final void zza(zzm zzmVar) {
        Parcel c = c();
        com.google.android.gms.internal.measurement.zzb.zza(c, zzmVar);
        b(4, c);
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final void zza(zzv zzvVar) {
        Parcel c = c();
        com.google.android.gms.internal.measurement.zzb.zza(c, zzvVar);
        b(13, c);
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final void zza(zzv zzvVar, zzm zzmVar) {
        Parcel c = c();
        com.google.android.gms.internal.measurement.zzb.zza(c, zzvVar);
        com.google.android.gms.internal.measurement.zzb.zza(c, zzmVar);
        b(12, c);
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final byte[] zza(zzan zzanVar, String str) {
        Parcel c = c();
        com.google.android.gms.internal.measurement.zzb.zza(c, zzanVar);
        c.writeString(str);
        Parcel a = a(9, c);
        byte[] createByteArray = a.createByteArray();
        a.recycle();
        return createByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final void zzb(zzm zzmVar) {
        Parcel c = c();
        com.google.android.gms.internal.measurement.zzb.zza(c, zzmVar);
        b(6, c);
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final String zzc(zzm zzmVar) {
        Parcel c = c();
        com.google.android.gms.internal.measurement.zzb.zza(c, zzmVar);
        Parcel a = a(11, c);
        String readString = a.readString();
        a.recycle();
        return readString;
    }

    @Override // com.google.android.gms.measurement.internal.zzeo
    public final void zzd(zzm zzmVar) {
        Parcel c = c();
        com.google.android.gms.internal.measurement.zzb.zza(c, zzmVar);
        b(18, c);
    }
}
