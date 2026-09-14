package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class na {

    /* renamed from: a, reason: collision with root package name */
    private static final Unsafe f5494a;

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?> f5495b;

    /* renamed from: c, reason: collision with root package name */
    private static final boolean f5496c;

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f5497d;

    /* renamed from: e, reason: collision with root package name */
    private static final c f5498e;

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f5499f;

    /* renamed from: g, reason: collision with root package name */
    private static final boolean f5500g;

    /* renamed from: h, reason: collision with root package name */
    private static final long f5501h;

    /* renamed from: i, reason: collision with root package name */
    static final boolean f5502i;

    /* loaded from: classes.dex */
    private static final class a extends c {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final byte a(Object obj, long j10) {
            return na.f5502i ? na.L(obj, j10) : na.M(obj, j10);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final void b(Object obj, long j10, byte b10) {
            if (na.f5502i) {
                na.u(obj, j10, b10);
            } else {
                na.y(obj, j10, b10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final void c(Object obj, long j10, double d10) {
            f(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final void d(Object obj, long j10, float f10) {
            e(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final void g(Object obj, long j10, boolean z10) {
            if (na.f5502i) {
                na.z(obj, j10, z10);
            } else {
                na.D(obj, j10, z10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final boolean h(Object obj, long j10) {
            return na.f5502i ? na.N(obj, j10) : na.O(obj, j10);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final float i(Object obj, long j10) {
            return Float.intBitsToFloat(k(obj, j10));
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final double j(Object obj, long j10) {
            return Double.longBitsToDouble(l(obj, j10));
        }
    }

    /* loaded from: classes.dex */
    private static final class b extends c {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final byte a(Object obj, long j10) {
            return na.f5502i ? na.L(obj, j10) : na.M(obj, j10);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final void b(Object obj, long j10, byte b10) {
            if (na.f5502i) {
                na.u(obj, j10, b10);
            } else {
                na.y(obj, j10, b10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final void c(Object obj, long j10, double d10) {
            f(obj, j10, Double.doubleToLongBits(d10));
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final void d(Object obj, long j10, float f10) {
            e(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final void g(Object obj, long j10, boolean z10) {
            if (na.f5502i) {
                na.z(obj, j10, z10);
            } else {
                na.D(obj, j10, z10);
            }
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final boolean h(Object obj, long j10) {
            return na.f5502i ? na.N(obj, j10) : na.O(obj, j10);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final float i(Object obj, long j10) {
            return Float.intBitsToFloat(k(obj, j10));
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final double j(Object obj, long j10) {
            return Double.longBitsToDouble(l(obj, j10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f5503a;

        c(Unsafe unsafe) {
            this.f5503a = unsafe;
        }

        public abstract byte a(Object obj, long j10);

        public abstract void b(Object obj, long j10, byte b10);

        public abstract void c(Object obj, long j10, double d10);

        public abstract void d(Object obj, long j10, float f10);

        public final void e(Object obj, long j10, int i10) {
            this.f5503a.putInt(obj, j10, i10);
        }

        public final void f(Object obj, long j10, long j11) {
            this.f5503a.putLong(obj, j10, j11);
        }

        public abstract void g(Object obj, long j10, boolean z10);

        public abstract boolean h(Object obj, long j10);

        public abstract float i(Object obj, long j10);

        public abstract double j(Object obj, long j10);

        public final int k(Object obj, long j10) {
            return this.f5503a.getInt(obj, j10);
        }

        public final long l(Object obj, long j10) {
            return this.f5503a.getLong(obj, j10);
        }
    }

    /* loaded from: classes.dex */
    private static final class d extends c {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final byte a(Object obj, long j10) {
            return this.f5503a.getByte(obj, j10);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final void b(Object obj, long j10, byte b10) {
            this.f5503a.putByte(obj, j10, b10);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final void c(Object obj, long j10, double d10) {
            this.f5503a.putDouble(obj, j10, d10);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final void d(Object obj, long j10, float f10) {
            this.f5503a.putFloat(obj, j10, f10);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final void g(Object obj, long j10, boolean z10) {
            this.f5503a.putBoolean(obj, j10, z10);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final boolean h(Object obj, long j10) {
            return this.f5503a.getBoolean(obj, j10);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final float i(Object obj, long j10) {
            return this.f5503a.getFloat(obj, j10);
        }

        @Override // com.google.android.gms.internal.measurement.na.c
        public final double j(Object obj, long j10) {
            return this.f5503a.getDouble(obj, j10);
        }
    }

    static {
        Unsafe t10 = t();
        f5494a = t10;
        f5495b = a6.c();
        boolean B = B(Long.TYPE);
        f5496c = B;
        boolean B2 = B(Integer.TYPE);
        f5497d = B2;
        c cVar = null;
        if (t10 != null) {
            if (!a6.b()) {
                cVar = new d(t10);
            } else if (B) {
                cVar = new a(t10);
            } else if (B2) {
                cVar = new b(t10);
            }
        }
        f5498e = cVar;
        f5499f = E();
        f5500g = A();
        f5501h = n(byte[].class);
        n(boolean[].class);
        s(boolean[].class);
        n(int[].class);
        s(int[].class);
        n(long[].class);
        s(long[].class);
        n(float[].class);
        s(float[].class);
        n(double[].class);
        s(double[].class);
        n(Object[].class);
        s(Object[].class);
        Field G = G();
        if (G != null && cVar != null) {
            cVar.f5503a.objectFieldOffset(G);
        }
        f5502i = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private na() {
    }

    private static boolean A() {
        Unsafe unsafe = f5494a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (a6.b()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = Logger.getLogger(na.class.getName());
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 71);
            sb2.append("platform method missing - proto runtime falling back to safer methods: ");
            sb2.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb2.toString());
            return false;
        }
    }

    private static boolean B(Class<?> cls) {
        if (!a6.b()) {
            return false;
        }
        try {
            Class<?> cls2 = f5495b;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double C(Object obj, long j10) {
        return f5498e.j(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(Object obj, long j10, boolean z10) {
        y(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    private static boolean E() {
        Unsafe unsafe = f5494a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (G() == null) {
                return false;
            }
            if (a6.b()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            Logger logger = Logger.getLogger(na.class.getName());
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 71);
            sb2.append("platform method missing - proto runtime falling back to safer methods: ");
            sb2.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb2.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object F(Object obj, long j10) {
        return f5498e.f5503a.getObject(obj, j10);
    }

    private static Field G() {
        Field d10;
        if (a6.b() && (d10 = d(Buffer.class, "effectiveDirectAddress")) != null) {
            return d10;
        }
        Field d11 = d(Buffer.class, "address");
        if (d11 == null || d11.getType() != Long.TYPE) {
            return null;
        }
        return d11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte L(Object obj, long j10) {
        return (byte) (b(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte M(Object obj, long j10) {
        return (byte) (b(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean N(Object obj, long j10) {
        return L(obj, j10) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean O(Object obj, long j10) {
        return M(obj, j10) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte a(byte[] bArr, long j10) {
        return f5498e.a(bArr, f5501h + j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Object obj, long j10) {
        return f5498e.k(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T c(Class<T> cls) {
        try {
            return (T) f5494a.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    private static Field d(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(Object obj, long j10, double d10) {
        f5498e.c(obj, j10, d10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Object obj, long j10, float f10) {
        f5498e.d(obj, j10, f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void h(Object obj, long j10, int i10) {
        f5498e.e(obj, j10, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Object obj, long j10, long j11) {
        f5498e.f(obj, j10, j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(Object obj, long j10, Object obj2) {
        f5498e.f5503a.putObject(obj, j10, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(Object obj, long j10, boolean z10) {
        f5498e.g(obj, j10, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void l(byte[] bArr, long j10, byte b10) {
        f5498e.b(bArr, f5501h + j10, b10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean m() {
        return f5500g;
    }

    private static int n(Class<?> cls) {
        if (f5500g) {
            return f5498e.f5503a.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long o(Object obj, long j10) {
        return f5498e.l(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r() {
        return f5499f;
    }

    private static int s(Class<?> cls) {
        if (f5500g) {
            return f5498e.f5503a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe t() {
        try {
            return (Unsafe) AccessController.doPrivileged(new ma());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void u(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int b11 = b(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        h(obj, j11, ((255 & b10) << i10) | (b11 & (~(255 << i10))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean w(Object obj, long j10) {
        return f5498e.h(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float x(Object obj, long j10) {
        return f5498e.i(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void y(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        h(obj, j11, ((255 & b10) << i10) | (b(obj, j11) & (~(255 << i10))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(Object obj, long j10, boolean z10) {
        u(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }
}
