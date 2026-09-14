package com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: TagRemovingProcessor.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/TagRemovingProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/DetectionPreProcessor;", "()V", "process", JsonProperty.USE_DEFAULT_NAME, "text", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TagRemovingProcessor implements DetectionPreProcessor {
    private static final Regex OPEN_TAG_REGEX = new Regex("<[^\\s/][^>]+>");
    private static final Regex CLOSE_TAG_REGEX = new Regex("</[^>]+>");

    @Inject
    public TagRemovingProcessor() {
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.DetectionPreProcessor
    public String process(String text) {
        MatchResult find$default;
        Intrinsics.checkNotNullParameter(text, "text");
        boolean z = true;
        List<Regex> listOf = CollectionsKt.listOf((Object[]) new Regex[]{OPEN_TAG_REGEX, CLOSE_TAG_REGEX});
        List list = listOf;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (!(Regex.find$default((Regex) it.next(), text, 0, 2, null) != null)) {
                    z = false;
                    break;
                }
            }
        }
        if (!z) {
            listOf = null;
        }
        if (listOf != null) {
            for (Regex regex : listOf) {
                do {
                    String str = text;
                    find$default = Regex.find$default(regex, str, 0, 2, null);
                    if (find$default != null) {
                        text = StringsKt.replaceRange((CharSequence) str, find$default.getRange(), (CharSequence) JsonProperty.USE_DEFAULT_NAME).toString();
                    } else {
                        find$default = null;
                    }
                } while (find$default != null);
            }
        }
        return text;
    }
}
