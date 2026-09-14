package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Unsafe f3166a;

    /* renamed from: b, reason: collision with root package name */
    public static final Class f3167b;

    /* renamed from: c, reason: collision with root package name */
    public static final e0 f3168c;

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f3169d;

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f3170e;

    /* renamed from: f, reason: collision with root package name */
    public static final long f3171f;

    /* renamed from: g, reason: collision with root package name */
    public static final boolean f3172g;

    static {
        boolean r3;
        boolean q3;
        Unsafe i = i();
        f3166a = i;
        f3167b = AbstractC0236c.f3155a;
        boolean h2 = h(Long.TYPE);
        boolean h3 = h(Integer.TYPE);
        e0 e0Var = null;
        if (i != null) {
            if (AbstractC0236c.a()) {
                if (h2) {
                    e0Var = new c0(i, 1);
                } else if (h3) {
                    e0Var = new c0(i, 0);
                }
            } else {
                e0Var = new e0(i);
            }
        }
        f3168c = e0Var;
        boolean z3 = false;
        if (e0Var == null) {
            r3 = false;
        } else {
            r3 = e0Var.r();
        }
        f3169d = r3;
        if (e0Var == null) {
            q3 = false;
        } else {
            q3 = e0Var.q();
        }
        f3170e = q3;
        f3171f = e(byte[].class);
        e(boolean[].class);
        f(boolean[].class);
        e(int[].class);
        f(int[].class);
        e(long[].class);
        f(long[].class);
        e(float[].class);
        f(float[].class);
        e(double[].class);
        f(double[].class);
        e(Object[].class);
        f(Object[].class);
        Field g3 = g();
        if (g3 != null && e0Var != null) {
            e0Var.i(g3);
        }
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            z3 = true;
        }
        f3172g = z3;
    }

    public static void a(Throwable th) {
        Logger.getLogger(f0.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    public static boolean b(long j2, Object obj) {
        if (((byte) ((f3168c.f((-4) & j2, obj) >>> ((int) (((~j2) & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static boolean c(long j2, Object obj) {
        if (((byte) ((f3168c.f((-4) & j2, obj) >>> ((int) ((j2 & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static Object d(Class cls) {
        try {
            return f3166a.allocateInstance(cls);
        } catch (InstantiationException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public static int e(Class cls) {
        if (f3170e) {
            return f3168c.a(cls);
        }
        return -1;
    }

    public static void f(Class cls) {
        if (f3170e) {
            f3168c.b(cls);
        }
    }

    public static Field g() {
        Field field;
        Field field2;
        if (AbstractC0236c.a()) {
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

    public static boolean h(Class cls) {
        if (!AbstractC0236c.a()) {
            return false;
        }
        try {
            Class cls2 = f3167b;
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

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.security.PrivilegedExceptionAction] */
    public static Unsafe i() {
        try {
            return (Unsafe) AccessController.doPrivileged((PrivilegedExceptionAction) new Object());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void j(byte[] bArr, long j2, byte b4) {
        f3168c.k(bArr, f3171f + j2, b4);
    }

    public static void k(Object obj, long j2, byte b4) {
        long j3 = (-4) & j2;
        int f4 = f3168c.f(j3, obj);
        int i = ((~((int) j2)) & 3) << 3;
        m(obj, ((255 & b4) << i) | (f4 & (~(255 << i))), j3);
    }

    public static void l(Object obj, long j2, byte b4) {
        long j3 = (-4) & j2;
        int i = (((int) j2) & 3) << 3;
        m(obj, ((255 & b4) << i) | (f3168c.f(j3, obj) & (~(255 << i))), j3);
    }

    public static void m(Object obj, int i, long j2) {
        f3168c.n(obj, i, j2);
    }

    public static void n(Object obj, long j2, long j3) {
        f3168c.o(obj, j2, j3);
    }

    public static void o(Object obj, long j2, Object obj2) {
        f3168c.p(obj, j2, obj2);
    }
}
