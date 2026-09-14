package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.placeholder.PlaceholderStorage;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.FormattingRules;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagNode;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagStorage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AtomicProcessingTask.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B±\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b¢\u0006\u0002\u0010\u0019J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bHÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\u0007HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u000f\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u000fHÆ\u0003J»\u0001\u0010Q\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bHÆ\u0001J\u000e\u0010R\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003J\u0013\u0010S\u001a\u00020\u00072\b\u0010T\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010U\u001a\u00020VHÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010$R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010$R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010)\"\u0004\b*\u0010+R\u0011\u0010,\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b,\u0010)R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001dR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010)¨\u0006X"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/AtomicProcessingTask;", JsonProperty.USE_DEFAULT_NAME, "sourceLanguage", JsonProperty.USE_DEFAULT_NAME, "targetLanguage", "currentText", "verbose", JsonProperty.USE_DEFAULT_NAME, "isFinished", "delimiter", "children", JsonProperty.USE_DEFAULT_NAME, "recaseRule", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRule;", "placeholderStorage", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/placeholder/PlaceholderStorage;", "tagStorage", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagStorage;", "encloseTags", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagNode;", "tagNode", "honorificTag", "pivotResult", "formattingRules", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/formatting/FormattingRules;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/List;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRule;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/placeholder/PlaceholderStorage;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagStorage;Ljava/util/List;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagNode;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getChildren", "()Ljava/util/List;", "getCurrentText", "()Ljava/lang/String;", "setCurrentText", "(Ljava/lang/String;)V", "getDelimiter", "setDelimiter", "getEncloseTags", "setEncloseTags", "(Ljava/util/List;)V", "getFormattingRules", "setFormattingRules", "getHonorificTag", "setHonorificTag", "()Z", "setFinished", "(Z)V", "isLeaf", "getPivotResult", "setPivotResult", "getPlaceholderStorage", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/placeholder/PlaceholderStorage;", "setPlaceholderStorage", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/placeholder/PlaceholderStorage;)V", "getRecaseRule", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRule;", "setRecaseRule", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRule;)V", "getSourceLanguage", "getTagNode", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagNode;", "setTagNode", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagNode;)V", "getTagStorage", "()Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagStorage;", "setTagStorage", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagStorage;)V", "getTargetLanguage", "getVerbose", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "createChild", "equals", "other", "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class AtomicProcessingTask {
    private final List<AtomicProcessingTask> children;
    private String currentText;
    private String delimiter;
    private List<TagNode> encloseTags;
    private List<FormattingRules> formattingRules;
    private String honorificTag;
    private boolean isFinished;
    private String pivotResult;
    private PlaceholderStorage placeholderStorage;
    private RecaseRule recaseRule;
    private final String sourceLanguage;
    private TagNode tagNode;
    private TagStorage tagStorage;
    private final String targetLanguage;
    private final boolean verbose;

    public static /* synthetic */ AtomicProcessingTask copy$default(AtomicProcessingTask atomicProcessingTask, String str, String str2, String str3, boolean z, boolean z2, String str4, List list, RecaseRule recaseRule, PlaceholderStorage placeholderStorage, TagStorage tagStorage, List list2, TagNode tagNode, String str5, String str6, List list3, int i, Object obj) {
        return atomicProcessingTask.copy((i & 1) != 0 ? atomicProcessingTask.sourceLanguage : str, (i & 2) != 0 ? atomicProcessingTask.targetLanguage : str2, (i & 4) != 0 ? atomicProcessingTask.currentText : str3, (i & 8) != 0 ? atomicProcessingTask.verbose : z, (i & 16) != 0 ? atomicProcessingTask.isFinished : z2, (i & 32) != 0 ? atomicProcessingTask.delimiter : str4, (i & 64) != 0 ? atomicProcessingTask.children : list, (i & 128) != 0 ? atomicProcessingTask.recaseRule : recaseRule, (i & 256) != 0 ? atomicProcessingTask.placeholderStorage : placeholderStorage, (i & 512) != 0 ? atomicProcessingTask.tagStorage : tagStorage, (i & 1024) != 0 ? atomicProcessingTask.encloseTags : list2, (i & 2048) != 0 ? atomicProcessingTask.tagNode : tagNode, (i & 4096) != 0 ? atomicProcessingTask.honorificTag : str5, (i & 8192) != 0 ? atomicProcessingTask.pivotResult : str6, (i & 16384) != 0 ? atomicProcessingTask.formattingRules : list3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSourceLanguage() {
        return this.sourceLanguage;
    }

    /* renamed from: component10, reason: from getter */
    public final TagStorage getTagStorage() {
        return this.tagStorage;
    }

    public final List<TagNode> component11() {
        return this.encloseTags;
    }

    /* renamed from: component12, reason: from getter */
    public final TagNode getTagNode() {
        return this.tagNode;
    }

    /* renamed from: component13, reason: from getter */
    public final String getHonorificTag() {
        return this.honorificTag;
    }

    /* renamed from: component14, reason: from getter */
    public final String getPivotResult() {
        return this.pivotResult;
    }

    public final List<FormattingRules> component15() {
        return this.formattingRules;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCurrentText() {
        return this.currentText;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getVerbose() {
        return this.verbose;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsFinished() {
        return this.isFinished;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDelimiter() {
        return this.delimiter;
    }

    public final List<AtomicProcessingTask> component7() {
        return this.children;
    }

    /* renamed from: component8, reason: from getter */
    public final RecaseRule getRecaseRule() {
        return this.recaseRule;
    }

    /* renamed from: component9, reason: from getter */
    public final PlaceholderStorage getPlaceholderStorage() {
        return this.placeholderStorage;
    }

    public final AtomicProcessingTask copy(String sourceLanguage, String targetLanguage, String currentText, boolean verbose, boolean isFinished, String delimiter, List<AtomicProcessingTask> children, RecaseRule recaseRule, PlaceholderStorage placeholderStorage, TagStorage tagStorage, List<TagNode> encloseTags, TagNode tagNode, String honorificTag, String pivotResult, List<FormattingRules> formattingRules) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(currentText, "currentText");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(encloseTags, "encloseTags");
        Intrinsics.checkNotNullParameter(honorificTag, "honorificTag");
        Intrinsics.checkNotNullParameter(formattingRules, "formattingRules");
        return new AtomicProcessingTask(sourceLanguage, targetLanguage, currentText, verbose, isFinished, delimiter, children, recaseRule, placeholderStorage, tagStorage, encloseTags, tagNode, honorificTag, pivotResult, formattingRules);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AtomicProcessingTask)) {
            return false;
        }
        AtomicProcessingTask atomicProcessingTask = (AtomicProcessingTask) other;
        return Intrinsics.areEqual(this.sourceLanguage, atomicProcessingTask.sourceLanguage) && Intrinsics.areEqual(this.targetLanguage, atomicProcessingTask.targetLanguage) && Intrinsics.areEqual(this.currentText, atomicProcessingTask.currentText) && this.verbose == atomicProcessingTask.verbose && this.isFinished == atomicProcessingTask.isFinished && Intrinsics.areEqual(this.delimiter, atomicProcessingTask.delimiter) && Intrinsics.areEqual(this.children, atomicProcessingTask.children) && Intrinsics.areEqual(this.recaseRule, atomicProcessingTask.recaseRule) && Intrinsics.areEqual(this.placeholderStorage, atomicProcessingTask.placeholderStorage) && Intrinsics.areEqual(this.tagStorage, atomicProcessingTask.tagStorage) && Intrinsics.areEqual(this.encloseTags, atomicProcessingTask.encloseTags) && Intrinsics.areEqual(this.tagNode, atomicProcessingTask.tagNode) && Intrinsics.areEqual(this.honorificTag, atomicProcessingTask.honorificTag) && Intrinsics.areEqual(this.pivotResult, atomicProcessingTask.pivotResult) && Intrinsics.areEqual(this.formattingRules, atomicProcessingTask.formattingRules);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.sourceLanguage.hashCode() * 31) + this.targetLanguage.hashCode()) * 31) + this.currentText.hashCode()) * 31;
        boolean z = this.verbose;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.isFinished;
        int hashCode2 = (((((i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31) + this.delimiter.hashCode()) * 31) + this.children.hashCode()) * 31;
        RecaseRule recaseRule = this.recaseRule;
        int hashCode3 = (hashCode2 + (recaseRule == null ? 0 : recaseRule.hashCode())) * 31;
        PlaceholderStorage placeholderStorage = this.placeholderStorage;
        int hashCode4 = (hashCode3 + (placeholderStorage == null ? 0 : placeholderStorage.hashCode())) * 31;
        TagStorage tagStorage = this.tagStorage;
        int hashCode5 = (((hashCode4 + (tagStorage == null ? 0 : tagStorage.hashCode())) * 31) + this.encloseTags.hashCode()) * 31;
        TagNode tagNode = this.tagNode;
        int hashCode6 = (((hashCode5 + (tagNode == null ? 0 : tagNode.hashCode())) * 31) + this.honorificTag.hashCode()) * 31;
        String str = this.pivotResult;
        return ((hashCode6 + (str != null ? str.hashCode() : 0)) * 31) + this.formattingRules.hashCode();
    }

    public String toString() {
        return "AtomicProcessingTask(sourceLanguage=" + this.sourceLanguage + ", targetLanguage=" + this.targetLanguage + ", currentText=" + this.currentText + ", verbose=" + this.verbose + ", isFinished=" + this.isFinished + ", delimiter=" + this.delimiter + ", children=" + this.children + ", recaseRule=" + this.recaseRule + ", placeholderStorage=" + this.placeholderStorage + ", tagStorage=" + this.tagStorage + ", encloseTags=" + this.encloseTags + ", tagNode=" + this.tagNode + ", honorificTag=" + this.honorificTag + ", pivotResult=" + this.pivotResult + ", formattingRules=" + this.formattingRules + ")";
    }

    public AtomicProcessingTask(String sourceLanguage, String targetLanguage, String currentText, boolean z, boolean z2, String delimiter, List<AtomicProcessingTask> children, RecaseRule recaseRule, PlaceholderStorage placeholderStorage, TagStorage tagStorage, List<TagNode> encloseTags, TagNode tagNode, String honorificTag, String str, List<FormattingRules> formattingRules) {
        Intrinsics.checkNotNullParameter(sourceLanguage, "sourceLanguage");
        Intrinsics.checkNotNullParameter(targetLanguage, "targetLanguage");
        Intrinsics.checkNotNullParameter(currentText, "currentText");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(children, "children");
        Intrinsics.checkNotNullParameter(encloseTags, "encloseTags");
        Intrinsics.checkNotNullParameter(honorificTag, "honorificTag");
        Intrinsics.checkNotNullParameter(formattingRules, "formattingRules");
        this.sourceLanguage = sourceLanguage;
        this.targetLanguage = targetLanguage;
        this.currentText = currentText;
        this.verbose = z;
        this.isFinished = z2;
        this.delimiter = delimiter;
        this.children = children;
        this.recaseRule = recaseRule;
        this.placeholderStorage = placeholderStorage;
        this.tagStorage = tagStorage;
        this.encloseTags = encloseTags;
        this.tagNode = tagNode;
        this.honorificTag = honorificTag;
        this.pivotResult = str;
        this.formattingRules = formattingRules;
    }

    public final String getSourceLanguage() {
        return this.sourceLanguage;
    }

    public final String getTargetLanguage() {
        return this.targetLanguage;
    }

    public final String getCurrentText() {
        return this.currentText;
    }

    public final void setCurrentText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentText = str;
    }

    public final boolean getVerbose() {
        return this.verbose;
    }

    public final boolean isFinished() {
        return this.isFinished;
    }

    public final void setFinished(boolean z) {
        this.isFinished = z;
    }

    public final String getDelimiter() {
        return this.delimiter;
    }

    public final void setDelimiter(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.delimiter = str;
    }

    public /* synthetic */ AtomicProcessingTask(String str, String str2, String str3, boolean z, boolean z2, String str4, List list, RecaseRule recaseRule, PlaceholderStorage placeholderStorage, TagStorage tagStorage, List list2, TagNode tagNode, String str5, String str6, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? false : z, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? JsonProperty.USE_DEFAULT_NAME : str4, (i & 64) != 0 ? new ArrayList() : list, (i & 128) != 0 ? null : recaseRule, (i & 256) != 0 ? null : placeholderStorage, (i & 512) != 0 ? null : tagStorage, (i & 1024) != 0 ? new ArrayList() : list2, (i & 2048) != 0 ? null : tagNode, (i & 4096) != 0 ? JsonProperty.USE_DEFAULT_NAME : str5, (i & 8192) != 0 ? null : str6, (i & 16384) != 0 ? new ArrayList() : list3);
    }

    public final List<AtomicProcessingTask> getChildren() {
        return this.children;
    }

    public final RecaseRule getRecaseRule() {
        return this.recaseRule;
    }

    public final void setRecaseRule(RecaseRule recaseRule) {
        this.recaseRule = recaseRule;
    }

    public final PlaceholderStorage getPlaceholderStorage() {
        return this.placeholderStorage;
    }

    public final void setPlaceholderStorage(PlaceholderStorage placeholderStorage) {
        this.placeholderStorage = placeholderStorage;
    }

    public final TagStorage getTagStorage() {
        return this.tagStorage;
    }

    public final void setTagStorage(TagStorage tagStorage) {
        this.tagStorage = tagStorage;
    }

    public final List<TagNode> getEncloseTags() {
        return this.encloseTags;
    }

    public final void setEncloseTags(List<TagNode> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.encloseTags = list;
    }

    public final TagNode getTagNode() {
        return this.tagNode;
    }

    public final void setTagNode(TagNode tagNode) {
        this.tagNode = tagNode;
    }

    public final String getHonorificTag() {
        return this.honorificTag;
    }

    public final void setHonorificTag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.honorificTag = str;
    }

    public final String getPivotResult() {
        return this.pivotResult;
    }

    public final void setPivotResult(String str) {
        this.pivotResult = str;
    }

    public final List<FormattingRules> getFormattingRules() {
        return this.formattingRules;
    }

    public final void setFormattingRules(List<FormattingRules> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.formattingRules = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AtomicProcessingTask createChild(String currentText) {
        Intrinsics.checkNotNullParameter(currentText, "currentText");
        AtomicProcessingTask copy$default = copy$default(this, null, null, currentText, false, false, JsonProperty.USE_DEFAULT_NAME, new ArrayList(), null, null, new TagStorage(null, 1, 0 == true ? 1 : 0), new ArrayList(), null, null, null, null, 31131, null);
        this.children.add(copy$default);
        return copy$default;
    }

    public final boolean isLeaf() {
        return this.children.isEmpty();
    }
}
