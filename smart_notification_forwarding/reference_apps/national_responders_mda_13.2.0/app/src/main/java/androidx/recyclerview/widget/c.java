package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.a0;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class c extends m {

    /* renamed from: s, reason: collision with root package name */
    private static TimeInterpolator f3522s;

    /* renamed from: h, reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f3523h = new ArrayList<>();

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<RecyclerView.d0> f3524i = new ArrayList<>();

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<j> f3525j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<i> f3526k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    ArrayList<ArrayList<RecyclerView.d0>> f3527l = new ArrayList<>();

    /* renamed from: m, reason: collision with root package name */
    ArrayList<ArrayList<j>> f3528m = new ArrayList<>();

    /* renamed from: n, reason: collision with root package name */
    ArrayList<ArrayList<i>> f3529n = new ArrayList<>();

    /* renamed from: o, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f3530o = new ArrayList<>();

    /* renamed from: p, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f3531p = new ArrayList<>();

    /* renamed from: q, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f3532q = new ArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    ArrayList<RecyclerView.d0> f3533r = new ArrayList<>();

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f3534f;

        a(ArrayList arrayList) {
            this.f3534f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f3534f.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                c.this.S(jVar.f3568a, jVar.f3569b, jVar.f3570c, jVar.f3571d, jVar.f3572e);
            }
            this.f3534f.clear();
            c.this.f3528m.remove(this.f3534f);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f3536f;

        b(ArrayList arrayList) {
            this.f3536f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f3536f.iterator();
            while (it.hasNext()) {
                c.this.R((i) it.next());
            }
            this.f3536f.clear();
            c.this.f3529n.remove(this.f3536f);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0058c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f3538f;

        RunnableC0058c(ArrayList arrayList) {
            this.f3538f = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f3538f.iterator();
            while (it.hasNext()) {
                c.this.Q((RecyclerView.d0) it.next());
            }
            this.f3538f.clear();
            c.this.f3527l.remove(this.f3538f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f3540a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3541b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3542c;

        d(RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3540a = d0Var;
            this.f3541b = viewPropertyAnimator;
            this.f3542c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3541b.setListener(null);
            this.f3542c.setAlpha(1.0f);
            c.this.G(this.f3540a);
            c.this.f3532q.remove(this.f3540a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.H(this.f3540a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f3544a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f3545b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3546c;

        e(RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f3544a = d0Var;
            this.f3545b = view;
            this.f3546c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3545b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3546c.setListener(null);
            c.this.A(this.f3544a);
            c.this.f3530o.remove(this.f3544a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.B(this.f3544a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView.d0 f3548a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f3549b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3550c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f3551d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3552e;

        f(RecyclerView.d0 d0Var, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f3548a = d0Var;
            this.f3549b = i10;
            this.f3550c = view;
            this.f3551d = i11;
            this.f3552e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f3549b != 0) {
                this.f3550c.setTranslationX(0.0f);
            }
            if (this.f3551d != 0) {
                this.f3550c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3552e.setListener(null);
            c.this.E(this.f3548a);
            c.this.f3531p.remove(this.f3548a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.F(this.f3548a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f3554a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3555b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3556c;

        g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3554a = iVar;
            this.f3555b = viewPropertyAnimator;
            this.f3556c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3555b.setListener(null);
            this.f3556c.setAlpha(1.0f);
            this.f3556c.setTranslationX(0.0f);
            this.f3556c.setTranslationY(0.0f);
            c.this.C(this.f3554a.f3562a, true);
            c.this.f3533r.remove(this.f3554a.f3562a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f3554a.f3562a, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f3558a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewPropertyAnimator f3559b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f3560c;

        h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3558a = iVar;
            this.f3559b = viewPropertyAnimator;
            this.f3560c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3559b.setListener(null);
            this.f3560c.setAlpha(1.0f);
            this.f3560c.setTranslationX(0.0f);
            this.f3560c.setTranslationY(0.0f);
            c.this.C(this.f3558a.f3563b, false);
            c.this.f3533r.remove(this.f3558a.f3563b);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f3558a.f3563b, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f3562a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.d0 f3563b;

        /* renamed from: c, reason: collision with root package name */
        public int f3564c;

        /* renamed from: d, reason: collision with root package name */
        public int f3565d;

        /* renamed from: e, reason: collision with root package name */
        public int f3566e;

        /* renamed from: f, reason: collision with root package name */
        public int f3567f;

        private i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            this.f3562a = d0Var;
            this.f3563b = d0Var2;
        }

        i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13) {
            this(d0Var, d0Var2);
            this.f3564c = i10;
            this.f3565d = i11;
            this.f3566e = i12;
            this.f3567f = i13;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f3562a + ", newHolder=" + this.f3563b + ", fromX=" + this.f3564c + ", fromY=" + this.f3565d + ", toX=" + this.f3566e + ", toY=" + this.f3567f + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f3568a;

        /* renamed from: b, reason: collision with root package name */
        public int f3569b;

        /* renamed from: c, reason: collision with root package name */
        public int f3570c;

        /* renamed from: d, reason: collision with root package name */
        public int f3571d;

        /* renamed from: e, reason: collision with root package name */
        public int f3572e;

        j(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
            this.f3568a = d0Var;
            this.f3569b = i10;
            this.f3570c = i11;
            this.f3571d = i12;
            this.f3572e = i13;
        }
    }

    private void T(RecyclerView.d0 d0Var) {
        View view = d0Var.f3375a;
        ViewPropertyAnimator animate = view.animate();
        this.f3532q.add(d0Var);
        animate.setDuration(o()).alpha(0.0f).setListener(new d(d0Var, animate, view)).start();
    }

    private void W(List<i> list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (Y(iVar, d0Var) && iVar.f3562a == null && iVar.f3563b == null) {
                list.remove(iVar);
            }
        }
    }

    private void X(i iVar) {
        RecyclerView.d0 d0Var = iVar.f3562a;
        if (d0Var != null) {
            Y(iVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = iVar.f3563b;
        if (d0Var2 != null) {
            Y(iVar, d0Var2);
        }
    }

    private boolean Y(i iVar, RecyclerView.d0 d0Var) {
        boolean z10 = false;
        if (iVar.f3563b == d0Var) {
            iVar.f3563b = null;
        } else {
            if (iVar.f3562a != d0Var) {
                return false;
            }
            iVar.f3562a = null;
            z10 = true;
        }
        d0Var.f3375a.setAlpha(1.0f);
        d0Var.f3375a.setTranslationX(0.0f);
        d0Var.f3375a.setTranslationY(0.0f);
        C(d0Var, z10);
        return true;
    }

    private void Z(RecyclerView.d0 d0Var) {
        if (f3522s == null) {
            f3522s = new ValueAnimator().getInterpolator();
        }
        d0Var.f3375a.animate().setInterpolator(f3522s);
        j(d0Var);
    }

    void Q(RecyclerView.d0 d0Var) {
        View view = d0Var.f3375a;
        ViewPropertyAnimator animate = view.animate();
        this.f3530o.add(d0Var);
        animate.alpha(1.0f).setDuration(l()).setListener(new e(d0Var, view, animate)).start();
    }

    void R(i iVar) {
        RecyclerView.d0 d0Var = iVar.f3562a;
        View view = d0Var == null ? null : d0Var.f3375a;
        RecyclerView.d0 d0Var2 = iVar.f3563b;
        View view2 = d0Var2 != null ? d0Var2.f3375a : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f3533r.add(iVar.f3562a);
            duration.translationX(iVar.f3566e - iVar.f3564c);
            duration.translationY(iVar.f3567f - iVar.f3565d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f3533r.add(iVar.f3563b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    void S(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
        View view = d0Var.f3375a;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f3531p.add(d0Var);
        animate.setDuration(n()).setListener(new f(d0Var, i14, view, i15, animate)).start();
    }

    void U(List<RecyclerView.d0> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).f3375a.animate().cancel();
        }
    }

    void V() {
        if (p()) {
            return;
        }
        i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.d0 d0Var, List<Object> list) {
        return !list.isEmpty() || super.g(d0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.d0 d0Var) {
        View view = d0Var.f3375a;
        view.animate().cancel();
        int size = this.f3525j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.f3525j.get(size).f3568a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(d0Var);
                this.f3525j.remove(size);
            }
        }
        W(this.f3526k, d0Var);
        if (this.f3523h.remove(d0Var)) {
            view.setAlpha(1.0f);
            G(d0Var);
        }
        if (this.f3524i.remove(d0Var)) {
            view.setAlpha(1.0f);
            A(d0Var);
        }
        for (int size2 = this.f3529n.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.f3529n.get(size2);
            W(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.f3529n.remove(size2);
            }
        }
        for (int size3 = this.f3528m.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.f3528m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).f3568a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(d0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f3528m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f3527l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.d0> arrayList3 = this.f3527l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                A(d0Var);
                if (arrayList3.isEmpty()) {
                    this.f3527l.remove(size5);
                }
            }
        }
        this.f3532q.remove(d0Var);
        this.f3530o.remove(d0Var);
        this.f3533r.remove(d0Var);
        this.f3531p.remove(d0Var);
        V();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f3525j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.f3525j.get(size);
            View view = jVar.f3568a.f3375a;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(jVar.f3568a);
            this.f3525j.remove(size);
        }
        for (int size2 = this.f3523h.size() - 1; size2 >= 0; size2--) {
            G(this.f3523h.get(size2));
            this.f3523h.remove(size2);
        }
        int size3 = this.f3524i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = this.f3524i.get(size3);
            d0Var.f3375a.setAlpha(1.0f);
            A(d0Var);
            this.f3524i.remove(size3);
        }
        for (int size4 = this.f3526k.size() - 1; size4 >= 0; size4--) {
            X(this.f3526k.get(size4));
        }
        this.f3526k.clear();
        if (p()) {
            for (int size5 = this.f3528m.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.f3528m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.f3568a.f3375a;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    E(jVar2.f3568a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f3528m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f3527l.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.d0> arrayList2 = this.f3527l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = arrayList2.get(size8);
                    d0Var2.f3375a.setAlpha(1.0f);
                    A(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f3527l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f3529n.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.f3529n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    X(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f3529n.remove(arrayList3);
                    }
                }
            }
            U(this.f3532q);
            U(this.f3531p);
            U(this.f3530o);
            U(this.f3533r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.f3524i.isEmpty() && this.f3526k.isEmpty() && this.f3525j.isEmpty() && this.f3523h.isEmpty() && this.f3531p.isEmpty() && this.f3532q.isEmpty() && this.f3530o.isEmpty() && this.f3533r.isEmpty() && this.f3528m.isEmpty() && this.f3527l.isEmpty() && this.f3529n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void u() {
        boolean z10 = !this.f3523h.isEmpty();
        boolean z11 = !this.f3525j.isEmpty();
        boolean z12 = !this.f3526k.isEmpty();
        boolean z13 = !this.f3524i.isEmpty();
        if (z10 || z11 || z13 || z12) {
            Iterator<RecyclerView.d0> it = this.f3523h.iterator();
            while (it.hasNext()) {
                T(it.next());
            }
            this.f3523h.clear();
            if (z11) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.f3525j);
                this.f3528m.add(arrayList);
                this.f3525j.clear();
                a aVar = new a(arrayList);
                if (z10) {
                    a0.f0(arrayList.get(0).f3568a.f3375a, aVar, o());
                } else {
                    aVar.run();
                }
            }
            if (z12) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.f3526k);
                this.f3529n.add(arrayList2);
                this.f3526k.clear();
                b bVar = new b(arrayList2);
                if (z10) {
                    a0.f0(arrayList2.get(0).f3562a.f3375a, bVar, o());
                } else {
                    bVar.run();
                }
            }
            if (z13) {
                ArrayList<RecyclerView.d0> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.f3524i);
                this.f3527l.add(arrayList3);
                this.f3524i.clear();
                RunnableC0058c runnableC0058c = new RunnableC0058c(arrayList3);
                if (z10 || z11 || z12) {
                    a0.f0(arrayList3.get(0).f3375a, runnableC0058c, (z10 ? o() : 0L) + Math.max(z11 ? n() : 0L, z12 ? m() : 0L));
                } else {
                    runnableC0058c.run();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.m
    public boolean w(RecyclerView.d0 d0Var) {
        Z(d0Var);
        d0Var.f3375a.setAlpha(0.0f);
        this.f3524i.add(d0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean x(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13) {
        if (d0Var == d0Var2) {
            return y(d0Var, i10, i11, i12, i13);
        }
        float translationX = d0Var.f3375a.getTranslationX();
        float translationY = d0Var.f3375a.getTranslationY();
        float alpha = d0Var.f3375a.getAlpha();
        Z(d0Var);
        int i14 = (int) ((i12 - i10) - translationX);
        int i15 = (int) ((i13 - i11) - translationY);
        d0Var.f3375a.setTranslationX(translationX);
        d0Var.f3375a.setTranslationY(translationY);
        d0Var.f3375a.setAlpha(alpha);
        if (d0Var2 != null) {
            Z(d0Var2);
            d0Var2.f3375a.setTranslationX(-i14);
            d0Var2.f3375a.setTranslationY(-i15);
            d0Var2.f3375a.setAlpha(0.0f);
        }
        this.f3526k.add(new i(d0Var, d0Var2, i10, i11, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean y(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
        View view = d0Var.f3375a;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) d0Var.f3375a.getTranslationY());
        Z(d0Var);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            E(d0Var);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX(-i14);
        }
        if (i15 != 0) {
            view.setTranslationY(-i15);
        }
        this.f3525j.add(new j(d0Var, translationX, translationY, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.m
    public boolean z(RecyclerView.d0 d0Var) {
        Z(d0Var);
        this.f3523h.add(d0Var);
        return true;
    }
}
