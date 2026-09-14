package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.samsung.sr.nmt.t2t.translator.core.pipeline.processors.formatting.rule.RuleUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

/* compiled from: ReflectKotlinClassFinder.kt */
/* loaded from: classes2.dex */
public final class ReflectKotlinClassFinderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String toRuntimeFqName(ClassId classId) {
        String asString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(asString, "relativeClassName.asString()");
        String replace$default = StringsKt.replace$default(asString, RuleUtils.DOT, Typography.dollar, false, 4, (Object) null);
        return classId.getPackageFqName().isRoot() ? replace$default : classId.getPackageFqName() + RuleUtils.DOT + replace$default;
    }
}
