package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationException.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "throwable", JsonProperty.USE_DEFAULT_NAME, "errorCode", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationErrorCode;", "(Ljava/lang/Throwable;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationErrorCode;)V", "getErrorCode", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationErrorCode;", "getThrowable", "()Ljava/lang/Throwable;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TranslationException extends Exception {
    private final TranslationErrorCode errorCode;
    private final Throwable throwable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranslationException(Throwable throwable, TranslationErrorCode errorCode) {
        super(throwable);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        this.throwable = throwable;
        this.errorCode = errorCode;
    }

    public final TranslationErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }
}
