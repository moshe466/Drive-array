package io.opencensus.stats;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.opencensus.common.Functions;
import io.opencensus.common.Timestamp;
import io.opencensus.internal.Utils;
import io.opencensus.stats.Measure;
import io.opencensus.stats.View;
import io.opencensus.stats.ViewData;
import io.opencensus.tags.TagContext;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;

/* loaded from: classes2.dex */
final class NoopStats {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class NoopMeasureMap extends MeasureMap {
        private static final Logger logger = Logger.getLogger(NoopMeasureMap.class.getName());
        private boolean hasUnsupportedValues;

        private NoopMeasureMap() {
        }

        @Override // io.opencensus.stats.MeasureMap
        public MeasureMap put(Measure.MeasureDouble measureDouble, double d) {
            if (d < 0.0d) {
                this.hasUnsupportedValues = true;
            }
            return this;
        }

        @Override // io.opencensus.stats.MeasureMap
        public MeasureMap put(Measure.MeasureLong measureLong, long j) {
            if (j < 0) {
                this.hasUnsupportedValues = true;
            }
            return this;
        }

        @Override // io.opencensus.stats.MeasureMap
        public void record() {
        }

        @Override // io.opencensus.stats.MeasureMap
        public void record(TagContext tagContext) {
            Utils.checkNotNull(tagContext, "tags");
            if (this.hasUnsupportedValues) {
                logger.log(Level.WARNING, "Dropping values, value to record must be non-negative.");
            }
        }
    }

    @ThreadSafe
    /* loaded from: classes2.dex */
    private static final class NoopStatsComponent extends StatsComponent {
        private volatile boolean isRead;
        private final ViewManager viewManager;

        private NoopStatsComponent() {
            this.viewManager = NoopStats.d();
        }

        @Override // io.opencensus.stats.StatsComponent
        public StatsCollectionState getState() {
            this.isRead = true;
            return StatsCollectionState.DISABLED;
        }

        @Override // io.opencensus.stats.StatsComponent
        public StatsRecorder getStatsRecorder() {
            return NoopStats.a();
        }

        @Override // io.opencensus.stats.StatsComponent
        public ViewManager getViewManager() {
            return this.viewManager;
        }

        @Override // io.opencensus.stats.StatsComponent
        @Deprecated
        public void setState(StatsCollectionState statsCollectionState) {
            Utils.checkNotNull(statsCollectionState, "state");
            Utils.checkState(!this.isRead, "State was already read, cannot set state.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Immutable
    /* loaded from: classes2.dex */
    public static final class NoopStatsRecorder extends StatsRecorder {
        static final StatsRecorder a = new NoopStatsRecorder();

        private NoopStatsRecorder() {
        }

        @Override // io.opencensus.stats.StatsRecorder
        public MeasureMap newMeasureMap() {
            return NoopStats.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ThreadSafe
    /* loaded from: classes2.dex */
    public static final class NoopViewManager extends ViewManager {
        private static final Timestamp ZERO_TIMESTAMP = Timestamp.create(0, 0);

        @Nullable
        private volatile Set<View> exportedViews;

        @GuardedBy("registeredViews")
        private final Map<View.Name, View> registeredViews;

        private NoopViewManager() {
            this.registeredViews = new HashMap();
        }

        private static Set<View> filterExportedViews(Collection<View> collection) {
            HashSet hashSet = new HashSet();
            for (View view : collection) {
                if (!(view.getWindow() instanceof View.AggregationWindow.Interval)) {
                    hashSet.add(view);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }

        @Override // io.opencensus.stats.ViewManager
        public Set<View> getAllExportedViews() {
            Set<View> set = this.exportedViews;
            if (set == null) {
                synchronized (this.registeredViews) {
                    set = filterExportedViews(this.registeredViews.values());
                    this.exportedViews = set;
                }
            }
            return set;
        }

        @Override // io.opencensus.stats.ViewManager
        @Nullable
        public ViewData getView(View.Name name) {
            Utils.checkNotNull(name, AppMeasurementSdk.ConditionalUserProperty.NAME);
            synchronized (this.registeredViews) {
                View view = this.registeredViews.get(name);
                if (view == null) {
                    return null;
                }
                return ViewData.create(view, Collections.emptyMap(), (ViewData.AggregationWindowData) view.getWindow().match(Functions.returnConstant(ViewData.AggregationWindowData.CumulativeData.create(ZERO_TIMESTAMP, ZERO_TIMESTAMP)), Functions.returnConstant(ViewData.AggregationWindowData.IntervalData.create(ZERO_TIMESTAMP)), Functions.throwAssertionError()));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[Catch: all -> 0x0035, TryCatch #0 {, blocks: (B:5:0x0009, B:7:0x0019, B:11:0x0023, B:13:0x002a, B:14:0x0033), top: B:4:0x0009 }] */
        @Override // io.opencensus.stats.ViewManager
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void registerView(io.opencensus.stats.View r5) {
            /*
                r4 = this;
                java.lang.String r0 = "newView"
                io.opencensus.internal.Utils.checkNotNull(r5, r0)
                java.util.Map<io.opencensus.stats.View$Name, io.opencensus.stats.View> r0 = r4.registeredViews
                monitor-enter(r0)
                r1 = 0
                r4.exportedViews = r1     // Catch: java.lang.Throwable -> L35
                java.util.Map<io.opencensus.stats.View$Name, io.opencensus.stats.View> r1 = r4.registeredViews     // Catch: java.lang.Throwable -> L35
                io.opencensus.stats.View$Name r2 = r5.getName()     // Catch: java.lang.Throwable -> L35
                java.lang.Object r1 = r1.get(r2)     // Catch: java.lang.Throwable -> L35
                io.opencensus.stats.View r1 = (io.opencensus.stats.View) r1     // Catch: java.lang.Throwable -> L35
                if (r1 == 0) goto L22
                boolean r2 = r5.equals(r1)     // Catch: java.lang.Throwable -> L35
                if (r2 == 0) goto L20
                goto L22
            L20:
                r2 = 0
                goto L23
            L22:
                r2 = 1
            L23:
                java.lang.String r3 = "A different view with the same name already exists."
                io.opencensus.internal.Utils.checkArgument(r2, r3)     // Catch: java.lang.Throwable -> L35
                if (r1 != 0) goto L33
                java.util.Map<io.opencensus.stats.View$Name, io.opencensus.stats.View> r1 = r4.registeredViews     // Catch: java.lang.Throwable -> L35
                io.opencensus.stats.View$Name r2 = r5.getName()     // Catch: java.lang.Throwable -> L35
                r1.put(r2, r5)     // Catch: java.lang.Throwable -> L35
            L33:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
                return
            L35:
                r5 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L35
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opencensus.stats.NoopStats.NoopViewManager.registerView(io.opencensus.stats.View):void");
        }
    }

    private NoopStats() {
    }

    static StatsRecorder a() {
        return NoopStatsRecorder.a;
    }

    static MeasureMap b() {
        return new NoopMeasureMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StatsComponent c() {
        return new NoopStatsComponent();
    }

    static ViewManager d() {
        return new NoopViewManager();
    }
}
