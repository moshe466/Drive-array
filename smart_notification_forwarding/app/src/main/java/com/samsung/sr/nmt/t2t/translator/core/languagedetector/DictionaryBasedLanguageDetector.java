package com.samsung.sr.nmt.t2t.translator.core.languagedetector;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DictionaryBasedLanguageDetector.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002J\t\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u0016J&\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\nH\u0016J\t\u0010\u0014\u001a\u00020\fH\u0096\u0001R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DictionaryBasedLanguageDetector;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;", "ruleBasedLanguageDetector", "languageDetectorDictionary", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "(Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;Ljava/util/Map;)V", "dictionaryBasedPreprocessing", "input", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "load", JsonProperty.USE_DEFAULT_NAME, "predict", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DetectionCandidate;", "verbose", "predictAndGetCandidates", JsonProperty.USE_DEFAULT_NAME, "maxCandidate", JsonProperty.USE_DEFAULT_NAME, "unload", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class DictionaryBasedLanguageDetector implements LanguageDetector {
    private final Map<String, String> languageDetectorDictionary;
    private final LanguageDetector ruleBasedLanguageDetector;

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public boolean isLoaded() {
        return this.ruleBasedLanguageDetector.isLoaded();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public void load() {
        this.ruleBasedLanguageDetector.load();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public void unload() {
        this.ruleBasedLanguageDetector.unload();
    }

    public DictionaryBasedLanguageDetector(LanguageDetector ruleBasedLanguageDetector, Map<String, String> languageDetectorDictionary) {
        Intrinsics.checkNotNullParameter(ruleBasedLanguageDetector, "ruleBasedLanguageDetector");
        Intrinsics.checkNotNullParameter(languageDetectorDictionary, "languageDetectorDictionary");
        this.ruleBasedLanguageDetector = ruleBasedLanguageDetector;
        this.languageDetectorDictionary = languageDetectorDictionary;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public List<DetectionCandidate> predictAndGetCandidates(String input, int maxCandidate, boolean verbose) {
        List<DetectionCandidate> predictAndGetCandidates;
        Intrinsics.checkNotNullParameter(input, "input");
        synchronized (this) {
            String dictionaryBasedPreprocessing = dictionaryBasedPreprocessing(StringsKt.trim((CharSequence) input).toString());
            String str = this.languageDetectorDictionary.get(dictionaryBasedPreprocessing);
            if (str == null || (predictAndGetCandidates = CollectionsKt.listOf(new DetectionCandidate(str, 1.0f))) == null) {
                predictAndGetCandidates = this.ruleBasedLanguageDetector.predictAndGetCandidates(dictionaryBasedPreprocessing, maxCandidate, verbose);
            }
        }
        return predictAndGetCandidates;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public DetectionCandidate predict(String input, boolean verbose) {
        DetectionCandidate predict;
        Intrinsics.checkNotNullParameter(input, "input");
        synchronized (this) {
            String dictionaryBasedPreprocessing = dictionaryBasedPreprocessing(StringsKt.trim((CharSequence) input).toString());
            String str = this.languageDetectorDictionary.get(dictionaryBasedPreprocessing);
            if (str != null) {
                predict = new DetectionCandidate(str, 1.0f);
            } else {
                predict = this.ruleBasedLanguageDetector.predict(dictionaryBasedPreprocessing, verbose);
            }
        }
        return predict;
    }

    private final String dictionaryBasedPreprocessing(String input) {
        return StringsKt.replace$default(input, "'", "''", false, 4, (Object) null);
    }
}
