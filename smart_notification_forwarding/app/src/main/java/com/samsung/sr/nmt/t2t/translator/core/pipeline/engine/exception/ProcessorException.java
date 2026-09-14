package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomException.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/exception/ProcessorException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", JsonProperty.USE_DEFAULT_NAME, "cause", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;Ljava/lang/Throwable;)V", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ProcessorException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProcessorException(String message, Throwable cause) {
        super(message, cause);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(cause, "cause");
    }

    public /* synthetic */ ProcessorException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? JsonProperty.USE_DEFAULT_NAME : str, th);
    }
}
