package androidx.fragment.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class k0 extends androidx.lifecycle.V {

    /* renamed from: h, reason: collision with root package name */
    public static final j0 f3426h = new j0(0);

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3430e;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3427b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f3428c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f3429d = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public boolean f3431f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f3432g = false;

    public k0(boolean z3) {
        this.f3430e = z3;
    }

    @Override // androidx.lifecycle.V
    public final void b() {
        if (AbstractC0272g0.J(3)) {
            toString();
        }
        this.f3431f = true;
    }

    public final void c(G g3) {
        if (this.f3432g) {
            AbstractC0272g0.J(2);
            return;
        }
        String str = g3.mWho;
        HashMap hashMap = this.f3427b;
        if (!hashMap.containsKey(str)) {
            hashMap.put(g3.mWho, g3);
            if (AbstractC0272g0.J(2)) {
                g3.toString();
            }
        }
    }

    public final void d(String str, boolean z3) {
        AbstractC0272g0.J(3);
        e(str, z3);
    }

    public final void e(String str, boolean z3) {
        HashMap hashMap = this.f3428c;
        k0 k0Var = (k0) hashMap.get(str);
        if (k0Var != null) {
            if (z3) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(k0Var.f3428c.keySet());
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    k0Var.d((String) obj, true);
                }
            }
            k0Var.b();
            hashMap.remove(str);
        }
        HashMap hashMap2 = this.f3429d;
        androidx.lifecycle.Z z4 = (androidx.lifecycle.Z) hashMap2.get(str);
        if (z4 != null) {
            z4.a();
            hashMap2.remove(str);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k0.class == obj.getClass()) {
            k0 k0Var = (k0) obj;
            if (this.f3427b.equals(k0Var.f3427b) && this.f3428c.equals(k0Var.f3428c) && this.f3429d.equals(k0Var.f3429d)) {
                return true;
            }
        }
        return false;
    }

    public final void f(G g3) {
        if (this.f3432g) {
            AbstractC0272g0.J(2);
        } else if (this.f3427b.remove(g3.mWho) != null && AbstractC0272g0.J(2)) {
            g3.toString();
        }
    }

    public final int hashCode() {
        return this.f3429d.hashCode() + ((this.f3428c.hashCode() + (this.f3427b.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f3427b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f3428c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f3429d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
