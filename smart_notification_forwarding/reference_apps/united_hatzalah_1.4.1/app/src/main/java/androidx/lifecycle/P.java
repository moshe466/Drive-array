package androidx.lifecycle;

import F0.C0110z2;
import android.os.Bundle;
import android.view.View;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.uh.sf.R;
import d0.AbstractC0356b;
import d0.C0355a;
import d0.C0357c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import l0.C0511a;
import l0.C0514d;
import l0.InterfaceC0513c;
import l0.InterfaceC0516f;

/* loaded from: classes.dex */
public abstract class P {

    /* renamed from: a, reason: collision with root package name */
    public static final N f3574a = new N(0);

    /* renamed from: b, reason: collision with root package name */
    public static final N f3575b = new N(1);

    /* renamed from: c, reason: collision with root package name */
    public static final A.n f3576c = new A.n(29);

    public static final void a(V v2, C0514d registry, AbstractC0305o lifecycle) {
        AutoCloseable autoCloseable;
        kotlin.jvm.internal.j.e(registry, "registry");
        kotlin.jvm.internal.j.e(lifecycle, "lifecycle");
        e0.b bVar = v2.f3589a;
        if (bVar != null) {
            synchronized (bVar.f4443a) {
                autoCloseable = (AutoCloseable) bVar.f4444b.get("androidx.lifecycle.savedstate.vm.tag");
            }
        } else {
            autoCloseable = null;
        }
        M m4 = (M) autoCloseable;
        if (m4 != null && !m4.f3570c) {
            m4.b(lifecycle, registry);
            EnumC0304n enumC0304n = ((C0311v) lifecycle).f3618c;
            if (enumC0304n != EnumC0304n.f3608b && enumC0304n.compareTo(EnumC0304n.f3610d) < 0) {
                lifecycle.a(new C0296f(lifecycle, registry));
            } else {
                registry.d();
            }
        }
    }

    public static L b(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new L();
            }
            HashMap hashMap = new HashMap();
            for (String key : bundle2.keySet()) {
                kotlin.jvm.internal.j.d(key, "key");
                hashMap.put(key, bundle2.get(key));
            }
            return new L(hashMap);
        }
        ClassLoader classLoader = L.class.getClassLoader();
        kotlin.jvm.internal.j.b(classLoader);
        bundle.setClassLoader(classLoader);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(UserMetadata.KEYDATA_FILENAME);
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList != null && parcelableArrayList2 != null && parcelableArrayList.size() == parcelableArrayList2.size()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size = parcelableArrayList.size();
            for (int i = 0; i < size; i++) {
                Object obj = parcelableArrayList.get(i);
                kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type kotlin.String");
                linkedHashMap.put((String) obj, parcelableArrayList2.get(i));
            }
            return new L(linkedHashMap);
        }
        throw new IllegalStateException("Invalid bundle passed as restored state");
    }

    public static final L c(C0357c c0357c) {
        Q q3;
        Bundle bundle;
        LinkedHashMap linkedHashMap = c0357c.f4412a;
        InterfaceC0516f interfaceC0516f = (InterfaceC0516f) linkedHashMap.get(f3574a);
        if (interfaceC0516f != null) {
            a0 a0Var = (a0) linkedHashMap.get(f3575b);
            if (a0Var != null) {
                Bundle bundle2 = (Bundle) linkedHashMap.get(f3576c);
                String str = (String) linkedHashMap.get(e0.c.f4447a);
                if (str != null) {
                    InterfaceC0513c b4 = interfaceC0516f.getSavedStateRegistry().b();
                    if (b4 instanceof Q) {
                        q3 = (Q) b4;
                    } else {
                        q3 = null;
                    }
                    if (q3 != null) {
                        LinkedHashMap linkedHashMap2 = e(a0Var).f3581b;
                        L l3 = (L) linkedHashMap2.get(str);
                        if (l3 == null) {
                            Class[] clsArr = L.f3562f;
                            q3.b();
                            Bundle bundle3 = q3.f3579c;
                            if (bundle3 != null) {
                                bundle = bundle3.getBundle(str);
                            } else {
                                bundle = null;
                            }
                            Bundle bundle4 = q3.f3579c;
                            if (bundle4 != null) {
                                bundle4.remove(str);
                            }
                            Bundle bundle5 = q3.f3579c;
                            if (bundle5 != null && bundle5.isEmpty()) {
                                q3.f3579c = null;
                            }
                            L b5 = b(bundle, bundle2);
                            linkedHashMap2.put(str, b5);
                            return b5;
                        }
                        return l3;
                    }
                    throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
                }
                throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
            }
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
    }

    public static final void d(InterfaceC0516f interfaceC0516f) {
        EnumC0304n enumC0304n = ((C0311v) interfaceC0516f.getLifecycle()).f3618c;
        if (enumC0304n != EnumC0304n.f3608b && enumC0304n != EnumC0304n.f3609c) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (interfaceC0516f.getSavedStateRegistry().b() == null) {
            Q q3 = new Q(interfaceC0516f.getSavedStateRegistry(), (a0) interfaceC0516f);
            interfaceC0516f.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", q3);
            interfaceC0516f.getLifecycle().a(new C0511a(q3, 2));
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.lifecycle.X, java.lang.Object] */
    public static final S e(a0 a0Var) {
        AbstractC0356b defaultCreationExtras;
        ?? obj = new Object();
        Z store = a0Var.getViewModelStore();
        if (a0Var instanceof InterfaceC0299i) {
            defaultCreationExtras = ((InterfaceC0299i) a0Var).getDefaultViewModelCreationExtras();
        } else {
            defaultCreationExtras = C0355a.f4411b;
        }
        kotlin.jvm.internal.j.e(store, "store");
        kotlin.jvm.internal.j.e(defaultCreationExtras, "defaultCreationExtras");
        return (S) new C0110z2(store, (X) obj, defaultCreationExtras).r(kotlin.jvm.internal.s.a(S.class), "androidx.lifecycle.internal.SavedStateHandlesVM");
    }

    public static final void f(View view, InterfaceC0309t interfaceC0309t) {
        kotlin.jvm.internal.j.e(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, interfaceC0309t);
    }
}
