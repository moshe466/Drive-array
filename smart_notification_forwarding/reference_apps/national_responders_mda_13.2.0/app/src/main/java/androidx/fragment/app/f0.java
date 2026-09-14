package androidx.fragment.app;

import android.view.ViewGroup;
import androidx.lifecycle.h;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: b, reason: collision with root package name */
    int f2995b;

    /* renamed from: c, reason: collision with root package name */
    int f2996c;

    /* renamed from: d, reason: collision with root package name */
    int f2997d;

    /* renamed from: e, reason: collision with root package name */
    int f2998e;

    /* renamed from: f, reason: collision with root package name */
    int f2999f;

    /* renamed from: g, reason: collision with root package name */
    boolean f3000g;

    /* renamed from: i, reason: collision with root package name */
    String f3002i;

    /* renamed from: j, reason: collision with root package name */
    int f3003j;

    /* renamed from: k, reason: collision with root package name */
    CharSequence f3004k;

    /* renamed from: l, reason: collision with root package name */
    int f3005l;

    /* renamed from: m, reason: collision with root package name */
    CharSequence f3006m;

    /* renamed from: n, reason: collision with root package name */
    ArrayList<String> f3007n;

    /* renamed from: o, reason: collision with root package name */
    ArrayList<String> f3008o;

    /* renamed from: q, reason: collision with root package name */
    ArrayList<Runnable> f3010q;

    /* renamed from: a, reason: collision with root package name */
    ArrayList<a> f2994a = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    boolean f3001h = true;

    /* renamed from: p, reason: collision with root package name */
    boolean f3009p = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        int f3011a;

        /* renamed from: b, reason: collision with root package name */
        Fragment f3012b;

        /* renamed from: c, reason: collision with root package name */
        boolean f3013c;

        /* renamed from: d, reason: collision with root package name */
        int f3014d;

        /* renamed from: e, reason: collision with root package name */
        int f3015e;

        /* renamed from: f, reason: collision with root package name */
        int f3016f;

        /* renamed from: g, reason: collision with root package name */
        int f3017g;

        /* renamed from: h, reason: collision with root package name */
        h.c f3018h;

        /* renamed from: i, reason: collision with root package name */
        h.c f3019i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i10, Fragment fragment) {
            this.f3011a = i10;
            this.f3012b = fragment;
            this.f3013c = false;
            h.c cVar = h.c.RESUMED;
            this.f3018h = cVar;
            this.f3019i = cVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i10, Fragment fragment, boolean z10) {
            this.f3011a = i10;
            this.f3012b = fragment;
            this.f3013c = z10;
            h.c cVar = h.c.RESUMED;
            this.f3018h = cVar;
            this.f3019i = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(n nVar, ClassLoader classLoader) {
    }

    public f0 b(int i10, Fragment fragment) {
        m(i10, fragment, null, 1);
        return this;
    }

    public f0 c(int i10, Fragment fragment, String str) {
        m(i10, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0 d(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.M = viewGroup;
        return c(viewGroup.getId(), fragment, str);
    }

    public f0 e(Fragment fragment, String str) {
        m(0, fragment, str, 1);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(a aVar) {
        this.f2994a.add(aVar);
        aVar.f3014d = this.f2995b;
        aVar.f3015e = this.f2996c;
        aVar.f3016f = this.f2997d;
        aVar.f3017g = this.f2998e;
    }

    public f0 g(String str) {
        if (!this.f3001h) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.f3000g = true;
        this.f3002i = str;
        return this;
    }

    public abstract int h();

    public abstract int i();

    public abstract void j();

    public abstract void k();

    public f0 l() {
        if (this.f3000g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f3001h = false;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i10, Fragment fragment, String str, int i11) {
        String str2 = fragment.U;
        if (str2 != null) {
            e0.d.h(fragment, str2);
        }
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = fragment.E;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.E + " now " + str);
            }
            fragment.E = str;
        }
        if (i10 != 0) {
            if (i10 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i12 = fragment.C;
            if (i12 != 0 && i12 != i10) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.C + " now " + i10);
            }
            fragment.C = i10;
            fragment.D = i10;
        }
        f(new a(i11, fragment));
    }

    public f0 n(Fragment fragment) {
        f(new a(3, fragment));
        return this;
    }

    public f0 o(int i10, Fragment fragment) {
        return p(i10, fragment, null);
    }

    public f0 p(int i10, Fragment fragment, String str) {
        if (i10 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m(i10, fragment, str, 2);
        return this;
    }

    public f0 q(int i10, int i11) {
        return r(i10, i11, 0, 0);
    }

    public f0 r(int i10, int i11, int i12, int i13) {
        this.f2995b = i10;
        this.f2996c = i11;
        this.f2997d = i12;
        this.f2998e = i13;
        return this;
    }

    public f0 s(boolean z10) {
        this.f3009p = z10;
        return this;
    }
}
