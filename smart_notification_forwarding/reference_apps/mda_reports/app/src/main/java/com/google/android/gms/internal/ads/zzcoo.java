package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbod;
import com.google.android.gms.internal.ads.zzbrm;
import java.util.Collections;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcoo extends zzvt implements zzbqt {
    private final ViewGroup zzfdu;
    private final zzbfx zzfzz;

    @Nullable
    @GuardedBy("this")
    private zzbkk zzgcp;
    private final Context zzgcr;
    private final zzbqp zzgcz;

    @Nullable
    @GuardedBy("this")
    private zzaak zzgda;

    @Nullable
    @GuardedBy("this")
    private zzdhe<zzbkk> zzgdb;
    private final zzcop zzgcw = new zzcop();
    private final zzcoq zzgcx = new zzcoq();
    private final zzcos zzgcy = new zzcos();

    @GuardedBy("this")
    private final zzczw zzgcs = new zzczw();

    public zzcoo(zzbfx zzbfxVar, Context context, zzuj zzujVar, String str) {
        this.zzfdu = new FrameLayout(context);
        this.zzfzz = zzbfxVar;
        this.zzgcr = context;
        this.zzgcs.zzd(zzujVar).zzgk(str);
        this.zzgcz = zzbfxVar.zzace();
        this.zzgcz.zza(this, this.zzfzz.zzaca());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzdhe a(zzcoo zzcooVar, zzdhe zzdheVar) {
        zzcooVar.zzgdb = null;
        return null;
    }

    private final synchronized zzblg zzb(zzczu zzczuVar) {
        return this.zzfzz.zzach().zzc(new zzbod.zza().zzbz(this.zzgcr).zza(zzczuVar).zzahh()).zzc(new zzbrm.zza().zza((zzty) this.zzgcw, this.zzfzz.zzaca()).zza(this.zzgcx, this.zzfzz.zzaca()).zza((zzbov) this.zzgcw, this.zzfzz.zzaca()).zza((zzbqb) this.zzgcw, this.zzfzz.zzaca()).zza((zzbow) this.zzgcw, this.zzfzz.zzaca()).zza(this.zzgcy, this.zzfzz.zzaca()).zzahw()).zza(new zzcns(this.zzgda)).zzb(new zzbvi(zzbwz.zzfmx, null)).zza(new zzbma(this.zzgcz)).zzb(new zzbkf(this.zzfdu)).zzaee();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.zzgcp != null) {
            this.zzgcp.destroy();
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
        if (this.zzgcp == null || this.zzgcp.zzags() == null) {
            return null;
        }
        return this.zzgcp.zzags().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized zzxb getVideoController() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        if (this.zzgcp == null) {
            return null;
        }
        return this.zzgcp.getVideoController();
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
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        if (this.zzgcp != null) {
            this.zzgcp.zzagr().zzbv(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        if (this.zzgcp != null) {
            this.zzgcp.zzagr().zzbw(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void setImmersiveMode(boolean z) {
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
    public final void showInterstitial() {
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
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzrg zzrgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void zza(zzuj zzujVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzgcs.zzd(zzujVar);
        if (this.zzgcp != null) {
            this.zzgcp.zza(this.zzfdu, zzujVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzuo zzuoVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvg zzvgVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzgcx.zzb(zzvgVar);
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
        Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        this.zzgcs.zzc(zzywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized boolean zza(zzug zzugVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (this.zzgdb != null) {
            return false;
        }
        zzdad.zze(this.zzgcr, zzugVar.zzccb);
        zzczu zzaos = this.zzgcs.zzg(zzugVar).zzaos();
        if (zzabe.zzcub.get().booleanValue() && this.zzgcs.zzjz().zzccs && this.zzgcw != null) {
            this.zzgcw.onAdFailedToLoad(1);
            return false;
        }
        zzblg zzb = zzb(zzaos);
        this.zzgdb = zzb.zzadc().zzaha();
        zzdgs.zza(this.zzgdb, new zzcon(this, zzb), this.zzfzz.zzaca());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbqt
    public final synchronized void zzahl() {
        boolean zza;
        Object parent = this.zzfdu.getParent();
        if (parent instanceof View) {
            View view = (View) parent;
            zza = com.google.android.gms.ads.internal.zzq.zzkq().zza(view, view.getContext());
        } else {
            zza = false;
        }
        if (zza) {
            zza(this.zzgcs.zzaoq());
        } else {
            this.zzgcz.zzdg(60);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zzbr(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final IObjectWrapper zzjx() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfdu);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void zzjy() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        if (this.zzgcp != null) {
            this.zzgcp.zzjy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized zzuj zzjz() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.zzgcp != null) {
            return zzczy.zza(this.zzgcr, (List<zzczk>) Collections.singletonList(this.zzgcp.zzafz()));
        }
        return this.zzgcs.zzjz();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized String zzka() {
        if (this.zzgcp == null || this.zzgcp.zzags() == null) {
            return null;
        }
        return this.zzgcp.zzags().getMediationAdapterClassName();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized zzxa zzkb() {
        if (!((Boolean) zzve.zzoy().zzd(zzzn.zzcrf)).booleanValue()) {
            return null;
        }
        if (this.zzgcp == null) {
            return null;
        }
        return this.zzgcp.zzags();
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
