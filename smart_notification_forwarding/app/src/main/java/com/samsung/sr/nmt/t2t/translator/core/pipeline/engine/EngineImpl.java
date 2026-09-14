package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.exception.EngineInterruptedException;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model.Model;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.PlaceholderSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.Vocab;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.DirectionToken;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.HonorificToken;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import com.samsung.sr.nmt.t2t.translator.core.utils.LoggerFactory;
import com.samsung.sr.nmt.t2t.translator.core.utils.SimpleLogger;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EngineImpl.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001:B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u000eH\u0016J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0016J\b\u0010'\u001a\u00020\u001eH\u0016JB\u0010(\u001a\u0002H)\"\u0006\b\u0000\u0010)\u0018\u00012\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u00020%2\f\u00100\u001a\b\u0012\u0004\u0012\u0002H)01H\u0082\b¢\u0006\u0002\u00102JH\u00103\u001a\b\u0012\u0004\u0012\u0002040-2\f\u00105\u001a\b\u0012\u0004\u0012\u00020.0-2\f\u00106\u001a\b\u0012\u0004\u0012\u00020%0-2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u00020%2\u0006\u00107\u001a\u000208H\u0016J\b\u00109\u001a\u00020\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineImpl;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/Engine;", "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "directionToken", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/DirectionToken;", "honorificToken", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/HonorificToken;", "model", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/model/Model;", "sourceVocab", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/Vocab;", "targetVocab", "transformerSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/TransformerSpec;", "(Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/DirectionToken;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/HonorificToken;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/model/Model;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/Vocab;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/Vocab;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/TransformerSpec;)V", "interrupted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInterrupted$translator_core", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "getLanguageDirection", "()Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "logger", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/SimpleLogger;", "translationState", "Ljava/util/concurrent/atomic/AtomicInteger;", "translationStateChangerLock", "clear", JsonProperty.USE_DEFAULT_NAME, "clearModel", "clearVocab", "getPlaceholderSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/PlaceholderSpec;", "getTransformerSpec", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "isReusable", "load", "runAtomicOperation", "T", "state", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineImpl$TranslationState;", "taskIdList", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "verbose", "command", "Lkotlin/Function0;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineImpl$TranslationState;Ljava/util/List;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "translate", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineTranslationResult;", "inputTextList", "formalityList", "batchSize", JsonProperty.USE_DEFAULT_NAME, "tryClearData", "TranslationState", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EngineImpl implements Engine {
    private final DirectionToken directionToken;
    private final HonorificToken honorificToken;
    private final AtomicBoolean interrupted;
    private final LanguageDirection languageDirection;
    private final ReentrantLock lock;
    private final SimpleLogger logger;
    private final Model model;
    private final Vocab sourceVocab;
    private final Vocab targetVocab;
    private final TransformerSpec transformerSpec;
    private final AtomicInteger translationState;
    private final ReentrantLock translationStateChangerLock;

    public EngineImpl(LanguageDirection languageDirection, DirectionToken directionToken, HonorificToken honorificToken, Model model, Vocab sourceVocab, Vocab targetVocab, TransformerSpec transformerSpec) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(directionToken, "directionToken");
        Intrinsics.checkNotNullParameter(honorificToken, "honorificToken");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(sourceVocab, "sourceVocab");
        Intrinsics.checkNotNullParameter(targetVocab, "targetVocab");
        Intrinsics.checkNotNullParameter(transformerSpec, "transformerSpec");
        this.languageDirection = languageDirection;
        this.directionToken = directionToken;
        this.honorificToken = honorificToken;
        this.model = model;
        this.sourceVocab = sourceVocab;
        this.targetVocab = targetVocab;
        this.transformerSpec = transformerSpec;
        this.logger = LoggerFactory.INSTANCE.getLogger(getClass());
        this.lock = new ReentrantLock();
        this.translationStateChangerLock = new ReentrantLock();
        this.interrupted = new AtomicBoolean(false);
        this.translationState = new AtomicInteger(TranslationState.FINISH.ordinal());
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.Engine
    public LanguageDirection getLanguageDirection() {
        return this.languageDirection;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: EngineImpl.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineImpl$TranslationState;", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;I)V", "START", "ENCODE", "MODEL", "DECODE", "FINISH", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    public static final class TranslationState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TranslationState[] $VALUES;
        public static final TranslationState START = new TranslationState("START", 0);
        public static final TranslationState ENCODE = new TranslationState("ENCODE", 1);
        public static final TranslationState MODEL = new TranslationState("MODEL", 2);
        public static final TranslationState DECODE = new TranslationState("DECODE", 3);
        public static final TranslationState FINISH = new TranslationState("FINISH", 4);

        private static final /* synthetic */ TranslationState[] $values() {
            return new TranslationState[]{START, ENCODE, MODEL, DECODE, FINISH};
        }

        public static EnumEntries<TranslationState> getEntries() {
            return $ENTRIES;
        }

        public static TranslationState valueOf(String str) {
            return (TranslationState) Enum.valueOf(TranslationState.class, str);
        }

        public static TranslationState[] values() {
            return (TranslationState[]) $VALUES.clone();
        }

        private TranslationState(String str, int i) {
        }

        static {
            TranslationState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* renamed from: getInterrupted$translator_core, reason: from getter */
    public final AtomicBoolean getInterrupted() {
        return this.interrupted;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.Engine
    public void load() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            if (this.interrupted.get()) {
                throw new EngineInterruptedException(null, 1, null);
            }
            this.model.load();
            this.sourceVocab.load();
            this.targetVocab.load();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x042e A[Catch: all -> 0x045d, TryCatch #6 {all -> 0x045d, blocks: (B:55:0x041b, B:57:0x042e, B:59:0x0435, B:60:0x043b, B:61:0x0451, B:63:0x0452), top: B:54:0x041b, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0452 A[Catch: all -> 0x045d, TRY_LEAVE, TryCatch #6 {all -> 0x045d, blocks: (B:55:0x041b, B:57:0x042e, B:59:0x0435, B:60:0x043b, B:61:0x0451, B:63:0x0452), top: B:54:0x041b, outer: #2 }] */
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.Engine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineTranslationResult> translate(java.util.List<java.lang.String> r26, java.util.List<java.lang.Boolean> r27, java.util.List<java.lang.String> r28, boolean r29, int r30) {
        /*
            Method dump skipped, instructions count: 1127
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineImpl.translate(java.util.List, java.util.List, java.util.List, boolean, int):java.util.List");
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.Engine
    public boolean isLoaded() {
        return this.model.isLoaded() && this.sourceVocab.isLoaded() && this.targetVocab.isLoaded();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.Engine
    public boolean isReusable() {
        return !this.interrupted.get();
    }

    private final void tryClearData() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int i = this.translationState.get();
            if (i == TranslationState.FINISH.ordinal()) {
                clearVocab();
                clearModel();
            } else if (i == TranslationState.MODEL.ordinal()) {
                clearModel();
                this.interrupted.set(true);
            } else {
                this.interrupted.set(true);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        throw r1;
     */
    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.Engine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void clear() {
        /*
            r4 = this;
            r4.tryClearData()
            java.util.concurrent.locks.ReentrantLock r0 = r4.translationStateChangerLock
            java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
            r0.lock()
            java.util.concurrent.locks.ReentrantLock r1 = r4.lock     // Catch: java.lang.Throwable -> L3d
            java.util.concurrent.locks.Lock r1 = (java.util.concurrent.locks.Lock) r1     // Catch: java.lang.Throwable -> L3d
            r1.lock()     // Catch: java.lang.Throwable -> L3d
            java.util.concurrent.atomic.AtomicInteger r2 = r4.translationState     // Catch: java.lang.Throwable -> L38
            int r2 = r2.get()     // Catch: java.lang.Throwable -> L38
            com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineImpl$TranslationState r3 = com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineImpl.TranslationState.FINISH     // Catch: java.lang.Throwable -> L38
            int r3 = r3.ordinal()     // Catch: java.lang.Throwable -> L38
            if (r2 == r3) goto L2d
            java.util.concurrent.atomic.AtomicInteger r2 = r4.translationState     // Catch: java.lang.Throwable -> L38
            com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineImpl$TranslationState r3 = com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineImpl.TranslationState.FINISH     // Catch: java.lang.Throwable -> L38
            int r3 = r3.ordinal()     // Catch: java.lang.Throwable -> L38
            r2.set(r3)     // Catch: java.lang.Throwable -> L38
            r4.tryClearData()     // Catch: java.lang.Throwable -> L38
        L2d:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L38
            r1.unlock()     // Catch: java.lang.Throwable -> L3d
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L3d
            r0.unlock()
            return
        L38:
            r2 = move-exception
            r1.unlock()     // Catch: java.lang.Throwable -> L3d
            throw r2     // Catch: java.lang.Throwable -> L3d
        L3d:
            r1 = move-exception
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.EngineImpl.clear():void");
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.Engine
    public PlaceholderSpec getPlaceholderSpec() {
        return this.sourceVocab.getPlaceholderSpec();
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.Engine
    public TransformerSpec getTransformerSpec() {
        return this.transformerSpec;
    }

    private final /* synthetic */ <T> T runAtomicOperation(TranslationState state, List<String> taskIdList, boolean verbose, Function0<? extends T> command) {
        if (this.interrupted.get()) {
            throw new EngineInterruptedException("Engine interrupted | " + state);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.translationState.set(state.ordinal());
        T invoke = command.invoke();
        if (verbose) {
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            this.logger.debug("(SR Translation Engine) " + state + " results of " + taskIdList + ":");
            this.logger.debug("(SR Translation Engine) " + state + " | Thread | " + Thread.currentThread().getName() + " | Cost | " + currentTimeMillis2 + "ms");
        }
        return invoke;
    }

    private final void clearVocab() {
        this.sourceVocab.clear();
        this.targetVocab.clear();
    }

    private final void clearModel() {
        this.model.clear();
    }
}
