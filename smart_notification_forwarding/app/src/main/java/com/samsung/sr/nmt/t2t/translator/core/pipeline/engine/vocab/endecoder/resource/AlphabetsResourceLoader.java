package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalLanguagePackAssetLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AlphabetsResourceLoader.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\f\u0010\f\u001a\u00020\u0003*\u00020\u0002H\u0002¨\u0006\u000e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/AlphabetsResourceLoader;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceLoaderDecorator;", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "rawResourceLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/ResourceLoader;)V", "load", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", "targetLanguage", ExternalLanguagePackAssetLoader.PATH_QUERY, "toAlphabet", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AlphabetsResourceLoader extends ResourceLoaderDecorator<String, Character> {
    private static final String ESCAPE_CHARS = "\\_u;0123456789";

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AlphabetsResourceLoader(ResourceLoader<String> rawResourceLoader) {
        super(rawResourceLoader);
        Intrinsics.checkNotNullParameter(rawResourceLoader, "rawResourceLoader");
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource.ResourceLoader
    public Set<Character> load(String sourceLanguage, String targetLanguage, String path) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(path, "path");
        Collection<String> loadRawResource = loadRawResource(sourceLanguage, targetLanguage, path);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(loadRawResource, 10));
        Iterator<T> it = loadRawResource.iterator();
        while (it.hasNext()) {
            arrayList.add(Character.valueOf(toAlphabet((String) it.next())));
        }
        HashSet hashSet = CollectionsKt.toHashSet(arrayList);
        if (!hashSet.isEmpty()) {
            for (int i = 0; i < r3.length(); i++) {
                hashSet.add(Character.valueOf(r3.charAt(i)));
            }
        }
        return hashSet;
    }

    private final char toAlphabet(String str) {
        return str.charAt(1);
    }
}
