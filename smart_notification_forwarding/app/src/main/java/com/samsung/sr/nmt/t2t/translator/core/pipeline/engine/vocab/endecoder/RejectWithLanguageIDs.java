package com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RejectWithLanguageIDs.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BI\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004H\u0014J\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/RejectWithLanguageIDs;", "T", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStepRejectable;", "languageIds", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "languageCodeNeeded", "threshold", JsonProperty.USE_DEFAULT_NAME, "resultWhenFailGenerator", "Lkotlin/Function1;", "nextVocabIDsConvertStep", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;", "(Ljava/util/List;Ljava/lang/String;FLkotlin/jvm/functions/Function1;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/engine/vocab/endecoder/VocabIDsConvertStep;)V", "isRejectable", JsonProperty.USE_DEFAULT_NAME, "ids", JsonProperty.USE_DEFAULT_NAME, "resultWhenFail", "previousResult", "(Ljava/lang/Object;)Ljava/lang/Object;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RejectWithLanguageIDs<T> extends VocabIDsConvertStepRejectable<T> {
    private final String languageCodeNeeded;
    private final List<String> languageIds;
    private final Function1<T, T> resultWhenFailGenerator;
    private final float threshold;

    public /* synthetic */ RejectWithLanguageIDs(List list, String str, float f, Function1 function1, VocabIDsConvertStep vocabIDsConvertStep, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, f, function1, (i & 16) != 0 ? null : vocabIDsConvertStep);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RejectWithLanguageIDs(List<String> languageIds, String languageCodeNeeded, float f, Function1<? super T, ? extends T> resultWhenFailGenerator, VocabIDsConvertStep<T> vocabIDsConvertStep) {
        super(vocabIDsConvertStep);
        Intrinsics.checkNotNullParameter(languageIds, "languageIds");
        Intrinsics.checkNotNullParameter(languageCodeNeeded, "languageCodeNeeded");
        Intrinsics.checkNotNullParameter(resultWhenFailGenerator, "resultWhenFailGenerator");
        this.languageIds = languageIds;
        this.languageCodeNeeded = languageCodeNeeded;
        this.threshold = f;
        this.resultWhenFailGenerator = resultWhenFailGenerator;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabIDsConvertStepRejectable
    protected boolean isRejectable(List<Integer> ids) {
        int i;
        Intrinsics.checkNotNullParameter(ids, "ids");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = ids.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            int intValue = ((Number) next).intValue();
            if ((intValue == 0 || intValue == 1 || intValue >= this.languageIds.size()) ? false : true) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = arrayList2;
        if ((arrayList3 instanceof Collection) && arrayList3.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it2 = arrayList3.iterator();
            i = 0;
            while (it2.hasNext()) {
                if (Intrinsics.areEqual(this.languageIds.get(((Number) it2.next()).intValue()), this.languageCodeNeeded) && (i = i + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return ((float) i) / ((float) arrayList2.size()) > this.threshold;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.engine.vocab.endecoder.VocabIDsConvertStepRejectable
    protected T resultWhenFail(T previousResult) {
        return this.resultWhenFailGenerator.invoke(previousResult);
    }
}
