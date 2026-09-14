package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Beta
/* loaded from: classes2.dex */
public abstract class Invokable<T, R> extends Element implements GenericDeclaration {

    /* loaded from: classes2.dex */
    static class ConstructorInvokable<T> extends Invokable<T, T> {
        final Constructor<?> a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConstructorInvokable(Constructor<?> constructor) {
            super(constructor);
            this.a = constructor;
        }

        private boolean mayNeedHiddenThis() {
            Class<?> declaringClass = this.a.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            return declaringClass.getEnclosingMethod() != null ? !Modifier.isStatic(r1.getModifiers()) : (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }

        @Override // com.google.common.reflect.Invokable
        final Object a(@NullableDecl Object obj, Object[] objArr) {
            try {
                return this.a.newInstance(objArr);
            } catch (InstantiationException e) {
                throw new RuntimeException(this.a + " failed.", e);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type[] a() {
            return this.a.getGenericExceptionTypes();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type[] b() {
            Type[] genericParameterTypes = this.a.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !mayNeedHiddenThis()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.a.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type c() {
            Class<? super T> declaringClass = getDeclaringClass();
            TypeVariable<Class<? super T>>[] typeParameters = declaringClass.getTypeParameters();
            return typeParameters.length > 0 ? Types.a(declaringClass, typeParameters) : declaringClass;
        }

        @Override // com.google.common.reflect.Invokable
        final Annotation[][] d() {
            return this.a.getParameterAnnotations();
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.a.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return false;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.a.isVarArgs();
        }
    }

    /* loaded from: classes2.dex */
    static class MethodInvokable<T> extends Invokable<T, Object> {
        final Method a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public MethodInvokable(Method method) {
            super(method);
            this.a = method;
        }

        @Override // com.google.common.reflect.Invokable
        final Object a(@NullableDecl Object obj, Object[] objArr) {
            return this.a.invoke(obj, objArr);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type[] a() {
            return this.a.getGenericExceptionTypes();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type[] b() {
            return this.a.getGenericParameterTypes();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.reflect.Invokable
        public Type c() {
            return this.a.getGenericReturnType();
        }

        @Override // com.google.common.reflect.Invokable
        final Annotation[][] d() {
            return this.a.getParameterAnnotations();
        }

        @Override // java.lang.reflect.GenericDeclaration
        public final TypeVariable<?>[] getTypeParameters() {
            return this.a.getTypeParameters();
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return (isFinal() || isPrivate() || isStatic() || Modifier.isFinal(getDeclaringClass().getModifiers())) ? false : true;
        }

        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.a.isVarArgs();
        }
    }

    <M extends AccessibleObject & Member> Invokable(M m) {
        super(m);
    }

    public static <T> Invokable<T, T> from(Constructor<T> constructor) {
        return new ConstructorInvokable(constructor);
    }

    public static Invokable<?, Object> from(Method method) {
        return new MethodInvokable(method);
    }

    abstract Object a(@NullableDecl Object obj, Object[] objArr);

    abstract Type[] a();

    abstract Type[] b();

    abstract Type c();

    abstract Annotation[][] d();

    @Override // com.google.common.reflect.Element
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.reflect.Element, java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) super.getDeclaringClass();
    }

    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : a()) {
            builder.add((ImmutableList.Builder) TypeToken.of(type));
        }
        return builder.build();
    }

    @Override // com.google.common.reflect.Element
    public TypeToken<T> getOwnerType() {
        return TypeToken.of((Class) getDeclaringClass());
    }

    public final ImmutableList<Parameter> getParameters() {
        Type[] b = b();
        Annotation[][] d = d();
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < b.length; i++) {
            builder.add((ImmutableList.Builder) new Parameter(this, i, TypeToken.of(b[i]), d[i]));
        }
        return builder.build();
    }

    public final TypeToken<? extends R> getReturnType() {
        return (TypeToken<? extends R>) TypeToken.of(c());
    }

    @Override // com.google.common.reflect.Element
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @CanIgnoreReturnValue
    public final R invoke(@NullableDecl T t, Object... objArr) {
        return (R) a(t, (Object[]) Preconditions.checkNotNull(objArr));
    }

    public abstract boolean isOverridable();

    public abstract boolean isVarArgs();

    /* JADX WARN: Multi-variable type inference failed */
    public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> typeToken) {
        if (typeToken.isSupertypeOf(getReturnType())) {
            return this;
        }
        throw new IllegalArgumentException("Invokable is known to return " + getReturnType() + ", not " + typeToken);
    }

    public final <R1 extends R> Invokable<T, R1> returning(Class<R1> cls) {
        return returning(TypeToken.of((Class) cls));
    }

    @Override // com.google.common.reflect.Element
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
