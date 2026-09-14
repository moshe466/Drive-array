package s0;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import s0.m;

/* loaded from: classes.dex */
public class e extends androidx.fragment.app.i0 {

    /* loaded from: classes.dex */
    class a extends m.e {
        a(e eVar, Rect rect) {
        }
    }

    /* loaded from: classes.dex */
    class b implements m.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f13899a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f13900b;

        b(e eVar, View view, ArrayList arrayList) {
            this.f13899a = view;
            this.f13900b = arrayList;
        }

        @Override // s0.m.f
        public void a(m mVar) {
        }

        @Override // s0.m.f
        public void b(m mVar) {
            mVar.X(this);
            this.f13899a.setVisibility(8);
            int size = this.f13900b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f13900b.get(i10)).setVisibility(0);
            }
        }

        @Override // s0.m.f
        public void c(m mVar) {
        }

        @Override // s0.m.f
        public void d(m mVar) {
        }
    }

    /* loaded from: classes.dex */
    class c implements m.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f13901a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList f13902b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Object f13903c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f13904d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f13905e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ArrayList f13906f;

        c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f13901a = obj;
            this.f13902b = arrayList;
            this.f13903c = obj2;
            this.f13904d = arrayList2;
            this.f13905e = obj3;
            this.f13906f = arrayList3;
        }

        @Override // s0.m.f
        public void a(m mVar) {
        }

        @Override // s0.m.f
        public void b(m mVar) {
        }

        @Override // s0.m.f
        public void c(m mVar) {
            Object obj = this.f13901a;
            if (obj != null) {
                e.this.w(obj, this.f13902b, null);
            }
            Object obj2 = this.f13903c;
            if (obj2 != null) {
                e.this.w(obj2, this.f13904d, null);
            }
            Object obj3 = this.f13905e;
            if (obj3 != null) {
                e.this.w(obj3, this.f13906f, null);
            }
        }

        @Override // s0.m.f
        public void d(m mVar) {
        }
    }

    /* loaded from: classes.dex */
    class d extends m.e {
        d(e eVar, Rect rect) {
        }
    }

    private static boolean v(m mVar) {
        return (androidx.fragment.app.i0.i(mVar.E()) && androidx.fragment.app.i0.i(mVar.F()) && androidx.fragment.app.i0.i(mVar.G())) ? false : true;
    }

    @Override // androidx.fragment.app.i0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((m) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.i0
    public void b(Object obj, ArrayList<View> arrayList) {
        m mVar = (m) obj;
        if (mVar == null) {
            return;
        }
        int i10 = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int o02 = qVar.o0();
            while (i10 < o02) {
                b(qVar.n0(i10), arrayList);
                i10++;
            }
            return;
        }
        if (v(mVar) || !androidx.fragment.app.i0.i(mVar.I())) {
            return;
        }
        int size = arrayList.size();
        while (i10 < size) {
            mVar.b(arrayList.get(i10));
            i10++;
        }
    }

    @Override // androidx.fragment.app.i0
    public void c(ViewGroup viewGroup, Object obj) {
        o.a(viewGroup, (m) obj);
    }

    @Override // androidx.fragment.app.i0
    public boolean e(Object obj) {
        return obj instanceof m;
    }

    @Override // androidx.fragment.app.i0
    public Object f(Object obj) {
        if (obj != null) {
            return ((m) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.i0
    public Object j(Object obj, Object obj2, Object obj3) {
        m mVar = (m) obj;
        m mVar2 = (m) obj2;
        m mVar3 = (m) obj3;
        if (mVar != null && mVar2 != null) {
            mVar = new q().m0(mVar).m0(mVar2).t0(1);
        } else if (mVar == null) {
            mVar = mVar2 != null ? mVar2 : null;
        }
        if (mVar3 == null) {
            return mVar;
        }
        q qVar = new q();
        if (mVar != null) {
            qVar.m0(mVar);
        }
        qVar.m0(mVar3);
        return qVar;
    }

    @Override // androidx.fragment.app.i0
    public Object k(Object obj, Object obj2, Object obj3) {
        q qVar = new q();
        if (obj != null) {
            qVar.m0((m) obj);
        }
        if (obj2 != null) {
            qVar.m0((m) obj2);
        }
        if (obj3 != null) {
            qVar.m0((m) obj3);
        }
        return qVar;
    }

    @Override // androidx.fragment.app.i0
    public void m(Object obj, View view, ArrayList<View> arrayList) {
        ((m) obj).a(new b(this, view, arrayList));
    }

    @Override // androidx.fragment.app.i0
    public void n(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((m) obj).a(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.i0
    public void o(Object obj, Rect rect) {
        if (obj != null) {
            ((m) obj).d0(new d(this, rect));
        }
    }

    @Override // androidx.fragment.app.i0
    public void p(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            h(view, rect);
            ((m) obj).d0(new a(this, rect));
        }
    }

    @Override // androidx.fragment.app.i0
    public void s(Object obj, View view, ArrayList<View> arrayList) {
        q qVar = (q) obj;
        List<View> I = qVar.I();
        I.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            androidx.fragment.app.i0.d(I, arrayList.get(i10));
        }
        I.add(view);
        arrayList.add(view);
        b(qVar, arrayList);
    }

    @Override // androidx.fragment.app.i0
    public void t(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        q qVar = (q) obj;
        if (qVar != null) {
            qVar.I().clear();
            qVar.I().addAll(arrayList2);
            w(qVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.i0
    public Object u(Object obj) {
        if (obj == null) {
            return null;
        }
        q qVar = new q();
        qVar.m0((m) obj);
        return qVar;
    }

    public void w(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        m mVar = (m) obj;
        int i10 = 0;
        if (mVar instanceof q) {
            q qVar = (q) mVar;
            int o02 = qVar.o0();
            while (i10 < o02) {
                w(qVar.n0(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (v(mVar)) {
            return;
        }
        List<View> I = mVar.I();
        if (I.size() == arrayList.size() && I.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i10 < size) {
                mVar.b(arrayList2.get(i10));
                i10++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                mVar.Y(arrayList.get(size2));
            }
        }
    }
}
