package com.fasterxml.jackson.module.kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinSerializers.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u0007*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0002\u0007\bB\u0015\b\u0004\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006\u0082\u0001\u0001\t¨\u0006\n"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ValueClassSerializer;", "T", JsonProperty.USE_DEFAULT_NAME, "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;", "t", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "Companion", "StaticJsonValue", "Lcom/fasterxml/jackson/module/kotlin/ValueClassSerializer$StaticJsonValue;", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class ValueClassSerializer<T> extends StdSerializer<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ ValueClassSerializer(Class cls, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls);
    }

    private ValueClassSerializer(Class<T> cls) {
        super(cls);
    }

    /* compiled from: KotlinSerializers.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ%\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ValueClassSerializer$StaticJsonValue;", "T", JsonProperty.USE_DEFAULT_NAME, "Lcom/fasterxml/jackson/module/kotlin/ValueClassSerializer;", "t", "Ljava/lang/Class;", "staticJsonValueGetter", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/lang/reflect/Method;)V", "unboxMethod", "serialize", JsonProperty.USE_DEFAULT_NAME, "value", "gen", "Lcom/fasterxml/jackson/core/JsonGenerator;", "provider", "Lcom/fasterxml/jackson/databind/SerializerProvider;", "(Ljava/lang/Object;Lcom/fasterxml/jackson/core/JsonGenerator;Lcom/fasterxml/jackson/databind/SerializerProvider;)V", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class StaticJsonValue<T> extends ValueClassSerializer<T> {
        private final Method staticJsonValueGetter;
        private final Method unboxMethod;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StaticJsonValue(Class<T> t, Method staticJsonValueGetter) {
            super(t, null);
            Intrinsics.checkNotNullParameter(t, "t");
            Intrinsics.checkNotNullParameter(staticJsonValueGetter, "staticJsonValueGetter");
            this.staticJsonValueGetter = staticJsonValueGetter;
            Method method = t.getMethod("unbox-impl", new Class[0]);
            Intrinsics.checkNotNullExpressionValue(method, "t.getMethod(\"unbox-impl\")");
            this.unboxMethod = method;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
        public void serialize(T value, JsonGenerator gen, SerializerProvider provider) {
            Unit unit;
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(gen, "gen");
            Intrinsics.checkNotNullParameter(provider, "provider");
            Object invoke = this.staticJsonValueGetter.invoke(null, this.unboxMethod.invoke(value, new Object[0]));
            if (invoke == null) {
                unit = null;
            } else {
                provider.findValueSerializer(invoke.getClass()).serialize(invoke, gen, provider);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                provider.findNullValueSerializer(null).serialize(null, gen, provider);
            }
        }
    }

    /* compiled from: KotlinSerializers.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¨\u0006\u0007"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/ValueClassSerializer$Companion;", JsonProperty.USE_DEFAULT_NAME, "()V", "from", "Lcom/fasterxml/jackson/databind/ser/std/StdSerializer;", "t", "Ljava/lang/Class;", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StdSerializer<?> from(Class<?> t) {
            Method staticJsonValueGetter;
            Intrinsics.checkNotNullParameter(t, "t");
            staticJsonValueGetter = KotlinSerializersKt.getStaticJsonValueGetter(t);
            StaticJsonValue staticJsonValue = staticJsonValueGetter == null ? null : new StaticJsonValue(t, staticJsonValueGetter);
            if (staticJsonValue != null) {
                return staticJsonValue;
            }
            return ValueClassUnboxSerializer.INSTANCE;
        }
    }
}
