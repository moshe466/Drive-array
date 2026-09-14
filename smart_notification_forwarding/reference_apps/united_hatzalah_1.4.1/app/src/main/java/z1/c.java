package z1;

import A1.l;
import a.AbstractC0228a;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.database.Cursor;
import android.os.PersistableBundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.Adler32;
import org.apache.tika.mime.MimeTypesReaderMetKeys;
import t1.k;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f6844a;

    /* renamed from: b, reason: collision with root package name */
    public final A1.d f6845b;

    /* renamed from: c, reason: collision with root package name */
    public final C0795a f6846c;

    public c(Context context, A1.d dVar, C0795a c0795a) {
        this.f6844a = context;
        this.f6845b = dVar;
        this.f6846c = c0795a;
    }

    public final void a(k kVar, int i, boolean z3) {
        Long l3;
        Context context = this.f6844a;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        String str = kVar.f6431a;
        String str2 = kVar.f6431a;
        adler32.update(str.getBytes(Charset.forName("UTF-8")));
        ByteBuffer allocate = ByteBuffer.allocate(4);
        q1.d dVar = kVar.f6433c;
        adler32.update(allocate.putInt(D1.a.a(dVar)).array());
        byte[] bArr = kVar.f6432b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z3) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i3 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i3 >= i) {
                        AbstractC0228a.h("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", kVar);
                        return;
                    }
                }
            }
        }
        Cursor rawQuery = ((l) this.f6845b).a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str2, String.valueOf(D1.a.a(dVar))});
        try {
            if (rawQuery.moveToNext()) {
                l3 = Long.valueOf(rawQuery.getLong(0));
            } else {
                l3 = 0L;
            }
            rawQuery.close();
            long longValue = l3.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            C0795a c0795a = this.f6846c;
            builder.setMinimumLatency(c0795a.a(dVar, longValue, i));
            Set set = ((b) c0795a.f6840b.get(dVar)).f6843c;
            if (set.contains(d.f6847a)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(d.f6849c)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(d.f6848b)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i);
            persistableBundle.putString("backendName", str2);
            persistableBundle.putInt(MimeTypesReaderMetKeys.MAGIC_PRIORITY_ATTR, D1.a.a(dVar));
            if (bArr != null) {
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            }
            builder.setExtras(persistableBundle);
            Object[] objArr = {kVar, Integer.valueOf(value), Long.valueOf(c0795a.a(dVar, longValue, i)), l3, Integer.valueOf(i)};
            if (Log.isLoggable(AbstractC0228a.v("JobInfoScheduler"), 3)) {
                String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr);
            }
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }
}
