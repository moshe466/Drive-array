package com.samsung.sr.nmt.t2t.translator.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.DetectionCandidate;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator.DifferentiationManager;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.DetectionPreProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.NeutralCharFilteringProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.RepetitionRemovingProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.SpaceAndNewlineProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.SymbolFilteringProcessor;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.TagRemovingProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageDetectionServiceImpl.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B:\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0002J2\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u0015H\u0016J.\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0015H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007¢\u0006\u0002\b\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/LanguageDetectionServiceImpl;", "Lcom/samsung/sr/nmt/t2t/translator/core/LanguageDetectionService;", "languageDetector", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;", "differentiationManager", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/differentiator/DifferentiationManager;", "preprocessors", JsonProperty.USE_DEFAULT_NAME, "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/DetectionPreProcessor;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/differentiator/DifferentiationManager;Ljava/util/Map;)V", "clear", JsonProperty.USE_DEFAULT_NAME, "getPreprocessors", JsonProperty.USE_DEFAULT_NAME, "identifyLanguage", JsonProperty.USE_DEFAULT_NAME, "text", "differentiate", JsonProperty.USE_DEFAULT_NAME, "threshold", JsonProperty.USE_DEFAULT_NAME, "fallbackLanguage", "verbose", "identifyLanguageAndGetCandidates", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DetectionCandidate;", "maxCandidate", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LanguageDetectionServiceImpl implements LanguageDetectionService {
    private final DifferentiationManager differentiationManager;
    private final LanguageDetector languageDetector;
    private final Map<Class<?>, Provider<DetectionPreProcessor>> preprocessors;

    @Inject
    public LanguageDetectionServiceImpl(LanguageDetector languageDetector, DifferentiationManager differentiationManager, Map<Class<?>, Provider<DetectionPreProcessor>> preprocessors) {
        Intrinsics.checkNotNullParameter(languageDetector, "languageDetector");
        Intrinsics.checkNotNullParameter(differentiationManager, "differentiationManager");
        Intrinsics.checkNotNullParameter(preprocessors, "preprocessors");
        this.languageDetector = languageDetector;
        this.differentiationManager = differentiationManager;
        this.preprocessors = preprocessors;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.LanguageDetectionService
    public String identifyLanguage(String text, boolean differentiate, float threshold, String fallbackLanguage, boolean verbose) {
        String languageCode;
        DetectionCandidate copy$default;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fallbackLanguage, "fallbackLanguage");
        Iterator<T> it = getPreprocessors().iterator();
        String str = text;
        while (it.hasNext()) {
            str = ((DetectionPreProcessor) it.next()).process(str);
        }
        if (str.length() == 0) {
            return "<neutral>";
        }
        DetectionCandidate predict = this.languageDetector.predict(str, verbose);
        if (predict != null) {
            DetectionCandidate detectionCandidate = differentiate ? predict : null;
            if (detectionCandidate != null && (copy$default = DetectionCandidate.copy$default(detectionCandidate, this.differentiationManager.differentiate(detectionCandidate.getLanguageCode(), text), 0.0f, 2, null)) != null) {
                predict = copy$default;
            }
        }
        if (predict == null) {
            return fallbackLanguage;
        }
        DetectionCandidate detectionCandidate2 = predict.getProbability() >= threshold ? predict : null;
        return (detectionCandidate2 == null || (languageCode = detectionCandidate2.getLanguageCode()) == null) ? fallbackLanguage : languageCode;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.LanguageDetectionService
    public List<DetectionCandidate> identifyLanguageAndGetCandidates(String text, int maxCandidate, boolean differentiate, boolean verbose) {
        Intrinsics.checkNotNullParameter(text, "text");
        Iterator<T> it = getPreprocessors().iterator();
        String str = text;
        while (it.hasNext()) {
            str = ((DetectionPreProcessor) it.next()).process(str);
        }
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return CollectionsKt.listOf(new DetectionCandidate("en", 1.0f));
        }
        List<DetectionCandidate> predictAndGetCandidates = this.languageDetector.predictAndGetCandidates(str, maxCandidate, verbose);
        List<DetectionCandidate> list = differentiate ? predictAndGetCandidates : null;
        if (list == null) {
            return predictAndGetCandidates;
        }
        List<DetectionCandidate> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (DetectionCandidate detectionCandidate : list2) {
            arrayList.add(new DetectionCandidate(this.differentiationManager.differentiate(detectionCandidate.getLanguageCode(), text), detectionCandidate.getProbability()));
        }
        return arrayList;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.LanguageDetectionService
    public void clear() {
        this.languageDetector.unload();
    }

    private final List<DetectionPreProcessor> getPreprocessors() {
        DetectionPreProcessor[] detectionPreProcessorArr = new DetectionPreProcessor[5];
        Provider<DetectionPreProcessor> provider = this.preprocessors.get(TagRemovingProcessor.class);
        DetectionPreProcessor detectionPreProcessor = provider != null ? provider.get() : null;
        if (detectionPreProcessor == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        detectionPreProcessorArr[0] = detectionPreProcessor;
        Provider<DetectionPreProcessor> provider2 = this.preprocessors.get(NeutralCharFilteringProcessor.class);
        DetectionPreProcessor detectionPreProcessor2 = provider2 != null ? provider2.get() : null;
        if (detectionPreProcessor2 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        detectionPreProcessorArr[1] = detectionPreProcessor2;
        Provider<DetectionPreProcessor> provider3 = this.preprocessors.get(SymbolFilteringProcessor.class);
        DetectionPreProcessor detectionPreProcessor3 = provider3 != null ? provider3.get() : null;
        if (detectionPreProcessor3 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        detectionPreProcessorArr[2] = detectionPreProcessor3;
        Provider<DetectionPreProcessor> provider4 = this.preprocessors.get(SpaceAndNewlineProcessor.class);
        DetectionPreProcessor detectionPreProcessor4 = provider4 != null ? provider4.get() : null;
        if (detectionPreProcessor4 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        detectionPreProcessorArr[3] = detectionPreProcessor4;
        Provider<DetectionPreProcessor> provider5 = this.preprocessors.get(RepetitionRemovingProcessor.class);
        DetectionPreProcessor detectionPreProcessor5 = provider5 != null ? provider5.get() : null;
        if (detectionPreProcessor5 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        detectionPreProcessorArr[4] = detectionPreProcessor5;
        return CollectionsKt.listOf((Object[]) detectionPreProcessorArr);
    }
}
