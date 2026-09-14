package com.samsung.sr.nmt.t2t.translator.core.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoggerFactory.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/utils/LoggerFactory;", JsonProperty.USE_DEFAULT_NAME, "()V", "logger", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/Logger;", "getLogger", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/SimpleLogger;", "givenClass", "Ljava/lang/Class;", "name", JsonProperty.USE_DEFAULT_NAME, "setLogger", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LoggerFactory {
    public static final LoggerFactory INSTANCE = new LoggerFactory();
    private static Logger logger;

    private LoggerFactory() {
    }

    public final void setLogger(Logger logger2) {
        Intrinsics.checkNotNullParameter(logger2, "logger");
        logger = logger2;
    }

    public final SimpleLogger getLogger(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new SimpleLogger(name, new Function0<Logger>() { // from class: com.samsung.sr.nmt.t2t.translator.core.utils.LoggerFactory$getLogger$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Logger invoke() {
                Logger logger2;
                logger2 = LoggerFactory.logger;
                return logger2;
            }
        });
    }

    public final SimpleLogger getLogger(Class<Object> givenClass) {
        Intrinsics.checkNotNullParameter(givenClass, "givenClass");
        String simpleName = givenClass.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        return new SimpleLogger(simpleName, new Function0<Logger>() { // from class: com.samsung.sr.nmt.t2t.translator.core.utils.LoggerFactory$getLogger$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Logger invoke() {
                Logger logger2;
                logger2 = LoggerFactory.logger;
                return logger2;
            }
        });
    }
}
