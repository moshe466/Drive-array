package E1;

import F0.C0035g2;
import F1.q;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.install.InstallException;
import k2.C0493c;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final k f131a;

    /* renamed from: b, reason: collision with root package name */
    public final c f132b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f133c;

    public d(k kVar, c cVar, Context context) {
        new Handler(Looper.getMainLooper());
        this.f131a = kVar;
        this.f132b = cVar;
        this.f133c = context;
    }

    public static void c(a aVar, Activity activity, m mVar) {
        if (activity != null && aVar != null && aVar.b(mVar) != null && !aVar.f124j) {
            aVar.f124j = true;
            activity.startIntentSenderForResult(aVar.b(mVar).getIntentSender(), 1276, null, 0, 0, 0, null);
        }
    }

    public final Task a() {
        String packageName = this.f133c.getPackageName();
        k kVar = this.f131a;
        q qVar = kVar.f147a;
        if (qVar == null) {
            C0035g2 c0035g2 = k.f145e;
            Object[] objArr = {-9};
            c0035g2.getClass();
            if (Log.isLoggable("PlayCore", 6)) {
                Log.e("PlayCore", C0035g2.z((String) c0035g2.f526b, "onError(%d)", objArr));
            }
            return Tasks.forException(new InstallException(-9));
        }
        k.f145e.y("requestUpdateInfo(%s)", packageName);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        qVar.a().post(new g(qVar, taskCompletionSource, taskCompletionSource, new g(kVar, taskCompletionSource, packageName, taskCompletionSource), 2));
        return taskCompletionSource.getTask();
    }

    public final synchronized void b(C0493c c0493c) {
        c cVar = this.f132b;
        synchronized (cVar) {
            cVar.f126a.y("registerListener", new Object[0]);
            cVar.f129d.add(c0493c);
            cVar.a();
        }
    }
}
