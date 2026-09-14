package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzakj implements zzaof {
    private final zzakg zza;

    private zzakj(zzakg zzakgVar) {
        zzakg zzakgVar2 = (zzakg) zzalb.zza(zzakgVar, "output");
        this.zza = zzakgVar2;
        zzakgVar2.zze = this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzb(int i, List<Double> list, boolean z3) {
        int i3 = 0;
        if (!(list instanceof zzaki)) {
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += zzakg.zza(list.get(i5).doubleValue());
                }
                this.zza.zzn(i4);
                while (i3 < list.size()) {
                    this.zza.zzb(list.get(i3).doubleValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                this.zza.zzb(i, list.get(i3).doubleValue());
                i3++;
            }
            return;
        }
        zzaki zzakiVar = (zzaki) list;
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < zzakiVar.size(); i7++) {
                i6 += zzakg.zza(zzakiVar.zzb(i7));
            }
            this.zza.zzn(i6);
            while (i3 < zzakiVar.size()) {
                this.zza.zzb(zzakiVar.zzb(i3));
                i3++;
            }
            return;
        }
        while (i3 < zzakiVar.size()) {
            this.zza.zzb(i, zzakiVar.zzb(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzc(int i, List<Integer> list, boolean z3) {
        int i3 = 0;
        if (!(list instanceof zzakz)) {
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += zzakg.zzc(list.get(i5).intValue());
                }
                this.zza.zzn(i4);
                while (i3 < list.size()) {
                    this.zza.zzl(list.get(i3).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                this.zza.zzi(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        zzakz zzakzVar = (zzakz) list;
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < zzakzVar.size(); i7++) {
                i6 += zzakg.zzc(zzakzVar.zzb(i7));
            }
            this.zza.zzn(i6);
            while (i3 < zzakzVar.size()) {
                this.zza.zzl(zzakzVar.zzb(i3));
                i3++;
            }
            return;
        }
        while (i3 < zzakzVar.size()) {
            this.zza.zzi(i, zzakzVar.zzb(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzd(int i, List<Integer> list, boolean z3) {
        int i3 = 0;
        if (!(list instanceof zzakz)) {
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += zzakg.zzd(list.get(i5).intValue());
                }
                this.zza.zzn(i4);
                while (i3 < list.size()) {
                    this.zza.zzk(list.get(i3).intValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                this.zza.zzh(i, list.get(i3).intValue());
                i3++;
            }
            return;
        }
        zzakz zzakzVar = (zzakz) list;
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < zzakzVar.size(); i7++) {
                i6 += zzakg.zzd(zzakzVar.zzb(i7));
            }
            this.zza.zzn(i6);
            while (i3 < zzakzVar.size()) {
                this.zza.zzk(zzakzVar.zzb(i3));
                i3++;
            }
            return;
        }
        while (i3 < zzakzVar.size()) {
            this.zza.zzh(i, zzakzVar.zzb(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zze(int i, List<Long> list, boolean z3) {
        int i3 = 0;
        if (!(list instanceof zzalr)) {
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += zzakg.zzc(list.get(i5).longValue());
                }
                this.zza.zzn(i4);
                while (i3 < list.size()) {
                    this.zza.zzh(list.get(i3).longValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                this.zza.zzf(i, list.get(i3).longValue());
                i3++;
            }
            return;
        }
        zzalr zzalrVar = (zzalr) list;
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < zzalrVar.size(); i7++) {
                i6 += zzakg.zzc(zzalrVar.zzb(i7));
            }
            this.zza.zzn(i6);
            while (i3 < zzalrVar.size()) {
                this.zza.zzh(zzalrVar.zzb(i3));
                i3++;
            }
            return;
        }
        while (i3 < zzalrVar.size()) {
            this.zza.zzf(i, zzalrVar.zzb(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzf(int i, List<Float> list, boolean z3) {
        int i3 = 0;
        if (!(list instanceof zzakx)) {
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += zzakg.zza(list.get(i5).floatValue());
                }
                this.zza.zzn(i4);
                while (i3 < list.size()) {
                    this.zza.zzb(list.get(i3).floatValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                this.zza.zzb(i, list.get(i3).floatValue());
                i3++;
            }
            return;
        }
        zzakx zzakxVar = (zzakx) list;
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < zzakxVar.size(); i7++) {
                i6 += zzakg.zza(zzakxVar.zzb(i7));
            }
            this.zza.zzn(i6);
            while (i3 < zzakxVar.size()) {
                this.zza.zzb(zzakxVar.zzb(i3));
                i3++;
            }
            return;
        }
        while (i3 < zzakxVar.size()) {
            this.zza.zzb(i, zzakxVar.zzb(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzg(int i, List<Integer> list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzakz) {
            zzakz zzakzVar = (zzakz) list;
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzakzVar.size(); i5++) {
                    i4 += zzakg.zze(zzakzVar.zzb(i5));
                }
                this.zza.zzn(i4);
                while (i3 < zzakzVar.size()) {
                    this.zza.zzl(zzakzVar.zzb(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzakzVar.size()) {
                this.zza.zzi(i, zzakzVar.zzb(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzakg.zze(list.get(i7).intValue());
            }
            this.zza.zzn(i6);
            while (i3 < list.size()) {
                this.zza.zzl(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzi(i, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzh(int i, List<Long> list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzalr) {
            zzalr zzalrVar = (zzalr) list;
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzalrVar.size(); i5++) {
                    i4 += zzakg.zzd(zzalrVar.zzb(i5));
                }
                this.zza.zzn(i4);
                while (i3 < zzalrVar.size()) {
                    this.zza.zzj(zzalrVar.zzb(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzalrVar.size()) {
                this.zza.zzh(i, zzalrVar.zzb(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzakg.zzd(list.get(i7).longValue());
            }
            this.zza.zzn(i6);
            while (i3 < list.size()) {
                this.zza.zzj(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzh(i, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzi(int i, List<Integer> list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzakz) {
            zzakz zzakzVar = (zzakz) list;
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzakzVar.size(); i5++) {
                    i4 += zzakg.zzg(zzakzVar.zzb(i5));
                }
                this.zza.zzn(i4);
                while (i3 < zzakzVar.size()) {
                    this.zza.zzk(zzakzVar.zzb(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzakzVar.size()) {
                this.zza.zzh(i, zzakzVar.zzb(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzakg.zzg(list.get(i7).intValue());
            }
            this.zza.zzn(i6);
            while (i3 < list.size()) {
                this.zza.zzk(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzh(i, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzj(int i, List<Long> list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzalr) {
            zzalr zzalrVar = (zzalr) list;
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzalrVar.size(); i5++) {
                    i4 += zzakg.zze(zzalrVar.zzb(i5));
                }
                this.zza.zzn(i4);
                while (i3 < zzalrVar.size()) {
                    this.zza.zzh(zzalrVar.zzb(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzalrVar.size()) {
                this.zza.zzf(i, zzalrVar.zzb(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzakg.zze(list.get(i7).longValue());
            }
            this.zza.zzn(i6);
            while (i3 < list.size()) {
                this.zza.zzh(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzf(i, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzk(int i, List<Integer> list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzakz) {
            zzakz zzakzVar = (zzakz) list;
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzakzVar.size(); i5++) {
                    i4 += zzakg.zzh(zzakzVar.zzb(i5));
                }
                this.zza.zzn(i4);
                while (i3 < zzakzVar.size()) {
                    this.zza.zzm(zzakzVar.zzb(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzakzVar.size()) {
                this.zza.zzj(i, zzakzVar.zzb(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzakg.zzh(list.get(i7).intValue());
            }
            this.zza.zzn(i6);
            while (i3 < list.size()) {
                this.zza.zzm(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzj(i, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzl(int i, List<Long> list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzalr) {
            zzalr zzalrVar = (zzalr) list;
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzalrVar.size(); i5++) {
                    i4 += zzakg.zzf(zzalrVar.zzb(i5));
                }
                this.zza.zzn(i4);
                while (i3 < zzalrVar.size()) {
                    this.zza.zzi(zzalrVar.zzb(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzalrVar.size()) {
                this.zza.zzg(i, zzalrVar.zzb(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzakg.zzf(list.get(i7).longValue());
            }
            this.zza.zzn(i6);
            while (i3 < list.size()) {
                this.zza.zzi(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzg(i, list.get(i3).longValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzm(int i, List<Integer> list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzakz) {
            zzakz zzakzVar = (zzakz) list;
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzakzVar.size(); i5++) {
                    i4 += zzakg.zzj(zzakzVar.zzb(i5));
                }
                this.zza.zzn(i4);
                while (i3 < zzakzVar.size()) {
                    this.zza.zzn(zzakzVar.zzb(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzakzVar.size()) {
                this.zza.zzl(i, zzakzVar.zzb(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzakg.zzj(list.get(i7).intValue());
            }
            this.zza.zzn(i6);
            while (i3 < list.size()) {
                this.zza.zzn(list.get(i3).intValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzl(i, list.get(i3).intValue());
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzn(int i, List<Long> list, boolean z3) {
        int i3 = 0;
        if (list instanceof zzalr) {
            zzalr zzalrVar = (zzalr) list;
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < zzalrVar.size(); i5++) {
                    i4 += zzakg.zzg(zzalrVar.zzb(i5));
                }
                this.zza.zzn(i4);
                while (i3 < zzalrVar.size()) {
                    this.zza.zzj(zzalrVar.zzb(i3));
                    i3++;
                }
                return;
            }
            while (i3 < zzalrVar.size()) {
                this.zza.zzh(i, zzalrVar.zzb(i3));
                i3++;
            }
            return;
        }
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < list.size(); i7++) {
                i6 += zzakg.zzg(list.get(i7).longValue());
            }
            this.zza.zzn(i6);
            while (i3 < list.size()) {
                this.zza.zzj(list.get(i3).longValue());
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzh(i, list.get(i3).longValue());
            i3++;
        }
    }

    public static zzakj zza(zzakg zzakgVar) {
        zzakj zzakjVar = zzakgVar.zze;
        return zzakjVar != null ? zzakjVar : new zzakj(zzakgVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i, boolean z3) {
        this.zza.zzb(i, z3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i, List<Boolean> list, boolean z3) {
        int i3 = 0;
        if (!(list instanceof zzajn)) {
            if (z3) {
                this.zza.zzk(i, 2);
                int i4 = 0;
                for (int i5 = 0; i5 < list.size(); i5++) {
                    i4 += zzakg.zza(list.get(i5).booleanValue());
                }
                this.zza.zzn(i4);
                while (i3 < list.size()) {
                    this.zza.zzb(list.get(i3).booleanValue());
                    i3++;
                }
                return;
            }
            while (i3 < list.size()) {
                this.zza.zzb(i, list.get(i3).booleanValue());
                i3++;
            }
            return;
        }
        zzajn zzajnVar = (zzajn) list;
        if (z3) {
            this.zza.zzk(i, 2);
            int i6 = 0;
            for (int i7 = 0; i7 < zzajnVar.size(); i7++) {
                i6 += zzakg.zza(zzajnVar.zzb(i7));
            }
            this.zza.zzn(i6);
            while (i3 < zzajnVar.size()) {
                this.zza.zzb(zzajnVar.zzb(i3));
                i3++;
            }
            return;
        }
        while (i3 < zzajnVar.size()) {
            this.zza.zzb(i, zzajnVar.zzb(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzb(int i, int i3) {
        this.zza.zzh(i, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzd(int i, int i3) {
        this.zza.zzh(i, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zze(int i, int i3) {
        this.zza.zzj(i, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzf(int i, int i3) {
        this.zza.zzl(i, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzb(int i, long j2) {
        this.zza.zzh(i, j2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zze(int i, long j2) {
        this.zza.zzh(i, j2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzd(int i, long j2) {
        this.zza.zzg(i, j2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzb(int i, Object obj, zzamv zzamvVar) {
        this.zza.zzc(i, (zzamc) obj, zzamvVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i, zzajp zzajpVar) {
        this.zza.zzc(i, zzajpVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzb(int i, List<?> list, zzamv zzamvVar) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            zzb(i, list.get(i3), zzamvVar);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzc(int i, int i3) {
        this.zza.zzi(i, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i, List<zzajp> list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.zza.zzc(i, list.get(i3));
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzc(int i, long j2) {
        this.zza.zzf(i, j2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    @Deprecated
    public final void zzb(int i) {
        this.zza.zzk(i, 3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i, double d2) {
        this.zza.zzb(i, d2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zzb(int i, List<String> list) {
        int i3 = 0;
        if (list instanceof zzaln) {
            zzaln zzalnVar = (zzaln) list;
            while (i3 < list.size()) {
                Object zza = zzalnVar.zza(i3);
                if (zza instanceof String) {
                    this.zza.zzb(i, (String) zza);
                } else {
                    this.zza.zzc(i, (zzajp) zza);
                }
                i3++;
            }
            return;
        }
        while (i3 < list.size()) {
            this.zza.zzb(i, list.get(i3));
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    @Deprecated
    public final void zza(int i) {
        this.zza.zzk(i, 4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i, int i3) {
        this.zza.zzi(i, i3);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i, long j2) {
        this.zza.zzf(i, j2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i, float f4) {
        this.zza.zzb(i, f4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i, Object obj, zzamv zzamvVar) {
        zzakg zzakgVar = this.zza;
        zzakgVar.zzk(i, 3);
        zzamvVar.zza((zzamv) obj, (zzaof) zzakgVar.zze);
        zzakgVar.zzk(i, 4);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i, List<?> list, zzamv zzamvVar) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            zza(i, list.get(i3), zzamvVar);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final <K, V> void zza(int i, zzalx<K, V> zzalxVar, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zza.zzk(i, 2);
            this.zza.zzn(zzalu.zza(zzalxVar, entry.getKey(), entry.getValue()));
            zzalu.zza(this.zza, zzalxVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i, Object obj) {
        if (obj instanceof zzajp) {
            this.zza.zzd(i, (zzajp) obj);
        } else {
            this.zza.zzb(i, (zzamc) obj);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaof
    public final void zza(int i, String str) {
        this.zza.zzb(i, str);
    }
}
