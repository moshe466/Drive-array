package w0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.jvm.internal.j;
import s2.C0684i;

/* renamed from: w0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0747c implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    public final kotlin.jvm.internal.e f6686a;

    /* renamed from: b, reason: collision with root package name */
    public final B0.b f6687b;

    public C0747c(kotlin.jvm.internal.e eVar, B0.b bVar) {
        this.f6686a = eVar;
        this.f6687b = bVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        j.e(obj, "obj");
        j.e(method, "method");
        boolean a2 = j.a(method.getName(), "accept");
        B0.b bVar = this.f6687b;
        boolean z3 = false;
        if (a2 && objArr != null && objArr.length == 1) {
            Object obj2 = objArr[0];
            kotlin.jvm.internal.e eVar = this.f6686a;
            if (eVar.d(obj2)) {
                j.c(obj2, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
                bVar.invoke(obj2);
                return C0684i.f6340a;
            }
            throw new ClassCastException("Value cannot be cast to " + eVar.b());
        }
        if (j.a(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE) && objArr != null && objArr.length == 1) {
            if (obj == objArr[0]) {
                z3 = true;
            }
            return Boolean.valueOf(z3);
        }
        if (j.a(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null) {
            return Integer.valueOf(bVar.hashCode());
        }
        if (j.a(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null) {
            return bVar.toString();
        }
        throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
    }
}
