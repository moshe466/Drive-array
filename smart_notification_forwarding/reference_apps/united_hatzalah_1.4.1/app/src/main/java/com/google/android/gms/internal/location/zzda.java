package com.google.android.gms.internal.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes.dex */
public final class zzda extends GoogleApi implements SettingsClient {
    public static final /* synthetic */ int zza = 0;

    public zzda(Activity activity) {
        super(activity, (Api<Api.ApiOptions.NoOptions>) zzbi.zzb, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @Override // com.google.android.gms.location.SettingsClient
    public final Task<LocationSettingsResponse> checkLocationSettings(final LocationSettingsRequest locationSettingsRequest) {
        return doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.location.zzdb
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final /* synthetic */ void accept(Object obj, Object obj2) {
                boolean z3;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                zzdz zzdzVar = (zzdz) obj;
                LocationSettingsRequest locationSettingsRequest2 = LocationSettingsRequest.this;
                if (locationSettingsRequest2 != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkArgument(z3, "locationSettingsRequest can't be null");
                ((zzv) zzdzVar.getService()).zzD(locationSettingsRequest2, new zzde(taskCompletionSource), null);
            }
        }).setMethodKey(2426).build());
    }

    @Override // com.google.android.gms.location.SettingsClient
    public final Task<Boolean> isGoogleLocationAccuracyEnabled() {
        return doRead(TaskApiCall.builder().run(zzdc.zza).setMethodKey(2444).setFeatures(com.google.android.gms.location.zzo.zzm).build());
    }

    public zzda(Context context) {
        super(context, (Api<Api.ApiOptions.NoOptions>) zzbi.zzb, Api.ApiOptions.NO_OPTIONS, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
