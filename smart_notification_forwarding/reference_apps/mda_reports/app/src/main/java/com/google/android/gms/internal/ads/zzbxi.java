package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbxi extends zzacs implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbxz {

    @GuardedBy("this")
    private zzbwk zzfnf;
    private zzpo zzfng;
    private final WeakReference<View> zzfnj;
    private final Map<String, WeakReference<View>> zzfnk = new HashMap();
    private final Map<String, WeakReference<View>> zzfnl = new HashMap();
    private final Map<String, WeakReference<View>> zzfnm = new HashMap();

    public zzbxi(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        com.google.android.gms.ads.internal.zzq.zzln();
        zzazt.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzq.zzln();
        zzazt.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzfnj = new WeakReference<>(view);
        for (Map.Entry<String, View> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.zzfnk.put(key, new WeakReference<>(value));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
        this.zzfnm.putAll(this.zzfnk);
        for (Map.Entry<String, View> entry2 : hashMap2.entrySet()) {
            View value2 = entry2.getValue();
            if (value2 != null) {
                this.zzfnl.put(entry2.getKey(), new WeakReference<>(value2));
                value2.setOnTouchListener(this);
                value2.setClickable(false);
            }
        }
        this.zzfnm.putAll(this.zzfnl);
        this.zzfng = new zzpo(view.getContext(), view);
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        if (this.zzfnf != null) {
            this.zzfnf.zza(view, zzaga(), zzajz(), zzaka(), true);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        if (this.zzfnf != null) {
            this.zzfnf.zzb(zzaga(), zzajz(), zzaka(), zzbwk.zzy(zzaga()));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        if (this.zzfnf != null) {
            this.zzfnf.zzb(zzaga(), zzajz(), zzaka(), zzbwk.zzy(zzaga()));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzfnf != null) {
            this.zzfnf.zza(view, motionEvent, zzaga());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzacp
    public final synchronized void unregisterNativeAd() {
        if (this.zzfnf != null) {
            this.zzfnf.zzb(this);
            this.zzfnf = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacp
    public final synchronized void zza(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzbwk)) {
            zzayu.zzez("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        if (this.zzfnf != null) {
            this.zzfnf.zzb(this);
        }
        if (!((zzbwk) unwrap).zzaiv()) {
            zzayu.zzex("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
            return;
        }
        this.zzfnf = (zzbwk) unwrap;
        this.zzfnf.zza(this);
        this.zzfnf.zzz(zzaga());
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final synchronized void zza(String str, View view, boolean z) {
        if (view == null) {
            this.zzfnm.remove(str);
            this.zzfnk.remove(str);
            this.zzfnl.remove(str);
            return;
        }
        this.zzfnm.put(str, new WeakReference<>(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
            this.zzfnk.put(str, new WeakReference<>(view));
            view.setClickable(true);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    @Nullable
    public final View zzaga() {
        return this.zzfnj.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final synchronized Map<String, WeakReference<View>> zzajz() {
        return this.zzfnm;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final synchronized Map<String, WeakReference<View>> zzaka() {
        return this.zzfnk;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzakb() {
        return this.zzfnl;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final synchronized String zzakc() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    @Nullable
    public final FrameLayout zzakd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final zzpo zzake() {
        return this.zzfng;
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    @Nullable
    public final synchronized IObjectWrapper zzakf() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzacp
    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        if (this.zzfnf != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzayu.zzez("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zzfnf.setClickConfirmingView((View) unwrap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxz
    public final synchronized View zzgb(String str) {
        WeakReference<View> weakReference = this.zzfnm.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
