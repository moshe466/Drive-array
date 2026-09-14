package io.opencensus.trace.export;

import io.opencensus.trace.export.RunningSpanStore;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class AutoValue_RunningSpanStore_Summary extends RunningSpanStore.Summary {
    private final Map<String, RunningSpanStore.PerSpanNameSummary> perSpanNameSummary;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_RunningSpanStore_Summary(Map<String, RunningSpanStore.PerSpanNameSummary> map) {
        if (map == null) {
            throw new NullPointerException("Null perSpanNameSummary");
        }
        this.perSpanNameSummary = map;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RunningSpanStore.Summary) {
            return this.perSpanNameSummary.equals(((RunningSpanStore.Summary) obj).getPerSpanNameSummary());
        }
        return false;
    }

    @Override // io.opencensus.trace.export.RunningSpanStore.Summary
    public Map<String, RunningSpanStore.PerSpanNameSummary> getPerSpanNameSummary() {
        return this.perSpanNameSummary;
    }

    public int hashCode() {
        return this.perSpanNameSummary.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Summary{perSpanNameSummary=" + this.perSpanNameSummary + "}";
    }
}
