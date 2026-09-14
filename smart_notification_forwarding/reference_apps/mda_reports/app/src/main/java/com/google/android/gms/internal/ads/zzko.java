package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes.dex */
public final class zzko implements zzjd, zzjm {
    private static final zzji zzanm = new zzkn();
    private static final int zzawr = zzoq.zzbn("qt  ");
    private long zzagj;
    private int zzapi;
    private int zzapj;
    private zzjf zzapm;
    private int zzawu;
    private int zzawv;
    private long zzaww;
    private int zzawx;
    private zzoj zzawy;
    private zzkq[] zzawz;
    private boolean zzaxa;
    private final zzoj zzaws = new zzoj(16);
    private final Stack<zzkc> zzawt = new Stack<>();
    private final zzoj zzant = new zzoj(zzoi.zzbga);
    private final zzoj zzanu = new zzoj(4);

    private final void zzeb(long j) {
        zzle zzleVar;
        zzjh zzjhVar;
        zzks zza;
        while (!this.zzawt.isEmpty() && this.zzawt.peek().zzaum == j) {
            zzkc pop = this.zzawt.pop();
            if (pop.type == zzjz.zzarw) {
                ArrayList arrayList = new ArrayList();
                zzle zzleVar2 = null;
                zzjh zzjhVar2 = new zzjh();
                zzkb zzao = pop.zzao(zzjz.zzatv);
                if (zzao != null && (zzleVar2 = zzke.zza(zzao, this.zzaxa)) != null) {
                    zzjhVar2.zzb(zzleVar2);
                }
                long j2 = Long.MAX_VALUE;
                long j3 = -9223372036854775807L;
                int i = 0;
                while (i < pop.zzauo.size()) {
                    zzkc zzkcVar = pop.zzauo.get(i);
                    if (zzkcVar.type == zzjz.zzary && (zza = zzke.zza(zzkcVar, pop.zzao(zzjz.zzarx), -9223372036854775807L, (zziv) null, this.zzaxa)) != null) {
                        zzku zza2 = zzke.zza(zza, zzkcVar.zzap(zzjz.zzarz).zzap(zzjz.zzasa).zzap(zzjz.zzasb), zzjhVar2);
                        if (zza2.zzavf != 0) {
                            zzkq zzkqVar = new zzkq(zza, zza2, this.zzapm.zzc(i, zza.type));
                            zzgw zzp = zza.zzafz.zzp(zza2.zzawo + 30);
                            if (zza.type == 1) {
                                if (zzjhVar2.zzgk()) {
                                    zzp = zzp.zzb(zzjhVar2.zzafr, zzjhVar2.zzafs);
                                }
                                if (zzleVar2 != null) {
                                    zzp = zzp.zza(zzleVar2);
                                }
                            }
                            zzkqVar.zzaxe.zze(zzp);
                            zzleVar = zzleVar2;
                            zzjhVar = zzjhVar2;
                            j3 = Math.max(j3, zza.zzagj);
                            arrayList.add(zzkqVar);
                            long j4 = zza2.zzamq[0];
                            if (j4 < j2) {
                                j2 = j4;
                            }
                            i++;
                            zzjhVar2 = zzjhVar;
                            zzleVar2 = zzleVar;
                        }
                    }
                    zzleVar = zzleVar2;
                    zzjhVar = zzjhVar2;
                    i++;
                    zzjhVar2 = zzjhVar;
                    zzleVar2 = zzleVar;
                }
                this.zzagj = j3;
                this.zzawz = (zzkq[]) arrayList.toArray(new zzkq[arrayList.size()]);
                this.zzapm.zzgj();
                this.zzapm.zza(this);
                this.zzawt.clear();
                this.zzawu = 2;
            } else if (!this.zzawt.isEmpty()) {
                this.zzawt.peek().zzauo.add(pop);
            }
        }
        if (this.zzawu != 2) {
            zzgt();
        }
    }

    private final void zzgt() {
        this.zzawu = 0;
        this.zzawx = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzjm
    public final long getDurationUs() {
        return this.zzagj;
    }

    @Override // com.google.android.gms.internal.ads.zzjd
    public final void release() {
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x018e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x029b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzjd
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(com.google.android.gms.internal.ads.zzjg r24, com.google.android.gms.internal.ads.zzjj r25) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzko.zza(com.google.android.gms.internal.ads.zzjg, com.google.android.gms.internal.ads.zzjj):int");
    }

    @Override // com.google.android.gms.internal.ads.zzjd
    public final void zza(zzjf zzjfVar) {
        this.zzapm = zzjfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzjd
    public final boolean zza(zzjg zzjgVar) {
        return zzkp.zzd(zzjgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjd
    public final void zzc(long j, long j2) {
        this.zzawt.clear();
        this.zzawx = 0;
        this.zzapj = 0;
        this.zzapi = 0;
        if (j == 0) {
            zzgt();
            return;
        }
        zzkq[] zzkqVarArr = this.zzawz;
        if (zzkqVarArr != null) {
            for (zzkq zzkqVar : zzkqVarArr) {
                zzku zzkuVar = zzkqVar.zzaxd;
                int zzec = zzkuVar.zzec(j2);
                if (zzec == -1) {
                    zzec = zzkuVar.zzed(j2);
                }
                zzkqVar.zzavh = zzec;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjm
    public final long zzdz(long j) {
        long j2 = Long.MAX_VALUE;
        for (zzkq zzkqVar : this.zzawz) {
            zzku zzkuVar = zzkqVar.zzaxd;
            int zzec = zzkuVar.zzec(j);
            if (zzec == -1) {
                zzec = zzkuVar.zzed(j);
            }
            long j3 = zzkuVar.zzamq[zzec];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzjm
    public final boolean zzgh() {
        return true;
    }
}
