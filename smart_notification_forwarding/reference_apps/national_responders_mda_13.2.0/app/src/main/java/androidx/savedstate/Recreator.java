package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import p0.c;
import p0.e;
import y8.g;
import y8.k;

/* loaded from: classes.dex */
public final class Recreator implements j {

    /* renamed from: a, reason: collision with root package name */
    private final e f3662a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements c.InterfaceC0267c {

        /* renamed from: a, reason: collision with root package name */
        private final Set<String> f3663a;

        public b(c cVar) {
            k.e(cVar, "registry");
            this.f3663a = new LinkedHashSet();
            cVar.h("androidx.savedstate.Restarter", this);
        }

        @Override // p0.c.InterfaceC0267c
        public Bundle a() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f3663a));
            return bundle;
        }

        public final void b(String str) {
            k.e(str, "className");
            this.f3663a.add(str);
        }
    }

    static {
        new a(null);
    }

    public Recreator(e eVar) {
        k.e(eVar, "owner");
        this.f3662a = eVar;
    }

    private final void h(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(c.a.class);
            k.d(asSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    Object newInstance = declaredConstructor.newInstance(new Object[0]);
                    k.d(newInstance, "{\n                constr…wInstance()\n            }");
                    ((c.a) newInstance).a(this.f3662a);
                } catch (Exception e10) {
                    throw new RuntimeException("Failed to instantiate " + str, e10);
                }
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
            }
        } catch (ClassNotFoundException e12) {
            throw new RuntimeException("Class " + str + " wasn't found", e12);
        }
    }

    @Override // androidx.lifecycle.j
    public void d(l lVar, h.b bVar) {
        k.e(lVar, "source");
        k.e(bVar, "event");
        if (bVar != h.b.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        lVar.b().c(this);
        Bundle b10 = this.f3662a.f().b("androidx.savedstate.Restarter");
        if (b10 == null) {
            return;
        }
        ArrayList<String> stringArrayList = b10.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            h(it.next());
        }
    }
}
