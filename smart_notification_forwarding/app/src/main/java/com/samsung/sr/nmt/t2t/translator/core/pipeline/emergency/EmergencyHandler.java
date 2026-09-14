package com.samsung.sr.nmt.t2t.translator.core.pipeline.emergency;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.RuleUtils;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: EmergencyHandler.kt */
@Singleton
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\b\u0007¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/emergency/EmergencyHandler;", JsonProperty.USE_DEFAULT_NAME, "()V", "processEmergency", JsonProperty.USE_DEFAULT_NAME, "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "sourceText", "translatedResult", "mode", "processRightParenthesis", "processThaiPeriod", "processYahooNews", "removeRedundantTags", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EmergencyHandler {
    private static final List<Regex> tagsToClean = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("<a_[0-9]{1,2}>"), new Regex("</a_[0-9]{1,2}>"), new Regex("<PLH[0-9]{1,3}>")});

    @Inject
    public EmergencyHandler() {
    }

    public static /* synthetic */ String processEmergency$default(EmergencyHandler emergencyHandler, LanguageDirection languageDirection, String str, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = "plain";
        }
        return emergencyHandler.processEmergency(languageDirection, str, str2, str3);
    }

    public final String processEmergency(LanguageDirection languageDirection, String sourceText, String translatedResult, String mode) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(translatedResult, "translatedResult");
        Intrinsics.checkNotNullParameter(mode, "mode");
        String removeRedundantTags = removeRedundantTags(sourceText, translatedResult);
        if (Intrinsics.areEqual(languageDirection.getTgtLang(), "th")) {
            return processThaiPeriod(removeRedundantTags);
        }
        if (Intrinsics.areEqual(languageDirection.getSrcLang(), "en") && Intrinsics.areEqual(languageDirection.getTgtLang(), "ja")) {
            return processYahooNews(removeRedundantTags);
        }
        return processRightParenthesis(sourceText, removeRedundantTags, mode);
    }

    private final String processThaiPeriod(String translatedResult) {
        if (!StringsKt.endsWith$default((CharSequence) translatedResult, RuleUtils.DOT, false, 2, (Object) null)) {
            return translatedResult;
        }
        return StringsKt.dropLast(translatedResult, 1) + "  ";
    }

    private final String processRightParenthesis(String sourceText, String translatedResult, String mode) {
        String str = sourceText;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= str.length()) {
                break;
            }
            if (str.charAt(i) == '>') {
                i2++;
            }
            i++;
        }
        String str2 = translatedResult;
        int i3 = 0;
        for (int i4 = 0; i4 < str2.length(); i4++) {
            if (str2.charAt(i4) == '>') {
                i3++;
            }
        }
        if (i2 >= i3) {
            return translatedResult;
        }
        if (Intrinsics.areEqual(mode, "tagged")) {
            return StringsKt.indexOf$default((CharSequence) str2, ">>", 0, false, 6, (Object) null) != -1 ? StringsKt.replace$default(translatedResult, ">>", ">", false, 4, (Object) null) : translatedResult;
        }
        Character firstOrNull = StringsKt.firstOrNull(str2);
        if (firstOrNull != null && firstOrNull.equals(Character.valueOf(Typography.greater))) {
            z = true;
        }
        if (!z) {
            return translatedResult;
        }
        String substring = translatedResult.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }

    private final String processYahooNews(String translatedResult) {
        return StringsKt.replace$default(translatedResult, "-Yahoo!ニュース", JsonProperty.USE_DEFAULT_NAME, false, 4, (Object) null);
    }

    private final String removeRedundantTags(String sourceText, String translatedResult) {
        String str;
        Iterator<T> it = tagsToClean.iterator();
        String str2 = translatedResult;
        while (it.hasNext()) {
            while (true) {
                str = str2;
                for (String str3 : SequencesKt.toSet(SequencesKt.map(Regex.findAll$default((Regex) it.next(), translatedResult, 0, 2, null), new Function1<MatchResult, String>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.emergency.EmergencyHandler$removeRedundantTags$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(MatchResult it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return it2.getValue();
                    }
                }))) {
                    if (!StringsKt.contains$default((CharSequence) sourceText, (CharSequence) str3, false, 2, (Object) null)) {
                        break;
                    }
                }
                str2 = StringsKt.replace$default(str, str3, JsonProperty.USE_DEFAULT_NAME, false, 4, (Object) null);
            }
            str2 = str;
        }
        if (!Intrinsics.areEqual(str2, translatedResult)) {
            System.out.println((Object) ("(SR Translation Engine) Redundant Tags Detected! " + translatedResult));
        }
        return str2;
    }
}
