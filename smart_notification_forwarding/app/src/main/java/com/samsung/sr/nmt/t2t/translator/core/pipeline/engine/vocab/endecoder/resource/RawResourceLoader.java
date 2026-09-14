package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalLanguagePackAssetLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.IllegalResourceException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.ResourceAccessException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RawResourceLoader.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/RawResourceLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceLoader;", JsonProperty.USE_DEFAULT_NAME, "fileLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;)V", "load", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", "targetLanguage", ExternalLanguagePackAssetLoader.PATH_QUERY, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RawResourceLoader implements ResourceLoader<String> {
    private final FileLoader fileLoader;

    public RawResourceLoader(FileLoader fileLoader) {
        Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
        this.fileLoader = fileLoader;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.ResourceLoader
    public Collection<String> load(String sourceLanguage, String targetLanguage, String path) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        if (path.length() > 0) {
            List<String> authorizedStringLines = this.fileLoader.getAuthorizedStringLines(sourceLanguage, targetLanguage, path);
            if (authorizedStringLines == null) {
                throw new ResourceAccessException("Failed to access resource | " + path);
            }
            if (authorizedStringLines.isEmpty()) {
                throw new IllegalResourceException("Vocab resource file is empty | " + path);
            }
            return authorizedStringLines;
        }
        return CollectionsKt.emptyList();
    }
}
