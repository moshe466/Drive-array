package com.samsung.sr.nmt.t2t.translator.core.languagedetector;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.LoggerFactory;
import com.samsung.sr.nmt.t2t.translator.core.utils.SimpleLogger;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VietnameseRuleBasedLanguageDetector.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/VietnameseRuleBasedLanguageDetector;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/RuleBasedLanguageDetector;", "alternateDetector", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;", "(Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/LanguageDetector;)V", "logger", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/SimpleLogger;", "predictByRule", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DetectionCandidate;", "input", JsonProperty.USE_DEFAULT_NAME, "verbose", JsonProperty.USE_DEFAULT_NAME, "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class VietnameseRuleBasedLanguageDetector extends RuleBasedLanguageDetector {
    private static final int NON_VIETNAMESE_ALPHABET_PENALTY = -1;
    private static final int VIETNAMESE_FREQUENT_ALPHABET_SCORE = 1;
    private static final int VIETNAMESE_ONLY_ALPHABET_SCORE = 10;
    private static final float VIETNAMESE_RULE_CONFIDENCE_THRESHOLD = 0.3f;
    private final SimpleLogger logger;
    private static final Set<Character> VIETNAMESE_ONLY_ALPHABET = SetsKt.setOf((Object[]) new Character[]{(char) 7901, (char) 7875, (char) 7873, (char) 7907, (char) 7903, (char) 7913, (char) 7855, (char) 7921, (char) 7915, (char) 7863, (char) 7893, (char) 7895, (char) 7867, (char) 7851, (char) 7877, (char) 7849, (char) 7859, (char) 7905, (char) 7927, (char) 7861, (char) 7925});
    private static final Set<Character> VIETNAMESE_FREQUENT_ALPHABET = SetsKt.setOf((Object[]) new Character[]{(char) 273, (char) 244, (char) 224, (char) 432, (char) 7841, (char) 7845, (char) 7871, (char) 7897, (char) 7901, (char) 7889, (char) 7843, (char) 234, (char) 7899, (char) 236, (char) 226, (char) 7911, (char) 7875, (char) 7873, (char) 7879, (char) 7853, (char) 250, (char) 7907, (char) 7885, (char) 417, (char) 7847, (char) 7903, (char) 7883, (char) 259, (char) 7919, (char) 7913, (char) 7855, (char) 7921, (char) 7891, (char) 7915, (char) 7869, (char) 242, (char) 7863, (char) 7893, (char) 249, (char) 7887, (char) 7909, (char) 7857, (char) 7881, (char) 297, (char) 7917, (char) 253, (char) 361, (char) 7895, (char) 7865, (char) 7867});
    private static final Set<Character> NON_VIETNAMESE_ALPHABET = SetsKt.setOf((Object[]) new Character[]{'f', 'j', 'w', 'z'});

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VietnameseRuleBasedLanguageDetector(LanguageDetector alternateDetector) {
        super(alternateDetector);
        Intrinsics.checkNotNullParameter(alternateDetector, "alternateDetector");
        this.logger = LoggerFactory.INSTANCE.getLogger(getClass());
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.RuleBasedLanguageDetector
    protected DetectionCandidate predictByRule(String input, boolean verbose) {
        Intrinsics.checkNotNullParameter(input, "input");
        Set<Character> set = VIETNAMESE_ONLY_ALPHABET;
        String str = input;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (set.contains(Character.valueOf(charAt))) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        int length2 = sb2.length() * 10;
        Set<Character> set2 = VIETNAMESE_FREQUENT_ALPHABET;
        StringBuilder sb3 = new StringBuilder();
        int length3 = str.length();
        for (int i2 = 0; i2 < length3; i2++) {
            char charAt2 = str.charAt(i2);
            if (set2.contains(Character.valueOf(charAt2))) {
                sb3.append(charAt2);
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "filterTo(StringBuilder(), predicate).toString()");
        int length4 = length2 + (sb4.length() * 1);
        Set<Character> set3 = NON_VIETNAMESE_ALPHABET;
        StringBuilder sb5 = new StringBuilder();
        int length5 = str.length();
        for (int i3 = 0; i3 < length5; i3++) {
            char charAt3 = str.charAt(i3);
            if (set3.contains(Character.valueOf(charAt3))) {
                sb5.append(charAt3);
            }
        }
        Intrinsics.checkNotNullExpressionValue(sb5.toString(), "filterTo(StringBuilder(), predicate).toString()");
        Float valueOf = Float.valueOf((length4 + (r1.length() * (-1))) / input.length());
        if (!(valueOf.floatValue() > VIETNAMESE_RULE_CONFIDENCE_THRESHOLD)) {
            valueOf = null;
        }
        if (valueOf == null) {
            return null;
        }
        float floatValue = valueOf.floatValue();
        if (verbose) {
            this.logger.debug("[Vi Rule-based Language Detector] input: - score: " + floatValue);
        }
        return new DetectionCandidate("vi", Math.min(floatValue, 1.0f));
    }
}
