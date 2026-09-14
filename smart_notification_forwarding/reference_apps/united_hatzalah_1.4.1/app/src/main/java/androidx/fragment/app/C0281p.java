package androidx.fragment.app;

import F0.AbstractC0008a;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.uh.sf.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.Set;
import java.util.WeakHashMap;
import s2.C0679d;
import t.C0689e;
import t.C0694j;
import t2.AbstractC0707i;
import t2.AbstractC0714p;

/* renamed from: androidx.fragment.app.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0281p {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f3476a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f3477b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f3478c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3479d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3480e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3481f;

    public C0281p(ViewGroup container) {
        kotlin.jvm.internal.j.e(container, "container");
        this.f3476a = container;
        this.f3477b = new ArrayList();
        this.f3478c = new ArrayList();
    }

    public static void f(C0689e c0689e, View view) {
        WeakHashMap weakHashMap = J.S.f954a;
        String e4 = J.J.e(view);
        if (e4 != null) {
            c0689e.put(e4, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    f(c0689e, childAt);
                }
            }
        }
    }

    public static final C0281p j(ViewGroup container, AbstractC0272g0 fragmentManager) {
        kotlin.jvm.internal.j.e(container, "container");
        kotlin.jvm.internal.j.e(fragmentManager, "fragmentManager");
        kotlin.jvm.internal.j.d(fragmentManager.I(), "fragmentManager.specialEffectsControllerFactory");
        Object tag = container.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof C0281p) {
            return (C0281p) tag;
        }
        C0281p c0281p = new C0281p(container);
        container.setTag(R.id.special_effects_controller_view_tag, c0281p);
        return c0281p;
    }

    public static boolean k(ArrayList arrayList) {
        boolean z3;
        int size = arrayList.size();
        int i = 0;
        loop0: while (true) {
            z3 = true;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                E0 e02 = (E0) obj;
                if (!e02.f3298k.isEmpty()) {
                    ArrayList arrayList2 = e02.f3298k;
                    if (arrayList2 == null || !arrayList2.isEmpty()) {
                        int size2 = arrayList2.size();
                        int i3 = 0;
                        while (i3 < size2) {
                            Object obj2 = arrayList2.get(i3);
                            i3++;
                            if (!((D0) obj2).a()) {
                                break;
                            }
                        }
                    }
                }
                z3 = false;
            }
            break loop0;
        }
        if (z3) {
            ArrayList arrayList3 = new ArrayList();
            int size3 = arrayList.size();
            int i4 = 0;
            while (i4 < size3) {
                Object obj3 = arrayList.get(i4);
                i4++;
                AbstractC0714p.a0(arrayList3, ((E0) obj3).f3298k);
            }
            if (!arrayList3.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void n(C0689e c0689e, Collection collection) {
        Set entrySet = c0689e.entrySet();
        R.L l3 = new R.L(collection, 3);
        Iterator it = ((androidx.datastore.preferences.protobuf.X) entrySet).iterator();
        while (it.hasNext()) {
            if (!((Boolean) l3.invoke(it.next())).booleanValue()) {
                it.remove();
            }
        }
    }

    public final void a(E0 operation) {
        kotlin.jvm.internal.j.e(operation, "operation");
        if (operation.i) {
            int i = operation.f3289a;
            View requireView = operation.f3291c.requireView();
            kotlin.jvm.internal.j.d(requireView, "operation.fragment.requireView()");
            AbstractC0008a.a(i, requireView, this.f3476a);
            operation.i = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [t.j, t.e] */
    /* JADX WARN: Type inference failed for: r13v1, types: [t.j, t.e] */
    /* JADX WARN: Type inference failed for: r15v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v13, types: [int] */
    /* JADX WARN: Type inference failed for: r15v14, types: [int] */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r1v25, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v1, types: [t.j, t.e] */
    public final void b(ArrayList arrayList, boolean z3) {
        Object obj;
        Object obj2;
        ArrayList arrayList2;
        int i;
        ?? r15;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList3;
        int i6;
        E0 e02;
        z0 z0Var;
        ArrayList arrayList4;
        ArrayList<String> sharedElementSourceNames;
        ArrayList<String> sharedElementTargetNames;
        C0679d c0679d;
        boolean z4;
        int i7 = 2;
        AbstractC0272g0.J(2);
        int size = arrayList.size();
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i9 < size) {
                obj = arrayList.get(i9);
                i9++;
                E0 e03 = (E0) obj;
                View view = e03.f3291c.mView;
                kotlin.jvm.internal.j.d(view, "operation.fragment.mView");
                if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                    int visibility = view.getVisibility();
                    if (visibility != 0) {
                        if (visibility != 4 && visibility != 8) {
                            throw new IllegalArgumentException(e0.a.c(visibility, "Unknown visibility "));
                        }
                    } else if (e03.f3289a != 2) {
                        break;
                    }
                }
            } else {
                obj = null;
                break;
            }
        }
        E0 e04 = (E0) obj;
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                obj2 = listIterator.previous();
                E0 e05 = (E0) obj2;
                View view2 = e05.f3291c.mView;
                kotlin.jvm.internal.j.d(view2, "operation.fragment.mView");
                if (view2.getAlpha() != 0.0f || view2.getVisibility() != 0) {
                    int visibility2 = view2.getVisibility();
                    if (visibility2 == 0) {
                        continue;
                    } else if (visibility2 != 4 && visibility2 != 8) {
                        throw new IllegalArgumentException(e0.a.c(visibility2, "Unknown visibility "));
                    }
                }
                if (e05.f3289a == 2) {
                    break;
                }
            } else {
                obj2 = null;
                break;
            }
        }
        E0 e06 = (E0) obj2;
        if (AbstractC0272g0.J(2)) {
            Objects.toString(e04);
            Objects.toString(e06);
        }
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        G g3 = ((E0) AbstractC0707i.i0(arrayList)).f3291c;
        int size2 = arrayList.size();
        int i10 = 0;
        while (i10 < size2) {
            Object obj3 = arrayList.get(i10);
            i10++;
            D d2 = ((E0) obj3).f3291c.mAnimationInfo;
            D d4 = g3.mAnimationInfo;
            d2.f3271b = d4.f3271b;
            d2.f3272c = d4.f3272c;
            d2.f3273d = d4.f3273d;
            d2.f3274e = d4.f3274e;
        }
        int size3 = arrayList.size();
        int i11 = 0;
        while (true) {
            int i12 = 1;
            if (i11 >= size3) {
                break;
            }
            Object obj4 = arrayList.get(i11);
            i11++;
            E0 e07 = (E0) obj4;
            arrayList5.add(new C0269f(e07, z3));
            if (!z3 ? e07 == e06 : e07 == e04) {
                z4 = true;
            } else {
                z4 = false;
            }
            arrayList6.add(new C0280o(e07, z3, z4));
            e07.f3292d.add(new C0(this, e07, i12));
        }
        ArrayList arrayList7 = new ArrayList();
        int size4 = arrayList6.size();
        int i13 = 0;
        while (i13 < size4) {
            Object obj5 = arrayList6.get(i13);
            i13++;
            if (!((C0280o) obj5).a()) {
                arrayList7.add(obj5);
            }
        }
        ArrayList arrayList8 = new ArrayList();
        int size5 = arrayList7.size();
        int i14 = 0;
        while (i14 < size5) {
            Object obj6 = arrayList7.get(i14);
            i14++;
            if (((C0280o) obj6).b() != null) {
                arrayList8.add(obj6);
            }
        }
        int size6 = arrayList8.size();
        int i15 = 0;
        z0 z0Var2 = null;
        while (i15 < size6) {
            Object obj7 = arrayList8.get(i15);
            i15++;
            C0280o c0280o = (C0280o) obj7;
            z0 b4 = c0280o.b();
            if (z0Var2 != null && b4 != z0Var2) {
                throw new IllegalArgumentException(("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + c0280o.f3425a.f3291c + " returned Transition " + c0280o.f3468b + " which uses a different Transition type than other Fragments.").toString());
            }
            z0Var2 = b4;
        }
        if (z0Var2 == null) {
            arrayList2 = arrayList5;
            i3 = 1;
            i = 2;
            r15 = 0;
        } else {
            ArrayList arrayList9 = new ArrayList();
            ArrayList arrayList10 = new ArrayList();
            ?? c0694j = new C0694j(0);
            ArrayList<String> arrayList11 = new ArrayList<>();
            ArrayList<String> arrayList12 = new ArrayList<>();
            ArrayList<String> arrayList13 = arrayList11;
            ?? c0694j2 = new C0694j(0);
            ArrayList<String> arrayList14 = arrayList12;
            ?? c0694j3 = new C0694j(0);
            int size7 = arrayList8.size();
            while (true) {
                Object obj8 = null;
                while (i8 < size7) {
                    Object obj9 = arrayList8.get(i8);
                    int i16 = i8 + 1;
                    i4 = i7;
                    Object obj10 = ((C0280o) obj9).f3470d;
                    if (obj10 != null && e04 != null) {
                        G g4 = e04.f3291c;
                        if (e06 != null) {
                            i5 = size7;
                            G g5 = e06.f3291c;
                            obj8 = z0Var2.s(z0Var2.f(obj10));
                            sharedElementSourceNames = g5.getSharedElementSourceNames();
                            arrayList3 = arrayList5;
                            kotlin.jvm.internal.j.d(sharedElementSourceNames, "lastIn.fragment.sharedElementSourceNames");
                            ArrayList<String> sharedElementSourceNames2 = g4.getSharedElementSourceNames();
                            i6 = i16;
                            kotlin.jvm.internal.j.d(sharedElementSourceNames2, "firstOut.fragment.sharedElementSourceNames");
                            ArrayList<String> sharedElementTargetNames2 = g4.getSharedElementTargetNames();
                            e02 = e06;
                            kotlin.jvm.internal.j.d(sharedElementTargetNames2, "firstOut.fragment.sharedElementTargetNames");
                            int size8 = sharedElementTargetNames2.size();
                            z0Var = z0Var2;
                            arrayList4 = arrayList9;
                            int i17 = 0;
                            while (i17 < size8) {
                                int i18 = size8;
                                int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames2.get(i17));
                                if (indexOf != -1) {
                                    sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i17));
                                }
                                i17++;
                                size8 = i18;
                            }
                            sharedElementTargetNames = g5.getSharedElementTargetNames();
                            kotlin.jvm.internal.j.d(sharedElementTargetNames, "lastIn.fragment.sharedElementTargetNames");
                            if (!z3) {
                                g4.getExitTransitionCallback();
                                g5.getEnterTransitionCallback();
                                c0679d = new C0679d(null, null);
                            } else {
                                g4.getEnterTransitionCallback();
                                g5.getExitTransitionCallback();
                                c0679d = new C0679d(null, null);
                            }
                            if (c0679d.f6332a == null) {
                                if (c0679d.f6333b == null) {
                                    int i19 = 0;
                                    for (int size9 = sharedElementSourceNames.size(); i19 < size9; size9 = size9) {
                                        String str = sharedElementSourceNames.get(i19);
                                        kotlin.jvm.internal.j.d(str, "exitingNames[i]");
                                        String str2 = sharedElementTargetNames.get(i19);
                                        kotlin.jvm.internal.j.d(str2, "enteringNames[i]");
                                        c0694j.put(str, str2);
                                        i19++;
                                    }
                                    if (AbstractC0272g0.J(i4)) {
                                        int size10 = sharedElementTargetNames.size();
                                        for (int i20 = 0; i20 < size10; i20++) {
                                            sharedElementTargetNames.get(i20);
                                        }
                                        int size11 = sharedElementSourceNames.size();
                                        for (int i21 = 0; i21 < size11; i21++) {
                                            sharedElementSourceNames.get(i21);
                                        }
                                    }
                                    View view3 = g4.mView;
                                    kotlin.jvm.internal.j.d(view3, "firstOut.fragment.mView");
                                    f(c0694j2, view3);
                                    c0694j2.l(sharedElementSourceNames);
                                    c0694j.l(c0694j2.keySet());
                                    View view4 = g5.mView;
                                    kotlin.jvm.internal.j.d(view4, "lastIn.fragment.mView");
                                    f(c0694j3, view4);
                                    c0694j3.l(sharedElementTargetNames);
                                    c0694j3.l(c0694j.values());
                                    x0 x0Var = s0.f3512a;
                                    for (int i22 = c0694j.f6366c - 1; -1 < i22; i22--) {
                                        if (!c0694j3.containsKey((String) c0694j.i(i22))) {
                                            c0694j.g(i22);
                                        }
                                    }
                                    n(c0694j2, c0694j.keySet());
                                    n(c0694j3, c0694j.values());
                                    if (c0694j.isEmpty()) {
                                        break;
                                    }
                                    arrayList13 = sharedElementTargetNames;
                                    arrayList14 = sharedElementSourceNames;
                                    i7 = i4;
                                    size7 = i5;
                                    arrayList5 = arrayList3;
                                    i8 = i6;
                                    e06 = e02;
                                    z0Var2 = z0Var;
                                    arrayList9 = arrayList4;
                                } else {
                                    throw new ClassCastException();
                                }
                            } else {
                                throw new ClassCastException();
                            }
                        }
                    }
                    i5 = size7;
                    arrayList3 = arrayList5;
                    i6 = i16;
                    e02 = e06;
                    z0Var = z0Var2;
                    arrayList4 = arrayList9;
                    i7 = i4;
                    size7 = i5;
                    arrayList5 = arrayList3;
                    i8 = i6;
                    e06 = e02;
                    z0Var2 = z0Var;
                    arrayList9 = arrayList4;
                }
                arrayList2 = arrayList5;
                E0 e08 = e06;
                z0 z0Var3 = z0Var2;
                ArrayList arrayList15 = arrayList9;
                i = i7;
                if (obj8 == null) {
                    if (!arrayList8.isEmpty()) {
                        int size12 = arrayList8.size();
                        int i23 = 0;
                        while (i23 < size12) {
                            Object obj11 = arrayList8.get(i23);
                            i23++;
                            if (((C0280o) obj11).f3468b == null) {
                            }
                        }
                    }
                    i3 = 1;
                    r15 = 0;
                }
                r15 = 0;
                i3 = 1;
                C0279n c0279n = new C0279n(arrayList8, e04, e08, z0Var3, obj8, arrayList15, arrayList10, c0694j, arrayList13, arrayList14, c0694j2, c0694j3, z3);
                int size13 = arrayList8.size();
                int i24 = 0;
                while (i24 < size13) {
                    Object obj12 = arrayList8.get(i24);
                    i24++;
                    ((C0280o) obj12).f3425a.f3297j.add(c0279n);
                }
                Objects.toString(obj8);
                e04.toString();
                e02.toString();
                arrayList4.clear();
                arrayList10.clear();
                arrayList13 = sharedElementTargetNames;
                arrayList14 = sharedElementSourceNames;
                i7 = i4;
                size7 = i5;
                arrayList5 = arrayList3;
                i8 = i6;
                e06 = e02;
                z0Var2 = z0Var;
                arrayList9 = arrayList4;
            }
        }
        ?? arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        int size14 = arrayList2.size();
        int i25 = r15;
        while (i25 < size14) {
            Object obj13 = arrayList2.get(i25);
            i25++;
            AbstractC0714p.a0(arrayList17, ((C0269f) obj13).f3425a.f3298k);
        }
        ArrayList arrayList18 = arrayList2;
        boolean isEmpty = arrayList17.isEmpty();
        int size15 = arrayList18.size();
        int i26 = r15;
        int i27 = i26;
        while (i27 < size15) {
            Object obj14 = arrayList18.get(i27);
            i27++;
            C0269f c0269f = (C0269f) obj14;
            Context context = this.f3476a.getContext();
            E0 e09 = c0269f.f3425a;
            kotlin.jvm.internal.j.d(context, "context");
            M b5 = c0269f.b(context);
            if (b5 != null) {
                if (((AnimatorSet) b5.f3309b) == null) {
                    arrayList16.add(c0269f);
                } else {
                    G g6 = e09.f3291c;
                    if (!e09.f3298k.isEmpty()) {
                        if (AbstractC0272g0.J(i)) {
                            Objects.toString(g6);
                        }
                    } else {
                        if (e09.f3289a == 3) {
                            e09.i = r15;
                        }
                        e09.f3297j.add(new C0273h(c0269f));
                        i26 = i3;
                    }
                }
            }
        }
        int size16 = arrayList16.size();
        while (r15 < size16) {
            Object obj15 = arrayList16.get(r15);
            r15++;
            C0269f c0269f2 = (C0269f) obj15;
            E0 e010 = c0269f2.f3425a;
            G g7 = e010.f3291c;
            if (!isEmpty) {
                if (AbstractC0272g0.J(i)) {
                    Objects.toString(g7);
                }
            } else if (i26 != 0) {
                if (AbstractC0272g0.J(i)) {
                    Objects.toString(g7);
                }
            } else {
                e010.f3297j.add(new C0267e(c0269f2));
            }
        }
    }

    public final void c(List operations) {
        kotlin.jvm.internal.j.e(operations, "operations");
        ArrayList arrayList = new ArrayList();
        Iterator it = operations.iterator();
        while (it.hasNext()) {
            AbstractC0714p.a0(arrayList, ((E0) it.next()).f3298k);
        }
        List q02 = AbstractC0707i.q0(AbstractC0707i.u0(arrayList));
        int size = q02.size();
        for (int i = 0; i < size; i++) {
            ((D0) q02.get(i)).c(this.f3476a);
        }
        int size2 = operations.size();
        for (int i3 = 0; i3 < size2; i3++) {
            a((E0) operations.get(i3));
        }
        List q03 = AbstractC0707i.q0(operations);
        int size3 = q03.size();
        for (int i4 = 0; i4 < size3; i4++) {
            E0 e02 = (E0) q03.get(i4);
            if (e02.f3298k.isEmpty()) {
                e02.b();
            }
        }
    }

    public final void d(int i, int i3, o0 o0Var) {
        synchronized (this.f3477b) {
            try {
                G g3 = o0Var.f3473c;
                kotlin.jvm.internal.j.d(g3, "fragmentStateManager.fragment");
                E0 g4 = g(g3);
                if (g4 == null) {
                    G g5 = o0Var.f3473c;
                    if (!g5.mTransitioning && !g5.mRemoving) {
                        g4 = null;
                    }
                    g4 = h(g5);
                }
                if (g4 != null) {
                    g4.d(i, i3);
                    return;
                }
                E0 e02 = new E0(i, i3, o0Var);
                this.f3477b.add(e02);
                e02.f3292d.add(new C0(this, e02, 0));
                e02.f3292d.add(new C0(this, e02, 2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        boolean z3;
        if (this.f3481f) {
            return;
        }
        if (!this.f3476a.isAttachedToWindow()) {
            i();
            this.f3480e = false;
            return;
        }
        synchronized (this.f3477b) {
            try {
                ArrayList s02 = AbstractC0707i.s0(this.f3478c);
                this.f3478c.clear();
                int size = s02.size();
                int i = 0;
                while (true) {
                    z3 = true;
                    if (i >= size) {
                        break;
                    }
                    Object obj = s02.get(i);
                    i++;
                    E0 e02 = (E0) obj;
                    if (this.f3477b.isEmpty() || !e02.f3291c.mTransitioning) {
                        z3 = false;
                    }
                    e02.f3295g = z3;
                }
                int size2 = s02.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = s02.get(i3);
                    i3++;
                    E0 e03 = (E0) obj2;
                    if (this.f3479d) {
                        if (AbstractC0272g0.J(2)) {
                            Objects.toString(e03);
                        }
                        e03.b();
                    } else {
                        if (AbstractC0272g0.J(2)) {
                            Objects.toString(e03);
                        }
                        e03.a(this.f3476a);
                    }
                    this.f3479d = false;
                    if (!e03.f3294f) {
                        this.f3478c.add(e03);
                    }
                }
                if (!this.f3477b.isEmpty()) {
                    o();
                    ArrayList s03 = AbstractC0707i.s0(this.f3477b);
                    if (s03.isEmpty()) {
                        return;
                    }
                    this.f3477b.clear();
                    this.f3478c.addAll(s03);
                    AbstractC0272g0.J(2);
                    b(s03, this.f3480e);
                    boolean k4 = k(s03);
                    int size3 = s03.size();
                    int i4 = 0;
                    boolean z4 = true;
                    while (i4 < size3) {
                        Object obj3 = s03.get(i4);
                        i4++;
                        if (!((E0) obj3).f3291c.mTransitioning) {
                            z4 = false;
                        }
                    }
                    if (!z4 || k4) {
                        z3 = false;
                    }
                    this.f3479d = z3;
                    AbstractC0272g0.J(2);
                    if (!z4) {
                        m(s03);
                        c(s03);
                    } else if (k4) {
                        m(s03);
                        int size4 = s03.size();
                        for (int i5 = 0; i5 < size4; i5++) {
                            a((E0) s03.get(i5));
                        }
                    }
                    this.f3480e = false;
                    AbstractC0272g0.J(2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final E0 g(G g3) {
        Object obj;
        ArrayList arrayList = this.f3477b;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i < size) {
                obj = arrayList.get(i);
                i++;
                E0 e02 = (E0) obj;
                if (kotlin.jvm.internal.j.a(e02.f3291c, g3) && !e02.f3293e) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (E0) obj;
    }

    public final E0 h(G g3) {
        Object obj;
        ArrayList arrayList = this.f3478c;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i < size) {
                obj = arrayList.get(i);
                i++;
                E0 e02 = (E0) obj;
                if (kotlin.jvm.internal.j.a(e02.f3291c, g3) && !e02.f3293e) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (E0) obj;
    }

    public final void i() {
        AbstractC0272g0.J(2);
        boolean isAttachedToWindow = this.f3476a.isAttachedToWindow();
        synchronized (this.f3477b) {
            try {
                o();
                m(this.f3477b);
                ArrayList s02 = AbstractC0707i.s0(this.f3478c);
                int size = s02.size();
                int i = 0;
                int i3 = 0;
                while (i3 < size) {
                    Object obj = s02.get(i3);
                    i3++;
                    ((E0) obj).f3295g = false;
                }
                int size2 = s02.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj2 = s02.get(i4);
                    i4++;
                    E0 e02 = (E0) obj2;
                    if (AbstractC0272g0.J(2)) {
                        if (!isAttachedToWindow) {
                            Objects.toString(this.f3476a);
                        }
                        Objects.toString(e02);
                    }
                    e02.a(this.f3476a);
                }
                ArrayList s03 = AbstractC0707i.s0(this.f3477b);
                int size3 = s03.size();
                int i5 = 0;
                while (i5 < size3) {
                    Object obj3 = s03.get(i5);
                    i5++;
                    ((E0) obj3).f3295g = false;
                }
                int size4 = s03.size();
                while (i < size4) {
                    Object obj4 = s03.get(i);
                    i++;
                    E0 e03 = (E0) obj4;
                    if (AbstractC0272g0.J(2)) {
                        if (!isAttachedToWindow) {
                            Objects.toString(this.f3476a);
                        }
                        Objects.toString(e03);
                    }
                    e03.a(this.f3476a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l() {
        G g3;
        Object obj;
        boolean z3;
        synchronized (this.f3477b) {
            try {
                o();
                ArrayList arrayList = this.f3477b;
                ListIterator listIterator = arrayList.listIterator(arrayList.size());
                while (true) {
                    g3 = null;
                    if (listIterator.hasPrevious()) {
                        obj = listIterator.previous();
                        E0 e02 = (E0) obj;
                        View view = e02.f3291c.mView;
                        kotlin.jvm.internal.j.d(view, "operation.fragment.mView");
                        char c4 = 4;
                        if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
                            int visibility = view.getVisibility();
                            if (visibility != 0) {
                                if (visibility != 4) {
                                    if (visibility == 8) {
                                        c4 = 3;
                                    } else {
                                        throw new IllegalArgumentException("Unknown visibility " + visibility);
                                    }
                                }
                            } else {
                                c4 = 2;
                            }
                        }
                        if (e02.f3289a == 2 && c4 != 2) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                E0 e03 = (E0) obj;
                if (e03 != null) {
                    g3 = e03.f3291c;
                }
                if (g3 != null) {
                    z3 = g3.isPostponed();
                } else {
                    z3 = false;
                }
                this.f3481f = z3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            E0 e02 = (E0) list.get(i);
            o0 o0Var = e02.f3299l;
            if (!e02.f3296h) {
                e02.f3296h = true;
                int i3 = e02.f3290b;
                if (i3 == 2) {
                    G g3 = o0Var.f3473c;
                    kotlin.jvm.internal.j.d(g3, "fragmentStateManager.fragment");
                    View findFocus = g3.mView.findFocus();
                    if (findFocus != null) {
                        g3.setFocusedView(findFocus);
                        if (AbstractC0272g0.J(2)) {
                            findFocus.toString();
                            g3.toString();
                        }
                    }
                    View requireView = e02.f3291c.requireView();
                    kotlin.jvm.internal.j.d(requireView, "this.fragment.requireView()");
                    if (requireView.getParent() == null) {
                        if (AbstractC0272g0.J(2)) {
                            g3.toString();
                            requireView.toString();
                        }
                        o0Var.a();
                        requireView.setAlpha(0.0f);
                    }
                    if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                        if (AbstractC0272g0.J(2)) {
                            requireView.toString();
                        }
                        requireView.setVisibility(4);
                    }
                    requireView.setAlpha(g3.getPostOnViewCreatedAlpha());
                    if (AbstractC0272g0.J(2)) {
                        g3.getPostOnViewCreatedAlpha();
                    }
                } else if (i3 == 3) {
                    G g4 = o0Var.f3473c;
                    kotlin.jvm.internal.j.d(g4, "fragmentStateManager.fragment");
                    View requireView2 = g4.requireView();
                    kotlin.jvm.internal.j.d(requireView2, "fragment.requireView()");
                    if (AbstractC0272g0.J(2)) {
                        Objects.toString(requireView2.findFocus());
                        requireView2.toString();
                        g4.toString();
                    }
                    requireView2.clearFocus();
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC0714p.a0(arrayList, ((E0) it.next()).f3298k);
        }
        List q02 = AbstractC0707i.q0(AbstractC0707i.u0(arrayList));
        int size2 = q02.size();
        for (int i4 = 0; i4 < size2; i4++) {
            D0 d02 = (D0) q02.get(i4);
            d02.getClass();
            ViewGroup container = this.f3476a;
            kotlin.jvm.internal.j.e(container, "container");
            if (!d02.f3287a) {
                d02.e(container);
            }
            d02.f3287a = true;
        }
    }

    public final void o() {
        ArrayList arrayList = this.f3477b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            E0 e02 = (E0) obj;
            int i3 = 2;
            if (e02.f3290b == 2) {
                View requireView = e02.f3291c.requireView();
                kotlin.jvm.internal.j.d(requireView, "fragment.requireView()");
                int visibility = requireView.getVisibility();
                if (visibility != 0) {
                    i3 = 4;
                    if (visibility != 4) {
                        if (visibility == 8) {
                            i3 = 3;
                        } else {
                            throw new IllegalArgumentException(e0.a.c(visibility, "Unknown visibility "));
                        }
                    }
                }
                e02.d(i3, 1);
            }
        }
    }
}
