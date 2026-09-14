package com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* compiled from: ChineseDifferentiator.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/differentiator/ChineseDifferentiator;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/differentiator/LanguageDifferentiator;", "traditionalChineseCharacters", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "traditionalChineseThreshold", JsonProperty.USE_DEFAULT_NAME, "(Ljava/util/Set;I)V", "differentiate", "text", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ChineseDifferentiator implements LanguageDifferentiator {
    private final Set<String> traditionalChineseCharacters;
    private final int traditionalChineseThreshold;

    @Inject
    public ChineseDifferentiator(@Named("traditional-chinese-characters") Set<String> traditionalChineseCharacters, @Named("traditional-chinese-threshold") int i) {
        Intrinsics.checkNotNullParameter(traditionalChineseCharacters, "traditionalChineseCharacters");
        this.traditionalChineseCharacters = traditionalChineseCharacters;
        this.traditionalChineseThreshold = i;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator.LanguageDifferentiator
    public String differentiate(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return SequencesKt.count(SequencesKt.filter(StringsKt.asSequence(text), new Function1<Character, Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.languagedetector.differentiator.ChineseDifferentiator$differentiate$traditionalChineseRate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final Boolean invoke(char c) {
                Set set;
                set = ChineseDifferentiator.this.traditionalChineseCharacters;
                return Boolean.valueOf(set.contains(String.valueOf(c)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Character ch) {
                return invoke(ch.charValue());
            }
        })) >= this.traditionalChineseThreshold ? "tc" : "zh";
    }
}
