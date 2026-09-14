package com.samsung.sr.nmt.t2t.translator.core.pipeline.normalizer;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* compiled from: RegexReplaceRule.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\u001a&\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u001a\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u001a\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u001a\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u001a\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u001a\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u001a\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u001a\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u001a\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\t\u001a\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\t¨\u0006\u0012"}, d2 = {"createRegexRule", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/normalizer/RegexReplaceRule;", "regexString", JsonProperty.USE_DEFAULT_NAME, "replaceTo", "options", JsonProperty.USE_DEFAULT_NAME, "Lkotlin/text/RegexOption;", "getCarriageReturnReplaceRules", JsonProperty.USE_DEFAULT_NAME, "getDeEsCzCsFrCommaBetweenNumberReplaceRules", "getDefaultCommaBetweenNumberReplaceRules", "getDefaultQuotationFollowedByCommaReplaceRules", "getEnglishQuotationFollowedByCommaReplaceRules", "getFrenchQuotesReplaceRules", "getPseudoSpacesReplaceRules", "getRemoveExtraSpaceReplaceRules", "getUnicodePunctuationReplaceRules", "translator-core"}, k = 2, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RegexReplaceRuleKt {
    public static /* synthetic */ RegexReplaceRule createRegexRule$default(String str, String str2, Set set, int i, Object obj) {
        if ((i & 4) != 0) {
            set = SetsKt.emptySet();
        }
        return createRegexRule(str, str2, set);
    }

    public static final RegexReplaceRule createRegexRule(String regexString, String replaceTo, Set<? extends RegexOption> options) {
        Intrinsics.checkNotNullParameter(regexString, "regexString");
        Intrinsics.checkNotNullParameter(replaceTo, "replaceTo");
        Intrinsics.checkNotNullParameter(options, "options");
        return new RegexReplaceRule(new Regex(regexString, options), replaceTo);
    }

    public static final List<RegexReplaceRule> getCarriageReturnReplaceRules() {
        return CollectionsKt.listOf(createRegexRule$default("\r", JsonProperty.USE_DEFAULT_NAME, null, 4, null));
    }

    public static final List<RegexReplaceRule> getRemoveExtraSpaceReplaceRules() {
        return CollectionsKt.listOf((Object[]) new RegexReplaceRule[]{createRegexRule$default("\\(", " \\(", null, 4, null), createRegexRule$default("\\)", "\\) ", null, 4, null), createRegexRule$default(" +", " ", null, 4, null), createRegexRule$default("\\) ([\\.\\!\\:\\?\\;\\,])", "\\)$1", null, 4, null), createRegexRule$default("\\( ", "\\(", null, 4, null), createRegexRule$default(" \\)", "\\)", null, 4, null), createRegexRule$default("(\\d) \\%", "$1\\%", null, 4, null), createRegexRule$default(" :", ":", null, 4, null), createRegexRule$default(" ;", ";", null, 4, null)});
    }

    public static final List<RegexReplaceRule> getUnicodePunctuationReplaceRules() {
        return CollectionsKt.listOf((Object[]) new RegexReplaceRule[]{createRegexRule$default("\\`", "\\'", null, 4, null), createRegexRule$default("\\'\\'", " \\\" ", null, 4, null), createRegexRule$default("„", "\\\"", null, 4, null), createRegexRule$default("“", "\\\"", null, 4, null), createRegexRule$default("”", "\\\"", null, 4, null), createRegexRule$default("–", "-", null, 4, null), createRegexRule$default("—", " - ", null, 4, null), createRegexRule$default(" +", " ", null, 4, null), createRegexRule$default("´", "\\'", null, 4, null), createRegexRule("([a-z])‘([a-z])", "$1\\'$2", SetsKt.setOf(RegexOption.IGNORE_CASE)), createRegexRule("([a-z])’([a-z])", "$1\\'$2", SetsKt.setOf(RegexOption.IGNORE_CASE)), createRegexRule$default("‘", "\\'", null, 4, null), createRegexRule$default("‚", "\\'", null, 4, null), createRegexRule$default("’", "\\\"", null, 4, null), createRegexRule$default("''", "\\\"", null, 4, null), createRegexRule$default("´´", "\\\"", null, 4, null), createRegexRule$default("…", "...", null, 4, null)});
    }

    public static final List<RegexReplaceRule> getFrenchQuotesReplaceRules() {
        return CollectionsKt.listOf((Object[]) new RegexReplaceRule[]{createRegexRule$default(" « ", " \"", null, 4, null), createRegexRule$default("« ", "\"", null, 4, null), createRegexRule$default("«", "\"", null, 4, null), createRegexRule$default(" » ", "\" ", null, 4, null), createRegexRule$default(" »", "\"", null, 4, null), createRegexRule$default("»", "\"", null, 4, null)});
    }

    public static final List<RegexReplaceRule> getPseudoSpacesReplaceRules() {
        return CollectionsKt.listOf((Object[]) new RegexReplaceRule[]{createRegexRule$default(" \\%", "\\%", null, 4, null), createRegexRule$default("nº ", "nº ", null, 4, null), createRegexRule$default(" :", ":", null, 4, null), createRegexRule$default(" ºC", " ºC", null, 4, null), createRegexRule$default(" cm", " cm", null, 4, null), createRegexRule$default(" \\?", "\\?", null, 4, null), createRegexRule$default(" \\!", "\\!", null, 4, null), createRegexRule$default(" ;", ";", null, 4, null), createRegexRule$default(", ", ", ", null, 4, null), createRegexRule$default(" +", " ", null, 4, null)});
    }

    public static final List<RegexReplaceRule> getEnglishQuotationFollowedByCommaReplaceRules() {
        return CollectionsKt.listOf(createRegexRule$default("\\\"([,\\.]+)", "$1\\\"", null, 4, null));
    }

    public static final List<RegexReplaceRule> getDefaultQuotationFollowedByCommaReplaceRules() {
        return CollectionsKt.listOf((Object[]) new RegexReplaceRule[]{createRegexRule$default(",\\\"", "\\\",", null, 4, null), createRegexRule$default("(\\.+)\\\"(\\s*[^<])", "\\\"$1$2", null, 4, null)});
    }

    public static final List<RegexReplaceRule> getDeEsCzCsFrCommaBetweenNumberReplaceRules() {
        return CollectionsKt.listOf(createRegexRule$default("(\\d) (\\d)", "$1,$2", null, 4, null));
    }

    public static final List<RegexReplaceRule> getDefaultCommaBetweenNumberReplaceRules() {
        return CollectionsKt.listOf(createRegexRule$default("(\\d) (\\d)", "$1.$2", null, 4, null));
    }
}
