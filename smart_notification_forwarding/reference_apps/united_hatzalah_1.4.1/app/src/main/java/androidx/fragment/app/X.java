package androidx.fragment.app;

import c.C0325a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import t2.AbstractC0707i;
import t2.AbstractC0714p;

/* loaded from: classes.dex */
public final class X extends c.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0272g0 f3331a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public X(AbstractC0272g0 abstractC0272g0) {
        super(false);
        this.f3331a = abstractC0272g0;
    }

    @Override // c.p
    public final void handleOnBackCancelled() {
        boolean J3 = AbstractC0272g0.J(3);
        AbstractC0272g0 abstractC0272g0 = this.f3331a;
        if (J3) {
            Objects.toString(abstractC0272g0);
        }
        if (AbstractC0272g0.J(3)) {
            Objects.toString(abstractC0272g0.f3396h);
        }
        C0259a c0259a = abstractC0272g0.f3396h;
        if (c0259a != null) {
            c0259a.f3336r = false;
            c0259a.e();
            C0259a c0259a2 = abstractC0272g0.f3396h;
            RunnableC0286v runnableC0286v = new RunnableC0286v(abstractC0272g0, 2);
            if (c0259a2.p == null) {
                c0259a2.p = new ArrayList();
            }
            c0259a2.p.add(runnableC0286v);
            abstractC0272g0.f3396h.f(false, true);
            abstractC0272g0.i = true;
            abstractC0272g0.z(true);
            abstractC0272g0.E();
            abstractC0272g0.i = false;
            abstractC0272g0.f3396h = null;
        }
    }

    @Override // c.p
    public final void handleOnBackPressed() {
        boolean J3 = AbstractC0272g0.J(3);
        AbstractC0272g0 abstractC0272g0 = this.f3331a;
        if (J3) {
            Objects.toString(abstractC0272g0);
        }
        X x3 = abstractC0272g0.f3397j;
        ArrayList arrayList = abstractC0272g0.f3401n;
        abstractC0272g0.i = true;
        abstractC0272g0.z(true);
        int i = 0;
        abstractC0272g0.i = false;
        if (abstractC0272g0.f3396h != null) {
            if (!arrayList.isEmpty()) {
                LinkedHashSet linkedHashSet = new LinkedHashSet(AbstractC0272g0.F(abstractC0272g0.f3396h));
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    if (obj == null) {
                        Iterator it = linkedHashSet.iterator();
                        if (it.hasNext()) {
                            throw null;
                        }
                    } else {
                        throw new ClassCastException();
                    }
                }
            }
            ArrayList arrayList2 = abstractC0272g0.f3396h.f3497a;
            int size2 = arrayList2.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayList2.get(i4);
                i4++;
                G g3 = ((q0) obj2).f3489b;
                if (g3 != null) {
                    g3.mTransitioning = false;
                }
            }
            Iterator it2 = abstractC0272g0.f(new ArrayList(Collections.singletonList(abstractC0272g0.f3396h)), 0, 1).iterator();
            while (it2.hasNext()) {
                C0281p c0281p = (C0281p) it2.next();
                c0281p.getClass();
                AbstractC0272g0.J(3);
                ArrayList arrayList3 = c0281p.f3478c;
                c0281p.m(arrayList3);
                c0281p.c(arrayList3);
            }
            ArrayList arrayList4 = abstractC0272g0.f3396h.f3497a;
            int size3 = arrayList4.size();
            while (i < size3) {
                Object obj3 = arrayList4.get(i);
                i++;
                G g4 = ((q0) obj3).f3489b;
                if (g4 != null && g4.mContainer == null) {
                    abstractC0272g0.g(g4).i();
                }
            }
            abstractC0272g0.f3396h = null;
            abstractC0272g0.d0();
            if (AbstractC0272g0.J(3)) {
                x3.isEnabled();
                abstractC0272g0.toString();
                return;
            }
            return;
        }
        if (x3.isEnabled()) {
            AbstractC0272g0.J(3);
            abstractC0272g0.Q();
        } else {
            AbstractC0272g0.J(3);
            abstractC0272g0.f3395g.c();
        }
    }

    @Override // c.p
    public final void handleOnBackProgressed(C0325a backEvent) {
        boolean J3 = AbstractC0272g0.J(2);
        AbstractC0272g0 abstractC0272g0 = this.f3331a;
        if (J3) {
            Objects.toString(abstractC0272g0);
        }
        if (abstractC0272g0.f3396h != null) {
            Iterator it = abstractC0272g0.f(new ArrayList(Collections.singletonList(abstractC0272g0.f3396h)), 0, 1).iterator();
            while (it.hasNext()) {
                C0281p c0281p = (C0281p) it.next();
                c0281p.getClass();
                kotlin.jvm.internal.j.e(backEvent, "backEvent");
                AbstractC0272g0.J(2);
                ArrayList arrayList = c0281p.f3478c;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    AbstractC0714p.a0(arrayList2, ((E0) obj).f3298k);
                }
                List q02 = AbstractC0707i.q0(AbstractC0707i.u0(arrayList2));
                int size2 = q02.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ((D0) q02.get(i3)).d(backEvent, c0281p.f3476a);
                }
            }
            Iterator it2 = abstractC0272g0.f3401n.iterator();
            if (it2.hasNext()) {
                it2.next().getClass();
                throw new ClassCastException();
            }
        }
    }

    @Override // c.p
    public final void handleOnBackStarted(C0325a c0325a) {
        boolean J3 = AbstractC0272g0.J(3);
        AbstractC0272g0 abstractC0272g0 = this.f3331a;
        if (J3) {
            Objects.toString(abstractC0272g0);
        }
        abstractC0272g0.w();
        abstractC0272g0.x(new C0270f0(abstractC0272g0), false);
    }
}
