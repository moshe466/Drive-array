package s0;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static m f13975a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static ThreadLocal<WeakReference<l.a<ViewGroup, ArrayList<m>>>> f13976b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    static ArrayList<ViewGroup> f13977c = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: f, reason: collision with root package name */
        m f13978f;

        /* renamed from: g, reason: collision with root package name */
        ViewGroup f13979g;

        /* renamed from: s0.o$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0287a extends n {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ l.a f13980a;

            C0287a(l.a aVar) {
                this.f13980a = aVar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // s0.m.f
            public void b(m mVar) {
                ((ArrayList) this.f13980a.get(a.this.f13979g)).remove(mVar);
            }
        }

        a(m mVar, ViewGroup viewGroup) {
            this.f13978f = mVar;
            this.f13979g = viewGroup;
        }

        private void a() {
            this.f13979g.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f13979g.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!o.f13977c.remove(this.f13979g)) {
                return true;
            }
            l.a<ViewGroup, ArrayList<m>> b10 = o.b();
            ArrayList<m> arrayList = b10.get(this.f13979g);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                b10.put(this.f13979g, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f13978f);
            this.f13978f.a(new C0287a(b10));
            this.f13978f.n(this.f13979g, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((m) it.next()).Z(this.f13979g);
                }
            }
            this.f13978f.W(this.f13979g);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            o.f13977c.remove(this.f13979g);
            ArrayList<m> arrayList = o.b().get(this.f13979g);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<m> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().Z(this.f13979g);
                }
            }
            this.f13978f.o(true);
        }
    }

    public static void a(ViewGroup viewGroup, m mVar) {
        if (f13977c.contains(viewGroup) || !androidx.core.view.a0.S(viewGroup)) {
            return;
        }
        f13977c.add(viewGroup);
        if (mVar == null) {
            mVar = f13975a;
        }
        m clone = mVar.clone();
        d(viewGroup, clone);
        l.c(viewGroup, null);
        c(viewGroup, clone);
    }

    static l.a<ViewGroup, ArrayList<m>> b() {
        l.a<ViewGroup, ArrayList<m>> aVar;
        WeakReference<l.a<ViewGroup, ArrayList<m>>> weakReference = f13976b.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        l.a<ViewGroup, ArrayList<m>> aVar2 = new l.a<>();
        f13976b.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    private static void c(ViewGroup viewGroup, m mVar) {
        if (mVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(mVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    private static void d(ViewGroup viewGroup, m mVar) {
        ArrayList<m> arrayList = b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<m> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().V(viewGroup);
            }
        }
        if (mVar != null) {
            mVar.n(viewGroup, true);
        }
        l b10 = l.b(viewGroup);
        if (b10 != null) {
            b10.a();
        }
    }
}
