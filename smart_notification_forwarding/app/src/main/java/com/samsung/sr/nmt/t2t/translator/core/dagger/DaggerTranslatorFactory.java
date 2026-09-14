package com.samsung.sr.nmt.t2t.translator.core.dagger;

import com.samsung.sr.nmt.t2t.translator.core.LanguageDetectionService;
import com.samsung.sr.nmt.t2t.translator.core.LanguageDetectionServiceImpl;
import com.samsung.sr.nmt.t2t.translator.core.LanguageDetectionServiceImpl_Factory;
import com.samsung.sr.nmt.t2t.translator.core.SegmentationService;
import com.samsung.sr.nmt.t2t.translator.core.SegmentationServiceImpl;
import com.samsung.sr.nmt.t2t.translator.core.SegmentationServiceImpl_Factory;
import com.samsung.sr.nmt.t2t.translator.core.TranslationService;
import com.samsung.sr.nmt.t2t.translator.core.TranslationServiceImpl;
import com.samsung.sr.nmt.t2t.translator.core.TranslationServiceImpl_Factory;
import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorModuleBuilderParams;
import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorSpec;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetectorJni;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator.ChineseDifferentiator;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator.ChineseDifferentiator_Factory;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator.DifferentiationManager;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator.DifferentiationManager_Factory;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator.LanguageDifferentiator;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.DetectionPreProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.NeutralCharFilteringProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.NeutralCharFilteringProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.RepetitionRemovingProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.RepetitionRemovingProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.SpaceAndNewlineProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.SpaceAndNewlineProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.SymbolFilteringProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.SymbolFilteringProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.TagRemovingProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.TagRemovingProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.emergency.EmergencyHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.emergency.EmergencyHandler_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineFactory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineFactory_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineProvider;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineProvider_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineSpecFactory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineSpecFactory_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.LanguageDirectionManager;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.LanguageDirectionManager_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model.ModelFactory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model.ModelFactory_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.VocabFactory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.VocabFactory_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.UnknownCharacterFilter_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.AlphabetsResourceLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.LanguageIdsResourceLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.SentencePieceResourceReader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.SentencePieceResourceReader_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.SubwordsResourceLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.WordPieceResourceReader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.WordPieceResourceReader_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.SwearWordRuleLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.CaserProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.CaserProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.EsMxDollarsFixProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.EsMxDollarsFixProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.FormattingRestoreProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.FormattingRestoreProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.FormattingStoreProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.FormattingStoreProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.NormalizeProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.NormalizeProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PlaceholderHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.PlaceholderHandler_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.RecaserProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.RecaserProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SentenceJoinerProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SentenceJoinerProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SentenceSplitterProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SentenceSplitterProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SwearWordReplacerProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SwearWordReplacerProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SymbolSentenceRejectionProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SymbolSentenceRejectionProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TMProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TMProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagClosingProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagClosingProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagParsingProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagParsingProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagRecoverProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagRecoverProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagSubstituteProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagSubstituteProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationProcessor_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.AllUppercaseRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.AllUppercaseWithWhitespacesRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.CamelcaseRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.FirstLetterUppercaseRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.CustomReplacePairHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePairHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePairManager;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePairManager_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.EnSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.EnSpec_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.LanguageSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.LanguageSpecFactory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.LanguageSpecFactory_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.StreamEnSpec_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.TaggedEnSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.TaggedEnSpec_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.CharBasedSentenceSplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.EUSentenceSplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.EndOfLineSplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.LineLengthSplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitterManager;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitterManager_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.ThaiSentenceSplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword.SwearWordReplacer;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword.SwearWordReplacer_Factory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.CustomTranslationMemory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.TranslationMemory;
import com.samsung.sr.nmt.t2t.translator.core.utils.ActiveLanguageCodeChecker;
import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import dagger.internal.DoubleCheck;
import dagger.internal.MapFactory;
import dagger.internal.MapProviderFactory;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes.dex */
public final class DaggerTranslatorFactory {
    private DaggerTranslatorFactory() {
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private ActiveLanguageCodeCheckerModule activeLanguageCodeCheckerModule;
        private AssetLoaderModule assetLoaderModule;
        private AssetsModule assetsModule;
        private BatchSizeModule batchSizeModule;
        private ComputationContextModule computationContextModule;
        private ExternalConfigurationModule externalConfigurationModule;
        private FileLoaderModule fileLoaderModule;
        private LanguageDetectorThresholdModule languageDetectorThresholdModule;
        private PipelineModule pipelineModule;
        private PlaceholderModule placeholderModule;
        private RecaseRuleModule recaseRuleModule;
        private ReplacePairHandlerModule replacePairHandlerModule;
        private SplitRuleModule splitRuleModule;
        private SwearWordRuleLoaderModule swearWordRuleLoaderModule;
        private SymbolRegexModule symbolRegexModule;
        private TaggedSupportingInfoModule taggedSupportingInfoModule;
        private TranslationMemoryLoaderModule translationMemoryLoaderModule;
        private TranslationMemoryModule translationMemoryModule;
        private TranslatorSpecModule translatorSpecModule;
        private UnknownTokenRatioThresholdModule unknownTokenRatioThresholdModule;

        private Builder() {
        }

        public Builder batchSizeModule(BatchSizeModule batchSizeModule) {
            this.batchSizeModule = (BatchSizeModule) Preconditions.checkNotNull(batchSizeModule);
            return this;
        }

        public Builder fileLoaderModule(FileLoaderModule fileLoaderModule) {
            this.fileLoaderModule = (FileLoaderModule) Preconditions.checkNotNull(fileLoaderModule);
            return this;
        }

        public Builder computationContextModule(ComputationContextModule computationContextModule) {
            this.computationContextModule = (ComputationContextModule) Preconditions.checkNotNull(computationContextModule);
            return this;
        }

        public Builder translatorSpecModule(TranslatorSpecModule translatorSpecModule) {
            this.translatorSpecModule = (TranslatorSpecModule) Preconditions.checkNotNull(translatorSpecModule);
            return this;
        }

        public Builder taggedSupportingInfoModule(TaggedSupportingInfoModule taggedSupportingInfoModule) {
            this.taggedSupportingInfoModule = (TaggedSupportingInfoModule) Preconditions.checkNotNull(taggedSupportingInfoModule);
            return this;
        }

        public Builder splitRuleModule(SplitRuleModule splitRuleModule) {
            this.splitRuleModule = (SplitRuleModule) Preconditions.checkNotNull(splitRuleModule);
            return this;
        }

        public Builder assetsModule(AssetsModule assetsModule) {
            this.assetsModule = (AssetsModule) Preconditions.checkNotNull(assetsModule);
            return this;
        }

        public Builder unknownTokenRatioThresholdModule(UnknownTokenRatioThresholdModule unknownTokenRatioThresholdModule) {
            this.unknownTokenRatioThresholdModule = (UnknownTokenRatioThresholdModule) Preconditions.checkNotNull(unknownTokenRatioThresholdModule);
            return this;
        }

        public Builder translationMemoryLoaderModule(TranslationMemoryLoaderModule translationMemoryLoaderModule) {
            this.translationMemoryLoaderModule = (TranslationMemoryLoaderModule) Preconditions.checkNotNull(translationMemoryLoaderModule);
            return this;
        }

        public Builder translationMemoryModule(TranslationMemoryModule translationMemoryModule) {
            this.translationMemoryModule = (TranslationMemoryModule) Preconditions.checkNotNull(translationMemoryModule);
            return this;
        }

        public Builder languageDetectorThresholdModule(LanguageDetectorThresholdModule languageDetectorThresholdModule) {
            this.languageDetectorThresholdModule = (LanguageDetectorThresholdModule) Preconditions.checkNotNull(languageDetectorThresholdModule);
            return this;
        }

        public Builder activeLanguageCodeCheckerModule(ActiveLanguageCodeCheckerModule activeLanguageCodeCheckerModule) {
            this.activeLanguageCodeCheckerModule = (ActiveLanguageCodeCheckerModule) Preconditions.checkNotNull(activeLanguageCodeCheckerModule);
            return this;
        }

        public Builder swearWordRuleLoaderModule(SwearWordRuleLoaderModule swearWordRuleLoaderModule) {
            this.swearWordRuleLoaderModule = (SwearWordRuleLoaderModule) Preconditions.checkNotNull(swearWordRuleLoaderModule);
            return this;
        }

        public Builder recaseRuleModule(RecaseRuleModule recaseRuleModule) {
            this.recaseRuleModule = (RecaseRuleModule) Preconditions.checkNotNull(recaseRuleModule);
            return this;
        }

        public Builder assetLoaderModule(AssetLoaderModule assetLoaderModule) {
            this.assetLoaderModule = (AssetLoaderModule) Preconditions.checkNotNull(assetLoaderModule);
            return this;
        }

        public Builder externalConfigurationModule(ExternalConfigurationModule externalConfigurationModule) {
            this.externalConfigurationModule = (ExternalConfigurationModule) Preconditions.checkNotNull(externalConfigurationModule);
            return this;
        }

        public Builder pipelineModule(PipelineModule pipelineModule) {
            this.pipelineModule = (PipelineModule) Preconditions.checkNotNull(pipelineModule);
            return this;
        }

        public Builder symbolRegexModule(SymbolRegexModule symbolRegexModule) {
            this.symbolRegexModule = (SymbolRegexModule) Preconditions.checkNotNull(symbolRegexModule);
            return this;
        }

        public Builder replacePairHandlerModule(ReplacePairHandlerModule replacePairHandlerModule) {
            this.replacePairHandlerModule = (ReplacePairHandlerModule) Preconditions.checkNotNull(replacePairHandlerModule);
            return this;
        }

        public Builder placeholderModule(PlaceholderModule placeholderModule) {
            this.placeholderModule = (PlaceholderModule) Preconditions.checkNotNull(placeholderModule);
            return this;
        }

        public TranslatorFactory build() {
            Preconditions.checkBuilderRequirement(this.batchSizeModule, BatchSizeModule.class);
            Preconditions.checkBuilderRequirement(this.fileLoaderModule, FileLoaderModule.class);
            if (this.computationContextModule == null) {
                this.computationContextModule = new ComputationContextModule();
            }
            if (this.translatorSpecModule == null) {
                this.translatorSpecModule = new TranslatorSpecModule();
            }
            if (this.taggedSupportingInfoModule == null) {
                this.taggedSupportingInfoModule = new TaggedSupportingInfoModule();
            }
            if (this.splitRuleModule == null) {
                this.splitRuleModule = new SplitRuleModule();
            }
            if (this.assetsModule == null) {
                this.assetsModule = new AssetsModule();
            }
            Preconditions.checkBuilderRequirement(this.unknownTokenRatioThresholdModule, UnknownTokenRatioThresholdModule.class);
            Preconditions.checkBuilderRequirement(this.translationMemoryLoaderModule, TranslationMemoryLoaderModule.class);
            if (this.translationMemoryModule == null) {
                this.translationMemoryModule = new TranslationMemoryModule();
            }
            Preconditions.checkBuilderRequirement(this.languageDetectorThresholdModule, LanguageDetectorThresholdModule.class);
            if (this.activeLanguageCodeCheckerModule == null) {
                this.activeLanguageCodeCheckerModule = new ActiveLanguageCodeCheckerModule();
            }
            Preconditions.checkBuilderRequirement(this.swearWordRuleLoaderModule, SwearWordRuleLoaderModule.class);
            if (this.recaseRuleModule == null) {
                this.recaseRuleModule = new RecaseRuleModule();
            }
            Preconditions.checkBuilderRequirement(this.assetLoaderModule, AssetLoaderModule.class);
            Preconditions.checkBuilderRequirement(this.externalConfigurationModule, ExternalConfigurationModule.class);
            if (this.pipelineModule == null) {
                this.pipelineModule = new PipelineModule();
            }
            if (this.symbolRegexModule == null) {
                this.symbolRegexModule = new SymbolRegexModule();
            }
            Preconditions.checkBuilderRequirement(this.replacePairHandlerModule, ReplacePairHandlerModule.class);
            if (this.placeholderModule == null) {
                this.placeholderModule = new PlaceholderModule();
            }
            return new TranslatorFactoryImpl(this.batchSizeModule, this.fileLoaderModule, this.computationContextModule, this.translatorSpecModule, this.taggedSupportingInfoModule, this.splitRuleModule, this.assetsModule, this.unknownTokenRatioThresholdModule, this.translationMemoryLoaderModule, this.translationMemoryModule, this.languageDetectorThresholdModule, this.activeLanguageCodeCheckerModule, this.swearWordRuleLoaderModule, this.recaseRuleModule, this.assetLoaderModule, this.externalConfigurationModule, this.pipelineModule, this.symbolRegexModule, this.replacePairHandlerModule, this.placeholderModule);
        }
    }

