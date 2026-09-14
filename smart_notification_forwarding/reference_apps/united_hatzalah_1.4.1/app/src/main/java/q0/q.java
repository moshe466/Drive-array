package q0;

import F0.AbstractC0008a;
import J.J;
import J.S;
import J.W;
import android.animation.Animator;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import q.C0602B;
import t.AbstractC0692h;
import t.C0689e;
import t.C0691g;
import t.C0694j;
import u.AbstractC0717a;

/* loaded from: classes.dex */
public abstract class q implements Cloneable {

    /* renamed from: v, reason: collision with root package name */
    public static final int[] f6102v = {2, 1, 3, 4};

    /* renamed from: w, reason: collision with root package name */
    public static final C0602B f6103w = new Object();

    /* renamed from: x, reason: collision with root package name */
    public static final ThreadLocal f6104x = new ThreadLocal();

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f6113l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f6114m;

    /* renamed from: t, reason: collision with root package name */
    public T.b f6120t;

    /* renamed from: a, reason: collision with root package name */
    public final String f6105a = getClass().getName();

    /* renamed from: b, reason: collision with root package name */
    public long f6106b = -1;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f6107c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f6108d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public K1.m f6109e = new K1.m(11);

    /* renamed from: f, reason: collision with root package name */
    public K1.m f6110f = new K1.m(11);

    /* renamed from: j, reason: collision with root package name */
    public v f6111j = null;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f6112k = f6102v;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f6115n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public int f6116o = 0;
    public boolean p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6117q = false;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f6118r = null;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList f6119s = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    public C0602B f6121u = f6103w;

