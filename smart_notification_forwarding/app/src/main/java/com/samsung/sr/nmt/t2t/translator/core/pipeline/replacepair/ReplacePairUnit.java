package com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.util.Trie;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.util.TrieNode;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReplacePairUnit.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005J\u001c\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017J.\u0010\u0019\u001a\u00020\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\u0006\u0010\u001e\u001a\u00020\u001aH\u0002J\u001e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bJ&\u0010!\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairUnit;", JsonProperty.USE_DEFAULT_NAME, "()V", "loadedLanguageDirections", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "sourceLanguageTrieMap", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/Trie;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairSourceNode;", "targetLanguageTrieMap", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePairTargetNode;", "clear", JsonProperty.USE_DEFAULT_NAME, "collectTextsFromSourceSentence", "language", "sourceSentence", "isLoaded", JsonProperty.USE_DEFAULT_NAME, "languageDirection", "load", "replacePairs", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/replacepair/ReplacePair;", "obtainKeyFromTrieNode", JsonProperty.USE_DEFAULT_NAME, "node", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/TrieNode;", "sourceTexts", "index", "replace", "targetSentenceBefore", "replaceWordsInTargetSentence", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ReplacePairUnit {
    private final Set<LanguageDirection> loadedLanguageDirections = new LinkedHashSet();
    private final Map<String, Trie<ReplacePairSourceNode>> sourceLanguageTrieMap = new LinkedHashMap();
    private final Map<String, Trie<ReplacePairTargetNode>> targetLanguageTrieMap = new LinkedHashMap();

    public final boolean isLoaded(LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        return this.loadedLanguageDirections.contains(languageDirection);
    }

    public final void load(LanguageDirection languageDirection, List<ReplacePair> replacePairs) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(replacePairs, "replacePairs");
        Trie<ReplacePairSourceNode> trie = this.sourceLanguageTrieMap.get(languageDirection.getSrcLang());
        if (trie == null) {
            trie = new Trie<>();
        }
        Trie<ReplacePairTargetNode> trie2 = this.targetLanguageTrieMap.get(languageDirection.getTgtLang());
        if (trie2 == null) {
            trie2 = new Trie<>();
        }
        Trie<ReplacePairTargetNode> trie3 = trie2;
        for (ReplacePair replacePair : replacePairs) {
            Trie.add$default(trie, replacePair.getSourceText(), new ReplacePairSourceNode(replacePair.isAllowedAsSubstring()), null, 4, null);
            trie3.add(replacePair.getTargetTextBefore(), ReplacePairTargetNode.INSTANCE.fromReplacePair(replacePair), new Function2<TrieNode<ReplacePairTargetNode>, ReplacePairTargetNode, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePairUnit$load$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(TrieNode<ReplacePairTargetNode> trieNode, ReplacePairTargetNode replacePairTargetNode) {
                    invoke2(trieNode, replacePairTargetNode);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TrieNode<ReplacePairTargetNode> node, ReplacePairTargetNode value) {
                    Set<String> sourceTexts;
                    Intrinsics.checkNotNullParameter(node, "node");
                    Intrinsics.checkNotNullParameter(value, "value");
                    ReplacePairTargetNode value2 = node.getValue();
                    if (value2 == null || (sourceTexts = value2.getSourceTexts()) == null) {
                        node.setValue(value);
                    } else {
                        sourceTexts.addAll(value.getSourceTexts());
                    }
                }
            });
        }
        this.loadedLanguageDirections.add(languageDirection);
        this.sourceLanguageTrieMap.put(languageDirection.getSrcLang(), trie);
        this.targetLanguageTrieMap.put(languageDirection.getTgtLang(), trie3);
    }

    public final String replace(LanguageDirection languageDirection, String sourceSentence, String targetSentenceBefore) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Intrinsics.checkNotNullParameter(sourceSentence, "sourceSentence");
        Intrinsics.checkNotNullParameter(targetSentenceBefore, "targetSentenceBefore");
        return replaceWordsInTargetSentence(languageDirection.getTgtLang(), targetSentenceBefore, collectTextsFromSourceSentence(languageDirection.getSrcLang(), sourceSentence));
    }

    private final Set<String> collectTextsFromSourceSentence(String language, String sourceSentence) {
        Trie<ReplacePairSourceNode> trie = this.sourceLanguageTrieMap.get(language);
        if (trie != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (i < sourceSentence.length()) {
                i = obtainKeyFromTrieNode(trie.searchLongestPrefixKeyNode(sourceSentence, i, new Function1<ReplacePairSourceNode, Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePairUnit$collectTextsFromSourceSentence$1$node$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(ReplacePairSourceNode searchLongestPrefixKeyNode) {
                        Intrinsics.checkNotNullParameter(searchLongestPrefixKeyNode, "$this$searchLongestPrefixKeyNode");
                        return Boolean.valueOf(!searchLongestPrefixKeyNode.isAllowedAsSubstring());
                    }
                }), linkedHashSet, i);
            }
            return linkedHashSet;
        }
        return new LinkedHashSet();
    }

    private final int obtainKeyFromTrieNode(TrieNode<ReplacePairSourceNode> node, Set<String> sourceTexts, int index) {
        String key;
        if (node == null || node.getValue() == null || (key = node.getKey()) == null) {
            return index + 1;
        }
        sourceTexts.add(key);
        return index + key.length();
    }

    private final String replaceWordsInTargetSentence(String language, String targetSentenceBefore, Set<String> sourceTexts) {
        ReplacePairTargetNode value;
        Object m107constructorimpl;
        Trie<ReplacePairTargetNode> trie = this.targetLanguageTrieMap.get(language);
        if (trie == null) {
            return targetSentenceBefore;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < targetSentenceBefore.length()) {
            TrieNode<ReplacePairTargetNode> searchLongestPrefixKeyNode = trie.searchLongestPrefixKeyNode(targetSentenceBefore, i, new Function1<ReplacePairTargetNode, Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.replacepair.ReplacePairUnit$replaceWordsInTargetSentence$1$1$node$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(ReplacePairTargetNode searchLongestPrefixKeyNode2) {
                    Intrinsics.checkNotNullParameter(searchLongestPrefixKeyNode2, "$this$searchLongestPrefixKeyNode");
                    return Boolean.valueOf(!searchLongestPrefixKeyNode2.isAllowedAsSubstring());
                }
            });
            if (searchLongestPrefixKeyNode != null && (value = searchLongestPrefixKeyNode.getValue()) != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m107constructorimpl = Result.m107constructorimpl(ResultKt.createFailure(th));
                }
                for (Object obj : value.getSourceTexts()) {
                    if (sourceTexts.contains((String) obj)) {
                        m107constructorimpl = Result.m107constructorimpl((String) obj);
                        String str = null;
                        if (Result.m113isFailureimpl(m107constructorimpl)) {
                            m107constructorimpl = null;
                        }
                        String str2 = (String) m107constructorimpl;
                        if (str2 != null) {
                            i += searchLongestPrefixKeyNode.getLevel();
                            sb.append(value.getTargetTextAfter());
                            str = str2;
                        }
                        if (str == null) {
                        }
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                break;
            }
            sb.append(targetSentenceBefore.charAt(i));
            Integer.valueOf(i);
            i++;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2 == null ? targetSentenceBefore : sb2;
    }

    public final void clear() {
        this.loadedLanguageDirections.clear();
        this.sourceLanguageTrieMap.clear();
        this.targetLanguageTrieMap.clear();
    }
}
