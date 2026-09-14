package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbod;
import com.google.android.gms.internal.ads.zzbrm;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcor extends zzvt {
    private final Executor zzfci;
    private final zzbfx zzfzz;
    private final Context zzgcr;

    @Nullable
    @GuardedBy("this")
    private zzaak zzgda;

    @Nullable
    @GuardedBy("this")
    private zzdhe<zzbtu> zzgdb;

    @Nullable
    @GuardedBy("this")
    private zzbtu zzgdf;
    private final zzcop zzgcw = new zzcop();
    private final zzcos zzgcy = new zzcos();
    private final zzcxz zzgde = new zzcxz(new zzdax());

    @GuardedBy("this")
    private final zzczw zzgcs = new zzczw();

    @GuardedBy("this")
    private boolean zzgdg = false;

    public zzcor(zzbfx zzbfxVar, Context context, zzuj zzujVar, String str) {
        this.zzfzz = zzbfxVar;
        this.zzgcs.zzd(zzujVar).zzgk(str);
        this.zzfci = zzbfxVar.zzaca();
        this.zzgcr = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzdhe a(zzcor zzcorVar, zzdhe zzdheVar) {
        zzcorVar.zzgdb = null;
        return null;
    }

    private final synchronized boolean zzamp() {
        boolean z;
        if (this.zzgdf != null) {
            z = this.zzgdf.isClosed() ? false : true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgdf != null) {
            this.zzgdf.zzagr().zzbx(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final Bundle getAdMetadata() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized String getAdUnitId() {
        return this.zzgcs.zzaor();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized String getMediationAdapterClassName() {
        if (this.zzgdf == null || this.zzgdf.zzags() == null) {
            return null;
        }
        return this.zzgdf.zzags().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzxb getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized boolean isLoading() {
        boolean z;
        if (this.zzgdb != null) {
            z = this.zzgdb.isDone() ? false : true;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized boolean isReady() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzamp();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgdf != null) {
            this.zzgdf.zzagr().zzbv(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgdf != null) {
            this.zzgdf.zzagr().zzbw(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void setImmersiveMode(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzgdg = z;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void setManualImpressionsEnabled(boolean z) {
        Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        this.zzgcs.zzbm(z);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void setUserId(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void showInterstitial() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.zzgdf == null) {
            return;
        }
        if (this.zzgdf.zzaid()) {
            this.zzgdf.zzbg(this.zzgdg);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void stopLoading() {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void zza(zzaak zzaakVar) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzgda = zzaakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzaoy zzaoyVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzape zzapeVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzaro zzaroVar) {
        this.zzgde.zzb(zzaroVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzrg zzrgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzuj zzujVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzuo zzuoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvg zzvgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvh zzvhVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgcw.zzc(zzvhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvx zzvxVar) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzwc zzwcVar) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzgcy.zzb(zzwcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void zza(zzwi zzwiVar) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzgcs.zzc(zzwiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzxh zzxhVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void zza(zzyw zzywVar) {
        this.zzgcs.zzc(zzywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized boolean zza(zzug zzugVar) {
        boolean z;
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (this.zzgdb == null && !zzamp()) {
            zzdad.zze(this.zzgcr, zzugVar.zzccb);
            this.zzgdf = null;
            zzczu zzaos = this.zzgcs.zzg(zzugVar).zzaos();
            zzbrm.zza zzaVar = new zzbrm.zza();
            if (this.zzgde != null) {
                zzaVar.zza((zzbov) this.zzgde, this.zzfzz.zzaca()).zza((zzbqb) this.zzgde, this.zzfzz.zzaca()).zza((zzbow) this.zzgde, this.zzfzz.zzaca());
            }
            zzbup zzaek = this.zzfzz.zzack().zzd(new zzbod.zza().zzbz(this.zzgcr).zza(zzaos).zzahh()).zzd(zzaVar.zza((zzbov) this.zzgcw, this.zzfzz.zzaca()).zza((zzbqb) this.zzgcw, this.zzfzz.zzaca()).zza((zzbow) this.zzgcw, this.zzfzz.zzaca()).zza((zzty) this.zzgcw, this.zzfzz.zzaca()).zza(this.zzgcy, this.zzfzz.zzaca()).zzahw()).zzb(new zzcns(this.zzgda)).zzaek();
            this.zzgdb = zzaek.zzadc().zzaha();
            zzdgs.zza(this.zzgdb, new zzcou(this, zzaek), this.zzfci);
            z = true;
        }
        z = false;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zzbr(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final IObjectWrapper zzjx() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zzjy() {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzuj zzjz() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized String zzka() {
        if (this.zzgdf == null || this.zzgdf.zzags() == null) {
            return null;
        }
        return this.zzgdf.zzags().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized zzxa zzkb() {
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcrf)).booleanValue()) {
            return null;
        }
        if (this.zzgdf == null) {
            return null;
        }
        return this.zzgdf.zzags();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzwc zzkc() {
        return this.zzgcy.zzamq();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzvh zzkd() {
        return this.zzgcw.zzamo();
    }
}
