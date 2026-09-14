package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import D1.a;
import F0.C0110z2;
import F0.RunnableC0064o;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import com.lt.plugin.lt_plugin.utils.d;
import org.apache.tika.mime.MimeTypesReaderMetKeys;
import t1.k;
import t1.t;
import z1.g;

/* loaded from: classes.dex */
public class JobInfoSchedulerService extends JobService {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3886a = 0;

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i = jobParameters.getExtras().getInt(MimeTypesReaderMetKeys.MAGIC_PRIORITY_ATTR);
        int i3 = jobParameters.getExtras().getInt("attemptNumber");
        t.b(getApplicationContext());
        C0110z2 a2 = k.a();
        a2.v(string);
        a2.f731d = a.b(i);
        if (string2 != null) {
            a2.f730c = Base64.decode(string2, 0);
        }
        g gVar = t.a().f6457d;
        gVar.f6861e.execute(new d(gVar, a2.g(), i3, new RunnableC0064o(21, this, jobParameters), 1));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
