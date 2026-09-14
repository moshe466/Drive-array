package p3;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final class e implements n3.b {

    /* renamed from: a, reason: collision with root package name */
    public final String f5978a;

    /* renamed from: b, reason: collision with root package name */
    public volatile n3.b f5979b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f5980c;

    /* renamed from: d, reason: collision with root package name */
    public Method f5981d;

    /* renamed from: e, reason: collision with root package name */
    public o3.a f5982e;

    /* renamed from: f, reason: collision with root package name */
    public final Queue f5983f;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f5984j;

    public e(String str, LinkedBlockingQueue linkedBlockingQueue, boolean z3) {
        this.f5978a = str;
        this.f5983f = linkedBlockingQueue;
        this.f5984j = z3;
    }

    @Override // n3.b
    public final void A(String str, Object obj, Serializable serializable) {
        d().A(str, obj, serializable);
    }

    public final boolean B() {
        Boolean bool = this.f5980c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f5981d = this.f5979b.getClass().getMethod("log", o3.b.class);
            this.f5980c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f5980c = Boolean.FALSE;
        }
        return this.f5980c.booleanValue();
    }

    @Override // n3.b
    public final boolean a() {
        return d().a();
    }

    @Override // n3.b
    public final boolean b() {
        return d().b();
    }

    @Override // n3.b
    public final void c(Object obj, Object obj2) {
        d().c(obj, obj2);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [o3.a, java.lang.Object] */
    public final n3.b d() {
        if (this.f5979b != null) {
            return this.f5979b;
        }
        if (this.f5984j) {
            return b.f5973a;
        }
        if (this.f5982e == null) {
            Queue queue = this.f5983f;
            ?? obj = new Object();
            obj.f5953b = this;
            obj.f5952a = this.f5978a;
            obj.f5954c = queue;
            this.f5982e = obj;
        }
        return this.f5982e;
    }

    @Override // n3.b
    public final void e(String str, Throwable th) {
        d().e(str, th);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass() && this.f5978a.equals(((e) obj).f5978a)) {
            return true;
        }
        return false;
    }

    @Override // n3.b
    public final void f(Object obj, String str) {
        d().f(obj, str);
    }

    @Override // n3.b
    public final boolean g() {
        return d().g();
    }

    @Override // n3.b
    public final String getName() {
        return this.f5978a;
    }

    @Override // n3.b
    public final void h(String str, Object... objArr) {
        d().h(str, objArr);
    }

    public final int hashCode() {
        return this.f5978a.hashCode();
    }

    @Override // n3.b
    public final boolean i() {
        return d().i();
    }

    @Override // n3.b
    public final void j(String str) {
        d().j(str);
    }

    @Override // n3.b
    public final boolean k() {
        return d().k();
    }

    @Override // n3.b
    public final void l(String str, Integer num) {
        d().l(str, num);
    }

    @Override // n3.b
    public final void m(String str, Object obj, Serializable serializable) {
        d().m(str, obj, serializable);
    }

    @Override // n3.b
    public final void n(String str, Object... objArr) {
        d().n(str, objArr);
    }

    @Override // n3.b
    public final void o(Object... objArr) {
        d().o(objArr);
    }

    @Override // n3.b
    public final void p(String str, Throwable th) {
        d().p(str, th);
    }

    @Override // n3.b
    public final void q(Object obj, String str) {
        d().q(obj, str);
    }

    @Override // n3.b
    public final void r(Object obj, String str, Object obj2) {
        d().r(obj, str, obj2);
    }

    @Override // n3.b
    public final void s(String str, Throwable th) {
        d().s(str, th);
    }

    @Override // n3.b
    public final void t(String str) {
        d().t(str);
    }

    @Override // n3.b
    public final void u(String str) {
        d().u(str);
    }

    @Override // n3.b
    public final void v(String str) {
        d().v(str);
    }

    @Override // n3.b
    public final boolean w(int i) {
        return d().w(i);
    }

    @Override // n3.b
    public final void x(Object obj, String str) {
        d().x(obj, str);
    }

    @Override // n3.b
    public final void y(Object obj, String str, Object obj2) {
        d().y(obj, str, obj2);
    }

    @Override // n3.b
    public final void z(String str, Integer num) {
        d().z(str, num);
    }
}
