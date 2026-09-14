package l0;

import android.os.Bundle;
import androidx.fragment.app.L;
import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.InterfaceC0298h;
import androidx.lifecycle.InterfaceC0309t;
import androidx.lifecycle.P;
import androidx.lifecycle.Q;
import androidx.lifecycle.V;
import androidx.lifecycle.Z;
import androidx.lifecycle.a0;
import androidx.lifecycle.r;
import c.m;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.j;

/* renamed from: l0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0511a implements r {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5472a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5473b;

    public /* synthetic */ C0511a(Object obj, int i) {
        this.f5472a = i;
        this.f5473b = obj;
    }

    @Override // androidx.lifecycle.r
    public final void a(InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m) {
        switch (this.f5472a) {
            case 0:
                InterfaceC0516f interfaceC0516f = (InterfaceC0516f) this.f5473b;
                if (enumC0303m == EnumC0303m.ON_CREATE) {
                    interfaceC0309t.getLifecycle().b(this);
                    Bundle a2 = interfaceC0516f.getSavedStateRegistry().a("androidx.savedstate.Restarter");
                    if (a2 != null) {
                        ArrayList<String> stringArrayList = a2.getStringArrayList("classes_to_restore");
                        if (stringArrayList != null) {
                            int size = stringArrayList.size();
                            int i = 0;
                            while (i < size) {
                                String str = stringArrayList.get(i);
                                i++;
                                String str2 = str;
                                try {
                                    Class<? extends U> asSubclass = Class.forName(str2, false, C0511a.class.getClassLoader()).asSubclass(InterfaceC0512b.class);
                                    j.d(asSubclass, "{\n                Class.…class.java)\n            }");
                                    try {
                                        Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                                        declaredConstructor.setAccessible(true);
                                        try {
                                            Object newInstance = declaredConstructor.newInstance(null);
                                            j.d(newInstance, "{\n                constr…wInstance()\n            }");
                                            if (interfaceC0516f instanceof a0) {
                                                Z viewModelStore = ((a0) interfaceC0516f).getViewModelStore();
                                                C0514d savedStateRegistry = interfaceC0516f.getSavedStateRegistry();
                                                viewModelStore.getClass();
                                                LinkedHashMap linkedHashMap = viewModelStore.f3594a;
                                                Iterator it = new HashSet(linkedHashMap.keySet()).iterator();
                                                while (it.hasNext()) {
                                                    String key = (String) it.next();
                                                    j.e(key, "key");
                                                    V v2 = (V) linkedHashMap.get(key);
                                                    j.b(v2);
                                                    P.a(v2, savedStateRegistry, interfaceC0516f.getLifecycle());
                                                }
                                                if (!new HashSet(linkedHashMap.keySet()).isEmpty()) {
                                                    savedStateRegistry.d();
                                                }
                                            } else {
                                                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
                                            }
                                        } catch (Exception e4) {
                                            throw new RuntimeException(e0.a.d("Failed to instantiate ", str2), e4);
                                        }
                                    } catch (NoSuchMethodException e5) {
                                        throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e5);
                                    }
                                } catch (ClassNotFoundException e6) {
                                    throw new RuntimeException(e0.a.e("Class ", str2, " wasn't found"), e6);
                                }
                            }
                            return;
                        }
                        throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
                    }
                    return;
                }
                throw new AssertionError("Next event must be ON_CREATE");
            case 1:
                new HashMap();
                InterfaceC0298h[] interfaceC0298hArr = (InterfaceC0298h[]) this.f5473b;
                if (interfaceC0298hArr.length <= 0) {
                    if (interfaceC0298hArr.length <= 0) {
                        return;
                    }
                    InterfaceC0298h interfaceC0298h = interfaceC0298hArr[0];
                    throw null;
                }
                InterfaceC0298h interfaceC0298h2 = interfaceC0298hArr[0];
                throw null;
            case 2:
                if (enumC0303m == EnumC0303m.ON_CREATE) {
                    interfaceC0309t.getLifecycle().b(this);
                    ((Q) this.f5473b).b();
                    return;
                } else {
                    throw new IllegalStateException(("Next event must be ON_CREATE, it was " + enumC0303m).toString());
                }
            default:
                L l3 = (L) this.f5473b;
                m.access$ensureViewModelStore(l3);
                l3.getLifecycle().b(this);
                return;
        }
    }
}
