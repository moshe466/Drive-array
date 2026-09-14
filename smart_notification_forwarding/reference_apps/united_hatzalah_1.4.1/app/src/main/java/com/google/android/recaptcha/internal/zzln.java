package com.google.android.recaptcha.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzln extends zzkw {
    private static final Logger zzb = Logger.getLogger(zzln.class.getName());
    private static final boolean zzc = zzps.zzx();
    zzlo zza;

    private zzln() {
        throw null;
    }

    public static int zzA(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzB(long j2) {
        return (640 - (Long.numberOfLeadingZeros(j2) * 9)) >>> 6;
    }

    @Deprecated
    public static int zzw(int i, zzoi zzoiVar, zzow zzowVar) {
        int zzA = zzA(i << 3);
        return ((zzko) zzoiVar).zza(zzowVar) + zzA + zzA;
    }

    public static int zzx(zzoi zzoiVar) {
        int zzo = zzoiVar.zzo();
        return zzA(zzo) + zzo;
    }

    public static int zzy(zzoi zzoiVar, zzow zzowVar) {
        int zza = ((zzko) zzoiVar).zza(zzowVar);
        return zzA(zza) + zza;
    }

    public static int zzz(String str) {
        int length;
        try {
            length = zzpv.zzc(str);
        } catch (zzpu unused) {
            length = str.getBytes(zznl.zza).length;
        }
        return zzA(length) + length;
    }

    public final void zzC() {
        if (zza() == 0) {
        } else {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzD(String str, zzpu zzpuVar) {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzpuVar);
        byte[] bytes = str.getBytes(zznl.zza);
        try {
            int length = bytes.length;
            zzt(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e4) {
            throw new zzll(e4);
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b4);

    public abstract void zzd(int i, boolean z3);

    public abstract void zze(int i, zzle zzleVar);

    public abstract void zzf(int i, int i3);

    public abstract void zzg(int i);

    public abstract void zzh(int i, long j2);

    public abstract void zzi(long j2);

    public abstract void zzj(int i, int i3);

    public abstract void zzk(int i);

    public abstract void zzl(byte[] bArr, int i, int i3);

    public abstract void zzm(int i, zzoi zzoiVar, zzow zzowVar);

    public abstract void zzn(int i, zzoi zzoiVar);

    public abstract void zzo(int i, zzle zzleVar);

    public abstract void zzp(int i, String str);

    public abstract void zzr(int i, int i3);

    public abstract void zzs(int i, int i3);

    public abstract void zzt(int i);

    public abstract void zzu(int i, long j2);

    public abstract void zzv(long j2);

    public /* synthetic */ zzln(zzlm zzlmVar) {
    }
}
