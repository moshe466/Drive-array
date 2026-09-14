package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzo extends zza implements zzm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void beginAdUnitExposure(String str, long j) {
        Parcel c = c();
        c.writeString(str);
        c.writeLong(j);
        b(23, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        zzb.zza(c, bundle);
        b(9, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void endAdUnitExposure(String str, long j) {
        Parcel c = c();
        c.writeString(str);
        c.writeLong(j);
        b(24, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void generateEventId(zzn zznVar) {
        Parcel c = c();
        zzb.zza(c, zznVar);
        b(22, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getAppInstanceId(zzn zznVar) {
        Parcel c = c();
        zzb.zza(c, zznVar);
        b(20, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getCachedAppInstanceId(zzn zznVar) {
        Parcel c = c();
        zzb.zza(c, zznVar);
        b(19, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getConditionalUserProperties(String str, String str2, zzn zznVar) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        zzb.zza(c, zznVar);
        b(10, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getCurrentScreenClass(zzn zznVar) {
        Parcel c = c();
        zzb.zza(c, zznVar);
        b(17, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getCurrentScreenName(zzn zznVar) {
        Parcel c = c();
        zzb.zza(c, zznVar);
        b(16, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getGmpAppId(zzn zznVar) {
        Parcel c = c();
        zzb.zza(c, zznVar);
        b(21, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getMaxUserProperties(String str, zzn zznVar) {
        Parcel c = c();
        c.writeString(str);
        zzb.zza(c, zznVar);
        b(6, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getTestFlag(zzn zznVar, int i) {
        Parcel c = c();
        zzb.zza(c, zznVar);
        c.writeInt(i);
        b(38, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getUserProperties(String str, String str2, boolean z, zzn zznVar) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        zzb.zza(c, z);
        zzb.zza(c, zznVar);
        b(5, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void initForTests(Map map) {
        Parcel c = c();
        c.writeMap(map);
        b(37, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void initialize(IObjectWrapper iObjectWrapper, zzv zzvVar, long j) {
        Parcel c = c();
        zzb.zza(c, iObjectWrapper);
        zzb.zza(c, zzvVar);
        c.writeLong(j);
        b(1, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void isDataCollectionEnabled(zzn zznVar) {
        Parcel c = c();
        zzb.zza(c, zznVar);
        b(40, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        zzb.zza(c, bundle);
        zzb.zza(c, z);
        zzb.zza(c, z2);
        c.writeLong(j);
        b(2, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void logEventAndBundle(String str, String str2, Bundle bundle, zzn zznVar, long j) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        zzb.zza(c, bundle);
        zzb.zza(c, zznVar);
        c.writeLong(j);
        b(3, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void logHealthData(int i, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        Parcel c = c();
        c.writeInt(i);
        c.writeString(str);
        zzb.zza(c, iObjectWrapper);
        zzb.zza(c, iObjectWrapper2);
        zzb.zza(c, iObjectWrapper3);
        b(33, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j) {
        Parcel c = c();
        zzb.zza(c, iObjectWrapper);
        zzb.zza(c, bundle);
        c.writeLong(j);
        b(27, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j) {
        Parcel c = c();
        zzb.zza(c, iObjectWrapper);
        c.writeLong(j);
        b(28, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j) {
        Parcel c = c();
        zzb.zza(c, iObjectWrapper);
        c.writeLong(j);
        b(29, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j) {
        Parcel c = c();
        zzb.zza(c, iObjectWrapper);
        c.writeLong(j);
        b(30, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzn zznVar, long j) {
        Parcel c = c();
        zzb.zza(c, iObjectWrapper);
        zzb.zza(c, zznVar);
        c.writeLong(j);
        b(31, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j) {
        Parcel c = c();
        zzb.zza(c, iObjectWrapper);
        c.writeLong(j);
        b(25, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j) {
        Parcel c = c();
        zzb.zza(c, iObjectWrapper);
        c.writeLong(j);
        b(26, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void performAction(Bundle bundle, zzn zznVar, long j) {
        Parcel c = c();
        zzb.zza(c, bundle);
        zzb.zza(c, zznVar);
        c.writeLong(j);
        b(32, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void registerOnMeasurementEventListener(zzs zzsVar) {
        Parcel c = c();
        zzb.zza(c, zzsVar);
        b(35, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void resetAnalyticsData(long j) {
        Parcel c = c();
        c.writeLong(j);
        b(12, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setConditionalUserProperty(Bundle bundle, long j) {
        Parcel c = c();
        zzb.zza(c, bundle);
        c.writeLong(j);
        b(8, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j) {
        Parcel c = c();
        zzb.zza(c, iObjectWrapper);
        c.writeString(str);
        c.writeString(str2);
        c.writeLong(j);
        b(15, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setDataCollectionEnabled(boolean z) {
        Parcel c = c();
        zzb.zza(c, z);
        b(39, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setEventInterceptor(zzs zzsVar) {
        Parcel c = c();
        zzb.zza(c, zzsVar);
        b(34, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setInstanceIdProvider(zzt zztVar) {
        Parcel c = c();
        zzb.zza(c, zztVar);
        b(18, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setMeasurementEnabled(boolean z, long j) {
        Parcel c = c();
        zzb.zza(c, z);
        c.writeLong(j);
        b(11, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setMinimumSessionDuration(long j) {
        Parcel c = c();
        c.writeLong(j);
        b(13, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setSessionTimeoutDuration(long j) {
        Parcel c = c();
        c.writeLong(j);
        b(14, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setUserId(String str, long j) {
        Parcel c = c();
        c.writeString(str);
        c.writeLong(j);
        b(7, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j) {
        Parcel c = c();
        c.writeString(str);
        c.writeString(str2);
        zzb.zza(c, iObjectWrapper);
        zzb.zza(c, z);
        c.writeLong(j);
        b(4, c);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void unregisterOnMeasurementEventListener(zzs zzsVar) {
        Parcel c = c();
        zzb.zza(c, zzsVar);
        b(36, c);
    }
}
