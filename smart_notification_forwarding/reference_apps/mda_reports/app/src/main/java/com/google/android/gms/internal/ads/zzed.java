package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
final class zzed implements zzef {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzwz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzed(zzdx zzdxVar, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzwz = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzef
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzwz);
    }
}
