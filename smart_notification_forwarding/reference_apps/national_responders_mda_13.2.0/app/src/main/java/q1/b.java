package q1;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* loaded from: classes.dex */
public class b implements n {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13424a;

    /* renamed from: b, reason: collision with root package name */
    private final r1.c f13425b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.scheduling.jobscheduling.e f13426c;

    public b(Context context, r1.c cVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.e eVar) {
        this.f13424a = context;
        this.f13425b = cVar;
        this.f13426c = eVar;
    }

    private boolean c(JobScheduler jobScheduler, int i10, int i11) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i12 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i10) {
                return i12 >= i11;
            }
        }
        return false;
    }

    @Override // q1.n
    public void a(k1.m mVar, int i10) {
        ComponentName componentName = new ComponentName(this.f13424a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f13424a.getSystemService("jobscheduler");
        int b10 = b(mVar);
        if (c(jobScheduler, b10, i10)) {
            n1.a.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", mVar);
            return;
        }
        long Q = this.f13425b.Q(mVar);
        JobInfo.Builder c10 = this.f13426c.c(new JobInfo.Builder(b10, componentName), mVar.d(), Q, i10);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i10);
        persistableBundle.putString("backendName", mVar.b());
        persistableBundle.putInt("priority", u1.a.a(mVar.d()));
        if (mVar.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(mVar.c(), 0));
        }
        c10.setExtras(persistableBundle);
        n1.a.b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", mVar, Integer.valueOf(b10), Long.valueOf(this.f13426c.g(mVar.d(), Q, i10)), Long.valueOf(Q), Integer.valueOf(i10));
        jobScheduler.schedule(c10.build());
    }

    int b(k1.m mVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f13424a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(mVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(u1.a.a(mVar.d())).array());
        if (mVar.c() != null) {
            adler32.update(mVar.c());
        }
        return (int) adler32.getValue();
    }
}
