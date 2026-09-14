package androidx.fragment.app;

import androidx.lifecycle.b0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z extends androidx.lifecycle.a0 {

    /* renamed from: j, reason: collision with root package name */
    private static final b0.b f3147j = new a();

    /* renamed from: f, reason: collision with root package name */
    private final boolean f3151f;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, Fragment> f3148c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, z> f3149d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, androidx.lifecycle.e0> f3150e = new HashMap<>();

    /* renamed from: g, reason: collision with root package name */
    private boolean f3152g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f3153h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3154i = false;

    /* loaded from: classes.dex */
    class a implements b0.b {
        a() {
        }

        @Override // androidx.lifecycle.b0.b
        public /* synthetic */ androidx.lifecycle.a0 a(Class cls, k0.a aVar) {
            return androidx.lifecycle.c0.b(this, cls, aVar);
        }

        @Override // androidx.lifecycle.b0.b
        public <T extends androidx.lifecycle.a0> T b(Class<T> cls) {
            return new z(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(boolean z10) {
        this.f3151f = z10;
    }

    private void h(String str) {
        z zVar = this.f3149d.get(str);
        if (zVar != null) {
            zVar.d();
            this.f3149d.remove(str);
        }
        androidx.lifecycle.e0 e0Var = this.f3150e.get(str);
        if (e0Var != null) {
            e0Var.a();
            this.f3150e.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z k(androidx.lifecycle.e0 e0Var) {
        return (z) new androidx.lifecycle.b0(e0Var, f3147j).a(z.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.a0
    public void d() {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCleared called for ");
            sb2.append(this);
        }
        this.f3152g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Fragment fragment) {
        if (this.f3154i) {
            w.H0(2);
            return;
        }
        if (this.f3148c.containsKey(fragment.f2836k)) {
            return;
        }
        this.f3148c.put(fragment.f2836k, fragment);
        if (w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Updating retained Fragments: Added ");
            sb2.append(fragment);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass()) {
            return false;
        }
        z zVar = (z) obj;
        return this.f3148c.equals(zVar.f3148c) && this.f3149d.equals(zVar.f3149d) && this.f3150e.equals(zVar.f3150e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Fragment fragment) {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing non-config state for ");
            sb2.append(fragment);
        }
        h(fragment.f2836k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(String str) {
        if (w.H0(3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing non-config state for saved state of Fragment ");
            sb2.append(str);
        }
        h(str);
    }

    public int hashCode() {
        return (((this.f3148c.hashCode() * 31) + this.f3149d.hashCode()) * 31) + this.f3150e.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment i(String str) {
        return this.f3148c.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z j(Fragment fragment) {
        z zVar = this.f3149d.get(fragment.f2836k);
        if (zVar != null) {
            return zVar;
        }
        z zVar2 = new z(this.f3151f);
        this.f3149d.put(fragment.f2836k, zVar2);
        return zVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<Fragment> l() {
        return new ArrayList(this.f3148c.values());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.lifecycle.e0 m(Fragment fragment) {
        androidx.lifecycle.e0 e0Var = this.f3150e.get(fragment.f2836k);
        if (e0Var != null) {
            return e0Var;
        }
        androidx.lifecycle.e0 e0Var2 = new androidx.lifecycle.e0();
        this.f3150e.put(fragment.f2836k, e0Var2);
        return e0Var2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f3152g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Fragment fragment) {
        if (this.f3154i) {
            w.H0(2);
            return;
        }
        if ((this.f3148c.remove(fragment.f2836k) != null) && w.H0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Updating retained Fragments: Removed ");
            sb2.append(fragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(boolean z10) {
        this.f3154i = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q(Fragment fragment) {
        if (this.f3148c.containsKey(fragment.f2836k)) {
            return this.f3151f ? this.f3152g : !this.f3153h;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("FragmentManagerViewModel{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("} Fragments (");
        Iterator<Fragment> it = this.f3148c.values().iterator();
        while (it.hasNext()) {
            sb2.append(it.next());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") Child Non Config (");
        Iterator<String> it2 = this.f3149d.keySet().iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(") ViewModelStores (");
        Iterator<String> it3 = this.f3150e.keySet().iterator();
        while (it3.hasNext()) {
            sb2.append(it3.next());
            if (it3.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(')');
        return sb2.toString();
    }
}
