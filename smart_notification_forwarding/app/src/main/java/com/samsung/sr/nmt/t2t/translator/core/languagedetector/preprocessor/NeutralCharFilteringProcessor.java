package com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: NeutralCharFilteringProcessor.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/NeutralCharFilteringProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/DetectionPreProcessor;", "()V", "process", JsonProperty.USE_DEFAULT_NAME, "text", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class NeutralCharFilteringProcessor implements DetectionPreProcessor {
    private static final int FILTER_THRESHOLD = 3;
    private static final Companion Companion = new Companion(null);
    private static final Regex neutralRegex = new Regex("[0-9]|・");
    private static final List<String> languageNames = CollectionsKt.listOf((Object[]) new String[]{"english", "español", "русский язык", "français", "deutsch", "日本語", "português", "türkçe", "italiano", "فارسی", "nederlands", "中文", "polski", "tiếng việt", "bahasa indonesia", "čeština", "العربية", "한국어", "українська мова", "ελληνικά", "esperanto"});

    /* compiled from: NeutralCharFilteringProcessor.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/languagedetector/preprocessor/NeutralCharFilteringProcessor$Companion;", JsonProperty.USE_DEFAULT_NAME, "()V", "FILTER_THRESHOLD", JsonProperty.USE_DEFAULT_NAME, "languageNames", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "neutralRegex", "Lkotlin/text/Regex;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
    /* loaded from: classes.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Inject
    public NeutralCharFilteringProcessor() {
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.languagedetector.preprocessor.DetectionPreProcessor
    public String process(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        String lowerCase = text.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        String obj = StringsKt.trim((CharSequence) lowerCase).toString();
        List<String> list = languageNames;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (StringsKt.contains$default((CharSequence) obj, (CharSequence) next, false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = arrayList2.size() >= 3 ? arrayList2 : null;
        if (arrayList3 != null) {
            Iterator it2 = arrayList3.iterator();
            String str = obj;
            while (it2.hasNext()) {
                str = StringsKt.replace$default(str, (String) it2.next(), JsonProperty.USE_DEFAULT_NAME, false, 4, (Object) null);
            }
            obj = str;
        }
        return neutralRegex.replace(obj, JsonProperty.USE_DEFAULT_NAME);
    }
}
