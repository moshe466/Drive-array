package a2;

import a2.a;
import a2.a.d;
import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b2.e;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.c0;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.common.api.internal.l1;
import com.google.android.gms.common.api.internal.m2;
import com.google.android.gms.common.api.internal.q1;
import com.google.android.gms.common.api.internal.u;
import com.google.android.gms.common.api.internal.v;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

/* loaded from: classes.dex */
public abstract class e<O extends a.d> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f56a;

    /* renamed from: b, reason: collision with root package name */
    private final String f57b;

    /* renamed from: c, reason: collision with root package name */
    private final a2.a f58c;

    /* renamed from: d, reason: collision with root package name */
    private final a.d f59d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.android.gms.common.api.internal.b f60e;

    /* renamed from: f, reason: collision with root package name */
    private final Looper f61f;

    /* renamed from: g, reason: collision with root package name */
    private final int f62g;

    /* renamed from: h, reason: collision with root package name */
    private final u f63h;

    /* renamed from: i, reason: collision with root package name */
    protected final com.google.android.gms.common.api.internal.g f64i;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        public static final a f65c = new C0008a().a();

        /* renamed from: a, reason: collision with root package name */
        public final u f66a;

        /* renamed from: b, reason: collision with root package name */
        public final Looper f67b;

        /* renamed from: a2.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0008a {

            /* renamed from: a, reason: collision with root package name */
            private u f68a;

            /* renamed from: b, reason: collision with root package name */
            private Looper f69b;

            /* JADX WARN: Multi-variable type inference failed */
            public a a() {
                if (this.f68a == null) {
                    this.f68a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.f69b == null) {
                    this.f69b = Looper.getMainLooper();
                }
                return new a(this.f68a, this.f69b);
            }
        }

        private a(u uVar, Account account, Looper looper) {
            this.f66a = uVar;
            this.f67b = looper;
        }
    }

    public e(Context context, a2.a<O> aVar, O o10, a aVar2) {
        this(context, null, aVar, o10, aVar2);
    }

    private e(Context context, Activity activity, a2.a aVar, a.d dVar, a aVar2) {
        b2.p.l(context, "Null context is not permitted.");
        b2.p.l(aVar, "Api must not be null.");
        b2.p.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f56a = context.getApplicationContext();
        String str = null;
        if (g2.l.k()) {
            try {
                str = (String) Context.class.getMethod("getAttributionTag", new Class[0]).invoke(context, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        this.f57b = str;
        this.f58c = aVar;
        this.f59d = dVar;
        this.f61f = aVar2.f67b;
        com.google.android.gms.common.api.internal.b a10 = com.google.android.gms.common.api.internal.b.a(aVar, dVar, str);
        this.f60e = a10;
        new q1(this);
        com.google.android.gms.common.api.internal.g x10 = com.google.android.gms.common.api.internal.g.x(this.f56a);
        this.f64i = x10;
        this.f62g = x10.m();
        this.f63h = aVar2.f66a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            c0.u(activity, x10, a10);
        }
        x10.b(this);
    }

    private final com.google.android.gms.common.api.internal.d v(int i10, com.google.android.gms.common.api.internal.d dVar) {
        dVar.l();
        this.f64i.F(this, i10, dVar);
        return dVar;
    }

    private final z2.l w(int i10, v vVar) {
        z2.m mVar = new z2.m();
        this.f64i.G(this, i10, vVar, mVar, this.f63h);
        return mVar.a();
    }

    protected e.a i() {
        Account a10;
        GoogleSignInAccount b10;
        GoogleSignInAccount b11;
        e.a aVar = new e.a();
        a.d dVar = this.f59d;
        if (!(dVar instanceof a.d.b) || (b11 = ((a.d.b) dVar).b()) == null) {
            a.d dVar2 = this.f59d;
            a10 = dVar2 instanceof a.d.InterfaceC0007a ? ((a.d.InterfaceC0007a) dVar2).a() : null;
        } else {
            a10 = b11.g();
        }
        aVar.d(a10);
        a.d dVar3 = this.f59d;
        aVar.c((!(dVar3 instanceof a.d.b) || (b10 = ((a.d.b) dVar3).b()) == null) ? Collections.emptySet() : b10.x());
        aVar.e(this.f56a.getClass().getName());
        aVar.b(this.f56a.getPackageName());
        return aVar;
    }

    public <TResult, A extends a.b> z2.l<TResult> j(v<A, TResult> vVar) {
        return w(2, vVar);
    }

    public <TResult, A extends a.b> z2.l<TResult> k(v<A, TResult> vVar) {
        return w(0, vVar);
    }

    public <A extends a.b> z2.l<Void> l(com.google.android.gms.common.api.internal.q<A, ?> qVar) {
        b2.p.k(qVar);
        b2.p.l(qVar.f4957a.b(), "Listener has already been released.");
        b2.p.l(qVar.f4958b.a(), "Listener has already been released.");
        return this.f64i.z(this, qVar.f4957a, qVar.f4958b, qVar.f4959c);
    }

    public z2.l<Boolean> m(l.a<?> aVar, int i10) {
        b2.p.l(aVar, "Listener key cannot be null.");
        return this.f64i.A(this, aVar, i10);
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.d<? extends j, A>> T n(T t10) {
        v(1, t10);
        return t10;
    }

    public <TResult, A extends a.b> z2.l<TResult> o(v<A, TResult> vVar) {
        return w(1, vVar);
    }

    public final com.google.android.gms.common.api.internal.b<O> p() {
        return this.f60e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String q() {
        return this.f57b;
    }

    public Looper r() {
        return this.f61f;
    }

    public final int s() {
        return this.f62g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final a.f t(Looper looper, l1 l1Var) {
        a.f c10 = ((a.AbstractC0006a) b2.p.k(this.f58c.a())).c(this.f56a, looper, i().a(), this.f59d, l1Var, l1Var);
        String q10 = q();
        if (q10 != null && (c10 instanceof b2.c)) {
            ((b2.c) c10).U(q10);
        }
        if (q10 != null && (c10 instanceof com.google.android.gms.common.api.internal.n)) {
            ((com.google.android.gms.common.api.internal.n) c10).w(q10);
        }
        return c10;
    }

    public final m2 u(Context context, Handler handler) {
        return new m2(context, handler, i().a());
    }
}
