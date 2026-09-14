package com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.loader.SwearWordRuleLoader;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.util.Trie;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.util.TrieNode;
import com.samsung.sr.nmt.t2t.translator.core.utils.LanguageDirection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SwearWordReplacer.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0007J\u0016\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/swearword/SwearWordReplacer;", JsonProperty.USE_DEFAULT_NAME, "swearWordRuleLoader", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/loader/SwearWordRuleLoader;)V", "loadedLanguageDirections", JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/utils/LanguageDirection;", "ruleTriePerLanguageMap", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/util/Trie;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/swearword/SwearWordRule;", "clear", JsonProperty.USE_DEFAULT_NAME, "isLoaded", JsonProperty.USE_DEFAULT_NAME, "language", "load", "languageDirection", "replace", "sourceText", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class SwearWordReplacer {
    private final Set<LanguageDirection> loadedLanguageDirections;
    private final Map<String, Trie<SwearWordRule>> ruleTriePerLanguageMap;
    private final SwearWordRuleLoader swearWordRuleLoader;

    @Inject
    public SwearWordReplacer(SwearWordRuleLoader swearWordRuleLoader) {
        Intrinsics.checkNotNullParameter(swearWordRuleLoader, "swearWordRuleLoader");
        this.swearWordRuleLoader = swearWordRuleLoader;
        this.loadedLanguageDirections = new LinkedHashSet();
        this.ruleTriePerLanguageMap = new LinkedHashMap();
    }

    public final boolean isLoaded(LanguageDirection language) {
        Intrinsics.checkNotNullParameter(language, "language");
        return this.loadedLanguageDirections.contains(language);
    }

    public final void load(LanguageDirection languageDirection) {
        Intrinsics.checkNotNullParameter(languageDirection, "languageDirection");
        Trie<SwearWordRule> trie = this.ruleTriePerLanguageMap.get(languageDirection.getSrcLang());
        if (trie == null) {
            trie = new Trie<>();
        }
        Trie<SwearWordRule> trie2 = this.ruleTriePerLanguageMap.get(languageDirection.getTgtLang());
        if (trie2 == null) {
            trie2 = new Trie<>();
        }
        Trie<SwearWordRule> trie3 = trie2;
        this.loadedLanguageDirections.add(languageDirection);
        for (SwearWordRule swearWordRule : this.swearWordRuleLoader.getAllRules(languageDirection.getSrcLang(), languageDirection.getTgtLang())) {
            if (swearWordRule.getLanguage() == languageDirection.getSrcLang()) {
                Trie.add$default(trie, swearWordRule.getSourceText(), swearWordRule, null, 4, null);
            } else {
                Trie.add$default(trie3, swearWordRule.getSourceText(), swearWordRule, null, 4, null);
            }
        }
        this.ruleTriePerLanguageMap.put(languageDirection.getSrcLang(), trie);
        this.ruleTriePerLanguageMap.put(languageDirection.getTgtLang(), trie3);
    }

    public final String replace(String language, String sourceText) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Trie<SwearWordRule> trie = this.ruleTriePerLanguageMap.get(language);
        if (trie == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        if (trie.isEmpty()) {
            return sourceText;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < sourceText.length()) {
            TrieNode<SwearWordRule> searchLongestPrefixKeyNode = trie.searchLongestPrefixKeyNode(sourceText, i, new Function1<SwearWordRule, Boolean>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.swearword.SwearWordReplacer$replace$1$node$1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(SwearWordRule searchLongestPrefixKeyNode2) {
                    Intrinsics.checkNotNullParameter(searchLongestPrefixKeyNode2, "$this$searchLongestPrefixKeyNode");
                    return Boolean.valueOf(searchLongestPrefixKeyNode2.getOnlyWord());
                }
            });
            if ((searchLongestPrefixKeyNode != null ? searchLongestPrefixKeyNode.getValue() : null) == null) {
                sb.append(sourceText.charAt(i));
                i++;
            } else {
                SwearWordRule value = searchLongestPrefixKeyNode.getValue();
                Intrinsics.checkNotNull(value);
                sb.append(value.getReplaceTo());
                i += searchLongestPrefixKeyNode.getLevel();
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final void clear() {
        this.loadedLanguageDirections.clear();
        this.ruleTriePerLanguageMap.clear();
    }
}
