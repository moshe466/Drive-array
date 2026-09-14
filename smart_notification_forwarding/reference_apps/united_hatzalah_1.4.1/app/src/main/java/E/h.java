package e;

import F0.A0;
import F0.T1;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0305o;
import androidx.lifecycle.C0311v;
import androidx.lifecycle.EnumC0303m;
import androidx.lifecycle.EnumC0304n;
import androidx.lifecycle.InterfaceC0309t;
import androidx.lifecycle.r;
import f.AbstractC0365a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f4429a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f4430b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f4431c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f4432d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final transient LinkedHashMap f4433e = new LinkedHashMap();

    /* renamed from: f, reason: collision with root package name */
    public final LinkedHashMap f4434f = new LinkedHashMap();

    /* renamed from: g, reason: collision with root package name */
    public final Bundle f4435g = new Bundle();

    public final boolean a(int i, int i3, Intent intent) {
        b bVar;
        String str = (String) this.f4429a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        e eVar = (e) this.f4433e.get(str);
        if (eVar != null) {
            bVar = eVar.f4421a;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            ArrayList arrayList = this.f4432d;
            if (arrayList.contains(str)) {
                eVar.f4421a.a(eVar.f4422b.c(i3, intent));
                arrayList.remove(str);
                return true;
            }
        }
        this.f4434f.remove(str);
        this.f4435g.putParcelable(str, new C0359a(i3, intent));
        return true;
    }

    public abstract void b(int i, AbstractC0365a abstractC0365a, Object obj);

    public final g c(final String key, InterfaceC0309t interfaceC0309t, final AbstractC0365a contract, final b callback) {
        kotlin.jvm.internal.j.e(key, "key");
        kotlin.jvm.internal.j.e(contract, "contract");
        kotlin.jvm.internal.j.e(callback, "callback");
        AbstractC0305o lifecycle = interfaceC0309t.getLifecycle();
        C0311v c0311v = (C0311v) lifecycle;
        if (c0311v.f3618c.compareTo(EnumC0304n.f3610d) < 0) {
            e(key);
            LinkedHashMap linkedHashMap = this.f4431c;
            f fVar = (f) linkedHashMap.get(key);
            if (fVar == null) {
                fVar = new f(lifecycle);
            }
            r rVar = new r() { // from class: e.d
                @Override // androidx.lifecycle.r
                public final void a(InterfaceC0309t interfaceC0309t2, EnumC0303m enumC0303m) {
                    h hVar = h.this;
                    LinkedHashMap linkedHashMap2 = hVar.f4433e;
                    EnumC0303m enumC0303m2 = EnumC0303m.ON_START;
                    String str = key;
                    if (enumC0303m2 == enumC0303m) {
                        Bundle bundle = hVar.f4435g;
                        LinkedHashMap linkedHashMap3 = hVar.f4434f;
                        AbstractC0365a abstractC0365a = contract;
                        b bVar = callback;
                        linkedHashMap2.put(str, new e(abstractC0365a, bVar));
                        if (linkedHashMap3.containsKey(str)) {
                            Object obj = linkedHashMap3.get(str);
                            linkedHashMap3.remove(str);
                            bVar.a(obj);
                        }
                        C0359a c0359a = (C0359a) m3.b.q(bundle, str);
                        if (c0359a != null) {
                            bundle.remove(str);
                            bVar.a(abstractC0365a.c(c0359a.f4415a, c0359a.f4416b));
                            return;
                        }
                        return;
                    }
                    if (EnumC0303m.ON_STOP == enumC0303m) {
                        linkedHashMap2.remove(str);
                    } else if (EnumC0303m.ON_DESTROY == enumC0303m) {
                        hVar.f(str);
                    }
                }
            };
            fVar.f4423a.a(rVar);
            fVar.f4424b.add(rVar);
            linkedHashMap.put(key, fVar);
            return new g(this, key, contract, 0);
        }
        throw new IllegalStateException(("LifecycleOwner " + interfaceC0309t + " is attempting to register while current state is " + c0311v.f3618c + ". LifecycleOwners must call register before they are STARTED.").toString());
    }

    public final g d(String key, AbstractC0365a abstractC0365a, b bVar) {
        kotlin.jvm.internal.j.e(key, "key");
        e(key);
        this.f4433e.put(key, new e(abstractC0365a, bVar));
        LinkedHashMap linkedHashMap = this.f4434f;
        if (linkedHashMap.containsKey(key)) {
            Object obj = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            bVar.a(obj);
        }
        Bundle bundle = this.f4435g;
        C0359a c0359a = (C0359a) m3.b.q(bundle, key);
        if (c0359a != null) {
            bundle.remove(key);
            bVar.a(abstractC0365a.c(c0359a.f4415a, c0359a.f4416b));
        }
        return new g(this, key, abstractC0365a, 1);
    }

    public final void e(String str) {
        LinkedHashMap linkedHashMap = this.f4430b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        T1 t12 = new T1(3);
        Iterator it = new M2.a(new M2.c(t12, new A0(t12, 1))).iterator();
        while (it.hasNext()) {
            Number number = (Number) it.next();
            Integer valueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.f4429a;
            if (!linkedHashMap2.containsKey(valueOf)) {
                int intValue = number.intValue();
                linkedHashMap2.put(Integer.valueOf(intValue), str);
                linkedHashMap.put(str, Integer.valueOf(intValue));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void f(String key) {
        Integer num;
        kotlin.jvm.internal.j.e(key, "key");
        if (!this.f4432d.contains(key) && (num = (Integer) this.f4430b.remove(key)) != null) {
            this.f4429a.remove(num);
        }
        this.f4433e.remove(key);
        LinkedHashMap linkedHashMap = this.f4434f;
        if (linkedHashMap.containsKey(key)) {
            Objects.toString(linkedHashMap.get(key));
            linkedHashMap.remove(key);
        }
        Bundle bundle = this.f4435g;
        if (bundle.containsKey(key)) {
            Objects.toString((C0359a) m3.b.q(bundle, key));
            bundle.remove(key);
        }
        LinkedHashMap linkedHashMap2 = this.f4431c;
        f fVar = (f) linkedHashMap2.get(key);
        if (fVar != null) {
            ArrayList arrayList = fVar.f4424b;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                fVar.f4423a.b((r) obj);
            }
            arrayList.clear();
            linkedHashMap2.remove(key);
        }
    }
}
