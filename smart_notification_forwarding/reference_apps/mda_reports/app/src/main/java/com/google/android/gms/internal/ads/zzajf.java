package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzajf extends zzazo<zzajq> {
    private final Object lock = new Object();
    private final zzajj zzdab;
    private boolean zzdac;

    public zzajf(zzajj zzajjVar) {
        this.zzdab = zzajjVar;
    }

    public final void release() {
        synchronized (this.lock) {
            if (this.zzdac) {
                return;
            }
            this.zzdac = true;
            zza(new zzaji(this), new zzazm());
            zza(new zzajh(this), new zzajk(this));
        }
    }
}
