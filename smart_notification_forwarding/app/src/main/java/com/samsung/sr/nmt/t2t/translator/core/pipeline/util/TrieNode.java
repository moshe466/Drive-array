package com.samsung.sr.nmt.t2t.translator.core.pipeline.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrieNode.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\f\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u001b\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\tHÆ\u0003JR\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\tHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\"\u001a\u00020\u0007HÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001R#\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/TrieNode;", "NodeValue", JsonProperty.USE_DEFAULT_NAME, "key", JsonProperty.USE_DEFAULT_NAME, "value", "level", JsonProperty.USE_DEFAULT_NAME, "childNodes", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;Ljava/lang/Object;ILjava/util/Map;)V", "getChildNodes", "()Ljava/util/Map;", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getLevel", "()I", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Object;ILjava/util/Map;)Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/TrieNode;", "equals", JsonProperty.USE_DEFAULT_NAME, "other", "hashCode", "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class TrieNode<NodeValue> {
    private final Map<Character, TrieNode<NodeValue>> childNodes;
    private String key;
    private final int level;
    private NodeValue value;

    public TrieNode() {
        this(null, null, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrieNode copy$default(TrieNode trieNode, String str, Object obj, int i, Map map, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            str = trieNode.key;
        }
        if ((i2 & 2) != 0) {
            obj = trieNode.value;
        }
        if ((i2 & 4) != 0) {
            i = trieNode.level;
        }
        if ((i2 & 8) != 0) {
            map = trieNode.childNodes;
        }
        return trieNode.copy(str, obj, i, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public final NodeValue component2() {
        return this.value;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    public final Map<Character, TrieNode<NodeValue>> component4() {
        return this.childNodes;
    }

    public final TrieNode<NodeValue> copy(String key, NodeValue value, int level, Map<Character, TrieNode<NodeValue>> childNodes) {
        Intrinsics.checkNotNullParameter(childNodes, "childNodes");
        return new TrieNode<>(key, value, level, childNodes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrieNode)) {
            return false;
        }
        TrieNode trieNode = (TrieNode) other;
        return Intrinsics.areEqual(this.key, trieNode.key) && Intrinsics.areEqual(this.value, trieNode.value) && this.level == trieNode.level && Intrinsics.areEqual(this.childNodes, trieNode.childNodes);
    }

    public int hashCode() {
        String str = this.key;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        NodeValue nodevalue = this.value;
        return ((((hashCode + (nodevalue != null ? nodevalue.hashCode() : 0)) * 31) + Integer.hashCode(this.level)) * 31) + this.childNodes.hashCode();
    }

    public String toString() {
        return "TrieNode(key=" + this.key + ", value=" + this.value + ", level=" + this.level + ", childNodes=" + this.childNodes + ")";
    }

    public TrieNode(String str, NodeValue nodevalue, int i, Map<Character, TrieNode<NodeValue>> childNodes) {
        Intrinsics.checkNotNullParameter(childNodes, "childNodes");
        this.key = str;
        this.value = nodevalue;
        this.level = i;
        this.childNodes = childNodes;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final NodeValue getValue() {
        return this.value;
    }

    public final void setValue(NodeValue nodevalue) {
        this.value = nodevalue;
    }

    public final int getLevel() {
        return this.level;
    }

    public /* synthetic */ TrieNode(String str, Object obj, int i, LinkedHashMap linkedHashMap, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : obj, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? new LinkedHashMap() : linkedHashMap);
    }

    public final Map<Character, TrieNode<NodeValue>> getChildNodes() {
        return this.childNodes;
    }
}
