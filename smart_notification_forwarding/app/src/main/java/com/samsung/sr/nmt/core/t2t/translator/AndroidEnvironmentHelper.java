package com.samsung.sr.nmt.core.t2t.translator;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AndroidEnvironmentHelper.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/AndroidEnvironmentHelper;", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/EnvironmentHelper;", "modelName", JsonProperty.USE_DEFAULT_NAME, "usingInputStreamInsteadDescriptor", JsonProperty.USE_DEFAULT_NAME, "(Ljava/lang/String;Z)V", "isExynosCpu", "isUsingInputStreamInsteadDescriptor", "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidEnvironmentHelper implements EnvironmentHelper {
    private final String modelName;
    private final boolean usingInputStreamInsteadDescriptor;

    public AndroidEnvironmentHelper(String modelName, boolean usingInputStreamInsteadDescriptor) {
        this.modelName = modelName;
        this.usingInputStreamInsteadDescriptor = usingInputStreamInsteadDescriptor;
    }

    public /* synthetic */ AndroidEnvironmentHelper(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper
    public boolean isExynosCpu() {
        System.out.println((Object) this.modelName);
        return true;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.utils.EnvironmentHelper
    /* renamed from: isUsingInputStreamInsteadDescriptor, reason: from getter */
    public boolean getUsingInputStreamInsteadDescriptor() {
        return this.usingInputStreamInsteadDescriptor;
    }
}
