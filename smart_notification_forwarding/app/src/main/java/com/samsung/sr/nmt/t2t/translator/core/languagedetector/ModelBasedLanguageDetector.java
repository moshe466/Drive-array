package com.samsung.sr.nmt.t2t.translator.core.languagedetector;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.LoggerFactory;
import com.samsung.sr.nmt.t2t.translator.core.utils.SimpleLogger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ModelBasedLanguageDetector.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0016J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/ModelBasedLanguageDetector;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;", "languageDetectorJni", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetectorJni;", "(Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetectorJni;)V", "logger", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/SimpleLogger;", "filterExcludedLanguages", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DetectionCandidate;", "candidates", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "load", JsonProperty.USE_DEFAULT_NAME, "predict", "input", JsonProperty.USE_DEFAULT_NAME, "verbose", "predictAndGetCandidates", "maxCandidate", JsonProperty.USE_DEFAULT_NAME, "unload", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ModelBasedLanguageDetector implements LanguageDetector {
    private static final Set<String> excludedLanguages = SetsKt.setOf((Object[]) new String[]{"gl", "sk"});
    private final LanguageDetectorJni languageDetectorJni;
    private final SimpleLogger logger;

    public ModelBasedLanguageDetector(LanguageDetectorJni languageDetectorJni) {
        Intrinsics.checkNotNullParameter(languageDetectorJni, "languageDetectorJni");
        this.languageDetectorJni = languageDetectorJni;
        this.logger = LoggerFactory.INSTANCE.getLogger(getClass());
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public void unload() {
        this.languageDetectorJni.clear();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public boolean isLoaded() {
        return this.languageDetectorJni.isLoaded();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public List<DetectionCandidate> predictAndGetCandidates(String input, int maxCandidate, boolean verbose) {
        Intrinsics.checkNotNullParameter(input, "input");
        synchronized (this) {
            if (!isLoaded()) {
                load();
            }
            String obj = StringsKt.trim((CharSequence) input).toString();
            if (obj.length() == 0) {
                return CollectionsKt.emptyList();
            }
            List<DetectionCandidate> filterExcludedLanguages = filterExcludedLanguages(this.languageDetectorJni.predictAndGetCandidates(obj, maxCandidate));
            if (verbose) {
                this.logger.debug("[Language Detection Result] input: -, result: " + CollectionsKt.joinToString$default(filterExcludedLanguages, JsonProperty.USE_DEFAULT_NAME, null, null, 0, null, null, 62, null));
            }
            return filterExcludedLanguages;
        }
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public DetectionCandidate predict(String input, boolean verbose) {
        Intrinsics.checkNotNullParameter(input, "input");
        synchronized (this) {
            if (!isLoaded()) {
                load();
            }
            String obj = StringsKt.trim((CharSequence) input).toString();
            if (obj.length() == 0) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            DetectionCandidate detectionCandidate = (DetectionCandidate) CollectionsKt.firstOrNull((List) filterExcludedLanguages(this.languageDetectorJni.predictAndGetCandidates(obj, excludedLanguages.size() + 1)));
            if (verbose) {
                this.logger.debug("Input Text | - | Detected language | " + (detectionCandidate != null ? detectionCandidate.getLanguageCode() : null) + " | Probability | " + (detectionCandidate != null ? Float.valueOf(detectionCandidate.getProbability()) : null) + " | Cost | " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            }
            return detectionCandidate;
        }
    }

    private final List<DetectionCandidate> filterExcludedLanguages(List<DetectionCandidate> candidates) {
        float probability;
        ArrayList arrayList = new ArrayList();
        while (true) {
            for (DetectionCandidate detectionCandidate : candidates) {
                probability = excludedLanguages.contains(detectionCandidate.getLanguageCode()) ? probability + detectionCandidate.getProbability() : 0.0f;
            }
            return arrayList;
            arrayList.add(DetectionCandidate.copy$default(detectionCandidate, null, detectionCandidate.getProbability() + probability, 1, null));
        }
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public void load() {
        long currentTimeMillis = System.currentTimeMillis();
        this.languageDetectorJni.load();
        this.logger.debug("[Language Detector Load] elapsed time: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }
}
