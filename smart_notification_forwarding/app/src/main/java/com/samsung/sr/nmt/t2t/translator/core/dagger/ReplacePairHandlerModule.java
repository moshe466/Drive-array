package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomReplacePairLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.ReplacePairLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.CustomReplacePairHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePairHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePairUnit;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReplacePairHandlerModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/ReplacePairHandlerModule;", JsonProperty.USE_DEFAULT_NAME, "replacePairLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/ReplacePairLoader;", "customReplacePairLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomReplacePairLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/ReplacePairLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomReplacePairLoader;)V", "provideCustomReplacePairHandler", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/CustomReplacePairHandler;", "provideReplacePairHandler", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairHandler;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class ReplacePairHandlerModule {
    private final CustomReplacePairLoader customReplacePairLoader;
    private final ReplacePairLoader replacePairLoader;

    public ReplacePairHandlerModule(ReplacePairLoader replacePairLoader, CustomReplacePairLoader customReplacePairLoader) {
        Intrinsics.checkNotNullParameter(replacePairLoader, "replacePairLoader");
        Intrinsics.checkNotNullParameter(customReplacePairLoader, "customReplacePairLoader");
        this.replacePairLoader = replacePairLoader;
        this.customReplacePairLoader = customReplacePairLoader;
    }

    @Provides
    @Singleton
    public final ReplacePairHandler provideReplacePairHandler() {
        return new ReplacePairHandler(this.replacePairLoader, new ReplacePairUnit());
    }

    @Provides
    @Singleton
    public final CustomReplacePairHandler provideCustomReplacePairHandler() {
        return new CustomReplacePairHandler(this.customReplacePairLoader);
    }
}
