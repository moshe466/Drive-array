package com.samsung.sr.nmt.t2t.translator.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.dataclass.TranslatorSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.Pipeline;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineProvider;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.LanguageDirectionManager;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.NotAvailableDirectionException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.ProcessingTask;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TaskResultHandler;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.translationmemory.TranslationMemory;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirectionState;
import com.samsung.sr.nmt.t2t.translator.core.utils.LoggerFactory;
import com.samsung.sr.nmt.t2t.translator.core.utils.SimpleLogger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TranslationServiceImpl.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u001aH\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a2\u0006\u0010\u001e\u001a\u00020\u0016H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010!\u001a\u00020 2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\u0018\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/TranslationServiceImpl;", "Lcom/samsung/sr/nmt/t2t/translator/core/TranslationService;", "engineProvider", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineProvider;", "pipeline", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/Pipeline;", "languageDirectionManager", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/LanguageDirectionManager;", "translationMemory", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/TranslationMemory;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineProvider;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/Pipeline;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/LanguageDirectionManager;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/translationmemory/TranslationMemory;)V", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "logger", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/SimpleLogger;", "clear", JsonProperty.USE_DEFAULT_NAME, "getLanguageDirectionStateMap", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirectionState;", "getResourcePackPackageName", JsonProperty.USE_DEFAULT_NAME, "sourceLanguageCode", "targetLanguageCode", "getSourceLanguageList", JsonProperty.USE_DEFAULT_NAME, "getSourceLanguageListWithTargetLanguage", "targetLanguage", "getTargetLanguageList", "sourceLanguage", "isAvailableDirection", JsonProperty.USE_DEFAULT_NAME, "isTaggedTranslationSupported", "refresh", "translate", "task", "Lcom/samsung/sr/nmt/t2t/translator/core/TranslatorInput;", "resultHandler", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TaskResultHandler;", "updateTranslatorSpec", "translatorSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/dataclass/TranslatorSpec;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TranslationServiceImpl implements TranslationService {
    private final EngineProvider engineProvider;
    private final LanguageDirectionManager languageDirectionManager;
    private final ReentrantLock lock;
    private final SimpleLogger logger;
    private final Pipeline pipeline;
    private final TranslationMemory translationMemory;

    @Inject
    public TranslationServiceImpl(EngineProvider engineProvider, Pipeline pipeline, LanguageDirectionManager languageDirectionManager, TranslationMemory translationMemory) {
        Intrinsics.checkNotNullParameter(engineProvider, "engineProvider");
        Intrinsics.checkNotNullParameter(pipeline, "pipeline");
        Intrinsics.checkNotNullParameter(languageDirectionManager, "languageDirectionManager");
        Intrinsics.checkNotNullParameter(translationMemory, "translationMemory");
        this.engineProvider = engineProvider;
        this.pipeline = pipeline;
        this.languageDirectionManager = languageDirectionManager;
        this.translationMemory = translationMemory;
        this.logger = LoggerFactory.INSTANCE.getLogger(getClass());
        this.lock = new ReentrantLock();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.TranslationService
    public void translate(TranslatorInput task, TaskResultHandler resultHandler) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(resultHandler, "resultHandler");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.logger.debug("[Received Translation Task]  - / " + task.getSourceLanguageCode() + " / " + task.getTargetLanguageCode());
            ProcessingTask processingTask = new ProcessingTask(task.toTask(), resultHandler, null, null, 12, null);
            if (!this.languageDirectionManager.isAvailableDirection(task.getSourceLanguageCode(), task.getTargetLanguageCode())) {
                throw new NotAvailableDirectionException("Invalid Language Direction " + task.getSourceLanguageCode() + " => " + task.getTargetLanguageCode());
            }
            this.pipeline.submit(processingTask);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.TranslationService
    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.logger.debug("[Clearing] TranslationServiceImpl start");
            this.translationMemory.clearAll();
            this.languageDirectionManager.clear();
            this.pipeline.clear();
            this.engineProvider.clear();
            this.logger.debug("[Clearing] TranslationServiceImpl done");
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.TranslationService
    public Map<LanguageDirection, LanguageDirectionState> getLanguageDirectionStateMap() {
        return this.languageDirectionManager.getLanguageDirectionStateMap();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.TranslationService
    public List<String> getSourceLanguageList() {
        return this.languageDirectionManager.getAvailableSourceLanguageList();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.TranslationService
    public List<String> getSourceLanguageListWithTargetLanguage(String targetLanguage) {
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        return this.languageDirectionManager.getAvailableSourceLanguageListWithTargetLanguage(targetLanguage);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.TranslationService
    public List<String> getTargetLanguageList(String sourceLanguage) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        return this.languageDirectionManager.getAvailableTargetLanguageList(sourceLanguage);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.TranslationService
    public boolean isAvailableDirection(String sourceLanguageCode, String targetLanguageCode) {
        Intrinsics.checkNotNullParameter(sourceLanguageCode, "sourceLanguageCode");
        Intrinsics.checkNotNullParameter(targetLanguageCode, "targetLanguageCode");
        return this.languageDirectionManager.isAvailableDirection(sourceLanguageCode, targetLanguageCode);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.TranslationService
    public void refresh() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.languageDirectionManager.refresh();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.TranslationService
    public String getResourcePackPackageName(String sourceLanguageCode, String targetLanguageCode) {
        Intrinsics.checkNotNullParameter(sourceLanguageCode, "sourceLanguageCode");
        Intrinsics.checkNotNullParameter(targetLanguageCode, "targetLanguageCode");
        return this.languageDirectionManager.getResourcePackPackageName(sourceLanguageCode, targetLanguageCode);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.TranslationService
    public void updateTranslatorSpec(TranslatorSpec translatorSpec) {
        Intrinsics.checkNotNullParameter(translatorSpec, "translatorSpec");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            this.languageDirectionManager.updateTranslatorSpec(translatorSpec);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.TranslationService
    public boolean isTaggedTranslationSupported(String sourceLanguageCode, String targetLanguageCode) {
        boolean z;
        Intrinsics.checkNotNullParameter(sourceLanguageCode, "sourceLanguageCode");
        Intrinsics.checkNotNullParameter(targetLanguageCode, "targetLanguageCode");
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.languageDirectionManager.isAvailableDirection(sourceLanguageCode, targetLanguageCode)) {
                if (this.languageDirectionManager.isTaggedTranslationSupported(sourceLanguageCode, targetLanguageCode)) {
                    z = true;
                    return z;
                }
            }
            z = false;
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }
}
