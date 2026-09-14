package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdrt;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdrf implements zzdvl {
    private final zzdrb zzhic;

    private zzdrf(zzdrb zzdrbVar) {
        zzdrv.a(zzdrbVar, "output");
        this.zzhic = zzdrbVar;
        this.zzhic.a = this;
    }

    public static zzdrf zza(zzdrb zzdrbVar) {
        zzdrf zzdrfVar = zzdrbVar.a;
        return zzdrfVar != null ? zzdrfVar : new zzdrf(zzdrbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zza(int i, float f) {
        this.zzhic.zza(i, f);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zza(int i, zzdqk zzdqkVar) {
        this.zzhic.zza(i, zzdqkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final <K, V> void zza(int i, zzdsv<K, V> zzdsvVar, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zzhic.zzaa(i, 2);
            this.zzhic.zzfw(zzdsw.a(zzdsvVar, entry.getKey(), entry.getValue()));
            zzdsw.a(this.zzhic, zzdsvVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zza(int i, Object obj, zzdua zzduaVar) {
        this.zzhic.a(i, (zzdte) obj, zzduaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zza(int i, List<String> list) {
        int i2 = 0;
        if (!(list instanceof zzdsl)) {
            while (i2 < list.size()) {
                this.zzhic.zzf(i, list.get(i2));
                i2++;
            }
            return;
        }
        zzdsl zzdslVar = (zzdsl) list;
        while (i2 < list.size()) {
            Object zzgm = zzdslVar.zzgm(i2);
            if (zzgm instanceof String) {
                this.zzhic.zzf(i, (String) zzgm);
            } else {
                this.zzhic.zza(i, (zzdqk) zzgm);
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zza(int i, List<?> list, zzdua zzduaVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzduaVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zza(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzab(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzga(list.get(i4).intValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzfv(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzab(int i, int i2) {
        this.zzhic.zzab(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzac(int i, int i2) {
        this.zzhic.zzac(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzad(int i, int i2) {
        this.zzhic.zzad(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzae(int i, int i2) {
        this.zzhic.zzae(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzal(int i, int i2) {
        this.zzhic.zzae(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzam(int i, int i2) {
        this.zzhic.zzab(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final int zzazg() {
        return zzdrt.zze.zzhnd;
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzb(int i, double d) {
        this.zzhic.zzb(i, d);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzb(int i, Object obj, zzdua zzduaVar) {
        zzdrb zzdrbVar = this.zzhic;
        zzdrbVar.zzaa(i, 3);
        zzduaVar.zza((zzdte) obj, zzdrbVar.a);
        zzdrbVar.zzaa(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzb(int i, List<zzdqk> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzhic.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzb(int i, List<?> list, zzdua zzduaVar) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzduaVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzb(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzae(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzgd(list.get(i4).intValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzfy(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzc(int i, Object obj) {
        if (obj instanceof zzdqk) {
            this.zzhic.zzb(i, (zzdqk) obj);
        } else {
            this.zzhic.zzb(i, (zzdte) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzc(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzg(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzfj(list.get(i4).longValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzfg(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzd(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzg(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzfk(list.get(i4).longValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzfg(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zze(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzi(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzfm(list.get(i4).longValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzfi(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzf(int i, String str) {
        this.zzhic.zzf(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzf(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zza(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzg(list.get(i4).floatValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzf(list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzg(int i, long j) {
        this.zzhic.zzg(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzg(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzb(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzc(list.get(i4).doubleValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzb(list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzgi(int i) {
        this.zzhic.zzaa(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzgj(int i) {
        this.zzhic.zzaa(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzh(int i, long j) {
        this.zzhic.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzh(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzab(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzgf(list.get(i4).intValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzfv(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzh(int i, boolean z) {
        this.zzhic.zzh(i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzi(int i, long j) {
        this.zzhic.zzi(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzi(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzh(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzbo(list.get(i4).booleanValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzbn(list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzj(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzac(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzgb(list.get(i4).intValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzfw(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzk(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzae(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzge(list.get(i4).intValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzfy(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzl(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzi(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzfn(list.get(i4).longValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzfi(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzm(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzad(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzgc(list.get(i4).intValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzfx(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzn(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zzhic.zzh(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zzhic.zzaa(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += zzdrb.zzfl(list.get(i4).longValue());
        }
        this.zzhic.zzfw(i3);
        while (i2 < list.size()) {
            this.zzhic.zzfh(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzo(int i, long j) {
        this.zzhic.zzg(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzdvl
    public final void zzp(int i, long j) {
        this.zzhic.zzi(i, j);
    }
}
