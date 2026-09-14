package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class zzcbb extends zzbmd {
    private final zzasf zzdny;
    private final WeakReference<zzbdi> zzfix;
    private final zzbsk zzfiy;
    private final zzbmx zzfja;
    private final com.google.android.gms.gass.zzf zzfjb;
    private final zzbuv zzfjd;
    private boolean zzfqa;
    private final zzbqa zzfqp;
    private final zzboz zzfra;
    private final Context zzup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbb(zzbmg zzbmgVar, Context context, @Nullable zzbdi zzbdiVar, zzbuv zzbuvVar, zzbsk zzbskVar, zzboz zzbozVar, zzbqa zzbqaVar, zzbmx zzbmxVar, zzczl zzczlVar, com.google.android.gms.gass.zzf zzfVar) {
        super(zzbmgVar);
        this.zzfqa = false;
        this.zzup = context;
        this.zzfjd = zzbuvVar;
        this.zzfix = new WeakReference<>(zzbdiVar);
        this.zzfiy = zzbskVar;
        this.zzfra = zzbozVar;
        this.zzfqp = zzbqaVar;
        this.zzfja = zzbmxVar;
        this.zzfjb = zzfVar;
        this.zzdny = new zzatc(zzczlVar.zzdky);
    }

    public final void finalize() {
        try {
            zzbdi zzbdiVar = this.zzfix.get();
            if (((Boolean) zzve.zzoy().zzd(zzzn.zzcrd)).booleanValue()) {
                if (!this.zzfqa && zzbdiVar != null) {
                    zzdhd zzdhdVar = zzazd.zzdwi;
                    zzbdiVar.getClass();
                    zzdhdVar.execute(zzcbe.a(zzbdiVar));
                }
            } else if (zzbdiVar != null) {
                zzbdiVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle getAdMetadata() {
        return this.zzfqp.getAdMetadata();
    }

    public final boolean isClosed() {
        return this.zzfja.isClosed();
    }

    public final boolean zzaks() {
        return this.zzfqa;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context] */
    public final void zzb(boolean z, @Nullable Activity activity) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcin)).booleanValue()) {
            com.google.android.gms.ads.internal.zzq.zzkq();
            if (zzawb.zzau(this.zzup)) {
                zzayu.zzez("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzfra.zzco(3);
                if (((Boolean) zzve.zzoy().zzd(zzzn.zzcio)).booleanValue()) {
                    this.zzfjb.zzgq(this.a.zzgmi.zzgmf.zzbzo);
                    return;
                }
                return;
            }
        }
        if (this.zzfqa) {
            zzayu.zzez("The rewarded ad have been showed.");
            this.zzfra.zzco(1);
            return;
        }
        this.zzfqa = true;
        this.zzfiy.zzahx();
        Activity activity2 = activity;
        if (activity == null) {
            activity2 = this.zzup;
        }
        this.zzfjd.zza(z, activity2);
    }

    public final zzasf zzpz() {
        return this.zzdny;
    }

    public final boolean zzqa() {
        zzbdi zzbdiVar = this.zzfix.get();
        return (zzbdiVar == null || zzbdiVar.zzaap()) ? false : true;
    }
}
