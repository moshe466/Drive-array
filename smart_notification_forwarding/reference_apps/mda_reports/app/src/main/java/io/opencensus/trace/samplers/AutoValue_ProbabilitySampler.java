package io.opencensus.trace.samplers;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AutoValue_ProbabilitySampler extends ProbabilitySampler {
    private final long idUpperBound;
    private final double probability;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_ProbabilitySampler(double d, long j) {
        this.probability = d;
        this.idUpperBound = j;
    }

    @Override // io.opencensus.trace.samplers.ProbabilitySampler
    long a() {
        return this.idUpperBound;
    }

    @Override // io.opencensus.trace.samplers.ProbabilitySampler
    double b() {
        return this.probability;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProbabilitySampler)) {
            return false;
        }
        ProbabilitySampler probabilitySampler = (ProbabilitySampler) obj;
        return Double.doubleToLongBits(this.probability) == Double.doubleToLongBits(probabilitySampler.b()) && this.idUpperBound == probabilitySampler.a();
    }

    public int hashCode() {
        long doubleToLongBits = ((int) (1000003 ^ ((Double.doubleToLongBits(this.probability) >>> 32) ^ Double.doubleToLongBits(this.probability)))) * 1000003;
        long j = this.idUpperBound;
        return (int) (doubleToLongBits ^ (j ^ (j >>> 32)));
    }

    public String toString() {
        return "ProbabilitySampler{probability=" + this.probability + ", idUpperBound=" + this.idUpperBound + "}";
    }
}
