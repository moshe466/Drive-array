package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationTask.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b6\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r¢\u0006\u0002\u0010\u0015J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\rHÆ\u0003J\t\u00104\u001a\u00020\rHÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\tHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010>\u001a\u00020\rHÆ\u0003J\t\u0010?\u001a\u00020\rHÆ\u0003J¥\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\rHÆ\u0001J\u0013\u0010A\u001a\u00020\r2\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001fR\u0011\u0010\u0014\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001f\"\u0004\b&\u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001f\"\u0004\b+\u0010!R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0017¨\u0006F"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationTask;", JsonProperty.USE_DEFAULT_NAME, "sourceLanguageCode", JsonProperty.USE_DEFAULT_NAME, "targetLanguageCode", "sourceText", "targetText", "id", "errorCode", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationErrorCode;", "throwable", JsonProperty.USE_DEFAULT_NAME, "verbose", JsonProperty.USE_DEFAULT_NAME, "appendMeta", "mode", "forcePivot", "formality", "packageName", "pivotResult", "needSentenceSplit", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationErrorCode;Ljava/lang/Throwable;ZZLjava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Z)V", "getAppendMeta", "()Z", "getErrorCode", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationErrorCode;", "setErrorCode", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationErrorCode;)V", "getForcePivot", "getFormality", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getMode", "getNeedSentenceSplit", "getPackageName", "getPivotResult", "setPivotResult", "getSourceLanguageCode", "getSourceText", "getTargetLanguageCode", "getTargetText", "setTargetText", "getThrowable", "()Ljava/lang/Throwable;", "setThrowable", "(Ljava/lang/Throwable;)V", "getVerbose", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class TranslationTask {
    private final boolean appendMeta;
    private TranslationErrorCode errorCode;
    private final boolean forcePivot;
    private final boolean formality;
    private String id;
    private final String mode;
    private final boolean needSentenceSplit;
    private final String packageName;
    private String pivotResult;
    private final String sourceLanguageCode;
    private final String sourceText;
    private final String targetLanguageCode;
    private String targetText;
    private Throwable throwable;
    private final boolean verbose;

    /* renamed from: component1, reason: from getter */
    public final String getSourceLanguageCode() {
        return this.sourceLanguageCode;
    }

    /* renamed from: component10, reason: from getter */
    public final String getMode() {
        return this.mode;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getForcePivot() {
        return this.forcePivot;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getFormality() {
        return this.formality;
    }

    /* renamed from: component13, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component14, reason: from getter */
    public final String getPivotResult() {
        return this.pivotResult;
    }

    /* renamed from: component15, reason: from getter */
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
    public final String getTargetText() {
        return this.targetText;
    }

    /* renamed from: component5, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component6, reason: from getter */
    public final TranslationErrorCode getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component7, reason: from getter */
    public final Throwable getThrowable() {
        return this.throwable;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getVerbose() {
        return this.verbose;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getAppendMeta() {
        return this.appendMeta;
    }

    public final TranslationTask copy(String sourceLanguageCode, String targetLanguageCode, String sourceText, String targetText, String id, TranslationErrorCode errorCode, Throwable throwable, boolean verbose, boolean appendMeta, String mode, boolean forcePivot, boolean formality, String packageName, String pivotResult, boolean needSentenceSplit) {
        Intrinsics.checkNotNullParameter(sourceLanguageCode, "sourceLanguageCode");
        Intrinsics.checkNotNullParameter(targetLanguageCode, "targetLanguageCode");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(mode, "mode");
        return new TranslationTask(sourceLanguageCode, targetLanguageCode, sourceText, targetText, id, errorCode, throwable, verbose, appendMeta, mode, forcePivot, formality, packageName, pivotResult, needSentenceSplit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TranslationTask)) {
            return false;
        }
        TranslationTask translationTask = (TranslationTask) other;
        return Intrinsics.areEqual(this.sourceLanguageCode, translationTask.sourceLanguageCode) && Intrinsics.areEqual(this.targetLanguageCode, translationTask.targetLanguageCode) && Intrinsics.areEqual(this.sourceText, translationTask.sourceText) && Intrinsics.areEqual(this.targetText, translationTask.targetText) && Intrinsics.areEqual(this.id, translationTask.id) && this.errorCode == translationTask.errorCode && Intrinsics.areEqual(this.throwable, translationTask.throwable) && this.verbose == translationTask.verbose && this.appendMeta == translationTask.appendMeta && Intrinsics.areEqual(this.mode, translationTask.mode) && this.forcePivot == translationTask.forcePivot && this.formality == translationTask.formality && Intrinsics.areEqual(this.packageName, translationTask.packageName) && Intrinsics.areEqual(this.pivotResult, translationTask.pivotResult) && this.needSentenceSplit == translationTask.needSentenceSplit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((((this.sourceLanguageCode.hashCode() * 31) + this.targetLanguageCode.hashCode()) * 31) + this.sourceText.hashCode()) * 31) + this.targetText.hashCode()) * 31) + this.id.hashCode()) * 31) + this.errorCode.hashCode()) * 31;
        Throwable th = this.throwable;
        int hashCode2 = (hashCode + (th == null ? 0 : th.hashCode())) * 31;
        boolean z = this.verbose;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode2 + i) * 31;
        boolean z2 = this.appendMeta;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int hashCode3 = (((i2 + i3) * 31) + this.mode.hashCode()) * 31;
        boolean z3 = this.forcePivot;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (hashCode3 + i4) * 31;
        boolean z4 = this.formality;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        String str = this.packageName;
        int hashCode4 = (i7 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.pivotResult;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z5 = this.needSentenceSplit;
        return hashCode5 + (z5 ? 1 : z5 ? 1 : 0);
    }

    public String toString() {
        return "TranslationTask(sourceLanguageCode=" + this.sourceLanguageCode + ", targetLanguageCode=" + this.targetLanguageCode + ", sourceText=" + this.sourceText + ", targetText=" + this.targetText + ", id=" + this.id + ", errorCode=" + this.errorCode + ", throwable=" + this.throwable + ", verbose=" + this.verbose + ", appendMeta=" + this.appendMeta + ", mode=" + this.mode + ", forcePivot=" + this.forcePivot + ", formality=" + this.formality + ", packageName=" + this.packageName + ", pivotResult=" + this.pivotResult + ", needSentenceSplit=" + this.needSentenceSplit + ")";
    }

    public TranslationTask(String sourceLanguageCode, String targetLanguageCode, String sourceText, String targetText, String id, TranslationErrorCode errorCode, Throwable th, boolean z, boolean z2, String mode, boolean z3, boolean z4, String str, String str2, boolean z5) {
        Intrinsics.checkNotNullParameter(sourceLanguageCode, "sourceLanguageCode");
        Intrinsics.checkNotNullParameter(targetLanguageCode, "targetLanguageCode");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.sourceLanguageCode = sourceLanguageCode;
        this.targetLanguageCode = targetLanguageCode;
        this.sourceText = sourceText;
        this.targetText = targetText;
        this.id = id;
        this.errorCode = errorCode;
        this.throwable = th;
        this.verbose = z;
        this.appendMeta = z2;
        this.mode = mode;
        this.forcePivot = z3;
        this.formality = z4;
        this.packageName = str;
        this.pivotResult = str2;
        this.needSentenceSplit = z5;
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

    public final String getTargetText() {
        return this.targetText;
    }

    public final void setTargetText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.targetText = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public /* synthetic */ TranslationTask(String str, String str2, String str3, String str4, String str5, TranslationErrorCode translationErrorCode, Throwable th, boolean z, boolean z2, String str6, boolean z3, boolean z4, String str7, String str8, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? JsonProperty.USE_DEFAULT_NAME : str, str2, (i & 4) != 0 ? JsonProperty.USE_DEFAULT_NAME : str3, (i & 8) != 0 ? JsonProperty.USE_DEFAULT_NAME : str4, (i & 16) != 0 ? JsonProperty.USE_DEFAULT_NAME : str5, (i & 32) != 0 ? TranslationErrorCode.NONE : translationErrorCode, (i & 64) != 0 ? null : th, (i & 128) != 0 ? false : z, (i & 256) != 0 ? false : z2, (i & 512) != 0 ? "plain" : str6, (i & 1024) != 0 ? false : z3, (i & 2048) != 0 ? false : z4, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : str8, (i & 16384) != 0 ? true : z5);
    }

    public final TranslationErrorCode getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(TranslationErrorCode translationErrorCode) {
        Intrinsics.checkNotNullParameter(translationErrorCode, "<set-?>");
        this.errorCode = translationErrorCode;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final void setThrowable(Throwable th) {
        this.throwable = th;
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

    public final String getPivotResult() {
        return this.pivotResult;
    }

    public final void setPivotResult(String str) {
        this.pivotResult = str;
    }

    public final boolean getNeedSentenceSplit() {
        return this.needSentenceSplit;
    }
}
