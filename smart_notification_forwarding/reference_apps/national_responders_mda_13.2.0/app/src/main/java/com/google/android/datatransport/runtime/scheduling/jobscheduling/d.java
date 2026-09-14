package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;

/* loaded from: classes.dex */
final /* synthetic */ class d implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final JobInfoSchedulerService f4722f;

    /* renamed from: g, reason: collision with root package name */
    private final JobParameters f4723g;

    private d(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f4722f = jobInfoSchedulerService;
        this.f4723g = jobParameters;
    }

    public static Runnable a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new d(jobInfoSchedulerService, jobParameters);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4722f.jobFinished(this.f4723g, false);
    }
}
