package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public class zzae extends Exception {
    private long zzad;
    private final zzo zzbk;

    public zzae() {
        this.zzbk = null;
    }

    public zzae(zzo zzoVar) {
        this.zzbk = zzoVar;
    }

    public zzae(String str) {
        super(str);
        this.zzbk = null;
    }

    public zzae(Throwable th) {
        super(th);
        this.zzbk = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j) {
        this.zzad = j;
    }
}
