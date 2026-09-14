package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class sf extends a implements qf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public sf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void beginAdUnitExposure(String str, long j10) {
        Parcel i10 = i();
        i10.writeString(str);
        i10.writeLong(j10);
        p(23, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        Parcel i10 = i();
        i10.writeString(str);
        i10.writeString(str2);
        v.c(i10, bundle);
        p(9, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void endAdUnitExposure(String str, long j10) {
        Parcel i10 = i();
        i10.writeString(str);
        i10.writeLong(j10);
        p(24, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void generateEventId(rf rfVar) {
        Parcel i10 = i();
        v.b(i10, rfVar);
        p(22, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void getCachedAppInstanceId(rf rfVar) {
        Parcel i10 = i();
        v.b(i10, rfVar);
        p(19, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void getConditionalUserProperties(String str, String str2, rf rfVar) {
        Parcel i10 = i();
        i10.writeString(str);
        i10.writeString(str2);
        v.b(i10, rfVar);
        p(10, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void getCurrentScreenClass(rf rfVar) {
        Parcel i10 = i();
        v.b(i10, rfVar);
        p(17, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void getCurrentScreenName(rf rfVar) {
        Parcel i10 = i();
        v.b(i10, rfVar);
        p(16, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void getGmpAppId(rf rfVar) {
        Parcel i10 = i();
        v.b(i10, rfVar);
        p(21, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void getMaxUserProperties(String str, rf rfVar) {
        Parcel i10 = i();
        i10.writeString(str);
        v.b(i10, rfVar);
        p(6, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void getUserProperties(String str, String str2, boolean z10, rf rfVar) {
        Parcel i10 = i();
        i10.writeString(str);
        i10.writeString(str2);
        v.d(i10, z10);
        v.b(i10, rfVar);
        p(5, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void initialize(j2.a aVar, f fVar, long j10) {
        Parcel i10 = i();
        v.b(i10, aVar);
        v.c(i10, fVar);
        i10.writeLong(j10);
        p(1, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10) {
        Parcel i10 = i();
        i10.writeString(str);
        i10.writeString(str2);
        v.c(i10, bundle);
        v.d(i10, z10);
        v.d(i10, z11);
        i10.writeLong(j10);
        p(2, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void logHealthData(int i10, String str, j2.a aVar, j2.a aVar2, j2.a aVar3) {
        Parcel i11 = i();
        i11.writeInt(i10);
        i11.writeString(str);
        v.b(i11, aVar);
        v.b(i11, aVar2);
        v.b(i11, aVar3);
        p(33, i11);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void onActivityCreated(j2.a aVar, Bundle bundle, long j10) {
        Parcel i10 = i();
        v.b(i10, aVar);
        v.c(i10, bundle);
        i10.writeLong(j10);
        p(27, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void onActivityDestroyed(j2.a aVar, long j10) {
        Parcel i10 = i();
        v.b(i10, aVar);
        i10.writeLong(j10);
        p(28, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void onActivityPaused(j2.a aVar, long j10) {
        Parcel i10 = i();
        v.b(i10, aVar);
        i10.writeLong(j10);
        p(29, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void onActivityResumed(j2.a aVar, long j10) {
        Parcel i10 = i();
        v.b(i10, aVar);
        i10.writeLong(j10);
        p(30, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void onActivitySaveInstanceState(j2.a aVar, rf rfVar, long j10) {
        Parcel i10 = i();
        v.b(i10, aVar);
        v.b(i10, rfVar);
        i10.writeLong(j10);
        p(31, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void onActivityStarted(j2.a aVar, long j10) {
        Parcel i10 = i();
        v.b(i10, aVar);
        i10.writeLong(j10);
        p(25, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void onActivityStopped(j2.a aVar, long j10) {
        Parcel i10 = i();
        v.b(i10, aVar);
        i10.writeLong(j10);
        p(26, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void registerOnMeasurementEventListener(c cVar) {
        Parcel i10 = i();
        v.b(i10, cVar);
        p(35, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void setConditionalUserProperty(Bundle bundle, long j10) {
        Parcel i10 = i();
        v.c(i10, bundle);
        i10.writeLong(j10);
        p(8, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void setCurrentScreen(j2.a aVar, String str, String str2, long j10) {
        Parcel i10 = i();
        v.b(i10, aVar);
        i10.writeString(str);
        i10.writeString(str2);
        i10.writeLong(j10);
        p(15, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void setDataCollectionEnabled(boolean z10) {
        Parcel i10 = i();
        v.d(i10, z10);
        p(39, i10);
    }

    @Override // com.google.android.gms.internal.measurement.qf
    public final void setUserProperty(String str, String str2, j2.a aVar, boolean z10, long j10) {
        Parcel i10 = i();
        i10.writeString(str);
        i10.writeString(str2);
        v.b(i10, aVar);
        v.d(i10, z10);
        i10.writeLong(j10);
        p(4, i10);
    }
}
