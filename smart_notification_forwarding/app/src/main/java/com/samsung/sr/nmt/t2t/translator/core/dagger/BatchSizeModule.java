package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;

/* compiled from: BatchSizeModule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0007J\b\u0010\u0007\u001a\u00020\u0003H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/BatchSizeModule;", JsonProperty.USE_DEFAULT_NAME, "characterBatchSize", JsonProperty.USE_DEFAULT_NAME, "tokenBatchSize", "(II)V", "provideCharacterBatchSize", "provideTokenBatchSize", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class BatchSizeModule {
    private final int characterBatchSize;
    private final int tokenBatchSize;

    public BatchSizeModule(int i, int i2) {
        this.characterBatchSize = i;
        this.tokenBatchSize = i2;
    }

    @Provides
    @Singleton
    @Named("tokenBatchSize")
    /* renamed from: provideTokenBatchSize, reason: from getter */
    public final int getTokenBatchSize() {
        return this.tokenBatchSize;
    }

    @Provides
    @Singleton
    @Named("characterBatchSize")
    /* renamed from: provideCharacterBatchSize, reason: from getter */
    public final int getCharacterBatchSize() {
        return this.characterBatchSize;
    }
}
