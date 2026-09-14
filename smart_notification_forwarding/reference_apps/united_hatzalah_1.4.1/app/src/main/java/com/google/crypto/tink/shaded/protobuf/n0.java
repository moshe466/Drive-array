package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f4136a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f4137b;

    /* renamed from: c, reason: collision with root package name */
    public static final m0 f4138c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f4139d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f4140e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f4141f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f4142g;

    static {
        boolean s3;
        boolean r3;
        Unsafe j2 = j();
        f4136a = j2;
        f4137b = AbstractC0331c.f4086a;
        boolean f4 = f(Long.TYPE);
        boolean f5 = f(Integer.TYPE);
        m0 m0Var = null;
        if (j2 != null) {
            if (AbstractC0331c.a()) {
                if (f4) {
                    m0Var = new k0(j2, 1);
                } else if (f5) {
                    m0Var = new k0(j2, 0);
                }
            } else {
                m0Var = new m0(j2);
            }
        }
        f4138c = m0Var;
        boolean z3 = false;
        if (m0Var == null) {
            s3 = false;
        } else {
            s3 = m0Var.s();
        }
        f4139d = s3;
        if (m0Var == null) {
            r3 = false;
        } else {
            r3 = m0Var.r();
        }
        f4140e = r3;
        f4141f = c(byte[].class);
        c(boolean[].class);
        d(boolean[].class);
        c(int[].class);
        d(int[].class);
        c(long[].class);
        d(long[].class);
        c(float[].class);
        d(float[].class);
        c(double[].class);
        d(double[].class);
        c(Object[].class);
        d(Object[].class);
        Field e4 = e();
        if (e4 != null && m0Var != null) {
            m0Var.j(e4);
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z3 = true;
        }
        f4142g = z3;
    }

    public static void a(Throwable th) {
        Logger.getLogger(n0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static Object b(Class cls) {
        try {
            return f4136a.allocateInstance(cls);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public static int c(Class cls) {
        if (f4140e) {
            return f4138c.a(cls);
        }
        return -1;
    }

    public static void d(Class cls) {
        if (f4140e) {
            f4138c.b(cls);
        }
    }

    public static Field e() {
        Field field;
        Field field2;
        if (AbstractC0331c.a()) {
            try {
                field2 = Buffer.class.getDeclaredField("effectiveDirectAddress");
            } catch (Throwable unused) {
                field2 = null;
            }
            if (field2 != null) {
                return field2;
            }
        }
        try {
            field = Buffer.class.getDeclaredField("address");
        } catch (Throwable unused2) {
            field = null;
        }
        if (field == null || field.getType() != Long.TYPE) {
            return null;
        }
        return field;
    }

    public static boolean f(Class cls) {
        if (!AbstractC0331c.a()) {
            return false;
        }
        try {
            Class cls2 = f4137b;
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

    public static byte g(byte[] bArr, long j2) {
        return f4138c.d(f4141f + j2, bArr);
    }

    public static byte h(long j2, Object obj) {
        return (byte) ((f4138c.g((-4) & j2, obj) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    public static byte i(long j2, Object obj) {
        return (byte) ((f4138c.g((-4) & j2, obj) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.security.PrivilegedExceptionAction] */
    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged((PrivilegedExceptionAction) new Object());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void k(byte[] bArr, long j2, byte b4) {
        f4138c.l(bArr, f4141f + j2, b4);
    }

    public static void l(Object obj, long j2, byte b4) {
        long j3 = (-4) & j2;
        int g3 = f4138c.g(j3, obj);
        int i = ((~((int) j2)) & 3) << 3;
        n(obj, ((255 & b4) << i) | (g3 & (~(255 << i))), j3);
    }

    public static void m(Object obj, long j2, byte b4) {
        long j3 = (-4) & j2;
        int i = (((int) j2) & 3) << 3;
        n(obj, ((255 & b4) << i) | (f4138c.g(j3, obj) & (~(255 << i))), j3);
    }

    public static void n(Object obj, int i, long j2) {
        f4138c.o(obj, i, j2);
    }

    public static void o(Object obj, long j2, long j3) {
        f4138c.p(obj, j2, j3);
    }

    public static void p(Object obj, long j2, Object obj2) {
        f4138c.q(obj, j2, obj2);
    }
}
