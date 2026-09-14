package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;

/* compiled from: UnknownTokenRatioThresholdModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/UnknownTokenRatioThresholdModule;", JsonProperty.USE_DEFAULT_NAME, "threshold", JsonProperty.USE_DEFAULT_NAME, "(F)V", "provideUnknownThreshold", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class UnknownTokenRatioThresholdModule {
    private final float threshold;

    public UnknownTokenRatioThresholdModule(float f) {
        this.threshold = f;
    }

    @Provides
    @Singleton
    @Named("unknownTokenRatioThreshold")
    /* renamed from: provideUnknownThreshold, reason: from getter */
    public final float getThreshold() {
        return this.threshold;
    }
}
