package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzcea {

    @GuardedBy("this")
    private List<Map<String, String>> zzftc = new ArrayList();

    @GuardedBy("this")
    private boolean zzftd = false;

    @GuardedBy("this")
    private boolean zzfte = false;
    private String zzftf;
    private zzcdv zzftg;

    public zzcea(String str, zzcdv zzcdvVar) {
        this.zzftf = str;
        this.zzftg = zzcdvVar;
    }

    private final Map<String, String> zzalk() {
        Map<String, String> zzalg = this.zzftg.zzalg();
        zzalg.put("tms", Long.toString(com.google.android.gms.ads.internal.zzq.zzkx().elapsedRealtime(), 10));
        zzalg.put("tid", this.zzftf);
        return zzalg;
    }

    public final synchronized void zzali() {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcku)).booleanValue()) {
            if (!this.zzftd) {
                Map<String, String> zzalk = zzalk();
                zzalk.put("action", "init_started");
                this.zzftc.add(zzalk);
                this.zzftd = true;
            }
        }
    }

    public final synchronized void zzalj() {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcku)).booleanValue()) {
            if (!this.zzfte) {
                Map<String, String> zzalk = zzalk();
                zzalk.put("action", "init_finished");
                this.zzftc.add(zzalk);
                Iterator<Map<String, String>> it = this.zzftc.iterator();
                while (it.hasNext()) {
                    this.zzftg.a(it.next());
                }
                this.zzfte = true;
            }
        }
    }

    public final synchronized void zzgd(String str) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcku)).booleanValue()) {
            Map<String, String> zzalk = zzalk();
            zzalk.put("action", "adapter_init_started");
            zzalk.put("ancn", str);
            this.zzftc.add(zzalk);
        }
    }

    public final synchronized void zzge(String str) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcku)).booleanValue()) {
            Map<String, String> zzalk = zzalk();
            zzalk.put("action", "adapter_init_finished");
            zzalk.put("ancn", str);
            this.zzftc.add(zzalk);
        }
    }

    public final synchronized void zzq(String str, String str2) {
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcku)).booleanValue()) {
            Map<String, String> zzalk = zzalk();
            zzalk.put("action", "adapter_init_finished");
            zzalk.put("ancn", str);
            zzalk.put("rqe", str2);
            this.zzftc.add(zzalk);
        }
    }
}
