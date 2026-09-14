package e0;

import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import e0.d;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import m8.l0;
import m8.r0;
import m8.y;
import y8.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f9126a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static c f9127b = c.f9128d;

    /* loaded from: classes.dex */
    public enum a {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(h hVar);
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: d, reason: collision with root package name */
        public static final c f9128d;

        /* renamed from: a, reason: collision with root package name */
        private final Set<a> f9129a;

        /* renamed from: b, reason: collision with root package name */
        private final b f9130b;

        /* renamed from: c, reason: collision with root package name */
        private final Map<String, Set<Class<? extends h>>> f9131c;

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(y8.g gVar) {
                this();
            }
        }

        static {
            Set b10;
            Map h10;
            new a(null);
            b10 = r0.b();
            h10 = l0.h();
            f9128d = new c(b10, null, h10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Set<? extends a> set, b bVar, Map<String, ? extends Set<Class<? extends h>>> map) {
            k.e(set, "flags");
            k.e(map, "allowedViolations");
            this.f9129a = set;
            this.f9130b = bVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends h>>> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.f9131c = linkedHashMap;
        }

        public final Set<a> a() {
            return this.f9129a;
        }

        public final b b() {
            return this.f9130b;
        }

        public final Map<String, Set<Class<? extends h>>> c() {
            return this.f9131c;
        }
    }

    private d() {
    }

    private final c c(Fragment fragment) {
        while (fragment != null) {
            if (fragment.m0()) {
                w S = fragment.S();
                k.d(S, "declaringFragment.parentFragmentManager");
                if (S.A0() != null) {
                    c A0 = S.A0();
                    k.b(A0);
                    return A0;
                }
            }
            fragment = fragment.R();
        }
        return f9127b;
    }

    private final void d(final c cVar, final h hVar) {
        Fragment a10 = hVar.a();
        final String name = a10.getClass().getName();
        if (cVar.a().contains(a.PENALTY_LOG)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Policy violation in ");
            sb2.append(name);
        }
        if (cVar.b() != null) {
            l(a10, new Runnable() { // from class: e0.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.e(d.c.this, hVar);
                }
            });
        }
        if (cVar.a().contains(a.PENALTY_DEATH)) {
            l(a10, new Runnable() { // from class: e0.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.f(name, hVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c cVar, h hVar) {
        k.e(cVar, "$policy");
        k.e(hVar, "$violation");
        cVar.b().a(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str, h hVar) {
        k.e(hVar, "$violation");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Policy violation with PENALTY_DEATH in ");
        sb2.append(str);
        throw hVar;
    }

    private final void g(h hVar) {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("StrictMode violation in ");
            sb2.append(hVar.a().getClass().getName());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(Fragment fragment, String str) {
        k.e(fragment, "fragment");
        k.e(str, "previousFragmentId");
        e0.a aVar = new e0.a(fragment, str);
        d dVar = f9126a;
        dVar.g(aVar);
        c c10 = dVar.c(fragment);
        if (c10.a().contains(a.DETECT_FRAGMENT_REUSE) && dVar.m(c10, fragment.getClass(), aVar.getClass())) {
            dVar.d(c10, aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(Fragment fragment, ViewGroup viewGroup) {
        k.e(fragment, "fragment");
        e eVar = new e(fragment, viewGroup);
        d dVar = f9126a;
        dVar.g(eVar);
        c c10 = dVar.c(fragment);
        if (c10.a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && dVar.m(c10, fragment.getClass(), eVar.getClass())) {
            dVar.d(c10, eVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(Fragment fragment) {
        k.e(fragment, "fragment");
        f fVar = new f(fragment);
        d dVar = f9126a;
        dVar.g(fVar);
        c c10 = dVar.c(fragment);
        if (c10.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && dVar.m(c10, fragment.getClass(), fVar.getClass())) {
            dVar.d(c10, fVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(Fragment fragment, ViewGroup viewGroup) {
        k.e(fragment, "fragment");
        k.e(viewGroup, "container");
        i iVar = new i(fragment, viewGroup);
        d dVar = f9126a;
        dVar.g(iVar);
        c c10 = dVar.c(fragment);
        if (c10.a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && dVar.m(c10, fragment.getClass(), iVar.getClass())) {
            dVar.d(c10, iVar);
        }
    }

    private final void l(Fragment fragment, Runnable runnable) {
        if (fragment.m0()) {
            Handler k10 = fragment.S().u0().k();
            k.d(k10, "fragment.parentFragmentManager.host.handler");
            if (!k.a(k10.getLooper(), Looper.myLooper())) {
                k10.post(runnable);
                return;
            }
        }
        runnable.run();
    }

    private final boolean m(c cVar, Class<? extends Fragment> cls, Class<? extends h> cls2) {
        boolean B;
        Set<Class<? extends h>> set = cVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (!k.a(cls2.getSuperclass(), h.class)) {
            B = y.B(set, cls2.getSuperclass());
            if (B) {
                return false;
            }
        }
        return !set.contains(cls2);
    }
}
