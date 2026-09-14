package androidx.lifecycle;

import android.os.Looper;
import java.util.Map;
import n.C0590a;

/* loaded from: classes.dex */
public abstract class A {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f3539k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f3540a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final o.f f3541b = new o.f();

    /* renamed from: c, reason: collision with root package name */
    public int f3542c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3543d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f3544e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f3545f;

    /* renamed from: g, reason: collision with root package name */
    public int f3546g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3547h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final G.a f3548j;

    public A() {
        Object obj = f3539k;
        this.f3545f = obj;
        this.f3548j = new G.a(this, 2);
        this.f3544e = obj;
        this.f3546g = -1;
    }

    public static void a(String str) {
        C0590a.B().f5875b.getClass();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
        } else {
            throw new IllegalStateException(e0.a.e("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(AbstractC0315z abstractC0315z) {
        if (abstractC0315z.f3629b) {
            if (!abstractC0315z.e()) {
                abstractC0315z.b(false);
                return;
            }
            int i = abstractC0315z.f3630c;
            int i3 = this.f3546g;
            if (i >= i3) {
                return;
            }
            abstractC0315z.f3630c = i3;
            abstractC0315z.f3628a.g(this.f3544e);
        }
    }

    public final void c(AbstractC0315z abstractC0315z) {
        if (this.f3547h) {
            this.i = true;
            return;
        }
        this.f3547h = true;
        do {
            this.i = false;
            if (abstractC0315z != null) {
                b(abstractC0315z);
                abstractC0315z = null;
            } else {
                o.f fVar = this.f3541b;
                fVar.getClass();
                o.d dVar = new o.d(fVar);
                fVar.f5908c.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((AbstractC0315z) ((Map.Entry) dVar.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.f3547h = false;
    }

    public final void d(InterfaceC0309t interfaceC0309t, C c4) {
        Object obj;
        a("observe");
        if (((C0311v) interfaceC0309t.getLifecycle()).f3618c != EnumC0304n.f3607a) {
            C0314y c0314y = new C0314y(this, interfaceC0309t, c4);
            o.f fVar = this.f3541b;
            o.c d2 = fVar.d(c4);
            if (d2 != null) {
                obj = d2.f5900b;
            } else {
                o.c cVar = new o.c(c4, c0314y);
                fVar.f5909d++;
                o.c cVar2 = fVar.f5907b;
                if (cVar2 == null) {
                    fVar.f5906a = cVar;
                    fVar.f5907b = cVar;
                } else {
                    cVar2.f5901c = cVar;
                    cVar.f5902d = cVar2;
                    fVar.f5907b = cVar;
                }
                obj = null;
            }
            AbstractC0315z abstractC0315z = (AbstractC0315z) obj;
            if (abstractC0315z != null && !abstractC0315z.d(interfaceC0309t)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            }
            if (abstractC0315z != null) {
                return;
            }
            interfaceC0309t.getLifecycle().a(c0314y);
        }
    }

    public void e() {
    }

    public void f() {
    }

    public void g(C c4) {
        a("removeObserver");
        AbstractC0315z abstractC0315z = (AbstractC0315z) this.f3541b.g(c4);
        if (abstractC0315z == null) {
            return;
        }
        abstractC0315z.c();
        abstractC0315z.b(false);
    }

    public abstract void h(Object obj);
}
