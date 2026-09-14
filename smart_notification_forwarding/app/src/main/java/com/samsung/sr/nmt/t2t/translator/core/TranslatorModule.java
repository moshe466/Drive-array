package com.samsung.sr.nmt.t2t.translator.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.samsung.sr.nmt.t2t.translator.core.dagger.AssetLoaderModule;
import com.samsung.sr.nmt.t2t.translator.core.dagger.BatchSizeModule;
import com.samsung.sr.nmt.t2t.translator.core.dagger.DaggerTranslatorFactory;
import com.samsung.sr.nmt.t2t.translator.core.dagger.ExternalConfigurationModule;
import com.samsung.sr.nmt.t2t.translator.core.dagger.FileLoaderModule;
import com.samsung.sr.nmt.t2t.translator.core.dagger.LanguageDetectorThresholdModule;
import com.samsung.sr.nmt.t2t.translator.core.dagger.ReplacePairHandlerModule;
import com.samsung.sr.nmt.t2t.translator.core.dagger.SwearWordRuleLoaderModule;
import com.samsung.sr.nmt.t2t.translator.core.dagger.TranslationMemoryLoaderModule;
import com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorFactory;
import com.samsung.sr.nmt.t2t.translator.core.dagger.UnknownTokenRatioThresholdModule;
import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorModuleBuilderParams;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetectorParams;
import com.samsung.sr.nmt.t2t.translator.core.utils.Logger;
import com.samsung.sr.nmt.t2t.translator.core.utils.LoggerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslatorModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/TranslatorModule;", JsonProperty.USE_DEFAULT_NAME, "translatorFactory", "Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TranslatorFactory;", "(Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TranslatorFactory;)V", "languageDetectionService", "Lcom/samsung/sr/nmt/t2t/translator/core/LanguageDetectionService;", "getLanguageDetectionService", "()Lcom/samsung/sr/nmt/t2t/translator/core/LanguageDetectionService;", "segmentationService", "Lcom/samsung/sr/nmt/t2t/translator/core/SegmentationService;", "getSegmentationService", "()Lcom/samsung/sr/nmt/t2t/translator/core/SegmentationService;", "translationService", "Lcom/samsung/sr/nmt/t2t/translator/core/TranslationService;", "getTranslationService", "()Lcom/samsung/sr/nmt/t2t/translator/core/TranslationService;", "Builder", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TranslatorModule {

    /* renamed from: Builder, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String LANGUAGE_DETECTOR_PATH = "srlid83-v7.ftz";
    private static final int MAX_BATCH_SIZE = 256;
    private static final int MIN_BATCH_SIZE = 32;
    private final LanguageDetectionService languageDetectionService;
    private final SegmentationService segmentationService;
    private final TranslationService translationService;

    /* compiled from: TranslatorModule.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/TranslatorModule$Builder;", JsonProperty.USE_DEFAULT_NAME, "()V", "LANGUAGE_DETECTOR_PATH", JsonProperty.USE_DEFAULT_NAME, "MAX_BATCH_SIZE", JsonProperty.USE_DEFAULT_NAME, "MIN_BATCH_SIZE", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/samsung/sr/nmt/t2t/translator/core/TranslatorModule;", "translatorParams", "Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorModuleBuilderParams;", "languageDetectorParams", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetectorParams;", "setLogger", JsonProperty.USE_DEFAULT_NAME, "logger", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/Logger;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* renamed from: com.samsung.sr.nmt.t2t.translator.core.TranslatorModule$Builder, reason: from kotlin metadata */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setLogger(Logger logger) {
            Intrinsics.checkNotNullParameter(logger, "logger");
            LoggerFactory.INSTANCE.setLogger(logger);
        }

        public final TranslatorModule build(TranslatorModuleBuilderParams translatorParams, LanguageDetectorParams languageDetectorParams) {
            Intrinsics.checkNotNullParameter(translatorParams, "translatorParams");
            Intrinsics.checkNotNullParameter(languageDetectorParams, "languageDetectorParams");
            int tokenBatchSize = translatorParams.getTokenBatchSize();
            if (!(32 <= tokenBatchSize && tokenBatchSize < 257)) {
                throw new IllegalArgumentException(("Batch size (" + translatorParams.getTokenBatchSize() + ") should be in the range [32, 256]").toString());
            }
            if (!(translatorParams.getCharacterBatchSize() > 0)) {
                throw new IllegalArgumentException("Character batch size should be positive".toString());
            }
            TranslatorFactory build = DaggerTranslatorFactory.builder().assetLoaderModule(new AssetLoaderModule(translatorParams.getAssetLoader())).externalConfigurationModule(new ExternalConfigurationModule(translatorParams)).fileLoaderModule(new FileLoaderModule(translatorParams.getFileLoader())).unknownTokenRatioThresholdModule(new UnknownTokenRatioThresholdModule(translatorParams.getUnknownTokenRatioThreshold())).translationMemoryLoaderModule(new TranslationMemoryLoaderModule(translatorParams.getTranslationMemoryLoader(), translatorParams.getCustomTranslationMemoryLoader())).languageDetectorThresholdModule(new LanguageDetectorThresholdModule(languageDetectorParams, TranslatorModule.LANGUAGE_DETECTOR_PATH)).swearWordRuleLoaderModule(new SwearWordRuleLoaderModule(translatorParams.getSwearWordRuleLoader())).replacePairHandlerModule(new ReplacePairHandlerModule(translatorParams.getReplacePairLoader(), translatorParams.getCustomReplacePairLoader())).batchSizeModule(new BatchSizeModule(translatorParams.getCharacterBatchSize(), translatorParams.getTokenBatchSize())).build();
            Intrinsics.checkNotNull(build);
            return new TranslatorModule(build);
        }
    }

    public TranslatorModule(TranslatorFactory translatorFactory) {
        Intrinsics.checkNotNullParameter(translatorFactory, "translatorFactory");
        this.translationService = translatorFactory.translator();
        this.languageDetectionService = translatorFactory.languageDetector();
        this.segmentationService = translatorFactory.segmenter();
    }

    public final TranslationService getTranslationService() {
        return this.translationService;
    }

    public final LanguageDetectionService getLanguageDetectionService() {
        return this.languageDetectionService;
    }

    public final SegmentationService getSegmentationService() {
        return this.segmentationService;
    }
}
