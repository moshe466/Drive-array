package s0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class m implements Cloneable {
    private static final int[] L = {2, 1, 3, 4};
    private static final g M = new a();
    private static ThreadLocal<l.a<Animator, d>> N = new ThreadLocal<>();
    p H;
    private e I;
    private l.a<String, String> J;

    /* renamed from: y, reason: collision with root package name */
    private ArrayList<s> f13965y;

    /* renamed from: z, reason: collision with root package name */
    private ArrayList<s> f13966z;

    /* renamed from: f, reason: collision with root package name */
    private String f13946f = getClass().getName();

    /* renamed from: g, reason: collision with root package name */
    private long f13947g = -1;

    /* renamed from: h, reason: collision with root package name */
    long f13948h = -1;

    /* renamed from: i, reason: collision with root package name */
    private TimeInterpolator f13949i = null;

    /* renamed from: j, reason: collision with root package name */
    ArrayList<Integer> f13950j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    ArrayList<View> f13951k = new ArrayList<>();

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<String> f13952l = null;

    /* renamed from: m, reason: collision with root package name */
    private ArrayList<Class> f13953m = null;

    /* renamed from: n, reason: collision with root package name */
    private ArrayList<Integer> f13954n = null;

    /* renamed from: o, reason: collision with root package name */
    private ArrayList<View> f13955o = null;

    /* renamed from: p, reason: collision with root package name */
    private ArrayList<Class> f13956p = null;

    /* renamed from: q, reason: collision with root package name */
    private ArrayList<String> f13957q = null;

    /* renamed from: r, reason: collision with root package name */
    private ArrayList<Integer> f13958r = null;

    /* renamed from: s, reason: collision with root package name */
    private ArrayList<View> f13959s = null;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList<Class> f13960t = null;

    /* renamed from: u, reason: collision with root package name */
    private t f13961u = new t();

    /* renamed from: v, reason: collision with root package name */
    private t f13962v = new t();

    /* renamed from: w, reason: collision with root package name */
    q f13963w = null;

    /* renamed from: x, reason: collision with root package name */
    private int[] f13964x = L;
    boolean A = false;
    ArrayList<Animator> B = new ArrayList<>();
    private int C = 0;
    private boolean D = false;
    private boolean E = false;
    private ArrayList<f> F = null;
    private ArrayList<Animator> G = new ArrayList<>();
    private g K = M;

    /* loaded from: classes.dex */
    static class a extends g {
        a() {
        }

        @Override // s0.g
        public Path a(float f10, float f11, float f12, float f13) {
            Path path = new Path();
            path.moveTo(f10, f11);
            path.lineTo(f12, f13);
            return path;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.a f13967a;

        b(l.a aVar) {
            this.f13967a = aVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f13967a.remove(animator);
            m.this.B.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            m.this.B.add(animator);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m.this.s();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        View f13970a;

        /* renamed from: b, reason: collision with root package name */
        String f13971b;

        /* renamed from: c, reason: collision with root package name */
        s f13972c;

        /* renamed from: d, reason: collision with root package name */
        l0 f13973d;

        /* renamed from: e, reason: collision with root package name */
        m f13974e;

        d(View view, String str, m mVar, l0 l0Var, s sVar) {
            this.f13970a = view;
            this.f13971b = str;
            this.f13972c = sVar;
            this.f13973d = l0Var;
            this.f13974e = mVar;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e {
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(m mVar);

        void b(m mVar);

        void c(m mVar);

        void d(m mVar);
    }

    private static l.a<Animator, d> B() {
        l.a<Animator, d> aVar = N.get();
        if (aVar != null) {
            return aVar;
        }
        l.a<Animator, d> aVar2 = new l.a<>();
        N.set(aVar2);
        return aVar2;
    }

    private static boolean P(s sVar, s sVar2, String str) {
        Object obj = sVar.f13987a.get(str);
        Object obj2 = sVar2.f13987a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void Q(l.a<View, s> aVar, l.a<View, s> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i10 = 0; i10 < size; i10++) {
            View valueAt = sparseArray.valueAt(i10);
            if (valueAt != null && O(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i10))) != null && O(view)) {
                s sVar = aVar.get(valueAt);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f13965y.add(sVar);
                    this.f13966z.add(sVar2);
                    aVar.remove(valueAt);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void R(l.a<View, s> aVar, l.a<View, s> aVar2) {
        s remove;
        View view;
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View i10 = aVar.i(size);
            if (i10 != null && O(i10) && (remove = aVar2.remove(i10)) != null && (view = remove.f13988b) != null && O(view)) {
                this.f13965y.add(aVar.k(size));
                this.f13966z.add(remove);
            }
        }
    }

    private void S(l.a<View, s> aVar, l.a<View, s> aVar2, l.d<View> dVar, l.d<View> dVar2) {
        View h10;
        int p10 = dVar.p();
        for (int i10 = 0; i10 < p10; i10++) {
            View q10 = dVar.q(i10);
            if (q10 != null && O(q10) && (h10 = dVar2.h(dVar.l(i10))) != null && O(h10)) {
                s sVar = aVar.get(q10);
                s sVar2 = aVar2.get(h10);
                if (sVar != null && sVar2 != null) {
                    this.f13965y.add(sVar);
                    this.f13966z.add(sVar2);
                    aVar.remove(q10);
                    aVar2.remove(h10);
                }
            }
        }
    }

    private void T(l.a<View, s> aVar, l.a<View, s> aVar2, l.a<String, View> aVar3, l.a<String, View> aVar4) {
        View view;
        int size = aVar3.size();
        for (int i10 = 0; i10 < size; i10++) {
            View n10 = aVar3.n(i10);
            if (n10 != null && O(n10) && (view = aVar4.get(aVar3.i(i10))) != null && O(view)) {
                s sVar = aVar.get(n10);
                s sVar2 = aVar2.get(view);
                if (sVar != null && sVar2 != null) {
                    this.f13965y.add(sVar);
                    this.f13966z.add(sVar2);
                    aVar.remove(n10);
                    aVar2.remove(view);
                }
            }
        }
    }

    private void U(t tVar, t tVar2) {
        l.a<View, s> aVar = new l.a<>(tVar.f13990a);
        l.a<View, s> aVar2 = new l.a<>(tVar2.f13990a);
        int i10 = 0;
        while (true) {
            int[] iArr = this.f13964x;
            if (i10 >= iArr.length) {
                d(aVar, aVar2);
                return;
            }
            int i11 = iArr[i10];
            if (i11 == 1) {
                R(aVar, aVar2);
            } else if (i11 == 2) {
                T(aVar, aVar2, tVar.f13993d, tVar2.f13993d);
            } else if (i11 == 3) {
                Q(aVar, aVar2, tVar.f13991b, tVar2.f13991b);
            } else if (i11 == 4) {
                S(aVar, aVar2, tVar.f13992c, tVar2.f13992c);
            }
            i10++;
        }
    }

    private void a0(Animator animator, l.a<Animator, d> aVar) {
        if (animator != null) {
            animator.addListener(new b(aVar));
            h(animator);
        }
    }

    private void d(l.a<View, s> aVar, l.a<View, s> aVar2) {
        for (int i10 = 0; i10 < aVar.size(); i10++) {
            s n10 = aVar.n(i10);
            if (O(n10.f13988b)) {
                this.f13965y.add(n10);
                this.f13966z.add(null);
            }
        }
        for (int i11 = 0; i11 < aVar2.size(); i11++) {
            s n11 = aVar2.n(i11);
            if (O(n11.f13988b)) {
                this.f13966z.add(n11);
                this.f13965y.add(null);
            }
        }
    }

    private static void e(t tVar, View view, s sVar) {
        tVar.f13990a.put(view, sVar);
        int id = view.getId();
        if (id >= 0) {
            if (tVar.f13991b.indexOfKey(id) >= 0) {
                tVar.f13991b.put(id, null);
            } else {
                tVar.f13991b.put(id, view);
            }
        }
        String I = androidx.core.view.a0.I(view);
        if (I != null) {
            if (tVar.f13993d.containsKey(I)) {
                tVar.f13993d.put(I, null);
            } else {
                tVar.f13993d.put(I, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (tVar.f13992c.k(itemIdAtPosition) < 0) {
                    androidx.core.view.a0.t0(view, true);
                    tVar.f13992c.m(itemIdAtPosition, view);
                    return;
                }
                View h10 = tVar.f13992c.h(itemIdAtPosition);
                if (h10 != null) {
                    androidx.core.view.a0.t0(h10, false);
                    tVar.f13992c.m(itemIdAtPosition, null);
                }
            }
        }
    }

    private void k(View view, boolean z10) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.f13954n;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.f13955o;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class> arrayList3 = this.f13956p;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        if (this.f13956p.get(i10).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    s sVar = new s();
                    sVar.f13988b = view;
                    if (z10) {
                        m(sVar);
                    } else {
                        i(sVar);
                    }
                    sVar.f13989c.add(this);
                    l(sVar);
                    e(z10 ? this.f13961u : this.f13962v, view, sVar);
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.f13958r;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.f13959s;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class> arrayList6 = this.f13960t;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i11 = 0; i11 < size2; i11++) {
                                    if (this.f13960t.get(i11).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i12 = 0; i12 < viewGroup.getChildCount(); i12++) {
                                k(viewGroup.getChildAt(i12), z10);
                            }
                        }
                    }
                }
            }
        }
    }

    public p A() {
        return this.H;
    }

    public long C() {
        return this.f13947g;
    }

    public List<Integer> E() {
        return this.f13950j;
    }

    public List<String> F() {
        return this.f13952l;
    }

    public List<Class> G() {
        return this.f13953m;
    }

    public List<View> I() {
        return this.f13951k;
    }

    public String[] J() {
        return null;
    }

    public s K(View view, boolean z10) {
        q qVar = this.f13963w;
        if (qVar != null) {
            return qVar.K(view, z10);
        }
        return (z10 ? this.f13961u : this.f13962v).f13990a.get(view);
    }

    public boolean L(s sVar, s sVar2) {
        if (sVar == null || sVar2 == null) {
            return false;
        }
        String[] J = J();
        if (J == null) {
            Iterator<String> it = sVar.f13987a.keySet().iterator();
            while (it.hasNext()) {
                if (P(sVar, sVar2, it.next())) {
                }
            }
            return false;
        }
        for (String str : J) {
            if (!P(sVar, sVar2, str)) {
            }
        }
        return false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O(View view) {
        ArrayList<Class> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.f13954n;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.f13955o;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class> arrayList5 = this.f13956p;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (this.f13956p.get(i10).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.f13957q != null && androidx.core.view.a0.I(view) != null && this.f13957q.contains(androidx.core.view.a0.I(view))) {
            return false;
        }
        if ((this.f13950j.size() == 0 && this.f13951k.size() == 0 && (((arrayList = this.f13953m) == null || arrayList.isEmpty()) && ((arrayList2 = this.f13952l) == null || arrayList2.isEmpty()))) || this.f13950j.contains(Integer.valueOf(id)) || this.f13951k.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.f13952l;
        if (arrayList6 != null && arrayList6.contains(androidx.core.view.a0.I(view))) {
            return true;
        }
        if (this.f13953m != null) {
            for (int i11 = 0; i11 < this.f13953m.size(); i11++) {
                if (this.f13953m.get(i11).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void V(View view) {
        if (this.E) {
            return;
        }
        l.a<Animator, d> B = B();
        int size = B.size();
        l0 e10 = d0.e(view);
        for (int i10 = size - 1; i10 >= 0; i10--) {
            d n10 = B.n(i10);
            if (n10.f13970a != null && e10.equals(n10.f13973d)) {
                s0.a.b(B.i(i10));
            }
        }
        ArrayList<f> arrayList = this.F;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.F.clone();
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ((f) arrayList2.get(i11)).a(this);
            }
        }
        this.D = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(ViewGroup viewGroup) {
        d dVar;
        this.f13965y = new ArrayList<>();
        this.f13966z = new ArrayList<>();
        U(this.f13961u, this.f13962v);
        l.a<Animator, d> B = B();
        int size = B.size();
        l0 e10 = d0.e(viewGroup);
        for (int i10 = size - 1; i10 >= 0; i10--) {
            Animator i11 = B.i(i10);
            if (i11 != null && (dVar = B.get(i11)) != null && dVar.f13970a != null && e10.equals(dVar.f13973d)) {
                s sVar = dVar.f13972c;
                View view = dVar.f13970a;
                s K = K(view, true);
                s x10 = x(view, true);
                if (!(K == null && x10 == null) && dVar.f13974e.L(sVar, x10)) {
                    if (i11.isRunning() || i11.isStarted()) {
                        i11.cancel();
                    } else {
                        B.remove(i11);
                    }
                }
            }
        }
        r(viewGroup, this.f13961u, this.f13962v, this.f13965y, this.f13966z);
        b0();
    }

    public m X(f fVar) {
        ArrayList<f> arrayList = this.F;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.F.size() == 0) {
            this.F = null;
        }
        return this;
    }

    public m Y(View view) {
        this.f13951k.remove(view);
        return this;
    }

    public void Z(View view) {
        if (this.D) {
            if (!this.E) {
                l.a<Animator, d> B = B();
                int size = B.size();
                l0 e10 = d0.e(view);
                for (int i10 = size - 1; i10 >= 0; i10--) {
                    d n10 = B.n(i10);
                    if (n10.f13970a != null && e10.equals(n10.f13973d)) {
                        s0.a.c(B.i(i10));
                    }
                }
                ArrayList<f> arrayList = this.F;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.F.clone();
                    int size2 = arrayList2.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        ((f) arrayList2.get(i11)).d(this);
                    }
                }
            }
            this.D = false;
        }
    }

    public m a(f fVar) {
        if (this.F == null) {
            this.F = new ArrayList<>();
        }
        this.F.add(fVar);
        return this;
    }

    public m b(View view) {
        this.f13951k.add(view);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b0() {
        i0();
        l.a<Animator, d> B = B();
        Iterator<Animator> it = this.G.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (B.containsKey(next)) {
                i0();
                a0(next, B);
            }
        }
        this.G.clear();
        s();
    }

    public m c0(long j10) {
        this.f13948h = j10;
        return this;
    }

    public void d0(e eVar) {
        this.I = eVar;
    }

    public m e0(TimeInterpolator timeInterpolator) {
        this.f13949i = timeInterpolator;
        return this;
    }

    public void f0(g gVar) {
        if (gVar == null) {
            gVar = M;
        }
        this.K = gVar;
    }

    public void g0(p pVar) {
    }

    protected void h(Animator animator) {
        if (animator == null) {
            s();
            return;
        }
        if (t() >= 0) {
            animator.setDuration(t());
        }
        if (C() >= 0) {
            animator.setStartDelay(C());
        }
        if (w() != null) {
            animator.setInterpolator(w());
        }
        animator.addListener(new c());
        animator.start();
    }

    public m h0(long j10) {
        this.f13947g = j10;
        return this;
    }

    public abstract void i(s sVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void i0() {
        if (this.C == 0) {
            ArrayList<f> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size = arrayList2.size();
                for (int i10 = 0; i10 < size; i10++) {
                    ((f) arrayList2.get(i10)).c(this);
                }
            }
            this.E = false;
        }
        this.C++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String j0(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.f13948h != -1) {
            str2 = str2 + "dur(" + this.f13948h + ") ";
        }
        if (this.f13947g != -1) {
            str2 = str2 + "dly(" + this.f13947g + ") ";
        }
        if (this.f13949i != null) {
            str2 = str2 + "interp(" + this.f13949i + ") ";
        }
        if (this.f13950j.size() <= 0 && this.f13951k.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.f13950j.size() > 0) {
            for (int i10 = 0; i10 < this.f13950j.size(); i10++) {
                if (i10 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f13950j.get(i10);
            }
        }
        if (this.f13951k.size() > 0) {
            for (int i11 = 0; i11 < this.f13951k.size(); i11++) {
                if (i11 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.f13951k.get(i11);
            }
        }
        return str3 + ")";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(s sVar) {
    }

    public abstract void m(s sVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(ViewGroup viewGroup, boolean z10) {
        ArrayList<String> arrayList;
        ArrayList<Class> arrayList2;
        l.a<String, String> aVar;
        o(z10);
        if ((this.f13950j.size() > 0 || this.f13951k.size() > 0) && (((arrayList = this.f13952l) == null || arrayList.isEmpty()) && ((arrayList2 = this.f13953m) == null || arrayList2.isEmpty()))) {
            for (int i10 = 0; i10 < this.f13950j.size(); i10++) {
                View findViewById = viewGroup.findViewById(this.f13950j.get(i10).intValue());
                if (findViewById != null) {
                    s sVar = new s();
                    sVar.f13988b = findViewById;
                    if (z10) {
                        m(sVar);
                    } else {
                        i(sVar);
                    }
                    sVar.f13989c.add(this);
                    l(sVar);
                    e(z10 ? this.f13961u : this.f13962v, findViewById, sVar);
                }
            }
            for (int i11 = 0; i11 < this.f13951k.size(); i11++) {
                View view = this.f13951k.get(i11);
                s sVar2 = new s();
                sVar2.f13988b = view;
                if (z10) {
                    m(sVar2);
                } else {
                    i(sVar2);
                }
                sVar2.f13989c.add(this);
                l(sVar2);
                e(z10 ? this.f13961u : this.f13962v, view, sVar2);
            }
        } else {
            k(viewGroup, z10);
        }
        if (z10 || (aVar = this.J) == null) {
            return;
        }
        int size = aVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            arrayList3.add(this.f13961u.f13993d.remove(this.J.i(i12)));
        }
        for (int i13 = 0; i13 < size; i13++) {
            View view2 = (View) arrayList3.get(i13);
            if (view2 != null) {
                this.f13961u.f13993d.put(this.J.n(i13), view2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(boolean z10) {
        t tVar;
        if (z10) {
            this.f13961u.f13990a.clear();
            this.f13961u.f13991b.clear();
            tVar = this.f13961u;
        } else {
            this.f13962v.f13990a.clear();
            this.f13962v.f13991b.clear();
            tVar = this.f13962v;
        }
        tVar.f13992c.b();
    }

    @Override // 
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public m clone() {
        try {
            m mVar = (m) super.clone();
            mVar.G = new ArrayList<>();
            mVar.f13961u = new t();
            mVar.f13962v = new t();
            mVar.f13965y = null;
            mVar.f13966z = null;
            return mVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator q(ViewGroup viewGroup, s sVar, s sVar2) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        int i10;
        View view;
        Animator animator;
        s sVar;
        Animator animator2;
        s sVar2;
        l.a<Animator, d> B = B();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            s sVar3 = arrayList.get(i11);
            s sVar4 = arrayList2.get(i11);
            if (sVar3 != null && !sVar3.f13989c.contains(this)) {
                sVar3 = null;
            }
            if (sVar4 != null && !sVar4.f13989c.contains(this)) {
                sVar4 = null;
            }
            if (sVar3 != null || sVar4 != null) {
                if (sVar3 == null || sVar4 == null || L(sVar3, sVar4)) {
                    Animator q10 = q(viewGroup, sVar3, sVar4);
                    if (q10 != null) {
                        if (sVar4 != null) {
                            View view2 = sVar4.f13988b;
                            String[] J = J();
                            if (view2 == null || J == null || J.length <= 0) {
                                i10 = size;
                                animator2 = q10;
                                sVar2 = null;
                            } else {
                                sVar2 = new s();
                                sVar2.f13988b = view2;
                                s sVar5 = tVar2.f13990a.get(view2);
                                if (sVar5 != null) {
                                    int i12 = 0;
                                    while (i12 < J.length) {
                                        sVar2.f13987a.put(J[i12], sVar5.f13987a.get(J[i12]));
                                        i12++;
                                        q10 = q10;
                                        size = size;
                                        sVar5 = sVar5;
                                    }
                                }
                                Animator animator3 = q10;
                                i10 = size;
                                int size2 = B.size();
                                int i13 = 0;
                                while (true) {
                                    if (i13 >= size2) {
                                        animator2 = animator3;
                                        break;
                                    }
                                    d dVar = B.get(B.i(i13));
                                    if (dVar.f13972c != null && dVar.f13970a == view2 && dVar.f13971b.equals(y()) && dVar.f13972c.equals(sVar2)) {
                                        animator2 = null;
                                        break;
                                    }
                                    i13++;
                                }
                            }
                            view = view2;
                            animator = animator2;
                            sVar = sVar2;
                        } else {
                            i10 = size;
                            view = sVar3.f13988b;
                            animator = q10;
                            sVar = null;
                        }
                        if (animator != null) {
                            B.put(animator, new d(view, y(), this, d0.e(viewGroup), sVar));
                            this.G.add(animator);
                        }
                        i11++;
                        size = i10;
                    }
                    i10 = size;
                    i11++;
                    size = i10;
                }
            }
            i10 = size;
            i11++;
            size = i10;
        }
        if (Long.MAX_VALUE != 0) {
            for (int i14 = 0; i14 < sparseIntArray.size(); i14++) {
                Animator animator4 = this.G.get(sparseIntArray.keyAt(i14));
                animator4.setStartDelay((sparseIntArray.valueAt(i14) - Long.MAX_VALUE) + animator4.getStartDelay());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        int i10 = this.C - 1;
        this.C = i10;
        if (i10 == 0) {
            ArrayList<f> arrayList = this.F;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.F.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((f) arrayList2.get(i11)).b(this);
                }
            }
            for (int i12 = 0; i12 < this.f13961u.f13992c.p(); i12++) {
                View q10 = this.f13961u.f13992c.q(i12);
                if (q10 != null) {
                    androidx.core.view.a0.t0(q10, false);
                }
            }
            for (int i13 = 0; i13 < this.f13962v.f13992c.p(); i13++) {
                View q11 = this.f13962v.f13992c.q(i13);
                if (q11 != null) {
                    androidx.core.view.a0.t0(q11, false);
                }
            }
            this.E = true;
        }
    }

    public long t() {
        return this.f13948h;
    }

    public String toString() {
        return j0("");
    }

    public e u() {
        return this.I;
    }

    public TimeInterpolator w() {
        return this.f13949i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s x(View view, boolean z10) {
        q qVar = this.f13963w;
        if (qVar != null) {
            return qVar.x(view, z10);
        }
        ArrayList<s> arrayList = z10 ? this.f13965y : this.f13966z;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i10 = -1;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            s sVar = arrayList.get(i11);
            if (sVar == null) {
                return null;
            }
            if (sVar.f13988b == view) {
                i10 = i11;
                break;
            }
            i11++;
        }
        if (i10 >= 0) {
            return (z10 ? this.f13966z : this.f13965y).get(i10);
        }
        return null;
    }

    public String y() {
        return this.f13946f;
    }

    public g z() {
        return this.K;
    }
}
