package io.grpc.perfmark;

import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes2.dex */
public final class PerfTag {
    private static final long NULL_NUMERIC_TAG = 0;
    private static final String NULL_STRING_TAG = null;
    private final long numericTag;
    private final String stringTag;

    /* loaded from: classes2.dex */
    static final class TagFactory {
        private TagFactory() {
            throw new AssertionError("nope");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static PerfTag a() {
            return new PerfTag(0L, PerfTag.NULL_STRING_TAG);
        }

        public static PerfTag create(long j) {
            return new PerfTag(j, PerfTag.NULL_STRING_TAG);
        }

        public static PerfTag create(long j, String str) {
            return new PerfTag(j, str);
        }

        public static PerfTag create(String str) {
            return new PerfTag(0L, str);
        }
    }

    private PerfTag(long j, @Nullable String str) {
        this.numericTag = j;
        this.stringTag = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PerfTag)) {
            return false;
        }
        PerfTag perfTag = (PerfTag) obj;
        if (this.numericTag != perfTag.numericTag) {
            return false;
        }
        String str = this.stringTag;
        String str2 = perfTag.stringTag;
        return str == str2 || (str != null && str.equals(str2));
    }

    public long getNumericTag() {
        return this.numericTag;
    }

    @Nullable
    public String getStringTag() {
        return this.stringTag;
    }

    public int hashCode() {
        long j = this.numericTag;
        int i = (int) (j ^ (j >>> 32));
        String str = this.stringTag;
        return i + (str != null ? str.hashCode() : 31);
    }

    public String toString() {
        return "Tag(numericTag=" + this.numericTag + ",stringTag='" + this.stringTag + "')";
    }
}
