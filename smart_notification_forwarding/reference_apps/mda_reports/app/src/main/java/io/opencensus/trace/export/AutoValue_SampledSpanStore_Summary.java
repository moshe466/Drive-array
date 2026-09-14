package io.opencensus.trace.export;

import io.opencensus.trace.export.SampledSpanStore;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AutoValue_SampledSpanStore_Summary extends SampledSpanStore.Summary {
    private final Map<String, SampledSpanStore.PerSpanNameSummary> perSpanNameSummary;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SampledSpanStore_Summary(Map<String, SampledSpanStore.PerSpanNameSummary> map) {
        if (map == null) {
            throw new NullPointerException("Null perSpanNameSummary");
        }
        this.perSpanNameSummary = map;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SampledSpanStore.Summary) {
            return this.perSpanNameSummary.equals(((SampledSpanStore.Summary) obj).getPerSpanNameSummary());
        }
        return false;
    }

    @Override // io.opencensus.trace.export.SampledSpanStore.Summary
    public Map<String, SampledSpanStore.PerSpanNameSummary> getPerSpanNameSummary() {
        return this.perSpanNameSummary;
    }

    public int hashCode() {
        return this.perSpanNameSummary.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Summary{perSpanNameSummary=" + this.perSpanNameSummary + "}";
    }
}
