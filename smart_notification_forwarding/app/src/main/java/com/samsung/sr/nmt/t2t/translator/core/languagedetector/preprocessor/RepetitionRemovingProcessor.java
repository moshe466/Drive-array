package com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* compiled from: RepetitionRemovingProcessor.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/RepetitionRemovingProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/DetectionPreProcessor;", "()V", "process", JsonProperty.USE_DEFAULT_NAME, "text", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RepetitionRemovingProcessor implements DetectionPreProcessor {
    private static final Regex WORD_REGEX = new Regex("\\s+");

    @Inject
    public RepetitionRemovingProcessor() {
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.DetectionPreProcessor
    public String process(String text) {
        Set keySet;
        List list;
        String str;
        Intrinsics.checkNotNullParameter(text, "text");
        List<String> split = WORD_REGEX.split(text, 0);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : split) {
            String str2 = (String) obj;
            Object obj2 = linkedHashMap.get(str2);
            if (obj2 == null) {
                obj2 = (List) new ArrayList();
                linkedHashMap.put(str2, obj2);
            }
            ((List) obj2).add(obj);
        }
        if (!(linkedHashMap.size() == 1)) {
            linkedHashMap = null;
        }
        return (linkedHashMap == null || (keySet = linkedHashMap.keySet()) == null || (list = CollectionsKt.toList(keySet)) == null || (str = (String) CollectionsKt.first(list)) == null) ? text : str;
    }
}