    /* loaded from: classes.dex */
    private static final class TranslatorFactoryImpl implements TranslatorFactory {
        private Provider<AlphabetsResourceLoader> alphabetsResourceLoaderProvider;
        private Provider<AssetLoader> assetLoaderProvider;
        private Provider<ChineseDifferentiator> chineseDifferentiatorProvider;
        private Provider<DifferentiationManager> differentiationManagerProvider;
        private Provider<EmergencyHandler> emergencyHandlerProvider;
        private Provider<EnSpec> enSpecProvider;
        private Provider<EngineFactory> engineFactoryProvider;
        private Provider<EngineProvider> engineProvider;
        private Provider<EngineSpecFactory> engineSpecFactoryProvider;
        private Provider<EnvironmentHelper> environmentHelperProvider;
        private Provider<Pipeline> environmentHelperProvider2;
        private Provider<FileLoader> fileLoaderProvider;
        private Provider<Processor> getPlaceholderPostProcessorProvider;
        private Provider<Processor> getPlaceholderPreProcessorProvider;
        private Provider<LanguageDetectionServiceImpl> languageDetectionServiceImplProvider;
        private Provider<LanguageDirectionManager> languageDirectionManagerProvider;
        private Provider<LanguageIdsResourceLoader> languageIdsResourceLoaderProvider;
        private Provider<LanguageSpecFactory> languageSpecFactoryProvider;
        private Provider<Map<Class<?>, Provider<DetectionPreProcessor>>> mapOfClassOfAndProviderOfDetectionPreProcessorProvider;
        private Provider<Map<Class<?>, Provider<Processor>>> mapOfClassOfAndProviderOfProcessorProvider;
        private Provider<Map<Class<?>, RecaseRule>> mapOfClassOfAndRecaseRuleProvider;
        private Provider<Map<Class<?>, SplitRule>> mapOfClassOfAndSplitRuleProvider;
        private Provider<Map<String, LanguageDifferentiator>> mapOfStringAndLanguageDifferentiatorProvider;
        private Provider<Map<String, Provider<LanguageSpec>>> mapOfStringAndProviderOfLanguageSpecProvider;
        private Provider<ModelFactory> modelFactoryProvider;
        private Provider<NormalizeProcessor> normalizeProcessorProvider;
        private Provider<PlaceholderHandler> placeholderHandlerProvider;
        private Provider<Set<String>> provideAbbreviationsProvider;
        private Provider<RecaseRule> provideAllUppercaseRuleProvider;
        private Provider<RecaseRule> provideAllUppercaseWithWhitespacesRuleProvider;
        private Provider<RecaseRule> provideCamelcaseRuleProvider;
        private Provider<Processor> provideCaserProcessorProvider;
        private Provider<SplitRule> provideCharBasedSentenceSplitRuleProvider;
        private Provider<LanguageDifferentiator> provideChineseDifferentiatorProvider;
        private Provider<Integer> provideChineseThresholdProvider;
        private Provider<CoroutineContext> provideComputationContextProvider;
        private Provider<CustomReplacePairHandler> provideCustomReplacePairHandlerProvider;
        private Provider<CustomTranslationMemoryLoader> provideCustomTranslationMemoryLoaderProvider;
        private Provider<CustomTranslationMemory> provideCustomTranslationMemoryProvider;
        private Provider<SplitRule> provideEUSentenceSplitRuleProvider;
        private Provider<DetectionPreProcessor> provideEmojiFilteringProcessorProvider;
        private Provider<SplitRule> provideEndOfLineSplitRuleProvider;
        private Provider<Set<String>> provideEnglishDictionaryProvider;
        private Provider<LanguageSpec> provideEnglishSpecProvider;
        private Provider<Processor> provideEsMxDollarsFixProcessorProvider;
        private Provider<RecaseRule> provideFirstLetterUppercaseRuleProvider;
        private Provider<Processor> provideFormattingRestoreProcessorProvider;
        private Provider<Processor> provideFormattingStoreProcessorProvider;
        private Provider<Boolean> provideIsShortestProvider;
        private Provider<ActiveLanguageCodeChecker> provideLanguageCodeCheckerProvider;
        private Provider<LanguageDetectionService> provideLanguageDetectionServiceProvider;
        private Provider<Map<String, String>> provideLanguageDetectorDictionaryProvider;
        private Provider<LanguageDetectorJni> provideLanguageDetectorJniProvider;
        private Provider<LanguageDetector> provideLanguageDetectorProvider;
        private Provider<SplitRule> provideLineLengthSplitRuleProvider;
        private Provider<DetectionPreProcessor> provideNeutralCharFilteringProcessorProvider;
        private Provider<Set<String>> provideNoCaseDistinctLanguagesProvider;
        private Provider<Processor> provideNormalizeProcessorProvider;
        private Provider<SymbolRegex> providePlaceholderSymbolRegexProvider;
        private Provider<Processor> provideRecaserProcessorProvider;
        private Provider<SymbolRegex> provideRejectionSymbolRegexProvider;
        private Provider<DetectionPreProcessor> provideRepetitionRemovingProcessorProvider;
        private Provider<ReplacePairHandler> provideReplacePairHandlerProvider;
        private Provider<SegmentationService> provideSegmentationServiceProvider;
        private Provider<Processor> provideSentenceJoinerProcessorProvider;
        private Provider<Processor> provideSentenceSplitterProcessorProvider;
        private Provider<DetectionPreProcessor> provideSpaceAndNewlineProcessorProvider;
        private Provider<LanguageSpec> provideStreamEnglishSpecProvider;
        private Provider<Processor> provideSwearWordReplacerProcessorProvider;
        private Provider<Processor> provideSymbolSentenceRejectionProcessorProvider;
        private Provider<Processor> provideTMProcessorProvider;
        private Provider<Processor> provideTagClosingProcessorProvider;
        private Provider<Processor> provideTagParsingProcessorProvider;
        private Provider<Processor> provideTagRecoverSubstituteProcessorProvider;
        private Provider<DetectionPreProcessor> provideTagRemovingProcessorProvider;
        private Provider<Processor> provideTagSubstituteProcessorProvider;
        private Provider<LanguageSpec> provideTaggedSpecProvider;
        private Provider<Map<LanguageDirection, String>> provideTaggedSupportingInfoProvider;
        private Provider<SplitRule> provideThaiSentenceSplitRuleProvider;
        private Provider<Integer> provideTokenBatchSizeProvider;
        private Provider<Set<String>> provideTraditionalChineseCharactersProvider;
        private Provider<TranslationMemoryLoader> provideTranslationMemoryProvider;
        private Provider<TranslationMemory> provideTranslationMemoryProvider2;
        private Provider<Processor> provideTranslationProcessorProvider;
        private Provider<TranslationService> provideTranslationServiceProvider;
        private Provider<TranslatorSpec> provideTranslatorSpecProvider;
        private Provider<Float> provideUnknownThresholdProvider;
        private Provider<SymbolRegex> provideUnpairedTagsRegexProvider;
        private Provider<RecaserProcessor> recaserProcessorProvider;
        private Provider<ReplacePairManager> replacePairManagerProvider;
        private Provider<SegmentationServiceImpl> segmentationServiceImplProvider;
        private Provider<SentencePieceResourceReader> sentencePieceResourceReaderProvider;
        private Provider<SentenceSplitterProcessor> sentenceSplitterProcessorProvider;
        private Provider<SplitterManager> splitterManagerProvider;
        private Provider<SubwordsResourceLoader> subwordsResourceLoaderProvider;
        private Provider<SwearWordReplacerProcessor> swearWordReplacerProcessorProvider;
        private Provider<SwearWordReplacer> swearWordReplacerProvider;
        private Provider<SwearWordRuleLoader> swearWordRuleLoaderProvider;
        private Provider<SymbolFilteringProcessor> symbolFilteringProcessorProvider;
        private Provider<SymbolSentenceRejectionProcessor> symbolSentenceRejectionProcessorProvider;
        private Provider<TMProcessor> tMProcessorProvider;
        private Provider<TagParsingProcessor> tagParsingProcessorProvider;
        private Provider<TagSubstituteProcessor> tagSubstituteProcessorProvider;
        private Provider<TaggedEnSpec> taggedEnSpecProvider;
        private Provider<TaggedSupportingInfoFactory> taggedSupportingInfoFactoryProvider;
        private Provider<TranslationProcessor> translationProcessorProvider;
        private Provider<TranslationServiceImpl> translationServiceImplProvider;
        private final TranslatorFactoryImpl translatorFactoryImpl;
        private Provider<TranslatorModuleBuilderParams> translatorModuleBuilderParamsProvider;
        private Provider<TranslatorSpecFactory> translatorSpecFactoryProvider;
        private Provider<VocabFactory> vocabFactoryProvider;
        private Provider<WordPieceResourceReader> wordPieceResourceReaderProvider;

