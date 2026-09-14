package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzduy {
    static final long a;
    static final boolean b;
    private static final boolean zzhiu;
    private static final zzc zzhrl;
    private static final boolean zzhrm;
    private static final long zzhro;
    private static final long zzhrp;
    private static final long zzhrq;
    private static final long zzhrr;
    private static final long zzhrs;
    private static final long zzhrt;
    private static final long zzhru;
    private static final long zzhrv;
    private static final long zzhrw;
    private static final long zzhrx;
    private static final long zzhry;
    private static final long zzhrz;
    private static final long zzhsa;
    private static final int zzhsb;
    private static final Logger logger = Logger.getLogger(zzduy.class.getName());
    private static final Unsafe zzgvq = c();
    private static final Class<?> zzhho = zzdqd.b();
    private static final boolean zzhrj = zzm(Long.TYPE);
    private static final boolean zzhrk = zzm(Integer.TYPE);

    /* loaded from: classes.dex */
    static final class zza extends zzc {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(Object obj, long j, boolean z) {
            if (zzduy.b) {
                zzduy.zzb(obj, j, z);
            } else {
                zzduy.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zze(Object obj, long j, byte b) {
            if (zzduy.b) {
                zzduy.zza(obj, j, b);
            } else {
                zzduy.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final boolean zzm(Object obj, long j) {
            return zzduy.b ? zzduy.zzs(obj, j) : zzduy.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final byte zzy(Object obj, long j) {
            return zzduy.b ? zzduy.zzq(obj, j) : zzduy.zzr(obj, j);
        }
    }

    /* loaded from: classes.dex */
    static final class zzb extends zzc {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(long j, byte b) {
            Memory.pokeByte((int) (j & (-1)), b);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(Object obj, long j, boolean z) {
            if (zzduy.b) {
                zzduy.zzb(obj, j, z);
            } else {
                zzduy.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & (-1)), bArr, (int) j, (int) j3);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zze(Object obj, long j, byte b) {
            if (zzduy.b) {
                zzduy.zza(obj, j, b);
            } else {
                zzduy.zzb(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final boolean zzm(Object obj, long j) {
            return zzduy.b ? zzduy.zzs(obj, j) : zzduy.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final byte zzy(Object obj, long j) {
            return zzduy.b ? zzduy.zzq(obj, j) : zzduy.zzr(obj, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class zzc {
        Unsafe a;

        zzc(Unsafe unsafe) {
            this.a = unsafe;
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, long j2) {
            this.a.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public final void zzb(Object obj, long j, int i) {
            this.a.putInt(obj, j, i);
        }

        public abstract void zze(Object obj, long j, byte b);

        public final int zzk(Object obj, long j) {
            return this.a.getInt(obj, j);
        }

        public final long zzl(Object obj, long j) {
            return this.a.getLong(obj, j);
        }

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);
    }

    /* loaded from: classes.dex */
    static final class zzd extends zzc {
        zzd(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(long j, byte b) {
            this.a.putByte(j, b);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.a.copyMemory(bArr, zzduy.a + j, (Object) null, j2, j3);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final void zze(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final boolean zzm(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final float zzn(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final double zzo(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzduy.zzc
        public final byte zzy(Object obj, long j) {
            return this.a.getByte(obj, j);
        }
    }

    static {
        zzc zzcVar;
        zzc zzcVar2 = null;
        if (zzgvq != null) {
            if (!zzdqd.a()) {
                zzcVar2 = new zzd(zzgvq);
            } else if (zzhrj) {
                zzcVar2 = new zza(zzgvq);
            } else if (zzhrk) {
                zzcVar2 = new zzb(zzgvq);
            }
        }
        zzhrl = zzcVar2;
        zzhrm = zzbcn();
        zzhiu = zzbcm();
        a = zzk(byte[].class);
        zzhro = zzk(boolean[].class);
        zzhrp = zzl(boolean[].class);
        zzhrq = zzk(int[].class);
        zzhrr = zzl(int[].class);
        zzhrs = zzk(long[].class);
        zzhrt = zzl(long[].class);
        zzhru = zzk(float[].class);
        zzhrv = zzl(float[].class);
        zzhrw = zzk(double[].class);
        zzhrx = zzl(double[].class);
        zzhry = zzk(Object[].class);
        zzhrz = zzl(Object[].class);
        Field zzbco = zzbco();
        zzhsa = (zzbco == null || (zzcVar = zzhrl) == null) ? -1L : zzcVar.a.objectFieldOffset(zzbco);
        zzhsb = (int) (a & 7);
        b = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zzduy() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte a(byte[] bArr, long j) {
        return zzhrl.zzy(bArr, a + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Object obj, long j) {
        return zzhrl.zzk(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(ByteBuffer byteBuffer) {
        return zzhrl.zzl(byteBuffer, zzhsa);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(Class<T> cls) {
        try {
            return (T) zzgvq.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j, byte b2) {
        zzhrl.zza(j, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j, double d) {
        zzhrl.zza(obj, j, d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j, float f) {
        zzhrl.zza(obj, j, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j, int i) {
        zzhrl.zzb(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j, long j2) {
        zzhrl.zza(obj, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j, Object obj2) {
        zzhrl.a.putObject(obj, j, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j, boolean z) {
        zzhrl.zza(obj, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j, byte b2) {
        zzhrl.zze(bArr, a + j, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j, long j2, long j3) {
        zzhrl.zza(bArr, j, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return zzhiu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(Object obj, long j) {
        return zzhrl.zzl(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return zzhrm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzdux());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Object obj, long j) {
        return zzhrl.zzm(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(Object obj, long j) {
        return zzhrl.zzn(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double e(Object obj, long j) {
        return zzhrl.zzo(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object f(Object obj, long j) {
        return zzhrl.a.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = ((((int) j) ^ (-1)) & 3) << 3;
        a(obj, j2, ((255 & b2) << i) | (a(obj, j2) & ((255 << i) ^ (-1))));
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        a(obj, j2, ((255 & b2) << i) | (a(obj, j2) & ((255 << i) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : (byte) 0);
    }

    private static boolean zzbcm() {
        Unsafe unsafe = zzgvq;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzdqd.a()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzbcn() {
        Unsafe unsafe = zzgvq;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzbco() == null) {
                return false;
            }
            if (zzdqd.a()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field zzbco() {
        Field zzb2;
        if (zzdqd.a() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : (byte) 0);
    }

    private static int zzk(Class<?> cls) {
        if (zzhiu) {
            return zzhrl.a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzl(Class<?> cls) {
        if (zzhiu) {
            return zzhrl.a.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzm(Class<?> cls) {
        if (!zzdqd.a()) {
            return false;
        }
        try {
            Class<?> cls2 = zzhho;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (a(obj, (-4) & j) >>> ((int) (((j ^ (-1)) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (a(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }
}
