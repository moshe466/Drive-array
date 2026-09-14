package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IInterface;
import java.util.Map;

/* loaded from: classes.dex */
public interface qf extends IInterface {
    void beginAdUnitExposure(String str, long j10);

    void clearConditionalUserProperty(String str, String str2, Bundle bundle);

    void clearMeasurementEnabled(long j10);

    void endAdUnitExposure(String str, long j10);

    void generateEventId(rf rfVar);

    void getAppInstanceId(rf rfVar);

    void getCachedAppInstanceId(rf rfVar);

    void getConditionalUserProperties(String str, String str2, rf rfVar);

    void getCurrentScreenClass(rf rfVar);

    void getCurrentScreenName(rf rfVar);

    void getGmpAppId(rf rfVar);

    void getMaxUserProperties(String str, rf rfVar);

    void getTestFlag(rf rfVar, int i10);

    void getUserProperties(String str, String str2, boolean z10, rf rfVar);

    void initForTests(Map map);

    void initialize(j2.a aVar, f fVar, long j10);

    void isDataCollectionEnabled(rf rfVar);

    void logEvent(String str, String str2, Bundle bundle, boolean z10, boolean z11, long j10);

    void logEventAndBundle(String str, String str2, Bundle bundle, rf rfVar, long j10);

    void logHealthData(int i10, String str, j2.a aVar, j2.a aVar2, j2.a aVar3);

    void onActivityCreated(j2.a aVar, Bundle bundle, long j10);

    void onActivityDestroyed(j2.a aVar, long j10);

    void onActivityPaused(j2.a aVar, long j10);

    void onActivityResumed(j2.a aVar, long j10);

    void onActivitySaveInstanceState(j2.a aVar, rf rfVar, long j10);

    void onActivityStarted(j2.a aVar, long j10);

    void onActivityStopped(j2.a aVar, long j10);

    void performAction(Bundle bundle, rf rfVar, long j10);

    void registerOnMeasurementEventListener(c cVar);

    void resetAnalyticsData(long j10);

    void setConditionalUserProperty(Bundle bundle, long j10);

    void setConsent(Bundle bundle, long j10);

    void setConsentThirdParty(Bundle bundle, long j10);

    void setCurrentScreen(j2.a aVar, String str, String str2, long j10);

    void setDataCollectionEnabled(boolean z10);

    void setDefaultEventParameters(Bundle bundle);

    void setEventInterceptor(c cVar);

    void setInstanceIdProvider(d dVar);

    void setMeasurementEnabled(boolean z10, long j10);

    void setMinimumSessionDuration(long j10);

    void setSessionTimeoutDuration(long j10);

    void setUserId(String str, long j10);

    void setUserProperty(String str, String str2, j2.a aVar, boolean z10, long j10);

    void unregisterOnMeasurementEventListener(c cVar);
}
