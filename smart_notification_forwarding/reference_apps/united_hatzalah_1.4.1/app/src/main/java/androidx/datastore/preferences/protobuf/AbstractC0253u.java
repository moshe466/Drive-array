package androidx.datastore.preferences.protobuf;

import com.google.android.gms.common.api.Api;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: androidx.datastore.preferences.protobuf.u, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0253u extends AbstractC0234a {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Object, AbstractC0253u> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize;
    protected Z unknownFields;

    public AbstractC0253u() {
        this.memoizedHashCode = 0;
        this.memoizedSerializedSize = -1;
        this.unknownFields = Z.f3148f;
    }

    public static AbstractC0253u d(Class cls) {
        AbstractC0253u abstractC0253u = defaultInstanceMap.get(cls);
        if (abstractC0253u == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC0253u = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException("Class initialization cannot fail.", e4);
            }
        }
        if (abstractC0253u == null) {
            AbstractC0253u abstractC0253u2 = (AbstractC0253u) ((AbstractC0253u) f0.d(cls)).c(6);
            if (abstractC0253u2 != null) {
                defaultInstanceMap.put(cls, abstractC0253u2);
                return abstractC0253u2;
            }
            throw new IllegalStateException();
        }
        return abstractC0253u;
    }

    public static Object e(Method method, AbstractC0253u abstractC0253u, Object... objArr) {
        try {
            return method.invoke(abstractC0253u, objArr);
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

    public static final boolean f(AbstractC0253u abstractC0253u, boolean z3) {
        byte byteValue = ((Byte) abstractC0253u.c(1)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        O o2 = O.f3120c;
        o2.getClass();
        boolean c4 = o2.a(abstractC0253u.getClass()).c(abstractC0253u);
        if (z3) {
            abstractC0253u.c(2);
        }
        return c4;
    }

    public static void j(Class cls, AbstractC0253u abstractC0253u) {
        abstractC0253u.h();
        defaultInstanceMap.put(cls, abstractC0253u);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0234a
    public final int a(S s3) {
        int e4;
        int e5;
        if (g()) {
            if (s3 == null) {
                O o2 = O.f3120c;
                o2.getClass();
                e5 = o2.a(getClass()).e(this);
            } else {
                e5 = s3.e(this);
            }
            if (e5 >= 0) {
                return e5;
            }
            throw new IllegalStateException(e0.a.c(e5, "serialized size must be non-negative, was "));
        }
        int i = this.memoizedSerializedSize;
        if ((i & Api.BaseClientBuilder.API_PRIORITY_OTHER) != Integer.MAX_VALUE) {
            return i & Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (s3 == null) {
            O o4 = O.f3120c;
            o4.getClass();
            e4 = o4.a(getClass()).e(this);
        } else {
            e4 = s3.e(this);
        }
        k(e4);
        return e4;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0234a
    public final void b(C0244k c0244k) {
        O o2 = O.f3120c;
        o2.getClass();
        S a2 = o2.a(getClass());
        B b4 = c0244k.f3197j;
        if (b4 == null) {
            b4 = new B(c0244k);
        }
        a2.d(this, b4);
    }

    public abstract Object c(int i);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        O o2 = O.f3120c;
        o2.getClass();
        return o2.a(getClass()).g(this, (AbstractC0253u) obj);
    }

    public final boolean g() {
        if ((this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0) {
            return true;
        }
        return false;
    }

    public final void h() {
        this.memoizedSerializedSize &= Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final int hashCode() {
        if (g()) {
            O o2 = O.f3120c;
            o2.getClass();
            return o2.a(getClass()).f(this);
        }
        if (this.memoizedHashCode == 0) {
            O o4 = O.f3120c;
            o4.getClass();
            this.memoizedHashCode = o4.a(getClass()).f(this);
        }
        return this.memoizedHashCode;
    }

    public final AbstractC0253u i() {
        return (AbstractC0253u) c(4);
    }

    public final void k(int i) {
        if (i >= 0) {
            this.memoizedSerializedSize = (i & Api.BaseClientBuilder.API_PRIORITY_OTHER) | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
            return;
        }
        throw new IllegalStateException(e0.a.c(i, "serialized size must be non-negative, was "));
    }

    public final String toString() {
        String obj = super.toString();
        char[] cArr = I.f3099a;
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        I.c(this, sb, 0);
        return sb.toString();
    }
}
