package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.spec.PlaceholderSpec;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.List;
import kotlin.Metadata;

/* compiled from: Engine.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u0007H&JH\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00112\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001a"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/Engine;", JsonProperty.USE_DEFAULT_NAME, "languageDirection", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "getLanguageDirection", "()Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "clear", JsonProperty.USE_DEFAULT_NAME, "getPlaceholderSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/spec/PlaceholderSpec;", "getTransformerSpec", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/TransformerSpec;", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "isReusable", "load", "translate", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/EngineTranslationResult;", "inputTextList", JsonProperty.USE_DEFAULT_NAME, "formalityList", "taskIdList", "verbose", "batchSize", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public interface Engine {
    void clear();

    LanguageDirection getLanguageDirection();

    PlaceholderSpec getPlaceholderSpec();

    TransformerSpec getTransformerSpec();

    boolean isLoaded();

    boolean isReusable();

    void load();

    List<EngineTranslationResult> translate(List<String> inputTextList, List<Boolean> formalityList, List<String> taskIdList, boolean verbose, int batchSize);
}
