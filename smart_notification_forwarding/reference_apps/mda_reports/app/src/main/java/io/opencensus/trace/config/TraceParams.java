package io.opencensus.trace.config;

import io.opencensus.internal.Utils;
import io.opencensus.trace.Sampler;
import io.opencensus.trace.config.AutoValue_TraceParams;
import io.opencensus.trace.samplers.Samplers;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes2.dex */
public abstract class TraceParams {
    private static final int DEFAULT_SPAN_MAX_NUM_ANNOTATIONS = 32;
    private static final int DEFAULT_SPAN_MAX_NUM_ATTRIBUTES = 32;
    private static final int DEFAULT_SPAN_MAX_NUM_LINKS = 32;
    private static final int DEFAULT_SPAN_MAX_NUM_MESSAGE_EVENTS = 128;
    private static final double DEFAULT_PROBABILITY = 1.0E-4d;
    private static final Sampler DEFAULT_SAMPLER = Samplers.probabilitySampler(DEFAULT_PROBABILITY);
    public static final TraceParams DEFAULT = builder().setSampler(DEFAULT_SAMPLER).setMaxNumberOfAttributes(32).setMaxNumberOfAnnotations(32).setMaxNumberOfMessageEvents(128).setMaxNumberOfLinks(32).build();

    /* loaded from: classes2.dex */
    public static abstract class Builder {
        abstract TraceParams a();

        public TraceParams build() {
            TraceParams a = a();
            Utils.checkArgument(a.getMaxNumberOfAttributes() > 0, "maxNumberOfAttributes");
            Utils.checkArgument(a.getMaxNumberOfAnnotations() > 0, "maxNumberOfAnnotations");
            Utils.checkArgument(a.getMaxNumberOfMessageEvents() > 0, "maxNumberOfMessageEvents");
            Utils.checkArgument(a.getMaxNumberOfLinks() > 0, "maxNumberOfLinks");
            return a;
        }

        public abstract Builder setMaxNumberOfAnnotations(int i);

        public abstract Builder setMaxNumberOfAttributes(int i);

        public abstract Builder setMaxNumberOfLinks(int i);

        public abstract Builder setMaxNumberOfMessageEvents(int i);

        @Deprecated
        public Builder setMaxNumberOfNetworkEvents(int i) {
            return setMaxNumberOfMessageEvents(i);
        }

        public abstract Builder setSampler(Sampler sampler);
    }

    private static Builder builder() {
        return new AutoValue_TraceParams.Builder();
    }

    public abstract int getMaxNumberOfAnnotations();

    public abstract int getMaxNumberOfAttributes();

    public abstract int getMaxNumberOfLinks();

    public abstract int getMaxNumberOfMessageEvents();

    @Deprecated
    public int getMaxNumberOfNetworkEvents() {
        return getMaxNumberOfMessageEvents();
    }

    public abstract Sampler getSampler();

    public abstract Builder toBuilder();
}
