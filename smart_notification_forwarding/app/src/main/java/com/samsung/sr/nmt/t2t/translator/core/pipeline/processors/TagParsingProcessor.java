package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagData;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: TagParsingProcessor.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u001e\u0010\t\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J&\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J&\u0010\u0018\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J&\u0010\u0019\u001a\u00020\u00142\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u001e\u0010\u001b\u001a\u00020\u00062\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d2\u0006\u0010\u0017\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TagParsingProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "unpairedTagsRegex", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;", "(Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;)V", "getRootNode", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagNode;", "stack", "Ljava/util/Stack;", "groupTagNode", JsonProperty.USE_DEFAULT_NAME, "closedTagName", JsonProperty.USE_DEFAULT_NAME, "normalizeSpace", "text", "process", JsonProperty.USE_DEFAULT_NAME, "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "processIllegalCaseAsText", JsonProperty.USE_DEFAULT_NAME, "index", "processLayeredTags", "root", "processLeftTag", "processTextNode", "removeComments", "removeEncloseTags", "encloseTags", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TagParsingProcessor extends Processor {
    private final SymbolRegex unpairedTagsRegex;

    @Inject
    public TagParsingProcessor(@Named("UnpairedTagsRegex") SymbolRegex unpairedTagsRegex) {
        Intrinsics.checkNotNullParameter(unpairedTagsRegex, "unpairedTagsRegex");
        this.unpairedTagsRegex = unpairedTagsRegex;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagParsingProcessor$process$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProcessorJob processorJob) {
                invoke2(processorJob);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v11 */
            /* JADX WARN: Type inference failed for: r7v4, types: [kotlin.Unit] */
            /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
            /* JADX WARN: Type inference failed for: r7v6, types: [com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagNode] */
            /* JADX WARN: Type inference failed for: r7v7 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProcessorJob currentJob) {
                String removeComments;
                String normalizeSpace;
                TagNode rootNode;
                ?? r7;
                TagNode removeEncloseTags;
                SymbolRegex symbolRegex;
                boolean groupTagNode;
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                List<ProcessingTask> tasks = currentJob.getTasks();
                TagParsingProcessor tagParsingProcessor = TagParsingProcessor.this;
                Iterator it = tasks.iterator();
                while (it.hasNext()) {
                    List<AtomicProcessingTask> leaves = ((ProcessingTask) it.next()).getLeaves();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : leaves) {
                        if (true ^ ((AtomicProcessingTask) obj).isFinished()) {
                            arrayList.add(obj);
                        }
                    }
                    ArrayList<AtomicProcessingTask> arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    for (AtomicProcessingTask atomicProcessingTask : arrayList2) {
                        removeComments = tagParsingProcessor.removeComments(atomicProcessingTask.getCurrentText());
                        normalizeSpace = tagParsingProcessor.normalizeSpace(removeComments);
                        Stack stack = new Stack();
                        int i = 0;
                        while (!atomicProcessingTask.isFinished() && i < normalizeSpace.length()) {
                            if (normalizeSpace.charAt(i) != '<') {
                                i = tagParsingProcessor.processTextNode(stack, normalizeSpace, i);
                            } else {
                                int i2 = i + 1;
                                if (i2 >= normalizeSpace.length() || normalizeSpace.charAt(i2) != '/') {
                                    i = tagParsingProcessor.processLeftTag(stack, normalizeSpace, i2);
                                } else {
                                    int indexOf$default = StringsKt.indexOf$default((CharSequence) normalizeSpace, Typography.greater, i2, false, 4, (Object) null);
                                    if (indexOf$default == -1) {
                                        i = tagParsingProcessor.processIllegalCaseAsText(i2, normalizeSpace, stack);
                                    } else {
                                        String substring = normalizeSpace.substring(i2, indexOf$default);
                                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                                        symbolRegex = tagParsingProcessor.unpairedTagsRegex;
                                        if (symbolRegex.getRegexCompiled().matches(substring)) {
                                            stack.push(new TagNode(new TagData(substring, null, null, 6, null), null, false, null, 10, null));
                                        } else {
                                            String substring2 = substring.substring(1);
                                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                                            groupTagNode = tagParsingProcessor.groupTagNode(stack, substring2);
                                            atomicProcessingTask.setFinished(!groupTagNode);
                                        }
                                        i = indexOf$default + 1;
                                    }
                                }
                            }
                        }
                        rootNode = tagParsingProcessor.getRootNode(stack);
                        if (rootNode != null) {
                            r7 = rootNode;
                            if (!(!atomicProcessingTask.isFinished())) {
                                r7 = 0;
                            }
                            if (r7 != 0) {
                                removeEncloseTags = tagParsingProcessor.removeEncloseTags(atomicProcessingTask.getEncloseTags(), r7);
                                atomicProcessingTask.setTagNode(removeEncloseTags);
                                TagNode tagNode = atomicProcessingTask.getTagNode();
                                if (tagNode != null) {
                                    tagParsingProcessor.processLayeredTags(tagNode);
                                }
                                if (r7 != 0) {
                                    arrayList3.add(r7);
                                }
                            }
                        }
                        atomicProcessingTask.setFinished(true);
                        r7 = Unit.INSTANCE;
                        arrayList3.add(r7);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean groupTagNode(Stack<TagNode> stack, String closedTagName) {
        ArrayList arrayList = new ArrayList();
        while (!stack.isEmpty()) {
            TagNode pop = stack.pop();
            TagData tagData = pop.getTagData();
            if (Intrinsics.areEqual(tagData != null ? tagData.getTagName() : null, closedTagName) && !pop.getHasBeenClosed()) {
                stack.push(new TagNode(pop.getTagData(), null, false, CollectionsKt.asReversedMutable(arrayList), 6, null));
                return true;
            }
            Intrinsics.checkNotNull(pop);
            arrayList.add(pop);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int processLeftTag(Stack<TagNode> stack, String text, int index) {
        String str = text;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, Typography.greater, index, false, 4, (Object) null);
        if (indexOf$default == -1) {
            return processIllegalCaseAsText(index, text, stack);
        }
        int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, ' ', index, false, 4, (Object) null);
        if (indexOf$default2 != -1 && indexOf$default2 < indexOf$default) {
            String substring = text.substring(index, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            String substring2 = text.substring(indexOf$default2 + 1, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            stack.push(new TagNode(new TagData(substring, substring2, null, 4, null), null, false, null, 10, null));
        } else {
            String substring3 = text.substring(index, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
            stack.push(new TagNode(new TagData(substring3, null, null, 6, null), null, false, null, 10, null));
        }
        return indexOf$default + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int processTextNode(Stack<TagNode> stack, String text, int index) {
        String substring;
        int indexOf$default = StringsKt.indexOf$default((CharSequence) text, Typography.less, index, false, 4, (Object) null);
        if (indexOf$default == -1) {
            substring = text.substring(index);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        } else {
            substring = text.substring(index, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        if (substring.length() > 0) {
            stack.push(new TagNode(null, substring, false, null, 13, null));
        }
        return index + substring.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int processIllegalCaseAsText(int index, String text, Stack<TagNode> stack) {
        int i = index - 1;
        int i2 = index + 1;
        String substring = text.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        stack.push(new TagNode(null, substring, false, null, 13, null));
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TagNode getRootNode(Stack<TagNode> stack) {
        String tagName;
        ArrayList arrayList = new ArrayList();
        while (!stack.isEmpty()) {
            TagNode pop = stack.pop();
            if (!pop.getHasBeenClosed()) {
                TagData tagData = pop.getTagData();
                boolean z = false;
                if (tagData != null && (tagName = tagData.getTagName()) != null) {
                    if (this.unpairedTagsRegex.getRegexCompiled().matches(tagName)) {
                        z = true;
                    }
                }
                if (!z) {
                    stack.clear();
                    return null;
                }
            }
            Intrinsics.checkNotNull(pop);
            arrayList.add(pop);
        }
        return new TagNode(new TagData("root", null, null, 6, null), null, false, CollectionsKt.asReversedMutable(arrayList), 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processLayeredTags(TagNode root) {
        while (root.getTagData() != null && root.getChildren().size() == 1 && ((TagNode) CollectionsKt.first((List) root.getChildren())).getTagData() != null) {
            TagData tagData = root.getTagData();
            if (tagData != null) {
                tagData.addInnerTag(((TagNode) CollectionsKt.first((List) root.getChildren())).getTagData());
            }
            List<TagNode> children = ((TagNode) CollectionsKt.first((List) root.getChildren())).getChildren();
            root.getChildren().clear();
            root.getChildren().addAll(children);
        }
        Iterator<T> it = root.getChildren().iterator();
        while (it.hasNext()) {
            processLayeredTags((TagNode) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TagNode removeEncloseTags(List<TagNode> encloseTags, TagNode root) {
        while (true) {
            if (root.getChildren().size() != 1) {
                return root;
            }
            root = (TagNode) CollectionsKt.first((List) root.getChildren());
            TagNode tagNode = root.getTagData() != null ? root : null;
            if (tagNode != null) {
                encloseTags.add(tagNode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String removeComments(String text) {
        int indexOf$default;
        int i = 0;
        while (i != -1) {
            String str = text;
            int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str, "<!--", 0, false, 6, (Object) null);
            if (indexOf$default2 != -1 && (indexOf$default = StringsKt.indexOf$default((CharSequence) str, "-->", 0, false, 6, (Object) null)) != -1) {
                text = StringsKt.replaceRange((CharSequence) str, indexOf$default2, indexOf$default + 3, (CharSequence) JsonProperty.USE_DEFAULT_NAME).toString();
            }
            i = indexOf$default2;
        }
        return text;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizeSpace(String text) {
        return new Regex("\\s((<[^/][^>]*>)+)").replace(text, "$1 ");
    }
}
