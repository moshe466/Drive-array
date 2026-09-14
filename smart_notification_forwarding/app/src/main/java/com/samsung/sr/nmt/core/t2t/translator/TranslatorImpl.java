package com.samsung.sr.nmt.core.t2t.translator;

import android.os.Handler;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.core.t2t.translator.languagedetector.DetectionCandidate;
import com.samsung.sr.nmt.core.t2t.translator.pipeline.TranslationTask;
import com.samsung.sr.nmt.core.t2t.translator.pipeline.engine.NotAvailableDirectionException;
import com.samsung.sr.nmt.t2t.translator.core.LanguageDetectionService;
import com.samsung.sr.nmt.t2t.translator.core.SegmentationService;
import com.samsung.sr.nmt.t2t.translator.core.TranslationService;
import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TaskResultHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationException;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslatorImpl.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 <2\u00020\u0001:\u0002;<B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u000fR\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\rH\u0017J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0016H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u001dH\u0016J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\u0006\u0010!\u001a\u00020\nH\u0016J.\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u001d2\u0006\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0014J8\u0010*\u001a\u00020\n2\u0006\u0010$\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020(2\u0006\u0010'\u001a\u00020(2\u0006\u0010-\u001a\u00020.2\u0006\u0010)\u001a\u00020(H\u0014J\u0018\u0010/\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u00100\u001a\u00020(2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\b\u00101\u001a\u00020\rH\u0016J\u0018\u00102\u001a\u00020\r2\u0006\u00103\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001e\u00105\u001a\b\u0012\u0004\u0012\u00020\n0\u001d2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0016J\u0018\u00108\u001a\u00020\r2\u0006\u00103\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u00109\u001a\u00020\r2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorImpl;", "Lcom/samsung/sr/nmt/core/t2t/translator/Translator;", "translationService", "Lcom/samsung/sr/nmt/t2t/translator/core/TranslationService;", "languageDetectionService", "Lcom/samsung/sr/nmt/t2t/translator/core/LanguageDetectionService;", "segmentationService", "Lcom/samsung/sr/nmt/t2t/translator/core/SegmentationService;", "(Lcom/samsung/sr/nmt/t2t/translator/core/TranslationService;Lcom/samsung/sr/nmt/t2t/translator/core/LanguageDetectionService;Lcom/samsung/sr/nmt/t2t/translator/core/SegmentationService;)V", "adaptLanguageCode", JsonProperty.USE_DEFAULT_NAME, "languageCode", "clear", JsonProperty.USE_DEFAULT_NAME, "createTaskResultHandler", "Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorImpl$AndroidTaskResultHandler;", "translationTask", "Lcom/samsung/sr/nmt/core/t2t/translator/pipeline/TranslationTask;", "handler", "Landroid/os/Handler;", "dispose", "getLanguageDirectionStateMap", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/core/t2t/translator/utils/LanguageDirection;", "Lcom/samsung/sr/nmt/core/t2t/translator/LanguageDirectionState;", "getResourcePackPackageName", "sourceLanguageCode", "targetLanguageCode", "getSourceLanguageList", JsonProperty.USE_DEFAULT_NAME, "getSourceLanguageListWithTargetLanguage", "targetLanguage", "getTargetLanguageList", "sourceLanguage", "identifyLanguageAndGetCandidatesDefault", "Lcom/samsung/sr/nmt/core/t2t/translator/languagedetector/DetectionCandidate;", "text", "maxCandidate", JsonProperty.USE_DEFAULT_NAME, "differentiate", JsonProperty.USE_DEFAULT_NAME, "verbose", "identifyLanguageInner", "fallbackLanguage", "filterSupportedLanguage", "threshold", JsonProperty.USE_DEFAULT_NAME, "isAvailableDirection", "isTaggedTranslationSupported", "refresh", "rejectTask", "task", "Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorInput;", "segment", "sentence", "language", "translate", "updateTranslatorSpec", "languageDirections", "AndroidTaskResultHandler", "Companion", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TranslatorImpl extends Translator {
    public static final int TRANSLATION_FAILURE = -1;
    public static final int TRANSLATION_SUCCESS = 0;
    private final LanguageDetectionService languageDetectionService;
    private final SegmentationService segmentationService;
    private final TranslationService translationService;

    public TranslatorImpl(TranslationService translationService, LanguageDetectionService languageDetectionService, SegmentationService segmentationService) {
        Intrinsics.checkNotNullParameter(translationService, "translationService");
        Intrinsics.checkNotNullParameter(languageDetectionService, "languageDetectionService");
        Intrinsics.checkNotNullParameter(segmentationService, "segmentationService");
        this.translationService = translationService;
        this.languageDetectionService = languageDetectionService;
        this.segmentationService = segmentationService;
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    public void translate(TranslatorInput task, Handler handler) throws NotAvailableDirectionException {
        String sourceLanguageCode;
        TranslatorInput copy;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (task.getSourceLanguageCode().length() == 0) {
            sourceLanguageCode = Translator.identifyLanguage$default(this, task.getSourceText(), task.getFallbackLanguage(), true, false, task.getThreshold(), task.getVerbose(), 8, null);
        } else {
            sourceLanguageCode = task.getSourceLanguageCode();
        }
        String str = sourceLanguageCode;
        copy = task.copy((r28 & 1) != 0 ? task.sourceLanguageCode : adaptLanguageCode(str), (r28 & 2) != 0 ? task.targetLanguageCode : adaptLanguageCode(task.getTargetLanguageCode()), (r28 & 4) != 0 ? task.sourceText : null, (r28 & 8) != 0 ? task.id : null, (r28 & 16) != 0 ? task.threshold : 0.0f, (r28 & 32) != 0 ? task.fallbackLanguage : null, (r28 & 64) != 0 ? task.verbose : false, (r28 & 128) != 0 ? task.appendMeta : false, (r28 & 256) != 0 ? task.mode : null, (r28 & 512) != 0 ? task.forcePivot : false, (r28 & 1024) != 0 ? task.formality : false, (r28 & 2048) != 0 ? task.packageName : null, (r28 & 4096) != 0 ? task.needSentenceSplit : false);
        try {
            this.translationService.translate(TranslatorCoreAdaptor.INSTANCE.toCoreTranslatorInput(copy), createTaskResultHandler(copy.toTask(), handler));
        } catch (com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.NotAvailableDirectionException e) {
            if (Intrinsics.areEqual(str, "<neutral>") || Intrinsics.areEqual(str, task.getTargetLanguageCode())) {
                rejectTask(task, handler);
                return;
            }
            throw new NotAvailableDirectionException(e);
        }
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    protected String identifyLanguageInner(String text, String fallbackLanguage, boolean filterSupportedLanguage, boolean differentiate, float threshold, boolean verbose) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(fallbackLanguage, "fallbackLanguage");
        String identifyLanguage = this.languageDetectionService.identifyLanguage(text, differentiate, threshold, fallbackLanguage, verbose);
        if (filterSupportedLanguage && identifyLanguage != null) {
            Map<LanguageDirection, com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirectionState> languageDirectionStateMap = this.translationService.getLanguageDirectionStateMap();
            ArrayList arrayList = new ArrayList(languageDirectionStateMap.size());
            Iterator<Map.Entry<LanguageDirection, com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirectionState>> it = languageDirectionStateMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getKey().getSrcLang());
            }
            Set mutableSet = CollectionsKt.toMutableSet(arrayList);
            if (mutableSet.contains("zhtw") || mutableSet.contains("zhhk")) {
                mutableSet.add("tc");
            }
            if (!mutableSet.contains(identifyLanguage)) {
                identifyLanguage = null;
            }
        }
        return identifyLanguage == null ? fallbackLanguage : identifyLanguage;
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    protected List<DetectionCandidate> identifyLanguageAndGetCandidatesDefault(String text, int maxCandidate, boolean differentiate, boolean verbose) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (!(maxCandidate > 0)) {
            throw new IllegalArgumentException("max candidate should be positive integer".toString());
        }
        List<com.samsung.sr.nmt.t2t.translator.core.languagedetector.DetectionCandidate> identifyLanguageAndGetCandidates = this.languageDetectionService.identifyLanguageAndGetCandidates(text, maxCandidate, differentiate, verbose);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(identifyLanguageAndGetCandidates, 10));
        Iterator<T> it = identifyLanguageAndGetCandidates.iterator();
        while (it.hasNext()) {
            arrayList.add(TranslatorCoreAdaptor.INSTANCE.fromCoreDetectionCandidate((com.samsung.sr.nmt.t2t.translator.core.languagedetector.DetectionCandidate) it.next()));
        }
        return arrayList;
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    public void clear() {
        this.translationService.clear();
        this.languageDetectionService.clear();
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    @Deprecated(message = "Currently, it doesn't have a specific role comparing to use method `clean`. It can be removed soon")
    public void dispose() {
        this.translationService.clear();
        this.languageDetectionService.clear();
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    public Map<com.samsung.sr.nmt.core.t2t.translator.utils.LanguageDirection, LanguageDirectionState> getLanguageDirectionStateMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<LanguageDirection, com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirectionState> entry : this.translationService.getLanguageDirectionStateMap().entrySet()) {
            linkedHashMap.put(TranslatorCoreAdaptor.INSTANCE.fromCoreLanguageDirection(entry.getKey()), TranslatorCoreAdaptor.INSTANCE.fromCoreLanguageDirectionState(entry.getValue()));
        }
        return linkedHashMap;
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    public List<String> getSourceLanguageList() {
        return this.translationService.getSourceLanguageList();
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    public List<String> getSourceLanguageListWithTargetLanguage(String targetLanguage) {
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return this.translationService.getSourceLanguageListWithTargetLanguage(targetLanguage);
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    public List<String> getTargetLanguageList(String sourceLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        return this.translationService.getTargetLanguageList(sourceLanguage);
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    public boolean isAvailableDirection(String sourceLanguageCode, String targetLanguageCode) {
        Intrinsics.checkNotNullParameter(sourceLanguageCode, "sourceLanguageCode");
        Intrinsics.checkNotNullParameter(targetLanguageCode, "targetLanguageCode");
        return this.translationService.isAvailableDirection(sourceLanguageCode, targetLanguageCode);
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    public void refresh() {
        this.translationService.refresh();
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    public String getResourcePackPackageName(String sourceLanguageCode, String targetLanguageCode) {
        Intrinsics.checkNotNullParameter(sourceLanguageCode, "sourceLanguageCode");
        Intrinsics.checkNotNullParameter(targetLanguageCode, "targetLanguageCode");
        return this.translationService.getResourcePackPackageName(sourceLanguageCode, targetLanguageCode);
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    public void updateTranslatorSpec(List<com.samsung.sr.nmt.core.t2t.translator.utils.LanguageDirection> languageDirections) {
        Intrinsics.checkNotNullParameter(languageDirections, "languageDirections");
        TranslationService translationService = this.translationService;
        List<com.samsung.sr.nmt.core.t2t.translator.utils.LanguageDirection> list = languageDirections;
        TranslatorCoreAdaptor translatorCoreAdaptor = TranslatorCoreAdaptor.INSTANCE;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(translatorCoreAdaptor.toCoreLanguageDirection((com.samsung.sr.nmt.core.t2t.translator.utils.LanguageDirection) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((com.samsung.sr.nmt.core.t2t.translator.utils.LanguageDirection) it2.next()).reversed());
        }
        ArrayList arrayList4 = arrayList3;
        TranslatorCoreAdaptor translatorCoreAdaptor2 = TranslatorCoreAdaptor.INSTANCE;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            arrayList5.add(translatorCoreAdaptor2.toCoreLanguageDirection((com.samsung.sr.nmt.core.t2t.translator.utils.LanguageDirection) it3.next()));
        }
        translationService.updateTranslatorSpec(new TranslatorSpec(JsonProperty.USE_DEFAULT_NAME, CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList5)));
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    public boolean isTaggedTranslationSupported(String sourceLanguageCode, String targetLanguageCode) {
        Intrinsics.checkNotNullParameter(sourceLanguageCode, "sourceLanguageCode");
        Intrinsics.checkNotNullParameter(targetLanguageCode, "targetLanguageCode");
        return this.translationService.isTaggedTranslationSupported(adaptLanguageCode(sourceLanguageCode), adaptLanguageCode(targetLanguageCode));
    }

    @Override // com.samsung.sr.nmt.core.t2t.translator.Translator
    public List<String> segment(String sentence, String language) {
        Intrinsics.checkNotNullParameter(sentence, "sentence");
        Intrinsics.checkNotNullParameter(language, "language");
        return this.segmentationService.segment(sentence, language);
    }

    private final AndroidTaskResultHandler createTaskResultHandler(TranslationTask translationTask, Handler handler) {
        return new AndroidTaskResultHandler(this, translationTask, handler);
    }

    private final void rejectTask(TranslatorInput task, Handler handler) {
        TranslationTask task2 = task.toTask();
        task2.setTargetText(task2.getSourceText());
        handler.sendMessage(handler.obtainMessage(0, task2));
    }

    private final String adaptLanguageCode(String languageCode) {
        if (!Intrinsics.areEqual(languageCode, "tc")) {
            return languageCode;
        }
        String str = "zhtw";
        if (!isAvailableDirection("en", "zhtw")) {
            str = "zhhk";
            if (!isAvailableDirection("en", "zhhk")) {
                return languageCode;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TranslatorImpl.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorImpl$AndroidTaskResultHandler;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TaskResultHandler;", "originalTask", "Lcom/samsung/sr/nmt/core/t2t/translator/pipeline/TranslationTask;", "handler", "Landroid/os/Handler;", "(Lcom/samsung/sr/nmt/core/t2t/translator/TranslatorImpl;Lcom/samsung/sr/nmt/core/t2t/translator/pipeline/TranslationTask;Landroid/os/Handler;)V", "onFailure", JsonProperty.USE_DEFAULT_NAME, "exception", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationException;", "onSuccess", "task", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TranslationTask;", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public final class AndroidTaskResultHandler implements TaskResultHandler {
        private final Handler handler;
        private final TranslationTask originalTask;
        final /* synthetic */ TranslatorImpl this$0;

        public AndroidTaskResultHandler(TranslatorImpl this$0, TranslationTask originalTask, Handler handler) {
            Intrinsics.checkNotNullParameter(originalTask, "originalTask");
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.this$0 = this$0;
            this.originalTask = originalTask;
            this.handler = handler;
        }

        @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TaskResultHandler
        public void onFailure(TranslationException exception) {
            TranslationTask copy;
            Intrinsics.checkNotNullParameter(exception, "exception");
            Handler handler = this.handler;
            copy = r3.copy((r26 & 1) != 0 ? r3.sourceLanguageCode : null, (r26 & 2) != 0 ? r3.targetLanguageCode : null, (r26 & 4) != 0 ? r3.sourceText : null, (r26 & 8) != 0 ? r3.targetText : JsonProperty.USE_DEFAULT_NAME, (r26 & 16) != 0 ? r3.id : null, (r26 & 32) != 0 ? r3.errorCode : TranslatorCoreAdaptor.INSTANCE.fromCoreErrorCode(exception.getErrorCode()), (r26 & 64) != 0 ? r3.throwable : exception.getThrowable(), (r26 & 128) != 0 ? r3.verbose : false, (r26 & 256) != 0 ? r3.appendMeta : false, (r26 & 512) != 0 ? r3.forcePivot : false, (r26 & 1024) != 0 ? r3.formality : false, (r26 & 2048) != 0 ? this.originalTask.pivotResult : null);
            this.handler.sendMessage(handler.obtainMessage(-1, copy));
        }

        @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TaskResultHandler
        public void onSuccess(com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TranslationTask task) {
            Intrinsics.checkNotNullParameter(task, "task");
            this.handler.sendMessage(this.handler.obtainMessage(0, TranslatorCoreAdaptor.INSTANCE.fromCoreTranslationTask(task)));
        }
    }
}
