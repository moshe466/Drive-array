package com.samsung.sr.nmt.t2t.translator.core.pipeline.spec;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.CaserProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.EsMxDollarsFixProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.FormattingRestoreProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.FormattingStoreProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.NormalizeProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.RecaserProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SentenceJoinerProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SentenceSplitterProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SwearWordReplacerProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.SymbolSentenceRejectionProcessor;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TMProcessor;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Provider;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnSpec.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B*\b\u0007\u0012!\u0010\u0002\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0002\b\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR)\u0010\u0002\u001a\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/EnSpec;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/spec/LanguageSpec;", "processorMap", JsonProperty.USE_DEFAULT_NAME, "Ljava/lang/Class;", "Ljavax/inject/Provider;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Map;)V", "postProcessorList", JsonProperty.USE_DEFAULT_NAME, "getPostProcessorList", "()Ljava/util/List;", "preProcessorList", "getPreProcessorList", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class EnSpec implements LanguageSpec {
    private final Map<Class<?>, Provider<Processor>> processorMap;

    @Inject
    public EnSpec(Map<Class<?>, Provider<Processor>> processorMap) {
        Intrinsics.checkNotNullParameter(processorMap, "processorMap");
        this.processorMap = processorMap;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.LanguageSpec
    public List<Processor> getPreProcessorList() {
        Processor[] processorArr = new Processor[9];
        Provider<Processor> provider = this.processorMap.get(NormalizeProcessor.class);
        Processor processor = provider != null ? provider.get() : null;
        if (processor == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[0] = processor;
        Provider<Processor> provider2 = this.processorMap.get(FormattingStoreProcessor.class);
        Processor processor2 = provider2 != null ? provider2.get() : null;
        if (processor2 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[1] = processor2;
        Provider<Processor> provider3 = this.processorMap.get(TMProcessor.class);
        Processor processor3 = provider3 != null ? provider3.get() : null;
        if (processor3 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[2] = processor3;
        Provider<Processor> provider4 = this.processorMap.get(SymbolSentenceRejectionProcessor.class);
        Processor processor4 = provider4 != null ? provider4.get() : null;
        if (processor4 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[3] = processor4;
        Provider<Processor> provider5 = this.processorMap.get(SentenceSplitterProcessor.class);
        Processor processor5 = provider5 != null ? provider5.get() : null;
        if (processor5 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[4] = processor5;
        Provider<Processor> provider6 = this.processorMap.get(FormattingStoreProcessor.class);
        Processor processor6 = provider6 != null ? provider6.get() : null;
        if (processor6 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[5] = processor6;
        Provider<Processor> provider7 = this.processorMap.get(TMProcessor.class);
        Processor processor7 = provider7 != null ? provider7.get() : null;
        if (processor7 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[6] = processor7;
        Provider<Processor> provider8 = this.processorMap.get(SymbolSentenceRejectionProcessor.class);
        Processor processor8 = provider8 != null ? provider8.get() : null;
        if (processor8 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[7] = processor8;
        Provider<Processor> provider9 = this.processorMap.get(RecaserProcessor.class);
        Processor processor9 = provider9 != null ? provider9.get() : null;
        if (processor9 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[8] = processor9;
        return CollectionsKt.listOf((Object[]) processorArr);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.spec.LanguageSpec
    public List<Processor> getPostProcessorList() {
        Processor[] processorArr = new Processor[6];
        Provider<Processor> provider = this.processorMap.get(CaserProcessor.class);
        Processor processor = provider != null ? provider.get() : null;
        if (processor == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[0] = processor;
        Provider<Processor> provider2 = this.processorMap.get(SwearWordReplacerProcessor.class);
        Processor processor2 = provider2 != null ? provider2.get() : null;
        if (processor2 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[1] = processor2;
        Provider<Processor> provider3 = this.processorMap.get(FormattingRestoreProcessor.class);
        Processor processor3 = provider3 != null ? provider3.get() : null;
        if (processor3 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[2] = processor3;
        Provider<Processor> provider4 = this.processorMap.get(EsMxDollarsFixProcessor.class);
        Processor processor4 = provider4 != null ? provider4.get() : null;
        if (processor4 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[3] = processor4;
        Provider<Processor> provider5 = this.processorMap.get(SentenceJoinerProcessor.class);
        Processor processor5 = provider5 != null ? provider5.get() : null;
        if (processor5 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[4] = processor5;
        Provider<Processor> provider6 = this.processorMap.get(FormattingRestoreProcessor.class);
        Processor processor6 = provider6 != null ? provider6.get() : null;
        if (processor6 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        processorArr[5] = processor6;
        return CollectionsKt.listOf((Object[]) processorArr);
    }
}
