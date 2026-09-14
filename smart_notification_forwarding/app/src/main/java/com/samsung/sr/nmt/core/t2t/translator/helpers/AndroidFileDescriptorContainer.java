package com.samsung.sr.nmt.core.t2t.translator.helpers;

import android.os.ParcelFileDescriptor;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.samsung.sr.nmt.t2t.translator.core.utils.FileDescriptorContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidFileDescriptorContainer.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/samsung/sr/nmt/core/t2t/translator/helpers/AndroidFileDescriptorContainer;", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/FileDescriptorContainer;", "parcelFileDescriptor", "Landroid/os/ParcelFileDescriptor;", "(Landroid/os/ParcelFileDescriptor;)V", "fd", JsonProperty.USE_DEFAULT_NAME, "getFd", "()I", "close", JsonProperty.USE_DEFAULT_NAME, "translator_release"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final class AndroidFileDescriptorContainer implements FileDescriptorContainer {
    private final ParcelFileDescriptor parcelFileDescriptor;

    public AndroidFileDescriptorContainer(ParcelFileDescriptor parcelFileDescriptor) {
        Intrinsics.checkNotNullParameter(parcelFileDescriptor, "parcelFileDescriptor");
        this.parcelFileDescriptor = parcelFileDescriptor;
    }

    @Override // com.samsung.sr.nmt.t2t.translator.core.utils.FileDescriptorContainer
    public int getFd() {
        return this.parcelFileDescriptor.getFd();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.parcelFileDescriptor.close();
    }
}