    public static void c(K1.m mVar, View view, x xVar) {
        C0689e c0689e = (C0689e) mVar.f1102a;
        C0689e c0689e2 = (C0689e) mVar.f1105d;
        SparseArray sparseArray = (SparseArray) mVar.f1103b;
        C0691g c0691g = (C0691g) mVar.f1104c;
        c0689e.put(view, xVar);
        int id = view.getId();
        if (id >= 0) {
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = S.f954a;
        String e4 = J.e(view);
        if (e4 != null) {
            if (c0689e2.containsKey(e4)) {
                c0689e2.put(e4, null);
            } else {
                c0689e2.put(e4, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (c0691g.f6358a) {
                    int i = c0691g.f6361d;
                    long[] jArr = c0691g.f6359b;
                    Object[] objArr = c0691g.f6360c;
                    int i3 = 0;
                    for (int i4 = 0; i4 < i; i4++) {
                        Object obj = objArr[i4];
                        if (obj != AbstractC0692h.f6362a) {
                            if (i4 != i3) {
                                jArr[i3] = jArr[i4];
                                objArr[i3] = obj;
                                objArr[i4] = null;
                            }
                            i3++;
                        }
                    }
                    c0691g.f6358a = false;
                    c0691g.f6361d = i3;
                }
                if (AbstractC0717a.b(c0691g.f6359b, c0691g.f6361d, itemIdAtPosition) >= 0) {
                    View view2 = (View) c0691g.b(itemIdAtPosition);
                    if (view2 != null) {
                        view2.setHasTransientState(false);
                        c0691g.d(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                view.setHasTransientState(true);
                c0691g.d(itemIdAtPosition, view);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [t.j, java.lang.Object, t.e] */
    public static C0689e p() {
        ThreadLocal threadLocal = f6104x;
        C0689e c0689e = (C0689e) threadLocal.get();
        if (c0689e == null) {
            ?? c0694j = new C0694j(0);
            threadLocal.set(c0694j);
            return c0694j;
        }
        return c0689e;
    }

    public static boolean u(x xVar, x xVar2, String str) {
        Object obj = xVar.f6136a.get(str);
        Object obj2 = xVar2.f6136a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public void A(T.b bVar) {
        this.f6120t = bVar;
    }

    public void C(C0602B c0602b) {
        if (c0602b == null) {
            this.f6121u = f6103w;
        } else {
            this.f6121u = c0602b;
        }
    }

    public void E(long j2) {
        this.f6106b = j2;
    }

    public final void F() {
        if (this.f6116o == 0) {
            ArrayList arrayList = this.f6118r;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f6118r.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((p) arrayList2.get(i)).a(this);
                }
            }
            this.f6117q = false;
        }
        this.f6116o++;
    }

    public String G(String str) {
        StringBuilder h2 = e0.a.h(str);
        h2.append(getClass().getSimpleName());
        h2.append("@");
        h2.append(Integer.toHexString(hashCode()));
        h2.append(": ");
        String sb = h2.toString();
        if (this.f6106b != -1) {
            sb = e0.a.g(e0.a.i(sb, "dly("), this.f6106b, ") ");
        }
        ArrayList arrayList = this.f6107c;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f6108d;
        if (size <= 0 && arrayList2.size() <= 0) {
            return sb;
        }
        String n4 = AbstractC0008a.n(sb, "tgts(");
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                if (i > 0) {
                    n4 = AbstractC0008a.n(n4, ", ");
                }
                StringBuilder h3 = e0.a.h(n4);
                h3.append(arrayList.get(i));
                n4 = h3.toString();
            }
        }
        if (arrayList2.size() > 0) {
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (i3 > 0) {
                    n4 = AbstractC0008a.n(n4, ", ");
                }
                StringBuilder h4 = e0.a.h(n4);
                h4.append(arrayList2.get(i3));
                n4 = h4.toString();
            }
        }
        return AbstractC0008a.n(n4, ")");
    }

    public void a(p pVar) {
        if (this.f6118r == null) {
            this.f6118r = new ArrayList();
        }
        this.f6118r.add(pVar);
    }

    public void b(View view) {
        this.f6108d.add(view);
    }

    public void d() {
        ArrayList arrayList = this.f6115n;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((Animator) arrayList.get(size)).cancel();
        }
        ArrayList arrayList2 = this.f6118r;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList arrayList3 = (ArrayList) this.f6118r.clone();
            int size2 = arrayList3.size();
            for (int i = 0; i < size2; i++) {
                ((p) arrayList3.get(i)).c();
            }
        }
    }

    public abstract void e(x xVar);

    public final void f(View view, boolean z3) {
        if (view != null) {
            view.getId();
            if (view.getParent() instanceof ViewGroup) {
                x xVar = new x(view);
                if (z3) {
                    h(xVar);
                } else {
                    e(xVar);
                }
                xVar.f6138c.add(this);
                g(xVar);
                if (z3) {
                    c(this.f6109e, view, xVar);
                } else {
                    c(this.f6110f, view, xVar);
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    f(viewGroup.getChildAt(i), z3);
                }
            }
        }
    }

    public abstract void h(x xVar);

    public final void i(ViewGroup viewGroup, boolean z3) {
        j(z3);
        ArrayList arrayList = this.f6107c;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f6108d;
        if (size <= 0 && arrayList2.size() <= 0) {
            f(viewGroup, z3);
            return;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            View findViewById = viewGroup.findViewById(((Integer) arrayList.get(i)).intValue());
            if (findViewById != null) {
                x xVar = new x(findViewById);
                if (z3) {
                    h(xVar);
                } else {
                    e(xVar);
                }
                xVar.f6138c.add(this);
                g(xVar);
                if (z3) {
                    c(this.f6109e, findViewById, xVar);
                } else {
                    c(this.f6110f, findViewById, xVar);
                }
            }
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            View view = (View) arrayList2.get(i3);
            x xVar2 = new x(view);
            if (z3) {
                h(xVar2);
            } else {
                e(xVar2);
            }
            xVar2.f6138c.add(this);
            g(xVar2);
            if (z3) {
                c(this.f6109e, view, xVar2);
            } else {
                c(this.f6110f, view, xVar2);
            }
        }
    }

    public final void j(boolean z3) {
        if (z3) {
            ((C0689e) this.f6109e.f1102a).clear();
            ((SparseArray) this.f6109e.f1103b).clear();
            ((C0691g) this.f6109e.f1104c).a();
        } else {
            ((C0689e) this.f6110f.f1102a).clear();
            ((SparseArray) this.f6110f.f1103b).clear();
            ((C0691g) this.f6110f.f1104c).a();
        }
    }

    @Override // 
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public q clone() {
        try {
            q qVar = (q) super.clone();
            qVar.f6119s = new ArrayList();
            qVar.f6109e = new K1.m(11);
            qVar.f6110f = new K1.m(11);
            qVar.f6113l = null;
            qVar.f6114m = null;
            return qVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Animator l(ViewGroup viewGroup, x xVar, x xVar2) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [q0.o, java.lang.Object] */
    public void m(ViewGroup viewGroup, K1.m mVar, K1.m mVar2, ArrayList arrayList, ArrayList arrayList2) {
        Animator l3;
        int i;
        int i3;
        View view;
        x xVar;
        Animator animator;
        x xVar2;
        C0689e p = p();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            x xVar3 = (x) arrayList.get(i4);
            x xVar4 = (x) arrayList2.get(i4);
            if (xVar3 != null && !xVar3.f6138c.contains(this)) {
                xVar3 = null;
            }
            if (xVar4 != null && !xVar4.f6138c.contains(this)) {
                xVar4 = null;
            }
            if ((xVar3 == null && xVar4 == null) || ((xVar3 != null && xVar4 != null && !s(xVar3, xVar4)) || (l3 = l(viewGroup, xVar3, xVar4)) == null)) {
                i = size;
                i3 = i4;
            } else {
                String str = this.f6105a;
                if (xVar4 != null) {
                    view = xVar4.f6137b;
                    String[] q3 = q();
                    if (q3 != null && q3.length > 0) {
                        xVar2 = new x(view);
                        x xVar5 = (x) ((C0689e) mVar2.f1102a).get(view);
                        i = size;
                        if (xVar5 != null) {
                            int i5 = 0;
                            while (i5 < q3.length) {
                                String str2 = q3[i5];
                                xVar2.f6136a.put(str2, xVar5.f6136a.get(str2));
                                i5++;
                                i4 = i4;
                                xVar5 = xVar5;
                            }
                        }
                        i3 = i4;
                        int i6 = p.f6366c;
                        int i7 = 0;
                        while (true) {
                            if (i7 < i6) {
                                o oVar = (o) p.get((Animator) p.f(i7));
                                if (oVar.f6099c != null && oVar.f6097a == view && oVar.f6098b.equals(str) && oVar.f6099c.equals(xVar2)) {
                                    animator = null;
                                    break;
                                }
                                i7++;
                            } else {
                                animator = l3;
                                break;
                            }
                        }
                    } else {
                        i = size;
                        i3 = i4;
                        animator = l3;
                        xVar2 = null;
                    }
                    l3 = animator;
                    xVar = xVar2;
                } else {
                    i = size;
                    i3 = i4;
                    view = xVar3.f6137b;
                    xVar = null;
                }
                if (l3 != null) {
                    z zVar = y.f6139a;
                    E e4 = new E(viewGroup);
                    ?? obj = new Object();
                    obj.f6097a = view;
                    obj.f6098b = str;
                    obj.f6099c = xVar;
                    obj.f6100d = e4;
                    obj.f6101e = this;
                    p.put(l3, obj);
                    this.f6119s.add(l3);
                }
            }
            i4 = i3 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                Animator animator2 = (Animator) this.f6119s.get(sparseIntArray.keyAt(i8));
                animator2.setStartDelay(animator2.getStartDelay() + (sparseIntArray.valueAt(i8) - Long.MAX_VALUE));
            }
        }
    }

    public final void n() {
        int i = this.f6116o - 1;
        this.f6116o = i;
        if (i == 0) {
            ArrayList arrayList = this.f6118r;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.f6118r.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((p) arrayList2.get(i3)).e(this);
                }
            }
            for (int i4 = 0; i4 < ((C0691g) this.f6109e.f1104c).e(); i4++) {
                View view = (View) ((C0691g) this.f6109e.f1104c).f(i4);
                if (view != null) {
                    WeakHashMap weakHashMap = S.f954a;
                    view.setHasTransientState(false);
                }
            }
            for (int i5 = 0; i5 < ((C0691g) this.f6110f.f1104c).e(); i5++) {
                View view2 = (View) ((C0691g) this.f6110f.f1104c).f(i5);
                if (view2 != null) {
                    WeakHashMap weakHashMap2 = S.f954a;
                    view2.setHasTransientState(false);
                }
            }
            this.f6117q = true;
        }
    }

