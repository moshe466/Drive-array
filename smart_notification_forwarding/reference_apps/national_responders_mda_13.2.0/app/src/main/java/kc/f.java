package kc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

/* loaded from: classes.dex */
public class f implements ic.b {

    /* renamed from: f, reason: collision with root package name */
    private final String f11342f;

    /* renamed from: g, reason: collision with root package name */
    private volatile ic.b f11343g;

    /* renamed from: h, reason: collision with root package name */
    private Boolean f11344h;

    /* renamed from: i, reason: collision with root package name */
    private Method f11345i;

    /* renamed from: j, reason: collision with root package name */
    private jc.a f11346j;

    /* renamed from: k, reason: collision with root package name */
    private Queue<jc.d> f11347k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f11348l;

    public f(String str, Queue<jc.d> queue, boolean z10) {
        this.f11342f = str;
        this.f11347k = queue;
        this.f11348l = z10;
    }

    private ic.b h() {
        if (this.f11346j == null) {
            this.f11346j = new jc.a(this, this.f11347k);
        }
        return this.f11346j;
    }

    @Override // ic.b
    public void a(String str) {
        g().a(str);
    }

    @Override // ic.b
    public void b(String str, Object... objArr) {
        g().b(str, objArr);
    }

    @Override // ic.b
    public void c(String str, Object obj, Object obj2) {
        g().c(str, obj, obj2);
    }

    @Override // ic.b
    public void d(String str, Throwable th) {
        g().d(str, th);
    }

    @Override // ic.b
    public void e(String str) {
        g().e(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && f.class == obj.getClass() && this.f11342f.equals(((f) obj).f11342f);
    }

    @Override // ic.b
    public void f(String str, Object obj) {
        g().f(str, obj);
    }

    ic.b g() {
        return this.f11343g != null ? this.f11343g : this.f11348l ? c.f11341f : h();
    }

    public int hashCode() {
        return this.f11342f.hashCode();
    }

    public String i() {
        return this.f11342f;
    }

    public boolean j() {
        Boolean bool = this.f11344h;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f11345i = this.f11343g.getClass().getMethod("log", jc.c.class);
            this.f11344h = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f11344h = Boolean.FALSE;
        }
        return this.f11344h.booleanValue();
    }

    public boolean k() {
        return this.f11343g instanceof c;
    }

    public boolean l() {
        return this.f11343g == null;
    }

    public void m(jc.c cVar) {
        if (j()) {
            try {
                this.f11345i.invoke(this.f11343g, cVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public void n(ic.b bVar) {
        this.f11343g = bVar;
    }
}
