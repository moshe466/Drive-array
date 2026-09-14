package z4;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public abstract class m {

    /* loaded from: classes.dex */
    class a extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f16218a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f16219b;

        a(Method method, Object obj) {
            this.f16218a = method;
            this.f16219b = obj;
        }

        @Override // z4.m
        public <T> T c(Class<T> cls) {
            m.a(cls);
            return (T) this.f16218a.invoke(this.f16219b, cls);
        }
    }

    /* loaded from: classes.dex */
    class b extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f16220a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f16221b;

        b(Method method, int i10) {
            this.f16220a = method;
            this.f16221b = i10;
        }

        @Override // z4.m
        public <T> T c(Class<T> cls) {
            m.a(cls);
            return (T) this.f16220a.invoke(null, cls, Integer.valueOf(this.f16221b));
        }
    }

    /* loaded from: classes.dex */
    class c extends m {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Method f16222a;

        c(Method method) {
            this.f16222a = method;
        }

        @Override // z4.m
        public <T> T c(Class<T> cls) {
            m.a(cls);
            return (T) this.f16222a.invoke(null, cls, Object.class);
        }
    }

    /* loaded from: classes.dex */
    class d extends m {
        d() {
        }

        @Override // z4.m
        public <T> T c(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls);
        }
    }

    static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (Modifier.isInterface(modifiers)) {
            throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
        }
        if (Modifier.isAbstract(modifiers)) {
            throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
        }
    }

    public static m b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    return new d();
                }
            } catch (Exception unused3) {
                Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                declaredMethod3.setAccessible(true);
                return new c(declaredMethod3);
            }
        }
    }

    public abstract <T> T c(Class<T> cls);
}
