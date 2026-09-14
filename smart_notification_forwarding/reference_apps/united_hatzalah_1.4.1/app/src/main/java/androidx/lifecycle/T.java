package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import d0.C0357c;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import l0.C0514d;
import l0.InterfaceC0516f;

/* loaded from: classes.dex */
public final class T implements X {

    /* renamed from: a, reason: collision with root package name */
    public final Application f3582a;

    /* renamed from: b, reason: collision with root package name */
    public final W f3583b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f3584c;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC0305o f3585d;

    /* renamed from: e, reason: collision with root package name */
    public final C0514d f3586e;

    public T(Application application, InterfaceC0516f interfaceC0516f, Bundle bundle) {
        W w3;
        this.f3586e = interfaceC0516f.getSavedStateRegistry();
        this.f3585d = interfaceC0516f.getLifecycle();
        this.f3584c = bundle;
        this.f3582a = application;
        if (application != null) {
            if (W.f3590c == null) {
                W.f3590c = new W(application);
            }
            w3 = W.f3590c;
            kotlin.jvm.internal.j.b(w3);
        } else {
            w3 = new W(null);
        }
        this.f3583b = w3;
    }

    @Override // androidx.lifecycle.X
    public final V a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return d(cls, canonicalName);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.X
    public final V c(Class cls, C0357c c0357c) {
        Constructor a2;
        LinkedHashMap linkedHashMap = c0357c.f4412a;
        String str = (String) linkedHashMap.get(e0.c.f4447a);
        if (str != null) {
            if (linkedHashMap.get(P.f3574a) != null && linkedHashMap.get(P.f3575b) != null) {
                Application application = (Application) linkedHashMap.get(W.f3591d);
                boolean isAssignableFrom = AbstractC0291a.class.isAssignableFrom(cls);
                if (isAssignableFrom && application != null) {
                    a2 = U.a(cls, U.f3587a);
                } else {
                    a2 = U.a(cls, U.f3588b);
                }
                if (a2 == null) {
                    return this.f3583b.c(cls, c0357c);
                }
                if (isAssignableFrom && application != null) {
                    return U.b(cls, a2, application, P.c(c0357c));
                }
                return U.b(cls, a2, P.c(c0357c));
            }
            if (this.f3585d != null) {
                return d(cls, str);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.Object, androidx.lifecycle.Y] */
    public final V d(Class cls, String str) {
        Constructor a2;
        V b4;
        AutoCloseable autoCloseable;
        Application application;
        AbstractC0305o abstractC0305o = this.f3585d;
        if (abstractC0305o != null) {
            boolean isAssignableFrom = AbstractC0291a.class.isAssignableFrom(cls);
            if (isAssignableFrom && this.f3582a != null) {
                a2 = U.a(cls, U.f3587a);
            } else {
                a2 = U.a(cls, U.f3588b);
            }
            if (a2 == null) {
                if (this.f3582a != null) {
                    return this.f3583b.a(cls);
                }
                if (Y.f3593a == null) {
                    Y.f3593a = new Object();
                }
                kotlin.jvm.internal.j.b(Y.f3593a);
                return T.b.h(cls);
            }
            C0514d c0514d = this.f3586e;
            kotlin.jvm.internal.j.b(c0514d);
            Bundle bundle = this.f3584c;
            Bundle a4 = c0514d.a(str);
            Class[] clsArr = L.f3562f;
            L b5 = P.b(a4, bundle);
            M m4 = new M(str, b5);
            m4.b(abstractC0305o, c0514d);
            EnumC0304n enumC0304n = ((C0311v) abstractC0305o).f3618c;
            if (enumC0304n != EnumC0304n.f3608b && enumC0304n.compareTo(EnumC0304n.f3610d) < 0) {
                abstractC0305o.a(new C0296f(abstractC0305o, c0514d));
            } else {
                c0514d.d();
            }
            if (isAssignableFrom && (application = this.f3582a) != null) {
                b4 = U.b(cls, a2, application, b5);
            } else {
                b4 = U.b(cls, a2, b5);
            }
            b4.getClass();
            e0.b bVar = b4.f3589a;
            if (bVar != null) {
                if (bVar.f4446d) {
                    e0.b.a(m4);
                    return b4;
                }
                synchronized (bVar.f4443a) {
                    autoCloseable = (AutoCloseable) bVar.f4444b.put("androidx.lifecycle.savedstate.vm.tag", m4);
                }
                e0.b.a(autoCloseable);
                return b4;
            }
            return b4;
        }
        throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }
}
