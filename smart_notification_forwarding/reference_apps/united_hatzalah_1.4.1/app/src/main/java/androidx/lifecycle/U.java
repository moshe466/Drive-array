package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import t2.AbstractC0705g;
import t2.AbstractC0708j;

/* loaded from: classes.dex */
public abstract class U {

    /* renamed from: a, reason: collision with root package name */
    public static final List f3587a = AbstractC0708j.W(Application.class, L.class);

    /* renamed from: b, reason: collision with root package name */
    public static final List f3588b = T.b.B(L.class);

    public static final Constructor a(Class cls, List signature) {
        kotlin.jvm.internal.j.e(signature, "signature");
        Constructor<?>[] constructors = cls.getConstructors();
        kotlin.jvm.internal.j.d(constructors, "modelClass.constructors");
        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            kotlin.jvm.internal.j.d(parameterTypes, "constructor.parameterTypes");
            List R3 = AbstractC0705g.R(parameterTypes);
            if (signature.equals(R3)) {
                return constructor;
            }
            if (signature.size() == R3.size() && R3.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final V b(Class cls, Constructor constructor, Object... objArr) {
        try {
            return (V) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Failed to access " + cls, e4);
        } catch (InstantiationException e5) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e6.getCause());
        }
    }
}
