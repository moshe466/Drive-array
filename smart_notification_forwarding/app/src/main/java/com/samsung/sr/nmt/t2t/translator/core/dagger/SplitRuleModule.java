package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.CharBasedSentenceSplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.EUSentenceSplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.EndOfLineSplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.LineLengthSplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.ThaiSentenceSplitRule;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import java.util.Set;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SplitRuleModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0007J\b\u0010\f\u001a\u00020\u0006H\u0007J\b\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u0004H\u0007¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/SplitRuleModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "provideCharBasedSentenceSplitRule", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitRule;", "isShortest", JsonProperty.USE_DEFAULT_NAME, "abbreviations", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "provideEUSentenceSplitRule", "provideEndOfLineSplitRule", "provideIsShortest", "provideLineLengthSplitRule", "provideThaiSentenceSplitRule", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class SplitRuleModule {
    @Provides
    @Named("isShortest")
    public final boolean provideIsShortest() {
        return false;
    }

    @Provides
    @ClassKey(CharBasedSentenceSplitRule.class)
    @Singleton
    @IntoMap
    public final SplitRule provideCharBasedSentenceSplitRule(@Named("isShortest") boolean isShortest, @Named("abbreviations") Set<String> abbreviations) {
        Intrinsics.checkNotNullParameter(abbreviations, "abbreviations");
        return new CharBasedSentenceSplitRule(isShortest, abbreviations);
    }

    @Provides
    @ClassKey(EndOfLineSplitRule.class)
    @Singleton
    @IntoMap
    public final SplitRule provideEndOfLineSplitRule() {
        return new EndOfLineSplitRule();
    }

    @Provides
    @ClassKey(EUSentenceSplitRule.class)
    @Singleton
    @IntoMap
    public final SplitRule provideEUSentenceSplitRule(@Named("abbreviations") Set<String> abbreviations) {
        Intrinsics.checkNotNullParameter(abbreviations, "abbreviations");
        return new EUSentenceSplitRule(abbreviations);
    }

    @Provides
    @ClassKey(LineLengthSplitRule.class)
    @Singleton
    @IntoMap
    public final SplitRule provideLineLengthSplitRule() {
        return new LineLengthSplitRule(0, 1, null);
    }

    @Provides
    @ClassKey(ThaiSentenceSplitRule.class)
    @Singleton
    @IntoMap
    public final SplitRule provideThaiSentenceSplitRule() {
        return new ThaiSentenceSplitRule();
    }
}
