package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzczf extends zzark {
    private final zzczs zzfhh;

    @GuardedBy("this")
    private boolean zzgdg = false;
    private final zzcyt zzgkw;
    private final zzcxz zzgkx;

    @Nullable
    @GuardedBy("this")
    private zzcbb zzgky;

    public zzczf(zzcyt zzcytVar, zzcxz zzcxzVar, zzczs zzczsVar) {
        this.zzgkw = zzcytVar;
        this.zzgkx = zzcxzVar;
        this.zzfhh = zzczsVar;
    }

    private final synchronized boolean zzamp() {
        boolean z;
        if (this.zzgky != null) {
            z = this.zzgky.isClosed() ? false : true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void destroy() {
        zzl(null);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata can only be called from the UI thread.");
        zzcbb zzcbbVar = this.zzgky;
        return zzcbbVar != null ? zzcbbVar.getAdMetadata() : new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final synchronized String getMediationAdapterClassName() {
        if (this.zzgky == null || this.zzgky.zzags() == null) {
            return null;
        }
        return this.zzgky.zzags().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final boolean isLoaded() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzamp();
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void pause() {
        zzj(null);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void resume() {
        zzk(null);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void setAppPackageName(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final synchronized void setCustomData(String str) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcja)).booleanValue()) {
            Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setCustomData");
            this.zzfhh.zzdnw = str;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgdg = z;
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final synchronized void setUserId(String str) {
        Preconditions.checkMainThread("setUserId must be called on the main UI thread.");
        this.zzfhh.zzdnv = str;
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final synchronized void show() {
        zzi(null);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void zza(zzarj zzarjVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.: setRewardedAdSkuListener");
        this.zzgkx.zzb(zzarjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void zza(zzaro zzaroVar) {
        Preconditions.checkMainThread("setRewardedVideoAdListener can only be called from the UI thread.");
        this.zzgkx.zzb(zzaroVar);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final synchronized void zza(zzaru zzaruVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (zzzp.zzcp(zzaruVar.zzbqz)) {
            return;
        }
        if (zzamp()) {
            if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcor)).booleanValue()) {
                return;
            }
        }
        zzcyq zzcyqVar = new zzcyq(null);
        this.zzgky = null;
        this.zzgkw.zza(zzaruVar.zzdio, zzaruVar.zzbqz, zzcyqVar, new zzcze(this));
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final void zza(zzvx zzvxVar) {
        Preconditions.checkMainThread("setAdMetadataListener can only be called from the UI thread.");
        if (zzvxVar == null) {
            this.zzgkx.zza((AdMetadataListener) null);
        } else {
            this.zzgkx.zza(new zzczh(this, zzvxVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final synchronized void zzi(@Nullable IObjectWrapper iObjectWrapper) {
        Activity activity;
        Preconditions.checkMainThread("showAd must be called on the main UI thread.");
        if (this.zzgky == null) {
            return;
        }
        if (iObjectWrapper != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (unwrap instanceof Activity) {
                activity = (Activity) unwrap;
                this.zzgky.zzb(this.zzgdg, activity);
            }
        }
        activity = null;
        this.zzgky.zzb(this.zzgdg, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final synchronized void zzj(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgky != null) {
            this.zzgky.zzagr().zzbv(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final synchronized void zzk(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgky != null) {
            this.zzgky.zzagr().zzbw(iObjectWrapper == null ? null : (Context) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final synchronized zzxa zzkb() {
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcrf)).booleanValue()) {
            return null;
        }
        if (this.zzgky == null) {
            return null;
        }
        return this.zzgky.zzags();
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final synchronized void zzl(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        Context context = null;
        this.zzgkx.zza((AdMetadataListener) null);
        if (this.zzgky != null) {
            if (iObjectWrapper != null) {
                context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
            }
            this.zzgky.zzagr().zzbx(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarl
    public final boolean zzqa() {
        zzcbb zzcbbVar = this.zzgky;
        return zzcbbVar != null && zzcbbVar.zzqa();
    }
}
