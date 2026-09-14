package org.apache.tika.pipes.pipesiterator;

/* loaded from: classes.dex */
public class TotalCountResult {
    public static TotalCountResult UNSUPPORTED = new TotalCountResult(-1, STATUS.UNSUPPORTED);
    private STATUS status;
    private long totalCount;

    /* loaded from: classes.dex */
    public enum STATUS {
        UNSUPPORTED,
        EXCEPTION,
        NOT_COMPLETED,
        COMPLETED
    }

    public TotalCountResult() {
        this.totalCount = 0L;
        this.status = STATUS.NOT_COMPLETED;
    }

    public STATUS getStatus() {
        return this.status;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public String toString() {
        return "TotalCountResult{totalCount=" + this.totalCount + ", status=" + this.status + "}";
    }

    public TotalCountResult(long j2, STATUS status) {
        this.totalCount = j2;
        this.status = status;
    }
}
