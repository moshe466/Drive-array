package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* loaded from: classes.dex */
final class zzqb implements zzqd {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzwz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzqb(zzpv zzpvVar, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzwz = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivitySaveInstanceState(this.val$activity, this.zzwz);
    }
}
