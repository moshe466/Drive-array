package com.google.android.gms.internal.auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
final class zzhi {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class zzc;
    private static final boolean zzd;
    private static final zzhh zze;
    private static final boolean zzf;
    private static final boolean zzg;

    /* JADX WARN: Removed duplicated region for block: B:15:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    static {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzhi.<clinit>():void");
    }

    private zzhi() {
    }

    public static double zza(Object obj, long j2) {
        return zze.zza(obj, j2);
    }

    public static float zzb(Object obj, long j2) {
        return zze.zzb(obj, j2);
    }

    public static int zzc(Object obj, long j2) {
        return zze.zzi(obj, j2);
    }

    public static long zzd(Object obj, long j2) {
        return zze.zzj(obj, j2);
    }

    public static Object zze(Class cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public static Object zzf(Object obj, long j2) {
        return zze.zzl(obj, j2);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzhe());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void zzh(Throwable th) {
        Logger.getLogger(zzhi.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static /* synthetic */ void zzi(Object obj, long j2, boolean z3) {
        long j3 = (-4) & j2;
        zzhh zzhhVar = zze;
        int zzi = zzhhVar.zzi(obj, j3);
        int i = ((~((int) j2)) & 3) << 3;
        zzhhVar.zzm(obj, j3, ((z3 ? 1 : 0) << i) | ((~(255 << i)) & zzi));
    }

    public static /* synthetic */ void zzj(Object obj, long j2, boolean z3) {
        long j3 = (-4) & j2;
        zzhh zzhhVar = zze;
        int i = (((int) j2) & 3) << 3;
        zzhhVar.zzm(obj, j3, ((z3 ? 1 : 0) << i) | ((~(255 << i)) & zzhhVar.zzi(obj, j3)));
    }

    public static void zzk(Object obj, long j2, boolean z3) {
        zze.zzc(obj, j2, z3);
    }

    public static void zzl(Object obj, long j2, double d2) {
        zze.zzd(obj, j2, d2);
    }

    public static void zzm(Object obj, long j2, float f4) {
        zze.zze(obj, j2, f4);
    }

    public static void zzn(Object obj, long j2, int i) {
        zze.zzm(obj, j2, i);
    }

    public static void zzo(Object obj, long j2, long j3) {
        zze.zzn(obj, j2, j3);
    }

    public static void zzp(Object obj, long j2, Object obj2) {
        zze.zzo(obj, j2, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzq(Object obj, long j2) {
        if (((byte) ((zze.zzi(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ boolean zzr(Object obj, long j2) {
        if (((byte) ((zze.zzi(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static boolean zzs(Class cls) {
        int i = zzdr.zza;
        try {
            Class cls2 = zzc;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zzt(Object obj, long j2) {
        return zze.zzf(obj, j2);
    }

    public static boolean zzu() {
        return zzg;
    }

    public static boolean zzv() {
        return zzf;
    }

    private static int zzw(Class cls) {
        if (zzg) {
            return zze.zzg(cls);
        }
        return -1;
    }

    private static int zzx(Class cls) {
        if (zzg) {
            return zze.zzh(cls);
        }
        return -1;
    }

    private static Field zzy() {
        int i = zzdr.zza;
        Field zzz = zzz(Buffer.class, "effectiveDirectAddress");
        if (zzz == null) {
            Field zzz2 = zzz(Buffer.class, "address");
            if (zzz2 != null && zzz2.getType() == Long.TYPE) {
                return zzz2;
            }
            return null;
        }
        return zzz;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
