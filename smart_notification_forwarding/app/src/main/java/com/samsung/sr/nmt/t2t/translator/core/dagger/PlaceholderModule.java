package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PlaceholderPostProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PlaceholderPreProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.PlaceholderSymbolRegex;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;

/* compiled from: PlaceholderModule.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/PlaceholderModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "getPlaceholderPostProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "getPlaceholderPreProcessor", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class PlaceholderModule {
    @Provides
    @Singleton
    @Named("PlaceholderPreProcessor")
    public final Processor getPlaceholderPreProcessor() {
        return new PlaceholderPreProcessor(new PlaceholderSymbolRegex());
    }

    @Provides
    @Singleton
    @Named("PlaceholderPostProcessor")
    public final Processor getPlaceholderPostProcessor() {
        return new PlaceholderPostProcessor();
    }
}