        private TranslatorFactoryImpl(BatchSizeModule batchSizeModule, FileLoaderModule fileLoaderModule, ComputationContextModule computationContextModule, TranslatorSpecModule translatorSpecModule, TaggedSupportingInfoModule taggedSupportingInfoModule, SplitRuleModule splitRuleModule, AssetsModule assetsModule, UnknownTokenRatioThresholdModule unknownTokenRatioThresholdModule, TranslationMemoryLoaderModule translationMemoryLoaderModule, TranslationMemoryModule translationMemoryModule, LanguageDetectorThresholdModule languageDetectorThresholdModule, ActiveLanguageCodeCheckerModule activeLanguageCodeCheckerModule, SwearWordRuleLoaderModule swearWordRuleLoaderModule, RecaseRuleModule recaseRuleModule, AssetLoaderModule assetLoaderModule, ExternalConfigurationModule externalConfigurationModule, PipelineModule pipelineModule, SymbolRegexModule symbolRegexModule, ReplacePairHandlerModule replacePairHandlerModule, PlaceholderModule placeholderModule) {
            this.translatorFactoryImpl = this;
            initialize(batchSizeModule, fileLoaderModule, computationContextModule, translatorSpecModule, taggedSupportingInfoModule, splitRuleModule, assetsModule, unknownTokenRatioThresholdModule, translationMemoryLoaderModule, translationMemoryModule, languageDetectorThresholdModule, activeLanguageCodeCheckerModule, swearWordRuleLoaderModule, recaseRuleModule, assetLoaderModule, externalConfigurationModule, pipelineModule, symbolRegexModule, replacePairHandlerModule, placeholderModule);
            initialize2(batchSizeModule, fileLoaderModule, computationContextModule, translatorSpecModule, taggedSupportingInfoModule, splitRuleModule, assetsModule, unknownTokenRatioThresholdModule, translationMemoryLoaderModule, translationMemoryModule, languageDetectorThresholdModule, activeLanguageCodeCheckerModule, swearWordRuleLoaderModule, recaseRuleModule, assetLoaderModule, externalConfigurationModule, pipelineModule, symbolRegexModule, replacePairHandlerModule, placeholderModule);
        }

