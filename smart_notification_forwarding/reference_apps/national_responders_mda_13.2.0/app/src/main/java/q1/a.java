package q1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;

/* loaded from: classes.dex */
public class a implements n {

    /* renamed from: a, reason: collision with root package name */
    private final Context f13419a;

    /* renamed from: b, reason: collision with root package name */
    private final r1.c f13420b;

    /* renamed from: c, reason: collision with root package name */
    private AlarmManager f13421c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.datatransport.runtime.scheduling.jobscheduling.e f13422d;

    /* renamed from: e, reason: collision with root package name */
    private final t1.a f13423e;

    a(Context context, r1.c cVar, AlarmManager alarmManager, t1.a aVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.e eVar) {
        this.f13419a = context;
        this.f13420b = cVar;
        this.f13421c = alarmManager;
        this.f13423e = aVar;
        this.f13422d = eVar;
    }

    public a(Context context, r1.c cVar, t1.a aVar, com.google.android.datatransport.runtime.scheduling.jobscheduling.e eVar) {
        this(context, cVar, (AlarmManager) context.getSystemService("alarm"), aVar, eVar);
    }

    @Override // q1.n
    public void a(k1.m mVar, int i10) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", mVar.b());
        builder.appendQueryParameter("priority", String.valueOf(u1.a.a(mVar.d())));
        if (mVar.c() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(mVar.c(), 0));
        }
        Intent intent = new Intent(this.f13419a, (Class<?>) AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i10);
        if (b(intent)) {
            n1.a.a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", mVar);
            return;
        }
        long Q = this.f13420b.Q(mVar);
        long g10 = this.f13422d.g(mVar.d(), Q, i10);
        n1.a.b("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", mVar, Long.valueOf(g10), Long.valueOf(Q), Integer.valueOf(i10));
        this.f13421c.set(3, this.f13423e.a() + g10, PendingIntent.getBroadcast(this.f13419a, 0, intent, 0));
    }

    boolean b(Intent intent) {
        return PendingIntent.getBroadcast(this.f13419a, 0, intent, 536870912) != null;
    }
}
