package io.grpc.perfmark;

import io.grpc.perfmark.PerfTag;

/* loaded from: classes2.dex */
public final class InternalPerfMark {
    private static final long NULL_NUMERIC_TAG = 0;
    private static final String NULL_STRING_TAG = null;

    /* loaded from: classes2.dex */
    public static abstract class InternalPerfMarkTask extends PerfMarkTask {
    }

    private InternalPerfMark() {
    }

    public static PerfTag createPerfTag(long j) {
        return PerfTag.TagFactory.create(j, NULL_STRING_TAG);
    }

    public static PerfTag createPerfTag(long j, String str) {
        return PerfTag.TagFactory.create(j, str);
    }

    public static PerfTag createPerfTag(String str) {
        return PerfTag.TagFactory.create(0L, str);
    }
}
