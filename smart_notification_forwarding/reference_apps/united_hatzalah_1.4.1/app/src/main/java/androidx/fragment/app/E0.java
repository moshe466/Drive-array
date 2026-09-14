package androidx.fragment.app;

import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Objects;
import t2.AbstractC0707i;

/* loaded from: classes.dex */
public final class E0 {

    /* renamed from: a, reason: collision with root package name */
    public int f3289a;

    /* renamed from: b, reason: collision with root package name */
    public int f3290b;

    /* renamed from: c, reason: collision with root package name */
    public final G f3291c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f3292d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f3293e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3294f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3295g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3296h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f3297j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f3298k;

    /* renamed from: l, reason: collision with root package name */
    public final o0 f3299l;

    public E0(int i, int i3, o0 o0Var) {
        e0.a.j(i, "finalState");
        e0.a.j(i3, "lifecycleImpact");
        G fragment = o0Var.f3473c;
        kotlin.jvm.internal.j.d(fragment, "fragmentStateManager.fragment");
        e0.a.j(i, "finalState");
        e0.a.j(i3, "lifecycleImpact");
        kotlin.jvm.internal.j.e(fragment, "fragment");
        this.f3289a = i;
        this.f3290b = i3;
        this.f3291c = fragment;
        this.f3292d = new ArrayList();
        this.i = true;
        ArrayList arrayList = new ArrayList();
        this.f3297j = arrayList;
        this.f3298k = arrayList;
        this.f3299l = o0Var;
    }

    public final void a(ViewGroup container) {
        kotlin.jvm.internal.j.e(container, "container");
        this.f3296h = false;
        if (!this.f3293e) {
            this.f3293e = true;
            if (this.f3297j.isEmpty()) {
                b();
                return;
            }
            for (D0 d02 : AbstractC0707i.q0(this.f3298k)) {
                d02.getClass();
                if (!d02.f3288b) {
                    d02.b(container);
                }
                d02.f3288b = true;
            }
        }
    }

    public final void b() {
        this.f3296h = false;
        if (!this.f3294f) {
            if (AbstractC0272g0.J(2)) {
                toString();
            }
            this.f3294f = true;
            ArrayList arrayList = this.f3292d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
        this.f3291c.mTransitioning = false;
        this.f3299l.i();
    }

    public final void c(D0 effect) {
        kotlin.jvm.internal.j.e(effect, "effect");
        ArrayList arrayList = this.f3297j;
        if (arrayList.remove(effect) && arrayList.isEmpty()) {
            b();
        }
    }

    public final void d(int i, int i3) {
        e0.a.j(i, "finalState");
        e0.a.j(i3, "lifecycleImpact");
        int b4 = T.k.b(i3);
        G g3 = this.f3291c;
        if (b4 != 0) {
            if (b4 != 1) {
                if (b4 == 2) {
                    if (AbstractC0272g0.J(2)) {
                        Objects.toString(g3);
                    }
                    this.f3289a = 1;
                    this.f3290b = 3;
                    this.i = true;
                    return;
                }
                return;
            }
            if (this.f3289a == 1) {
                if (AbstractC0272g0.J(2)) {
                    Objects.toString(g3);
                }
                this.f3289a = 2;
                this.f3290b = 2;
                this.i = true;
                return;
            }
            return;
        }
        if (this.f3289a != 1) {
            if (AbstractC0272g0.J(2)) {
                Objects.toString(g3);
                if (i != 1 && i != 2 && i != 3 && i != 4) {
                    throw null;
                }
            }
            this.f3289a = i;
        }
    }

    public final String toString() {
        String str;
        String str2;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        StringBuilder sb = new StringBuilder("Operation {");
        sb.append(hexString);
        sb.append("} {finalState = ");
        int i = this.f3289a;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        str = "null";
                    } else {
                        str = "INVISIBLE";
                    }
                } else {
                    str = "GONE";
                }
            } else {
                str = "VISIBLE";
            }
        } else {
            str = "REMOVED";
        }
        sb.append(str);
        sb.append(" lifecycleImpact = ");
        int i3 = this.f3290b;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    str2 = "null";
                } else {
                    str2 = "REMOVING";
                }
            } else {
                str2 = "ADDING";
            }
        } else {
            str2 = "NONE";
        }
        sb.append(str2);
        sb.append(" fragment = ");
        sb.append(this.f3291c);
        sb.append('}');
        return sb.toString();
    }
}
