package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.LoggerFactory;
import com.samsung.sr.nmt.t2t.translator.core.utils.SimpleLogger;
import dagger.Module;
import dagger.Provides;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: AssetsModule.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/AssetsModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "logger", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/SimpleLogger;", "provideAbbreviations", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "assetLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;", "provideChineseThreshold", JsonProperty.USE_DEFAULT_NAME, "provideEnglishDictionary", "provideLanguageDetectorDictionary", JsonProperty.USE_DEFAULT_NAME, "provideNoCaseDistinctLanguages", "provideTraditionalChineseCharacters", "readDictionaryFromAssetLoader", "readFromAssetLoader", "sourcePath", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class AssetsModule {
    public static final String ENGLISH_DICTIONARY_PATH = "srlid_dict_en.txt";
    public static final String LANGUAGE_DETECTOR_DICTIONARY_PATH = "srlid_dict-v7.tsv";
    public static final String NO_CASE_DISTINCT_LANGUAGE = "no-case-distinct-languages.txt";
    public static final String SOURCE_PATH = "abbreviations.txt";
    public static final String TRADITIONAL_CHINESE_CHARACTER_PATH = "traditional-chinese-characters.txt";
    private final SimpleLogger logger = LoggerFactory.INSTANCE.getLogger(getClass());

    @Provides
    @Named("traditional-chinese-threshold")
    public final int provideChineseThreshold() {
        return 3;
    }

    @Provides
    @Named("abbreviations")
    public final Set<String> provideAbbreviations(AssetLoader assetLoader) {
        Intrinsics.checkNotNullParameter(assetLoader, "assetLoader");
        return readFromAssetLoader(assetLoader, SOURCE_PATH);
    }

    @Provides
    @Named("traditional-chinese-characters")
    public final Set<String> provideTraditionalChineseCharacters(AssetLoader assetLoader) {
        Intrinsics.checkNotNullParameter(assetLoader, "assetLoader");
        return readFromAssetLoader(assetLoader, TRADITIONAL_CHINESE_CHARACTER_PATH);
    }

    @Provides
    @Named("english-dictionary")
    public final Set<String> provideEnglishDictionary(AssetLoader assetLoader) {
        Intrinsics.checkNotNullParameter(assetLoader, "assetLoader");
        return readFromAssetLoader(assetLoader, ENGLISH_DICTIONARY_PATH);
    }

    @Provides
    @Named("language-detector-dictionary")
    public final Map<String, String> provideLanguageDetectorDictionary(AssetLoader assetLoader) {
        Intrinsics.checkNotNullParameter(assetLoader, "assetLoader");
        return readDictionaryFromAssetLoader(assetLoader);
    }

    @Provides
    @Named("no-case-distinct-languages")
    public final Set<String> provideNoCaseDistinctLanguages(AssetLoader assetLoader) {
        Intrinsics.checkNotNullParameter(assetLoader, "assetLoader");
        return readFromAssetLoader(assetLoader, NO_CASE_DISTINCT_LANGUAGE);
    }

    private final Set<String> readFromAssetLoader(AssetLoader assetLoader, String sourcePath) {
        Object m107constructorimpl;
        BufferedReader open;
        try {
            Result.Companion companion = Result.INSTANCE;
            AssetsModule assetsModule = this;
            open = assetLoader.open(sourcePath);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
        }
        try {
            Reader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            open = bufferedReader instanceof BufferedReader ? bufferedReader : new BufferedReader(bufferedReader, 8192);
            try {
                List list = SequencesKt.toList(TextStreamsKt.lineSequence(open));
                CloseableKt.closeFinally(open, null);
                CloseableKt.closeFinally(open, null);
                m107constructorimpl = Result.m107constructorimpl(CollectionsKt.toSet(list));
                Throwable m110exceptionOrNullimpl = Result.m110exceptionOrNullimpl(m107constructorimpl);
                if (m110exceptionOrNullimpl != null) {
                    this.logger.error("Failed to load files " + m110exceptionOrNullimpl.getMessage(), m110exceptionOrNullimpl);
                    m107constructorimpl = SetsKt.emptySet();
                }
                return (Set) m107constructorimpl;
            } finally {
            }
        } finally {
        }
    }

    private final Map<String, String> readDictionaryFromAssetLoader(AssetLoader assetLoader) {
        Object m107constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            AssetsModule assetsModule = this;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            InputStream open = assetLoader.open(LANGUAGE_DETECTOR_DICTIONARY_PATH);
            try {
                Reader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
                List<String> readLines = TextStreamsKt.readLines(inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192));
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(readLines, 10));
                Iterator<T> it = readLines.iterator();
                while (it.hasNext()) {
                    List split$default = StringsKt.split$default((CharSequence) it.next(), new String[]{"\t"}, false, 0, 6, (Object) null);
                    linkedHashMap.put(split$default.get(0), split$default.get(1));
                    arrayList.add(Unit.INSTANCE);
                }
                ArrayList arrayList2 = arrayList;
                CloseableKt.closeFinally(open, null);
                m107constructorimpl = Result.m107constructorimpl(linkedHashMap);
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m110exceptionOrNullimpl = Result.m110exceptionOrNullimpl(m107constructorimpl);
        if (m110exceptionOrNullimpl != null) {
            this.logger.error("Failed to load files " + m110exceptionOrNullimpl.getMessage(), m110exceptionOrNullimpl);
            m107constructorimpl = MapsKt.emptyMap();
        }
        return (Map) m107constructorimpl;
    }
}
