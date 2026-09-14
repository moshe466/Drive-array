package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalLanguagePackAssetLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageIdsResourceLoader.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/LanguageIdsResourceLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceLoaderDecorator;", JsonProperty.USE_DEFAULT_NAME, "rawResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceLoader;)V", "load", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", "targetLanguage", ExternalLanguagePackAssetLoader.PATH_QUERY, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class LanguageIdsResourceLoader extends ResourceLoaderDecorator<String, String> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LanguageIdsResourceLoader(ResourceLoader<String> rawResourceLoader) {
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
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String lowerCase = str.toLowerCase(US);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            arrayList.add(lowerCase);
        }
        return arrayList;
    }
}
