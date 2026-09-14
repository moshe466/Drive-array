package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.CaserProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.EsMxDollarsFixProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.FormattingRestoreProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.FormattingStoreProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.NormalizeProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.RecaserProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SentenceJoinerProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SentenceSplitterProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SwearWordReplacerProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SymbolSentenceRejectionProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TMProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagClosingProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagParsingProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagRecoverProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagSubstituteProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationProcessor;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.inject.Singleton;
import kotlin.Metadata;

/* compiled from: ProcessorModule.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0010H'J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H'J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H'J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H'J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH'J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001fH'J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"H'J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020%H'J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020(H'J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+H'J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H'J\u0010\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u000201H'¨\u00062"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/ProcessorModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "provideCaserProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "caserProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/CaserProcessor;", "provideEsMxDollarsFixProcessor", "processor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/EsMxDollarsFixProcessor;", "provideFormattingRestoreProcessor", "normalizeProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/FormattingRestoreProcessor;", "provideFormattingStoreProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/FormattingStoreProcessor;", "provideNormalizeProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/NormalizeProcessor;", "provideRecaserProcessor", "recaserProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/RecaserProcessor;", "provideSentenceJoinerProcessor", "sentenceJoinerProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/SentenceJoinerProcessor;", "provideSentenceSplitterProcessor", "sentenceSplitterProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/SentenceSplitterProcessor;", "provideSwearWordReplacerProcessor", "swearWordReplacerProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/SwearWordReplacerProcessor;", "provideSymbolSentenceRejectionProcessor", "symbolSentenceRejectionProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/SymbolSentenceRejectionProcessor;", "provideTMProcessor", "tmProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TMProcessor;", "provideTagClosingProcessor", "tagClosingProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TagClosingProcessor;", "provideTagParsingProcessor", "tagParsingProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TagParsingProcessor;", "provideTagRecoverSubstituteProcessor", "tagRecoverProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TagRecoverProcessor;", "provideTagSubstituteProcessor", "tagSubstituteProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TagSubstituteProcessor;", "provideTranslationProcessor", "translationProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationProcessor;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public abstract class ProcessorModule {
    @Binds
    @ClassKey(CaserProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideCaserProcessor(CaserProcessor caserProcessor);

    @Binds
    @ClassKey(EsMxDollarsFixProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideEsMxDollarsFixProcessor(EsMxDollarsFixProcessor processor);

    @Binds
    @ClassKey(FormattingRestoreProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideFormattingRestoreProcessor(FormattingRestoreProcessor normalizeProcessor);

    @Binds
    @ClassKey(FormattingStoreProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideFormattingStoreProcessor(FormattingStoreProcessor normalizeProcessor);

    @Binds
    @ClassKey(NormalizeProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideNormalizeProcessor(NormalizeProcessor normalizeProcessor);

    @Binds
    @ClassKey(RecaserProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideRecaserProcessor(RecaserProcessor recaserProcessor);

    @Binds
    @ClassKey(SentenceJoinerProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideSentenceJoinerProcessor(SentenceJoinerProcessor sentenceJoinerProcessor);

    @Binds
    @ClassKey(SentenceSplitterProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideSentenceSplitterProcessor(SentenceSplitterProcessor sentenceSplitterProcessor);

    @Binds
    @ClassKey(SwearWordReplacerProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideSwearWordReplacerProcessor(SwearWordReplacerProcessor swearWordReplacerProcessor);

    @Binds
    @ClassKey(SymbolSentenceRejectionProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideSymbolSentenceRejectionProcessor(SymbolSentenceRejectionProcessor symbolSentenceRejectionProcessor);

    @Binds
    @ClassKey(TMProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideTMProcessor(TMProcessor tmProcessor);

    @Binds
    @ClassKey(TagClosingProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideTagClosingProcessor(TagClosingProcessor tagClosingProcessor);

    @Binds
    @ClassKey(TagParsingProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideTagParsingProcessor(TagParsingProcessor tagParsingProcessor);

    @Binds
    @ClassKey(TagRecoverProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideTagRecoverSubstituteProcessor(TagRecoverProcessor tagRecoverProcessor);

    @Binds
    @ClassKey(TagSubstituteProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideTagSubstituteProcessor(TagSubstituteProcessor tagSubstituteProcessor);

    @Binds
    @ClassKey(TranslationProcessor.class)
    @Singleton
    @IntoMap
    public abstract Processor provideTranslationProcessor(TranslationProcessor translationProcessor);
}
