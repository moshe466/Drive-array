package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WordPieceResourceReader.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResourceReader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceReader;", "languageIdsResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/LanguageIdsResourceLoader;", "alphabetsResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/AlphabetsResourceLoader;", "subwordsResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SubwordsResourceLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/LanguageIdsResourceLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/AlphabetsResourceLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SubwordsResourceLoader;)V", "getResource", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/WordPieceResource;", "spec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class WordPieceResourceReader extends ResourceReader {
    private final SubwordsResourceLoader subwordsResourceLoader;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public WordPieceResourceReader(LanguageIdsResourceLoader languageIdsResourceLoader, AlphabetsResourceLoader alphabetsResourceLoader, SubwordsResourceLoader subwordsResourceLoader) {
        super(languageIdsResourceLoader, alphabetsResourceLoader);
        Intrinsics.checkNotNullParameter(languageIdsResourceLoader, "languageIdsResourceLoader");
        Intrinsics.checkNotNullParameter(alphabetsResourceLoader, "alphabetsResourceLoader");
        Intrinsics.checkNotNullParameter(subwordsResourceLoader, "subwordsResourceLoader");
        this.subwordsResourceLoader = subwordsResourceLoader;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.ResourceReader
    public WordPieceResource getResource(VocabSpec spec) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        List<String> load = this.subwordsResourceLoader.load(spec.getSourceLanguage(), spec.getTargetLanguage(), spec.getVocabPath());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (Object obj : load) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            linkedHashMap.put((String) obj, Integer.valueOf(i));
            i = i2;
        }
        List<String> load2 = getLanguageIdsResourceLoader().load(spec.getSourceLanguage(), spec.getTargetLanguage(), spec.getVocabLangIdPath());
        if (!(load2.isEmpty() || load2.size() == load.size())) {
            throw new IllegalStateException("Language ids should be same length with subword vocab".toString());
        }
        return new WordPieceResource(load, getAlphabetsResourceLoader().load(spec.getSourceLanguage(), spec.getTargetLanguage(), spec.getAlphabetPath()), load2, linkedHashMap);
    }
}
