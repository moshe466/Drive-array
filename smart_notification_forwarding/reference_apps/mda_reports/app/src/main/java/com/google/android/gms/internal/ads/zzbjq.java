package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzbjq implements zzps {
    private final Clock zzbmq;
    private zzbdi zzcza;
    private final zzbjb zzfcf;
    private final Executor zzfci;
    private boolean zzbsd = false;
    private boolean zzfdh = false;
    private zzbjf zzfck = new zzbjf();

    public zzbjq(Executor executor, zzbjb zzbjbVar, Clock clock) {
        this.zzfci = executor;
        this.zzfcf = zzbjbVar;
        this.zzbmq = clock;
    }

    private final void zzafq() {
        try {
            final JSONObject zzj = this.zzfcf.zzj(this.zzfck);
            if (this.zzcza != null) {
                this.zzfci.execute(new Runnable(this, zzj) { // from class: com.google.android.gms.internal.ads.zzbjp
                    private final JSONObject zzfcs;
                    private final zzbjq zzfdg;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzfdg = this;
                        this.zzfcs = zzj;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzfdg.a(this.zzfcs);
                    }
                });
            }
        } catch (JSONException e) {
            zzavs.zza("Failed to call video active view js", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(JSONObject jSONObject) {
        this.zzcza.zza("AFMA_updateActiveView", jSONObject);
    }

    public final void disable() {
        this.zzbsd = false;
    }

    public final void enable() {
        this.zzbsd = true;
        zzafq();
    }

    @Override // com.google.android.gms.internal.ads.zzps
    public final void zza(zzpt zzptVar) {
        this.zzfck.zzbnq = this.zzfdh ? false : zzptVar.zzbnq;
        this.zzfck.timestamp = this.zzbmq.elapsedRealtime();
        this.zzfck.zzfcr = zzptVar;
        if (this.zzbsd) {
            zzafq();
        }
    }

    public final void zzbf(boolean z) {
        this.zzfdh = z;
    }

    public final void zzg(zzbdi zzbdiVar) {
        this.zzcza = zzbdiVar;
    }
}
