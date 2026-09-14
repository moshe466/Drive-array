package l0;

import android.os.Bundle;
import androidx.lifecycle.C0300j;
import h.C0439i;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.jvm.internal.j;

/* renamed from: l0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0514d {

    /* renamed from: b, reason: collision with root package name */
    public boolean f5475b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f5476c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5477d;

    /* renamed from: e, reason: collision with root package name */
    public C0439i f5478e;

    /* renamed from: a, reason: collision with root package name */
    public final o.f f5474a = new o.f();

    /* renamed from: f, reason: collision with root package name */
    public boolean f5479f = true;

    public final Bundle a(String str) {
        if (this.f5477d) {
            Bundle bundle = this.f5476c;
            if (bundle == null) {
                return null;
            }
            Bundle bundle2 = bundle.getBundle(str);
            Bundle bundle3 = this.f5476c;
            if (bundle3 != null) {
                bundle3.remove(str);
            }
            Bundle bundle4 = this.f5476c;
            if (bundle4 != null && !bundle4.isEmpty()) {
                return bundle2;
            }
            this.f5476c = null;
            return bundle2;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public final InterfaceC0513c b() {
        String str;
        InterfaceC0513c interfaceC0513c;
        Iterator it = this.f5474a.iterator();
        do {
            o.b bVar = (o.b) it;
            if (bVar.hasNext()) {
                Map.Entry components = (Map.Entry) bVar.next();
                j.d(components, "components");
                str = (String) components.getKey();
                interfaceC0513c = (InterfaceC0513c) components.getValue();
            } else {
                return null;
            }
        } while (!j.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return interfaceC0513c;
    }

    public final void c(String str, InterfaceC0513c provider) {
        Object obj;
        j.e(provider, "provider");
        o.f fVar = this.f5474a;
        o.c d2 = fVar.d(str);
        if (d2 != null) {
            obj = d2.f5900b;
        } else {
            o.c cVar = new o.c(str, provider);
            fVar.f5909d++;
            o.c cVar2 = fVar.f5907b;
            if (cVar2 == null) {
                fVar.f5906a = cVar;
                fVar.f5907b = cVar;
            } else {
                cVar2.f5901c = cVar;
                cVar.f5902d = cVar2;
                fVar.f5907b = cVar;
            }
            obj = null;
        }
        if (((InterfaceC0513c) obj) == null) {
        } else {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void d() {
        if (this.f5479f) {
            C0439i c0439i = this.f5478e;
            if (c0439i == null) {
                c0439i = new C0439i(this);
            }
            this.f5478e = c0439i;
            try {
                C0300j.class.getDeclaredConstructor(null);
                C0439i c0439i2 = this.f5478e;
                if (c0439i2 != null) {
                    ((LinkedHashSet) c0439i2.f4831b).add(C0300j.class.getName());
                    return;
                }
                return;
            } catch (NoSuchMethodException e4) {
                throw new IllegalArgumentException("Class " + C0300j.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e4);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
}
