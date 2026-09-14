package com.fasterxml.jackson.module.kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.fasterxml.jackson.databind.util.BeanUtil;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* compiled from: KotlinNamesAnnotationIntrospector.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007¢\u0006\u0002\u0010\tJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0018H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020 H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020!H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/KotlinNamesAnnotationIntrospector;", "Lcom/fasterxml/jackson/databind/introspect/NopAnnotationIntrospector;", "module", "Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "cache", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "ignoredClassesForImplyingJsonCreator", JsonProperty.USE_DEFAULT_NAME, "Lkotlin/reflect/KClass;", "(Lcom/fasterxml/jackson/module/kotlin/KotlinModule;Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;Ljava/util/Set;)V", "getCache", "()Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", "getIgnoredClassesForImplyingJsonCreator", "()Ljava/util/Set;", "getModule", "()Lcom/fasterxml/jackson/module/kotlin/KotlinModule;", "findImplicitPropertyName", JsonProperty.USE_DEFAULT_NAME, "member", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;", "findKotlinParameterName", "param", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedParameter;", "findRenameByField", "Lcom/fasterxml/jackson/databind/PropertyName;", "config", "Lcom/fasterxml/jackson/databind/cfg/MapperConfig;", "field", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedField;", "implName", "hasCreatorAnnotation", JsonProperty.USE_DEFAULT_NAME, "Lcom/fasterxml/jackson/databind/introspect/Annotated;", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class KotlinNamesAnnotationIntrospector extends NopAnnotationIntrospector {
    private final ReflectionCache cache;
    private final Set<KClass<?>> ignoredClassesForImplyingJsonCreator;
    private final KotlinModule module;

    /* JADX WARN: Multi-variable type inference failed */
    public KotlinNamesAnnotationIntrospector(KotlinModule module, ReflectionCache cache, Set<? extends KClass<?>> ignoredClassesForImplyingJsonCreator) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(ignoredClassesForImplyingJsonCreator, "ignoredClassesForImplyingJsonCreator");
        this.module = module;
        this.cache = cache;
        this.ignoredClassesForImplyingJsonCreator = ignoredClassesForImplyingJsonCreator;
    }

    public final ReflectionCache getCache() {
        return this.cache;
    }

    public final Set<KClass<?>> getIgnoredClassesForImplyingJsonCreator() {
        return this.ignoredClassesForImplyingJsonCreator;
    }

    public final KotlinModule getModule() {
        return this.module;
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public String findImplicitPropertyName(AnnotatedMember member) {
        String str;
        Intrinsics.checkNotNullParameter(member, "member");
        if (!(member instanceof AnnotatedMethod)) {
            if (member instanceof AnnotatedParameter) {
                return findKotlinParameterName((AnnotatedParameter) member);
            }
            return null;
        }
        AnnotatedMethod annotatedMethod = (AnnotatedMethod) member;
        String name = annotatedMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name, "member.name");
        if (!StringsKt.contains$default((CharSequence) name, '-', false, 2, (Object) null) || annotatedMethod.getParameterCount() != 0) {
            return null;
        }
        String name2 = annotatedMethod.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "member.name");
        if (StringsKt.startsWith$default(name2, "get", false, 2, (Object) null)) {
            String name3 = annotatedMethod.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "member.name");
            str = StringsKt.substringAfter$default(name3, "get", (String) null, 2, (Object) null);
        } else {
            String name4 = annotatedMethod.getName();
            Intrinsics.checkNotNullExpressionValue(name4, "member.name");
            if (StringsKt.startsWith$default(name4, "is", false, 2, (Object) null)) {
                String name5 = annotatedMethod.getName();
                Intrinsics.checkNotNullExpressionValue(name5, "member.name");
                str = StringsKt.substringAfter$default(name5, "is", (String) null, 2, (Object) null);
            } else {
                str = null;
            }
        }
        if (str == null) {
            return null;
        }
        if (str.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char charAt = str.charAt(0);
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            StringBuilder append = sb.append(CharsKt.lowercase(charAt, locale).toString());
            String substring = str.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            str = append.append(substring).toString();
        }
        if (str == null) {
            return null;
        }
        return StringsKt.substringBefore$default(str, '-', (String) null, 2, (Object) null);
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public PropertyName findRenameByField(MapperConfig<?> config, AnnotatedField field, PropertyName implName) {
        String stdManglePropertyName;
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(field, "field");
        Intrinsics.checkNotNullParameter(implName, "implName");
        String origSimple = implName.getSimpleName();
        Class<?> declaringClass = field.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "field.declaringClass");
        if (KotlinModuleKt.isKotlinClass(declaringClass)) {
            Intrinsics.checkNotNullExpressionValue(origSimple, "origSimple");
            if (StringsKt.startsWith$default(origSimple, "is", false, 2, (Object) null) && (stdManglePropertyName = BeanUtil.stdManglePropertyName(origSimple, 2)) != null && !stdManglePropertyName.equals(origSimple)) {
                return PropertyName.construct(stdManglePropertyName);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[LOOP:1: B:48:0x012e->B:75:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean hasCreatorAnnotation(com.fasterxml.jackson.databind.introspect.AnnotatedConstructor r9) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector.hasCreatorAnnotation(com.fasterxml.jackson.databind.introspect.AnnotatedConstructor):boolean");
    }

    @Override // com.fasterxml.jackson.databind.AnnotationIntrospector
    public boolean hasCreatorAnnotation(Annotated member) {
        boolean isKotlinConstructorWithParameters;
        Intrinsics.checkNotNullParameter(member, "member");
        if (member instanceof AnnotatedConstructor) {
            AnnotatedConstructor annotatedConstructor = (AnnotatedConstructor) member;
            isKotlinConstructorWithParameters = KotlinNamesAnnotationIntrospectorKt.isKotlinConstructorWithParameters(annotatedConstructor);
            if (isKotlinConstructorWithParameters) {
                return this.cache.checkConstructorIsCreatorAnnotated(annotatedConstructor, new Function1<AnnotatedConstructor, Boolean>() { // from class: com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector$hasCreatorAnnotation$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(AnnotatedConstructor it) {
                        boolean hasCreatorAnnotation;
                        Intrinsics.checkNotNullParameter(it, "it");
                        hasCreatorAnnotation = KotlinNamesAnnotationIntrospector.this.hasCreatorAnnotation(it);
                        return Boolean.valueOf(hasCreatorAnnotation);
                    }
                });
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0089 A[Catch: KotlinReflectionInternalError -> 0x00c0, TryCatch #1 {KotlinReflectionInternalError -> 0x00c0, blocks: (B:37:0x0067, B:40:0x0085, B:42:0x0089, B:49:0x00a7, B:53:0x00ae, B:57:0x00b7, B:59:0x00bc, B:61:0x0097, B:64:0x009e, B:65:0x0090, B:66:0x0071, B:69:0x0078, B:72:0x0081), top: B:36:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc A[Catch: KotlinReflectionInternalError -> 0x00c0, TRY_LEAVE, TryCatch #1 {KotlinReflectionInternalError -> 0x00c0, blocks: (B:37:0x0067, B:40:0x0085, B:42:0x0089, B:49:0x00a7, B:53:0x00ae, B:57:0x00b7, B:59:0x00bc, B:61:0x0097, B:64:0x009e, B:65:0x0090, B:66:0x0071, B:69:0x0078, B:72:0x0081), top: B:36:0x0067 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0090 A[Catch: KotlinReflectionInternalError -> 0x00c0, TryCatch #1 {KotlinReflectionInternalError -> 0x00c0, blocks: (B:37:0x0067, B:40:0x0085, B:42:0x0089, B:49:0x00a7, B:53:0x00ae, B:57:0x00b7, B:59:0x00bc, B:61:0x0097, B:64:0x009e, B:65:0x0090, B:66:0x0071, B:69:0x0078, B:72:0x0081), top: B:36:0x0067 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String findKotlinParameterName(com.fasterxml.jackson.databind.introspect.AnnotatedParameter r6) {
        /*
            r5 = this;
            java.lang.Class r0 = r6.getDeclaringClass()
            java.lang.String r1 = "param.declaringClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = com.fasterxml.jackson.module.kotlin.KotlinModuleKt.isKotlinClass(r0)
            r1 = 0
            if (r0 == 0) goto Lc8
            com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r0 = r6.getOwner()
            java.lang.reflect.Member r0 = r0.getMember()
            boolean r2 = r0 instanceof java.lang.reflect.Constructor
            r3 = 0
            if (r2 == 0) goto L63
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            java.lang.Class[] r2 = r0.getParameterTypes()
            int r2 = r2.length
            kotlin.reflect.KFunction r4 = kotlin.reflect.jvm.ReflectJvmMapping.getKotlinFunction(r0)     // Catch: java.lang.Throwable -> L36
            if (r4 != 0) goto L2b
            goto L36
        L2b:
            java.util.List r4 = r4.getParameters()     // Catch: java.lang.Throwable -> L36
            if (r4 != 0) goto L32
            goto L36
        L32:
            int r3 = r4.size()     // Catch: java.lang.Throwable -> L36
        L36:
            if (r3 <= 0) goto L5e
            if (r3 != r2) goto L5e
            kotlin.reflect.KFunction r0 = kotlin.reflect.jvm.ReflectJvmMapping.getKotlinFunction(r0)
            if (r0 != 0) goto L42
            goto Lcb
        L42:
            java.util.List r0 = r0.getParameters()
            if (r0 != 0) goto L4a
            goto Lcb
        L4a:
            int r6 = r6.getIndex()
            java.lang.Object r6 = r0.get(r6)
            kotlin.reflect.KParameter r6 = (kotlin.reflect.KParameter) r6
            if (r6 != 0) goto L58
            goto Lcb
        L58:
            java.lang.String r1 = r6.getName()
            goto Lcb
        L5e:
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            goto Lcb
        L63:
            boolean r2 = r0 instanceof java.lang.reflect.Method
            if (r2 == 0) goto Lc4
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            kotlin.reflect.KFunction r0 = kotlin.reflect.jvm.ReflectJvmMapping.getKotlinFunction(r0)     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r0 != 0) goto L71
        L6f:
            r2 = r1
            goto L85
        L71:
            java.util.List r2 = r0.getParameters()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r2 != 0) goto L78
            goto L6f
        L78:
            java.lang.Object r2 = kotlin.collections.CollectionsKt.firstOrNull(r2)     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            kotlin.reflect.KParameter r2 = (kotlin.reflect.KParameter) r2     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r2 != 0) goto L81
            goto L6f
        L81:
            kotlin.reflect.KParameter$Kind r2 = r2.getKind()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
        L85:
            kotlin.reflect.KParameter$Kind r4 = kotlin.reflect.KParameter.Kind.VALUE     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r2 == r4) goto L90
            int r6 = r6.getIndex()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            int r6 = r6 + 1
            goto L94
        L90:
            int r6 = r6.getIndex()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
        L94:
            if (r0 != 0) goto L97
            goto La2
        L97:
            java.util.List r2 = r0.getParameters()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r2 != 0) goto L9e
            goto La2
        L9e:
            int r3 = r2.size()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
        La2:
            if (r3 <= r6) goto Lbc
            if (r0 != 0) goto La7
            goto Lcb
        La7:
            java.util.List r0 = r0.getParameters()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r0 != 0) goto Lae
            goto Lcb
        Lae:
            java.lang.Object r6 = r0.get(r6)     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            kotlin.reflect.KParameter r6 = (kotlin.reflect.KParameter) r6     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            if (r6 != 0) goto Lb7
            goto Lcb
        Lb7:
            java.lang.String r1 = r6.getName()     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            goto Lcb
        Lbc:
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6     // Catch: kotlin.reflect.jvm.internal.KotlinReflectionInternalError -> Lc0
            goto Lcb
        Lc0:
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            goto Lcb
        Lc4:
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
            goto Lcb
        Lc8:
            r6 = r1
            java.lang.String r6 = (java.lang.String) r6
        Lcb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.module.kotlin.KotlinNamesAnnotationIntrospector.findKotlinParameterName(com.fasterxml.jackson.databind.introspect.AnnotatedParameter):java.lang.String");
    }
}
