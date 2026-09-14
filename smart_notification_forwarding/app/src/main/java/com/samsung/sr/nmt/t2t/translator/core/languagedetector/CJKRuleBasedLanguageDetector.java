package com.samsung.sr.nmt.t2t.translator.core.languagedetector;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;

/* compiled from: CJKRuleBasedLanguageDetector.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\nH\u0096\u0001J\t\u0010\u000b\u001a\u00020\fH\u0096\u0001J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\t\u0010\u0017\u001a\u00020\fH\u0096\u0001J\u0014\u0010\u0018\u001a\u00020\u0006*\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\f\u0010\u001b\u001a\u00020\u0006*\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/CJKRuleBasedLanguageDetector;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;", "alternateDetector", "confidenceThreshold", JsonProperty.USE_DEFAULT_NAME, "chineseRuleApplicableMinLength", JsonProperty.USE_DEFAULT_NAME, "chineseValidThreshold", "(Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;FIF)V", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "load", JsonProperty.USE_DEFAULT_NAME, "predict", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DetectionCandidate;", "input", JsonProperty.USE_DEFAULT_NAME, "verbose", "predictAndGetCandidates", JsonProperty.USE_DEFAULT_NAME, "maxCandidate", "predictByRule", "validCharLength", "unload", "count", "regex", "Lkotlin/text/Regex;", "getLengthExceptSymbol", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class CJKRuleBasedLanguageDetector implements LanguageDetector {
    private final LanguageDetector alternateDetector;
    private final int chineseRuleApplicableMinLength;
    private final float chineseValidThreshold;
    private final float confidenceThreshold;
    private static final Regex koRegex = new Regex("\\p{InHANGUL_COMPATIBILITY_JAMO}|\\p{InHANGUL_JAMO}|\\p{InHANGUL_SYLLABLES}");
    private static final Regex jaRegex = new Regex("\\p{InHiragana}|\\p{InKatakana}");
    private static final Regex zhRegex = new Regex("\\p{InCJK_UNIFIED_IDEOGRAPHS_EXTENSION_A}|\\p{InCJK_UNIFIED_IDEOGRAPHS}|\\p{InCJK_COMPATIBILITY_IDEOGRAPHS}|\\p{InCJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT}");
    private static final Regex symbolRegex = new Regex("\\p{S}|\\p{P}|( )");
    private static final Regex SPECIAL_CHAR_REGEX = new Regex("[・く]");

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public boolean isLoaded() {
        return this.alternateDetector.isLoaded();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public void load() {
        this.alternateDetector.load();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public void unload() {
        this.alternateDetector.unload();
    }

    public CJKRuleBasedLanguageDetector(LanguageDetector alternateDetector, float f, int i, float f2) {
        Intrinsics.checkNotNullParameter(alternateDetector, "alternateDetector");
        this.alternateDetector = alternateDetector;
        this.confidenceThreshold = f;
        this.chineseRuleApplicableMinLength = i;
        this.chineseValidThreshold = f2;
    }

    public /* synthetic */ CJKRuleBasedLanguageDetector(LanguageDetector languageDetector, float f, int i, float f2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(languageDetector, (i2 & 2) != 0 ? 0.2f : f, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? 0.3f : f2);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public DetectionCandidate predict(String input, boolean verbose) {
        Intrinsics.checkNotNullParameter(input, "input");
        int lengthExceptSymbol = getLengthExceptSymbol(input);
        if (lengthExceptSymbol == 0) {
            return null;
        }
        DetectionCandidate predictByRule = predictByRule(input, lengthExceptSymbol);
        return predictByRule == null ? this.alternateDetector.predict(input, verbose) : predictByRule;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetector
    public List<DetectionCandidate> predictAndGetCandidates(String input, int maxCandidate, boolean verbose) {
        List<DetectionCandidate> listOf;
        Intrinsics.checkNotNullParameter(input, "input");
        int lengthExceptSymbol = getLengthExceptSymbol(input);
        if (lengthExceptSymbol == 0) {
            return CollectionsKt.emptyList();
        }
        DetectionCandidate predictByRule = predictByRule(input, lengthExceptSymbol);
        return (predictByRule == null || (listOf = CollectionsKt.listOf(predictByRule)) == null) ? this.alternateDetector.predictAndGetCandidates(input, maxCandidate, verbose) : listOf;
    }

    private final int getLengthExceptSymbol(String str) {
        return str.length() - SequencesKt.count(Regex.findAll$default(symbolRegex, str, 0, 2, null));
    }

    private final int count(String str, Regex regex) {
        return SequencesKt.count(Regex.findAll$default(regex, str, 0, 2, null));
    }

    private final DetectionCandidate predictByRule(String input, int validCharLength) {
        DetectionCandidate detectionCandidate;
        DetectionCandidate detectionCandidate2;
        String replace = SPECIAL_CHAR_REGEX.replace(input, JsonProperty.USE_DEFAULT_NAME);
        float f = validCharLength;
        float count = count(replace, koRegex) / f;
        float count2 = count(replace, jaRegex) / f;
        float count3 = count(replace, zhRegex) / f;
        if (count > 0.0f || count2 > 0.0f) {
            if (count > count2) {
                detectionCandidate = new DetectionCandidate("ko", count + count3);
            } else {
                detectionCandidate = new DetectionCandidate("ja", count2 + count3);
            }
            detectionCandidate2 = detectionCandidate;
        } else {
            detectionCandidate2 = (validCharLength < this.chineseRuleApplicableMinLength || count3 < this.chineseValidThreshold) ? null : new DetectionCandidate("zh", 1.0f);
        }
        if (detectionCandidate2 == null) {
            return null;
        }
        if (detectionCandidate2.getProbability() >= this.confidenceThreshold) {
            return detectionCandidate2;
        }
        return null;
    }
}
