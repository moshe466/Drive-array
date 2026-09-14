package com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TagNode.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00000\tHÆ\u0003J9\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\tHÆ\u0001J\u0013\u0010 \u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006%"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagNode;", JsonProperty.USE_DEFAULT_NAME, "tagData", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagData;", "text", JsonProperty.USE_DEFAULT_NAME, "hasBeenClosed", JsonProperty.USE_DEFAULT_NAME, "children", JsonProperty.USE_DEFAULT_NAME, "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagData;Ljava/lang/String;ZLjava/util/List;)V", "getChildren", "()Ljava/util/List;", "setChildren", "(Ljava/util/List;)V", "getHasBeenClosed", "()Z", "setHasBeenClosed", "(Z)V", "getTagData", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagData;", "setTagData", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagData;)V", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class TagNode {
    private List<TagNode> children;
    private boolean hasBeenClosed;
    private TagData tagData;
    private String text;

    public TagNode() {
        this(null, null, false, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagNode copy$default(TagNode tagNode, TagData tagData, String str, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            tagData = tagNode.tagData;
        }
        if ((i & 2) != 0) {
            str = tagNode.text;
        }
        if ((i & 4) != 0) {
            z = tagNode.hasBeenClosed;
        }
        if ((i & 8) != 0) {
            list = tagNode.children;
        }
        return tagNode.copy(tagData, str, z, list);
    }

    /* renamed from: component1, reason: from getter */
    public final TagData getTagData() {
        return this.tagData;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasBeenClosed() {
        return this.hasBeenClosed;
    }

    public final List<TagNode> component4() {
        return this.children;
    }

    public final TagNode copy(TagData tagData, String text, boolean hasBeenClosed, List<TagNode> children) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(children, "children");
        return new TagNode(tagData, text, hasBeenClosed, children);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TagNode)) {
            return false;
        }
        TagNode tagNode = (TagNode) other;
        return Intrinsics.areEqual(this.tagData, tagNode.tagData) && Intrinsics.areEqual(this.text, tagNode.text) && this.hasBeenClosed == tagNode.hasBeenClosed && Intrinsics.areEqual(this.children, tagNode.children);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        TagData tagData = this.tagData;
        int hashCode = (((tagData == null ? 0 : tagData.hashCode()) * 31) + this.text.hashCode()) * 31;
        boolean z = this.hasBeenClosed;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return ((hashCode + i) * 31) + this.children.hashCode();
    }

    public String toString() {
        return "TagNode(tagData=" + this.tagData + ", text=" + this.text + ", hasBeenClosed=" + this.hasBeenClosed + ", children=" + this.children + ")";
    }

    public TagNode(TagData tagData, String text, boolean z, List<TagNode> children) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(children, "children");
        this.tagData = tagData;
        this.text = text;
        this.hasBeenClosed = z;
        this.children = children;
    }

    public final TagData getTagData() {
        return this.tagData;
    }

    public final void setTagData(TagData tagData) {
        this.tagData = tagData;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final boolean getHasBeenClosed() {
        return this.hasBeenClosed;
    }

    public final void setHasBeenClosed(boolean z) {
        this.hasBeenClosed = z;
    }

    public /* synthetic */ TagNode(TagData tagData, String str, boolean z, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tagData, (i & 2) != 0 ? JsonProperty.USE_DEFAULT_NAME : str, (i & 4) != 0 ? true : z, (i & 8) != 0 ? new ArrayList() : arrayList);
    }

    public final List<TagNode> getChildren() {
        return this.children;
    }

    public final void setChildren(List<TagNode> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.children = list;
    }
}
