package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.resource;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VocabSpec.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003J\t\u0010(\u001a\u00020\u000eHÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u000bHÆ\u0003J\t\u0010/\u001a\u00020\u000bHÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\u008b\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000eHÆ\u0001J\u0013\u00102\u001a\u00020\u000e2\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0005HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u00066"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/resource/VocabSpec;", JsonProperty.USE_DEFAULT_NAME, "vocabPath", JsonProperty.USE_DEFAULT_NAME, "eosId", JsonProperty.USE_DEFAULT_NAME, "alphabetPath", "vocabLangIdPath", "sourceLanguage", "targetLanguage", "unknownTokenRatioThreshold", JsonProperty.USE_DEFAULT_NAME, "invalidLanguageIdRejectionRatioThreshold", "processPlh", JsonProperty.USE_DEFAULT_NAME, "plhTok", "numPlhTok", "preventPlhTokenSplits", "isIndian", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FFZLjava/lang/String;IZZ)V", "getAlphabetPath", "()Ljava/lang/String;", "getEosId", "()I", "getInvalidLanguageIdRejectionRatioThreshold", "()F", "()Z", "getNumPlhTok", "getPlhTok", "getPreventPlhTokenSplits", "getProcessPlh", "getSourceLanguage", "getTargetLanguage", "getUnknownTokenRatioThreshold", "getVocabLangIdPath", "getVocabPath", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class VocabSpec {
    private final String alphabetPath;
    private final int eosId;
    private final float invalidLanguageIdRejectionRatioThreshold;
    private final boolean isIndian;
    private final int numPlhTok;
    private final String plhTok;
    private final boolean preventPlhTokenSplits;
    private final boolean processPlh;
    private final String sourceLanguage;
    private final String targetLanguage;
    private final float unknownTokenRatioThreshold;
    private final String vocabLangIdPath;
    private final String vocabPath;

    /* renamed from: component1, reason: from getter */
    public final String getVocabPath() {
        return this.vocabPath;
    }

    /* renamed from: component10, reason: from getter */
    public final String getPlhTok() {
        return this.plhTok;
    }

    /* renamed from: component11, reason: from getter */
    public final int getNumPlhTok() {
        return this.numPlhTok;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getPreventPlhTokenSplits() {
        return this.preventPlhTokenSplits;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIsIndian() {
        return this.isIndian;
    }

    /* renamed from: component2, reason: from getter */
    public final int getEosId() {
        return this.eosId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAlphabetPath() {
        return this.alphabetPath;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVocabLangIdPath() {
        return this.vocabLangIdPath;
    }

    /* renamed from: component5, reason: from getter */
    public final String getSourceLanguage() {
        return this.sourceLanguage;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    /* renamed from: component7, reason: from getter */
    public final float getUnknownTokenRatioThreshold() {
        return this.unknownTokenRatioThreshold;
    }

    /* renamed from: component8, reason: from getter */
    public final float getInvalidLanguageIdRejectionRatioThreshold() {
        return this.invalidLanguageIdRejectionRatioThreshold;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getProcessPlh() {
        return this.processPlh;
    }

    public final VocabSpec copy(String vocabPath, int eosId, String alphabetPath, String vocabLangIdPath, String sourceLanguage, String targetLanguage, float unknownTokenRatioThreshold, float invalidLanguageIdRejectionRatioThreshold, boolean processPlh, String plhTok, int numPlhTok, boolean preventPlhTokenSplits, boolean isIndian) {
        Intrinsics.checkNotNullParameter(vocabPath, "vocabPath");
        Intrinsics.checkNotNullParameter(alphabetPath, "alphabetPath");
        Intrinsics.checkNotNullParameter(vocabLangIdPath, "vocabLangIdPath");
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(plhTok, "plhTok");
        return new VocabSpec(vocabPath, eosId, alphabetPath, vocabLangIdPath, sourceLanguage, targetLanguage, unknownTokenRatioThreshold, invalidLanguageIdRejectionRatioThreshold, processPlh, plhTok, numPlhTok, preventPlhTokenSplits, isIndian);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VocabSpec)) {
            return false;
        }
        VocabSpec vocabSpec = (VocabSpec) other;
        return Intrinsics.areEqual(this.vocabPath, vocabSpec.vocabPath) && this.eosId == vocabSpec.eosId && Intrinsics.areEqual(this.alphabetPath, vocabSpec.alphabetPath) && Intrinsics.areEqual(this.vocabLangIdPath, vocabSpec.vocabLangIdPath) && Intrinsics.areEqual(this.sourceLanguage, vocabSpec.sourceLanguage) && Intrinsics.areEqual(this.targetLanguage, vocabSpec.targetLanguage) && Float.compare(this.unknownTokenRatioThreshold, vocabSpec.unknownTokenRatioThreshold) == 0 && Float.compare(this.invalidLanguageIdRejectionRatioThreshold, vocabSpec.invalidLanguageIdRejectionRatioThreshold) == 0 && this.processPlh == vocabSpec.processPlh && Intrinsics.areEqual(this.plhTok, vocabSpec.plhTok) && this.numPlhTok == vocabSpec.numPlhTok && this.preventPlhTokenSplits == vocabSpec.preventPlhTokenSplits && this.isIndian == vocabSpec.isIndian;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((((((this.vocabPath.hashCode() * 31) + Integer.hashCode(this.eosId)) * 31) + this.alphabetPath.hashCode()) * 31) + this.vocabLangIdPath.hashCode()) * 31) + this.sourceLanguage.hashCode()) * 31) + this.targetLanguage.hashCode()) * 31) + Float.hashCode(this.unknownTokenRatioThreshold)) * 31) + Float.hashCode(this.invalidLanguageIdRejectionRatioThreshold)) * 31;
        boolean z = this.processPlh;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode2 = (((((hashCode + i) * 31) + this.plhTok.hashCode()) * 31) + Integer.hashCode(this.numPlhTok)) * 31;
        boolean z2 = this.preventPlhTokenSplits;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z3 = this.isIndian;
        return i3 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        return "VocabSpec(vocabPath=" + this.vocabPath + ", eosId=" + this.eosId + ", alphabetPath=" + this.alphabetPath + ", vocabLangIdPath=" + this.vocabLangIdPath + ", sourceLanguage=" + this.sourceLanguage + ", targetLanguage=" + this.targetLanguage + ", unknownTokenRatioThreshold=" + this.unknownTokenRatioThreshold + ", invalidLanguageIdRejectionRatioThreshold=" + this.invalidLanguageIdRejectionRatioThreshold + ", processPlh=" + this.processPlh + ", plhTok=" + this.plhTok + ", numPlhTok=" + this.numPlhTok + ", preventPlhTokenSplits=" + this.preventPlhTokenSplits + ", isIndian=" + this.isIndian + ")";
    }

    public VocabSpec(String vocabPath, int i, String alphabetPath, String vocabLangIdPath, String sourceLanguage, String targetLanguage, float f, float f2, boolean z, String plhTok, int i2, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(vocabPath, "vocabPath");
        Intrinsics.checkNotNullParameter(alphabetPath, "alphabetPath");
        Intrinsics.checkNotNullParameter(vocabLangIdPath, "vocabLangIdPath");
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(plhTok, "plhTok");
        this.vocabPath = vocabPath;
        this.eosId = i;
        this.alphabetPath = alphabetPath;
        this.vocabLangIdPath = vocabLangIdPath;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.unknownTokenRatioThreshold = f;
        this.invalidLanguageIdRejectionRatioThreshold = f2;
        this.processPlh = z;
        this.plhTok = plhTok;
        this.numPlhTok = i2;
        this.preventPlhTokenSplits = z2;
        this.isIndian = z3;
    }

    public /* synthetic */ VocabSpec(String str, int i, String str2, String str3, String str4, String str5, float f, float f2, boolean z, String str6, int i2, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, str3, str4, str5, f, f2, (i3 & 256) != 0 ? false : z, (i3 & 512) != 0 ? JsonProperty.USE_DEFAULT_NAME : str6, (i3 & 1024) != 0 ? 0 : i2, (i3 & 2048) != 0 ? false : z2, (i3 & 4096) != 0 ? false : z3);
    }

    public final String getVocabPath() {
        return this.vocabPath;
    }

    public final int getEosId() {
        return this.eosId;
    }

    public final String getAlphabetPath() {
        return this.alphabetPath;
    }

    public final String getVocabLangIdPath() {
        return this.vocabLangIdPath;
    }

    public final String getSourceLanguage() {
        return this.sourceLanguage;
    }

    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    public final float getUnknownTokenRatioThreshold() {
        return this.unknownTokenRatioThreshold;
    }

    public final float getInvalidLanguageIdRejectionRatioThreshold() {
        return this.invalidLanguageIdRejectionRatioThreshold;
    }

    public final boolean getProcessPlh() {
        return this.processPlh;
    }

    public final String getPlhTok() {
        return this.plhTok;
    }

    public final int getNumPlhTok() {
        return this.numPlhTok;
    }

    public final boolean getPreventPlhTokenSplits() {
        return this.preventPlhTokenSplits;
    }

    public final boolean isIndian() {
        return this.isIndian;
    }
}
