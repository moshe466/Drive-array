package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.model.ModelFactory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.EngineSpec;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.VocabFactory;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.DirectionToken;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.HonorificToken;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EngineFactory.kt */
@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineFactory;", JsonProperty.USE_DEFAULT_NAME, "modelFactory", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/model/ModelFactory;", "vocabFactory", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/VocabFactory;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/model/ModelFactory;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/VocabFactory;)V", "createEngine", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/Engine;", "engineSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/EngineSpec;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EngineFactory {
    private final ModelFactory modelFactory;
    private final VocabFactory vocabFactory;

    @Inject
    public EngineFactory(ModelFactory modelFactory, VocabFactory vocabFactory) {
        Intrinsics.checkNotNullParameter(modelFactory, "modelFactory");
        Intrinsics.checkNotNullParameter(vocabFactory, "vocabFactory");
        this.modelFactory = modelFactory;
        this.vocabFactory = vocabFactory;
    }

    public final Engine createEngine(EngineSpec engineSpec) {
        Intrinsics.checkNotNullParameter(engineSpec, "engineSpec");
        return new EngineImpl(new LanguageDirection(engineSpec.getSourceLanguage(), engineSpec.getTargetLanguage()), new DirectionToken(engineSpec.getDirTokStr(), engineSpec.getDirTokId()), new HonorificToken(engineSpec.getHonorificTok(), engineSpec.getHonorificTokId()), this.modelFactory.create(engineSpec), this.vocabFactory.create(engineSpec.getSourceVocabPath(), engineSpec.getSourceAlphabetPath(), engineSpec, engineSpec.getVocabLanguageIdPath()), this.vocabFactory.create(engineSpec.getTargetVocabPath(), engineSpec.getTargetAlphabetPath(), engineSpec, engineSpec.getVocabLanguageIdPath()), new TransformerSpec(engineSpec.getLowerCase(), engineSpec.getProcessHonorificTag(), engineSpec.getHonorificTok()));
    }
}
