package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzbxh extends zzacl implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbxz {
    public static final String[] zzfna = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO};
    private FrameLayout zzbkf;
    private zzacd zzcwg;
    private final int zzdwa;
    private final String zzfmz;
    private FrameLayout zzfnc;
    private zzdhd zzfnd;
    private View zzfne;

    @GuardedBy("this")
    private zzbwk zzfnf;
    private zzpo zzfng;
    private boolean zzfni;

    @GuardedBy("this")
    private Map<String, WeakReference<View>> zzfnb = new HashMap();
    private IObjectWrapper zzfnh = null;
    private boolean zzegh = false;

    public zzbxh(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.zzfnc = frameLayout;
        this.zzbkf = frameLayout2;
        this.zzdwa = i;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzfmz = str;
        com.google.android.gms.ads.internal.zzq.zzln();
        zzazt.zza((View) frameLayout, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzq.zzln();
        zzazt.zza((View) frameLayout, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzfnd = zzazd.zzdwi;
        this.zzfng = new zzpo(this.zzfnc.getContext(), this.zzfnc);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzajy() {
        this.zzfnd.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbxk
            private final zzbxh zzfno;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfno = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzfno.c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c() {
        if (this.zzfne == null) {
            this.zzfne = new View(this.zzfnc.getContext());
            this.zzfne.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzfnc != this.zzfne.getParent()) {
            this.zzfnc.addView(this.zzfne);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final synchronized void destroy() {
        if (this.zzegh) {
            return;
        }
        if (this.zzfnf != null) {
            this.zzfnf.zzb(this);
            this.zzfnf = null;
        }
        this.zzfnb.clear();
        this.zzfnc.removeAllViews();
        this.zzbkf.removeAllViews();
        this.zzfnb = null;
        this.zzfnc = null;
        this.zzbkf = null;
        this.zzfne = null;
        this.zzfng = null;
        this.zzegh = true;
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        if (this.zzfnf != null) {
            this.zzfnf.cancelUnconfirmedClick();
            this.zzfnf.zza(view, this.zzfnc, zzajz(), zzaka(), false);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        if (this.zzfnf != null) {
            this.zzfnf.zzb(this.zzfnc, zzajz(), zzaka(), zzbwk.zzy(this.zzfnc));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        if (this.zzfnf != null) {
            this.zzfnf.zzb(this.zzfnc, zzajz(), zzaka(), zzbwk.zzy(this.zzfnc));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzfnf != null) {
            this.zzfnf.zza(view, motionEvent, this.zzfnc);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final synchronized void zza(IObjectWrapper iObjectWrapper) {
        if (this.zzegh) {
            return;
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzbwk)) {
            zzayu.zzez("Not an instance of native engine. This is most likely a transient error");
            return;
        }
        if (this.zzfnf != null) {
            this.zzfnf.zzb(this);
        }
        zzajy();
        this.zzfnf = (zzbwk) unwrap;
        this.zzfnf.zza(this);
        this.zzfnf.zzz(this.zzfnc);
        this.zzfnf.zzaa(this.zzbkf);
        if (this.zzfni) {
            this.zzfnf.zzaix().zza(this.zzcwg);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final synchronized void zza(zzacd zzacdVar) {
        if (this.zzegh) {
            return;
        }
        this.zzfni = true;
        this.zzcwg = zzacdVar;
        if (this.zzfnf != null) {
            this.zzfnf.zzaix().zza(zzacdVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final synchronized void zza(String str, View view, boolean z) {
        if (this.zzegh) {
            return;
        }
        if (view == null) {
            this.zzfnb.remove(str);
            return;
        }
        this.zzfnb.put(str, new WeakReference<>(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
            if (zzaxy.zzcs(this.zzdwa)) {
                view.setOnTouchListener(this);
            }
            view.setClickable(true);
            view.setOnClickListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final /* synthetic */ View zzaga() {
        return this.zzfnc;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final synchronized Map<String, WeakReference<View>> zzajz() {
        return this.zzfnb;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final synchronized Map<String, WeakReference<View>> zzaka() {
        return this.zzfnb;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzakb() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final synchronized String zzakc() {
        return this.zzfmz;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final FrameLayout zzakd() {
        return this.zzbkf;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final zzpo zzake() {
        return this.zzfng;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    @Nullable
    public final IObjectWrapper zzakf() {
        return this.zzfnh;
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final synchronized void zzb(String str, IObjectWrapper iObjectWrapper) {
        zza(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final synchronized void zzc(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final synchronized IObjectWrapper zzco(String str) {
        return ObjectWrapper.wrap(zzgb(str));
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        this.zzfnf.setClickConfirmingView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final void zzf(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzfnc, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzacm
    public final synchronized void zzg(IObjectWrapper iObjectWrapper) {
        if (this.zzegh) {
            return;
        }
        this.zzfnh = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final synchronized View zzgb(String str) {
        if (this.zzegh) {
            return null;
        }
        WeakReference<View> weakReference = this.zzfnb.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
