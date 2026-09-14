package com.samsung.sr.nmt.t2t.translator.core.utils;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RawFileDescriptor.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0001J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/samsung/sr/nmt/t2t/translator/core/utils/RawFileDescriptor;", "Ljava/io/Closeable;", "fileDescriptorContainer", "Lcom/samsung/sr/nmt/t2t/translator/core/utils/FileDescriptorContainer;", "offSet", JsonProperty.USE_DEFAULT_NAME, "length", "(Lcom/samsung/sr/nmt/t2t/translator/core/utils/FileDescriptorContainer;JJ)V", "getFileDescriptorContainer", "()Lcom/samsung/sr/nmt/t2t/translator/core/utils/FileDescriptorContainer;", "getLength", "()J", "setLength", "(J)V", "getOffSet", "setOffSet", "close", JsonProperty.USE_DEFAULT_NAME, "component1", "component2", "component3", "copy", "equals", JsonProperty.USE_DEFAULT_NAME, "other", JsonProperty.USE_DEFAULT_NAME, "hashCode", JsonProperty.USE_DEFAULT_NAME, "toString", JsonProperty.USE_DEFAULT_NAME, "translator-core"}, k = 1, mv = {1, 9, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
/* loaded from: classes.dex */
public final /* data */ class RawFileDescriptor implements Closeable {
    private final FileDescriptorContainer fileDescriptorContainer;
    private long length;
    private long offSet;

    public static /* synthetic */ RawFileDescriptor copy$default(RawFileDescriptor rawFileDescriptor, FileDescriptorContainer fileDescriptorContainer, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            fileDescriptorContainer = rawFileDescriptor.fileDescriptorContainer;
        }
        if ((i & 2) != 0) {
            j = rawFileDescriptor.offSet;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            j2 = rawFileDescriptor.length;
        }
        return rawFileDescriptor.copy(fileDescriptorContainer, j3, j2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.fileDescriptorContainer.close();
    }

    /* renamed from: component1, reason: from getter */
    public final FileDescriptorContainer getFileDescriptorContainer() {
        return this.fileDescriptorContainer;
    }

    /* renamed from: component2, reason: from getter */
    public final long getOffSet() {
        return this.offSet;
    }

    /* renamed from: component3, reason: from getter */
    public final long getLength() {
        return this.length;
    }

    public final RawFileDescriptor copy(FileDescriptorContainer fileDescriptorContainer, long offSet, long length) {
        Intrinsics.checkNotNullParameter(fileDescriptorContainer, "fileDescriptorContainer");
        return new RawFileDescriptor(fileDescriptorContainer, offSet, length);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RawFileDescriptor)) {
            return false;
        }
        RawFileDescriptor rawFileDescriptor = (RawFileDescriptor) other;
        return Intrinsics.areEqual(this.fileDescriptorContainer, rawFileDescriptor.fileDescriptorContainer) && this.offSet == rawFileDescriptor.offSet && this.length == rawFileDescriptor.length;
    }

    public int hashCode() {
        return (((this.fileDescriptorContainer.hashCode() * 31) + Long.hashCode(this.offSet)) * 31) + Long.hashCode(this.length);
    }

    public String toString() {
        return "RawFileDescriptor(fileDescriptorContainer=" + this.fileDescriptorContainer + ", offSet=" + this.offSet + ", length=" + this.length + ")";
    }

    public RawFileDescriptor(FileDescriptorContainer fileDescriptorContainer, long j, long j2) {
        Intrinsics.checkNotNullParameter(fileDescriptorContainer, "fileDescriptorContainer");
        this.fileDescriptorContainer = fileDescriptorContainer;
        this.offSet = j;
        this.length = j2;
    }

    public final FileDescriptorContainer getFileDescriptorContainer() {
        return this.fileDescriptorContainer;
    }

    public final long getOffSet() {
        return this.offSet;
    }

    public final void setOffSet(long j) {
        this.offSet = j;
    }

    public final long getLength() {
        return this.length;
    }

    public final void setLength(long j) {
        this.length = j;
    }
}
