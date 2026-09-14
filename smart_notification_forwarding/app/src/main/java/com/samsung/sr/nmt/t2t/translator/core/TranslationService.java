package com.samsung.sr.nmt.t2t.translator.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.NotAvailableDirectionException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TaskResultHandler;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirectionState;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: TranslationService.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u000f\u001a\u00020\tH&J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0011\u001a\u00020\tH&J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&¨\u0006\u001e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/TranslationService;", JsonProperty.USE_DEFAULT_NAME, "clear", JsonProperty.USE_DEFAULT_NAME, "getLanguageDirectionStateMap", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirectionState;", "getResourcePackPackageName", JsonProperty.USE_DEFAULT_NAME, "sourceLanguageCode", "targetLanguageCode", "getSourceLanguageList", JsonProperty.USE_DEFAULT_NAME, "getSourceLanguageListWithTargetLanguage", "targetLanguage", "getTargetLanguageList", "sourceLanguage", "isAvailableDirection", JsonProperty.USE_DEFAULT_NAME, "isTaggedTranslationSupported", "refresh", "translate", "task", "Lcom/samsung/sr/nmt/t2t/translator/core/TranslatorInput;", "resultHandler", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TaskResultHandler;", "updateTranslatorSpec", "translatorSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorSpec;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface TranslationService {
    void clear();

    Map<LanguageDirection, LanguageDirectionState> getLanguageDirectionStateMap();

    String getResourcePackPackageName(String sourceLanguageCode, String targetLanguageCode);

    List<String> getSourceLanguageList();

    List<String> getSourceLanguageListWithTargetLanguage(String targetLanguage);

    List<String> getTargetLanguageList(String sourceLanguage);

    boolean isAvailableDirection(String sourceLanguageCode, String targetLanguageCode);

    boolean isTaggedTranslationSupported(String sourceLanguageCode, String targetLanguageCode);

    void refresh();

    void translate(TranslatorInput task, TaskResultHandler resultHandler) throws NotAvailableDirectionException;

    void updateTranslatorSpec(TranslatorSpec translatorSpec);
}
