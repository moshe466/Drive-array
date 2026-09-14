package s9;

import ca.a0;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class m extends r implements ca.k {

    /* renamed from: a, reason: collision with root package name */
    private final Constructor<?> f14173a;

    public m(Constructor<?> constructor) {
        y8.k.e(constructor, "member");
        this.f14173a = constructor;
    }

    @Override // s9.r
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public Constructor<?> c0() {
        return this.f14173a;
    }

    @Override // ca.k
    public List<a0> l() {
        List<a0> d10;
        Type[] genericParameterTypes = c0().getGenericParameterTypes();
        y8.k.d(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            d10 = m8.q.d();
            return d10;
        }
        Class<?> declaringClass = c0().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) m8.g.f(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = c0().getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
            throw new IllegalStateException(y8.k.j("Illegal generic signature: ", c0()));
        }
        if (parameterAnnotations.length > genericParameterTypes.length) {
            y8.k.d(parameterAnnotations, "annotations");
            parameterAnnotations = (Annotation[][]) m8.g.f(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
        }
        y8.k.d(genericParameterTypes, "realTypes");
        y8.k.d(parameterAnnotations, "realAnnotations");
        return d0(genericParameterTypes, parameterAnnotations, c0().isVarArgs());
    }

    @Override // ca.z
    public List<x> m() {
        TypeVariable<Constructor<?>>[] typeParameters = c0().getTypeParameters();
        y8.k.d(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new x(typeVariable));
        }
        return arrayList;
    }
}
