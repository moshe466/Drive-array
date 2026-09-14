package com.samsung.sr.nmt.t2t.translator.core.languagedetector;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.LoggerFactory;
import com.samsung.sr.nmt.t2t.translator.core.utils.SimpleLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: EnglishRuleBasedLanguageDetector.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000bH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/EnglishRuleBasedLanguageDetector;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/RuleBasedLanguageDetector;", "alternateDetector", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;", "englishDictionary", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "(Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;Ljava/util/Set;)V", "logger", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/SimpleLogger;", "isSymbol", JsonProperty.USE_DEFAULT_NAME, "c", JsonProperty.USE_DEFAULT_NAME, "predictByRule", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DetectionCandidate;", "input", "verbose", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EnglishRuleBasedLanguageDetector extends RuleBasedLanguageDetector {
    private static final float ENGLISH_LENGTH_THRESHOLD = 0.5f;
    private static final float ENGLISH_RULE_CONFIDENCE_THRESHOLD = 0.8f;
    private final Set<String> englishDictionary;
    private final SimpleLogger logger;
    private static final Regex WORD_REGEX = new Regex("\\s+");

    private final boolean isSymbol(char c) {
        return c == ',' || c == '.' || c == ';' || c == ':' || c == '!';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnglishRuleBasedLanguageDetector(LanguageDetector alternateDetector, Set<String> englishDictionary) {
        super(alternateDetector);
        Intrinsics.checkNotNullParameter(alternateDetector, "alternateDetector");
        Intrinsics.checkNotNullParameter(englishDictionary, "englishDictionary");
        this.englishDictionary = englishDictionary;
        this.logger = LoggerFactory.INSTANCE.getLogger(getClass());
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.RuleBasedLanguageDetector
    protected DetectionCandidate predictByRule(String input, boolean verbose) {
        Intrinsics.checkNotNullParameter(input, "input");
        String str = input;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (true ^ isSymbol(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        List<String> split = WORD_REGEX.split(sb2, 0);
        ArrayList arrayList = new ArrayList();
        for (Object obj : split) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        Set<String> set = this.englishDictionary;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (set.contains((String) obj2)) {
                arrayList2.add(obj2);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            i += ((String) it.next()).length();
        }
        if (i / sb2.length() <= ENGLISH_LENGTH_THRESHOLD) {
            return null;
        }
        float size = r4.size() / r1.size();
        if (size <= ENGLISH_RULE_CONFIDENCE_THRESHOLD) {
            return null;
        }
        DetectionCandidate detectionCandidate = new DetectionCandidate("en", size);
        if (verbose) {
            this.logger.debug("[En Rule-based Language Detector] input: - result: " + detectionCandidate);
        }
        return detectionCandidate;
    }
}
