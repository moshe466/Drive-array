package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalLanguagePackAssetLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.IllegalResourceException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: SubwordsResourceLoader.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016J\f\u0010\u000b\u001a\u00020\u0002*\u00020\u0002H\u0002¨\u0006\f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/SubwordsResourceLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceLoaderDecorator;", JsonProperty.USE_DEFAULT_NAME, "rawResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceLoader;)V", "load", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", "targetLanguage", ExternalLanguagePackAssetLoader.PATH_QUERY, "toSubWord", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SubwordsResourceLoader extends ResourceLoaderDecorator<String, String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubwordsResourceLoader(ResourceLoader<String> rawResourceLoader) {
        super(rawResourceLoader);
        Intrinsics.checkNotNullParameter(rawResourceLoader, "rawResourceLoader");
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.ResourceLoader
    public List<String> load(String sourceLanguage, String targetLanguage, String path) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        Collection<String> loadRawResource = loadRawResource(sourceLanguage, targetLanguage, path);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(loadRawResource, 10));
        for (String str : loadRawResource) {
            if (str.length() <= 1) {
                throw new IllegalResourceException("Vocab token format is wrong | " + str + " | " + path);
            }
            arrayList.add(toSubWord(str));
        }
        return arrayList;
    }

    private final String toSubWord(String str) {
        String substring = str.substring(1, StringsKt.last(str) == '\n' ? str.length() - 2 : str.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
