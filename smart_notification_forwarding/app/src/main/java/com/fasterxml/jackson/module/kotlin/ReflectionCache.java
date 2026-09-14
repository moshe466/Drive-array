package com.fasterxml.jackson.module.kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import com.fasterxml.jackson.databind.util.LRUMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.ReflectJvmMapping;

/* compiled from: ReflectionCache.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001%B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\n2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u001dJ\"\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00192\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000b0\u001dJ+\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u00122\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001d¢\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00010\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007J\u001c\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\rJ\u0014\u0010 \u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u0015J\u0014\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"2\u0006\u0010#\u001a\u00020$R&\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00170\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache;", JsonProperty.USE_DEFAULT_NAME, "reflectionCacheSize", JsonProperty.USE_DEFAULT_NAME, "(I)V", "javaClassToKotlin", "Lcom/fasterxml/jackson/databind/util/LRUMap;", "Ljava/lang/Class;", "Lkotlin/reflect/KClass;", "javaConstructorIsCreatorAnnotated", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedConstructor;", JsonProperty.USE_DEFAULT_NAME, "javaConstructorToKotlin", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/KFunction;", "javaConstructorToValueCreator", "Lcom/fasterxml/jackson/module/kotlin/ConstructorValueCreator;", "javaMemberIsRequired", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "javaMethodToKotlin", "Ljava/lang/reflect/Method;", "javaMethodToValueCreator", "Lcom/fasterxml/jackson/module/kotlin/MethodValueCreator;", "kotlinGeneratedMethod", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedMethod;", "checkConstructorIsCreatorAnnotated", "key", "calc", "Lkotlin/Function1;", "isKotlinGeneratedMethod", "(Lcom/fasterxml/jackson/databind/introspect/AnnotatedMember;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "kotlinFromJava", "valueCreatorFromJava", "Lcom/fasterxml/jackson/module/kotlin/ValueCreator;", "_withArgsCreator", "Lcom/fasterxml/jackson/databind/introspect/AnnotatedWithParams;", "BooleanTriState", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ReflectionCache {
    private final LRUMap<Class<Object>, KClass<Object>> javaClassToKotlin;
    private final LRUMap<AnnotatedConstructor, Boolean> javaConstructorIsCreatorAnnotated;
    private final LRUMap<Constructor<Object>, KFunction<Object>> javaConstructorToKotlin;
    private final LRUMap<Constructor<Object>, ConstructorValueCreator<?>> javaConstructorToValueCreator;
    private final LRUMap<AnnotatedMember, BooleanTriState> javaMemberIsRequired;
    private final LRUMap<Method, KFunction<?>> javaMethodToKotlin;
    private final LRUMap<Method, MethodValueCreator<?>> javaMethodToValueCreator;
    private final LRUMap<AnnotatedMethod, Boolean> kotlinGeneratedMethod;

    /* compiled from: ReflectionCache.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \b2\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", JsonProperty.USE_DEFAULT_NAME, "value", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/Boolean;)V", "getValue", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "Companion", "Empty", "False", "True", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$True;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$False;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Empty;", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static abstract class BooleanTriState {
        private final Boolean value;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final True TRUE = new True();
        private static final False FALSE = new False();
        private static final Empty EMPTY = new Empty();

        public /* synthetic */ BooleanTriState(Boolean bool, DefaultConstructorMarker defaultConstructorMarker) {
            this(bool);
        }

        /* compiled from: ReflectionCache.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$True;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "()V", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes.dex */
        public static final class True extends BooleanTriState {
            public True() {
                super(true, null);
            }
        }

        private BooleanTriState(Boolean bool) {
            this.value = bool;
        }

        public final Boolean getValue() {
            return this.value;
        }

        /* compiled from: ReflectionCache.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$False;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "()V", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes.dex */
        public static final class False extends BooleanTriState {
            public False() {
                super(false, null);
            }
        }

        /* compiled from: ReflectionCache.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Empty;", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "()V", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes.dex */
        public static final class Empty extends BooleanTriState {
            /* JADX WARN: Multi-variable type inference failed */
            public Empty() {
                super(null, 0 == true ? 1 : 0);
            }
        }

        /* compiled from: ReflectionCache.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Companion;", JsonProperty.USE_DEFAULT_NAME, "()V", "EMPTY", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$Empty;", "FALSE", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$False;", "TRUE", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState$True;", "fromBoolean", "Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "value", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/Boolean;)Lcom/fasterxml/jackson/module/kotlin/ReflectionCache$BooleanTriState;", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final BooleanTriState fromBoolean(Boolean value) {
                if (value == null) {
                    return BooleanTriState.EMPTY;
                }
                if (Intrinsics.areEqual((Object) value, (Object) true)) {
                    return BooleanTriState.TRUE;
                }
                if (Intrinsics.areEqual((Object) value, (Object) false)) {
                    return BooleanTriState.FALSE;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public ReflectionCache(int i) {
        this.javaClassToKotlin = new LRUMap<>(i, i);
        this.javaConstructorToKotlin = new LRUMap<>(i, i);
        this.javaMethodToKotlin = new LRUMap<>(i, i);
        this.javaConstructorToValueCreator = new LRUMap<>(i, i);
        this.javaMethodToValueCreator = new LRUMap<>(i, i);
        this.javaConstructorIsCreatorAnnotated = new LRUMap<>(i, i);
        this.javaMemberIsRequired = new LRUMap<>(i, i);
        this.kotlinGeneratedMethod = new LRUMap<>(i, i);
    }

    public final KClass<Object> kotlinFromJava(Class<Object> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        KClass<Object> kClass = this.javaClassToKotlin.get(key);
        if (kClass != null) {
            return kClass;
        }
        KClass<Object> kotlinClass = JvmClassMappingKt.getKotlinClass(key);
        KClass<Object> putIfAbsent = this.javaClassToKotlin.putIfAbsent(key, kotlinClass);
        return putIfAbsent == null ? kotlinClass : putIfAbsent;
    }

    public final KFunction<Object> kotlinFromJava(Constructor<Object> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        KFunction<Object> kFunction = this.javaConstructorToKotlin.get(key);
        if (kFunction != null) {
            return kFunction;
        }
        KFunction<Object> kotlinFunction = ReflectJvmMapping.getKotlinFunction(key);
        if (kotlinFunction == null) {
            return null;
        }
        KFunction<Object> putIfAbsent = this.javaConstructorToKotlin.putIfAbsent(key, kotlinFunction);
        return putIfAbsent == null ? kotlinFunction : putIfAbsent;
    }

    public final KFunction<?> kotlinFromJava(Method key) {
        Intrinsics.checkNotNullParameter(key, "key");
        KFunction<?> kFunction = this.javaMethodToKotlin.get(key);
        if (kFunction != null) {
            return kFunction;
        }
        KFunction<?> kotlinFunction = ReflectJvmMapping.getKotlinFunction(key);
        if (kotlinFunction == null) {
            return null;
        }
        KFunction<?> putIfAbsent = this.javaMethodToKotlin.putIfAbsent(key, kotlinFunction);
        return putIfAbsent == null ? kotlinFunction : putIfAbsent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [com.fasterxml.jackson.module.kotlin.MethodValueCreator, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.fasterxml.jackson.module.kotlin.MethodValueCreator] */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.fasterxml.jackson.module.kotlin.MethodValueCreator] */
    public final ValueCreator<?> valueCreatorFromJava(AnnotatedWithParams _withArgsCreator) {
        ConstructorValueCreator<?> putIfAbsent;
        Intrinsics.checkNotNullParameter(_withArgsCreator, "_withArgsCreator");
        ConstructorValueCreator<?> constructorValueCreator = null;
        if (_withArgsCreator instanceof AnnotatedConstructor) {
            Constructor<?> annotated = ((AnnotatedConstructor) _withArgsCreator).getAnnotated();
            if (annotated == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<kotlin.Any>");
            }
            ConstructorValueCreator<?> constructorValueCreator2 = this.javaConstructorToValueCreator.get(annotated);
            if (constructorValueCreator2 == null) {
                KFunction<Object> kotlinFromJava = kotlinFromJava(annotated);
                if (kotlinFromJava != null && (putIfAbsent = this.javaConstructorToValueCreator.putIfAbsent(annotated, (constructorValueCreator = new ConstructorValueCreator<>(kotlinFromJava)))) != null) {
                    constructorValueCreator = putIfAbsent;
                }
            } else {
                constructorValueCreator = constructorValueCreator2;
            }
            return constructorValueCreator;
        }
        if (_withArgsCreator instanceof AnnotatedMethod) {
            Method annotated2 = ((AnnotatedMethod) _withArgsCreator).getAnnotated();
            if (annotated2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Method");
            }
            ?? r0 = (MethodValueCreator) this.javaMethodToValueCreator.get(annotated2);
            ConstructorValueCreator<?> constructorValueCreator3 = r0;
            if (r0 == 0) {
                KFunction<?> kotlinFromJava2 = kotlinFromJava(annotated2);
                if (kotlinFromJava2 != null) {
                    ?? of = MethodValueCreator.INSTANCE.of(kotlinFromJava2);
                    ?? r3 = (MethodValueCreator) this.javaMethodToValueCreator.putIfAbsent(annotated2, of);
                    constructorValueCreator3 = of;
                    if (r3 != 0) {
                        constructorValueCreator = r3;
                    }
                }
                return constructorValueCreator;
            }
            constructorValueCreator = constructorValueCreator3;
            return constructorValueCreator;
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Expected a constructor or method to create a Kotlin object, instead found ", _withArgsCreator.getAnnotated().getClass().getName()));
    }

    public final boolean checkConstructorIsCreatorAnnotated(AnnotatedConstructor key, Function1<? super AnnotatedConstructor, Boolean> calc) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(calc, "calc");
        Boolean bool = this.javaConstructorIsCreatorAnnotated.get(key);
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean booleanValue = calc.invoke(key).booleanValue();
        Boolean putIfAbsent = this.javaConstructorIsCreatorAnnotated.putIfAbsent(key, Boolean.valueOf(booleanValue));
        return putIfAbsent == null ? booleanValue : putIfAbsent.booleanValue();
    }

    public final Boolean javaMemberIsRequired(AnnotatedMember key, Function1<? super AnnotatedMember, Boolean> calc) {
        Boolean value;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(calc, "calc");
        BooleanTriState booleanTriState = this.javaMemberIsRequired.get(key);
        Boolean value2 = booleanTriState == null ? null : booleanTriState.getValue();
        if (value2 != null) {
            return value2;
        }
        Boolean invoke = calc.invoke(key);
        BooleanTriState putIfAbsent = this.javaMemberIsRequired.putIfAbsent(key, BooleanTriState.INSTANCE.fromBoolean(invoke));
        return (putIfAbsent == null || (value = putIfAbsent.getValue()) == null) ? invoke : value;
    }

    public final boolean isKotlinGeneratedMethod(AnnotatedMethod key, Function1<? super AnnotatedMethod, Boolean> calc) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(calc, "calc");
        Boolean bool = this.kotlinGeneratedMethod.get(key);
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean booleanValue = calc.invoke(key).booleanValue();
        Boolean putIfAbsent = this.kotlinGeneratedMethod.putIfAbsent(key, Boolean.valueOf(booleanValue));
        return putIfAbsent == null ? booleanValue : putIfAbsent.booleanValue();
    }
}
