package com.samsung.sr.nmt.core.t2t.translator;

import android.content.Context;
import android.os.Build;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.CustomReplacePairLoaderImpl;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.CustomTranslationMemoryLoaderImpl;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.DBSwearWordRuleLoader;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.DBTranslationMemoryLoader;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.ReplacePairLoaderImpl;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.ReplacePairCursorParser;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.SwearWordRuleCursorParser;
import com.samsung.sr.nmt.core.t2t.translator.helpers.db.cursor.TranslationMemoryCursorParser;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ContextExtension;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalFileLoader;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalLanguagePackAssetLoader;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalLanguagePackCursorHelper;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalLanguagePackReplacePairLoader;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalLanguagePackTranslationMemoryLoader;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ExternalSwearWordRuleLoader;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.HashCalculator;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.LanguagePackManager;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.ParcelFileDescriptorFactory;
import com.samsung.sr.nmt.core.t2t.translator.helpers.external.UriFactory;
import com.samsung.sr.nmt.core.t2t.translator.helpers.internal.InternalAssetLoader;
import com.samsung.sr.nmt.t2t.translator.core.TranslatorModule;
import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorModuleBuilderParams;
import com.samsung.sr.nmt.t2t.translator.core.languagedetector.LanguageDetectorParams;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomReplacePairLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.ReplacePairLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.SwearWordRuleLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.Logger;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: TranslatorBuilder.kt */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\r\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J,\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0004H\u0007J8\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0004H\u0007J$\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0019\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000e¨\u0006 "}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorBuilder;", JsonProperty.USE_DEFAULT_NAME, "()V", "LANG_DETECT_CHINESE_RULE_APPLICABLE_LENGTH", JsonProperty.USE_DEFAULT_NAME, "LANG_DETECT_CHINESE_RULE_VALID_LENGTH", JsonProperty.USE_DEFAULT_NAME, "LANG_DETECT_MODEL_CONFIDENCE_THRESHOLD", "LANG_DETECT_RULE_CONFIDENCE_THRESHOLD", "MAX_BATCH_SIZE", "MIN_BATCH_SIZE", "UNKNOWN_TOKEN_RATIO_THRESHOLD", "logger", "com/samsung/sr/nmt/core/t2t/translator/TranslatorBuilder$logger$1", "Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorBuilder$logger$1;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/samsung/sr/nmt/core/t2t/translator/Translator;", "params", "Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorBuilder$TranslatorBuilderParams;", "buildWithExternalFile", "context", "Landroid/content/Context;", "resourceDirectory", "Ljava/io/File;", "characterBatchSize", "tokenBatchSize", "buildWithExternalLanguagePack", "androidLanguagePackOnly", JsonProperty.USE_DEFAULT_NAME, "srLanguagePackOnly", "buildWithInternalAsset", "TranslatorBuilderParams", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TranslatorBuilder {
    private static final int LANG_DETECT_CHINESE_RULE_APPLICABLE_LENGTH = 1;
    private static final float LANG_DETECT_CHINESE_RULE_VALID_LENGTH = 0.3f;
    private static final float LANG_DETECT_MODEL_CONFIDENCE_THRESHOLD = -1.0f;
    private static final float LANG_DETECT_RULE_CONFIDENCE_THRESHOLD = 0.2f;
    private static final int MAX_BATCH_SIZE = 256;
    private static final int MIN_BATCH_SIZE = 32;
    private static final float UNKNOWN_TOKEN_RATIO_THRESHOLD = 0.4f;
    public static final TranslatorBuilder INSTANCE = new TranslatorBuilder();
    private static final TranslatorBuilder$logger$1 logger = new Logger() { // from class: com.samsung.sr.nmt.core.t2t.translator.TranslatorBuilder$logger$1
        @Override // com.samsung.sr.nmt.t2t.translator.core.utils.Logger
        public void debug(String tag, String message) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            Timber.tag(tag).d(message, new Object[0]);
        }

        @Override // com.samsung.sr.nmt.t2t.translator.core.utils.Logger
        public void info(String tag, String message) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            Timber.tag(tag).i(message, new Object[0]);
        }

        @Override // com.samsung.sr.nmt.t2t.translator.core.utils.Logger
        public void error(String tag, String message, Throwable throwable) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            Timber.tag(tag).e(throwable, message, new Object[0]);
        }
    };

    @JvmStatic
    public static final Translator buildWithExternalFile(Context context, File resourceDirectory) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resourceDirectory, "resourceDirectory");
        return buildWithExternalFile$default(context, resourceDirectory, 0, 0, 12, null);
    }

    @JvmStatic
    public static final Translator buildWithExternalFile(Context context, File resourceDirectory, int characterBatchSize) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resourceDirectory, "resourceDirectory");
        return buildWithExternalFile$default(context, resourceDirectory, characterBatchSize, 0, 8, null);
    }

    @JvmStatic
    public static final Translator buildWithExternalLanguagePack(Context context) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(context, "context");
        return buildWithExternalLanguagePack$default(context, false, false, 0, 0, 30, null);
    }

    @JvmStatic
    public static final Translator buildWithExternalLanguagePack(Context context, boolean androidLanguagePackOnly) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(context, "context");
        return buildWithExternalLanguagePack$default(context, androidLanguagePackOnly, false, 0, 0, 28, null);
    }

    @JvmStatic
    public static final Translator buildWithExternalLanguagePack(Context context, boolean androidLanguagePackOnly, boolean srLanguagePackOnly) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(context, "context");
        return buildWithExternalLanguagePack$default(context, androidLanguagePackOnly, srLanguagePackOnly, 0, 0, 24, null);
    }

    @JvmStatic
    public static final Translator buildWithExternalLanguagePack(Context context, boolean androidLanguagePackOnly, boolean srLanguagePackOnly, int characterBatchSize) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(context, "context");
        return buildWithExternalLanguagePack$default(context, androidLanguagePackOnly, srLanguagePackOnly, characterBatchSize, 0, 16, null);
    }

    @JvmStatic
    public static final Translator buildWithInternalAsset(Context context) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(context, "context");
        return buildWithInternalAsset$default(context, 0, 0, 6, null);
    }

    @JvmStatic
    public static final Translator buildWithInternalAsset(Context context, int characterBatchSize) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(context, "context");
        return buildWithInternalAsset$default(context, characterBatchSize, 0, 4, null);
    }

    private TranslatorBuilder() {
    }

    private final synchronized Translator build(TranslatorBuilderParams params) {
        TranslatorModule build;
        int tokenBatchSize = params.getTokenBatchSize();
        if (!(32 <= tokenBatchSize && tokenBatchSize < 257)) {
            throw new IllegalArgumentException(("Batch size (" + params + ".tokenBatchSize) should be in the range [32, 256]").toString());
        }
        if (!(params.getCharacterBatchSize() > 0)) {
            throw new IllegalArgumentException("Character batch size should be positive".toString());
        }
        AndroidEnvironmentHelper androidEnvironmentHelper = new AndroidEnvironmentHelper(Build.MODEL, false);
        TranslatorModuleBuilderParams translatorModuleBuilderParams = new TranslatorModuleBuilderParams(new AndroidAssetLoader(params.getContext()), androidEnvironmentHelper, params.getFileLoader(), params.getTranslationMemoryLoader(), params.getCustomTranslationMemoryLoader(), params.getSwearWordRuleLoader(), params.getReplacePairLoader(), params.getCustomReplacePairLoader(), params.getCharacterBatchSize(), params.getTokenBatchSize(), UNKNOWN_TOKEN_RATIO_THRESHOLD);
        LanguageDetectorParams languageDetectorParams = new LanguageDetectorParams(LANG_DETECT_MODEL_CONFIDENCE_THRESHOLD, LANG_DETECT_RULE_CONFIDENCE_THRESHOLD, 1, LANG_DETECT_CHINESE_RULE_VALID_LENGTH);
        TranslatorModule.INSTANCE.setLogger(logger);
        build = TranslatorModule.INSTANCE.build(translatorModuleBuilderParams, languageDetectorParams);
        return new TranslatorImpl(build.getTranslationService(), build.getLanguageDetectionService(), build.getSegmentationService());
    }

    public static /* synthetic */ Translator buildWithExternalLanguagePack$default(Context context, boolean z, boolean z2, int i, int i2, int i3, Object obj) throws IllegalArgumentException {
        if ((i3 & 2) != 0) {
            z = false;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        if ((i3 & 8) != 0) {
            i = 500;
        }
        if ((i3 & 16) != 0) {
            i2 = 256;
        }
        return buildWithExternalLanguagePack(context, z, z2, i, i2);
    }

    @JvmStatic
    public static final synchronized Translator buildWithExternalLanguagePack(Context context, boolean androidLanguagePackOnly, boolean srLanguagePackOnly, int characterBatchSize, int tokenBatchSize) throws IllegalArgumentException {
        Translator build;
        synchronized (TranslatorBuilder.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            ContextExtension contextExtension = new ContextExtension(context);
            LanguagePackManager languagePackManager = new LanguagePackManager(contextExtension, androidLanguagePackOnly, srLanguagePackOnly);
            UriFactory uriFactory = new UriFactory();
            String string = context.getString(R.string.translationMemoryTable);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExternalLanguagePackTranslationMemoryLoader externalLanguagePackTranslationMemoryLoader = new ExternalLanguagePackTranslationMemoryLoader(new ExternalLanguagePackCursorHelper(languagePackManager, string, contextExtension, uriFactory), new TranslationMemoryCursorParser());
            String string2 = context.getString(R.string.replacePairTable);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ExternalLanguagePackReplacePairLoader externalLanguagePackReplacePairLoader = new ExternalLanguagePackReplacePairLoader(new ExternalLanguagePackCursorHelper(languagePackManager, string2, contextExtension, uriFactory), new ReplacePairCursorParser());
            TranslatorBuilder translatorBuilder = INSTANCE;
            String string3 = context.getString(R.string.languagePackHash);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            String string4 = context.getString(R.string.swearWordRuleTable);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            build = translatorBuilder.build(new TranslatorBuilderParams(context, new ExternalLanguagePackAssetLoader(languagePackManager, string3, contextExtension, new HashCalculator(), uriFactory), externalLanguagePackTranslationMemoryLoader, externalLanguagePackTranslationMemoryLoader, new ExternalSwearWordRuleLoader(new ExternalLanguagePackCursorHelper(languagePackManager, string4, contextExtension, uriFactory), new SwearWordRuleCursorParser()), externalLanguagePackReplacePairLoader, externalLanguagePackReplacePairLoader, characterBatchSize, tokenBatchSize));
        }
        return build;
    }

    public static /* synthetic */ Translator buildWithInternalAsset$default(Context context, int i, int i2, int i3, Object obj) throws IllegalArgumentException {
        if ((i3 & 2) != 0) {
            i = 500;
        }
        if ((i3 & 4) != 0) {
            i2 = 256;
        }
        return buildWithInternalAsset(context, i, i2);
    }

    @JvmStatic
    public static final synchronized Translator buildWithInternalAsset(Context context, int characterBatchSize, int tokenBatchSize) throws IllegalArgumentException {
        Translator build;
        synchronized (TranslatorBuilder.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            TranslatorBuilder translatorBuilder = INSTANCE;
            InternalAssetLoader internalAssetLoader = new InternalAssetLoader(context);
            DBTranslationMemoryLoader dBTranslationMemoryLoader = new DBTranslationMemoryLoader(context, null, new TranslationMemoryCursorParser(), 2, null);
            DBSwearWordRuleLoader dBSwearWordRuleLoader = new DBSwearWordRuleLoader(context, null, new SwearWordRuleCursorParser(), 2, null);
            build = translatorBuilder.build(new TranslatorBuilderParams(context, internalAssetLoader, dBTranslationMemoryLoader, new CustomTranslationMemoryLoaderImpl(context, null, new TranslationMemoryCursorParser(), 2, null), dBSwearWordRuleLoader, new ReplacePairLoaderImpl(context, new ReplacePairCursorParser()), new CustomReplacePairLoaderImpl(context, new ReplacePairCursorParser()), characterBatchSize, tokenBatchSize));
        }
        return build;
    }

    public static /* synthetic */ Translator buildWithExternalFile$default(Context context, File file, int i, int i2, int i3, Object obj) throws IllegalArgumentException {
        if ((i3 & 4) != 0) {
            i = 500;
        }
        if ((i3 & 8) != 0) {
            i2 = 256;
        }
        return buildWithExternalFile(context, file, i, i2);
    }

    @JvmStatic
    public static final synchronized Translator buildWithExternalFile(Context context, File resourceDirectory, int characterBatchSize, int tokenBatchSize) throws IllegalArgumentException {
        Translator build;
        synchronized (TranslatorBuilder.class) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(resourceDirectory, "resourceDirectory");
            build = INSTANCE.build(new TranslatorBuilderParams(context, new ExternalFileLoader(resourceDirectory, new ParcelFileDescriptorFactory()), new DBTranslationMemoryLoader(context, resourceDirectory, new TranslationMemoryCursorParser()), new CustomTranslationMemoryLoaderImpl(context, null, new TranslationMemoryCursorParser(), 2, null), new DBSwearWordRuleLoader(context, resourceDirectory, new SwearWordRuleCursorParser()), new ReplacePairLoaderImpl(context, new ReplacePairCursorParser()), new CustomReplacePairLoaderImpl(context, new ReplacePairCursorParser()), characterBatchSize, tokenBatchSize));
        }
        return build;
    }

    /* compiled from: TranslatorBuilder.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\t\u0010+\u001a\u00020\u000fHÆ\u0003J\t\u0010,\u001a\u00020\u0011HÆ\u0003J\t\u0010-\u001a\u00020\u0011HÆ\u0003Jc\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\u0011HÖ\u0001J\t\u00103\u001a\u000204HÖ\u0001R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u00065"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorBuilder$TranslatorBuilderParams;", JsonProperty.USE_DEFAULT_NAME, "context", "Landroid/content/Context;", "fileLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "translationMemoryLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;", "customTranslationMemoryLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;", "swearWordRuleLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;", "replacePairLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/ReplacePairLoader;", "customReplacePairLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomReplacePairLoader;", "characterBatchSize", JsonProperty.USE_DEFAULT_NAME, "tokenBatchSize", "(Landroid/content/Context;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/ReplacePairLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomReplacePairLoader;II)V", "getCharacterBatchSize", "()I", "getContext", "()Landroid/content/Context;", "getCustomReplacePairLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomReplacePairLoader;", "getCustomTranslationMemoryLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;", "getFileLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "getReplacePairLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/ReplacePairLoader;", "getSwearWordRuleLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;", "getTokenBatchSize", "getTranslationMemoryLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", "toString", JsonProperty.USE_DEFAULT_NAME, "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final /* data */ class TranslatorBuilderParams {
        private final int characterBatchSize;
        private final Context context;
        private final CustomReplacePairLoader customReplacePairLoader;
        private final CustomTranslationMemoryLoader customTranslationMemoryLoader;
        private final FileLoader fileLoader;
        private final ReplacePairLoader replacePairLoader;
        private final SwearWordRuleLoader swearWordRuleLoader;
        private final int tokenBatchSize;
        private final TranslationMemoryLoader translationMemoryLoader;

        /* renamed from: component1, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        /* renamed from: component2, reason: from getter */
        public final FileLoader getFileLoader() {
            return this.fileLoader;
        }

        /* renamed from: component3, reason: from getter */
        public final TranslationMemoryLoader getTranslationMemoryLoader() {
            return this.translationMemoryLoader;
        }

        /* renamed from: component4, reason: from getter */
        public final CustomTranslationMemoryLoader getCustomTranslationMemoryLoader() {
            return this.customTranslationMemoryLoader;
        }

        /* renamed from: component5, reason: from getter */
        public final SwearWordRuleLoader getSwearWordRuleLoader() {
            return this.swearWordRuleLoader;
        }

        /* renamed from: component6, reason: from getter */
        public final ReplacePairLoader getReplacePairLoader() {
            return this.replacePairLoader;
        }

        /* renamed from: component7, reason: from getter */
        public final CustomReplacePairLoader getCustomReplacePairLoader() {
            return this.customReplacePairLoader;
        }

        /* renamed from: component8, reason: from getter */
        public final int getCharacterBatchSize() {
            return this.characterBatchSize;
        }

        /* renamed from: component9, reason: from getter */
        public final int getTokenBatchSize() {
            return this.tokenBatchSize;
        }

        public final TranslatorBuilderParams copy(Context context, FileLoader fileLoader, TranslationMemoryLoader translationMemoryLoader, CustomTranslationMemoryLoader customTranslationMemoryLoader, SwearWordRuleLoader swearWordRuleLoader, ReplacePairLoader replacePairLoader, CustomReplacePairLoader customReplacePairLoader, int characterBatchSize, int tokenBatchSize) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
            Intrinsics.checkNotNullParameter(translationMemoryLoader, "translationMemoryLoader");
            Intrinsics.checkNotNullParameter(customTranslationMemoryLoader, "customTranslationMemoryLoader");
            Intrinsics.checkNotNullParameter(swearWordRuleLoader, "swearWordRuleLoader");
            Intrinsics.checkNotNullParameter(replacePairLoader, "replacePairLoader");
            Intrinsics.checkNotNullParameter(customReplacePairLoader, "customReplacePairLoader");
            return new TranslatorBuilderParams(context, fileLoader, translationMemoryLoader, customTranslationMemoryLoader, swearWordRuleLoader, replacePairLoader, customReplacePairLoader, characterBatchSize, tokenBatchSize);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TranslatorBuilderParams)) {
                return false;
            }
            TranslatorBuilderParams translatorBuilderParams = (TranslatorBuilderParams) other;
            return Intrinsics.areEqual(this.context, translatorBuilderParams.context) && Intrinsics.areEqual(this.fileLoader, translatorBuilderParams.fileLoader) && Intrinsics.areEqual(this.translationMemoryLoader, translatorBuilderParams.translationMemoryLoader) && Intrinsics.areEqual(this.customTranslationMemoryLoader, translatorBuilderParams.customTranslationMemoryLoader) && Intrinsics.areEqual(this.swearWordRuleLoader, translatorBuilderParams.swearWordRuleLoader) && Intrinsics.areEqual(this.replacePairLoader, translatorBuilderParams.replacePairLoader) && Intrinsics.areEqual(this.customReplacePairLoader, translatorBuilderParams.customReplacePairLoader) && this.characterBatchSize == translatorBuilderParams.characterBatchSize && this.tokenBatchSize == translatorBuilderParams.tokenBatchSize;
        }

        public int hashCode() {
            return (((((((((((((((this.context.hashCode() * 31) + this.fileLoader.hashCode()) * 31) + this.translationMemoryLoader.hashCode()) * 31) + this.customTranslationMemoryLoader.hashCode()) * 31) + this.swearWordRuleLoader.hashCode()) * 31) + this.replacePairLoader.hashCode()) * 31) + this.customReplacePairLoader.hashCode()) * 31) + Integer.hashCode(this.characterBatchSize)) * 31) + Integer.hashCode(this.tokenBatchSize);
        }

        public String toString() {
            return "TranslatorBuilderParams(context=" + this.context + ", fileLoader=" + this.fileLoader + ", translationMemoryLoader=" + this.translationMemoryLoader + ", customTranslationMemoryLoader=" + this.customTranslationMemoryLoader + ", swearWordRuleLoader=" + this.swearWordRuleLoader + ", replacePairLoader=" + this.replacePairLoader + ", customReplacePairLoader=" + this.customReplacePairLoader + ", characterBatchSize=" + this.characterBatchSize + ", tokenBatchSize=" + this.tokenBatchSize + ')';
        }

        public TranslatorBuilderParams(Context context, FileLoader fileLoader, TranslationMemoryLoader translationMemoryLoader, CustomTranslationMemoryLoader customTranslationMemoryLoader, SwearWordRuleLoader swearWordRuleLoader, ReplacePairLoader replacePairLoader, CustomReplacePairLoader customReplacePairLoader, int characterBatchSize, int tokenBatchSize) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
            Intrinsics.checkNotNullParameter(translationMemoryLoader, "translationMemoryLoader");
            Intrinsics.checkNotNullParameter(customTranslationMemoryLoader, "customTranslationMemoryLoader");
            Intrinsics.checkNotNullParameter(swearWordRuleLoader, "swearWordRuleLoader");
            Intrinsics.checkNotNullParameter(replacePairLoader, "replacePairLoader");
            Intrinsics.checkNotNullParameter(customReplacePairLoader, "customReplacePairLoader");
            this.context = context;
            this.fileLoader = fileLoader;
            this.translationMemoryLoader = translationMemoryLoader;
            this.customTranslationMemoryLoader = customTranslationMemoryLoader;
            this.swearWordRuleLoader = swearWordRuleLoader;
            this.replacePairLoader = replacePairLoader;
            this.customReplacePairLoader = customReplacePairLoader;
            this.characterBatchSize = characterBatchSize;
            this.tokenBatchSize = tokenBatchSize;
        }

        public final Context getContext() {
            return this.context;
        }

        public final FileLoader getFileLoader() {
            return this.fileLoader;
        }

        public final TranslationMemoryLoader getTranslationMemoryLoader() {
            return this.translationMemoryLoader;
        }

        public final CustomTranslationMemoryLoader getCustomTranslationMemoryLoader() {
            return this.customTranslationMemoryLoader;
        }

        public final SwearWordRuleLoader getSwearWordRuleLoader() {
            return this.swearWordRuleLoader;
        }

        public final ReplacePairLoader getReplacePairLoader() {
            return this.replacePairLoader;
        }

        public final CustomReplacePairLoader getCustomReplacePairLoader() {
            return this.customReplacePairLoader;
        }

        public final int getCharacterBatchSize() {
            return this.characterBatchSize;
        }

        public final int getTokenBatchSize() {
            return this.tokenBatchSize;
        }
    }
}
