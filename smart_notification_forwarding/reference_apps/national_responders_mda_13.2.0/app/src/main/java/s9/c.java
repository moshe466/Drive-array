package s9;

import ca.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import s9.d;

/* loaded from: classes.dex */
public final class c extends n implements ca.a {

    /* renamed from: a, reason: collision with root package name */
    private final Annotation f14152a;

    public c(Annotation annotation) {
        y8.k.e(annotation, "annotation");
        this.f14152a = annotation;
    }

    @Override // ca.a
    public Collection<ca.b> G() {
        Method[] declaredMethods = w8.a.b(w8.a.a(this.f14152a)).getDeclaredMethods();
        y8.k.d(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            d.a aVar = d.f14153b;
            Object invoke = method.invoke(Z(), new Object[0]);
            y8.k.d(invoke, "method.invoke(annotation)");
            arrayList.add(aVar.a(invoke, la.e.r(method.getName())));
        }
        return arrayList;
    }

    @Override // ca.a
    public boolean U() {
        return a.C0080a.a(this);
    }

    public final Annotation Z() {
        return this.f14152a;
    }

    @Override // ca.a
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public j k() {
        return new j(w8.a.b(w8.a.a(this.f14152a)));
    }

    @Override // ca.a
    public la.a d() {
        return b.b(w8.a.b(w8.a.a(this.f14152a)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && y8.k.a(this.f14152a, ((c) obj).f14152a);
    }

    public int hashCode() {
        return this.f14152a.hashCode();
    }

    @Override // ca.a
    public boolean j() {
        return a.C0080a.b(this);
    }

    public String toString() {
        return c.class.getName() + ": " + this.f14152a;
    }
}
