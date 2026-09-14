package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzsy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
final class zzdba implements zzdbb {

    @GuardedBy("this")
    private final ConcurrentHashMap<zzdbl, zzday> zzgnt;
    private zzdbe zzgnu;
    private zzdbc zzgnv = new zzdbc();

    public zzdba(zzdbe zzdbeVar) {
        this.zzgnt = new ConcurrentHashMap<>(zzdbeVar.zzgoj);
        this.zzgnu = zzdbeVar;
    }

    private final void dumpToLog() {
        if (zzdbe.zzapl()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzgnu.zzgoh);
            sb.append(" PoolCollection");
            sb.append(this.zzgnv.zzapk());
            int i = 0;
            for (Map.Entry<zzdbl, zzday> entry : this.zzgnt.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(entry.getKey().hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < entry.getValue().size(); i2++) {
                    sb.append("[O]");
                }
                for (int size = entry.getValue().size(); size < this.zzgnu.zzgoj; size++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(entry.getValue().zzapa());
                sb.append("\n");
            }
            while (i < this.zzgnu.zzgoi) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzayu.zzea(sb.toString());
        }
    }

    private final void zza(zzdbi<?> zzdbiVar, zzdbo zzdboVar) {
        if (zzdbiVar != null) {
            zzdbiVar.zzgpc.zzahb().zza((zzsy.zza) zzsy.zza.zzmz().zza(zzsy.zza.C0024zza.zzmx().zzb(zzsy.zza.zzc.IN_MEMORY).zza(zzsy.zza.zzd.zznb().zzt(zzdboVar.zzgpi).zzbu(zzdboVar.zzgpj))).zzbaf());
        }
        dumpToLog();
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    @Nullable
    public final synchronized zzdbi<?> zza(zzdbl zzdblVar) {
        zzdbi<?> zzdbiVar;
        zzday zzdayVar = this.zzgnt.get(zzdblVar);
        zzdbiVar = null;
        if (zzdayVar != null) {
            zzdbiVar = zzdayVar.zzaox();
            if (zzdbiVar == null) {
                this.zzgnv.zzapf();
            }
            zza(zzdbiVar, zzdayVar.zzapb());
        } else {
            this.zzgnv.zzape();
            zza((zzdbi<?>) null, (zzdbo) null);
        }
        return zzdbiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final zzdbl zza(zzug zzugVar, String str, zzuo zzuoVar) {
        return new zzdbk(zzugVar, str, new zzaqs(this.zzgnu.zzup).zzug().zzdmo, this.zzgnu.zzgol, zzuoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final synchronized boolean zza(zzdbl zzdblVar, zzdbi<?> zzdbiVar) {
        boolean zzb;
        ConcurrentHashMap<zzdbl, zzday> concurrentHashMap;
        zzday zzdayVar = this.zzgnt.get(zzdblVar);
        zzdbiVar.zzgpe = com.google.android.gms.ads.internal.zzq.zzkx().currentTimeMillis();
        if (zzdayVar == null) {
            zzdayVar = new zzday(this.zzgnu.zzgoj, this.zzgnu.zzgok * 1000);
            if (this.zzgnt.size() == this.zzgnu.zzgoi) {
                int i = zzdbd.a[this.zzgnu.zzgon - 1];
                long j = Long.MAX_VALUE;
                zzdbl zzdblVar2 = null;
                if (i == 1) {
                    for (Map.Entry<zzdbl, zzday> entry : this.zzgnt.entrySet()) {
                        if (entry.getValue().getCreationTimeMillis() < j) {
                            j = entry.getValue().getCreationTimeMillis();
                            zzdblVar2 = entry.getKey();
                        }
                    }
                    if (zzdblVar2 != null) {
                        concurrentHashMap = this.zzgnt;
                        concurrentHashMap.remove(zzdblVar2);
                    }
                    this.zzgnv.zzaph();
                } else if (i != 2) {
                    if (i == 3) {
                        int i2 = Integer.MAX_VALUE;
                        for (Map.Entry<zzdbl, zzday> entry2 : this.zzgnt.entrySet()) {
                            if (entry2.getValue().zzaoz() < i2) {
                                i2 = entry2.getValue().zzaoz();
                                zzdblVar2 = entry2.getKey();
                            }
                        }
                        if (zzdblVar2 != null) {
                            concurrentHashMap = this.zzgnt;
                            concurrentHashMap.remove(zzdblVar2);
                        }
                    }
                    this.zzgnv.zzaph();
                } else {
                    for (Map.Entry<zzdbl, zzday> entry3 : this.zzgnt.entrySet()) {
                        if (entry3.getValue().zzaoy() < j) {
                            j = entry3.getValue().zzaoy();
                            zzdblVar2 = entry3.getKey();
                        }
                    }
                    if (zzdblVar2 != null) {
                        concurrentHashMap = this.zzgnt;
                        concurrentHashMap.remove(zzdblVar2);
                    }
                    this.zzgnv.zzaph();
                }
            }
            this.zzgnt.put(zzdblVar, zzdayVar);
            this.zzgnv.zzapg();
        }
        zzb = zzdayVar.zzb(zzdbiVar);
        this.zzgnv.zzapi();
        zzdbf zzapj = this.zzgnv.zzapj();
        zzdbo zzapb = zzdayVar.zzapb();
        if (zzdbiVar != null) {
            zzdbiVar.zzgpc.zzahb().zzb((zzsy.zza) ((zzdrt) zzsy.zza.zzmz().zza(zzsy.zza.C0024zza.zzmx().zzb(zzsy.zza.zzc.IN_MEMORY).zza(zzsy.zza.zze.zznd().zzu(zzapj.zzgoq).zzv(zzapj.zzgor).zzbv(zzapb.zzgpj))).zzbaf()));
        }
        dumpToLog();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdbb
    public final synchronized boolean zzb(zzdbl zzdblVar) {
        zzday zzdayVar = this.zzgnt.get(zzdblVar);
        if (zzdayVar != null) {
            return zzdayVar.size() < this.zzgnu.zzgoj;
        }
        return true;
    }
}
