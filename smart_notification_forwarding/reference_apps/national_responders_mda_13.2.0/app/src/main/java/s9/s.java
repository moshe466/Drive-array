package s9;

import ca.a0;
import ca.r;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import s9.w;

/* loaded from: classes.dex */
public final class s extends r implements ca.r {

    /* renamed from: a, reason: collision with root package name */
    private final Method f14177a;

    public s(Method method) {
        y8.k.e(method, "member");
        this.f14177a = method;
    }

    @Override // ca.r
    public ca.b F() {
        Object defaultValue = c0().getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return d.f14153b.a(defaultValue, null);
    }

    @Override // ca.r
    public boolean N() {
        return r.a.a(this);
    }

    @Override // s9.r
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public Method c0() {
        return this.f14177a;
    }

    @Override // ca.r
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public w i() {
        w.a aVar = w.f14182a;
        Type genericReturnType = c0().getGenericReturnType();
        y8.k.d(genericReturnType, "member.genericReturnType");
        return aVar.a(genericReturnType);
    }

    @Override // ca.r
    public List<a0> l() {
        Type[] genericParameterTypes = c0().getGenericParameterTypes();
        y8.k.d(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = c0().getParameterAnnotations();
        y8.k.d(parameterAnnotations, "member.parameterAnnotations");
        return d0(genericParameterTypes, parameterAnnotations, c0().isVarArgs());
    }

    @Override // ca.z
    public List<x> m() {
        TypeVariable<Method>[] typeParameters = c0().getTypeParameters();
        y8.k.d(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new x(typeVariable));
        }
        return arrayList;
    }
}
