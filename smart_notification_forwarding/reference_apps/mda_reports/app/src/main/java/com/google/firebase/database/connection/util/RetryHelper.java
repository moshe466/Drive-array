package com.google.firebase.database.connection.util;

import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class RetryHelper {
    private long currentRetryDelay;
    private final ScheduledExecutorService executorService;
    private final double jitterFactor;
    private boolean lastWasSuccess;
    private final LogWrapper logger;
    private final long maxRetryDelay;
    private final long minRetryDelayAfterFailure;
    private final Random random;
    private final double retryExponent;
    private ScheduledFuture<?> scheduledRetry;

    /* loaded from: classes2.dex */
    public static class Builder {
        private final LogWrapper logger;
        private final ScheduledExecutorService service;
        private long minRetryDelayAfterFailure = 1000;
        private double jitterFactor = 0.5d;
        private long retryMaxDelay = 30000;
        private double retryExponent = 1.3d;

        public Builder(ScheduledExecutorService scheduledExecutorService, Logger logger, String str) {
            this.service = scheduledExecutorService;
            this.logger = new LogWrapper(logger, str);
        }

        public RetryHelper build() {
            return new RetryHelper(this.service, this.logger, this.minRetryDelayAfterFailure, this.retryMaxDelay, this.retryExponent, this.jitterFactor);
        }

        public Builder withJitterFactor(double d) {
            if (d >= 0.0d && d <= 1.0d) {
                this.jitterFactor = d;
                return this;
            }
            throw new IllegalArgumentException("Argument out of range: " + d);
        }

        public Builder withMaxDelay(long j) {
            this.retryMaxDelay = j;
            return this;
        }

        public Builder withMinDelayAfterFailure(long j) {
            this.minRetryDelayAfterFailure = j;
            return this;
        }

        public Builder withRetryExponent(double d) {
            this.retryExponent = d;
            return this;
        }
    }

    private RetryHelper(ScheduledExecutorService scheduledExecutorService, LogWrapper logWrapper, long j, long j2, double d, double d2) {
        this.random = new Random();
        this.lastWasSuccess = true;
        this.executorService = scheduledExecutorService;
        this.logger = logWrapper;
        this.minRetryDelayAfterFailure = j;
        this.maxRetryDelay = j2;
        this.retryExponent = d;
        this.jitterFactor = d2;
    }

    public void cancel() {
        if (this.scheduledRetry != null) {
            this.logger.debug("Cancelling existing retry attempt", new Object[0]);
            this.scheduledRetry.cancel(false);
            this.scheduledRetry = null;
        } else {
            this.logger.debug("No existing retry attempt to cancel", new Object[0]);
        }
        this.currentRetryDelay = 0L;
    }

    public void retry(final Runnable runnable) {
        long min;
        Runnable runnable2 = new Runnable() { // from class: com.google.firebase.database.connection.util.RetryHelper.1
            @Override // java.lang.Runnable
            public void run() {
                RetryHelper.this.scheduledRetry = null;
                runnable.run();
            }
        };
        if (this.scheduledRetry != null) {
            this.logger.debug("Cancelling previous scheduled retry", new Object[0]);
            this.scheduledRetry.cancel(false);
            this.scheduledRetry = null;
        }
        long j = 0;
        if (!this.lastWasSuccess) {
            long j2 = this.currentRetryDelay;
            if (j2 == 0) {
                min = this.minRetryDelayAfterFailure;
            } else {
                double d = j2;
                double d2 = this.retryExponent;
                Double.isNaN(d);
                min = Math.min((long) (d * d2), this.maxRetryDelay);
            }
            this.currentRetryDelay = min;
            double d3 = this.jitterFactor;
            long j3 = this.currentRetryDelay;
            double d4 = j3;
            Double.isNaN(d4);
            double d5 = j3;
            Double.isNaN(d5);
            j = (long) (((1.0d - d3) * d4) + (d3 * d5 * this.random.nextDouble()));
        }
        this.lastWasSuccess = false;
        this.logger.debug("Scheduling retry in %dms", Long.valueOf(j));
        this.scheduledRetry = this.executorService.schedule(runnable2, j, TimeUnit.MILLISECONDS);
    }

    public void setMaxDelay() {
        this.currentRetryDelay = this.maxRetryDelay;
    }

    public void signalSuccess() {
        this.lastWasSuccess = true;
        this.currentRetryDelay = 0L;
    }
}
