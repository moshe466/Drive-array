package p0;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.h;
import androidx.lifecycle.j;
import androidx.lifecycle.l;
import androidx.savedstate.Recreator;
import java.util.Iterator;
import java.util.Map;
import y8.g;
import y8.k;

@SuppressLint({"RestrictedApi"})
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    private boolean f13006b;

    /* renamed from: c, reason: collision with root package name */
    private Bundle f13007c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13008d;

    /* renamed from: e, reason: collision with root package name */
    private Recreator.b f13009e;

    /* renamed from: a, reason: collision with root package name */
    private final j.b<String, InterfaceC0267c> f13005a = new j.b<>();

    /* renamed from: f, reason: collision with root package name */
    private boolean f13010f = true;

    /* loaded from: classes.dex */
    public interface a {
        void a(e eVar);
    }

    /* loaded from: classes.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }

    /* renamed from: p0.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0267c {
        Bundle a();
    }

    static {
        new b(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(c cVar, l lVar, h.b bVar) {
        boolean z10;
        k.e(cVar, "this$0");
        k.e(lVar, "<anonymous parameter 0>");
        k.e(bVar, "event");
        if (bVar == h.b.ON_START) {
            z10 = true;
        } else if (bVar != h.b.ON_STOP) {
            return;
        } else {
            z10 = false;
        }
        cVar.f13010f = z10;
    }

    public final Bundle b(String str) {
        k.e(str, "key");
        if (!this.f13008d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f13007c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(str) : null;
        Bundle bundle3 = this.f13007c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.f13007c;
        boolean z10 = false;
        if (bundle4 != null && !bundle4.isEmpty()) {
            z10 = true;
        }
        if (!z10) {
            this.f13007c = null;
        }
        return bundle2;
    }

    public final InterfaceC0267c c(String str) {
        k.e(str, "key");
        Iterator<Map.Entry<String, InterfaceC0267c>> it = this.f13005a.iterator();
        while (it.hasNext()) {
            Map.Entry<String, InterfaceC0267c> next = it.next();
            k.d(next, "components");
            String key = next.getKey();
            InterfaceC0267c value = next.getValue();
            if (k.a(key, str)) {
                return value;
            }
        }
        return null;
    }

    public final void e(h hVar) {
        k.e(hVar, "lifecycle");
        if (!(!this.f13006b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        hVar.a(new j() { // from class: p0.b
            @Override // androidx.lifecycle.j
            public final void d(l lVar, h.b bVar) {
                c.d(c.this, lVar, bVar);
            }
        });
        this.f13006b = true;
    }

    public final void f(Bundle bundle) {
        if (!this.f13006b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.f13008d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.f13007c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f13008d = true;
    }

    public final void g(Bundle bundle) {
        k.e(bundle, "outBundle");
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f13007c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        j.b<String, InterfaceC0267c>.d j10 = this.f13005a.j();
        k.d(j10, "this.components.iteratorWithAdditions()");
        while (j10.hasNext()) {
            Map.Entry next = j10.next();
            bundle2.putBundle((String) next.getKey(), ((InterfaceC0267c) next.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public final void h(String str, InterfaceC0267c interfaceC0267c) {
        k.e(str, "key");
        k.e(interfaceC0267c, "provider");
        if (!(this.f13005a.t(str, interfaceC0267c) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    public final void i(Class<? extends a> cls) {
        k.e(cls, "clazz");
        if (!this.f13010f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        Recreator.b bVar = this.f13009e;
        if (bVar == null) {
            bVar = new Recreator.b(this);
        }
        this.f13009e = bVar;
        try {
            cls.getDeclaredConstructor(new Class[0]);
            Recreator.b bVar2 = this.f13009e;
            if (bVar2 != null) {
                String name = cls.getName();
                k.d(name, "clazz.name");
                bVar2.b(name);
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + cls.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }
}
