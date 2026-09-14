package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzacp;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzve;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzbkd = new WeakHashMap<>();
    private zzacp zzbkc;
    private WeakReference<View> zzbke;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if ((view instanceof NativeAdView) || (view instanceof UnifiedNativeAdView)) {
            zzayu.zzex("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
            return;
        }
        if (zzbkd.get(view) != null) {
            zzayu.zzex("The provided containerView is already in use with another NativeAdViewHolder.");
            return;
        }
        zzbkd.put(view, this);
        this.zzbke = new WeakReference<>(view);
        this.zzbkc = zzve.zzov().zza(view, zzb(map), zzb(map2));
    }

    private final void zza(IObjectWrapper iObjectWrapper) {
        WeakReference<View> weakReference = this.zzbke;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            zzayu.zzez("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzbkd.containsKey(view)) {
            zzbkd.put(view, this);
        }
        zzacp zzacpVar = this.zzbkc;
        if (zzacpVar != null) {
            try {
                zzacpVar.zza(iObjectWrapper);
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    private static HashMap<String, View> zzb(Map<String, View> map) {
        return map == null ? new HashMap<>() : new HashMap<>(map);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbkc.zze(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzayu.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setNativeAd(NativeAd nativeAd) {
        zza((IObjectWrapper) nativeAd.a());
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        zza((IObjectWrapper) unifiedNativeAd.a());
    }

    public final void unregisterNativeAd() {
        zzacp zzacpVar = this.zzbkc;
        if (zzacpVar != null) {
            try {
                zzacpVar.unregisterNativeAd();
            } catch (RemoteException e) {
                zzayu.zzc("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference<View> weakReference = this.zzbke;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            zzbkd.remove(view);
        }
    }
}
