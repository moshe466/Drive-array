package com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SymbolNormalizer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002¨\u0006\u0011"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/SymbolNormalizer;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/Normalizer;", "()V", "getNormalizer", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/Replacer;", "sourceLang", JsonProperty.USE_DEFAULT_NAME, "targetLang", "normalize", "language", "text", "targetLanguage", "useSrpolReplacer", JsonProperty.USE_DEFAULT_NAME, "srcLang", "tgtLang", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SymbolNormalizer implements Normalizer {
    private static final List<RegexReplaceRule> baseReplaceRules;
    private static final List<RegexReplaceRule> csCzReplaceRules;
    private static final List<RegexReplaceRule> deEsCzCsFrCommaBetweenNumberReplaceRules;
    private static final List<RegexReplaceRule> deEsFrReplaceRules;
    private static final List<RegexReplaceRule> defaultCommaBetweenNumberReplaceRules;
    private static final List<RegexReplaceRule> defaultQuotationFollowedByCommaReplaceRules;
    private static final List<RegexReplaceRule> defaultReplaceRules;
    private static final List<RegexReplaceRule> enReplaceRules;
    private static final List<RegexReplaceRule> englishQuotationFollowedByCommaReplaceRules;

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.Normalizer
    public String normalize(String language, String text, String targetLanguage) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return getNormalizer(language, targetLanguage).replace(text);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        if (r3.equals("ja") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0054, code lost:
    
        r3 = com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.SymbolNormalizer.enReplaceRules;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        if (r3.equals("fr") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        r3 = com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.SymbolNormalizer.deEsFrReplaceRules;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0048, code lost:
    
        if (r3.equals("es") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0051, code lost:
    
        if (r3.equals("en") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005d, code lost:
    
        if (r3.equals("de") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        if (r3.equals("cz") == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0077, code lost:
    
        r3 = com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.SymbolNormalizer.csCzReplaceRules;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0072, code lost:
    
        if (r3.equals("cs") == false) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.Replacer getNormalizer(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            boolean r4 = r2.useSrpolReplacer(r3, r4)
            if (r4 == 0) goto Ld
            com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.RuleBasedReplacer r3 = com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.SrpolReplacerKt.createSrpolReplacer(r3)
            com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.Replacer r3 = (com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.Replacer) r3
            return r3
        Ld:
            com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.RuleBasedReplacer r4 = new com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.RuleBasedReplacer
            int r0 = r3.hashCode()
            r1 = 3184(0xc70, float:4.462E-42)
            if (r0 == r1) goto L6c
            r1 = 3191(0xc77, float:4.472E-42)
            if (r0 == r1) goto L63
            r1 = 3201(0xc81, float:4.486E-42)
            if (r0 == r1) goto L57
            r1 = 3241(0xca9, float:4.542E-42)
            if (r0 == r1) goto L4b
            r1 = 3246(0xcae, float:4.549E-42)
            if (r0 == r1) goto L42
            r1 = 3276(0xccc, float:4.59E-42)
            if (r0 == r1) goto L39
            r1 = 3383(0xd37, float:4.74E-42)
            if (r0 == r1) goto L30
            goto L74
        L30:
            java.lang.String r0 = "ja"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L54
            goto L74
        L39:
            java.lang.String r0 = "fr"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L60
            goto L74
        L42:
            java.lang.String r0 = "es"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L60
            goto L74
        L4b:
            java.lang.String r0 = "en"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L54
            goto L74
        L54:
            java.util.List<com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.RegexReplaceRule> r3 = com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.SymbolNormalizer.enReplaceRules
            goto L79
        L57:
            java.lang.String r0 = "de"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L60
            goto L74
        L60:
            java.util.List<com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.RegexReplaceRule> r3 = com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.SymbolNormalizer.deEsFrReplaceRules
            goto L79
        L63:
            java.lang.String r0 = "cz"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L77
            goto L74
        L6c:
            java.lang.String r0 = "cs"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L77
        L74:
            java.util.List<com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.RegexReplaceRule> r3 = com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.SymbolNormalizer.defaultReplaceRules
            goto L79
        L77:
            java.util.List<com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.RegexReplaceRule> r3 = com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.SymbolNormalizer.csCzReplaceRules
        L79:
            r4.<init>(r3)
            com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.Replacer r4 = (com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.Replacer) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.SymbolNormalizer.getNormalizer(java.lang.String, java.lang.String):com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer.Replacer");
    }

    private final boolean useSrpolReplacer(String srcLang, String tgtLang) {
        Set of = SetsKt.setOf((Object[]) new String[]{"ar", "de", "es", "esmx", "esus", "fr", "frca", "hi", "it", "pl", "ptbr"});
        return (Intrinsics.areEqual(srcLang, "en") && of.contains(tgtLang)) || (Intrinsics.areEqual(tgtLang, "en") && of.contains(srcLang));
    }

    static {
        List<RegexReplaceRule> englishQuotationFollowedByCommaReplaceRules2 = RegexReplaceRuleKt.getEnglishQuotationFollowedByCommaReplaceRules();
        englishQuotationFollowedByCommaReplaceRules = englishQuotationFollowedByCommaReplaceRules2;
        List<RegexReplaceRule> defaultQuotationFollowedByCommaReplaceRules2 = RegexReplaceRuleKt.getDefaultQuotationFollowedByCommaReplaceRules();
        defaultQuotationFollowedByCommaReplaceRules = defaultQuotationFollowedByCommaReplaceRules2;
        List<RegexReplaceRule> deEsCzCsFrCommaBetweenNumberReplaceRules2 = RegexReplaceRuleKt.getDeEsCzCsFrCommaBetweenNumberReplaceRules();
        deEsCzCsFrCommaBetweenNumberReplaceRules = deEsCzCsFrCommaBetweenNumberReplaceRules2;
        List<RegexReplaceRule> defaultCommaBetweenNumberReplaceRules2 = RegexReplaceRuleKt.getDefaultCommaBetweenNumberReplaceRules();
        defaultCommaBetweenNumberReplaceRules = defaultCommaBetweenNumberReplaceRules2;
        List<RegexReplaceRule> flatten = CollectionsKt.flatten(CollectionsKt.listOf((Object[]) new List[]{RegexReplaceRuleKt.getCarriageReturnReplaceRules(), RegexReplaceRuleKt.getRemoveExtraSpaceReplaceRules(), RegexReplaceRuleKt.getUnicodePunctuationReplaceRules(), RegexReplaceRuleKt.getFrenchQuotesReplaceRules(), RegexReplaceRuleKt.getPseudoSpacesReplaceRules()}));
        baseReplaceRules = flatten;
        enReplaceRules = CollectionsKt.flatten(CollectionsKt.listOf((Object[]) new List[]{flatten, englishQuotationFollowedByCommaReplaceRules2, defaultCommaBetweenNumberReplaceRules2}));
        csCzReplaceRules = CollectionsKt.flatten(CollectionsKt.listOf((Object[]) new List[]{flatten, deEsCzCsFrCommaBetweenNumberReplaceRules2}));
        deEsFrReplaceRules = CollectionsKt.flatten(CollectionsKt.listOf((Object[]) new List[]{flatten, defaultQuotationFollowedByCommaReplaceRules2, deEsCzCsFrCommaBetweenNumberReplaceRules2}));
        defaultReplaceRules = CollectionsKt.flatten(CollectionsKt.listOf((Object[]) new List[]{flatten, defaultQuotationFollowedByCommaReplaceRules2, defaultCommaBetweenNumberReplaceRules2}));
    }
}
