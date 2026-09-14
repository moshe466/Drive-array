package com.samsung.sr.nmt.t2t.translator.core.dagger;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.ActiveLanguageCodeChecker;
import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import dagger.Module;
import dagger.Provides;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* compiled from: ActiveLanguageCodeCheckerModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dagger/ActiveLanguageCodeCheckerModule;", JsonProperty.USE_DEFAULT_NAME, "()V", "provideLanguageCodeChecker", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/ActiveLanguageCodeChecker;", "assetLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@Module
/* loaded from: classes.dex */
public final class ActiveLanguageCodeCheckerModule {
    public static final String SOURCE_PATH = "active-language-code.txt";

    @Provides
    @Singleton
    public final ActiveLanguageCodeChecker provideLanguageCodeChecker(AssetLoader assetLoader) {
        Intrinsics.checkNotNullParameter(assetLoader, "assetLoader");
        Reader inputStreamReader = new InputStreamReader(assetLoader.open(SOURCE_PATH), Charsets.UTF_8);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        BufferedReader bufferedReader2 = bufferedReader instanceof BufferedReader ? bufferedReader : new BufferedReader(bufferedReader, 8192);
        try {
            List list = SequencesKt.toList(TextStreamsKt.lineSequence(bufferedReader2));
            CloseableKt.closeFinally(bufferedReader2, null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
            return new ActiveLanguageCodeChecker(CollectionsKt.toSet(arrayList));
        } finally {
        }
    }
}
