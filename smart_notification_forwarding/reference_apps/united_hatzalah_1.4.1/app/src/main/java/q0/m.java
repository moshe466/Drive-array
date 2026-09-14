package q0;

import F0.C0035g2;
import J.S;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.z0;
import com.uh.sf.R;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class m extends z0 {
    @Override // androidx.fragment.app.z0
    public final void a(View view, Object obj) {
        ((q) obj).b(view);
    }

    @Override // androidx.fragment.app.z0
    public final void b(Object obj, ArrayList arrayList) {
        q qVar;
        q qVar2 = (q) obj;
        if (qVar2 != null) {
            int i = 0;
            if (qVar2 instanceof v) {
                v vVar = (v) qVar2;
                int size = vVar.y.size();
                while (i < size) {
                    if (i >= 0 && i < vVar.y.size()) {
                        qVar = (q) vVar.y.get(i);
                    } else {
                        qVar = null;
                    }
                    b(qVar, arrayList);
                    i++;
                }
                return;
            }
            if (z0.h(qVar2.f6107c) && z0.h(qVar2.f6108d)) {
                int size2 = arrayList.size();
                while (i < size2) {
                    qVar2.b((View) arrayList.get(i));
                    i++;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [q0.t, android.view.ViewTreeObserver$OnPreDrawListener, java.lang.Object, android.view.View$OnAttachStateChangeListener] */
    @Override // androidx.fragment.app.z0
    public final void c(ViewGroup viewGroup, Object obj) {
        q qVar = (q) obj;
        ArrayList arrayList = u.f6128c;
        if (!arrayList.contains(viewGroup)) {
            WeakHashMap weakHashMap = S.f954a;
            if (viewGroup.isLaidOut()) {
                arrayList.add(viewGroup);
                if (qVar == null) {
                    qVar = u.f6126a;
                }
                q clone = qVar.clone();
                ArrayList arrayList2 = (ArrayList) u.a().get(viewGroup);
                if (arrayList2 != null && arrayList2.size() > 0) {
                    int size = arrayList2.size();
                    int i = 0;
                    while (i < size) {
                        Object obj2 = arrayList2.get(i);
                        i++;
                        ((q) obj2).v(viewGroup);
                    }
                }
                if (clone != null) {
                    clone.i(viewGroup, true);
                }
                if (viewGroup.getTag(R.id.transition_current_scene) == null) {
                    viewGroup.setTag(R.id.transition_current_scene, null);
                    if (clone != null) {
                        ?? obj3 = new Object();
                        obj3.f6124a = clone;
                        obj3.f6125b = viewGroup;
                        viewGroup.addOnAttachStateChangeListener(obj3);
                        viewGroup.getViewTreeObserver().addOnPreDrawListener(obj3);
                        return;
                    }
                    return;
                }
                throw new ClassCastException();
            }
        }
    }

    @Override // androidx.fragment.app.z0
    public final boolean e(Object obj) {
        return obj instanceof q;
    }

    @Override // androidx.fragment.app.z0
    public final Object f(Object obj) {
        if (obj != null) {
            return ((q) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.z0
    public final Object j(Object obj, Object obj2, Object obj3) {
        q qVar = (q) obj;
        q qVar2 = (q) obj2;
        q qVar3 = (q) obj3;
        if (qVar != null && qVar2 != null) {
            v vVar = new v();
            vVar.H(qVar);
            vVar.H(qVar2);
            vVar.f6132z = false;
            qVar = vVar;
        } else if (qVar == null) {
            if (qVar2 != null) {
                qVar = qVar2;
            } else {
                qVar = null;
            }
        }
        if (qVar3 != null) {
            v vVar2 = new v();
            if (qVar != null) {
                vVar2.H(qVar);
            }
            vVar2.H(qVar3);
            return vVar2;
        }
        return qVar;
    }

    @Override // androidx.fragment.app.z0
    public final Object k(Object obj, Object obj2) {
        v vVar = new v();
        if (obj != null) {
            vVar.H((q) obj);
        }
        vVar.H((q) obj2);
        return vVar;
    }

    @Override // androidx.fragment.app.z0
    public final void l(Object obj, View view, ArrayList arrayList) {
        ((q) obj).a(new j(view, arrayList));
    }

    @Override // androidx.fragment.app.z0
    public final void m(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2) {
        ((q) obj).a(new k(this, obj2, arrayList, obj3, arrayList2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T.b, java.lang.Object] */
    @Override // androidx.fragment.app.z0
    public final void n(View view, Object obj) {
        if (view != null) {
            z0.g(view, new Rect());
            ((q) obj).A(new Object());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T.b, java.lang.Object] */
    @Override // androidx.fragment.app.z0
    public final void o(Object obj, Rect rect) {
        ((q) obj).A(new Object());
    }

    @Override // androidx.fragment.app.z0
    public final void p(Object obj, F.c cVar, Runnable runnable) {
        q qVar = (q) obj;
        C0035g2 c0035g2 = new C0035g2(qVar, 20);
        synchronized (cVar) {
            while (cVar.f155b) {
                try {
                    try {
                        cVar.wait();
                    } catch (InterruptedException unused) {
                    }
                } finally {
                }
            }
            if (((C0035g2) cVar.f156c) != c0035g2) {
                cVar.f156c = c0035g2;
                if (cVar.f154a) {
                    ((q) c0035g2.f526b).d();
                }
            }
        }
        qVar.a(new l(runnable));
    }

    @Override // androidx.fragment.app.z0
    public final void q(Object obj, View view, ArrayList arrayList) {
        v vVar = (v) obj;
        ArrayList arrayList2 = vVar.f6108d;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            z0.d(arrayList2, (View) arrayList.get(i));
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(vVar, arrayList);
    }

    @Override // androidx.fragment.app.z0
    public final void r(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        v vVar = (v) obj;
        if (vVar != null) {
            ArrayList arrayList3 = vVar.f6108d;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            t(vVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.z0
    public final Object s(Object obj) {
        if (obj == null) {
            return null;
        }
        v vVar = new v();
        vVar.H((q) obj);
        return vVar;
    }

    public final void t(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        int size;
        q qVar;
        q qVar2 = (q) obj;
        int i = 0;
        if (qVar2 instanceof v) {
            v vVar = (v) qVar2;
            int size2 = vVar.y.size();
            while (i < size2) {
                if (i >= 0 && i < vVar.y.size()) {
                    qVar = (q) vVar.y.get(i);
                } else {
                    qVar = null;
                }
                t(qVar, arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (z0.h(qVar2.f6107c)) {
            ArrayList arrayList3 = qVar2.f6108d;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    size = 0;
                } else {
                    size = arrayList2.size();
                }
                while (i < size) {
                    qVar2.b((View) arrayList2.get(i));
                    i++;
                }
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    qVar2.x((View) arrayList.get(size3));
                }
            }
        }
    }
}
