package androidx.fragment.app;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f3482a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3483b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f3484c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public k0 f3485d;

    public final void a(G g3) {
        if (!this.f3482a.contains(g3)) {
            synchronized (this.f3482a) {
                this.f3482a.add(g3);
            }
            g3.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + g3);
    }

    public final G b(String str) {
        o0 o0Var = (o0) this.f3483b.get(str);
        if (o0Var != null) {
            return o0Var.f3473c;
        }
        return null;
    }

    public final G c(String str) {
        G findFragmentByWho;
        for (o0 o0Var : this.f3483b.values()) {
            if (o0Var != null && (findFragmentByWho = o0Var.f3473c.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (o0 o0Var : this.f3483b.values()) {
            if (o0Var != null) {
                arrayList.add(o0Var);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (o0 o0Var : this.f3483b.values()) {
            if (o0Var != null) {
                arrayList.add(o0Var.f3473c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList;
        if (this.f3482a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f3482a) {
            arrayList = new ArrayList(this.f3482a);
        }
        return arrayList;
    }

    public final void g(o0 o0Var) {
        G g3 = o0Var.f3473c;
        String str = g3.mWho;
        HashMap hashMap = this.f3483b;
        if (hashMap.get(str) != null) {
            return;
        }
        hashMap.put(g3.mWho, o0Var);
        if (g3.mRetainInstanceChangedWhileDetached) {
            if (g3.mRetainInstance) {
                this.f3485d.c(g3);
            } else {
                this.f3485d.f(g3);
            }
            g3.mRetainInstanceChangedWhileDetached = false;
        }
        if (AbstractC0272g0.J(2)) {
            g3.toString();
        }
    }

    public final void h(o0 o0Var) {
        G g3 = o0Var.f3473c;
        if (g3.mRetainInstance) {
            this.f3485d.f(g3);
        }
        String str = g3.mWho;
        HashMap hashMap = this.f3483b;
        if (hashMap.get(str) == o0Var && ((o0) hashMap.put(g3.mWho, null)) != null && AbstractC0272g0.J(2)) {
            g3.toString();
        }
    }

    public final Bundle i(Bundle bundle, String str) {
        HashMap hashMap = this.f3484c;
        if (bundle != null) {
            return (Bundle) hashMap.put(str, bundle);
        }
        return (Bundle) hashMap.remove(str);
    }
}