        private void initialize(BatchSizeModule batchSizeModule, FileLoaderModule fileLoaderModule, ComputationContextModule computationContextModule, TranslatorSpecModule translatorSpecModule, TaggedSupportingInfoModule taggedSupportingInfoModule, SplitRuleModule splitRuleModule, AssetsModule assetsModule, UnknownTokenRatioThresholdModule unknownTokenRatioThresholdModule, TranslationMemoryLoaderModule translationMemoryLoaderModule, TranslationMemoryModule translationMemoryModule, LanguageDetectorThresholdModule languageDetectorThresholdModule, ActiveLanguageCodeCheckerModule activeLanguageCodeCheckerModule, SwearWordRuleLoaderModule swearWordRuleLoaderModule, RecaseRuleModule recaseRuleModule, AssetLoaderModule assetLoaderModule, ExternalConfigurationModule externalConfigurationModule, PipelineModule pipelineModule, SymbolRegexModule symbolRegexModule, ReplacePairHandlerModule replacePairHandlerModule, PlaceholderModule placeholderModule) {
            this.fileLoaderProvider = DoubleCheck.provider(FileLoaderModule_FileLoaderFactory.create(fileLoaderModule));
            Provider<EnvironmentHelper> provider = DoubleCheck.provider(ExternalConfigurationModule_EnvironmentHelperFactory.create(externalConfigurationModule));
            this.environmentHelperProvider = provider;
            this.modelFactoryProvider = DoubleCheck.provider(ModelFactory_Factory.create(this.fileLoaderProvider, provider));
            this.provideUnknownThresholdProvider = DoubleCheck.provider(UnknownTokenRatioThresholdModule_ProvideUnknownThresholdFactory.create(unknownTokenRatioThresholdModule));
            this.languageIdsResourceLoaderProvider = DoubleCheck.provider(FileLoaderModule_LanguageIdsResourceLoaderFactory.create(fileLoaderModule));
            this.alphabetsResourceLoaderProvider = DoubleCheck.provider(FileLoaderModule_AlphabetsResourceLoaderFactory.create(fileLoaderModule));
            Provider<SubwordsResourceLoader> provider2 = DoubleCheck.provider(FileLoaderModule_SubwordsResourceLoaderFactory.create(fileLoaderModule));
            this.subwordsResourceLoaderProvider = provider2;
            this.wordPieceResourceReaderProvider = WordPieceResourceReader_Factory.create(this.languageIdsResourceLoaderProvider, this.alphabetsResourceLoaderProvider, provider2);
            SentencePieceResourceReader_Factory create = SentencePieceResourceReader_Factory.create(this.languageIdsResourceLoaderProvider, this.alphabetsResourceLoaderProvider);
            this.sentencePieceResourceReaderProvider = create;
            Provider<VocabFactory> provider3 = DoubleCheck.provider(VocabFactory_Factory.create(this.fileLoaderProvider, this.provideUnknownThresholdProvider, this.wordPieceResourceReaderProvider, create, UnknownCharacterFilter_Factory.create(), this.environmentHelperProvider));
            this.vocabFactoryProvider = provider3;
            this.engineFactoryProvider = DoubleCheck.provider(EngineFactory_Factory.create(this.modelFactoryProvider, provider3));
            Provider<AssetLoader> provider4 = DoubleCheck.provider(AssetLoaderModule_AssetLoaderFactory.create(assetLoaderModule));
            this.assetLoaderProvider = provider4;
            Provider<ActiveLanguageCodeChecker> provider5 = DoubleCheck.provider(ActiveLanguageCodeCheckerModule_ProvideLanguageCodeCheckerFactory.create(activeLanguageCodeCheckerModule, provider4));
            this.provideLanguageCodeCheckerProvider = provider5;
            this.engineSpecFactoryProvider = DoubleCheck.provider(EngineSpecFactory_Factory.create(this.fileLoaderProvider, provider5));
            TranslatorSpecFactory_Factory create2 = TranslatorSpecFactory_Factory.create(this.assetLoaderProvider, this.provideLanguageCodeCheckerProvider);
            this.translatorSpecFactoryProvider = create2;
            this.provideTranslatorSpecProvider = DoubleCheck.provider(TranslatorSpecModule_ProvideTranslatorSpecFactory.create(translatorSpecModule, create2));
            TaggedSupportingInfoFactory_Factory create3 = TaggedSupportingInfoFactory_Factory.create(this.assetLoaderProvider);
            this.taggedSupportingInfoFactoryProvider = create3;
            TaggedSupportingInfoModule_ProvideTaggedSupportingInfoFactory create4 = TaggedSupportingInfoModule_ProvideTaggedSupportingInfoFactory.create(taggedSupportingInfoModule, create3);
            this.provideTaggedSupportingInfoProvider = create4;
            Provider<LanguageDirectionManager> provider6 = DoubleCheck.provider(LanguageDirectionManager_Factory.create(this.provideTranslatorSpecProvider, this.fileLoaderProvider, create4));
            this.languageDirectionManagerProvider = provider6;
            this.engineProvider = DoubleCheck.provider(EngineProvider_Factory.create(this.engineFactoryProvider, this.engineSpecFactoryProvider, provider6));
            this.provideIsShortestProvider = SplitRuleModule_ProvideIsShortestFactory.create(splitRuleModule);
            AssetsModule_ProvideAbbreviationsFactory create5 = AssetsModule_ProvideAbbreviationsFactory.create(assetsModule, this.assetLoaderProvider);
            this.provideAbbreviationsProvider = create5;
            this.provideCharBasedSentenceSplitRuleProvider = DoubleCheck.provider(SplitRuleModule_ProvideCharBasedSentenceSplitRuleFactory.create(splitRuleModule, this.provideIsShortestProvider, create5));
            this.provideEndOfLineSplitRuleProvider = DoubleCheck.provider(SplitRuleModule_ProvideEndOfLineSplitRuleFactory.create(splitRuleModule));
            this.provideEUSentenceSplitRuleProvider = DoubleCheck.provider(SplitRuleModule_ProvideEUSentenceSplitRuleFactory.create(splitRuleModule, this.provideAbbreviationsProvider));
            this.provideLineLengthSplitRuleProvider = DoubleCheck.provider(SplitRuleModule_ProvideLineLengthSplitRuleFactory.create(splitRuleModule));
            this.provideThaiSentenceSplitRuleProvider = DoubleCheck.provider(SplitRuleModule_ProvideThaiSentenceSplitRuleFactory.create(splitRuleModule));
            MapFactory build = MapFactory.builder(5).put((MapFactory.Builder) CharBasedSentenceSplitRule.class, (Provider) this.provideCharBasedSentenceSplitRuleProvider).put((MapFactory.Builder) EndOfLineSplitRule.class, (Provider) this.provideEndOfLineSplitRuleProvider).put((MapFactory.Builder) EUSentenceSplitRule.class, (Provider) this.provideEUSentenceSplitRuleProvider).put((MapFactory.Builder) LineLengthSplitRule.class, (Provider) this.provideLineLengthSplitRuleProvider).put((MapFactory.Builder) ThaiSentenceSplitRule.class, (Provider) this.provideThaiSentenceSplitRuleProvider).build();
            this.mapOfClassOfAndSplitRuleProvider = build;
            Provider<SplitterManager> provider7 = DoubleCheck.provider(SplitterManager_Factory.create(build));
            this.splitterManagerProvider = provider7;
            SentenceSplitterProcessor_Factory create6 = SentenceSplitterProcessor_Factory.create(provider7);
            this.sentenceSplitterProcessorProvider = create6;
            this.provideSentenceSplitterProcessorProvider = DoubleCheck.provider(create6);
            this.provideSentenceJoinerProcessorProvider = DoubleCheck.provider(SentenceJoinerProcessor_Factory.create());
            Provider<TranslationMemoryLoader> provider8 = DoubleCheck.provider(TranslationMemoryLoaderModule_ProvideTranslationMemoryFactory.create(translationMemoryLoaderModule));
            this.provideTranslationMemoryProvider = provider8;
            this.provideTranslationMemoryProvider2 = DoubleCheck.provider(TranslationMemoryModule_ProvideTranslationMemoryFactory.create(translationMemoryModule, provider8));
            Provider<CustomTranslationMemoryLoader> provider9 = DoubleCheck.provider(TranslationMemoryLoaderModule_ProvideCustomTranslationMemoryLoaderFactory.create(translationMemoryLoaderModule));
            this.provideCustomTranslationMemoryLoaderProvider = provider9;
            Provider<CustomTranslationMemory> provider10 = DoubleCheck.provider(TranslationMemoryModule_ProvideCustomTranslationMemoryFactory.create(translationMemoryModule, provider9));
            this.provideCustomTranslationMemoryProvider = provider10;
            TMProcessor_Factory create7 = TMProcessor_Factory.create(this.provideTranslationMemoryProvider2, provider10, this.languageDirectionManagerProvider);
            this.tMProcessorProvider = create7;
            this.provideTMProcessorProvider = DoubleCheck.provider(create7);
            this.provideTokenBatchSizeProvider = DoubleCheck.provider(BatchSizeModule_ProvideTokenBatchSizeFactory.create(batchSizeModule));
            this.provideReplacePairHandlerProvider = DoubleCheck.provider(ReplacePairHandlerModule_ProvideReplacePairHandlerFactory.create(replacePairHandlerModule));
            Provider<CustomReplacePairHandler> provider11 = DoubleCheck.provider(ReplacePairHandlerModule_ProvideCustomReplacePairHandlerFactory.create(replacePairHandlerModule));
            this.provideCustomReplacePairHandlerProvider = provider11;
            this.replacePairManagerProvider = DoubleCheck.provider(ReplacePairManager_Factory.create(this.provideReplacePairHandlerProvider, provider11));
            this.getPlaceholderPreProcessorProvider = DoubleCheck.provider(PlaceholderModule_GetPlaceholderPreProcessorFactory.create(placeholderModule));
            Provider<Processor> provider12 = DoubleCheck.provider(PlaceholderModule_GetPlaceholderPostProcessorFactory.create(placeholderModule));
            this.getPlaceholderPostProcessorProvider = provider12;
            this.placeholderHandlerProvider = DoubleCheck.provider(PlaceholderHandler_Factory.create(this.getPlaceholderPreProcessorProvider, provider12));
            this.emergencyHandlerProvider = DoubleCheck.provider(EmergencyHandler_Factory.create());
            NormalizeProcessor_Factory create8 = NormalizeProcessor_Factory.create(this.languageDirectionManagerProvider);
            this.normalizeProcessorProvider = create8;
            TranslationProcessor_Factory create9 = TranslationProcessor_Factory.create(this.engineProvider, this.provideTranslationMemoryProvider2, this.provideTokenBatchSizeProvider, this.replacePairManagerProvider, this.placeholderHandlerProvider, this.emergencyHandlerProvider, create8);
            this.translationProcessorProvider = create9;
            this.provideTranslationProcessorProvider = DoubleCheck.provider(create9);
            Provider<SwearWordRuleLoader> provider13 = DoubleCheck.provider(SwearWordRuleLoaderModule_SwearWordRuleLoaderFactory.create(swearWordRuleLoaderModule));
            this.swearWordRuleLoaderProvider = provider13;
            SwearWordReplacer_Factory create10 = SwearWordReplacer_Factory.create(provider13);
            this.swearWordReplacerProvider = create10;
            SwearWordReplacerProcessor_Factory create11 = SwearWordReplacerProcessor_Factory.create(create10, this.languageDirectionManagerProvider);
            this.swearWordReplacerProcessorProvider = create11;
            this.provideSwearWordReplacerProcessorProvider = DoubleCheck.provider(create11);
            this.provideFirstLetterUppercaseRuleProvider = DoubleCheck.provider(RecaseRuleModule_ProvideFirstLetterUppercaseRuleFactory.create(recaseRuleModule));
            this.provideAllUppercaseRuleProvider = DoubleCheck.provider(RecaseRuleModule_ProvideAllUppercaseRuleFactory.create(recaseRuleModule));
            this.provideAllUppercaseWithWhitespacesRuleProvider = DoubleCheck.provider(RecaseRuleModule_ProvideAllUppercaseWithWhitespacesRuleFactory.create(recaseRuleModule));
            this.provideCamelcaseRuleProvider = DoubleCheck.provider(RecaseRuleModule_ProvideCamelcaseRuleFactory.create(recaseRuleModule));
            this.mapOfClassOfAndRecaseRuleProvider = MapFactory.builder(4).put((MapFactory.Builder) FirstLetterUppercaseRule.class, (Provider) this.provideFirstLetterUppercaseRuleProvider).put((MapFactory.Builder) AllUppercaseRule.class, (Provider) this.provideAllUppercaseRuleProvider).put((MapFactory.Builder) AllUppercaseWithWhitespacesRule.class, (Provider) this.provideAllUppercaseWithWhitespacesRuleProvider).put((MapFactory.Builder) CamelcaseRule.class, (Provider) this.provideCamelcaseRuleProvider).build();
            AssetsModule_ProvideNoCaseDistinctLanguagesFactory create12 = AssetsModule_ProvideNoCaseDistinctLanguagesFactory.create(assetsModule, this.assetLoaderProvider);
            this.provideNoCaseDistinctLanguagesProvider = create12;
            RecaserProcessor_Factory create13 = RecaserProcessor_Factory.create(this.mapOfClassOfAndRecaseRuleProvider, create12);
            this.recaserProcessorProvider = create13;
            this.provideRecaserProcessorProvider = DoubleCheck.provider(create13);
            this.provideCaserProcessorProvider = DoubleCheck.provider(CaserProcessor_Factory.create());
            Provider<SymbolRegex> provider14 = DoubleCheck.provider(SymbolRegexModule_ProvideRejectionSymbolRegexFactory.create(symbolRegexModule));
            this.provideRejectionSymbolRegexProvider = provider14;
            SymbolSentenceRejectionProcessor_Factory create14 = SymbolSentenceRejectionProcessor_Factory.create(provider14);
            this.symbolSentenceRejectionProcessorProvider = create14;
            this.provideSymbolSentenceRejectionProcessorProvider = DoubleCheck.provider(create14);
            Provider<SymbolRegex> provider15 = DoubleCheck.provider(SymbolRegexModule_ProvideUnpairedTagsRegexFactory.create(symbolRegexModule));
            this.provideUnpairedTagsRegexProvider = provider15;
            TagParsingProcessor_Factory create15 = TagParsingProcessor_Factory.create(provider15);
            this.tagParsingProcessorProvider = create15;
            this.provideTagParsingProcessorProvider = DoubleCheck.provider(create15);
            TagSubstituteProcessor_Factory create16 = TagSubstituteProcessor_Factory.create(this.mapOfClassOfAndSplitRuleProvider, this.provideUnpairedTagsRegexProvider);
            this.tagSubstituteProcessorProvider = create16;
            this.provideTagSubstituteProcessorProvider = DoubleCheck.provider(create16);
            this.provideTagRecoverSubstituteProcessorProvider = DoubleCheck.provider(TagRecoverProcessor_Factory.create());
            this.provideTagClosingProcessorProvider = DoubleCheck.provider(TagClosingProcessor_Factory.create());
            this.provideNormalizeProcessorProvider = DoubleCheck.provider(this.normalizeProcessorProvider);
            this.provideFormattingStoreProcessorProvider = DoubleCheck.provider(FormattingStoreProcessor_Factory.create());
            this.provideFormattingRestoreProcessorProvider = DoubleCheck.provider(FormattingRestoreProcessor_Factory.create());
            this.provideEsMxDollarsFixProcessorProvider = DoubleCheck.provider(EsMxDollarsFixProcessor_Factory.create());
            MapProviderFactory build2 = MapProviderFactory.builder(16).put((MapProviderFactory.Builder) SentenceSplitterProcessor.class, (Provider) this.provideSentenceSplitterProcessorProvider).put((MapProviderFactory.Builder) SentenceJoinerProcessor.class, (Provider) this.provideSentenceJoinerProcessorProvider).put((MapProviderFactory.Builder) TMProcessor.class, (Provider) this.provideTMProcessorProvider).put((MapProviderFactory.Builder) TranslationProcessor.class, (Provider) this.provideTranslationProcessorProvider).put((MapProviderFactory.Builder) SwearWordReplacerProcessor.class, (Provider) this.provideSwearWordReplacerProcessorProvider).put((MapProviderFactory.Builder) RecaserProcessor.class, (Provider) this.provideRecaserProcessorProvider).put((MapProviderFactory.Builder) CaserProcessor.class, (Provider) this.provideCaserProcessorProvider).put((MapProviderFactory.Builder) SymbolSentenceRejectionProcessor.class, (Provider) this.provideSymbolSentenceRejectionProcessorProvider).put((MapProviderFactory.Builder) TagParsingProcessor.class, (Provider) this.provideTagParsingProcessorProvider).put((MapProviderFactory.Builder) TagSubstituteProcessor.class, (Provider) this.provideTagSubstituteProcessorProvider).put((MapProviderFactory.Builder) TagRecoverProcessor.class, (Provider) this.provideTagRecoverSubstituteProcessorProvider).put((MapProviderFactory.Builder) TagClosingProcessor.class, (Provider) this.provideTagClosingProcessorProvider).put((MapProviderFactory.Builder) NormalizeProcessor.class, (Provider) this.provideNormalizeProcessorProvider).put((MapProviderFactory.Builder) FormattingStoreProcessor.class, (Provider) this.provideFormattingStoreProcessorProvider).put((MapProviderFactory.Builder) FormattingRestoreProcessor.class, (Provider) this.provideFormattingRestoreProcessorProvider).put((MapProviderFactory.Builder) EsMxDollarsFixProcessor.class, (Provider) this.provideEsMxDollarsFixProcessorProvider).build();
            this.mapOfClassOfAndProviderOfProcessorProvider = build2;
            EnSpec_Factory create17 = EnSpec_Factory.create(build2);
            this.enSpecProvider = create17;
            this.provideEnglishSpecProvider = DoubleCheck.provider(create17);
            this.provideStreamEnglishSpecProvider = DoubleCheck.provider(StreamEnSpec_Factory.create());
            TaggedEnSpec_Factory create18 = TaggedEnSpec_Factory.create(this.mapOfClassOfAndProviderOfProcessorProvider);
            this.taggedEnSpecProvider = create18;
            this.provideTaggedSpecProvider = DoubleCheck.provider(create18);
            MapProviderFactory build3 = MapProviderFactory.builder(3).put((MapProviderFactory.Builder) "en-plain", (Provider) this.provideEnglishSpecProvider).put((MapProviderFactory.Builder) "en-stream", (Provider) this.provideStreamEnglishSpecProvider).put((MapProviderFactory.Builder) "en-tagged", (Provider) this.provideTaggedSpecProvider).build();
            this.mapOfStringAndProviderOfLanguageSpecProvider = build3;
            this.languageSpecFactoryProvider = LanguageSpecFactory_Factory.create(build3);
            this.provideComputationContextProvider = DoubleCheck.provider(ComputationContextModule_ProvideComputationContextFactory.create(computationContextModule));
            Provider<TranslatorModuleBuilderParams> provider16 = DoubleCheck.provider(ExternalConfigurationModule_TranslatorModuleBuilderParamsFactory.create(externalConfigurationModule));
            this.translatorModuleBuilderParamsProvider = provider16;
            Provider<Pipeline> provider17 = DoubleCheck.provider(PipelineModule_EnvironmentHelperFactory.create(pipelineModule, this.languageSpecFactoryProvider, this.translationProcessorProvider, this.provideComputationContextProvider, provider16));
            this.environmentHelperProvider2 = provider17;
            TranslationServiceImpl_Factory create19 = TranslationServiceImpl_Factory.create(this.engineProvider, provider17, this.languageDirectionManagerProvider, this.provideTranslationMemoryProvider2);
            this.translationServiceImplProvider = create19;
            this.provideTranslationServiceProvider = DoubleCheck.provider(create19);
            this.provideLanguageDetectorJniProvider = DoubleCheck.provider(LanguageDetectorThresholdModule_ProvideLanguageDetectorJniFactory.create(languageDetectorThresholdModule, this.assetLoaderProvider));
            this.provideEnglishDictionaryProvider = AssetsModule_ProvideEnglishDictionaryFactory.create(assetsModule, this.assetLoaderProvider);
            AssetsModule_ProvideLanguageDetectorDictionaryFactory create20 = AssetsModule_ProvideLanguageDetectorDictionaryFactory.create(assetsModule, this.assetLoaderProvider);
            this.provideLanguageDetectorDictionaryProvider = create20;
            this.provideLanguageDetectorProvider = DoubleCheck.provider(LanguageDetectorThresholdModule_ProvideLanguageDetectorFactory.create(languageDetectorThresholdModule, this.provideLanguageDetectorJniProvider, this.provideEnglishDictionaryProvider, create20));
            this.provideTraditionalChineseCharactersProvider = AssetsModule_ProvideTraditionalChineseCharactersFactory.create(assetsModule, this.assetLoaderProvider);
            AssetsModule_ProvideChineseThresholdFactory create21 = AssetsModule_ProvideChineseThresholdFactory.create(assetsModule);
            this.provideChineseThresholdProvider = create21;
            ChineseDifferentiator_Factory create22 = ChineseDifferentiator_Factory.create(this.provideTraditionalChineseCharactersProvider, create21);
            this.chineseDifferentiatorProvider = create22;
            this.provideChineseDifferentiatorProvider = DoubleCheck.provider(create22);
            MapFactory build4 = MapFactory.builder(1).put((MapFactory.Builder) "zh", (Provider) this.provideChineseDifferentiatorProvider).build();
            this.mapOfStringAndLanguageDifferentiatorProvider = build4;
            this.differentiationManagerProvider = DifferentiationManager_Factory.create(build4);
            this.providePlaceholderSymbolRegexProvider = DoubleCheck.provider(SymbolRegexModule_ProvidePlaceholderSymbolRegexFactory.create(symbolRegexModule));
        }

