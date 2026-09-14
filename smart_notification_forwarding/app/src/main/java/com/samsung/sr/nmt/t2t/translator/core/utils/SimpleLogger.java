package com.samsung.sr.nmt.t2t.translator.core.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SimpleLogger.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003J\u001a\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003R\u001d\u0010\b\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0004\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/utils/SimpleLogger;", JsonProperty.USE_DEFAULT_NAME, "tag", JsonProperty.USE_DEFAULT_NAME, "getLogger", "Lkotlin/Function0;", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/Logger;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "logger", "()Lcom/samsung/sr/nmt/t2t/translator/core/utils/Logger;", "logger$delegate", "Lkotlin/Lazy;", "debug", JsonProperty.USE_DEFAULT_NAME, "message", "error", "throwable", JsonProperty.USE_DEFAULT_NAME, "info", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SimpleLogger {

    /* renamed from: logger$delegate, reason: from kotlin metadata */
    private final Lazy logger;
    private final String tag;

    public SimpleLogger(String tag, Function0<? extends Logger> getLogger) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(getLogger, "getLogger");
        this.tag = tag;
        this.logger = LazyKt.lazy(getLogger);
    }

    private final Logger getLogger() {
        return (Logger) this.logger.getValue();
    }

    public final void debug(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Logger logger = getLogger();
        if (logger != null) {
            logger.debug(this.tag, message);
        }
    }

    public final void info(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Logger logger = getLogger();
        if (logger != null) {
            logger.info(this.tag, message);
        }
    }

    public static /* synthetic */ void error$default(SimpleLogger simpleLogger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        simpleLogger.error(str, th);
    }

    public final void error(String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(message, "message");
        Logger logger = getLogger();
        if (logger != null) {
            logger.error(this.tag, message, throwable);
        }
    }
}
