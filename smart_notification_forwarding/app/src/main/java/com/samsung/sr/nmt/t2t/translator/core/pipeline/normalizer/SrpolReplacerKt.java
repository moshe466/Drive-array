package com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* compiled from: SrpolReplacer.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"EnQuoteStyleRules", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/ReplaceRule;", "SrpolRules", "StandardQuoteStyleRules", "createSrpolReplacer", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/RuleBasedReplacer;", "language", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SrpolReplacerKt {
    private static final List<ReplaceRule> EnQuoteStyleRules = CollectionsKt.listOf(RegexReplaceRuleKt.createRegexRule$default("\"([.,]+)", "$1\"", null, 4, null));
    private static final List<ReplaceRule> StandardQuoteStyleRules = CollectionsKt.listOf((Object[]) new LiteralStringReplaceRule[]{LiteralReplaceRuleKt.createLiteralRule(",\"", "\","), LiteralReplaceRuleKt.createLiteralRule("(\\.+)\"(\\s*[^.])", "\"$1$2")});
    private static final List<ReplaceRule> SrpolRules = CollectionsKt.listOf((Object[]) new ReplaceRule[]{LiteralReplaceRuleKt.createLiteralRule("\r", JsonProperty.USE_DEFAULT_NAME), RegexReplaceRuleKt.createRegexRule$default("[\u2000-\u2009\u2028-\u2029\t]", " ", null, 4, null), LiteralReplaceRuleKt.createLiteralRule("(", " ("), LiteralReplaceRuleKt.createLiteralRule(")", ") "), RegexReplaceRuleKt.createRegexRule$default(" +", " ", null, 4, null), RegexReplaceRuleKt.createRegexRule$default("\\) ([.!:?;,])", ")$1", null, 4, null), LiteralReplaceRuleKt.createLiteralRule("( ", "("), LiteralReplaceRuleKt.createLiteralRule(" )", ")"), RegexReplaceRuleKt.createRegexRule$default("(\\d) %", "$1%", null, 4, null), LiteralReplaceRuleKt.createLiteralRule(" :", ":"), LiteralReplaceRuleKt.createLiteralRule(" ;", ";"), RegexReplaceRuleKt.createRegexRule$default("[‘-‛′〵´`]", "'", null, 4, null), RegexReplaceRuleKt.createRegexRule$default("[“-‟″‶]", "\"", null, 4, null), LiteralReplaceRuleKt.createLiteralRule("''", "\""), LiteralReplaceRuleKt.createLiteralRule("—", " - "), RegexReplaceRuleKt.createRegexRule$default("[‐-―⁃−]", "-", null, 4, null), LiteralReplaceRuleKt.createLiteralRule("…", "..."), LiteralReplaceRuleKt.createLiteralRule("⁇", "??"), LiteralReplaceRuleKt.createLiteralRule("⁈", "?!"), LiteralReplaceRuleKt.createLiteralRule("⁉", "!?"), LiteralReplaceRuleKt.createLiteralRule("‼", "!!"), LiteralReplaceRuleKt.createLiteralRule("℃", "°C"), LiteralReplaceRuleKt.createLiteralRule("℉", "°F"), LiteralReplaceRuleKt.createLiteralRule(" « ", " \""), LiteralReplaceRuleKt.createLiteralRule("« ", "\""), LiteralReplaceRuleKt.createLiteralRule("«", "\""), LiteralReplaceRuleKt.createLiteralRule(" » ", "\" "), LiteralReplaceRuleKt.createLiteralRule(" »", "\""), LiteralReplaceRuleKt.createLiteralRule("»", "\""), LiteralReplaceRuleKt.createLiteralRule(" %", "%"), LiteralReplaceRuleKt.createLiteralRule(" :", ":"), LiteralReplaceRuleKt.createLiteralRule(" ;", ";"), LiteralReplaceRuleKt.createLiteralRule(" ?", "?"), LiteralReplaceRuleKt.createLiteralRule(" !", "!"), LiteralReplaceRuleKt.createLiteralRule(Typography.nbsp, ' '), RegexReplaceRuleKt.createRegexRule$default(" +", " ", null, 4, null), RegexReplaceRuleKt.createRegexRule$default("^\\s+|\\s+$", JsonProperty.USE_DEFAULT_NAME, null, 4, null)});

    public static final RuleBasedReplacer createSrpolReplacer(String language) {
        Intrinsics.checkNotNullParameter(language, "language");
        List[] listArr = new List[2];
        listArr[0] = SrpolRules;
        listArr[1] = Intrinsics.areEqual(language, "en") ? EnQuoteStyleRules : StandardQuoteStyleRules;
        return new RuleBasedReplacer(CollectionsKt.flatten(CollectionsKt.listOf((Object[]) listArr)));
    }
}
