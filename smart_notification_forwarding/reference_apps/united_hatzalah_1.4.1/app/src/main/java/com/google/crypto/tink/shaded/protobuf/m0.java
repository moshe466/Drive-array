package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public abstract class m0 {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f4135a;

    public m0(Unsafe unsafe) {
        this.f4135a = unsafe;
    }

    public final int a(Class cls) {
        return this.f4135a.arrayBaseOffset(cls);
    }

    public final int b(Class cls) {
        return this.f4135a.arrayIndexScale(cls);
    }

    public abstract boolean c(long j2, Object obj);

    public abstract byte d(long j2, Object obj);

    public abstract double e(long j2, Object obj);

    public abstract float f(long j2, Object obj);

    public final int g(long j2, Object obj) {
        return this.f4135a.getInt(obj, j2);
    }

    public final long h(long j2, Object obj) {
        return this.f4135a.getLong(obj, j2);
    }

    public final Object i(long j2, Object obj) {
        return this.f4135a.getObject(obj, j2);
    }

    public final long j(Field field) {
        return this.f4135a.objectFieldOffset(field);
    }

    public abstract void k(Object obj, long j2, boolean z3);

    public abstract void l(Object obj, long j2, byte b4);

    public abstract void m(Object obj, long j2, double d2);

    public abstract void n(Object obj, long j2, float f4);

    public final void o(Object obj, int i, long j2) {
        this.f4135a.putInt(obj, j2, i);
    }

    public final void p(Object obj, long j2, long j3) {
        this.f4135a.putLong(obj, j2, j3);
    }

    public final void q(Object obj, long j2, Object obj2) {
        this.f4135a.putObject(obj, j2, obj2);
    }

    public boolean r() {
        Unsafe unsafe = this.f4135a;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            return true;
        } catch (Throwable th) {
            n0.a(th);
            return false;
        }
    }

    public abstract boolean s();
}
