package com.samsung.sr.nmt.t2t.translator.core.pipeline.util;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Trie.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J=\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002 \b\u0002\u0010\u000b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J=\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u001b\b\u0002\u0010\u0015\u001a\u0015\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0016¢\u0006\u0002\b\u0017R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/Trie;", "T", JsonProperty.USE_DEFAULT_NAME, "()V", "root", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/TrieNode;", "add", JsonProperty.USE_DEFAULT_NAME, "key", JsonProperty.USE_DEFAULT_NAME, "value", "onTrieAdd", "Lkotlin/Function2;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "clear", "isEmpty", JsonProperty.USE_DEFAULT_NAME, "searchLongestPrefixKeyNode", "text", "startIndex", JsonProperty.USE_DEFAULT_NAME, "onlyWord", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class Trie<T> {
    private TrieNode<T> root = new TrieNode<>(null, null, 0, null, 15, null);

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void add$default(Trie trie, String str, Object obj, Function2 function2, int i, Object obj2) {
        if ((i & 4) != 0) {
            function2 = new Function2<TrieNode<T>, T, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.util.Trie$add$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object obj3, Object obj4) {
                    invoke((TrieNode<TrieNode<T>>) obj3, (TrieNode<T>) obj4);
                    return Unit.INSTANCE;
                }

                public final void invoke(TrieNode<T> node, T t) {
                    Intrinsics.checkNotNullParameter(node, "node");
                    node.setValue(t);
                }
            };
        }
        trie.add(str, obj, function2);
    }

    public final void add(String key, T value, Function2<? super TrieNode<T>, ? super T, Unit> onTrieAdd) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(onTrieAdd, "onTrieAdd");
        TrieNode<T> trieNode = this.root;
        String lowerCase = key.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        int length = lowerCase.length();
        for (int i = 0; i < length; i++) {
            char charAt = lowerCase.charAt(i);
            if (!trieNode.getChildNodes().containsKey(Character.valueOf(charAt))) {
                trieNode.getChildNodes().put(Character.valueOf(charAt), new TrieNode<>(null, null, trieNode.getLevel() + 1, null, 11, null));
            }
            TrieNode<T> trieNode2 = trieNode.getChildNodes().get(Character.valueOf(charAt));
            Intrinsics.checkNotNull(trieNode2);
            trieNode = trieNode2;
        }
        trieNode.setKey(key);
        onTrieAdd.invoke(trieNode, value);
    }

    public final void clear() {
        this.root = new TrieNode<>(null, null, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TrieNode searchLongestPrefixKeyNode$default(Trie trie, String str, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return trie.searchLongestPrefixKeyNode(str, i, function1);
    }

    public final TrieNode<T> searchLongestPrefixKeyNode(String text, int startIndex, Function1<? super T, Boolean> onlyWord) {
        Intrinsics.checkNotNullParameter(text, "text");
        if (!(startIndex >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        TrieNode<T> trieNode = this.root;
        TrieNode<T> trieNode2 = null;
        for (int i = startIndex; i < text.length(); i++) {
            char lowerCase = Character.toLowerCase(text.charAt(i));
            if (!trieNode.getChildNodes().containsKey(Character.valueOf(lowerCase))) {
                break;
            }
            TrieNode<T> trieNode3 = trieNode.getChildNodes().get(Character.valueOf(lowerCase));
            Intrinsics.checkNotNull(trieNode3);
            trieNode = trieNode3;
            if (trieNode.getValue() != null) {
                if (onlyWord != null) {
                    T value = trieNode.getValue();
                    Intrinsics.checkNotNull(value);
                    if (onlyWord.invoke(value).booleanValue() && !TrieKt.isWord(text, startIndex, i)) {
                    }
                }
                trieNode2 = trieNode;
            }
        }
        return trieNode2;
    }

    public final boolean isEmpty() {
        return this.root.getChildNodes().isEmpty();
    }
}
