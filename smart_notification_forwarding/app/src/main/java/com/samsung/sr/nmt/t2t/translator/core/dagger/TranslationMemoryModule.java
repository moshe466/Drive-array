package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.CustomTranslationMemory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.TranslationMemory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.TranslationMemoryUnit;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationMemoryModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TranslationMemoryModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "provideCustomTranslationMemory", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/CustomTranslationMemory;", "customTranslationMemoryLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;", "provideTranslationMemory", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/TranslationMemory;", "translationMemoryLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class TranslationMemoryModule {
    @Provides
    @Singleton
    public final TranslationMemory provideTranslationMemory(TranslationMemoryLoader translationMemoryLoader) {
        Intrinsics.checkNotNullParameter(translationMemoryLoader, "translationMemoryLoader");
        return new TranslationMemory(translationMemoryLoader, new TranslationMemoryUnit());
    }

    @Provides
    @Singleton
    public final CustomTranslationMemory provideCustomTranslationMemory(CustomTranslationMemoryLoader customTranslationMemoryLoader) {
        Intrinsics.checkNotNullParameter(customTranslationMemoryLoader, "customTranslationMemoryLoader");
        return new CustomTranslationMemory(customTranslationMemoryLoader);
    }
}
