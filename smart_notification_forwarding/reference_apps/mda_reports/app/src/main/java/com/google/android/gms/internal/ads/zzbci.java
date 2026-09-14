package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbci extends zzavo {
    final zzbaz a;
    final zzbcn b;
    private final String zzdyg;
    private final String[] zzdyh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbci(zzbaz zzbazVar, zzbcn zzbcnVar, String str, String[] strArr) {
        this.a = zzbazVar;
        this.b = zzbcnVar;
        this.zzdyg = str;
        this.zzdyh = strArr;
        com.google.android.gms.ads.internal.zzq.zzlm().zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzavo
    public final void zztu() {
        try {
            this.b.zze(this.zzdyg, this.zzdyh);
        } finally {
            zzawb.zzdsr.post(new zzbcl(this));
        }
    }
}
