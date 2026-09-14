package com.fasterxml.jackson.module.kotlin;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.exc.InputCoercionException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinKeyDeserializers.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\b\t\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\n"}, d2 = {"Lcom/fasterxml/jackson/module/kotlin/UShortKeyDeserializer;", "Lcom/fasterxml/jackson/databind/deser/std/StdKeyDeserializer;", "()V", "deserializeKey", "Lkotlin/UShort;", "key", JsonProperty.USE_DEFAULT_NAME, "ctxt", "Lcom/fasterxml/jackson/databind/DeserializationContext;", "deserializeKey-QDdqv-c", "jackson-module-kotlin"}, k = 1, mv = {1, 5, 1}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class UShortKeyDeserializer extends StdKeyDeserializer {
    public static final UShortKeyDeserializer INSTANCE = new UShortKeyDeserializer();

    private UShortKeyDeserializer() {
        super(5, UShort.class);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer, com.fasterxml.jackson.databind.KeyDeserializer
    /* renamed from: deserializeKey-QDdqv-c, reason: not valid java name and merged with bridge method [inline-methods] */
    public UShort deserializeKey(String key, DeserializationContext ctxt) {
        Intrinsics.checkNotNullParameter(ctxt, "ctxt");
        Object deserializeKey = super.deserializeKey(key, ctxt);
        if (deserializeKey == null) {
            return null;
        }
        UShort asUShort = UnsignedNumbersKt.asUShort(((Integer) deserializeKey).intValue());
        if (asUShort != null) {
            return UShort.m382boximpl(asUShort.getData());
        }
        throw new InputCoercionException(null, "Numeric value (" + ((Object) key) + ") out of range of UShort (0 - 65535).", JsonToken.VALUE_NUMBER_INT, UShort.class);
    }
}
