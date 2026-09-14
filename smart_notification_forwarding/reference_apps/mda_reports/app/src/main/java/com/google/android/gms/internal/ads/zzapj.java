package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.query.BannerQueryDataConfiguration;
import com.google.android.gms.ads.query.InterstitialQueryDataConfiguration;
import com.google.android.gms.ads.query.NativeQueryDataConfiguration;
import com.google.android.gms.ads.query.QueryDataConfiguration;
import com.google.android.gms.ads.query.QueryDataGenerationCallback;
import com.google.android.gms.ads.query.RewardedQueryDataConfiguration;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes.dex */
public final class zzapj {
    private final QueryDataConfiguration zzdic;

    public zzapj(QueryDataConfiguration queryDataConfiguration) {
        this.zzdic = queryDataConfiguration;
    }

    public final void zza(QueryDataGenerationCallback queryDataGenerationCallback) {
        Context context = this.zzdic.getContext();
        IObjectWrapper wrap = ObjectWrapper.wrap(context);
        try {
            zzauo zzf = ((zzaut) zzayx.zza(context, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzapi.a)).zzf(wrap, 12451009);
            String adUnitId = this.zzdic.getAdUnitId();
            QueryDataConfiguration queryDataConfiguration = this.zzdic;
            String str = queryDataConfiguration instanceof BannerQueryDataConfiguration ? "BANNER" : queryDataConfiguration instanceof InterstitialQueryDataConfiguration ? "INTERSTITIAL" : queryDataConfiguration instanceof NativeQueryDataConfiguration ? "NATIVE" : queryDataConfiguration instanceof RewardedQueryDataConfiguration ? "REWARDED" : "UNKNOWN";
            QueryDataConfiguration queryDataConfiguration2 = this.zzdic;
            try {
                zzf.zza(wrap, new zzauu(adUnitId, str, queryDataConfiguration2 instanceof BannerQueryDataConfiguration ? new zzuj(queryDataConfiguration2.getContext(), ((BannerQueryDataConfiguration) queryDataConfiguration2).getAdSize()) : queryDataConfiguration2 instanceof InterstitialQueryDataConfiguration ? new zzuj() : queryDataConfiguration2 instanceof NativeQueryDataConfiguration ? zzuj.zzg(queryDataConfiguration2.getContext()) : queryDataConfiguration2 instanceof RewardedQueryDataConfiguration ? zzuj.zzol() : new zzuj()), new zzapl(this, queryDataGenerationCallback));
            } catch (RemoteException unused) {
                queryDataGenerationCallback.onFailure("Internal Error.");
            }
        } catch (RemoteException | zzayz | NullPointerException unused2) {
            queryDataGenerationCallback.onFailure("Internal Error.");
        }
    }
}
