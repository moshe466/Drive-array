package io.opencensus.stats;

import io.opencensus.metrics.data.Exemplar;
import io.opencensus.stats.AggregationData;
import java.util.List;

/* loaded from: classes2.dex */
final class AutoValue_AggregationData_DistributionData extends AggregationData.DistributionData {
    private final List<Long> bucketCounts;
    private final long count;
    private final List<Exemplar> exemplars;
    private final double mean;
    private final double sumOfSquaredDeviations;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_AggregationData_DistributionData(double d, long j, double d2, List<Long> list, List<Exemplar> list2) {
        this.mean = d;
        this.count = j;
        this.sumOfSquaredDeviations = d2;
        if (list == null) {
            throw new NullPointerException("Null bucketCounts");
        }
        this.bucketCounts = list;
        if (list2 == null) {
            throw new NullPointerException("Null exemplars");
        }
        this.exemplars = list2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AggregationData.DistributionData)) {
            return false;
        }
        AggregationData.DistributionData distributionData = (AggregationData.DistributionData) obj;
        return Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(distributionData.getMean()) && this.count == distributionData.getCount() && Double.doubleToLongBits(this.sumOfSquaredDeviations) == Double.doubleToLongBits(distributionData.getSumOfSquaredDeviations()) && this.bucketCounts.equals(distributionData.getBucketCounts()) && this.exemplars.equals(distributionData.getExemplars());
    }

    @Override // io.opencensus.stats.AggregationData.DistributionData
    public List<Long> getBucketCounts() {
        return this.bucketCounts;
    }

    @Override // io.opencensus.stats.AggregationData.DistributionData
    public long getCount() {
        return this.count;
    }

    @Override // io.opencensus.stats.AggregationData.DistributionData
    public List<Exemplar> getExemplars() {
        return this.exemplars;
    }

    @Override // io.opencensus.stats.AggregationData.DistributionData
    public double getMean() {
        return this.mean;
    }

    @Override // io.opencensus.stats.AggregationData.DistributionData
    public double getSumOfSquaredDeviations() {
        return this.sumOfSquaredDeviations;
    }

    public int hashCode() {
        long doubleToLongBits = ((int) (1000003 ^ ((Double.doubleToLongBits(this.mean) >>> 32) ^ Double.doubleToLongBits(this.mean)))) * 1000003;
        long j = this.count;
        return this.exemplars.hashCode() ^ ((this.bucketCounts.hashCode() ^ (((int) ((((int) (doubleToLongBits ^ (j ^ (j >>> 32)))) * 1000003) ^ ((Double.doubleToLongBits(this.sumOfSquaredDeviations) >>> 32) ^ Double.doubleToLongBits(this.sumOfSquaredDeviations)))) * 1000003)) * 1000003);
    }

    public String toString() {
        return "DistributionData{mean=" + this.mean + ", count=" + this.count + ", sumOfSquaredDeviations=" + this.sumOfSquaredDeviations + ", bucketCounts=" + this.bucketCounts + ", exemplars=" + this.exemplars + "}";
    }
}
