package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.CharBasedSentenceSplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.EndOfLineSplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.splitter.SplitRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagData;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagNode;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagStorage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TagSubstituteProcessor.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B.\b\u0007\u0012\u001b\u0010\u0002\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00182\u0006\u0010\u0019\u001a\u00020\u000fH\u0002J6\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J6\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002J6\u0010!\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001bH\u0002R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/TagSubstituteProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "splitterRuleMap", JsonProperty.USE_DEFAULT_NAME, "Ljava/lang/Class;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/splitter/SplitRule;", "Lkotlin/jvm/JvmSuppressWildcards;", "unpairedTagsRegex", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;", "(Ljava/util/Map;Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/symbols/SymbolRegex;)V", "charBasedSentenceSplitRule", "endOfLineSplitRule", "addTextToLeaf", JsonProperty.USE_DEFAULT_NAME, "originalTask", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/AtomicProcessingTask;", "leaves", JsonProperty.USE_DEFAULT_NAME, "text", JsonProperty.USE_DEFAULT_NAME, "process", "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "splitTags", JsonProperty.USE_DEFAULT_NAME, "leaf", "splitTextIntoTasks", JsonProperty.USE_DEFAULT_NAME, "shouldHaveNewStart", "isBetweenTags", "splitTextWithNewLine", "root", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/tagged/TagNode;", "substituteTagsByTraversal", "Companion", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class TagSubstituteProcessor extends Processor {
    private static final int MAX_CHARS_PER_SENTENCE = 500;
    private final SplitRule charBasedSentenceSplitRule;
    private final SplitRule endOfLineSplitRule;
    private final SymbolRegex unpairedTagsRegex;

    @Inject
    public TagSubstituteProcessor(Map<Class<?>, SplitRule> splitterRuleMap, @Named("UnpairedTagsRegex") SymbolRegex unpairedTagsRegex) {
        Intrinsics.checkNotNullParameter(splitterRuleMap, "splitterRuleMap");
        Intrinsics.checkNotNullParameter(unpairedTagsRegex, "unpairedTagsRegex");
        this.unpairedTagsRegex = unpairedTagsRegex;
        SplitRule splitRule = splitterRuleMap.get(CharBasedSentenceSplitRule.class);
        if (splitRule == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        this.charBasedSentenceSplitRule = splitRule;
        SplitRule splitRule2 = splitterRuleMap.get(EndOfLineSplitRule.class);
        if (splitRule2 == null) {
            throw new IllegalStateException(JsonProperty.USE_DEFAULT_NAME.toString());
        }
        this.endOfLineSplitRule = splitRule2;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagSubstituteProcessor$process$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ProcessorJob processorJob) {
                invoke2(processorJob);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ProcessorJob currentJob) {
                List splitTags;
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                List<ProcessingTask> tasks = currentJob.getTasks();
                ArrayList<ProcessingTask> arrayList = new ArrayList();
                for (Object obj : tasks) {
                    if (!((ProcessingTask) obj).getRoot().isFinished()) {
                        arrayList.add(obj);
                    }
                }
                TagSubstituteProcessor tagSubstituteProcessor = TagSubstituteProcessor.this;
                for (ProcessingTask processingTask : arrayList) {
                    List<AtomicProcessingTask> leaves = processingTask.getLeaves();
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(leaves, 10));
                    Iterator<T> it = leaves.iterator();
                    while (it.hasNext()) {
                        splitTags = tagSubstituteProcessor.splitTags((AtomicProcessingTask) it.next());
                        arrayList2.add(splitTags);
                    }
                    processingTask.setLeaves(CollectionsKt.flatten(arrayList2));
                    processingTask.getRoot().setDelimiter(" ");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.AtomicProcessingTask> splitTags(com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.AtomicProcessingTask r12) {
        /*
            r11 = this;
            com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagStorage r0 = new com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagStorage
            com.samsung.sr.nmt.t2t.translator.core.pipeline.symbols.SymbolRegex r1 = r11.unpairedTagsRegex
            r0.<init>(r1)
            r12.setTagStorage(r0)
            java.lang.String r0 = ""
            r12.setCurrentText(r0)
            r1 = 1
            com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.AtomicProcessingTask[] r2 = new com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.AtomicProcessingTask[r1]
            com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.AtomicProcessingTask r0 = r12.createChild(r0)
            r3 = 0
            r2[r3] = r0
            java.util.List r0 = kotlin.collections.CollectionsKt.mutableListOf(r2)
            com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagNode r2 = r12.getTagNode()
            r10 = 0
            if (r2 == 0) goto L5c
            com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagData r4 = r2.getTagData()
            if (r4 == 0) goto L2c
            r4 = r1
            goto L2d
        L2c:
            r4 = r3
        L2d:
            if (r4 == 0) goto L30
            goto L31
        L30:
            r2 = r10
        L31:
            if (r2 == 0) goto L5c
            java.util.List r2 = r2.getChildren()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
            r8 = r3
        L3e:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L6d
            java.lang.Object r4 = r2.next()
            r6 = r4
            com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagNode r6 = (com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagNode) r6
            com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagData r4 = r6.getTagData()
            if (r4 == 0) goto L53
            r9 = r1
            goto L54
        L53:
            r9 = r3
        L54:
            r4 = r11
            r5 = r12
            r7 = r0
            boolean r8 = r4.substituteTagsByTraversal(r5, r6, r7, r8, r9)
            goto L3e
        L5c:
            r2 = r11
            com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagSubstituteProcessor r2 = (com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagSubstituteProcessor) r2
            com.samsung.sr.nmt.t2t.translator.core.pipeline.tagged.TagNode r6 = r12.getTagNode()
            if (r6 == 0) goto L6d
            r8 = 0
            r9 = 0
            r4 = r11
            r5 = r12
            r7 = r0
            r4.substituteTagsByTraversal(r5, r6, r7, r8, r9)
        L6d:
            java.lang.Object r12 = kotlin.collections.CollectionsKt.lastOrNull(r0)
            com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.AtomicProcessingTask r12 = (com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.AtomicProcessingTask) r12
            if (r12 == 0) goto L86
            java.lang.String r12 = r12.getCurrentText()
            if (r12 == 0) goto L86
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            int r12 = r12.length()
            if (r12 != 0) goto L84
            goto L85
        L84:
            r1 = r3
        L85:
            r3 = r1
        L86:
            if (r3 == 0) goto L89
            r10 = r0
        L89:
            if (r10 == 0) goto L91
            java.lang.Object r12 = kotlin.collections.CollectionsKt.removeLast(r10)
            com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.AtomicProcessingTask r12 = (com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.AtomicProcessingTask) r12
        L91:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.TagSubstituteProcessor.splitTags(com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.AtomicProcessingTask):java.util.List");
    }

    private final boolean substituteTagsByTraversal(AtomicProcessingTask originalTask, TagNode root, List<AtomicProcessingTask> leaves, boolean shouldHaveNewStart, boolean isBetweenTags) {
        boolean z;
        String keep;
        TagData tagData = root.getTagData();
        if (tagData != null) {
            if (shouldHaveNewStart) {
                leaves.add(originalTask.createChild(JsonProperty.USE_DEFAULT_NAME));
                z = false;
            } else {
                z = shouldHaveNewStart;
            }
            TagStorage tagStorage = ((AtomicProcessingTask) CollectionsKt.last((List) leaves)).getTagStorage();
            String str = (tagStorage == null || (keep = tagStorage.keep(tagData)) == null) ? JsonProperty.USE_DEFAULT_NAME : keep;
            addTextToLeaf(originalTask, leaves, "<" + str + ">");
            Iterator<T> it = root.getChildren().iterator();
            boolean z2 = z;
            while (it.hasNext()) {
                z2 = substituteTagsByTraversal(originalTask, (TagNode) it.next(), leaves, z2, isBetweenTags);
            }
            AtomicProcessingTask atomicProcessingTask = (AtomicProcessingTask) CollectionsKt.lastOrNull((List) leaves);
            if (Intrinsics.areEqual(tagStorage, atomicProcessingTask != null ? atomicProcessingTask.getTagStorage() : null)) {
                addTextToLeaf(originalTask, leaves, "</" + str + ">");
            } else {
                TagStorage tagStorage2 = ((AtomicProcessingTask) CollectionsKt.last((List) leaves)).getTagStorage();
                addTextToLeaf(originalTask, leaves, "</" + (tagStorage2 != null ? tagStorage2.keep(tagData) : null) + ">");
            }
            return z2;
        }
        return splitTextWithNewLine(originalTask, root, leaves, shouldHaveNewStart, isBetweenTags);
    }

    private final boolean splitTextWithNewLine(AtomicProcessingTask originalTask, TagNode root, List<AtomicProcessingTask> leaves, boolean shouldHaveNewStart, boolean isBetweenTags) {
        List<String> split = this.endOfLineSplitRule.split(root.getText());
        if (split.size() > 1) {
            AtomicProcessingTask createChild = originalTask.createChild(JsonProperty.USE_DEFAULT_NAME);
            String lineSeparator = System.lineSeparator();
            Intrinsics.checkNotNullExpressionValue(lineSeparator, "lineSeparator(...)");
            createChild.setDelimiter(lineSeparator);
            for (String str : split) {
                AtomicProcessingTask createChild2 = createChild.createChild(JsonProperty.USE_DEFAULT_NAME);
                createChild2.setDelimiter(" ");
                leaves.add(createChild2);
                splitTextIntoTasks(createChild2, str, leaves, shouldHaveNewStart, isBetweenTags);
            }
            return true;
        }
        return splitTextIntoTasks(originalTask, root.getText(), leaves, shouldHaveNewStart, isBetweenTags);
    }

    private final boolean splitTextIntoTasks(AtomicProcessingTask originalTask, String text, List<AtomicProcessingTask> leaves, boolean shouldHaveNewStart, boolean isBetweenTags) {
        String str = text;
        if (StringsKt.isBlank(str)) {
            addTextToLeaf(originalTask, leaves, text);
            return shouldHaveNewStart;
        }
        if (isBetweenTags) {
            addTextToLeaf(originalTask, leaves, text);
        } else {
            List<String> split = this.charBasedSentenceSplitRule.split(text);
            if (split.size() > 1) {
                addTextToLeaf(originalTask, leaves, (String) CollectionsKt.first((List) split));
                for (String str2 : split.subList(1, split.size())) {
                    leaves.add(originalTask.createChild(JsonProperty.USE_DEFAULT_NAME));
                    addTextToLeaf(originalTask, leaves, str2);
                    AtomicProcessingTask atomicProcessingTask = (AtomicProcessingTask) CollectionsKt.lastOrNull((List) leaves);
                    if (atomicProcessingTask != null) {
                        atomicProcessingTask.setTagStorage(new TagStorage(this.unpairedTagsRegex));
                    }
                }
            } else {
                addTextToLeaf(originalTask, leaves, text);
            }
        }
        return StringsKt.last(str) == '.' && !isBetweenTags;
    }

    private final void addTextToLeaf(AtomicProcessingTask originalTask, List<AtomicProcessingTask> leaves, String text) {
        AtomicProcessingTask atomicProcessingTask = (AtomicProcessingTask) CollectionsKt.last((List) leaves);
        atomicProcessingTask.setCurrentText(atomicProcessingTask.getCurrentText() + text);
        while (true) {
            int i = 500;
            if (((AtomicProcessingTask) CollectionsKt.last((List) leaves)).getCurrentText().length() <= 500) {
                return;
            }
            String currentText = ((AtomicProcessingTask) CollectionsKt.last((List) leaves)).getCurrentText();
            String substring = currentText.substring(0, 500);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) substring, ' ', 0, false, 6, (Object) null);
            if (lastIndexOf$default >= 0) {
                i = lastIndexOf$default;
            }
            AtomicProcessingTask atomicProcessingTask2 = (AtomicProcessingTask) CollectionsKt.last((List) leaves);
            String substring2 = currentText.substring(0, i);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            atomicProcessingTask2.setCurrentText(substring2);
            String substring3 = currentText.substring(i + 1);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
            leaves.add(originalTask.createChild(substring3));
            ((AtomicProcessingTask) CollectionsKt.last((List) leaves)).setTagStorage(new TagStorage(this.unpairedTagsRegex));
        }
    }
}
