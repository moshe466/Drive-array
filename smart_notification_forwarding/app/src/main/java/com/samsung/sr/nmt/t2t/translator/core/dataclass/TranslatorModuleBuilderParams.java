package com.samsung.sr.nmt.t2t.translator.core.dataclass;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.fileloader.FileLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomReplacePairLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.CustomTranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.ReplacePairLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.SwearWordRuleLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.TranslationMemoryLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.AssetLoader;
import com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslatorModuleBuilderParams.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0013HÆ\u0003J\t\u0010/\u001a\u00020\u0016HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\tHÆ\u0003J\t\u00103\u001a\u00020\u000bHÆ\u0003J\t\u00104\u001a\u00020\rHÆ\u0003J\t\u00105\u001a\u00020\u000fHÆ\u0003J\t\u00106\u001a\u00020\u0011HÆ\u0003J\t\u00107\u001a\u00020\u0013HÆ\u0003Jw\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0016HÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\u0013HÖ\u0001J\t\u0010=\u001a\u00020>HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006?"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorModuleBuilderParams;", JsonProperty.USE_DEFAULT_NAME, "assetLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;", "environmentHelper", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;", "fileLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "translationMemoryLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;", "customTranslationMemoryLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;", "swearWordRuleLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;", "replacePairLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/ReplacePairLoader;", "customReplacePairLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomReplacePairLoader;", "characterBatchSize", JsonProperty.USE_DEFAULT_NAME, "tokenBatchSize", "unknownTokenRatioThreshold", JsonProperty.USE_DEFAULT_NAME, "(Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/ReplacePairLoader;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomReplacePairLoader;IIF)V", "getAssetLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/utils/AssetLoader;", "getCharacterBatchSize", "()I", "getCustomReplacePairLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomReplacePairLoader;", "getCustomTranslationMemoryLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/CustomTranslationMemoryLoader;", "getEnvironmentHelper", "()Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;", "getFileLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/fileloader/FileLoader;", "getReplacePairLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/ReplacePairLoader;", "getSwearWordRuleLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;", "getTokenBatchSize", "getTranslationMemoryLoader", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/TranslationMemoryLoader;", "getUnknownTokenRatioThreshold", "()F", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", "toString", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class TranslatorModuleBuilderParams {
    private final AssetLoader assetLoader;
    private final int characterBatchSize;
    private final CustomReplacePairLoader customReplacePairLoader;
    private final CustomTranslationMemoryLoader customTranslationMemoryLoader;
    private final EnvironmentHelper environmentHelper;
    private final FileLoader fileLoader;
    private final ReplacePairLoader replacePairLoader;
    private final SwearWordRuleLoader swearWordRuleLoader;
    private final int tokenBatchSize;
    private final TranslationMemoryLoader translationMemoryLoader;
    private final float unknownTokenRatioThreshold;

    /* renamed from: component1, reason: from getter */
    public final AssetLoader getAssetLoader() {
        return this.assetLoader;
    }

    /* renamed from: component10, reason: from getter */
    public final int getTokenBatchSize() {
        return this.tokenBatchSize;
    }

    /* renamed from: component11, reason: from getter */
    public final float getUnknownTokenRatioThreshold() {
        return this.unknownTokenRatioThreshold;
    }

    /* renamed from: component2, reason: from getter */
    public final EnvironmentHelper getEnvironmentHelper() {
        return this.environmentHelper;
    }

    /* renamed from: component3, reason: from getter */
    public final FileLoader getFileLoader() {
        return this.fileLoader;
    }

    /* renamed from: component4, reason: from getter */
    public final TranslationMemoryLoader getTranslationMemoryLoader() {
        return this.translationMemoryLoader;
    }

    /* renamed from: component5, reason: from getter */
    public final CustomTranslationMemoryLoader getCustomTranslationMemoryLoader() {
        return this.customTranslationMemoryLoader;
    }

    /* renamed from: component6, reason: from getter */
    public final SwearWordRuleLoader getSwearWordRuleLoader() {
        return this.swearWordRuleLoader;
    }

    /* renamed from: component7, reason: from getter */
    public final ReplacePairLoader getReplacePairLoader() {
        return this.replacePairLoader;
    }

    /* renamed from: component8, reason: from getter */
    public final CustomReplacePairLoader getCustomReplacePairLoader() {
        return this.customReplacePairLoader;
    }

    /* renamed from: component9, reason: from getter */
    public final int getCharacterBatchSize() {
        return this.characterBatchSize;
    }

    public final TranslatorModuleBuilderParams copy(AssetLoader assetLoader, EnvironmentHelper environmentHelper, FileLoader fileLoader, TranslationMemoryLoader translationMemoryLoader, CustomTranslationMemoryLoader customTranslationMemoryLoader, SwearWordRuleLoader swearWordRuleLoader, ReplacePairLoader replacePairLoader, CustomReplacePairLoader customReplacePairLoader, int characterBatchSize, int tokenBatchSize, float unknownTokenRatioThreshold) {
        Intrinsics.checkNotNullParameter(assetLoader, "assetLoader");
        Intrinsics.checkNotNullParameter(environmentHelper, "environmentHelper");
        Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
        Intrinsics.checkNotNullParameter(translationMemoryLoader, "translationMemoryLoader");
        Intrinsics.checkNotNullParameter(customTranslationMemoryLoader, "customTranslationMemoryLoader");
        Intrinsics.checkNotNullParameter(swearWordRuleLoader, "swearWordRuleLoader");
        Intrinsics.checkNotNullParameter(replacePairLoader, "replacePairLoader");
        Intrinsics.checkNotNullParameter(customReplacePairLoader, "customReplacePairLoader");
        return new TranslatorModuleBuilderParams(assetLoader, environmentHelper, fileLoader, translationMemoryLoader, customTranslationMemoryLoader, swearWordRuleLoader, replacePairLoader, customReplacePairLoader, characterBatchSize, tokenBatchSize, unknownTokenRatioThreshold);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranslatorModuleBuilderParams)) {
            return false;
        }
        TranslatorModuleBuilderParams translatorModuleBuilderParams = (TranslatorModuleBuilderParams) other;
        return Intrinsics.areEqual(this.assetLoader, translatorModuleBuilderParams.assetLoader) && Intrinsics.areEqual(this.environmentHelper, translatorModuleBuilderParams.environmentHelper) && Intrinsics.areEqual(this.fileLoader, translatorModuleBuilderParams.fileLoader) && Intrinsics.areEqual(this.translationMemoryLoader, translatorModuleBuilderParams.translationMemoryLoader) && Intrinsics.areEqual(this.customTranslationMemoryLoader, translatorModuleBuilderParams.customTranslationMemoryLoader) && Intrinsics.areEqual(this.swearWordRuleLoader, translatorModuleBuilderParams.swearWordRuleLoader) && Intrinsics.areEqual(this.replacePairLoader, translatorModuleBuilderParams.replacePairLoader) && Intrinsics.areEqual(this.customReplacePairLoader, translatorModuleBuilderParams.customReplacePairLoader) && this.characterBatchSize == translatorModuleBuilderParams.characterBatchSize && this.tokenBatchSize == translatorModuleBuilderParams.tokenBatchSize && Float.compare(this.unknownTokenRatioThreshold, translatorModuleBuilderParams.unknownTokenRatioThreshold) == 0;
    }

    public int hashCode() {
        return (((((((((((((((((((this.assetLoader.hashCode() * 31) + this.environmentHelper.hashCode()) * 31) + this.fileLoader.hashCode()) * 31) + this.translationMemoryLoader.hashCode()) * 31) + this.customTranslationMemoryLoader.hashCode()) * 31) + this.swearWordRuleLoader.hashCode()) * 31) + this.replacePairLoader.hashCode()) * 31) + this.customReplacePairLoader.hashCode()) * 31) + Integer.hashCode(this.characterBatchSize)) * 31) + Integer.hashCode(this.tokenBatchSize)) * 31) + Float.hashCode(this.unknownTokenRatioThreshold);
    }

    public String toString() {
        return "TranslatorModuleBuilderParams(assetLoader=" + this.assetLoader + ", environmentHelper=" + this.environmentHelper + ", fileLoader=" + this.fileLoader + ", translationMemoryLoader=" + this.translationMemoryLoader + ", customTranslationMemoryLoader=" + this.customTranslationMemoryLoader + ", swearWordRuleLoader=" + this.swearWordRuleLoader + ", replacePairLoader=" + this.replacePairLoader + ", customReplacePairLoader=" + this.customReplacePairLoader + ", characterBatchSize=" + this.characterBatchSize + ", tokenBatchSize=" + this.tokenBatchSize + ", unknownTokenRatioThreshold=" + this.unknownTokenRatioThreshold + ")";
    }

    public TranslatorModuleBuilderParams(AssetLoader assetLoader, EnvironmentHelper environmentHelper, FileLoader fileLoader, TranslationMemoryLoader translationMemoryLoader, CustomTranslationMemoryLoader customTranslationMemoryLoader, SwearWordRuleLoader swearWordRuleLoader, ReplacePairLoader replacePairLoader, CustomReplacePairLoader customReplacePairLoader, int i, int i2, float f) {
        Intrinsics.checkNotNullParameter(assetLoader, "assetLoader");
        Intrinsics.checkNotNullParameter(environmentHelper, "environmentHelper");
        Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
        Intrinsics.checkNotNullParameter(translationMemoryLoader, "translationMemoryLoader");
        Intrinsics.checkNotNullParameter(customTranslationMemoryLoader, "customTranslationMemoryLoader");
        Intrinsics.checkNotNullParameter(swearWordRuleLoader, "swearWordRuleLoader");
        Intrinsics.checkNotNullParameter(replacePairLoader, "replacePairLoader");
        Intrinsics.checkNotNullParameter(customReplacePairLoader, "customReplacePairLoader");
        this.assetLoader = assetLoader;
        this.environmentHelper = environmentHelper;
        this.fileLoader = fileLoader;
        this.translationMemoryLoader = translationMemoryLoader;
        this.customTranslationMemoryLoader = customTranslationMemoryLoader;
        this.swearWordRuleLoader = swearWordRuleLoader;
        this.replacePairLoader = replacePairLoader;
        this.customReplacePairLoader = customReplacePairLoader;
        this.characterBatchSize = i;
        this.tokenBatchSize = i2;
        this.unknownTokenRatioThreshold = f;
    }

    public /* synthetic */ TranslatorModuleBuilderParams(AssetLoader assetLoader, EnvironmentHelper environmentHelper, FileLoader fileLoader, TranslationMemoryLoader translationMemoryLoader, CustomTranslationMemoryLoader customTranslationMemoryLoader, SwearWordRuleLoader swearWordRuleLoader, ReplacePairLoader replacePairLoader, CustomReplacePairLoader customReplacePairLoader, int i, int i2, float f, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(assetLoader, environmentHelper, fileLoader, translationMemoryLoader, customTranslationMemoryLoader, swearWordRuleLoader, replacePairLoader, customReplacePairLoader, i, i2, (i3 & 1024) != 0 ? 0.4f : f);
    }

    public final AssetLoader getAssetLoader() {
        return this.assetLoader;
    }

    public final EnvironmentHelper getEnvironmentHelper() {
        return this.environmentHelper;
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

    public final float getUnknownTokenRatioThreshold() {
        return this.unknownTokenRatioThreshold;
    }
}
