package com.google.android.recaptcha.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzpl {
    private static volatile int zza = 100;

    public abstract Object zza(Object obj);

    public abstract Object zzb();

    public abstract Object zzc(Object obj);

    public abstract void zzd(Object obj, int i, int i3);

    public abstract void zze(Object obj, int i, long j2);

    public abstract void zzf(Object obj, int i, Object obj2);

    public abstract void zzg(Object obj, int i, zzle zzleVar);

    public abstract void zzh(Object obj, int i, long j2);

    public abstract void zzi(Object obj);

    public abstract void zzj(Object obj, Object obj2);

    public final boolean zzk(Object obj, zzov zzovVar, int i) {
        int zzd = zzovVar.zzd();
        int i3 = zzd >>> 3;
        int i4 = zzd & 7;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 == 5) {
                                zzd(obj, i3, zzovVar.zzf());
                                return true;
                            }
                            throw new zznm("Protocol message tag had invalid wire type.");
                        }
                        return false;
                    }
                    Object zzb = zzb();
                    int i5 = i3 << 3;
                    int i6 = i + 1;
                    if (i6 >= zza) {
                        throw new zznn("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
                    }
                    while (zzovVar.zzc() != Integer.MAX_VALUE && zzk(zzb, zzovVar, i6)) {
                    }
                    if ((i5 | 4) == zzovVar.zzd()) {
                        zzf(obj, i3, zzc(zzb));
                        return true;
                    }
                    throw new zznn("Protocol message end-group tag did not match expected tag.");
                }
                zzg(obj, i3, zzovVar.zzp());
                return true;
            }
            zze(obj, i3, zzovVar.zzk());
            return true;
        }
        zzh(obj, i3, zzovVar.zzl());
        return true;
    }
}
