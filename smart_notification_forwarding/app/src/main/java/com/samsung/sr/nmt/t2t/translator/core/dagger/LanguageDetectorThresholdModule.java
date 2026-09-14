package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.CJKRuleBasedLanguageDetector;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.DictionaryBasedLanguageDetector;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.EnglishRuleBasedLanguageDetector;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetectorJni;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetectorParams;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.ModelBasedLanguageDetector;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.VietnameseRuleBasedLanguageDetector;
import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import dagger.Module;
import dagger.Provides;
import java.util.Map;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageDetectorThresholdModule.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J6\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\b\u0001\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/LanguageDetectorThresholdModule;", JsonProperty.USE_DEFAULT_NAME, "params", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetectorParams;", "resourcePath", JsonProperty.USE_DEFAULT_NAME, "(Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetectorParams;Ljava/lang/String;)V", "provideLanguageDetector", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;", "languageDetectorJni", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetectorJni;", "englishDictionary", JsonProperty.USE_DEFAULT_NAME, "languageDetectorDictionary", JsonProperty.USE_DEFAULT_NAME, "provideLanguageDetectorJni", "assertLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;", "provideThreshold", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class LanguageDetectorThresholdModule {
    private final LanguageDetectorParams params;
    private final String resourcePath;

    public LanguageDetectorThresholdModule(LanguageDetectorParams params, String resourcePath) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
        this.params = params;
        this.resourcePath = resourcePath;
    }

    @Provides
    @Named("LanguageDetectorThreshold")
    public final float provideThreshold() {
        return this.params.getModelConfidenceThreshold();
    }

    @Provides
    @Singleton
    public final LanguageDetector provideLanguageDetector(LanguageDetectorJni languageDetectorJni, @Named("english-dictionary") Set<String> englishDictionary, @Named("language-detector-dictionary") Map<String, String> languageDetectorDictionary) {
        Intrinsics.checkNotNullParameter(languageDetectorJni, "languageDetectorJni");
        Intrinsics.checkNotNullParameter(englishDictionary, "englishDictionary");
        Intrinsics.checkNotNullParameter(languageDetectorDictionary, "languageDetectorDictionary");
        return new DictionaryBasedLanguageDetector(new CJKRuleBasedLanguageDetector(new EnglishRuleBasedLanguageDetector(new VietnameseRuleBasedLanguageDetector(new ModelBasedLanguageDetector(languageDetectorJni)), englishDictionary), this.params.getRuleConfidenceThreshold(), this.params.getChineseRuleApplicableMinLength(), this.params.getChineseRuleValidThreshold()), languageDetectorDictionary);
    }

    @Provides
    @Singleton
    public final LanguageDetectorJni provideLanguageDetectorJni(AssetLoader assertLoader) {
        Intrinsics.checkNotNullParameter(assertLoader, "assertLoader");
        return new LanguageDetectorJni(assertLoader, this.params.getModelConfidenceThreshold(), this.resourcePath);
    }
}
