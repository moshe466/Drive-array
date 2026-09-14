package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public abstract class zzeg {
    int a;
    int b;
    zzel c;
    private int zzd;
    private boolean zze;

    private zzeg() {
        this.b = 100;
        this.zzd = Integer.MAX_VALUE;
        this.zze = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeg a(byte[] bArr, int i, int i2, boolean z) {
        zzei zzeiVar = new zzei(bArr, 0, i2, false);
        try {
            zzeiVar.zzc(i2);
            return zzeiVar;
        } catch (zzfo e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static long zza(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static int zze(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public abstract int zza();

    public abstract void zza(int i);

    public abstract double zzb();

    public abstract boolean zzb(int i);

    public abstract float zzc();

    public abstract int zzc(int i);

    public abstract long zzd();

    public abstract void zzd(int i);

    public abstract long zze();

    public abstract int zzf();

    public abstract long zzg();

    public abstract int zzh();

    public abstract boolean zzi();

    public abstract String zzj();

    public abstract String zzk();

    public abstract zzdu zzl();

    public abstract int zzm();

    public abstract int zzn();

    public abstract int zzo();

    public abstract long zzp();

    public abstract int zzq();

    public abstract long zzr();

    public abstract boolean zzt();

    public abstract int zzu();
}
