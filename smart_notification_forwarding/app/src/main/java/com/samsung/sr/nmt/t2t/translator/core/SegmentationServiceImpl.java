package com.samsung.sr.nmt.t2t.translator.core;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitterManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: SegmentationServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/SegmentationServiceImpl;", "Lcom/samsung/sr/nmt/t2t/translator/core/SegmentationService;", "splitterManager", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitterManager;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitterManager;)V", "segment", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "sentence", "language", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SegmentationServiceImpl implements SegmentationService {
    private final SplitterManager splitterManager;

    @Inject
    public SegmentationServiceImpl(SplitterManager splitterManager) {
        Intrinsics.checkNotNullParameter(splitterManager, "splitterManager");
        this.splitterManager = splitterManager;
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [java.util.List, T] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.util.List, T] */
    @Override // com.samsung.sr.nmt.t2t.translator.core.SegmentationService
    public List<String> segment(String sentence, String language) {
        Intrinsics.checkNotNullParameter(sentence, "sentence");
        Intrinsics.checkNotNullParameter(language, "language");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CollectionsKt.listOf(sentence);
        for (SplitRule splitRule : SplitterManager.getSplitterList$default(this.splitterManager, language, false, 2, null)) {
            Iterable iterable = (Iterable) objectRef.element;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(splitRule.split((String) it.next()));
            }
            List flatten = CollectionsKt.flatten(arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(flatten, 10));
            Iterator it2 = flatten.iterator();
            while (it2.hasNext()) {
                arrayList2.add(StringsKt.trim((CharSequence) it2.next()).toString());
            }
            objectRef.element = arrayList2;
        }
        return (List) objectRef.element;
    }
}
