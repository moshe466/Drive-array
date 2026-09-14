package com.samsung.sr.nmt.t2t.translator.core.languagedetector;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RuleBasedLanguageDetector.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0016J&\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H$J\t\u0010\u0012\u001a\u00020\u0007H\u0096\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/RuleBasedLanguageDetector;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;", "alternateDetector", "(Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;)V", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "load", JsonProperty.USE_DEFAULT_NAME, "predict", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DetectionCandidate;", "input", JsonProperty.USE_DEFAULT_NAME, "verbose", "predictAndGetCandidates", JsonProperty.USE_DEFAULT_NAME, "maxCandidate", JsonProperty.USE_DEFAULT_NAME, "predictByRule", "unload", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public abstract class RuleBasedLanguageDetector implements LanguageDetector {
    private final LanguageDetector alternateDetector;

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public boolean isLoaded() {
        return this.alternateDetector.isLoaded();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public void load() {
        this.alternateDetector.load();
    }

    protected abstract DetectionCandidate predictByRule(String input, boolean verbose);

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public void unload() {
        this.alternateDetector.unload();
    }

    public RuleBasedLanguageDetector(LanguageDetector alternateDetector) {
        Intrinsics.checkNotNullParameter(alternateDetector, "alternateDetector");
        this.alternateDetector = alternateDetector;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public List<DetectionCandidate> predictAndGetCandidates(String input, int maxCandidate, boolean verbose) {
        List<DetectionCandidate> listOf;
        Intrinsics.checkNotNullParameter(input, "input");
        DetectionCandidate predictByRule = predictByRule(input, verbose);
        return (predictByRule == null || (listOf = CollectionsKt.listOf(predictByRule)) == null) ? this.alternateDetector.predictAndGetCandidates(input, maxCandidate, verbose) : listOf;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public DetectionCandidate predict(String input, boolean verbose) {
        Intrinsics.checkNotNullParameter(input, "input");
        DetectionCandidate predictByRule = predictByRule(input, verbose);
        return predictByRule == null ? this.alternateDetector.predict(input, verbose) : predictByRule;
    }
}
