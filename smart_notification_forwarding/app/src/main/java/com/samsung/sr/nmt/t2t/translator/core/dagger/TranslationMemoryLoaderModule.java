package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationMemoryLoaderModule.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\b\u0010\b\u001a\u00020\u0003H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/TranslationMemoryLoaderModule;", JsonProperty.USE_DEFAULT_NAME, "translationMemoryLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;", "customTranslationMemoryLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;)V", "provideCustomTranslationMemoryLoader", "provideTranslationMemory", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class TranslationMemoryLoaderModule {
    private final CustomTranslationMemoryLoader customTranslationMemoryLoader;
    private final TranslationMemoryLoader translationMemoryLoader;

    public TranslationMemoryLoaderModule(TranslationMemoryLoader translationMemoryLoader, CustomTranslationMemoryLoader customTranslationMemoryLoader) {
        Intrinsics.checkNotNullParameter(translationMemoryLoader, "translationMemoryLoader");
        Intrinsics.checkNotNullParameter(customTranslationMemoryLoader, "customTranslationMemoryLoader");
        this.translationMemoryLoader = translationMemoryLoader;
        this.customTranslationMemoryLoader = customTranslationMemoryLoader;
    }

    @Provides
    @Singleton
    /* renamed from: provideTranslationMemory, reason: from getter */
    public final TranslationMemoryLoader getTranslationMemoryLoader() {
        return this.translationMemoryLoader;
    }

    @Provides
    @Singleton
    /* renamed from: provideCustomTranslationMemoryLoader, reason: from getter */
    public final CustomTranslationMemoryLoader getCustomTranslationMemoryLoader() {
        return this.customTranslationMemoryLoader;
    }
}
