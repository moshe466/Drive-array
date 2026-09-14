package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.SwearWordRuleLoader;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwearWordRuleLoaderModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/SwearWordRuleLoaderModule;", JsonProperty.USE_DEFAULT_NAME, "swearWordRuleLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;)V", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class SwearWordRuleLoaderModule {
    private final SwearWordRuleLoader swearWordRuleLoader;

    public SwearWordRuleLoaderModule(SwearWordRuleLoader swearWordRuleLoader) {
        Intrinsics.checkNotNullParameter(swearWordRuleLoader, "swearWordRuleLoader");
        this.swearWordRuleLoader = swearWordRuleLoader;
    }

    @Provides
    @Singleton
    /* renamed from: swearWordRuleLoader, reason: from getter */
    public final SwearWordRuleLoader getSwearWordRuleLoader() {
        return this.swearWordRuleLoader;
    }
}
