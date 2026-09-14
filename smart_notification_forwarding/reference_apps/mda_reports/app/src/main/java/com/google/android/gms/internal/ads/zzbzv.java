package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* loaded from: classes.dex */
public final class zzbzv extends zzahe implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzabr {
    private zzxb zzfma;
    private View zzfmf;
    private zzbwk zzfnf;
    private boolean zzegh = false;
    private boolean zzfqa = false;

    public zzbzv(zzbwk zzbwkVar, zzbws zzbwsVar) {
        this.zzfmf = zzbwsVar.zzaje();
        this.zzfma = zzbwsVar.getVideoController();
        this.zzfnf = zzbwkVar;
        if (zzbwsVar.zzajf() != null) {
            zzbwsVar.zzajf().zza(this);
        }
    }

    private static void zza(zzahg zzahgVar, int i) {
        try {
            zzahgVar.zzcn(i);
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    private final void zzakn() {
        View view = this.zzfmf;
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.zzfmf);
        }
    }

    private final void zzako() {
        View view;
        zzbwk zzbwkVar = this.zzfnf;
        if (zzbwkVar == null || (view = this.zzfmf) == null) {
            return;
        }
        zzbwkVar.zzb(view, Collections.emptyMap(), Collections.emptyMap(), zzbwk.zzy(this.zzfmf));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        try {
            destroy();
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final void destroy() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzakn();
        zzbwk zzbwkVar = this.zzfnf;
        if (zzbwkVar != null) {
            zzbwkVar.destroy();
        }
        this.zzfnf = null;
        this.zzfmf = null;
        this.zzfma = null;
        this.zzegh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzxb getVideoController() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzegh) {
            return this.zzfma;
        }
        zzayu.zzex("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzako();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzako();
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final void zza(IObjectWrapper iObjectWrapper, zzahg zzahgVar) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzegh) {
            zzayu.zzex("Instream ad can not be shown after destroy().");
            zza(zzahgVar, 2);
            return;
        }
        if (this.zzfmf == null || this.zzfma == null) {
            String str = this.zzfmf == null ? "can not get video view." : "can not get video controller.";
            zzayu.zzex(str.length() != 0 ? "Instream internal error: ".concat(str) : new String("Instream internal error: "));
            zza(zzahgVar, 0);
            return;
        }
        if (this.zzfqa) {
            zzayu.zzex("Instream ad should not be used again.");
            zza(zzahgVar, 1);
            return;
        }
        this.zzfqa = true;
        zzakn();
        ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zzfmf, new ViewGroup.LayoutParams(-1, -1));
        com.google.android.gms.ads.internal.zzq.zzln();
        zzazt.zza(this.zzfmf, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzq.zzln();
        zzazt.zza(this.zzfmf, (ViewTreeObserver.OnScrollChangedListener) this);
        zzako();
        try {
            zzahgVar.zzrv();
        } catch (RemoteException e) {
            zzayu.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final void zzr(IObjectWrapper iObjectWrapper) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zza(iObjectWrapper, new zzbzx(this));
    }

    @Override // com.google.android.gms.internal.ads.zzabr
    public final void zzrb() {
        zzawb.zzdsr.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbzy
            private final zzbzv zzfqb;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfqb = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfqb.c();
            }
        });
    }
}
