package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
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
public interface zzv extends IInterface {
    @Deprecated
    void zzA(Location location);

    void zzB(Location location, IStatusCallback iStatusCallback);

    void zzC(zzr zzrVar);

    void zzD(LocationSettingsRequest locationSettingsRequest, zzab zzabVar, String str);

    void zzE(zzo zzoVar);

    void zzF(zzj zzjVar);

    @Deprecated
    void zzd(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzt zztVar);

    void zze(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    @Deprecated
    void zzf(zzem zzemVar, zzt zztVar);

    void zzg(zzem zzemVar, IStatusCallback iStatusCallback);

    void zzh(long j2, boolean z3, PendingIntent pendingIntent);

    void zzi(com.google.android.gms.location.zzb zzbVar, PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzj(ActivityTransitionRequest activityTransitionRequest, PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzk(PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzl(PendingIntent pendingIntent);

    void zzm(PendingIntent pendingIntent, SleepSegmentRequest sleepSegmentRequest, IStatusCallback iStatusCallback);

    void zzn(PendingIntent pendingIntent, IStatusCallback iStatusCallback);

    void zzo(com.google.android.gms.location.zzad zzadVar, zzee zzeeVar);

    @Deprecated
    LocationAvailability zzp(String str);

    void zzq(LastLocationRequest lastLocationRequest, zzee zzeeVar);

    @Deprecated
    void zzr(LastLocationRequest lastLocationRequest, zzz zzzVar);

    @Deprecated
    Location zzs();

    ICancelToken zzt(CurrentLocationRequest currentLocationRequest, zzee zzeeVar);

    @Deprecated
    ICancelToken zzu(CurrentLocationRequest currentLocationRequest, zzz zzzVar);

    @Deprecated
    void zzv(zzei zzeiVar);

    void zzw(zzee zzeeVar, LocationRequest locationRequest, IStatusCallback iStatusCallback);

    void zzx(zzee zzeeVar, IStatusCallback iStatusCallback);

    @Deprecated
    void zzy(boolean z3);

    void zzz(boolean z3, IStatusCallback iStatusCallback);
}
