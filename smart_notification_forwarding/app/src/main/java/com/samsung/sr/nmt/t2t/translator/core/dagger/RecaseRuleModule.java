package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.AllUppercaseRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.AllUppercaseWithWhitespacesRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.CamelcaseRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.FirstLetterUppercaseRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import javax.inject.Singleton;
import kotlin.Metadata;

/* compiled from: RecaseRuleModule.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/RecaseRuleModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "provideAllUppercaseRule", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRule;", "provideAllUppercaseWithWhitespacesRule", "provideCamelcaseRule", "provideFirstLetterUppercaseRule", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class RecaseRuleModule {
    @Provides
    @ClassKey(FirstLetterUppercaseRule.class)
    @Singleton
    @IntoMap
    public final RecaseRule provideFirstLetterUppercaseRule() {
        return new FirstLetterUppercaseRule();
    }

    @Provides
    @ClassKey(AllUppercaseRule.class)
    @Singleton
    @IntoMap
    public final RecaseRule provideAllUppercaseRule() {
        return new AllUppercaseRule();
    }

    @Provides
    @ClassKey(AllUppercaseWithWhitespacesRule.class)
    @Singleton
    @IntoMap
    public final RecaseRule provideAllUppercaseWithWhitespacesRule() {
        return new AllUppercaseWithWhitespacesRule();
    }

    @Provides
    @ClassKey(CamelcaseRule.class)
    @Singleton
    @IntoMap
    public final RecaseRule provideCamelcaseRule() {
        return new CamelcaseRule();
    }
}
