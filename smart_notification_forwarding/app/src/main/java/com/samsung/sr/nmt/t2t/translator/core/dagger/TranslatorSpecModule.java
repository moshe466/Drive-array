package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorSpec;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslatorSpecModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TranslatorSpecModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "provideTranslatorSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorSpec;", "translatorSpecFactory", "Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TranslatorSpecFactory;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class TranslatorSpecModule {
    @Provides
    @Singleton
    public final TranslatorSpec provideTranslatorSpec(TranslatorSpecFactory translatorSpecFactory) {
        Intrinsics.checkNotNullParameter(translatorSpecFactory, "translatorSpecFactory");
        return translatorSpecFactory.create();
    }
}
