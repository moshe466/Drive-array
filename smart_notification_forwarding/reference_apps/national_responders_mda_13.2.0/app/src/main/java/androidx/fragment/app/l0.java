package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class l0 {

    /* renamed from: a, reason: collision with root package name */
    private final ViewGroup f3061a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<e> f3062b = new ArrayList<>();

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<e> f3063c = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    boolean f3064d = false;

    /* renamed from: e, reason: collision with root package name */
    boolean f3065e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f3066f;

        a(d dVar) {
            this.f3066f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l0.this.f3062b.contains(this.f3066f)) {
                this.f3066f.e().applyState(this.f3066f.f().N);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ d f3068f;

        b(d dVar) {
            this.f3068f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.this.f3062b.remove(this.f3068f);
            l0.this.f3063c.remove(this.f3068f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3070a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f3071b;

        static {
            int[] iArr = new int[e.b.values().length];
            f3071b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3071b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3071b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f3070a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3070a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3070a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3070a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: h, reason: collision with root package name */
        private final d0 f3072h;

        d(e.c cVar, e.b bVar, d0 d0Var, androidx.core.os.e eVar) {
            super(cVar, bVar, d0Var.k(), eVar);
            this.f3072h = d0Var;
        }

        @Override // androidx.fragment.app.l0.e
        public void c() {
            super.c();
            this.f3072h.m();
        }

        @Override // androidx.fragment.app.l0.e
        void l() {
            if (g() != e.b.ADDING) {
                if (g() == e.b.REMOVING) {
                    Fragment k10 = this.f3072h.k();
                    View D1 = k10.D1();
                    if (w.H0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Clearing focus ");
                        sb2.append(D1.findFocus());
                        sb2.append(" on view ");
                        sb2.append(D1);
                        sb2.append(" for Fragment ");
                        sb2.append(k10);
                    }
                    D1.clearFocus();
                    return;
                }
                return;
            }
            Fragment k11 = this.f3072h.k();
            View findFocus = k11.N.findFocus();
            if (findFocus != null) {
                k11.J1(findFocus);
                if (w.H0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("requestFocus: Saved focused view ");
                    sb3.append(findFocus);
                    sb3.append(" for Fragment ");
                    sb3.append(k11);
                }
            }
            View D12 = f().D1();
            if (D12.getParent() == null) {
                this.f3072h.b();
                D12.setAlpha(0.0f);
            }
            if (D12.getAlpha() == 0.0f && D12.getVisibility() == 0) {
                D12.setVisibility(4);
            }
            D12.setAlpha(k11.W());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        private c f3073a;

        /* renamed from: b, reason: collision with root package name */
        private b f3074b;

        /* renamed from: c, reason: collision with root package name */
        private final Fragment f3075c;

        /* renamed from: d, reason: collision with root package name */
        private final List<Runnable> f3076d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private final HashSet<androidx.core.os.e> f3077e = new HashSet<>();

        /* renamed from: f, reason: collision with root package name */
        private boolean f3078f = false;

        /* renamed from: g, reason: collision with root package name */
        private boolean f3079g = false;

        /* loaded from: classes.dex */
        class a implements e.b {
            a() {
            }

            @Override // androidx.core.os.e.b
            public void a() {
                e.this.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            /* JADX INFO: Access modifiers changed from: package-private */
            public static c from(int i10) {
                if (i10 == 0) {
                    return VISIBLE;
                }
                if (i10 == 4) {
                    return INVISIBLE;
                }
                if (i10 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i10);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public static c from(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : from(view.getVisibility());
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public void applyState(View view) {
                int i10;
                int i11 = c.f3070a[ordinal()];
                if (i11 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (w.H0(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("SpecialEffectsController: Removing view ");
                            sb2.append(view);
                            sb2.append(" from container ");
                            sb2.append(viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i11 == 2) {
                    if (w.H0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: Setting view ");
                        sb3.append(view);
                        sb3.append(" to VISIBLE");
                    }
                    i10 = 0;
                } else {
                    if (i11 != 3) {
                        if (i11 != 4) {
                            return;
                        }
                        if (w.H0(2)) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("SpecialEffectsController: Setting view ");
                            sb4.append(view);
                            sb4.append(" to INVISIBLE");
                        }
                        view.setVisibility(4);
                        return;
                    }
                    if (w.H0(2)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("SpecialEffectsController: Setting view ");
                        sb5.append(view);
                        sb5.append(" to GONE");
                    }
                    i10 = 8;
                }
                view.setVisibility(i10);
            }
        }

        e(c cVar, b bVar, Fragment fragment, androidx.core.os.e eVar) {
            this.f3073a = cVar;
            this.f3074b = bVar;
            this.f3075c = fragment;
            eVar.b(new a());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void a(Runnable runnable) {
            this.f3076d.add(runnable);
        }

        final void b() {
            if (h()) {
                return;
            }
            this.f3078f = true;
            if (this.f3077e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f3077e).iterator();
            while (it.hasNext()) {
                ((androidx.core.os.e) it.next()).a();
            }
        }

        public void c() {
            if (this.f3079g) {
                return;
            }
            if (w.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("SpecialEffectsController: ");
                sb2.append(this);
                sb2.append(" has called complete.");
            }
            this.f3079g = true;
            Iterator<Runnable> it = this.f3076d.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }

        public final void d(androidx.core.os.e eVar) {
            if (this.f3077e.remove(eVar) && this.f3077e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f3073a;
        }

        public final Fragment f() {
            return this.f3075c;
        }

        b g() {
            return this.f3074b;
        }

        final boolean h() {
            return this.f3078f;
        }

        final boolean i() {
            return this.f3079g;
        }

        public final void j(androidx.core.os.e eVar) {
            l();
            this.f3077e.add(eVar);
        }

        final void k(c cVar, b bVar) {
            b bVar2;
            int i10 = c.f3071b[bVar.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 == 3 && this.f3073a != c.REMOVED) {
                        if (w.H0(2)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("SpecialEffectsController: For fragment ");
                            sb2.append(this.f3075c);
                            sb2.append(" mFinalState = ");
                            sb2.append(this.f3073a);
                            sb2.append(" -> ");
                            sb2.append(cVar);
                            sb2.append(". ");
                        }
                        this.f3073a = cVar;
                        return;
                    }
                    return;
                }
                if (w.H0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: For fragment ");
                    sb3.append(this.f3075c);
                    sb3.append(" mFinalState = ");
                    sb3.append(this.f3073a);
                    sb3.append(" -> REMOVED. mLifecycleImpact  = ");
                    sb3.append(this.f3074b);
                    sb3.append(" to REMOVING.");
                }
                this.f3073a = c.REMOVED;
                bVar2 = b.REMOVING;
            } else {
                if (this.f3073a != c.REMOVED) {
                    return;
                }
                if (w.H0(2)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("SpecialEffectsController: For fragment ");
                    sb4.append(this.f3075c);
                    sb4.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                    sb4.append(this.f3074b);
                    sb4.append(" to ADDING.");
                }
                this.f3073a = c.VISIBLE;
                bVar2 = b.ADDING;
            }
            this.f3074b = bVar2;
        }

        void l() {
        }

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f3073a + "} {mLifecycleImpact = " + this.f3074b + "} {mFragment = " + this.f3075c + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(ViewGroup viewGroup) {
        this.f3061a = viewGroup;
    }

    private void a(e.c cVar, e.b bVar, d0 d0Var) {
        synchronized (this.f3062b) {
            androidx.core.os.e eVar = new androidx.core.os.e();
            e h10 = h(d0Var.k());
            if (h10 != null) {
                h10.k(cVar, bVar);
                return;
            }
            d dVar = new d(cVar, bVar, d0Var, eVar);
            this.f3062b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    private e h(Fragment fragment) {
        Iterator<e> it = this.f3062b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    private e i(Fragment fragment) {
        Iterator<e> it = this.f3063c.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.f().equals(fragment) && !next.h()) {
                return next;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l0 n(ViewGroup viewGroup, w wVar) {
        return o(viewGroup, wVar.z0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static l0 o(ViewGroup viewGroup, m0 m0Var) {
        int i10 = d0.b.f8629b;
        Object tag = viewGroup.getTag(i10);
        if (tag instanceof l0) {
            return (l0) tag;
        }
        l0 a10 = m0Var.a(viewGroup);
        viewGroup.setTag(i10, a10);
        return a10;
    }

    private void q() {
        Iterator<e> it = this.f3062b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.g() == e.b.ADDING) {
                next.k(e.c.from(next.f().D1().getVisibility()), e.b.NONE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(e.c cVar, d0 d0Var) {
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing add operation for fragment ");
            sb2.append(d0Var.k());
        }
        a(cVar, e.b.ADDING, d0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(d0 d0Var) {
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            sb2.append(d0Var.k());
        }
        a(e.c.GONE, e.b.NONE, d0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(d0 d0Var) {
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            sb2.append(d0Var.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, d0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(d0 d0Var) {
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SpecialEffectsController: Enqueuing show operation for fragment ");
            sb2.append(d0Var.k());
        }
        a(e.c.VISIBLE, e.b.NONE, d0Var);
    }

    abstract void f(List<e> list, boolean z10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.f3065e) {
            return;
        }
        if (!androidx.core.view.a0.R(this.f3061a)) {
            j();
            this.f3064d = false;
            return;
        }
        synchronized (this.f3062b) {
            if (!this.f3062b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f3063c);
                this.f3063c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    e eVar = (e) it.next();
                    if (w.H0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: Cancelling operation ");
                        sb2.append(eVar);
                    }
                    eVar.b();
                    if (!eVar.i()) {
                        this.f3063c.add(eVar);
                    }
                }
                q();
                ArrayList arrayList2 = new ArrayList(this.f3062b);
                this.f3062b.clear();
                this.f3063c.addAll(arrayList2);
                w.H0(2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).l();
                }
                f(arrayList2, this.f3064d);
                this.f3064d = false;
                w.H0(2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        String str;
        String str2;
        w.H0(2);
        boolean R = androidx.core.view.a0.R(this.f3061a);
        synchronized (this.f3062b) {
            q();
            Iterator<e> it = this.f3062b.iterator();
            while (it.hasNext()) {
                it.next().l();
            }
            Iterator it2 = new ArrayList(this.f3063c).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                if (w.H0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (R) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f3061a + " is not attached to window. ";
                    }
                    sb2.append(str2);
                    sb2.append("Cancelling running operation ");
                    sb2.append(eVar);
                }
                eVar.b();
            }
            Iterator it3 = new ArrayList(this.f3062b).iterator();
            while (it3.hasNext()) {
                e eVar2 = (e) it3.next();
                if (w.H0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: ");
                    if (R) {
                        str = "";
                    } else {
                        str = "Container " + this.f3061a + " is not attached to window. ";
                    }
                    sb3.append(str);
                    sb3.append("Cancelling pending operation ");
                    sb3.append(eVar2);
                }
                eVar2.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k() {
        if (this.f3065e) {
            w.H0(2);
            this.f3065e = false;
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e.b l(d0 d0Var) {
        e h10 = h(d0Var.k());
        e.b g10 = h10 != null ? h10.g() : null;
        e i10 = i(d0Var.k());
        return (i10 == null || !(g10 == null || g10 == e.b.NONE)) ? g10 : i10.g();
    }

    public ViewGroup m() {
        return this.f3061a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p() {
        synchronized (this.f3062b) {
            q();
            this.f3065e = false;
            int size = this.f3062b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                e eVar = this.f3062b.get(size);
                e.c from = e.c.from(eVar.f().N);
                e.c e10 = eVar.e();
                e.c cVar = e.c.VISIBLE;
                if (e10 == cVar && from != cVar) {
                    this.f3065e = eVar.f().q0();
                    break;
                }
                size--;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(boolean z10) {
        this.f3064d = z10;
    }
}
