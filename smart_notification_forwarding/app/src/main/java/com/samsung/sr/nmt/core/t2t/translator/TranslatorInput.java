package com.samsung.sr.nmt.core.t2t.translator;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.samsung.sr.nmt.core.t2t.translator.pipeline.TranslationTask;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslatorInput.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 <2\u00020\u0001:\u0002;<B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0085\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e¢\u0006\u0002\u0010\u0015J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u000eHÆ\u0003J\t\u0010(\u001a\u00020\u000eHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003J\t\u0010+\u001a\u00020\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u000bHÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\t\u00100\u001a\u00020\u000eHÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\u008d\u0001\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u000eHÆ\u0001J\u0013\u00104\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0006HÖ\u0001J\u0006\u00109\u001a\u00020:R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\u0012\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017¨\u0006="}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorInput;", JsonProperty.USE_DEFAULT_NAME, "builder", "Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorInput$Builder;", "(Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorInput$Builder;)V", "sourceLanguageCode", JsonProperty.USE_DEFAULT_NAME, "targetLanguageCode", "sourceText", "id", "threshold", JsonProperty.USE_DEFAULT_NAME, "fallbackLanguage", "verbose", JsonProperty.USE_DEFAULT_NAME, "appendMeta", "mode", "forcePivot", "formality", "packageName", "needSentenceSplit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;FLjava/lang/String;ZZLjava/lang/String;ZZLjava/lang/String;Z)V", "getAppendMeta", "()Z", "getFallbackLanguage", "()Ljava/lang/String;", "getForcePivot", "getFormality", "getId", "getMode", "getNeedSentenceSplit", "getPackageName", "getSourceLanguageCode", "getSourceText", "getTargetLanguageCode", "getThreshold", "()F", "getVerbose", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "toTask", "Lcom/samsung/sr/nmt/core/t2t/translator/pipeline/TranslationTask;", "Builder", "Companion", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class TranslatorInput {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean appendMeta;
    private final String fallbackLanguage;
    private final boolean forcePivot;
    private final boolean formality;
    private final String id;
    private final String mode;
    private final boolean needSentenceSplit;
    private final String packageName;
    private final String sourceLanguageCode;
    private final String sourceText;
    private final String targetLanguageCode;
    private final float threshold;
    private final boolean verbose;

    public /* synthetic */ TranslatorInput(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    @JvmStatic
    public static final Builder builder() {
        return INSTANCE.builder();
    }

    /* renamed from: component1, reason: from getter */
    public final String getSourceLanguageCode() {
        return this.sourceLanguageCode;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getForcePivot() {
        return this.forcePivot;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getFormality() {
        return this.formality;
    }

    /* renamed from: component12, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getNeedSentenceSplit() {
        return this.needSentenceSplit;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTargetLanguageCode() {
        return this.targetLanguageCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSourceText() {
        return this.sourceText;
    }

    /* renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component5, reason: from getter */
    public final float getThreshold() {
        return this.threshold;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFallbackLanguage() {
        return this.fallbackLanguage;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getVerbose() {
        return this.verbose;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getAppendMeta() {
        return this.appendMeta;
    }

    /* renamed from: component9, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    public final TranslatorInput copy(String sourceLanguageCode, String targetLanguageCode, String sourceText, String id, float threshold, String fallbackLanguage, boolean verbose, boolean appendMeta, String mode, boolean forcePivot, boolean formality, String packageName, boolean needSentenceSplit) {
        Intrinsics.checkNotNullParameter(sourceLanguageCode, "sourceLanguageCode");
        Intrinsics.checkNotNullParameter(targetLanguageCode, "targetLanguageCode");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(fallbackLanguage, "fallbackLanguage");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new TranslatorInput(sourceLanguageCode, targetLanguageCode, sourceText, id, threshold, fallbackLanguage, verbose, appendMeta, mode, forcePivot, formality, packageName, needSentenceSplit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranslatorInput)) {
            return false;
        }
        TranslatorInput translatorInput = (TranslatorInput) other;
        return Intrinsics.areEqual(this.sourceLanguageCode, translatorInput.sourceLanguageCode) && Intrinsics.areEqual(this.targetLanguageCode, translatorInput.targetLanguageCode) && Intrinsics.areEqual(this.sourceText, translatorInput.sourceText) && Intrinsics.areEqual(this.id, translatorInput.id) && Float.compare(this.threshold, translatorInput.threshold) == 0 && Intrinsics.areEqual(this.fallbackLanguage, translatorInput.fallbackLanguage) && this.verbose == translatorInput.verbose && this.appendMeta == translatorInput.appendMeta && Intrinsics.areEqual(this.mode, translatorInput.mode) && this.forcePivot == translatorInput.forcePivot && this.formality == translatorInput.formality && Intrinsics.areEqual(this.packageName, translatorInput.packageName) && this.needSentenceSplit == translatorInput.needSentenceSplit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.sourceLanguageCode.hashCode() * 31) + this.targetLanguageCode.hashCode()) * 31) + this.sourceText.hashCode()) * 31) + this.id.hashCode()) * 31) + Float.hashCode(this.threshold)) * 31) + this.fallbackLanguage.hashCode()) * 31;
        boolean z = this.verbose;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.appendMeta;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int hashCode2 = (((i2 + i3) * 31) + this.mode.hashCode()) * 31;
        boolean z3 = this.forcePivot;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (hashCode2 + i4) * 31;
        boolean z4 = this.formality;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        String str = this.packageName;
        int hashCode3 = (i7 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z5 = this.needSentenceSplit;
        return hashCode3 + (z5 ? 1 : z5 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TranslatorInput(sourceLanguageCode=");
        sb.append(this.sourceLanguageCode).append(", targetLanguageCode=").append(this.targetLanguageCode).append(", sourceText=").append(this.sourceText).append(", id=").append(this.id).append(", threshold=").append(this.threshold).append(", fallbackLanguage=").append(this.fallbackLanguage).append(", verbose=").append(this.verbose).append(", appendMeta=").append(this.appendMeta).append(", mode=").append(this.mode).append(", forcePivot=").append(this.forcePivot).append(", formality=").append(this.formality).append(", packageName=");
        sb.append(this.packageName).append(", needSentenceSplit=").append(this.needSentenceSplit).append(')');
        return sb.toString();
    }

    public TranslatorInput(String sourceLanguageCode, String targetLanguageCode, String sourceText, String id, float threshold, String fallbackLanguage, boolean verbose, boolean appendMeta, String mode, boolean forcePivot, boolean formality, String packageName, boolean needSentenceSplit) {
        Intrinsics.checkNotNullParameter(sourceLanguageCode, "sourceLanguageCode");
        Intrinsics.checkNotNullParameter(targetLanguageCode, "targetLanguageCode");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(fallbackLanguage, "fallbackLanguage");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.sourceLanguageCode = sourceLanguageCode;
        this.targetLanguageCode = targetLanguageCode;
        this.sourceText = sourceText;
        this.id = id;
        this.threshold = threshold;
        this.fallbackLanguage = fallbackLanguage;
        this.verbose = verbose;
        this.appendMeta = appendMeta;
        this.mode = mode;
        this.forcePivot = forcePivot;
        this.formality = formality;
        this.packageName = packageName;
        this.needSentenceSplit = needSentenceSplit;
    }

    public /* synthetic */ TranslatorInput(String str, String str2, String str3, String str4, float f, String str5, boolean z, boolean z2, String str6, boolean z3, boolean z4, String str7, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? JsonProperty.USE_DEFAULT_NAME : str, str2, str3, (i & 8) != 0 ? JsonProperty.USE_DEFAULT_NAME : str4, (i & 16) != 0 ? 0.0f : f, (i & 32) != 0 ? "en" : str5, (i & 64) != 0 ? false : z, (i & 128) != 0 ? false : z2, (i & 256) != 0 ? "plain" : str6, (i & 512) != 0 ? false : z3, (i & 1024) != 0 ? false : z4, (i & 2048) != 0 ? null : str7, (i & 4096) != 0 ? true : z5);
    }

    public final String getSourceLanguageCode() {
        return this.sourceLanguageCode;
    }

    public final String getTargetLanguageCode() {
        return this.targetLanguageCode;
    }

    public final String getSourceText() {
        return this.sourceText;
    }

    public final String getId() {
        return this.id;
    }

    public final float getThreshold() {
        return this.threshold;
    }

    public final String getFallbackLanguage() {
        return this.fallbackLanguage;
    }

    public final boolean getVerbose() {
        return this.verbose;
    }

    public final boolean getAppendMeta() {
        return this.appendMeta;
    }

    public final String getMode() {
        return this.mode;
    }

    public final boolean getForcePivot() {
        return this.forcePivot;
    }

    public final boolean getFormality() {
        return this.formality;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final boolean getNeedSentenceSplit() {
        return this.needSentenceSplit;
    }

    public final TranslationTask toTask() {
        return new TranslationTask(this.sourceLanguageCode, this.targetLanguageCode, this.sourceText, null, this.id, null, null, this.verbose, this.appendMeta, this.forcePivot, this.formality, null, 2152, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private TranslatorInput(com.samsung.sr.nmt.core.t2t.translator.TranslatorInput.Builder r15) {
        /*
            r14 = this;
            java.lang.String r1 = r15.getSourceLanguageCode()
            java.lang.String r2 = r15.getTargetLanguageCode()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            java.lang.String r3 = r15.getSourceText()
            java.lang.String r4 = r15.getId()
            float r5 = r15.getThreshold()
            java.lang.String r6 = r15.getFallbackLanguage()
            boolean r7 = r15.getVerbose()
            boolean r8 = r15.getAppendMeta()
            java.lang.String r9 = r15.getMode()
            boolean r10 = r15.getForcePivot()
            boolean r11 = r15.getFormality()
            java.lang.String r12 = r15.getPackageName()
            boolean r13 = r15.getNeedSentenceSplit()
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.core.t2t.translator.TranslatorInput.<init>(com.samsung.sr.nmt.core.t2t.translator.TranslatorInput$Builder):void");
    }

    /* compiled from: TranslatorInput.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorInput$Companion;", JsonProperty.USE_DEFAULT_NAME, "()V", "builder", "Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorInput$Builder;", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }
    }

    /* compiled from: TranslatorInput.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020,J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00002\u0006\u0010#\u001a\u00020$J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0004R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u001e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u001a\u0010\u0016\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\u0011R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000b\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000bR\u001e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u000bR\"\u0010!\u001a\u0004\u0018\u00010\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000bR\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0007¨\u0006-"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorInput$Builder;", JsonProperty.USE_DEFAULT_NAME, "()V", "<set-?>", JsonProperty.USE_DEFAULT_NAME, "appendMeta", "getAppendMeta", "()Z", JsonProperty.USE_DEFAULT_NAME, "fallbackLanguage", "getFallbackLanguage", "()Ljava/lang/String;", "forcePivot", "getForcePivot", "formality", "getFormality", "setFormality", "(Z)V", "id", "getId", "mode", "getMode", "needSentenceSplit", "getNeedSentenceSplit", "setNeedSentenceSplit", "packageName", "getPackageName", "setPackageName", "(Ljava/lang/String;)V", "sourceLanguageCode", "getSourceLanguageCode", "sourceText", "getSourceText", "targetLanguageCode", "getTargetLanguageCode", "threshold", JsonProperty.USE_DEFAULT_NAME, "getThreshold", "()F", "setThreshold", "(F)V", "verbose", "getVerbose", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorInput;", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean appendMeta;
        private boolean forcePivot;
        private boolean formality;
        private String packageName;
        private String targetLanguageCode;
        private float threshold;
        private boolean verbose;
        private String sourceLanguageCode = JsonProperty.USE_DEFAULT_NAME;
        private String sourceText = JsonProperty.USE_DEFAULT_NAME;
        private String id = JsonProperty.USE_DEFAULT_NAME;
        private String mode = "plain";
        private String fallbackLanguage = "en";
        private boolean needSentenceSplit = true;

        public final String getSourceLanguageCode() {
            return this.sourceLanguageCode;
        }

        public final String getTargetLanguageCode() {
            return this.targetLanguageCode;
        }

        public final String getSourceText() {
            return this.sourceText;
        }

        public final String getId() {
            return this.id;
        }

        public final boolean getVerbose() {
            return this.verbose;
        }

        public final boolean getAppendMeta() {
            return this.appendMeta;
        }

        public final String getMode() {
            return this.mode;
        }

        public final boolean getForcePivot() {
            return this.forcePivot;
        }

        public final boolean getFormality() {
            return this.formality;
        }

        public final void setFormality(boolean z) {
            this.formality = z;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final void setPackageName(String str) {
            this.packageName = str;
        }

        public final float getThreshold() {
            return this.threshold;
        }

        public final void setThreshold(float f) {
            this.threshold = f;
        }

        public final String getFallbackLanguage() {
            return this.fallbackLanguage;
        }

        public final boolean getNeedSentenceSplit() {
            return this.needSentenceSplit;
        }

        public final void setNeedSentenceSplit(boolean z) {
            this.needSentenceSplit = z;
        }

        public final Builder sourceLanguageCode(String sourceLanguageCode) {
            Intrinsics.checkNotNullParameter(sourceLanguageCode, "sourceLanguageCode");
            this.sourceLanguageCode = sourceLanguageCode;
            return this;
        }

        public final Builder targetLanguageCode(String targetLanguageCode) {
            Intrinsics.checkNotNullParameter(targetLanguageCode, "targetLanguageCode");
            this.targetLanguageCode = targetLanguageCode;
            return this;
        }

        public final Builder sourceText(String sourceText) {
            Intrinsics.checkNotNullParameter(sourceText, "sourceText");
            this.sourceText = sourceText;
            return this;
        }

        public final Builder id(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            this.id = id;
            return this;
        }

        public final Builder verbose(boolean verbose) {
            this.verbose = verbose;
            return this;
        }

        public final Builder appendMeta(boolean appendMeta) {
            this.appendMeta = appendMeta;
            return this;
        }

        public final Builder threshold(float threshold) {
            this.threshold = threshold;
            return this;
        }

        public final Builder fallbackLanguage(String fallbackLanguage) {
            Intrinsics.checkNotNullParameter(fallbackLanguage, "fallbackLanguage");
            this.fallbackLanguage = fallbackLanguage;
            return this;
        }

        public final Builder mode(String mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.mode = mode;
            return this;
        }

        public final Builder forcePivot(boolean forcePivot) {
            this.forcePivot = forcePivot;
            return this;
        }

        public final Builder formality(boolean formality) {
            this.formality = formality;
            return this;
        }

        public final Builder packageName(String packageName) {
            Intrinsics.checkNotNullParameter(packageName, "packageName");
            this.packageName = packageName;
            return this;
        }

        public final Builder needSentenceSplit(boolean needSentenceSplit) {
            this.needSentenceSplit = needSentenceSplit;
            return this;
        }

        public final TranslatorInput build() {
            if (this.targetLanguageCode == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            return new TranslatorInput(this, null);
        }
    }
}
