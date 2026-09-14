package s9;

import ca.c0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import n9.h1;
import s9.f;
import s9.t;

/* loaded from: classes.dex */
public final class j extends n implements s9.f, t, ca.g {

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f14161a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class a extends y8.i implements x8.l<Member, Boolean> {

        /* renamed from: o, reason: collision with root package name */
        public static final a f14162o = new a();

        a() {
            super(1);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "isSynthetic";
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(Member member) {
            return Boolean.valueOf(n(member));
        }

        @Override // y8.c
        public final e9.d k() {
            return y8.w.b(Member.class);
        }

        @Override // y8.c
        public final String m() {
            return "isSynthetic()Z";
        }

        public final boolean n(Member member) {
            y8.k.e(member, "p0");
            return member.isSynthetic();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class b extends y8.i implements x8.l<Constructor<?>, m> {

        /* renamed from: o, reason: collision with root package name */
        public static final b f14163o = new b();

        b() {
            super(1);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "<init>";
        }

        @Override // y8.c
        public final e9.d k() {
            return y8.w.b(m.class);
        }

        @Override // y8.c
        public final String m() {
            return "<init>(Ljava/lang/reflect/Constructor;)V";
        }

        @Override // x8.l
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final m h(Constructor<?> constructor) {
            y8.k.e(constructor, "p0");
            return new m(constructor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class c extends y8.i implements x8.l<Member, Boolean> {

        /* renamed from: o, reason: collision with root package name */
        public static final c f14164o = new c();

        c() {
            super(1);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "isSynthetic";
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(Member member) {
            return Boolean.valueOf(n(member));
        }

        @Override // y8.c
        public final e9.d k() {
            return y8.w.b(Member.class);
        }

        @Override // y8.c
        public final String m() {
            return "isSynthetic()Z";
        }

        public final boolean n(Member member) {
            y8.k.e(member, "p0");
            return member.isSynthetic();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class d extends y8.i implements x8.l<Field, p> {

        /* renamed from: o, reason: collision with root package name */
        public static final d f14165o = new d();

        d() {
            super(1);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "<init>";
        }

        @Override // y8.c
        public final e9.d k() {
            return y8.w.b(p.class);
        }

        @Override // y8.c
        public final String m() {
            return "<init>(Ljava/lang/reflect/Field;)V";
        }

        @Override // x8.l
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final p h(Field field) {
            y8.k.e(field, "p0");
            return new p(field);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e extends y8.l implements x8.l<Class<?>, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final e f14166f = new e();

        e() {
            super(1);
        }

        public final boolean a(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            y8.k.d(simpleName, "it.simpleName");
            return simpleName.length() == 0;
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(Class<?> cls) {
            return Boolean.valueOf(a(cls));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f extends y8.l implements x8.l<Class<?>, la.e> {

        /* renamed from: f, reason: collision with root package name */
        public static final f f14167f = new f();

        f() {
            super(1);
        }

        @Override // x8.l
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la.e h(Class<?> cls) {
            String simpleName = cls.getSimpleName();
            if (!la.e.t(simpleName)) {
                simpleName = null;
            }
            if (simpleName == null) {
                return null;
            }
            return la.e.r(simpleName);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class g extends y8.l implements x8.l<Method, Boolean> {
        g() {
            super(1);
        }

        public final boolean a(Method method) {
            if (!method.isSynthetic()) {
                if (!j.this.s()) {
                    return true;
                }
                j jVar = j.this;
                y8.k.d(method, "method");
                if (!jVar.i0(method)) {
                    return true;
                }
            }
            return false;
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(Method method) {
            return Boolean.valueOf(a(method));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class h extends y8.i implements x8.l<Method, s> {

        /* renamed from: o, reason: collision with root package name */
        public static final h f14169o = new h();

        h() {
            super(1);
        }

        @Override // y8.c, e9.a
        public final String c() {
            return "<init>";
        }

        @Override // y8.c
        public final e9.d k() {
            return y8.w.b(s.class);
        }

        @Override // y8.c
        public final String m() {
            return "<init>(Ljava/lang/reflect/Method;)V";
        }

        @Override // x8.l
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final s h(Method method) {
            y8.k.e(method, "p0");
            return new s(method);
        }
    }

    public j(Class<?> cls) {
        y8.k.e(cls, "klass");
        this.f14161a = cls;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i0(Method method) {
        String name = method.getName();
        if (y8.k.a(name, "values")) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            y8.k.d(parameterTypes, "method.parameterTypes");
            if (parameterTypes.length == 0) {
                return true;
            }
        } else if (y8.k.a(name, "valueOf")) {
            return Arrays.equals(method.getParameterTypes(), new Class[]{String.class});
        }
        return false;
    }

    @Override // ca.s
    public boolean B() {
        return t.a.c(this);
    }

    @Override // ca.g
    public boolean E() {
        return this.f14161a.isAnnotation();
    }

    @Override // ca.g
    public boolean H() {
        return this.f14161a.isInterface();
    }

    @Override // ca.s
    public boolean I() {
        return t.a.b(this);
    }

    @Override // ca.g
    public c0 J() {
        return null;
    }

    @Override // ca.g
    public boolean L() {
        return false;
    }

    @Override // ca.g
    public boolean P() {
        return false;
    }

    @Override // ca.g
    public Collection<ca.j> Q() {
        List d10;
        d10 = m8.q.d();
        return d10;
    }

    @Override // ca.s
    public boolean Y() {
        return t.a.d(this);
    }

    @Override // ca.d
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public s9.c e(la.b bVar) {
        return f.a.a(this, bVar);
    }

    @Override // ca.d
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public List<s9.c> u() {
        return f.a.b(this);
    }

    @Override // ca.t
    public la.e c() {
        la.e r10 = la.e.r(this.f14161a.getSimpleName());
        y8.k.d(r10, "identifier(klass.simpleName)");
        return r10;
    }

    @Override // ca.g
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public List<m> q() {
        lb.h k10;
        lb.h m10;
        lb.h q10;
        List<m> w10;
        Constructor<?>[] declaredConstructors = this.f14161a.getDeclaredConstructors();
        y8.k.d(declaredConstructors, "klass.declaredConstructors");
        k10 = m8.k.k(declaredConstructors);
        m10 = lb.n.m(k10, a.f14162o);
        q10 = lb.n.q(m10, b.f14163o);
        w10 = lb.n.w(q10);
        return w10;
    }

    @Override // s9.f
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public Class<?> V() {
        return this.f14161a;
    }

    @Override // ca.g
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public List<p> w() {
        lb.h k10;
        lb.h m10;
        lb.h q10;
        List<p> w10;
        Field[] declaredFields = this.f14161a.getDeclaredFields();
        y8.k.d(declaredFields, "klass.declaredFields");
        k10 = m8.k.k(declaredFields);
        m10 = lb.n.m(k10, c.f14164o);
        q10 = lb.n.q(m10, d.f14165o);
        w10 = lb.n.w(q10);
        return w10;
    }

    public boolean equals(Object obj) {
        return (obj instanceof j) && y8.k.a(this.f14161a, ((j) obj).f14161a);
    }

    @Override // ca.g
    public la.b f() {
        la.b b10 = s9.b.b(this.f14161a).b();
        y8.k.d(b10, "klass.classId.asSingleFqName()");
        return b10;
    }

    @Override // ca.g
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public List<la.e> M() {
        lb.h k10;
        lb.h m10;
        lb.h r10;
        List<la.e> w10;
        Class<?>[] declaredClasses = this.f14161a.getDeclaredClasses();
        y8.k.d(declaredClasses, "klass.declaredClasses");
        k10 = m8.k.k(declaredClasses);
        m10 = lb.n.m(k10, e.f14166f);
        r10 = lb.n.r(m10, f.f14167f);
        w10 = lb.n.w(r10);
        return w10;
    }

    @Override // ca.g
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public List<s> O() {
        lb.h k10;
        lb.h l10;
        lb.h q10;
        List<s> w10;
        Method[] declaredMethods = this.f14161a.getDeclaredMethods();
        y8.k.d(declaredMethods, "klass.declaredMethods");
        k10 = m8.k.k(declaredMethods);
        l10 = lb.n.l(k10, new g());
        q10 = lb.n.q(l10, h.f14169o);
        w10 = lb.n.w(q10);
        return w10;
    }

    @Override // ca.s
    public h1 h() {
        return t.a.a(this);
    }

    @Override // ca.g
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public j r() {
        Class<?> declaringClass = this.f14161a.getDeclaringClass();
        if (declaringClass == null) {
            return null;
        }
        return new j(declaringClass);
    }

    public int hashCode() {
        return this.f14161a.hashCode();
    }

    @Override // ca.z
    public List<x> m() {
        TypeVariable<Class<?>>[] typeParameters = this.f14161a.getTypeParameters();
        y8.k.d(typeParameters, "klass.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Class<?>> typeVariable : typeParameters) {
            arrayList.add(new x(typeVariable));
        }
        return arrayList;
    }

    @Override // ca.g
    public boolean s() {
        return this.f14161a.isEnum();
    }

    @Override // ca.g
    public Collection<ca.w> t() {
        List d10;
        d10 = m8.q.d();
        return d10;
    }

    public String toString() {
        return j.class.getName() + ": " + this.f14161a;
    }

    @Override // ca.d
    public boolean v() {
        return f.a.c(this);
    }

    @Override // ca.g
    public Collection<ca.j> x() {
        Class cls;
        List g10;
        int n10;
        List d10;
        cls = Object.class;
        if (y8.k.a(this.f14161a, cls)) {
            d10 = m8.q.d();
            return d10;
        }
        y8.y yVar = new y8.y(2);
        Object genericSuperclass = this.f14161a.getGenericSuperclass();
        yVar.a(genericSuperclass != null ? genericSuperclass : Object.class);
        Type[] genericInterfaces = this.f14161a.getGenericInterfaces();
        y8.k.d(genericInterfaces, "klass.genericInterfaces");
        yVar.b(genericInterfaces);
        g10 = m8.q.g(yVar.d(new Type[yVar.c()]));
        n10 = m8.r.n(g10, 10);
        ArrayList arrayList = new ArrayList(n10);
        Iterator it = g10.iterator();
        while (it.hasNext()) {
            arrayList.add(new l((Type) it.next()));
        }
        return arrayList;
    }

    @Override // s9.t
    public int y() {
        return this.f14161a.getModifiers();
    }

    @Override // ca.g
    public boolean z() {
        return false;
    }
}