    public final x o(View view, boolean z3) {
        ArrayList arrayList;
        ArrayList arrayList2;
        v vVar = this.f6111j;
        if (vVar != null) {
            return vVar.o(view, z3);
        }
        if (z3) {
            arrayList = this.f6113l;
        } else {
            arrayList = this.f6114m;
        }
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    x xVar = (x) arrayList.get(i);
                    if (xVar != null) {
                        if (xVar.f6137b == view) {
                            break;
                        }
                        i++;
                    } else {
                        return null;
                    }
                } else {
                    i = -1;
                    break;
                }
            }
            if (i >= 0) {
                if (z3) {
                    arrayList2 = this.f6114m;
                } else {
                    arrayList2 = this.f6113l;
                }
                return (x) arrayList2.get(i);
            }
            return null;
        }
        return null;
    }

    public String[] q() {
        return null;
    }

    public final x r(View view, boolean z3) {
        K1.m mVar;
        v vVar = this.f6111j;
        if (vVar != null) {
            return vVar.r(view, z3);
        }
        if (z3) {
            mVar = this.f6109e;
        } else {
            mVar = this.f6110f;
        }
        return (x) ((C0689e) mVar.f1102a).get(view);
    }

    public boolean s(x xVar, x xVar2) {
        if (xVar != null && xVar2 != null) {
            String[] q3 = q();
            if (q3 != null) {
                for (String str : q3) {
                    if (u(xVar, xVar2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = xVar.f6136a.keySet().iterator();
                while (it.hasNext()) {
                    if (u(xVar, xVar2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean t(View view) {
        int id = view.getId();
        ArrayList arrayList = this.f6107c;
        int size = arrayList.size();
        ArrayList arrayList2 = this.f6108d;
        if ((size == 0 && arrayList2.size() == 0) || arrayList.contains(Integer.valueOf(id)) || arrayList2.contains(view)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return G("");
    }

    public void v(View view) {
        if (!this.f6117q) {
            ArrayList arrayList = this.f6115n;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((Animator) arrayList.get(size)).pause();
            }
            ArrayList arrayList2 = this.f6118r;
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList arrayList3 = (ArrayList) this.f6118r.clone();
                int size2 = arrayList3.size();
                for (int i = 0; i < size2; i++) {
                    ((p) arrayList3.get(i)).b();
                }
            }
            this.p = true;
        }
    }

    public void w(p pVar) {
        ArrayList arrayList = this.f6118r;
        if (arrayList != null) {
            arrayList.remove(pVar);
            if (this.f6118r.size() == 0) {
                this.f6118r = null;
            }
        }
    }

    public void x(View view) {
        this.f6108d.remove(view);
    }

    public void y(View view) {
        if (this.p) {
            if (!this.f6117q) {
                ArrayList arrayList = this.f6115n;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((Animator) arrayList.get(size)).resume();
                }
                ArrayList arrayList2 = this.f6118r;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    ArrayList arrayList3 = (ArrayList) this.f6118r.clone();
                    int size2 = arrayList3.size();
                    for (int i = 0; i < size2; i++) {
                        ((p) arrayList3.get(i)).d();
                    }
                }
            }
            this.p = false;
        }
    }

    public void z() {
        F();
        C0689e p = p();
        ArrayList arrayList = this.f6119s;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            Animator animator = (Animator) obj;
            if (p.containsKey(animator)) {
                F();
                if (animator != null) {
                    animator.addListener(new n(this, p));
                    long j2 = this.f6106b;
                    if (j2 >= 0) {
                        animator.setStartDelay(animator.getStartDelay() + j2);
                    }
                    animator.addListener(new W(this, 2));
                    animator.start();
                }
            }
        }
        this.f6119s.clear();
        n();
    }

    public void B() {
    }

    public void D() {
    }

    public void g(x xVar) {
    }
}
