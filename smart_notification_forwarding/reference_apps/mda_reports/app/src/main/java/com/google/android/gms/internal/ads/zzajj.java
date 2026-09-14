package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzajj extends zzazo<zzaif> {
    private zzaxh<zzaif> zzczn;
    private final Object lock = new Object();
    private boolean zzdae = false;
    private int zzdaf = 0;

    public zzajj(zzaxh<zzaif> zzaxhVar) {
        this.zzczn = zzaxhVar;
    }

    private final void zzsf() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdaf >= 0);
            if (this.zzdae && this.zzdaf == 0) {
                zzavs.zzed("No reference is left (including root). Cleaning up engine.");
                zza(new zzajo(this), new zzazm());
            } else {
                zzavs.zzed("There are still references to the engine. Not destroying.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdaf > 0);
            zzavs.zzed("Releasing 1 reference for JS Engine");
            this.zzdaf--;
            zzsf();
        }
    }

    public final zzajf zzsc() {
        zzajf zzajfVar = new zzajf(this);
        synchronized (this.lock) {
            zza(new zzajm(this, zzajfVar), new zzajl(this, zzajfVar));
            Preconditions.checkState(this.zzdaf >= 0);
            this.zzdaf++;
        }
        return zzajfVar;
    }

    public final void zzse() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzdaf >= 0);
            zzavs.zzed("Releasing root reference. JS Engine will be destroyed once other references are released.");
            this.zzdae = true;
            zzsf();
        }
    }
}
