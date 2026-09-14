package com.fasterxml.jackson.module.kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.text.StringsKt;

/* compiled from: KotlinNamesAnnotationIntrospector.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0003\u001a\f\u0010\t\u001a\u00020\u0007*\u00020\nH\u0002\u001a\u001e\u0010\u000b\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002\u001a\u001c\u0010\f\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002¨\u0006\u000f"}, d2 = {"filterOutSingleStringCallables", JsonProperty.USE_DEFAULT_NAME, "Lkotlin/reflect/KFunction;", "propertyNames", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "isInlineClass", JsonProperty.USE_DEFAULT_NAME, "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;", "isKotlinConstructorWithParameters", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;", "isPossibleSingleString", "isPrimaryConstructor", "Lkotlin/reflect/KClass;", "kConstructor", "jackson-module-kotlin"}, k = 2, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class KotlinNamesAnnotationIntrospectorKt {
    @Deprecated(message = "To be removed in 2.14", replaceWith = @ReplaceWith(expression = "with(receiver) { declaringClass.declaredMethods.any { it.name.contains('-') } }", imports = {}))
    private static final boolean isInlineClass(AnnotatedMethod annotatedMethod) {
        Method[] declaredMethods = annotatedMethod.getDeclaringClass().getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "declaringClass.declaredMethods");
        for (Method method : declaredMethods) {
            String name = method.getName();
            Intrinsics.checkNotNullExpressionValue(name, "it.name");
            if (StringsKt.contains$default((CharSequence) name, '-', false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isKotlinConstructorWithParameters(AnnotatedConstructor annotatedConstructor) {
        if (annotatedConstructor.getParameterCount() > 0) {
            Class<?> declaringClass = annotatedConstructor.getDeclaringClass();
            Intrinsics.checkNotNullExpressionValue(declaringClass, "declaringClass");
            if (KotlinModuleKt.isKotlinClass(declaringClass) && !annotatedConstructor.getDeclaringClass().isEnum()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isPossibleSingleString(KFunction<?> kFunction, Set<String> set) {
        Object obj;
        if (kFunction.getParameters().size() != 1 || CollectionsKt.contains(set, kFunction.getParameters().get(0).getName()) || !Intrinsics.areEqual(ReflectJvmMapping.getJavaType(kFunction.getParameters().get(0).getType()), String.class)) {
            return false;
        }
        Iterator<T> it = kFunction.getParameters().get(0).getAnnotations().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Annotation) obj) instanceof JsonProperty) {
                break;
            }
        }
        return !(((JsonProperty) obj) != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Collection<KFunction<?>> filterOutSingleStringCallables(Collection<? extends KFunction<?>> collection, Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (!isPossibleSingleString((KFunction) obj, set)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isPrimaryConstructor(KClass<?> kClass, KFunction<?> kFunction) {
        KFunction primaryConstructor = KClasses.getPrimaryConstructor(kClass);
        if (Intrinsics.areEqual(primaryConstructor, kFunction)) {
            return true;
        }
        return primaryConstructor == null && kClass.getConstructors().size() == 1;
    }
}
