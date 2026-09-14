package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.LanguageDetectionService;
import com.samsung.sr.nmt.t2t.translator.core.SegmentationService;
import com.samsung.sr.nmt.t2t.translator.core.TranslationService;
import dagger.Component;
import javax.inject.Singleton;
import kotlin.Metadata;

/* compiled from: TranslatorFactory.kt */
@Component(modules = {BatchSizeModule.class, FileLoaderModule.class, ComputationContextModule.class, TranslatorSpecModule.class, TaggedSupportingInfoModule.class, SplitRuleModule.class, AssetsModule.class, ProcessorModule.class, LanguageSpecModule.class, UnknownTokenRatioThresholdModule.class, TranslationMemoryLoaderModule.class, TranslationMemoryModule.class, LanguageDetectorThresholdModule.class, LanguageDifferentiatorModule.class, ActiveLanguageCodeCheckerModule.class, SwearWordRuleLoaderModule.class, RecaseRuleModule.class, AssetLoaderModule.class, ServiceModule.class, ExternalConfigurationModule.class, PipelineModule.class, SymbolRegexModule.class, ReplacePairHandlerModule.class, PlaceholderModule.class, DetectionPreProcessorModule.class})
@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TranslatorFactory;", JsonProperty.USE_DEFAULT_NAME, "languageDetector", "Lcom/samsung/sr/nmt/t2t/translator/core/LanguageDetectionService;", "segmenter", "Lcom/samsung/sr/nmt/t2t/translator/core/SegmentationService;", "translator", "Lcom/samsung/sr/nmt/t2t/translator/core/TranslationService;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface TranslatorFactory {
    LanguageDetectionService languageDetector();

    SegmentationService segmenter();

    TranslationService translator();
}
