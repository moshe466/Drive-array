package s0;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import t.C0689e;

/* renamed from: s0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0647a {

    /* renamed from: a, reason: collision with root package name */
    public final C0689e f6227a;

    /* renamed from: b, reason: collision with root package name */
    public final C0689e f6228b;

    /* renamed from: c, reason: collision with root package name */
    public final C0689e f6229c;

    public AbstractC0647a(C0689e c0689e, C0689e c0689e2, C0689e c0689e3) {
        this.f6227a = c0689e;
        this.f6228b = c0689e2;
        this.f6229c = c0689e3;
    }

    public abstract C0648b a();

    public final Class b(Class cls) {
        String name = cls.getName();
        C0689e c0689e = this.f6229c;
        Class cls2 = (Class) c0689e.get(name);
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
            c0689e.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    public final Method c(String str) {
        C0689e c0689e = this.f6227a;
        Method method = (Method) c0689e.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, AbstractC0647a.class.getClassLoader()).getDeclaredMethod("read", AbstractC0647a.class);
            c0689e.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public final Method d(Class cls) {
        String name = cls.getName();
        C0689e c0689e = this.f6228b;
        Method method = (Method) c0689e.get(name);
        if (method == null) {
            Class b4 = b(cls);
            System.currentTimeMillis();
            Method declaredMethod = b4.getDeclaredMethod("write", cls, AbstractC0647a.class);
            c0689e.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    public abstract boolean e(int i);

    public final Parcelable f(Parcelable parcelable, int i) {
        if (!e(i)) {
            return parcelable;
        }
        return ((C0648b) this).f6231e.readParcelable(C0648b.class.getClassLoader());
    }

    public final InterfaceC0649c g() {
        String readString = ((C0648b) this).f6231e.readString();
        if (readString == null) {
            return null;
        }
        try {
            return (InterfaceC0649c) c(readString).invoke(null, a());
        } catch (ClassNotFoundException e4) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
        } catch (NoSuchMethodException e6) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e6);
        } catch (InvocationTargetException e7) {
            if (e7.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e7.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e7);
        }
    }

    public abstract void h(int i);

    public final void i(InterfaceC0649c interfaceC0649c) {
        if (interfaceC0649c == null) {
            ((C0648b) this).f6231e.writeString(null);
            return;
        }
        try {
            ((C0648b) this).f6231e.writeString(b(interfaceC0649c.getClass()).getName());
            C0648b a2 = a();
            try {
                d(interfaceC0649c.getClass()).invoke(null, interfaceC0649c, a2);
                Parcel parcel = a2.f6231e;
                int i = a2.i;
                if (i >= 0) {
                    int i3 = a2.f6230d.get(i);
                    int dataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i3);
                    parcel.writeInt(dataPosition - i3);
                    parcel.setDataPosition(dataPosition);
                }
            } catch (ClassNotFoundException e4) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e4);
            } catch (IllegalAccessException e5) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e5);
            } catch (NoSuchMethodException e6) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e6);
            } catch (InvocationTargetException e7) {
                if (e7.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e7.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e7);
            }
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException(interfaceC0649c.getClass().getSimpleName().concat(" does not have a Parcelizer"), e8);
        }
    }
}
