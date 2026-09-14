package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.crypto.tink.shaded.protobuf.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0351x extends AbstractC0329a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC0351x> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected e0 unknownFields;

    public AbstractC0351x() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = e0.f4095f;
    }

    public static void g(AbstractC0351x abstractC0351x) {
        if (m(abstractC0351x, true)) {
        } else {
            throw new IOException(new UninitializedMessageException().getMessage());
        }
    }

    public static AbstractC0351x j(Class cls) {
        AbstractC0351x abstractC0351x = defaultInstanceMap.get(cls);
        if (abstractC0351x == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC0351x = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (abstractC0351x == null) {
            AbstractC0351x a2 = ((AbstractC0351x) n0.b(cls)).a();
            if (a2 != null) {
                defaultInstanceMap.put(cls, a2);
                return a2;
            }
            throw new IllegalStateException();
        }
        return abstractC0351x;
    }

    public static Object l(Method method, AbstractC0351x abstractC0351x, Object... objArr) {
        try {
            return method.invoke(abstractC0351x, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static final boolean m(AbstractC0351x abstractC0351x, boolean z3) {
        byte byteValue = ((Byte) abstractC0351x.i(1)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        Y y = Y.f4075c;
        y.getClass();
        boolean c4 = y.a(abstractC0351x.getClass()).c(abstractC0351x);
        if (z3) {
            abstractC0351x.i(2);
        }
        return c4;
    }

    public static AbstractC0351x r(AbstractC0351x abstractC0351x, AbstractC0337i abstractC0337i, C0344p c0344p) {
        C0336h c0336h = (C0336h) abstractC0337i;
        C0338j h2 = M1.d.h(c0336h.f4105d, c0336h.l(), c0336h.size(), true);
        AbstractC0351x s3 = s(abstractC0351x, h2, c0344p);
        h2.b(0);
        g(s3);
        return s3;
    }

    public static AbstractC0351x s(AbstractC0351x abstractC0351x, M1.d dVar, C0344p c0344p) {
        AbstractC0351x q3 = abstractC0351x.q();
        try {
            Y y = Y.f4075c;
            y.getClass();
            b0 a2 = y.a(q3.getClass());
            C0340l c0340l = (C0340l) dVar.f1403b;
            if (c0340l == null) {
                c0340l = new C0340l(dVar);
            }
            a2.h(q3, c0340l, c0344p);
            a2.b(q3);
            return q3;
        } catch (InvalidProtocolBufferException e4) {
            if (e4.f4047a) {
                throw new IOException(e4.getMessage(), e4);
            }
            throw e4;
        } catch (UninitializedMessageException e5) {
            throw new IOException(e5.getMessage());
        } catch (IOException e6) {
            if (e6.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e6.getCause());
            }
            throw new IOException(e6.getMessage(), e6);
        } catch (RuntimeException e7) {
            if (e7.getCause() instanceof InvalidProtocolBufferException) {
                throw ((InvalidProtocolBufferException) e7.getCause());
            }
            throw e7;
        }
    }

    public static void t(Class cls, AbstractC0351x abstractC0351x) {
        abstractC0351x.o();
        defaultInstanceMap.put(cls, abstractC0351x);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0329a
    public final int b(b0 b0Var) {
        int f4;
        int f5;
        if (n()) {
            if (b0Var == null) {
                Y y = Y.f4075c;
                y.getClass();
                f5 = y.a(getClass()).f(this);
            } else {
                f5 = b0Var.f(this);
            }
            if (f5 >= 0) {
                return f5;
            }
            throw new IllegalStateException(e0.a.c(f5, "serialized size must be non-negative, was "));
        }
        int i = this.memoizedSerializedSize;
        if ((i & Api.BaseClientBuilder.API_PRIORITY_OTHER) != Integer.MAX_VALUE) {
            return i & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (b0Var == null) {
            Y y3 = Y.f4075c;
            y3.getClass();
            f4 = y3.a(getClass()).f(this);
        } else {
            f4 = b0Var.f(this);
        }
        u(f4);
        return f4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Y y = Y.f4075c;
        y.getClass();
        return y.a(getClass()).d(this, (AbstractC0351x) obj);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0329a
    public final void f(C0341m c0341m) {
        Y y = Y.f4075c;
        y.getClass();
        b0 a2 = y.a(getClass());
        K k4 = c0341m.f4131j;
        if (k4 == null) {
            k4 = new K(c0341m);
        }
        a2.i(this, k4);
    }

    public final AbstractC0349v h() {
        return (AbstractC0349v) i(5);
    }

    public final int hashCode() {
        if (n()) {
            Y y = Y.f4075c;
            y.getClass();
            return y.a(getClass()).e(this);
        }
        if (this.memoizedHashCode == 0) {
            Y y3 = Y.f4075c;
            y3.getClass();
            this.memoizedHashCode = y3.a(getClass()).e(this);
        }
        return this.memoizedHashCode;
    }

    public abstract Object i(int i);

    @Override // com.google.crypto.tink.shaded.protobuf.P
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final AbstractC0351x a() {
        return (AbstractC0351x) i(6);
    }

    public final boolean n() {
        if ((this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0) {
            return true;
        }
        return false;
    }

    public final void o() {
        this.memoizedSerializedSize &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractC0329a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public final AbstractC0349v d() {
        return (AbstractC0349v) i(5);
    }

    public final AbstractC0351x q() {
        return (AbstractC0351x) i(4);
    }

    public final String toString() {
        String obj = super.toString();
        char[] cArr = Q.f4055a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        Q.c(this, sb, 0);
        return sb.toString();
    }

    public final void u(int i) {
        if (i >= 0) {
            this.memoizedSerializedSize = (i & Api.BaseClientBuilder.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
            return;
        }
        throw new IllegalStateException(e0.a.c(i, "serialized size must be non-negative, was "));
    }

    public final AbstractC0349v v() {
        AbstractC0349v abstractC0349v = (AbstractC0349v) i(5);
        if (!abstractC0349v.f4157a.equals(this)) {
            abstractC0349v.e();
            AbstractC0349v.f(abstractC0349v.f4158b, this);
        }
        return abstractC0349v;
    }
}
