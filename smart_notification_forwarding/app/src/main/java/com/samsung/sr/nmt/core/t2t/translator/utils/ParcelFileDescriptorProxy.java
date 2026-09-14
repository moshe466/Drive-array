package com.samsung.sr.nmt.core.t2t.translator.utils;

import android.os.ParcelFileDescriptor;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParcelFileDescriptorProxy.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/utils/ParcelFileDescriptorProxy;", JsonProperty.USE_DEFAULT_NAME, "()V", "open", "Landroid/os/ParcelFileDescriptor;", "file", "Ljava/io/File;", "mode", JsonProperty.USE_DEFAULT_NAME, "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class ParcelFileDescriptorProxy {
    public final ParcelFileDescriptor open(File file, int mode) {
        Intrinsics.checkNotNullParameter(file, "file");
        ParcelFileDescriptor open = ParcelFileDescriptor.open(file, mode);
        Intrinsics.checkNotNullExpressionValue(open, "open(...)");
        return open;
    }
}
