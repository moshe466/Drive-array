package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.core.os.e;
import androidx.fragment.app.k;
import androidx.fragment.app.l0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class d extends l0 {

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2922a;

        static {
            int[] iArr = new int[l0.e.c.values().length];
            f2922a = iArr;
            try {
                iArr[l0.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2922a[l0.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2922a[l0.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2922a[l0.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f2923f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ l0.e f2924g;

        b(List list, l0.e eVar) {
            this.f2923f = list;
            this.f2924g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2923f.contains(this.f2924g)) {
                this.f2923f.remove(this.f2924g);
                d.this.s(this.f2924g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f2926a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f2927b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f2928c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l0.e f2929d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ k f2930e;

        c(d dVar, ViewGroup viewGroup, View view, boolean z10, l0.e eVar, k kVar) {
            this.f2926a = viewGroup;
            this.f2927b = view;
            this.f2928c = z10;
            this.f2929d = eVar;
            this.f2930e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2926a.endViewTransition(this.f2927b);
            if (this.f2928c) {
                this.f2929d.e().applyState(this.f2927b);
            }
            this.f2930e.a();
            if (w.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animator from operation ");
                sb2.append(this.f2929d);
                sb2.append(" has ended.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.fragment.app.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0048d implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Animator f2931a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ l0.e f2932b;

        C0048d(d dVar, Animator animator, l0.e eVar) {
            this.f2931a = animator;
            this.f2932b = eVar;
        }

        @Override // androidx.core.os.e.b
        public void a() {
            this.f2931a.end();
            if (w.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animator from operation ");
                sb2.append(this.f2932b);
                sb2.append(" has been canceled.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l0.e f2933a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f2934b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f2935c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ k f2936d;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f2934b.endViewTransition(eVar.f2935c);
                e.this.f2936d.a();
            }
        }

        e(d dVar, l0.e eVar, ViewGroup viewGroup, View view, k kVar) {
            this.f2933a = eVar;
            this.f2934b = viewGroup;
            this.f2935c = view;
            this.f2936d = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f2934b.post(new a());
            if (w.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animation from operation ");
                sb2.append(this.f2933a);
                sb2.append(" has ended.");
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (w.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animation from operation ");
                sb2.append(this.f2933a);
                sb2.append(" has reached onAnimationStart.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements e.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f2938a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f2939b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f2940c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l0.e f2941d;

        f(d dVar, View view, ViewGroup viewGroup, k kVar, l0.e eVar) {
            this.f2938a = view;
            this.f2939b = viewGroup;
            this.f2940c = kVar;
            this.f2941d = eVar;
        }

        @Override // androidx.core.os.e.b
        public void a() {
            this.f2938a.clearAnimation();
            this.f2939b.endViewTransition(this.f2938a);
            this.f2940c.a();
            if (w.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Animation from operation ");
                sb2.append(this.f2941d);
                sb2.append(" has been cancelled.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ l0.e f2942f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ l0.e f2943g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f2944h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ l.a f2945i;

        g(d dVar, l0.e eVar, l0.e eVar2, boolean z10, l.a aVar) {
            this.f2942f = eVar;
            this.f2943g = eVar2;
            this.f2944h = z10;
            this.f2945i = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g0.a(this.f2942f.f(), this.f2943g.f(), this.f2944h, this.f2945i, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i0 f2946f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f2947g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Rect f2948h;

        h(d dVar, i0 i0Var, View view, Rect rect) {
            this.f2946f = i0Var;
            this.f2947g = view;
            this.f2948h = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2946f.h(this.f2947g, this.f2948h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class i implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f2949f;

        i(d dVar, ArrayList arrayList) {
            this.f2949f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            g0.d(this.f2949f, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class j implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ m f2950f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ l0.e f2951g;

        j(d dVar, m mVar, l0.e eVar) {
            this.f2950f = mVar;
            this.f2951g = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2950f.a();
            if (w.H0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Transition for operation ");
                sb2.append(this.f2951g);
                sb2.append("has completed");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class k extends l {

        /* renamed from: c, reason: collision with root package name */
        private boolean f2952c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f2953d;

        /* renamed from: e, reason: collision with root package name */
        private k.a f2954e;

        k(l0.e eVar, androidx.core.os.e eVar2, boolean z10) {
            super(eVar, eVar2);
            this.f2953d = false;
            this.f2952c = z10;
        }

        k.a e(Context context) {
            if (this.f2953d) {
                return this.f2954e;
            }
            k.a b10 = androidx.fragment.app.k.b(context, b().f(), b().e() == l0.e.c.VISIBLE, this.f2952c);
            this.f2954e = b10;
            this.f2953d = true;
            return b10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: a, reason: collision with root package name */
        private final l0.e f2955a;

        /* renamed from: b, reason: collision with root package name */
        private final androidx.core.os.e f2956b;

        l(l0.e eVar, androidx.core.os.e eVar2) {
            this.f2955a = eVar;
            this.f2956b = eVar2;
        }

        void a() {
            this.f2955a.d(this.f2956b);
        }

        l0.e b() {
            return this.f2955a;
        }

        androidx.core.os.e c() {
            return this.f2956b;
        }

        boolean d() {
            l0.e.c cVar;
            l0.e.c from = l0.e.c.from(this.f2955a.f().N);
            l0.e.c e10 = this.f2955a.e();
            return from == e10 || !(from == (cVar = l0.e.c.VISIBLE) || e10 == cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class m extends l {

        /* renamed from: c, reason: collision with root package name */
        private final Object f2957c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f2958d;

        /* renamed from: e, reason: collision with root package name */
        private final Object f2959e;

        m(l0.e eVar, androidx.core.os.e eVar2, boolean z10, boolean z11) {
            super(eVar, eVar2);
            boolean z12;
            Object obj;
            if (eVar.e() == l0.e.c.VISIBLE) {
                Fragment f10 = eVar.f();
                this.f2957c = z10 ? f10.X() : f10.C();
                Fragment f11 = eVar.f();
                z12 = z10 ? f11.v() : f11.u();
            } else {
                Fragment f12 = eVar.f();
                this.f2957c = z10 ? f12.Z() : f12.H();
                z12 = true;
            }
            this.f2958d = z12;
            if (z11) {
                Fragment f13 = eVar.f();
                obj = z10 ? f13.b0() : f13.a0();
            } else {
                obj = null;
            }
            this.f2959e = obj;
        }

        private i0 f(Object obj) {
            if (obj == null) {
                return null;
            }
            i0 i0Var = g0.f3021a;
            if (i0Var != null && i0Var.e(obj)) {
                return i0Var;
            }
            i0 i0Var2 = g0.f3022b;
            if (i0Var2 != null && i0Var2.e(obj)) {
                return i0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        i0 e() {
            i0 f10 = f(this.f2957c);
            i0 f11 = f(this.f2959e);
            if (f10 == null || f11 == null || f10 == f11) {
                return f10 != null ? f10 : f11;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f2957c + " which uses a different Transition  type than its shared element transition " + this.f2959e);
        }

        public Object g() {
            return this.f2959e;
        }

        Object h() {
            return this.f2957c;
        }

        public boolean i() {
            return this.f2959e != null;
        }

        boolean j() {
            return this.f2958d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void w(List<k> list, List<l0.e> list2, boolean z10, Map<l0.e, Boolean> map) {
        int i10;
        StringBuilder sb2;
        String str;
        boolean z11;
        k.a e10;
        l0.e eVar;
        ViewGroup m10 = m();
        Context context = m10.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<k> it = list.iterator();
        boolean z12 = false;
        while (true) {
            i10 = 2;
            if (!it.hasNext()) {
                break;
            }
            k next = it.next();
            if (next.d() || (e10 = next.e(context)) == null) {
                next.a();
            } else {
                Animator animator = e10.f3053b;
                if (animator == null) {
                    arrayList.add(next);
                } else {
                    l0.e b10 = next.b();
                    Fragment f10 = b10.f();
                    if (Boolean.TRUE.equals(map.get(b10))) {
                        if (w.H0(2)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Ignoring Animator set on ");
                            sb3.append(f10);
                            sb3.append(" as this Fragment was involved in a Transition.");
                        }
                        next.a();
                    } else {
                        boolean z13 = b10.e() == l0.e.c.GONE;
                        if (z13) {
                            list2.remove(b10);
                        }
                        View view = f10.N;
                        m10.startViewTransition(view);
                        animator.addListener(new c(this, m10, view, z13, b10, next));
                        animator.setTarget(view);
                        animator.start();
                        if (w.H0(2)) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("Animator from operation ");
                            eVar = b10;
                            sb4.append(eVar);
                            sb4.append(" has started.");
                        } else {
                            eVar = b10;
                        }
                        next.c().b(new C0048d(this, animator, eVar));
                        z12 = true;
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k kVar = (k) it2.next();
            l0.e b11 = kVar.b();
            Fragment f11 = b11.f();
            if (z10) {
                if (w.H0(i10)) {
                    sb2 = new StringBuilder();
                    sb2.append("Ignoring Animation set on ");
                    sb2.append(f11);
                    str = " as Animations cannot run alongside Transitions.";
                    sb2.append(str);
                }
                kVar.a();
            } else if (z12) {
                if (w.H0(i10)) {
                    sb2 = new StringBuilder();
                    sb2.append("Ignoring Animation set on ");
                    sb2.append(f11);
                    str = " as Animations cannot run alongside Animators.";
                    sb2.append(str);
                }
                kVar.a();
            } else {
                View view2 = f11.N;
                Animation animation = (Animation) androidx.core.util.h.f(((k.a) androidx.core.util.h.f(kVar.e(context))).f3052a);
                if (b11.e() != l0.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar.a();
                    z11 = z12;
                } else {
                    m10.startViewTransition(view2);
                    k.b bVar = new k.b(animation, m10, view2);
                    z11 = z12;
                    bVar.setAnimationListener(new e(this, b11, m10, view2, kVar));
                    view2.startAnimation(bVar);
                    if (w.H0(2)) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Animation from operation ");
                        sb5.append(b11);
                        sb5.append(" has started.");
                    }
                }
                kVar.c().b(new f(this, view2, m10, kVar, b11));
                z12 = z11;
                i10 = 2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Map<l0.e, Boolean> x(List<m> list, List<l0.e> list2, boolean z10, l0.e eVar, l0.e eVar2) {
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        l0.e eVar3;
        l0.e eVar4;
        View view2;
        Object k10;
        l.a aVar;
        ArrayList<View> arrayList3;
        l0.e eVar5;
        ArrayList<View> arrayList4;
        Rect rect;
        View view3;
        i0 i0Var;
        l0.e eVar6;
        View view4;
        boolean z11 = z10;
        l0.e eVar7 = eVar;
        l0.e eVar8 = eVar2;
        HashMap hashMap = new HashMap();
        i0 i0Var2 = null;
        for (m mVar : list) {
            if (!mVar.d()) {
                i0 e10 = mVar.e();
                if (i0Var2 == null) {
                    i0Var2 = e10;
                } else if (e10 != null && i0Var2 != e10) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (i0Var2 == null) {
            for (m mVar2 : list) {
                hashMap.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return hashMap;
        }
        View view5 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList<View> arrayList5 = new ArrayList<>();
        ArrayList<View> arrayList6 = new ArrayList<>();
        l.a aVar2 = new l.a();
        Object obj3 = null;
        View view6 = null;
        boolean z12 = false;
        for (m mVar3 : list) {
            if (!mVar3.i() || eVar7 == null || eVar8 == null) {
                aVar = aVar2;
                arrayList3 = arrayList6;
                eVar5 = eVar7;
                arrayList4 = arrayList5;
                rect = rect2;
                view3 = view5;
                i0Var = i0Var2;
                eVar6 = eVar8;
                view6 = view6;
            } else {
                Object u10 = i0Var2.u(i0Var2.f(mVar3.g()));
                ArrayList<String> c02 = eVar2.f().c0();
                ArrayList<String> c03 = eVar.f().c0();
                ArrayList<String> d02 = eVar.f().d0();
                View view7 = view6;
                int i10 = 0;
                while (i10 < d02.size()) {
                    int indexOf = c02.indexOf(d02.get(i10));
                    ArrayList<String> arrayList7 = d02;
                    if (indexOf != -1) {
                        c02.set(indexOf, c03.get(i10));
                    }
                    i10++;
                    d02 = arrayList7;
                }
                ArrayList<String> d03 = eVar2.f().d0();
                Fragment f10 = eVar.f();
                if (z11) {
                    f10.D();
                    eVar2.f().K();
                } else {
                    f10.K();
                    eVar2.f().D();
                }
                int i11 = 0;
                for (int size = c02.size(); i11 < size; size = size) {
                    aVar2.put(c02.get(i11), d03.get(i11));
                    i11++;
                }
                if (w.H0(2)) {
                    Iterator<String> it = d03.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        Iterator<String> it2 = it;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Name: ");
                        sb2.append(next);
                        it = it2;
                    }
                    Iterator<String> it3 = c02.iterator();
                    while (it3.hasNext()) {
                        String next2 = it3.next();
                        Iterator<String> it4 = it3;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Name: ");
                        sb3.append(next2);
                        it3 = it4;
                    }
                }
                l.a<String, View> aVar3 = new l.a<>();
                u(aVar3, eVar.f().N);
                aVar3.p(c02);
                aVar2.p(aVar3.keySet());
                l.a<String, View> aVar4 = new l.a<>();
                u(aVar4, eVar2.f().N);
                aVar4.p(d03);
                aVar4.p(aVar2.values());
                g0.c(aVar2, aVar4);
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    aVar = aVar2;
                    arrayList3 = arrayList6;
                    eVar5 = eVar7;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    i0Var = i0Var2;
                    view6 = view7;
                    obj3 = null;
                    eVar6 = eVar8;
                } else {
                    g0.a(eVar2.f(), eVar.f(), z11, aVar3, true);
                    aVar = aVar2;
                    ArrayList<View> arrayList8 = arrayList6;
                    androidx.core.view.x.a(m(), new g(this, eVar2, eVar, z10, aVar4));
                    arrayList5.addAll(aVar3.values());
                    if (c02.isEmpty()) {
                        view6 = view7;
                    } else {
                        View view8 = (View) aVar3.get(c02.get(0));
                        i0Var2.p(u10, view8);
                        view6 = view8;
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(aVar4.values());
                    if (!d03.isEmpty() && (view4 = (View) aVar4.get(d03.get(0))) != null) {
                        androidx.core.view.x.a(m(), new h(this, i0Var2, view4, rect2));
                        z12 = true;
                    }
                    i0Var2.s(u10, view5, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    i0Var = i0Var2;
                    i0Var2.n(u10, null, null, null, null, u10, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    eVar5 = eVar;
                    hashMap.put(eVar5, bool);
                    eVar6 = eVar2;
                    hashMap.put(eVar6, bool);
                    obj3 = u10;
                }
            }
            eVar7 = eVar5;
            arrayList5 = arrayList4;
            rect2 = rect;
            view5 = view3;
            eVar8 = eVar6;
            aVar2 = aVar;
            z11 = z10;
            arrayList6 = arrayList3;
            i0Var2 = i0Var;
        }
        View view9 = view6;
        l.a aVar5 = aVar2;
        ArrayList<View> arrayList9 = arrayList6;
        l0.e eVar9 = eVar7;
        ArrayList<View> arrayList10 = arrayList5;
        Rect rect3 = rect2;
        View view10 = view5;
        i0 i0Var3 = i0Var2;
        l0.e eVar10 = eVar8;
        ArrayList arrayList11 = new ArrayList();
        Object obj4 = null;
        Object obj5 = null;
        for (m mVar4 : list) {
            if (mVar4.d()) {
                hashMap.put(mVar4.b(), Boolean.FALSE);
                mVar4.a();
            } else {
                Object f11 = i0Var3.f(mVar4.h());
                l0.e b10 = mVar4.b();
                boolean z13 = obj3 != null && (b10 == eVar9 || b10 == eVar10);
                if (f11 == null) {
                    if (!z13) {
                        hashMap.put(b10, Boolean.FALSE);
                        mVar4.a();
                    }
                    arrayList2 = arrayList9;
                    arrayList = arrayList10;
                    view = view10;
                    k10 = obj4;
                    eVar3 = eVar10;
                    view2 = view9;
                } else {
                    ArrayList<View> arrayList12 = new ArrayList<>();
                    Object obj6 = obj4;
                    t(arrayList12, b10.f().N);
                    if (z13) {
                        if (b10 == eVar9) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        i0Var3.a(f11, view10);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view10;
                        eVar4 = b10;
                        obj2 = obj5;
                        eVar3 = eVar10;
                        obj = obj6;
                    } else {
                        i0Var3.b(f11, arrayList12);
                        view = view10;
                        obj = obj6;
                        arrayList = arrayList10;
                        obj2 = obj5;
                        arrayList2 = arrayList9;
                        eVar3 = eVar10;
                        i0Var3.n(f11, f11, arrayList12, null, null, null, null);
                        if (b10.e() == l0.e.c.GONE) {
                            eVar4 = b10;
                            list2.remove(eVar4);
                            ArrayList<View> arrayList13 = new ArrayList<>(arrayList12);
                            arrayList13.remove(eVar4.f().N);
                            i0Var3.m(f11, eVar4.f().N, arrayList13);
                            androidx.core.view.x.a(m(), new i(this, arrayList12));
                        } else {
                            eVar4 = b10;
                        }
                    }
                    if (eVar4.e() == l0.e.c.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z12) {
                            i0Var3.o(f11, rect3);
                        }
                        view2 = view9;
                    } else {
                        view2 = view9;
                        i0Var3.p(f11, view2);
                    }
                    hashMap.put(eVar4, Boolean.TRUE);
                    if (mVar4.j()) {
                        obj5 = i0Var3.k(obj2, f11, null);
                        k10 = obj;
                    } else {
                        k10 = i0Var3.k(obj, f11, null);
                        obj5 = obj2;
                    }
                }
                eVar10 = eVar3;
                obj4 = k10;
                view9 = view2;
                view10 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
            }
        }
        ArrayList<View> arrayList14 = arrayList9;
        ArrayList<View> arrayList15 = arrayList10;
        l0.e eVar11 = eVar10;
        Object j10 = i0Var3.j(obj5, obj4, obj3);
        if (j10 == null) {
            return hashMap;
        }
        for (m mVar5 : list) {
            if (!mVar5.d()) {
                Object h10 = mVar5.h();
                l0.e b11 = mVar5.b();
                boolean z14 = obj3 != null && (b11 == eVar9 || b11 == eVar11);
                if (h10 != null || z14) {
                    if (androidx.core.view.a0.S(m())) {
                        i0Var3.q(mVar5.b().f(), j10, mVar5.c(), new j(this, mVar5, b11));
                    } else {
                        if (w.H0(2)) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append("SpecialEffectsController: Container ");
                            sb4.append(m());
                            sb4.append(" has not been laid out. Completing operation ");
                            sb4.append(b11);
                        }
                        mVar5.a();
                    }
                }
            }
        }
        if (!androidx.core.view.a0.S(m())) {
            return hashMap;
        }
        g0.d(arrayList11, 4);
        ArrayList<String> l10 = i0Var3.l(arrayList14);
        if (w.H0(2)) {
            Iterator<View> it5 = arrayList15.iterator();
            while (it5.hasNext()) {
                View next3 = it5.next();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("View: ");
                sb5.append(next3);
                sb5.append(" Name: ");
                sb5.append(androidx.core.view.a0.I(next3));
            }
            Iterator<View> it6 = arrayList14.iterator();
            while (it6.hasNext()) {
                View next4 = it6.next();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("View: ");
                sb6.append(next4);
                sb6.append(" Name: ");
                sb6.append(androidx.core.view.a0.I(next4));
            }
        }
        i0Var3.c(m(), j10);
        i0Var3.r(m(), arrayList15, arrayList14, l10, aVar5);
        g0.d(arrayList11, 0);
        i0Var3.t(obj3, arrayList15, arrayList14);
        return hashMap;
    }

    private void y(List<l0.e> list) {
        Fragment f10 = list.get(list.size() - 1).f();
        for (l0.e eVar : list) {
            eVar.f().Q.f2860c = f10.Q.f2860c;
            eVar.f().Q.f2861d = f10.Q.f2861d;
            eVar.f().Q.f2862e = f10.Q.f2862e;
            eVar.f().Q.f2863f = f10.Q.f2863f;
        }
    }

    @Override // androidx.fragment.app.l0
    void f(List<l0.e> list, boolean z10) {
        l0.e eVar = null;
        l0.e eVar2 = null;
        for (l0.e eVar3 : list) {
            l0.e.c from = l0.e.c.from(eVar3.f().N);
            int i10 = a.f2922a[eVar3.e().ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                if (from == l0.e.c.VISIBLE && eVar == null) {
                    eVar = eVar3;
                }
            } else if (i10 == 4 && from != l0.e.c.VISIBLE) {
                eVar2 = eVar3;
            }
        }
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Executing operations from ");
            sb2.append(eVar);
            sb2.append(" to ");
            sb2.append(eVar2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        y(list);
        for (l0.e eVar4 : list) {
            androidx.core.os.e eVar5 = new androidx.core.os.e();
            eVar4.j(eVar5);
            arrayList.add(new k(eVar4, eVar5, z10));
            androidx.core.os.e eVar6 = new androidx.core.os.e();
            eVar4.j(eVar6);
            boolean z11 = false;
            if (z10) {
                if (eVar4 != eVar) {
                    arrayList2.add(new m(eVar4, eVar6, z10, z11));
                    eVar4.a(new b(arrayList3, eVar4));
                }
                z11 = true;
                arrayList2.add(new m(eVar4, eVar6, z10, z11));
                eVar4.a(new b(arrayList3, eVar4));
            } else {
                if (eVar4 != eVar2) {
                    arrayList2.add(new m(eVar4, eVar6, z10, z11));
                    eVar4.a(new b(arrayList3, eVar4));
                }
                z11 = true;
                arrayList2.add(new m(eVar4, eVar6, z10, z11));
                eVar4.a(new b(arrayList3, eVar4));
            }
        }
        Map<l0.e, Boolean> x10 = x(arrayList2, arrayList3, z10, eVar, eVar2);
        w(arrayList, arrayList3, x10.containsValue(Boolean.TRUE), x10);
        Iterator<l0.e> it = arrayList3.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        arrayList3.clear();
        if (w.H0(2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Completed executing operations from ");
            sb3.append(eVar);
            sb3.append(" to ");
            sb3.append(eVar2);
        }
    }

    void s(l0.e eVar) {
        eVar.e().applyState(eVar.f().N);
    }

    void t(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (androidx.core.view.d0.a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    void u(Map<String, View> map, View view) {
        String I = androidx.core.view.a0.I(view);
        if (I != null) {
            map.put(I, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    void v(l.a<String, View> aVar, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(androidx.core.view.a0.I(it.next().getValue()))) {
                it.remove();
            }
        }
    }
}
