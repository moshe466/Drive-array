package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzbye implements zzbxa {
    private final zzazb zzbll;
    private final zzczl zzffc;
    private final zzczu zzfgl;
    private final zzbpd zzfkd;
    private final zzboq zzfke;
    private boolean zzfki = false;
    private boolean zzfkl = false;

    @Nullable
    private final zzall zzfok;

    @Nullable
    private final zzalq zzfol;

    @Nullable
    private final zzalr zzfom;
    private final Context zzup;

    public zzbye(@Nullable zzall zzallVar, @Nullable zzalq zzalqVar, @Nullable zzalr zzalrVar, zzbpd zzbpdVar, zzboq zzboqVar, Context context, zzczl zzczlVar, zzazb zzazbVar, zzczu zzczuVar) {
        this.zzfok = zzallVar;
        this.zzfol = zzalqVar;
        this.zzfom = zzalrVar;
        this.zzfkd = zzbpdVar;
        this.zzfke = zzboqVar;
        this.zzup = context;
        this.zzffc = zzczlVar;
        this.zzbll = zzazbVar;
        this.zzfgl = zzczuVar;
    }

    private final void zzac(View view) {
        try {
            if (this.zzfom != null && !this.zzfom.getOverrideClickHandling()) {
                this.zzfom.zzu(ObjectWrapper.wrap(view));
                this.zzfke.onAdClicked();
            } else if (this.zzfok != null && !this.zzfok.getOverrideClickHandling()) {
                this.zzfok.zzu(ObjectWrapper.wrap(view));
                this.zzfke.onAdClicked();
            } else {
                if (this.zzfol == null || this.zzfol.getOverrideClickHandling()) {
                    return;
                }
                this.zzfol.zzu(ObjectWrapper.wrap(view));
                this.zzfke.onAdClicked();
            }
        } catch (RemoteException e) {
            zzayu.zzd("Failed to call handleClick", e);
        }
    }

    private static HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    hashMap.put(entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void cancelUnconfirmedClick() {
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void destroy() {
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final boolean isCustomClickGestureEnabled() {
        return this.zzffc.zzdcf;
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void setClickConfirmingView(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(View view, MotionEvent motionEvent, @Nullable View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(View view, @Nullable View view2, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, boolean z) {
        if (this.zzfkl && this.zzffc.zzdcf) {
            return;
        }
        zzac(view);
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            if (this.zzfom != null) {
                this.zzfom.zzw(wrap);
            } else if (this.zzfok != null) {
                this.zzfok.zzw(wrap);
            } else if (this.zzfol != null) {
                this.zzfol.zzw(wrap);
            }
        } catch (RemoteException e) {
            zzayu.zzd("Failed to call untrackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(@Nullable View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2) {
        try {
            if (!this.zzfki && this.zzffc.zzglt != null) {
                this.zzfki |= com.google.android.gms.ads.internal.zzq.zzla().zzb(this.zzup, this.zzbll.zzbma, this.zzffc.zzglt.toString(), this.zzfgl.zzgmm);
            }
            if (this.zzfom != null && !this.zzfom.getOverrideImpressionRecording()) {
                this.zzfom.recordImpression();
                this.zzfkd.onAdImpression();
            } else if (this.zzfok != null && !this.zzfok.getOverrideImpressionRecording()) {
                this.zzfok.recordImpression();
                this.zzfkd.onAdImpression();
            } else {
                if (this.zzfol == null || this.zzfol.getOverrideImpressionRecording()) {
                    return;
                }
                this.zzfol.recordImpression();
                this.zzfkd.onAdImpression();
            }
        } catch (RemoteException e) {
            zzayu.zzd("Failed to call recordImpression", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(View view, @Nullable Map<String, WeakReference<View>> map, @Nullable Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            HashMap<String, View> zzb = zzb(map);
            HashMap<String, View> zzb2 = zzb(map2);
            if (this.zzfom != null) {
                this.zzfom.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                return;
            }
            if (this.zzfok != null) {
                this.zzfok.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzfok.zzv(wrap);
            } else if (this.zzfol != null) {
                this.zzfol.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzfol.zzv(wrap);
            }
        } catch (RemoteException e) {
            zzayu.zzd("Failed to call trackView", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        String str;
        if (!this.zzfkl) {
            str = "Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.";
        } else {
            if (this.zzffc.zzdcf) {
                zzac(view);
                return;
            }
            str = "Custom click reporting for 3p ads failed. Ad unit id not whitelisted.";
        }
        zzayu.zzez(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(zzaeb zzaebVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(zzwn zzwnVar) {
        zzayu.zzez("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zza(@Nullable zzwr zzwrVar) {
        zzayu.zzez("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzaio() {
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzaip() {
        zzayu.zzez("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzaiq() {
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzf(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzfu(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzg(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final boolean zzh(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbxa
    public final void zzrp() {
        this.zzfkl = true;
    }
}
