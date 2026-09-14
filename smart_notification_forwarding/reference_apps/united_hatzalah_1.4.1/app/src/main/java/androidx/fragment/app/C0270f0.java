package androidx.fragment.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;

/* renamed from: androidx.fragment.app.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0270f0 implements InterfaceC0266d0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0272g0 f3367a;

    public C0270f0(AbstractC0272g0 abstractC0272g0) {
        this.f3367a = abstractC0272g0;
    }

    @Override // androidx.fragment.app.InterfaceC0266d0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        boolean S3;
        boolean J3 = AbstractC0272g0.J(2);
        AbstractC0272g0 abstractC0272g0 = this.f3367a;
        if (J3) {
            Objects.toString(abstractC0272g0.f3389a);
        }
        int i = 0;
        if (abstractC0272g0.f3392d.isEmpty()) {
            S3 = false;
        } else {
            ArrayList arrayList3 = abstractC0272g0.f3392d;
            C0259a c0259a = (C0259a) arrayList3.get(arrayList3.size() - 1);
            abstractC0272g0.f3396h = c0259a;
            ArrayList arrayList4 = c0259a.f3497a;
            int size = arrayList4.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList4.get(i3);
                i3++;
                G g3 = ((q0) obj).f3489b;
                if (g3 != null) {
                    g3.mTransitioning = true;
                }
            }
            S3 = abstractC0272g0.S(arrayList, arrayList2, -1, 0);
        }
        if (!abstractC0272g0.f3401n.isEmpty() && arrayList.size() > 0) {
            ((Boolean) arrayList2.get(arrayList.size() - 1)).getClass();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int size2 = arrayList.size();
            int i4 = 0;
            while (i4 < size2) {
                Object obj2 = arrayList.get(i4);
                i4++;
                linkedHashSet.addAll(AbstractC0272g0.F((C0259a) obj2));
            }
            ArrayList arrayList5 = abstractC0272g0.f3401n;
            int size3 = arrayList5.size();
            while (i < size3) {
                Object obj3 = arrayList5.get(i);
                i++;
                if (obj3 == null) {
                    Iterator it = linkedHashSet.iterator();
                    if (it.hasNext()) {
                        throw null;
                    }
                } else {
                    throw new ClassCastException();
                }
            }
        }
        return S3;
    }
}
