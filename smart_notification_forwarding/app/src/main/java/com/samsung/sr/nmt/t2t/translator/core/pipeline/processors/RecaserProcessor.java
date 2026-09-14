package com.samsung.sr.nmt.t2t.translator.core.pipeline.processors;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.AllUppercaseRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.AllUppercaseWithWhitespacesRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.CamelcaseRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.FirstLetterUppercaseRule;
import com.samsung.sr.nmt.t2t.translator.core.pipeline.recaser.RecaseRule;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* compiled from: RecaserProcessor.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B4\b\u0007\u0012\u001b\u0010\u0002\u001a\u0017\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006\u0012\u000e\b\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/RecaserProcessor;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/Processor;", "recaseRuleMap", JsonProperty.USE_DEFAULT_NAME, "Ljava/lang/Class;", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/recaser/RecaseRule;", "Lkotlin/jvm/JvmSuppressWildcards;", "noCaseDistinctLanguages", JsonProperty.USE_DEFAULT_NAME, JsonProperty.USE_DEFAULT_NAME, "(Ljava/util/Map;Ljava/util/Set;)V", "recaseRuleList", JsonProperty.USE_DEFAULT_NAME, "fixCasing", JsonProperty.USE_DEFAULT_NAME, "task", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/AtomicProcessingTask;", "process", "job", "Lcom/samsung/sr/nmt/t2t/translator/core/pipeline/processors/ProcessorJob;", "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class RecaserProcessor extends Processor {
    private final Set<String> noCaseDistinctLanguages;
    private final List<RecaseRule> recaseRuleList;

    @Inject
    public RecaserProcessor(Map<Class<?>, RecaseRule> recaseRuleMap, @Named("no-case-distinct-languages") Set<String> noCaseDistinctLanguages) {
        Intrinsics.checkNotNullParameter(recaseRuleMap, "recaseRuleMap");
        Intrinsics.checkNotNullParameter(noCaseDistinctLanguages, "noCaseDistinctLanguages");
        this.noCaseDistinctLanguages = noCaseDistinctLanguages;
        RecaseRule[] recaseRuleArr = new RecaseRule[4];
        RecaseRule recaseRule = recaseRuleMap.get(AllUppercaseWithWhitespacesRule.class);
        if (recaseRule == null) {
            throw new IllegalStateException("Failed to load recase rule.".toString());
        }
        recaseRuleArr[0] = recaseRule;
        RecaseRule recaseRule2 = recaseRuleMap.get(AllUppercaseRule.class);
        if (recaseRule2 == null) {
            throw new IllegalStateException("Failed to load recase rule.".toString());
        }
        recaseRuleArr[1] = recaseRule2;
        RecaseRule recaseRule3 = recaseRuleMap.get(CamelcaseRule.class);
        if (recaseRule3 == null) {
            throw new IllegalStateException("Failed to load recase rule.".toString());
        }
        recaseRuleArr[2] = recaseRule3;
        RecaseRule recaseRule4 = recaseRuleMap.get(FirstLetterUppercaseRule.class);
        if (recaseRule4 != null) {
            recaseRuleArr[3] = recaseRule4;
            this.recaseRuleList = CollectionsKt.listOf((Object[]) recaseRuleArr);
            return;
        }
        throw new IllegalStateException("Failed to load recase rule.".toString());
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.Processor
    protected void process(ProcessorJob job) {
        Intrinsics.checkNotNullParameter(job, "job");
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        job.withJob(simpleName, new Function1<ProcessorJob, Unit>() { // from class: com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.RecaserProcessor$process$1
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
                Intrinsics.checkNotNullParameter(currentJob, "currentJob");
                List<ProcessingTask> tasks = currentJob.getTasks();
                RecaserProcessor recaserProcessor = RecaserProcessor.this;
                Iterator<T> it = tasks.iterator();
                while (it.hasNext()) {
                    for (AtomicProcessingTask atomicProcessingTask : ((ProcessingTask) it.next()).getLeaves()) {
                        if (atomicProcessingTask.isLeaf() && !atomicProcessingTask.isFinished()) {
                            recaserProcessor.fixCasing(atomicProcessingTask);
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fixCasing(AtomicProcessingTask task) {
        String str;
        String currentText = task.getCurrentText();
        Locale forLanguageTag = Locale.forLanguageTag(task.getSourceLanguage());
        Intrinsics.checkNotNullExpressionValue(forLanguageTag, "forLanguageTag(...)");
        String lowerCase = currentText.toLowerCase(forLanguageTag);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        if (lowerCase.length() > 0) {
            StringBuilder sb = new StringBuilder();
            char charAt = lowerCase.charAt(0);
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            StringBuilder append = sb.append((Object) CharsKt.titlecase(charAt, locale));
            String substring = lowerCase.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            str = append.append(substring).toString();
        } else {
            str = lowerCase;
        }
        if (task.getCurrentText().equals(str) || task.getCurrentText().equals(lowerCase)) {
            return;
        }
        for (RecaseRule recaseRule : this.recaseRuleList) {
            if (recaseRule.isApplicable(task.getCurrentText()) && !this.noCaseDistinctLanguages.contains(task.getSourceLanguage())) {
                task.setCurrentText(recaseRule.apply(task.getCurrentText(), recaseRule.getLocale(task.getSourceLanguage())));
                task.setRecaseRule(recaseRule);
            }
        }
    }
}
