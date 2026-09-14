package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class zzxl {
    private final zzuh zzaba;
    private VideoOptions zzbka;
    private boolean zzbkh;
    private AppEventListener zzbkj;
    private zzvu zzbqy;
    private String zzbqz;
    private final zzakz zzbrb;
    private zzty zzcbt;
    private AdListener zzcbw;
    private AdSize[] zzcdf;
    private final AtomicBoolean zzcek;
    private final VideoController zzcel;

    @VisibleForTesting
    private final zzvd zzcem;
    private OnCustomRenderedAdLoadedListener zzcen;
    private ViewGroup zzceo;
    private int zzcep;

    public zzxl(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzuh.zzccn, 0);
    }

    public zzxl(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzuh.zzccn, i);
    }

    public zzxl(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzuh.zzccn, 0);
    }

    public zzxl(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzuh.zzccn, i);
    }

    @VisibleForTesting
    private zzxl(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzuh zzuhVar, int i) {
        this(viewGroup, attributeSet, z, zzuhVar, null, i);
    }

    @VisibleForTesting
    private zzxl(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzuh zzuhVar, zzvu zzvuVar, int i) {
        zzuj zzujVar;
        this.zzbrb = new zzakz();
        this.zzcel = new VideoController();
        this.zzcem = new zzxo(this);
        this.zzceo = viewGroup;
        this.zzaba = zzuhVar;
        this.zzbqy = null;
        this.zzcek = new AtomicBoolean(false);
        this.zzcep = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzuq zzuqVar = new zzuq(context, attributeSet);
                this.zzcdf = zzuqVar.zzy(z);
                this.zzbqz = zzuqVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzayk zzou = zzve.zzou();
                    AdSize adSize = this.zzcdf[0];
                    int i2 = this.zzcep;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzujVar = zzuj.zzon();
                    } else {
                        zzuj zzujVar2 = new zzuj(context, adSize);
                        zzujVar2.zzccr = zzck(i2);
                        zzujVar = zzujVar2;
                    }
                    zzou.zza(viewGroup, zzujVar, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzve.zzou().zza(viewGroup, new zzuj(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private static zzuj zza(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize adSize : adSizeArr) {
            if (adSize.equals(AdSize.INVALID)) {
                return zzuj.zzon();
            }
        }
        zzuj zzujVar = new zzuj(context, adSizeArr);
        zzujVar.zzccr = zzck(i);
        return zzujVar;
    }

    private static boolean zzck(int i) {
        return i == 1;
    }

    public final void destroy() {
        try {
            if (this.zzbqy != null) {
                this.zzbqy.destroy();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.zzcbw;
    }

    public final AdSize getAdSize() {
        zzuj zzjz;
        try {
            if (this.zzbqy != null && (zzjz = this.zzbqy.zzjz()) != null) {
                return zzjz.zzoo();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzcdf;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzcdf;
    }

    public final String getAdUnitId() {
        zzvu zzvuVar;
        if (this.zzbqz == null && (zzvuVar = this.zzbqy) != null) {
            try {
                this.zzbqz = zzvuVar.getAdUnitId();
            } catch (RemoteException e) {
                zzayu.zze("#007 Could not call remote method.", e);
            }
        }
        return this.zzbqz;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbkj;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbqy != null) {
                return this.zzbqy.zzka();
            }
            return null;
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcen;
    }

    public final VideoController getVideoController() {
        return this.zzcel;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbka;
    }

    public final boolean isLoading() {
        try {
            if (this.zzbqy != null) {
                return this.zzbqy.isLoading();
            }
            return false;
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void pause() {
        try {
            if (this.zzbqy != null) {
                this.zzbqy.pause();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordManualImpression() {
        if (this.zzcek.getAndSet(true)) {
            return;
        }
        try {
            if (this.zzbqy != null) {
                this.zzbqy.zzjy();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final void resume() {
        try {
            if (this.zzbqy != null) {
                this.zzbqy.resume();
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzcbw = adListener;
        this.zzcem.zza(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzcdf != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        if (this.zzbqz != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.zzbqz = str;
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbkj = appEventListener;
            if (this.zzbqy != null) {
                this.zzbqy.zza(appEventListener != null ? new zzul(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbkh = z;
        try {
            if (this.zzbqy != null) {
                this.zzbqy.setManualImpressionsEnabled(this.zzbkh);
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcen = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzbqy != null) {
                this.zzbqy.zza(onCustomRenderedAdLoadedListener != null ? new zzaal(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzbka = videoOptions;
        try {
            if (this.zzbqy != null) {
                this.zzbqy.zza(videoOptions == null ? null : new zzyw(videoOptions));
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzty zztyVar) {
        try {
            this.zzcbt = zztyVar;
            if (this.zzbqy != null) {
                this.zzbqy.zza(zztyVar != null ? new zztx(zztyVar) : null);
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zza(zzxj zzxjVar) {
        try {
            if (this.zzbqy == null) {
                if ((this.zzcdf == null || this.zzbqz == null) && this.zzbqy == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzceo.getContext();
                zzuj zza = zza(context, this.zzcdf, this.zzcep);
                this.zzbqy = "search_v2".equals(zza.zzabg) ? new zzuw(zzve.zzov(), context, zza, this.zzbqz).zzd(context, false) : new zzus(zzve.zzov(), context, zza, this.zzbqz, this.zzbrb).zzd(context, false);
                this.zzbqy.zza(new zzuc(this.zzcem));
                if (this.zzcbt != null) {
                    this.zzbqy.zza(new zztx(this.zzcbt));
                }
                if (this.zzbkj != null) {
                    this.zzbqy.zza(new zzul(this.zzbkj));
                }
                if (this.zzcen != null) {
                    this.zzbqy.zza(new zzaal(this.zzcen));
                }
                if (this.zzbka != null) {
                    this.zzbqy.zza(new zzyw(this.zzbka));
                }
                this.zzbqy.setManualImpressionsEnabled(this.zzbkh);
                try {
                    IObjectWrapper zzjx = this.zzbqy.zzjx();
                    if (zzjx != null) {
                        this.zzceo.addView((View) ObjectWrapper.unwrap(zzjx));
                    }
                } catch (RemoteException e) {
                    zzayu.zze("#007 Could not call remote method.", e);
                }
            }
            if (this.zzbqy.zza(zzuh.zza(this.zzceo.getContext(), zzxjVar))) {
                this.zzbrb.zzf(zzxjVar.zzpq());
            }
        } catch (RemoteException e2) {
            zzayu.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzcdf = adSizeArr;
        try {
            if (this.zzbqy != null) {
                this.zzbqy.zza(zza(this.zzceo.getContext(), this.zzcdf, this.zzcep));
            }
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
        this.zzceo.requestLayout();
    }

    public final boolean zza(zzvu zzvuVar) {
        if (zzvuVar == null) {
            return false;
        }
        try {
            IObjectWrapper zzjx = zzvuVar.zzjx();
            if (zzjx == null || ((View) ObjectWrapper.unwrap(zzjx)).getParent() != null) {
                return false;
            }
            this.zzceo.addView((View) ObjectWrapper.unwrap(zzjx));
            this.zzbqy = zzvuVar;
            return true;
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final zzxb zzdl() {
        zzvu zzvuVar = this.zzbqy;
        if (zzvuVar == null) {
            return null;
        }
        try {
            return zzvuVar.getVideoController();
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
