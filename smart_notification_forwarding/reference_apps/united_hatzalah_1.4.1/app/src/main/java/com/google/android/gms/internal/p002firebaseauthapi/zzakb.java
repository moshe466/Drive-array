package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public abstract class zzakb {
    private static volatile int zzd = 100;
    int zza;
    int zzb;
    zzakf zzc;
    private int zze;
    private int zzf;

    public static long zza(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    public static int zze(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract double zza();

    public abstract int zza(int i);

    public abstract float zzb();

    public abstract void zzb(int i);

    public abstract int zzc();

    public abstract void zzc(int i);

    public abstract int zzd();

    public abstract boolean zzd(int i);

    public abstract int zze();

    public abstract int zzf();

    public abstract int zzg();

    public abstract int zzh();

    public abstract int zzi();

    public abstract int zzj();

    public abstract long zzk();

    public abstract long zzl();

    public abstract long zzm();

    public abstract long zzn();

    public abstract long zzo();

    public abstract long zzp();

    public abstract zzajp zzq();

    public abstract String zzr();

    public abstract String zzs();

    public abstract boolean zzt();

    public abstract boolean zzu();

    public final void zzv() {
        if (this.zza + this.zze < this.zzf) {
        } else {
            throw zzalf.zzh();
        }
    }

    public final void zzw() {
        if (this.zze == 0) {
            zzb(0);
        }
    }

    public final void zzx() {
        int zzi;
        do {
            zzi = zzi();
            if (zzi != 0) {
                zzv();
                this.zze++;
                this.zze--;
            } else {
                return;
            }
        } while (zzd(zzi));
    }

    private zzakb() {
        this.zzf = zzd;
        this.zzb = Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public static zzakb zza(byte[] bArr, int i, int i3, boolean z3) {
        zzaka zzakaVar = new zzaka(bArr, i, i3, z3);
        try {
            zzakaVar.zza(i3);
            return zzakaVar;
        } catch (zzalf e4) {
            throw new IllegalArgumentException(e4);
        }
    }
}
