package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.AlphabetsResourceLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.LanguageIdsResourceLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.RawResourceLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.SubwordsResourceLoader;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileLoaderModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/FileLoaderModule;", JsonProperty.USE_DEFAULT_NAME, "fileLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;)V", "rawResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/RawResourceLoader;", "alphabetsResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/AlphabetsResourceLoader;", "languageIdsResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/LanguageIdsResourceLoader;", "subwordsResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SubwordsResourceLoader;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class FileLoaderModule {
    private final FileLoader fileLoader;
    private final RawResourceLoader rawResourceLoader;

    public FileLoaderModule(FileLoader fileLoader) {
        Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
        this.fileLoader = fileLoader;
        this.rawResourceLoader = new RawResourceLoader(fileLoader);
    }

    @Provides
    @Singleton
    /* renamed from: fileLoader, reason: from getter */
    public final FileLoader getFileLoader() {
        return this.fileLoader;
    }

    @Provides
    @Singleton
    public final AlphabetsResourceLoader alphabetsResourceLoader() {
        return new AlphabetsResourceLoader(this.rawResourceLoader);
    }

    @Provides
    @Singleton
    public final LanguageIdsResourceLoader languageIdsResourceLoader() {
        return new LanguageIdsResourceLoader(this.rawResourceLoader);
    }

    @Provides
    @Singleton
    public final SubwordsResourceLoader subwordsResourceLoader() {
        return new SubwordsResourceLoader(this.rawResourceLoader);
    }
}
