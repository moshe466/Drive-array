package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzaja implements zzafn<zzajq> {
    private final /* synthetic */ zzaif zzczt;
    private final /* synthetic */ zzais zzczu;
    private final /* synthetic */ zzdq zzczw;
    private final /* synthetic */ zzayd zzczx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaja(zzais zzaisVar, zzdq zzdqVar, zzaif zzaifVar, zzayd zzaydVar) {
        this.zzczu = zzaisVar;
        this.zzczw = zzdqVar;
        this.zzczt = zzaifVar;
        this.zzczx = zzaydVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafn
    public final /* synthetic */ void zza(zzajq zzajqVar, Map map) {
        Object obj;
        int i;
        obj = this.zzczu.lock;
        synchronized (obj) {
            zzayu.zzey("JS Engine is requesting an update");
            i = this.zzczu.status;
            if (i == 0) {
                zzayu.zzey("Starting reload.");
                this.zzczu.status = 2;
                this.zzczu.a(this.zzczw);
            }
            this.zzczt.zzb("/requestReload", (zzafn<? super zzajq>) this.zzczx.get());
        }
    }
}
