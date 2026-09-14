package a2;

import a2.a;
import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.b3;
import com.google.android.gms.common.api.internal.k3;
import com.google.android.gms.common.api.internal.s2;
import com.google.android.gms.common.api.internal.z0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    private static final Set f70a = Collections.newSetFromMap(new WeakHashMap());

    @Deprecated
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Account f71a;

        /* renamed from: d, reason: collision with root package name */
        private int f74d;

        /* renamed from: e, reason: collision with root package name */
        private View f75e;

        /* renamed from: f, reason: collision with root package name */
        private String f76f;

        /* renamed from: g, reason: collision with root package name */
        private String f77g;

        /* renamed from: i, reason: collision with root package name */
        private final Context f79i;

        /* renamed from: k, reason: collision with root package name */
        private com.google.android.gms.common.api.internal.j f81k;

        /* renamed from: m, reason: collision with root package name */
        private c f83m;

        /* renamed from: n, reason: collision with root package name */
        private Looper f84n;

        /* renamed from: b, reason: collision with root package name */
        private final Set f72b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        private final Set f73c = new HashSet();

        /* renamed from: h, reason: collision with root package name */
        private final Map f78h = new l.a();

        /* renamed from: j, reason: collision with root package name */
        private final Map f80j = new l.a();

        /* renamed from: l, reason: collision with root package name */
        private int f82l = -1;

        /* renamed from: o, reason: collision with root package name */
        private com.google.android.gms.common.b f85o = com.google.android.gms.common.b.p();

        /* renamed from: p, reason: collision with root package name */
        private a.AbstractC0006a f86p = w2.e.f14903c;

        /* renamed from: q, reason: collision with root package name */
        private final ArrayList f87q = new ArrayList();

        /* renamed from: r, reason: collision with root package name */
        private final ArrayList f88r = new ArrayList();

        public a(Context context) {
            this.f79i = context;
            this.f84n = context.getMainLooper();
            this.f76f = context.getPackageName();
            this.f77g = context.getClass().getName();
        }

        public a a(a2.a<Object> aVar) {
            b2.p.l(aVar, "Api must not be null");
            this.f80j.put(aVar, null);
            List<Scope> a10 = ((a.e) b2.p.l(aVar.c(), "Base client builder must not be null")).a(null);
            this.f73c.addAll(a10);
            this.f72b.addAll(a10);
            return this;
        }

        public a b(b bVar) {
            b2.p.l(bVar, "Listener must not be null");
            this.f87q.add(bVar);
            return this;
        }

        public a c(c cVar) {
            b2.p.l(cVar, "Listener must not be null");
            this.f88r.add(cVar);
            return this;
        }

        public f d() {
            b2.p.b(!this.f80j.isEmpty(), "must call addApi() to add at least one API");
            b2.e e10 = e();
            Map i10 = e10.i();
            l.a aVar = new l.a();
            l.a aVar2 = new l.a();
            ArrayList arrayList = new ArrayList();
            a2.a aVar3 = null;
            boolean z10 = false;
            for (a2.a aVar4 : this.f80j.keySet()) {
                Object obj = this.f80j.get(aVar4);
                boolean z11 = i10.get(aVar4) != null;
                aVar.put(aVar4, Boolean.valueOf(z11));
                k3 k3Var = new k3(aVar4, z11);
                arrayList.add(k3Var);
                a.AbstractC0006a abstractC0006a = (a.AbstractC0006a) b2.p.k(aVar4.a());
                a.f c10 = abstractC0006a.c(this.f79i, this.f84n, e10, obj, k3Var, k3Var);
                aVar2.put(aVar4.b(), c10);
                if (abstractC0006a.b() == 1) {
                    z10 = obj != null;
                }
                if (c10.b()) {
                    if (aVar3 != null) {
                        throw new IllegalStateException(aVar4.d() + " cannot be used with " + aVar3.d());
                    }
                    aVar3 = aVar4;
                }
            }
            if (aVar3 != null) {
                if (z10) {
                    throw new IllegalStateException("With using " + aVar3.d() + ", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                }
                b2.p.p(this.f71a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", aVar3.d());
                b2.p.p(this.f72b.equals(this.f73c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", aVar3.d());
            }
            z0 z0Var = new z0(this.f79i, new ReentrantLock(), this.f84n, e10, this.f85o, this.f86p, aVar, this.f87q, this.f88r, aVar2, this.f82l, z0.n(aVar2.values(), true), arrayList);
            synchronized (f.f70a) {
                f.f70a.add(z0Var);
            }
            if (this.f82l >= 0) {
                b3.t(this.f81k).u(this.f82l, z0Var, this.f83m);
            }
            return z0Var;
        }

        public final b2.e e() {
            w2.a aVar = w2.a.f14891k;
            Map map = this.f80j;
            a2.a aVar2 = w2.e.f14905e;
            if (map.containsKey(aVar2)) {
                aVar = (w2.a) this.f80j.get(aVar2);
            }
            return new b2.e(this.f71a, this.f72b, this.f78h, this.f74d, this.f75e, this.f76f, this.f77g, aVar, false);
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface b extends com.google.android.gms.common.api.internal.f {
    }

    @Deprecated
    /* loaded from: classes.dex */
    public interface c extends com.google.android.gms.common.api.internal.o {
    }

    public abstract void d();

    public abstract void e();

    public abstract void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends j, A>> T g(T t10) {
        throw new UnsupportedOperationException();
    }

    public Looper h() {
        throw new UnsupportedOperationException();
    }

    public abstract void i(c cVar);

    public abstract void j(c cVar);

    public void k(s2 s2Var) {
        throw new UnsupportedOperationException();
    }
}
