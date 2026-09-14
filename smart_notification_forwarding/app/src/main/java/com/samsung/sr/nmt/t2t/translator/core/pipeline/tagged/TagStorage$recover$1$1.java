package com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged;

import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TagStorage.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public /* synthetic */ class TagStorage$recover$1$1 extends FunctionReferenceImpl implements Function1<TagData, String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TagStorage$recover$1$1(Object obj) {
        super(1, obj, TagStorage.class, "recoverOpenTag", "recoverOpenTag(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagData;)Ljava/lang/String;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final String invoke(TagData tagData) {
        String recoverOpenTag;
        recoverOpenTag = ((TagStorage) this.receiver).recoverOpenTag(tagData);
        return recoverOpenTag;
    }
}
