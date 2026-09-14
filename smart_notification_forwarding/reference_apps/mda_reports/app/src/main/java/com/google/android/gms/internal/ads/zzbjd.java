package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbjd implements com.google.android.gms.ads.internal.overlay.zzo, zzbpe, zzbph, zzps {
    private final Clock zzbmq;
    private final zzbiy zzfce;
    private final zzbjb zzfcf;
    private final zzako<JSONObject, JSONObject> zzfch;
    private final Executor zzfci;
    private final Set<zzbdi> zzfcg = new HashSet();
    private final AtomicBoolean zzfcj = new AtomicBoolean(false);

    @GuardedBy("this")
    private final zzbjf zzfck = new zzbjf();
    private boolean zzfcl = false;
    private WeakReference<?> zzfcm = new WeakReference<>(this);

    public zzbjd(zzakh zzakhVar, zzbjb zzbjbVar, Executor executor, zzbiy zzbiyVar, Clock clock) {
        this.zzfce = zzbiyVar;
        zzajy<JSONObject> zzajyVar = zzajx.zzdaq;
        this.zzfch = zzakhVar.zzb("google.afma.activeView.handleUpdate", zzajyVar, zzajyVar);
        this.zzfcf = zzbjbVar;
        this.zzfci = executor;
        this.zzbmq = clock;
    }

    private final void zzafo() {
        Iterator<zzbdi> it = this.zzfcg.iterator();
        while (it.hasNext()) {
            this.zzfce.zze(it.next());
        }
        this.zzfce.zzafm();
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void onAdImpression() {
        if (this.zzfcj.compareAndSet(false, true)) {
            this.zzfce.zza(this);
            zzafn();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onPause() {
        this.zzfck.zzfco = true;
        zzafn();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onResume() {
        this.zzfck.zzfco = false;
        zzafn();
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final synchronized void zza(zzpt zzptVar) {
        this.zzfck.zzbnq = zzptVar.zzbnq;
        this.zzfck.zzfcr = zzptVar;
        zzafn();
    }

    public final synchronized void zzafn() {
        if (!(this.zzfcm.get() != null)) {
            zzafp();
            return;
        }
        if (!this.zzfcl && this.zzfcj.get()) {
            try {
                this.zzfck.timestamp = this.zzbmq.elapsedRealtime();
                final JSONObject zzj = this.zzfcf.zzj(this.zzfck);
                for (final zzbdi zzbdiVar : this.zzfcg) {
                    this.zzfci.execute(new Runnable(zzbdiVar, zzj) { // from class: com.google.android.gms.internal.ads.zzbjg
                        private final zzbdi zzehp;
                        private final JSONObject zzfcs;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzehp = zzbdiVar;
                            this.zzfcs = zzj;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzehp.zza("AFMA_updateActiveView", this.zzfcs);
                        }
                    });
                }
                zzazh.zzb(this.zzfch.zzf(zzj), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e) {
                zzavs.zza("Failed to call ActiveViewJS", e);
            }
        }
    }

    public final synchronized void zzafp() {
        zzafo();
        this.zzfcl = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final synchronized void zzbv(@Nullable Context context) {
        this.zzfck.zzfco = true;
        zzafn();
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final synchronized void zzbw(@Nullable Context context) {
        this.zzfck.zzfco = false;
        zzafn();
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final synchronized void zzbx(@Nullable Context context) {
        this.zzfck.zzfcq = "u";
        zzafn();
        zzafo();
        this.zzfcl = true;
    }

    public final synchronized void zzf(zzbdi zzbdiVar) {
        this.zzfcg.add(zzbdiVar);
        this.zzfce.zzd(zzbdiVar);
    }

    public final void zzo(Object obj) {
        this.zzfcm = new WeakReference<>(obj);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzte() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zztf() {
    }
}
