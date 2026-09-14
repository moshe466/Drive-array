package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import c.C0325a;
import java.util.ArrayList;
import java.util.Objects;
import t.C0689e;

/* renamed from: androidx.fragment.app.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0279n extends D0 {

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f3454c;

    /* renamed from: d, reason: collision with root package name */
    public final E0 f3455d;

    /* renamed from: e, reason: collision with root package name */
    public final E0 f3456e;

    /* renamed from: f, reason: collision with root package name */
    public final z0 f3457f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f3458g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f3459h;
    public final ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public final C0689e f3460j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f3461k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f3462l;

    /* renamed from: m, reason: collision with root package name */
    public final C0689e f3463m;

    /* renamed from: n, reason: collision with root package name */
    public final C0689e f3464n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f3465o;
    public final F.c p = new Object();

    /* renamed from: q, reason: collision with root package name */
    public boolean f3466q;

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, F.c] */
    public C0279n(ArrayList arrayList, E0 e02, E0 e03, z0 z0Var, Object obj, ArrayList arrayList2, ArrayList arrayList3, C0689e c0689e, ArrayList arrayList4, ArrayList arrayList5, C0689e c0689e2, C0689e c0689e3, boolean z3) {
        this.f3454c = arrayList;
        this.f3455d = e02;
        this.f3456e = e03;
        this.f3457f = z0Var;
        this.f3458g = obj;
        this.f3459h = arrayList2;
        this.i = arrayList3;
        this.f3460j = c0689e;
        this.f3461k = arrayList4;
        this.f3462l = arrayList5;
        this.f3463m = c0689e2;
        this.f3464n = c0689e3;
        this.f3465o = z3;
    }

    public static void f(View view, ArrayList arrayList) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = J.U.f960a;
            if (viewGroup.isTransitionGroup()) {
                if (!arrayList.contains(view)) {
                    arrayList.add(view);
                    return;
                }
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    f(childAt, arrayList);
                }
            }
            return;
        }
        if (!arrayList.contains(view)) {
            arrayList.add(view);
        }
    }

    @Override // androidx.fragment.app.D0
    public final boolean a() {
        this.f3457f.i();
        return false;
    }

    @Override // androidx.fragment.app.D0
    public final void b(ViewGroup container) {
        kotlin.jvm.internal.j.e(container, "container");
        this.p.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c8  */
    /* JADX WARN: Type inference failed for: r13v5, types: [t.j] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    @Override // androidx.fragment.app.D0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(android.view.ViewGroup r36) {
        /*
            Method dump skipped, instructions count: 955
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.C0279n.c(android.view.ViewGroup):void");
    }

    @Override // androidx.fragment.app.D0
    public final void d(C0325a c0325a, ViewGroup container) {
        kotlin.jvm.internal.j.e(container, "container");
    }

    @Override // androidx.fragment.app.D0
    public final void e(ViewGroup container) {
        boolean z3;
        Object obj;
        kotlin.jvm.internal.j.e(container, "container");
        if (!container.isLaidOut()) {
            ArrayList arrayList = this.f3454c;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                E0 e02 = ((C0280o) obj2).f3425a;
                if (AbstractC0272g0.J(2)) {
                    container.toString();
                    Objects.toString(e02);
                }
            }
            return;
        }
        ArrayList arrayList2 = this.f3454c;
        if (!arrayList2.isEmpty()) {
            int size2 = arrayList2.size();
            z3 = false;
            int i3 = 0;
            while (i3 < size2) {
                Object obj3 = arrayList2.get(i3);
                i3++;
                if (!((C0280o) obj3).f3425a.f3291c.mTransitioning) {
                    break;
                }
            }
        }
        z3 = true;
        if (z3 && (obj = this.f3458g) != null) {
            a();
            Objects.toString(obj);
            Objects.toString(this.f3455d);
            Objects.toString(this.f3456e);
        }
        a();
    }
}
