package com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.UnpairedTagsRegex;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.util.DataExchanger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TagStorage.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagStorage;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/DataExchanger;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagData;", JsonProperty.USE_DEFAULT_NAME, "unpairedTagsRegex", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;)V", "generateDataTag", "currentDataCount", JsonProperty.USE_DEFAULT_NAME, "recover", "partialKeptData", "recoverClosedTag", "tagData", "recoverOpenTag", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TagStorage extends DataExchanger<TagData, String> {
    private final SymbolRegex unpairedTagsRegex;

    /* JADX WARN: Multi-variable type inference failed */
    public TagStorage() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public TagStorage(SymbolRegex unpairedTagsRegex) {
        Intrinsics.checkNotNullParameter(unpairedTagsRegex, "unpairedTagsRegex");
        this.unpairedTagsRegex = unpairedTagsRegex;
    }

    public /* synthetic */ TagStorage(UnpairedTagsRegex unpairedTagsRegex, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new UnpairedTagsRegex() : unpairedTagsRegex);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.util.DataExchanger
    protected String generateDataTag(int currentDataCount) {
        return "a_" + currentDataCount;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.util.DataRecover
    public String recover(String partialKeptData) {
        String str;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(partialKeptData, "partialKeptData");
        int i = 0;
        String str2 = partialKeptData;
        for (TagData tagData : getStorageStream()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            TagData tagData2 = tagData;
            String str3 = "<a_" + i + ">";
            String recoverOpenTag = recoverOpenTag(tagData2);
            List<TagData> innerTags = tagData2.getInnerTags();
            String str4 = JsonProperty.USE_DEFAULT_NAME;
            if (innerTags == null || (str = CollectionsKt.joinToString$default(innerTags, JsonProperty.USE_DEFAULT_NAME, null, null, 0, null, new TagStorage$recover$1$1(this), 30, null)) == null) {
                str = JsonProperty.USE_DEFAULT_NAME;
            }
            String replace$default = StringsKt.replace$default(str2, str3, recoverOpenTag + str, false, 4, (Object) null);
            String str5 = "</a_" + i + ">";
            List<TagData> innerTags2 = tagData2.getInnerTags();
            if (innerTags2 != null) {
                List<TagData> list = innerTags2;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(recoverClosedTag((TagData) it.next()));
                }
                List asReversed = CollectionsKt.asReversed(arrayList);
                if (asReversed != null && (joinToString$default = CollectionsKt.joinToString$default(asReversed, JsonProperty.USE_DEFAULT_NAME, null, null, 0, null, null, 62, null)) != null) {
                    str4 = joinToString$default;
                }
            }
            str2 = StringsKt.replace$default(replace$default, str5, str4 + recoverClosedTag(tagData2), false, 4, (Object) null);
            i = i2;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String recoverOpenTag(TagData tagData) {
        String str;
        if (tagData == null) {
            return JsonProperty.USE_DEFAULT_NAME;
        }
        String tagName = tagData.getTagName();
        String attribute = tagData.getAttribute();
        if (attribute == null || (str = " " + attribute) == null) {
            str = JsonProperty.USE_DEFAULT_NAME;
        }
        String str2 = "<" + tagName + str + ">";
        return str2 == null ? JsonProperty.USE_DEFAULT_NAME : str2;
    }

    private final String recoverClosedTag(TagData tagData) {
        if (tagData == null) {
            return JsonProperty.USE_DEFAULT_NAME;
        }
        String str = !this.unpairedTagsRegex.getRegexCompiled().matches(tagData.getTagName()) ? "</" + tagData.getTagName() + ">" : JsonProperty.USE_DEFAULT_NAME;
        return str == null ? JsonProperty.USE_DEFAULT_NAME : str;
    }
}
