package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* loaded from: classes.dex */
public final class zzceo implements AppEventListener, zzbov, zzbow, zzbpe, zzbph, zzbqb, zzbqx, zzdcx, zzty {
    private long startTime;
    private final List<Object> zzdvu;
    private final zzcec zzfti;

    public zzceo(zzcec zzcecVar, zzbfx zzbfxVar) {
        this.zzfti = zzcecVar;
        this.zzdvu = Collections.singletonList(zzbfxVar);
    }

    private final void zza(Class<?> cls, String str, Object... objArr) {
        zzcec zzcecVar = this.zzfti;
        List<Object> list = this.zzdvu;
        String valueOf = String.valueOf(cls.getSimpleName());
        zzcecVar.zza(list, valueOf.length() != 0 ? "Event-".concat(valueOf) : new String("Event-"), str, objArr);
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void onAdClicked() {
        zza(zzty.class, "onAdClicked", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdClosed() {
        zza(zzbov.class, "onAdClosed", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void onAdFailedToLoad(int i) {
        zza(zzbow.class, "onAdFailedToLoad", Integer.valueOf(i));
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final void onAdImpression() {
        zza(zzbpe.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdLeftApplication() {
        zza(zzbov.class, "onAdLeftApplication", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbqb
    public final void onAdLoaded() {
        long elapsedRealtime = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime() - this.startTime;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(elapsedRealtime);
        zzavs.zzed(sb.toString());
        zza(zzbqb.class, "onAdLoaded", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdOpened() {
        zza(zzbov.class, "onAdOpened", new Object[0]);
    }

    @Override // com.google.android.gms.ads.doubleclick.AppEventListener
    public final void onAppEvent(String str, String str2) {
        zza(AppEventListener.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoCompleted() {
        zza(zzbov.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoStarted() {
        zza(zzbov.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zza(zzdco zzdcoVar, String str) {
        zza(zzdcp.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zza(zzdco zzdcoVar, String str, Throwable th) {
        zza(zzdcp.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(zzaqk zzaqkVar) {
        this.startTime = com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime();
        zza(zzbqx.class, "onAdRequest", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    @ParametersAreNonnullByDefault
    public final void zzb(zzare zzareVar, String str, String str2) {
        zza(zzbov.class, "onRewarded", zzareVar, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(zzczt zzcztVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zzb(zzdco zzdcoVar, String str) {
        zza(zzdcp.class, "onTaskStarted", str);
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzbv(Context context) {
        zza(zzbph.class, "onPause", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzbw(Context context) {
        zza(zzbph.class, "onResume", context);
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzbx(Context context) {
        zza(zzbph.class, "onDestroy", context);
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zzc(zzdco zzdcoVar, String str) {
        zza(zzdcp.class, "onTaskSucceeded", str);
    }
}
