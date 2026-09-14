package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* loaded from: classes.dex */
public final class zzdac {
    private final zzald zzgmv;

    public zzdac(zzald zzaldVar) {
        this.zzgmv = zzaldVar;
    }

    public final void destroy() {
        try {
            this.zzgmv.destroy();
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final zzxb getVideoController() {
        try {
            return this.zzgmv.getVideoController();
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final View getView() {
        try {
            return (View) ObjectWrapper.unwrap(this.zzgmv.zzsk());
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final boolean isInitialized() {
        try {
            return this.zzgmv.isInitialized();
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void onContextChanged(Context context) {
        try {
            this.zzgmv.zzs(ObjectWrapper.wrap(context));
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void pause() {
        try {
            this.zzgmv.pause();
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void resume() {
        try {
            this.zzgmv.resume();
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzgmv.setImmersiveMode(z);
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void showInterstitial() {
        try {
            this.zzgmv.showInterstitial();
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void showVideo() {
        try {
            this.zzgmv.showVideo();
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void zza(Context context, zzagp zzagpVar, List<zzagx> list) {
        try {
            this.zzgmv.zza(ObjectWrapper.wrap(context), zzagpVar, list);
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void zza(Context context, zzarz zzarzVar, List<String> list) {
        try {
            this.zzgmv.zza(ObjectWrapper.wrap(context), zzarzVar, list);
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void zza(Context context, zzug zzugVar, String str, zzali zzaliVar) {
        try {
            this.zzgmv.zza(ObjectWrapper.wrap(context), zzugVar, str, zzaliVar);
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void zza(Context context, zzug zzugVar, String str, zzarz zzarzVar, String str2) {
        try {
            this.zzgmv.zza(ObjectWrapper.wrap(context), zzugVar, (String) null, zzarzVar, str2);
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void zza(Context context, zzug zzugVar, String str, String str2, zzali zzaliVar) {
        try {
            this.zzgmv.zza(ObjectWrapper.wrap(context), zzugVar, str, str2, zzaliVar);
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void zza(Context context, zzug zzugVar, String str, String str2, zzali zzaliVar, zzaby zzabyVar, List<String> list) {
        try {
            this.zzgmv.zza(ObjectWrapper.wrap(context), zzugVar, str, str2, zzaliVar, zzabyVar, list);
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void zza(Context context, zzuj zzujVar, zzug zzugVar, String str, zzali zzaliVar) {
        try {
            this.zzgmv.zza(ObjectWrapper.wrap(context), zzujVar, zzugVar, str, zzaliVar);
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void zza(Context context, zzuj zzujVar, zzug zzugVar, String str, String str2, zzali zzaliVar) {
        try {
            this.zzgmv.zza(ObjectWrapper.wrap(context), zzujVar, zzugVar, str, str2, zzaliVar);
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void zza(zzug zzugVar, String str) {
        try {
            this.zzgmv.zza(zzugVar, str);
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void zzb(Context context, zzug zzugVar, String str, zzali zzaliVar) {
        try {
            this.zzgmv.zzb(ObjectWrapper.wrap(context), zzugVar, str, zzaliVar);
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final void zzcb(Context context) {
        try {
            this.zzgmv.zzt(ObjectWrapper.wrap(context));
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final zzall zzsl() {
        try {
            return this.zzgmv.zzsl();
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final zzalq zzsm() {
        try {
            return this.zzgmv.zzsm();
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final boolean zzsp() {
        try {
            return this.zzgmv.zzsp();
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }

    public final zzalr zzsr() {
        try {
            return this.zzgmv.zzsr();
        } catch (Throwable th) {
            throw new zzdab(th);
        }
    }
}
