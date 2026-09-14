package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbtu extends zzbmd {
    private final WeakReference<zzbdi> zzfix;
    private final zzbsk zzfiy;
    private final zzbuv zzfiz;
    private final zzbmx zzfja;
    private final com.google.android.gms.gass.zzf zzfjb;
    private boolean zzfjc;
    private final Context zzup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbtu(zzbmg zzbmgVar, Context context, @Nullable zzbdi zzbdiVar, zzbsk zzbskVar, zzbuv zzbuvVar, zzbmx zzbmxVar, com.google.android.gms.gass.zzf zzfVar) {
        super(zzbmgVar);
        this.zzfjc = false;
        this.zzup = context;
        this.zzfix = new WeakReference<>(zzbdiVar);
        this.zzfiy = zzbskVar;
        this.zzfiz = zzbuvVar;
        this.zzfja = zzbmxVar;
        this.zzfjb = zzfVar;
    }

    public final void finalize() {
        try {
            zzbdi zzbdiVar = this.zzfix.get();
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcrd)).booleanValue()) {
                if (!this.zzfjc && zzbdiVar != null) {
                    zzdhd zzdhdVar = zzazd.zzdwi;
                    zzbdiVar.getClass();
                    zzdhdVar.execute(zzbtt.a(zzbdiVar));
                }
            } else if (zzbdiVar != null) {
                zzbdiVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean isClosed() {
        return this.zzfja.isClosed();
    }

    public final boolean zzaid() {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcin)).booleanValue()) {
            com.google.android.gms.ads.internal.zzq.zzkq();
            if (zzawb.zzau(this.zzup)) {
                zzayu.zzez("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                if (((Boolean) zzve.zzoy().zzd(zzzn.zzcio)).booleanValue()) {
                    this.zzfjb.zzgq(this.a.zzgmi.zzgmf.zzbzo);
                }
                return false;
            }
        }
        return !this.zzfjc;
    }

    public final void zzbg(boolean z) {
        this.zzfiy.zzahx();
        this.zzfiz.zza(z, this.zzup);
        this.zzfjc = true;
    }
}
