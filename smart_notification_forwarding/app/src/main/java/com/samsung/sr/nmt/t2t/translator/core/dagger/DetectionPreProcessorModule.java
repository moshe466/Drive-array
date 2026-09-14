package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.DetectionPreProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.NeutralCharFilteringProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.RepetitionRemovingProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.SpaceAndNewlineProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.SymbolFilteringProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.TagRemovingProcessor;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.inject.Singleton;
import kotlin.Metadata;

/* compiled from: DetectionPreProcessorModule.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH'J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH'J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H'¨\u0006\u0013"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/DetectionPreProcessorModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "provideEmojiFilteringProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/DetectionPreProcessor;", "symbolFilteringProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/SymbolFilteringProcessor;", "provideNeutralCharFilteringProcessor", "neutralCharFilteringProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/NeutralCharFilteringProcessor;", "provideRepetitionRemovingProcessor", "repetitionRemovingProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/RepetitionRemovingProcessor;", "provideSpaceAndNewlineProcessor", "spaceAndNewlineProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/SpaceAndNewlineProcessor;", "provideTagRemovingProcessor", "tagRemovingProcessor", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/TagRemovingProcessor;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public abstract class DetectionPreProcessorModule {
    @Binds
    @ClassKey(SymbolFilteringProcessor.class)
    @Singleton
    @IntoMap
    public abstract DetectionPreProcessor provideEmojiFilteringProcessor(SymbolFilteringProcessor symbolFilteringProcessor);

    @Binds
    @ClassKey(NeutralCharFilteringProcessor.class)
    @Singleton
    @IntoMap
    public abstract DetectionPreProcessor provideNeutralCharFilteringProcessor(NeutralCharFilteringProcessor neutralCharFilteringProcessor);

    @Binds
    @ClassKey(RepetitionRemovingProcessor.class)
    @Singleton
    @IntoMap
    public abstract DetectionPreProcessor provideRepetitionRemovingProcessor(RepetitionRemovingProcessor repetitionRemovingProcessor);

    @Binds
    @ClassKey(SpaceAndNewlineProcessor.class)
    @Singleton
    @IntoMap
    public abstract DetectionPreProcessor provideSpaceAndNewlineProcessor(SpaceAndNewlineProcessor spaceAndNewlineProcessor);

    @Binds
    @ClassKey(TagRemovingProcessor.class)
    @Singleton
    @IntoMap
    public abstract DetectionPreProcessor provideTagRemovingProcessor(TagRemovingProcessor tagRemovingProcessor);
}
