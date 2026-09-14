package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.LanguageDetectionService;
import com.samsung.sr.nmt.t2t.translator.core.LanguageDetectionServiceImpl;
import com.samsung.sr.nmt.t2t.translator.core.SegmentationService;
import com.samsung.sr.nmt.t2t.translator.core.SegmentationServiceImpl;
import com.samsung.sr.nmt.t2t.translator.core.TranslationService;
import com.samsung.sr.nmt.t2t.translator.core.TranslationServiceImpl;
import dagger.Binds;
import dagger.Module;
import javax.inject.Singleton;
import kotlin.Metadata;

/* compiled from: ServiceModule.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH'¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/ServiceModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "provideLanguageDetectionService", "Lcom/samsung/sr/nmt/t2t/translator/core/LanguageDetectionService;", "languageDetectionServiceImpl", "Lcom/samsung/sr/nmt/t2t/translator/core/LanguageDetectionServiceImpl;", "provideSegmentationService", "Lcom/samsung/sr/nmt/t2t/translator/core/SegmentationService;", "segmentationServiceImpl", "Lcom/samsung/sr/nmt/t2t/translator/core/SegmentationServiceImpl;", "provideTranslationService", "Lcom/samsung/sr/nmt/t2t/translator/core/TranslationService;", "translationServiceImpl", "Lcom/samsung/sr/nmt/t2t/translator/core/TranslationServiceImpl;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public abstract class ServiceModule {
    @Singleton
    @Binds
    public abstract LanguageDetectionService provideLanguageDetectionService(LanguageDetectionServiceImpl languageDetectionServiceImpl);

    @Singleton
    @Binds
    public abstract SegmentationService provideSegmentationService(SegmentationServiceImpl segmentationServiceImpl);

    @Singleton
    @Binds
    public abstract TranslationService provideTranslationService(TranslationServiceImpl translationServiceImpl);
}
