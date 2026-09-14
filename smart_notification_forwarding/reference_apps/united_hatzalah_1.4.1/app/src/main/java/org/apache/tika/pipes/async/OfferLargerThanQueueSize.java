package org.apache.tika.pipes.async;

/* loaded from: classes.dex */
public class OfferLargerThanQueueSize extends IllegalArgumentException {
    private final int queueSize;
    private final int sizeOffered;

    public OfferLargerThanQueueSize(int i, int i3) {
        this.sizeOffered = i;
        this.queueSize = i3;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "sizeOffered (" + this.sizeOffered + ") is greater than queue size (" + this.queueSize + ")";
    }

    public int getQueueSize() {
        return this.queueSize;
    }

    public int getSizeOffered() {
        return this.sizeOffered;
    }
}
