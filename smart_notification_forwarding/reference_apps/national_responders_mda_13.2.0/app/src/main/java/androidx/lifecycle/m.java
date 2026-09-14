package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class m extends h {

    /* renamed from: a, reason: collision with root package name */
    private j.a<k, a> f3206a;

    /* renamed from: b, reason: collision with root package name */
    private h.c f3207b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakReference<l> f3208c;

    /* renamed from: d, reason: collision with root package name */
    private int f3209d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3210e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f3211f;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<h.c> f3212g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f3213h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        h.c f3214a;

        /* renamed from: b, reason: collision with root package name */
        j f3215b;

        a(k kVar, h.c cVar) {
            this.f3215b = o.f(kVar);
            this.f3214a = cVar;
        }

        void a(l lVar, h.b bVar) {
            h.c targetState = bVar.getTargetState();
            this.f3214a = m.k(this.f3214a, targetState);
            this.f3215b.d(lVar, bVar);
            this.f3214a = targetState;
        }
    }

    public m(l lVar) {
        this(lVar, true);
    }

    private m(l lVar, boolean z10) {
        this.f3206a = new j.a<>();
        this.f3209d = 0;
        this.f3210e = false;
        this.f3211f = false;
        this.f3212g = new ArrayList<>();
        this.f3208c = new WeakReference<>(lVar);
        this.f3207b = h.c.INITIALIZED;
        this.f3213h = z10;
    }

    private void d(l lVar) {
        Iterator<Map.Entry<k, a>> c10 = this.f3206a.c();
        while (c10.hasNext() && !this.f3211f) {
            Map.Entry<k, a> next = c10.next();
            a value = next.getValue();
            while (value.f3214a.compareTo(this.f3207b) > 0 && !this.f3211f && this.f3206a.contains(next.getKey())) {
                h.b downFrom = h.b.downFrom(value.f3214a);
                if (downFrom == null) {
                    throw new IllegalStateException("no event down from " + value.f3214a);
                }
                n(downFrom.getTargetState());
                value.a(lVar, downFrom);
                m();
            }
        }
    }

    private h.c e(k kVar) {
        Map.Entry<k, a> v10 = this.f3206a.v(kVar);
        h.c cVar = null;
        h.c cVar2 = v10 != null ? v10.getValue().f3214a : null;
        if (!this.f3212g.isEmpty()) {
            cVar = this.f3212g.get(r0.size() - 1);
        }
        return k(k(this.f3207b, cVar2), cVar);
    }

    @SuppressLint({"RestrictedApi"})
    private void f(String str) {
        if (!this.f3213h || i.a.d().b()) {
            return;
        }
        throw new IllegalStateException("Method " + str + " must be called on the main thread");
    }

    private void g(l lVar) {
        j.b<k, a>.d j10 = this.f3206a.j();
        while (j10.hasNext() && !this.f3211f) {
            Map.Entry next = j10.next();
            a aVar = (a) next.getValue();
            while (aVar.f3214a.compareTo(this.f3207b) < 0 && !this.f3211f && this.f3206a.contains((k) next.getKey())) {
                n(aVar.f3214a);
                h.b upFrom = h.b.upFrom(aVar.f3214a);
                if (upFrom == null) {
                    throw new IllegalStateException("no event up from " + aVar.f3214a);
                }
                aVar.a(lVar, upFrom);
                m();
            }
        }
    }

    private boolean i() {
        if (this.f3206a.size() == 0) {
            return true;
        }
        h.c cVar = this.f3206a.f().getValue().f3214a;
        h.c cVar2 = this.f3206a.l().getValue().f3214a;
        return cVar == cVar2 && this.f3207b == cVar2;
    }

    static h.c k(h.c cVar, h.c cVar2) {
        return (cVar2 == null || cVar2.compareTo(cVar) >= 0) ? cVar : cVar2;
    }

    private void l(h.c cVar) {
        h.c cVar2 = this.f3207b;
        if (cVar2 == cVar) {
            return;
        }
        if (cVar2 == h.c.INITIALIZED && cVar == h.c.DESTROYED) {
            throw new IllegalStateException("no event down from " + this.f3207b);
        }
        this.f3207b = cVar;
        if (this.f3210e || this.f3209d != 0) {
            this.f3211f = true;
            return;
        }
        this.f3210e = true;
        p();
        this.f3210e = false;
        if (this.f3207b == h.c.DESTROYED) {
            this.f3206a = new j.a<>();
        }
    }

    private void m() {
        this.f3212g.remove(r0.size() - 1);
    }

    private void n(h.c cVar) {
        this.f3212g.add(cVar);
    }

    private void p() {
        l lVar = this.f3208c.get();
        if (lVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean i10 = i();
            this.f3211f = false;
            if (i10) {
                return;
            }
            if (this.f3207b.compareTo(this.f3206a.f().getValue().f3214a) < 0) {
                d(lVar);
            }
            Map.Entry<k, a> l10 = this.f3206a.l();
            if (!this.f3211f && l10 != null && this.f3207b.compareTo(l10.getValue().f3214a) > 0) {
                g(lVar);
            }
        }
    }

    @Override // androidx.lifecycle.h
    public void a(k kVar) {
        l lVar;
        f("addObserver");
        h.c cVar = this.f3207b;
        h.c cVar2 = h.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = h.c.INITIALIZED;
        }
        a aVar = new a(kVar, cVar2);
        if (this.f3206a.t(kVar, aVar) == null && (lVar = this.f3208c.get()) != null) {
            boolean z10 = this.f3209d != 0 || this.f3210e;
            h.c e10 = e(kVar);
            this.f3209d++;
            while (aVar.f3214a.compareTo(e10) < 0 && this.f3206a.contains(kVar)) {
                n(aVar.f3214a);
                h.b upFrom = h.b.upFrom(aVar.f3214a);
                if (upFrom == null) {
                    throw new IllegalStateException("no event up from " + aVar.f3214a);
                }
                aVar.a(lVar, upFrom);
                m();
                e10 = e(kVar);
            }
            if (!z10) {
                p();
            }
            this.f3209d--;
        }
    }

    @Override // androidx.lifecycle.h
    public h.c b() {
        return this.f3207b;
    }

    @Override // androidx.lifecycle.h
    public void c(k kVar) {
        f("removeObserver");
        this.f3206a.u(kVar);
    }

    public void h(h.b bVar) {
        f("handleLifecycleEvent");
        l(bVar.getTargetState());
    }

    @Deprecated
    public void j(h.c cVar) {
        f("markState");
        o(cVar);
    }

    public void o(h.c cVar) {
        f("setCurrentState");
        l(cVar);
    }
}
