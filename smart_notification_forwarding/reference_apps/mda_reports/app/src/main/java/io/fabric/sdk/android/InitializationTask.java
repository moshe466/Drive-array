package io.fabric.sdk.android;

import io.fabric.sdk.android.services.common.TimingMetric;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.PriorityAsyncTask;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class InitializationTask<Result> extends PriorityAsyncTask<Void, Void, Result> {
    private static final String TIMING_METRIC_TAG = "KitInitialization";
    final Kit<Result> a;

    public InitializationTask(Kit<Result> kit) {
        this.a = kit;
    }

    private TimingMetric createAndStartTimingMetric(String str) {
        TimingMetric timingMetric = new TimingMetric(this.a.getIdentifier() + "." + str, TIMING_METRIC_TAG);
        timingMetric.startMeasuring();
        return timingMetric;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.services.concurrency.AsyncTask
    public Result a(Void... voidArr) {
        TimingMetric createAndStartTimingMetric = createAndStartTimingMetric("doInBackground");
        Result a = !isCancelled() ? this.a.a() : null;
        createAndStartTimingMetric.stopMeasuring();
        return a;
    }

    @Override // io.fabric.sdk.android.services.concurrency.AsyncTask
    protected void a(Result result) {
        this.a.a((Kit<Result>) result);
        this.a.d.failure(new InitializationException(this.a.getIdentifier() + " Initialization was cancelled"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.fabric.sdk.android.services.concurrency.AsyncTask
    public void b() {
        super.b();
        TimingMetric createAndStartTimingMetric = createAndStartTimingMetric("onPreExecute");
        try {
            try {
                boolean f = this.a.f();
                createAndStartTimingMetric.stopMeasuring();
                if (f) {
                    return;
                }
            } catch (UnmetDependencyException e) {
                throw e;
            } catch (Exception e2) {
                Fabric.getLogger().e(Fabric.TAG, "Failure onPreExecute()", e2);
                createAndStartTimingMetric.stopMeasuring();
            }
            cancel(true);
        } catch (Throwable th) {
            createAndStartTimingMetric.stopMeasuring();
            cancel(true);
            throw th;
        }
    }

    @Override // io.fabric.sdk.android.services.concurrency.AsyncTask
    protected void b(Result result) {
        this.a.b(result);
        this.a.d.success(result);
    }

    @Override // io.fabric.sdk.android.services.concurrency.PriorityAsyncTask, io.fabric.sdk.android.services.concurrency.PriorityProvider
    public Priority getPriority() {
        return Priority.HIGH;
    }
}
