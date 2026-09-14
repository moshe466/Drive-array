package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
abstract class zzano<T, B> {
    private static volatile int zza = 100;

    public abstract int zza(T t3);

    public abstract B zza();

    public abstract T zza(T t3, T t4);

    public abstract void zza(B b4, int i, int i3);

    public abstract void zza(B b4, int i, long j2);

    public abstract void zza(B b4, int i, zzajp zzajpVar);

    public abstract void zza(B b4, int i, T t3);

    public abstract void zza(T t3, zzaof zzaofVar);

    public abstract boolean zza(zzams zzamsVar);

    public final boolean zza(B b4, zzams zzamsVar, int i) {
        int zzd = zzamsVar.zzd();
        int i3 = zzd >>> 3;
        int i4 = zzd & 7;
        if (i4 == 0) {
            zzb(b4, i3, zzamsVar.zzl());
            return true;
        }
        if (i4 == 1) {
            zza((zzano<T, B>) b4, i3, zzamsVar.zzk());
            return true;
        }
        if (i4 == 2) {
            zza((zzano<T, B>) b4, i3, zzamsVar.zzp());
            return true;
        }
        if (i4 != 3) {
            if (i4 == 4) {
                if (i != 0) {
                    return false;
                }
                throw zzalf.zzb();
            }
            if (i4 == 5) {
                zza((zzano<T, B>) b4, i3, zzamsVar.zzf());
                return true;
            }
            throw zzalf.zza();
        }
        B zza2 = zza();
        int i5 = 4 | (i3 << 3);
        int i6 = i + 1;
        if (i6 >= zza) {
            throw zzalf.zzh();
        }
        while (zzamsVar.zzc() != Integer.MAX_VALUE && zza((zzano<T, B>) zza2, zzamsVar, i6)) {
        }
        if (i5 == zzamsVar.zzd()) {
            zza((zzano<T, B>) b4, i3, (int) zze(zza2));
            return true;
        }
        throw zzalf.zzb();
    }

    public abstract int zzb(T t3);

    public abstract void zzb(B b4, int i, long j2);

    public abstract void zzb(T t3, zzaof zzaofVar);

    public abstract void zzb(Object obj, B b4);

    public abstract B zzc(Object obj);

    public abstract void zzc(Object obj, T t3);

    public abstract T zzd(Object obj);

    public abstract T zze(B b4);

    public abstract void zzf(Object obj);
}
