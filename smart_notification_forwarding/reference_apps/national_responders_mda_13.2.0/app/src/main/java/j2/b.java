package j2;

import android.os.IBinder;
import b2.p;
import j2.a;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class b<T> extends a.AbstractBinderC0212a {

    /* renamed from: a, reason: collision with root package name */
    private final Object f10964a;

    private b(Object obj) {
        this.f10964a = obj;
    }

    public static <T> T p(a aVar) {
        if (aVar instanceof b) {
            return (T) ((b) aVar).f10964a;
        }
        IBinder asBinder = aVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i10 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i10++;
                field = field2;
            }
        }
        if (i10 != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        p.k(field);
        if (field.isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        field.setAccessible(true);
        try {
            return (T) field.get(asBinder);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e10);
        } catch (NullPointerException e11) {
            throw new IllegalArgumentException("Binder object is null.", e11);
        }
    }

    public static <T> a z(T t10) {
        return new b(t10);
    }
}
