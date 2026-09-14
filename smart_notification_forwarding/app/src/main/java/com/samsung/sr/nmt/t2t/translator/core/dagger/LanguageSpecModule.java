package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.EnSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.LanguageSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.StreamEnSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.TaggedEnSpec;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.inject.Singleton;
import kotlin.Metadata;

/* compiled from: LanguageSpecModule.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b!\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH'J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH'¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/LanguageSpecModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "provideEnglishSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/LanguageSpec;", "enSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/EnSpec;", "provideStreamEnglishSpec", "streamEnSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/StreamEnSpec;", "provideTaggedSpec", "taggedEnSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/TaggedEnSpec;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public abstract class LanguageSpecModule {
    @Binds
    @StringKey("en-plain")
    @Singleton
    @IntoMap
    public abstract LanguageSpec provideEnglishSpec(EnSpec enSpec);

    @Binds
    @StringKey("en-stream")
    @Singleton
    @IntoMap
    public abstract LanguageSpec provideStreamEnglishSpec(StreamEnSpec streamEnSpec);

    @Binds
    @StringKey("en-tagged")
    @Singleton
    @IntoMap
    public abstract LanguageSpec provideTaggedSpec(TaggedEnSpec taggedEnSpec);
}
