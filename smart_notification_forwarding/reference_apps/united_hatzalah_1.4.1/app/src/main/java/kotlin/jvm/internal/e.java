package kotlin.jvm.internal;

import F2.v;
import F2.w;
import a.AbstractC0228a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import s2.C0679d;
import t2.AbstractC0708j;
import t2.AbstractC0709k;

/* loaded from: classes.dex */
public final class e implements L2.c, d {

    /* renamed from: b, reason: collision with root package name */
    public static final Map f5306b;

    /* renamed from: a, reason: collision with root package name */
    public final Class f5307a;

    static {
        List W3 = AbstractC0708j.W(F2.a.class, F2.l.class, F2.p.class, F2.q.class, F2.r.class, F2.s.class, F2.t.class, F2.u.class, v.class, w.class, F2.b.class, F2.c.class, F2.d.class, F2.e.class, F2.f.class, F2.g.class, F2.h.class, F2.i.class, F2.j.class, F2.k.class, F2.m.class, F2.n.class, F2.o.class);
        ArrayList arrayList = new ArrayList(AbstractC0709k.Y(W3, 10));
        int i = 0;
        for (Object obj : W3) {
            int i3 = i + 1;
            if (i >= 0) {
                arrayList.add(new C0679d((Class) obj, Integer.valueOf(i)));
                i = i3;
            } else {
                AbstractC0708j.X();
                throw null;
            }
        }
        f5306b = t2.u.I(arrayList);
    }

    public e(Class jClass) {
        j.e(jClass, "jClass");
        this.f5307a = jClass;
    }

    @Override // kotlin.jvm.internal.d
    public final Class a() {
        return this.f5307a;
    }

    public final String b() {
        String b4;
        Class jClass = this.f5307a;
        j.e(jClass, "jClass");
        String str = null;
        if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
            return null;
        }
        if (jClass.isArray()) {
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (b4 = u.b(componentType.getName())) != null) {
                str = b4.concat("Array");
            }
            if (str == null) {
                return "kotlin.Array";
            }
            return str;
        }
        String b5 = u.b(jClass.getName());
        if (b5 == null) {
            return jClass.getCanonicalName();
        }
        return b5;
    }

    public final String c() {
        String d2;
        Class jClass = this.f5307a;
        j.e(jClass, "jClass");
        String str = null;
        if (jClass.isAnonymousClass()) {
            return null;
        }
        if (jClass.isLocalClass()) {
            String simpleName = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return N2.f.c0(simpleName, enclosingMethod.getName() + '$', simpleName);
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor != null) {
                return N2.f.c0(simpleName, enclosingConstructor.getName() + '$', simpleName);
            }
            int indexOf = simpleName.indexOf(36, 0);
            if (indexOf == -1) {
                return simpleName;
            }
            String substring = simpleName.substring(indexOf + 1, simpleName.length());
            j.d(substring, "substring(...)");
            return substring;
        }
        if (jClass.isArray()) {
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive() && (d2 = u.d(componentType.getName())) != null) {
                str = d2.concat("Array");
            }
            if (str == null) {
                return "Array";
            }
            return str;
        }
        String d4 = u.d(jClass.getName());
        if (d4 == null) {
            return jClass.getSimpleName();
        }
        return d4;
    }

    public final boolean d(Object obj) {
        Class jClass = this.f5307a;
        j.e(jClass, "jClass");
        Map map = f5306b;
        j.c(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
        Integer num = (Integer) map.get(jClass);
        if (num != null) {
            return u.c(num.intValue(), obj);
        }
        if (jClass.isPrimitive()) {
            jClass = AbstractC0228a.t(s.a(jClass));
        }
        return jClass.isInstance(obj);
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof e) && AbstractC0228a.t(this).equals(AbstractC0228a.t((L2.c) obj))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC0228a.t(this).hashCode();
    }

    public final String toString() {
        return this.f5307a.toString() + " (Kotlin reflection is not available)";
    }
}
