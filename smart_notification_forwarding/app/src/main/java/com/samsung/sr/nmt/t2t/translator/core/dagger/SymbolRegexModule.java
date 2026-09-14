package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.PlaceholderSymbolRegex;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.RejectionSymbolRegex;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.UnpairedTagsRegex;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;

/* compiled from: SymbolRegexModule.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/SymbolRegexModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "providePlaceholderSymbolRegex", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;", "provideRejectionSymbolRegex", "provideUnpairedTagsRegex", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class SymbolRegexModule {
    @Provides
    @Singleton
    @Named("RejectionSymbolRegex")
    public final SymbolRegex provideRejectionSymbolRegex() {
        return new RejectionSymbolRegex();
    }

    @Provides
    @Singleton
    @Named("UnpairedTagsRegex")
    public final SymbolRegex provideUnpairedTagsRegex() {
        return new UnpairedTagsRegex();
    }

    @Provides
    @Singleton
    @Named("PlaceholderSymbolRegex")
    public final SymbolRegex providePlaceholderSymbolRegex() {
        return new PlaceholderSymbolRegex();
    }
}
