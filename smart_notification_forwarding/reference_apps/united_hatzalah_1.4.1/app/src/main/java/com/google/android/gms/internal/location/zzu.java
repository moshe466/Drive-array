package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LastLocationRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.SleepSegmentRequest;

/* loaded from: classes.dex */
public final class zzu extends zza implements zzv {
    public zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzA(Location location) {
        Parcel zza = zza();
        zzc.zzb(zza, location);
        zzc(13, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzB(Location location, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzb(zza, location);
        zzc.zzc(zza, iStatusCallback);
        zzc(85, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzC(zzr zzrVar) {
        Parcel zza = zza();
        zzc.zzc(zza, zzrVar);
        zzc(67, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzD(LocationSettingsRequest locationSettingsRequest, zzab zzabVar, String str) {
        Parcel zza = zza();
        zzc.zzb(zza, locationSettingsRequest);
        zzc.zzc(zza, zzabVar);
        zza.writeString(null);
        zzc(63, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzE(zzo zzoVar) {
        Parcel zza = zza();
        zzc.zzc(zza, zzoVar);
        zzc(95, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzF(zzj zzjVar) {
        Parcel zza = zza();
        zzc.zzb(zza, zzjVar);
        zzc(75, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzd(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzt zztVar) {
        Parcel zza = zza();
        zzc.zzb(zza, geofencingRequest);
        zzc.zzb(zza, pendingIntent);
        zzc.zzc(zza, zztVar);
        zzc(57, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zze(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzb(zza, geofencingRequest);
        zzc.zzb(zza, pendingIntent);
        zzc.zzc(zza, iStatusCallback);
        zzc(97, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzf(zzem zzemVar, zzt zztVar) {
        Parcel zza = zza();
        zzc.zzb(zza, zzemVar);
        zzc.zzc(zza, zztVar);
        zzc(74, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzg(zzem zzemVar, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzb(zza, zzemVar);
        zzc.zzc(zza, iStatusCallback);
        zzc(98, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzh(long j2, boolean z3, PendingIntent pendingIntent) {
        Parcel zza = zza();
        zza.writeLong(j2);
        int i = zzc.zza;
        zza.writeInt(1);
        zzc.zzb(zza, pendingIntent);
        zzc(5, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzi(com.google.android.gms.location.zzb zzbVar, PendingIntent pendingIntent, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzb(zza, zzbVar);
        zzc.zzb(zza, pendingIntent);
        zzc.zzc(zza, iStatusCallback);
        zzc(70, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzj(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzb(zza, activityTransitionRequest);
        zzc.zzb(zza, pendingIntent);
        zzc.zzc(zza, iStatusCallback);
        zzc(72, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzk(PendingIntent pendingIntent, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzb(zza, pendingIntent);
        zzc.zzc(zza, iStatusCallback);
        zzc(73, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzl(PendingIntent pendingIntent) {
        Parcel zza = zza();
        zzc.zzb(zza, pendingIntent);
        zzc(6, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzm(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzb(zza, pendingIntent);
        zzc.zzb(zza, sleepSegmentRequest);
        zzc.zzc(zza, iStatusCallback);
        zzc(79, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzn(PendingIntent pendingIntent, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzb(zza, pendingIntent);
        zzc.zzc(zza, iStatusCallback);
        zzc(69, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzo(com.google.android.gms.location.zzad zzadVar, zzee zzeeVar) {
        Parcel zza = zza();
        zzc.zzb(zza, zzadVar);
        zzc.zzb(zza, zzeeVar);
        zzc(91, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final LocationAvailability zzp(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzb = zzb(34, zza);
        LocationAvailability locationAvailability = (LocationAvailability) zzc.zza(zzb, LocationAvailability.CREATOR);
        zzb.recycle();
        return locationAvailability;
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzq(LastLocationRequest lastLocationRequest, zzee zzeeVar) {
        Parcel zza = zza();
        zzc.zzb(zza, lastLocationRequest);
        zzc.zzb(zza, zzeeVar);
        zzc(90, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzr(LastLocationRequest lastLocationRequest, zzz zzzVar) {
        Parcel zza = zza();
        zzc.zzb(zza, lastLocationRequest);
        zzc.zzc(zza, zzzVar);
        zzc(82, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final Location zzs() {
        Parcel zzb = zzb(7, zza());
        Location location = (Location) zzc.zza(zzb, Location.CREATOR);
        zzb.recycle();
        return location;
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final ICancelToken zzt(CurrentLocationRequest currentLocationRequest, zzee zzeeVar) {
        Parcel zza = zza();
        zzc.zzb(zza, currentLocationRequest);
        zzc.zzb(zza, zzeeVar);
        Parcel zzb = zzb(92, zza);
        ICancelToken asInterface = ICancelToken.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final ICancelToken zzu(CurrentLocationRequest currentLocationRequest, zzz zzzVar) {
        Parcel zza = zza();
        zzc.zzb(zza, currentLocationRequest);
        zzc.zzc(zza, zzzVar);
        Parcel zzb = zzb(87, zza);
        ICancelToken asInterface = ICancelToken.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzv(zzei zzeiVar) {
        Parcel zza = zza();
        zzc.zzb(zza, zzeiVar);
        zzc(59, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzw(zzee zzeeVar, LocationRequest locationRequest, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzb(zza, zzeeVar);
        zzc.zzb(zza, locationRequest);
        zzc.zzc(zza, iStatusCallback);
        zzc(88, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzx(zzee zzeeVar, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        zzc.zzb(zza, zzeeVar);
        zzc.zzc(zza, iStatusCallback);
        zzc(89, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzy(boolean z3) {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc(12, zza);
    }

    @Override // com.google.android.gms.internal.location.zzv
    public final void zzz(boolean z3, IStatusCallback iStatusCallback) {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzc.zzc(zza, iStatusCallback);
        zzc(84, zza);
    }
}
