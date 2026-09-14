package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorModuleBuilderParams;
import com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExternalConfigurationModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/ExternalConfigurationModule;", JsonProperty.USE_DEFAULT_NAME, "translatorModuleBuilderParams", "Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorModuleBuilderParams;", "(Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorModuleBuilderParams;)V", "environmentHelper", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class ExternalConfigurationModule {
    private final TranslatorModuleBuilderParams translatorModuleBuilderParams;

    public ExternalConfigurationModule(TranslatorModuleBuilderParams translatorModuleBuilderParams) {
        Intrinsics.checkNotNullParameter(translatorModuleBuilderParams, "translatorModuleBuilderParams");
        this.translatorModuleBuilderParams = translatorModuleBuilderParams;
    }

    @Provides
    @Singleton
    public final EnvironmentHelper environmentHelper() {
        return this.translatorModuleBuilderParams.getEnvironmentHelper();
    }

    @Provides
    @Singleton
    /* renamed from: translatorModuleBuilderParams, reason: from getter */
    public final TranslatorModuleBuilderParams getTranslatorModuleBuilderParams() {
        return this.translatorModuleBuilderParams;
    }
}
