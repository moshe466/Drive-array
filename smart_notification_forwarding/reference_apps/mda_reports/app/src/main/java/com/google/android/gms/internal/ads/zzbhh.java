package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbhh {
    private zzbga zzejy;
    private zzbhq zzeyc;
    private zzdcy zzeyd;
    private zzbhx zzeye;
    private zzdag zzeyf;

    private zzbhh() {
    }

    public final zzbhh zza(zzbhq zzbhqVar) {
        this.zzeyc = (zzbhq) zzdxm.checkNotNull(zzbhqVar);
        return this;
    }

    public final zzbfx zzael() {
        zzdxm.zza(this.zzejy, (Class<zzbga>) zzbga.class);
        zzdxm.zza(this.zzeyc, (Class<zzbhq>) zzbhq.class);
        if (this.zzeyd == null) {
            this.zzeyd = new zzdcy();
        }
        if (this.zzeye == null) {
            this.zzeye = new zzbhx();
        }
        if (this.zzeyf == null) {
            this.zzeyf = new zzdag();
        }
        return new zzbgr(this.zzejy, this.zzeyc, this.zzeyd, this.zzeye, this.zzeyf);
    }

    public final zzbhh zzc(zzbga zzbgaVar) {
        this.zzejy = (zzbga) zzdxm.checkNotNull(zzbgaVar);
        return this;
    }
}
