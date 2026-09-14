package androidx.lifecycle;

import android.app.Application;
import d0.C0357c;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class W extends Y {

    /* renamed from: c, reason: collision with root package name */
    public static W f3590c;

    /* renamed from: d, reason: collision with root package name */
    public static final N f3591d = new N(2);

    /* renamed from: b, reason: collision with root package name */
    public final Application f3592b;

    public W(Application application) {
        this.f3592b = application;
    }

    @Override // androidx.lifecycle.Y, androidx.lifecycle.X
    public final V a(Class cls) {
        Application application = this.f3592b;
        if (application != null) {
            return d(cls, application);
        }
        throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.Y, androidx.lifecycle.X
    public final V c(Class cls, C0357c c0357c) {
        if (this.f3592b != null) {
            return a(cls);
        }
        Application application = (Application) c0357c.f4412a.get(f3591d);
        if (application != null) {
            return d(cls, application);
        }
        if (!AbstractC0291a.class.isAssignableFrom(cls)) {
            return T.b.h(cls);
        }
        throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
    }

    public final V d(Class cls, Application application) {
        if (AbstractC0291a.class.isAssignableFrom(cls)) {
            try {
                V v2 = (V) cls.getConstructor(Application.class).newInstance(application);
                kotlin.jvm.internal.j.d(v2, "{\n                try {\n…          }\n            }");
                return v2;
            } catch (IllegalAccessException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (InstantiationException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            } catch (NoSuchMethodException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            } catch (InvocationTargetException e7) {
                throw new RuntimeException("Cannot create an instance of " + cls, e7);
            }
        }
        return T.b.h(cls);
    }
}
