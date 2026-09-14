package com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SplitterManager.kt */
@Singleton
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B$\b\u0007\u0012\u001b\u0010\u0002\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0002\u0010\u0007J \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00142\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitterManager;", JsonProperty.USE_DEFAULT_NAME, "splitterRuleMap", JsonProperty.USE_DEFAULT_NAME, "Ljava/lang/Class;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitRule;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Map;)V", "charBasedSentenceSplitRule", "endOfLineSplitRule", "euSentenceSplitRule", "lineLengthSplitRule", "thaiSplitRule", "getLanguageSplitRule", "splitRule", "language", JsonProperty.USE_DEFAULT_NAME, "needSentenceSplit", JsonProperty.USE_DEFAULT_NAME, "getSplitterList", JsonProperty.USE_DEFAULT_NAME, "getThreshold", JsonProperty.USE_DEFAULT_NAME, "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SplitterManager {
    private static final int LONG_THRESHOLD = 100;
    private static final int SHORT_THRESHOLD = 50;
    private final SplitRule charBasedSentenceSplitRule;
    private final SplitRule endOfLineSplitRule;
    private final SplitRule euSentenceSplitRule;
    private final SplitRule lineLengthSplitRule;
    private final SplitRule thaiSplitRule;
    private static final Set<String> SHORT_THRESHOLD_LANGUAGES = SetsKt.setOf((Object[]) new String[]{"ja", "ko", "zh"});
    private static final Set<String> CHAR_BASED_SPLITTER_LIST = SetsKt.setOf((Object[]) new String[]{"ja", "ko", "vi", "zh", "ar", "he", "hi"});

    @Inject
    public SplitterManager(Map<Class<?>, SplitRule> splitterRuleMap) {
        Intrinsics.checkNotNullParameter(splitterRuleMap, "splitterRuleMap");
        SplitRule splitRule = splitterRuleMap.get(EndOfLineSplitRule.class);
        if (splitRule == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        this.endOfLineSplitRule = splitRule;
        SplitRule splitRule2 = splitterRuleMap.get(ThaiSentenceSplitRule.class);
        if (splitRule2 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        this.thaiSplitRule = splitRule2;
        SplitRule splitRule3 = splitterRuleMap.get(CharBasedSentenceSplitRule.class);
        if (splitRule3 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        this.charBasedSentenceSplitRule = splitRule3;
        SplitRule splitRule4 = splitterRuleMap.get(EUSentenceSplitRule.class);
        if (splitRule4 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        this.euSentenceSplitRule = splitRule4;
        SplitRule splitRule5 = splitterRuleMap.get(LineLengthSplitRule.class);
        if (splitRule5 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        this.lineLengthSplitRule = splitRule5;
    }

    public static /* synthetic */ List getSplitterList$default(SplitterManager splitterManager, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return splitterManager.getSplitterList(str, z);
    }

    public final List<SplitRule> getSplitterList(String language, boolean needSentenceSplit) {
        Intrinsics.checkNotNullParameter(language, "language");
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.endOfLineSplitRule);
        if (Intrinsics.areEqual(language, "th")) {
            arrayList.add(getLanguageSplitRule(this.thaiSplitRule, language, needSentenceSplit));
        } else if (CHAR_BASED_SPLITTER_LIST.contains(language)) {
            arrayList.add(getLanguageSplitRule(this.charBasedSentenceSplitRule, language, needSentenceSplit));
        } else {
            arrayList.add(getLanguageSplitRule(this.euSentenceSplitRule, language, needSentenceSplit));
        }
        arrayList.add(this.lineLengthSplitRule);
        return arrayList;
    }

    private final SplitRule getLanguageSplitRule(SplitRule splitRule, String language, boolean needSentenceSplit) {
        SplitRule splitRule2 = needSentenceSplit ? splitRule : null;
        return splitRule2 == null ? new ThresholdAppliedSplitRule(getThreshold(language), splitRule) : splitRule2;
    }

    private final int getThreshold(String language) {
        return SHORT_THRESHOLD_LANGUAGES.contains(language) ? 50 : 100;
    }
}
