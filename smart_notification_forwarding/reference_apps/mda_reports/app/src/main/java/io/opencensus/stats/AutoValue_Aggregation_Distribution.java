package io.opencensus.stats;

import io.opencensus.stats.Aggregation;

/* loaded from: classes2.dex */
final class AutoValue_Aggregation_Distribution extends Aggregation.Distribution {
    private final BucketBoundaries bucketBoundaries;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_Aggregation_Distribution(BucketBoundaries bucketBoundaries) {
        if (bucketBoundaries == null) {
            throw new NullPointerException("Null bucketBoundaries");
        }
        this.bucketBoundaries = bucketBoundaries;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Aggregation.Distribution) {
            return this.bucketBoundaries.equals(((Aggregation.Distribution) obj).getBucketBoundaries());
        }
        return false;
    }

    @Override // io.opencensus.stats.Aggregation.Distribution
    public BucketBoundaries getBucketBoundaries() {
        return this.bucketBoundaries;
    }

    public int hashCode() {
        return this.bucketBoundaries.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Distribution{bucketBoundaries=" + this.bucketBoundaries + "}";
    }
}