        private void initialize2(BatchSizeModule batchSizeModule, FileLoaderModule fileLoaderModule, ComputationContextModule computationContextModule, TranslatorSpecModule translatorSpecModule, TaggedSupportingInfoModule taggedSupportingInfoModule, SplitRuleModule splitRuleModule, AssetsModule assetsModule, UnknownTokenRatioThresholdModule unknownTokenRatioThresholdModule, TranslationMemoryLoaderModule translationMemoryLoaderModule, TranslationMemoryModule translationMemoryModule, LanguageDetectorThresholdModule languageDetectorThresholdModule, ActiveLanguageCodeCheckerModule activeLanguageCodeCheckerModule, SwearWordRuleLoaderModule swearWordRuleLoaderModule, RecaseRuleModule recaseRuleModule, AssetLoaderModule assetLoaderModule, ExternalConfigurationModule externalConfigurationModule, PipelineModule pipelineModule, SymbolRegexModule symbolRegexModule, ReplacePairHandlerModule replacePairHandlerModule, PlaceholderModule placeholderModule) {
            SymbolFilteringProcessor_Factory create = SymbolFilteringProcessor_Factory.create(this.providePlaceholderSymbolRegexProvider);
            this.symbolFilteringProcessorProvider = create;
            this.provideEmojiFilteringProcessorProvider = DoubleCheck.provider(create);
            this.provideRepetitionRemovingProcessorProvider = DoubleCheck.provider(RepetitionRemovingProcessor_Factory.create());
            this.provideNeutralCharFilteringProcessorProvider = DoubleCheck.provider(NeutralCharFilteringProcessor_Factory.create());
            this.provideTagRemovingProcessorProvider = DoubleCheck.provider(TagRemovingProcessor_Factory.create());
            this.provideSpaceAndNewlineProcessorProvider = DoubleCheck.provider(SpaceAndNewlineProcessor_Factory.create());
            MapProviderFactory build = MapProviderFactory.builder(5).put((MapProviderFactory.Builder) SymbolFilteringProcessor.class, (Provider) this.provideEmojiFilteringProcessorProvider).put((MapProviderFactory.Builder) RepetitionRemovingProcessor.class, (Provider) this.provideRepetitionRemovingProcessorProvider).put((MapProviderFactory.Builder) NeutralCharFilteringProcessor.class, (Provider) this.provideNeutralCharFilteringProcessorProvider).put((MapProviderFactory.Builder) TagRemovingProcessor.class, (Provider) this.provideTagRemovingProcessorProvider).put((MapProviderFactory.Builder) SpaceAndNewlineProcessor.class, (Provider) this.provideSpaceAndNewlineProcessorProvider).build();
            this.mapOfClassOfAndProviderOfDetectionPreProcessorProvider = build;
            LanguageDetectionServiceImpl_Factory create2 = LanguageDetectionServiceImpl_Factory.create(this.provideLanguageDetectorProvider, this.differentiationManagerProvider, build);
            this.languageDetectionServiceImplProvider = create2;
            this.provideLanguageDetectionServiceProvider = DoubleCheck.provider(create2);
            SegmentationServiceImpl_Factory create3 = SegmentationServiceImpl_Factory.create(this.splitterManagerProvider);
            this.segmentationServiceImplProvider = create3;
            this.provideSegmentationServiceProvider = DoubleCheck.provider(create3);
        }

        @Override // com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorFactory
        public TranslationService translator() {
            return this.provideTranslationServiceProvider.get();
        }

        @Override // com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorFactory
        public LanguageDetectionService languageDetector() {
            return this.provideLanguageDetectionServiceProvider.get();
        }

        @Override // com.samsung.sr.nmt.t2t.translator.core.dagger.TranslatorFactory
        public SegmentationService segmenter() {
            return this.provideSegmentationServiceProvider.get();
        }
    }
}
