package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzakr extends zzbft {
    private final AppMeasurementSdk zzdbj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzakr(AppMeasurementSdk appMeasurementSdk) {
        this.zzdbj = appMeasurementSdk;
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void beginAdUnitExposure(String str) {
        this.zzdbj.beginAdUnitExposure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zzdbj.clearConditionalUserProperty(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void endAdUnitExposure(String str) {
        this.zzdbj.endAdUnitExposure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final long generateEventId() {
        return this.zzdbj.generateEventId();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final String getAppIdOrigin() {
        return this.zzdbj.getAppIdOrigin();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final String getAppInstanceId() {
        return this.zzdbj.getAppInstanceId();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final List getConditionalUserProperties(String str, String str2) {
        return this.zzdbj.getConditionalUserProperties(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final String getCurrentScreenClass() {
        return this.zzdbj.getCurrentScreenClass();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final String getCurrentScreenName() {
        return this.zzdbj.getCurrentScreenName();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final String getGmpAppId() {
        return this.zzdbj.getGmpAppId();
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final int getMaxUserProperties(String str) {
        return this.zzdbj.getMaxUserProperties(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final Map getUserProperties(String str, String str2, boolean z) {
        return this.zzdbj.getUserProperties(str, str2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void logEvent(String str, String str2, Bundle bundle) {
        this.zzdbj.logEvent(str, str2, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void performAction(Bundle bundle) {
        this.zzdbj.performAction(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final Bundle performActionWithResponse(Bundle bundle) {
        return this.zzdbj.performActionWithResponse(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void setConditionalUserProperty(Bundle bundle) {
        this.zzdbj.setConditionalUserProperty(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zza(String str, String str2, IObjectWrapper iObjectWrapper) {
        this.zzdbj.setUserProperty(str, str2, iObjectWrapper != null ? ObjectWrapper.unwrap(iObjectWrapper) : null);
    }

    @Override // com.google.android.gms.internal.ads.zzbfq
    public final void zzb(IObjectWrapper iObjectWrapper, String str, String str2) {
        this.zzdbj.setCurrentScreen(iObjectWrapper != null ? (Activity) ObjectWrapper.unwrap(iObjectWrapper) : null, str, str2);
    }
}
