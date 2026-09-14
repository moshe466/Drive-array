package com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TagData.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0006HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagData;", JsonProperty.USE_DEFAULT_NAME, "tagName", JsonProperty.USE_DEFAULT_NAME, "attribute", "innerTags", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAttribute", "()Ljava/lang/String;", "getInnerTags", "()Ljava/util/List;", "setInnerTags", "(Ljava/util/List;)V", "getTagName", "addInnerTag", JsonProperty.USE_DEFAULT_NAME, "tag", "component1", "component2", "component3", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class TagData {
    private final String attribute;
    private List<TagData> innerTags;
    private final String tagName;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagData copy$default(TagData tagData, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tagData.tagName;
        }
        if ((i & 2) != 0) {
            str2 = tagData.attribute;
        }
        if ((i & 4) != 0) {
            list = tagData.innerTags;
        }
        return tagData.copy(str, str2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTagName() {
        return this.tagName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAttribute() {
        return this.attribute;
    }

    public final List<TagData> component3() {
        return this.innerTags;
    }

    public final TagData copy(String tagName, String attribute, List<TagData> innerTags) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        return new TagData(tagName, attribute, innerTags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TagData)) {
            return false;
        }
        TagData tagData = (TagData) other;
        return Intrinsics.areEqual(this.tagName, tagData.tagName) && Intrinsics.areEqual(this.attribute, tagData.attribute) && Intrinsics.areEqual(this.innerTags, tagData.innerTags);
    }

    public int hashCode() {
        int hashCode = this.tagName.hashCode() * 31;
        String str = this.attribute;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<TagData> list = this.innerTags;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "TagData(tagName=" + this.tagName + ", attribute=" + this.attribute + ", innerTags=" + this.innerTags + ")";
    }

    public TagData(String tagName, String str, List<TagData> list) {
        Intrinsics.checkNotNullParameter(tagName, "tagName");
        this.tagName = tagName;
        this.attribute = str;
        this.innerTags = list;
    }

    public /* synthetic */ TagData(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : list);
    }

    public final String getTagName() {
        return this.tagName;
    }

    public final String getAttribute() {
        return this.attribute;
    }

    public final List<TagData> getInnerTags() {
        return this.innerTags;
    }

    public final void setInnerTags(List<TagData> list) {
        this.innerTags = list;
    }

    public final void addInnerTag(TagData tag) {
        List<TagData> list = this.innerTags;
        if (list != null) {
            list.add(tag);
        } else {
            this.innerTags = CollectionsKt.mutableListOf(tag);
        }
    }
}
