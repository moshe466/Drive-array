package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator.ChineseDifferentiator;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator.LanguageDifferentiator;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.inject.Singleton;
import kotlin.Metadata;

/* compiled from: LanguageDifferentiatorModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/LanguageDifferentiatorModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "provideChineseDifferentiator", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/differentiator/LanguageDifferentiator;", "chineseDifferentiator", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/differentiator/ChineseDifferentiator;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public abstract class LanguageDifferentiatorModule {
    @Binds
    @StringKey("zh")
    @Singleton
    @IntoMap
    public abstract LanguageDifferentiator provideChineseDifferentiator(ChineseDifferentiator chineseDifferentiator);
}
