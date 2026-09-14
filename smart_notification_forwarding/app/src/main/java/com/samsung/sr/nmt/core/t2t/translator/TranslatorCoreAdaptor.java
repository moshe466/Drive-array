package com.samsung.sr.nmt.core.t2t.translator;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.languagedetector.DetectionCandidate;
import com.samsung.sr.nmt.core.t2t.translator.pipeline.TranslationTask;
import com.samsung.sr.nmt.core.t2t.translator.utils.LanguageDirection;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationErrorCode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslatorCoreAdaptor.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c¨\u0006\u001d"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorCoreAdaptor;", JsonProperty.USE_DEFAULT_NAME, "()V", "fromCoreDetectionCandidate", "Lcom/samsung/sr/nmt/core/t2t/translator/languagedetector/DetectionCandidate;", "coreDetectionCandidate", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/DetectionCandidate;", "fromCoreErrorCode", "Lcom/samsung/sr/nmt/core/t2t/translator/pipeline/TranslationErrorCode;", "coreErrorCode", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationErrorCode;", "fromCoreLanguageDirection", "Lcom/samsung/sr/nmt/core/t2t/translator/utils/LanguageDirection;", "coreLanguageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "fromCoreLanguageDirectionState", "Lcom/samsung/sr/nmt/core/t2t/translator/LanguageDirectionState;", "coreLanguageDirectionState", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirectionState;", "fromCoreTranslationTask", "Lcom/samsung/sr/nmt/core/t2t/translator/pipeline/TranslationTask;", "coreTranslationTask", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationTask;", "toCoreLanguageDirection", "languageDirection", "toCoreTranslatorInput", "Lcom/samsung/sr/nmt/t2t/translator/core/TranslatorInput;", "coreTranslatorInput", "Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorInput;", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TranslatorCoreAdaptor {
    public static final TranslatorCoreAdaptor INSTANCE = new TranslatorCoreAdaptor();

    /* compiled from: TranslatorCoreAdaptor.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TranslationErrorCode.values().length];
            try {
                iArr[TranslationErrorCode.COMPUTATION_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TranslationErrorCode.ILLEGAL_RESOURCE_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TranslationErrorCode.INTERRUPTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TranslationErrorCode.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TranslationErrorCode.RESOURCE_ACCESS_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[TranslationErrorCode.UNAUTHORIZED_RESOURCE_ERROR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TranslatorCoreAdaptor() {
    }

    public final LanguageDirection fromCoreLanguageDirection(com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection coreLanguageDirection) {
        Intrinsics.checkNotNullParameter(coreLanguageDirection, "coreLanguageDirection");
        return new LanguageDirection(coreLanguageDirection.getSrcLang(), coreLanguageDirection.getTgtLang());
    }

    public final com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection toCoreLanguageDirection(LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        return new com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection(languageDirection.getSrcLang(), languageDirection.getTgtLang());
    }

    public final LanguageDirectionState fromCoreLanguageDirectionState(com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirectionState coreLanguageDirectionState) {
        Intrinsics.checkNotNullParameter(coreLanguageDirectionState, "coreLanguageDirectionState");
        return LanguageDirectionState.valueOf(coreLanguageDirectionState.name());
    }

    public final com.samsung.sr.nmt.t2t.translator.core.TranslatorInput toCoreTranslatorInput(TranslatorInput coreTranslatorInput) {
        Intrinsics.checkNotNullParameter(coreTranslatorInput, "coreTranslatorInput");
        return new com.samsung.sr.nmt.t2t.translator.core.TranslatorInput(coreTranslatorInput.getSourceLanguageCode(), coreTranslatorInput.getTargetLanguageCode(), coreTranslatorInput.getSourceText(), coreTranslatorInput.getId(), coreTranslatorInput.getFallbackLanguage(), coreTranslatorInput.getVerbose(), coreTranslatorInput.getAppendMeta(), coreTranslatorInput.getMode(), coreTranslatorInput.getForcePivot(), coreTranslatorInput.getFormality(), coreTranslatorInput.getPackageName(), coreTranslatorInput.getNeedSentenceSplit());
    }

    public final DetectionCandidate fromCoreDetectionCandidate(com.samsung.sr.nmt.t2t.translator.core.languagedetector.DetectionCandidate coreDetectionCandidate) {
        Intrinsics.checkNotNullParameter(coreDetectionCandidate, "coreDetectionCandidate");
        return new DetectionCandidate(coreDetectionCandidate.getLanguageCode(), coreDetectionCandidate.getProbability());
    }

    public final TranslationTask fromCoreTranslationTask(com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationTask coreTranslationTask) {
        Intrinsics.checkNotNullParameter(coreTranslationTask, "coreTranslationTask");
        String sourceLanguageCode = coreTranslationTask.getSourceLanguageCode();
        String targetLanguageCode = coreTranslationTask.getTargetLanguageCode();
        boolean appendMeta = coreTranslationTask.getAppendMeta();
        boolean verbose = coreTranslationTask.getVerbose();
        String id = coreTranslationTask.getId();
        return new TranslationTask(sourceLanguageCode, targetLanguageCode, coreTranslationTask.getSourceText(), coreTranslationTask.getTargetText(), id, fromCoreErrorCode(coreTranslationTask.getErrorCode()), coreTranslationTask.getThrowable(), verbose, appendMeta, false, coreTranslationTask.getFormality(), coreTranslationTask.getPivotResult(), 512, null);
    }

    public final com.samsung.sr.nmt.core.t2t.translator.pipeline.TranslationErrorCode fromCoreErrorCode(TranslationErrorCode coreErrorCode) {
        Intrinsics.checkNotNullParameter(coreErrorCode, "coreErrorCode");
        switch (WhenMappings.$EnumSwitchMapping$0[coreErrorCode.ordinal()]) {
            case 1:
                return com.samsung.sr.nmt.core.t2t.translator.pipeline.TranslationErrorCode.COMPUTATION_ERROR;
            case 2:
                return com.samsung.sr.nmt.core.t2t.translator.pipeline.TranslationErrorCode.ILLEGAL_RESOURCE_ERROR;
            case 3:
                return com.samsung.sr.nmt.core.t2t.translator.pipeline.TranslationErrorCode.INTERRUPTED;
            case 4:
                return com.samsung.sr.nmt.core.t2t.translator.pipeline.TranslationErrorCode.NONE;
            case 5:
                return com.samsung.sr.nmt.core.t2t.translator.pipeline.TranslationErrorCode.RESOURCE_ACCESS_ERROR;
            case 6:
                return com.samsung.sr.nmt.core.t2t.translator.pipeline.TranslationErrorCode.UNAUTHORIZED_RESOURCE_ERROR;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
