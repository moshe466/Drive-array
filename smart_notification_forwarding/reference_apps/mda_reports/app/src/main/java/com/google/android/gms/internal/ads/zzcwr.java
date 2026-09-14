package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcwr extends zzvt implements com.google.android.gms.ads.internal.overlay.zzy, zzbqg, zzra {

    @Nullable
    @GuardedBy("this")
    protected zzbke a;
    private final zzazb zzbli;
    private final String zzbqz;
    private final ViewGroup zzfdu;
    private final zzbfx zzfzz;
    private final Context zzgcr;
    private AtomicBoolean zzgiv = new AtomicBoolean();
    private final zzcwl zzgiw;
    private final zzcwz zzgix;

    @Nullable
    private zzbju zzgiy;

    public zzcwr(zzbfx zzbfxVar, Context context, String str, zzcwl zzcwlVar, zzcwz zzcwzVar, zzazb zzazbVar) {
        this.zzfdu = new FrameLayout(context);
        this.zzfzz = zzbfxVar;
        this.zzgcr = context;
        this.zzbqz = str;
        this.zzgiw = zzcwlVar;
        this.zzgix = zzcwzVar;
        zzcwzVar.zza(this);
        this.zzbli = zzazbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.google.android.gms.ads.internal.overlay.zzq zza(zzbke zzbkeVar) {
        boolean zzaat = zzbkeVar.zzaat();
        int intValue = ((Integer) zzve.zzoy().zzd(zzzn.zzcnv)).intValue();
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = new com.google.android.gms.ads.internal.overlay.zzp();
        zzpVar.size = 50;
        zzpVar.paddingLeft = zzaat ? intValue : 0;
        zzpVar.paddingRight = zzaat ? 0 : intValue;
        zzpVar.paddingTop = 0;
        zzpVar.paddingBottom = intValue;
        return new com.google.android.gms.ads.internal.overlay.zzq(this.zzgcr, zzpVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzaoc, reason: merged with bridge method [inline-methods] */
    public final void d() {
        if (this.zzgiv.compareAndSet(false, true)) {
            zzbke zzbkeVar = this.a;
            if (zzbkeVar != null && zzbkeVar.zzagc() != null) {
                this.zzgix.zzb(this.a.zzagc());
            }
            this.zzgix.onAdClosed();
            this.zzfdu.removeAllViews();
            zzbju zzbjuVar = this.zzgiy;
            if (zzbjuVar != null) {
                com.google.android.gms.ads.internal.zzq.zzkt().zzb(zzbjuVar);
            }
            destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzuj zzaod() {
        return zzczy.zza(this.zzgcr, (List<zzczk>) Collections.singletonList(this.a.zzafz()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RelativeLayout.LayoutParams zzb(zzbke zzbkeVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(zzbkeVar.zzaat() ? 11 : 9);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzc(zzbke zzbkeVar) {
        zzbkeVar.zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        this.zzfzz.zzaca().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcwq
            private final zzcwr zzgiu;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgiu = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgiu.d();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        if (this.a != null) {
            this.a.destroy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final Bundle getAdMetadata() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized String getAdUnitId() {
        return this.zzbqz;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized String getMediationAdapterClassName() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized zzxb getVideoController() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized boolean isLoading() {
        return this.zzgiw.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final boolean isReady() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void setImmersiveMode(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void setManualImpressionsEnabled(boolean z) {
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
        this.zzgix.zzb(zzrgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void zza(zzuj zzujVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzuo zzuoVar) {
        this.zzgiw.zza(zzuoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvg zzvgVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvh zzvhVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzvx zzvxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzwc zzwcVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void zza(zzwi zzwiVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zza(zzxh zzxhVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void zza(zzyw zzywVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized boolean zza(zzug zzugVar) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (isLoading()) {
            return false;
        }
        this.zzgiv = new AtomicBoolean();
        return this.zzgiw.zza(zzugVar, this.zzbqz, new zzcws(this), new zzcwv(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zzahi() {
        int zzafw;
        zzbke zzbkeVar = this.a;
        if (zzbkeVar != null && (zzafw = zzbkeVar.zzafw()) > 0) {
            this.zzgiy = new zzbju(this.zzfzz.zzacb(), com.google.android.gms.ads.internal.zzq.zzkx());
            this.zzgiy.zza(zzafw, new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcwt
                private final zzcwr zzgiu;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzgiu = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgiu.c();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final void zzbr(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final IObjectWrapper zzjx() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzfdu);
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized void zzjy() {
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized zzuj zzjz() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        if (this.a == null) {
            return null;
        }
        return zzczy.zza(this.zzgcr, (List<zzczk>) Collections.singletonList(this.a.zzafz()));
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized String zzka() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final synchronized zzxa zzkb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzwc zzkc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzvu
    public final zzvh zzkd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzra
    public final void zzmm() {
        d();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzy
    public final void zztl() {
        d();
    }
}
