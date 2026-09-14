package F1;

import F0.C0035g2;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.core.appupdate.internal.zzy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: n, reason: collision with root package name */
    public static final HashMap f751n = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f752a;

    /* renamed from: b, reason: collision with root package name */
    public final C0035g2 f753b;

    /* renamed from: g, reason: collision with root package name */
    public boolean f758g;

    /* renamed from: h, reason: collision with root package name */
    public final Intent f759h;

    /* renamed from: l, reason: collision with root package name */
    public p f762l;

    /* renamed from: m, reason: collision with root package name */
    public h f763m;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f755d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f756e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final Object f757f = new Object();

    /* renamed from: j, reason: collision with root package name */
    public final m f760j = new m(this, 0);

    /* renamed from: k, reason: collision with root package name */
    public final AtomicInteger f761k = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public final String f754c = "AppUpdateService";
    public final WeakReference i = new WeakReference(null);

    public q(Context context, C0035g2 c0035g2, Intent intent) {
        this.f752a = context;
        this.f753b = c0035g2;
        this.f759h = intent;
    }

    public static void b(q qVar, l lVar) {
        h hVar = qVar.f763m;
        C0035g2 c0035g2 = qVar.f753b;
        ArrayList arrayList = qVar.f755d;
        int i = 0;
        if (hVar == null && !qVar.f758g) {
            c0035g2.y("Initiate binding to the service.", new Object[0]);
            arrayList.add(lVar);
            p pVar = new p(qVar, 0);
            qVar.f762l = pVar;
            qVar.f758g = true;
            if (!qVar.f752a.bindService(qVar.f759h, pVar, 1)) {
                c0035g2.y("Failed to bind to the service.", new Object[0]);
                qVar.f758g = false;
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zzy zzyVar = new zzy();
                    TaskCompletionSource taskCompletionSource = ((l) obj).f742a;
                    if (taskCompletionSource != null) {
                        taskCompletionSource.trySetException(zzyVar);
                    }
                }
                arrayList.clear();
                return;
            }
            return;
        }
        if (qVar.f758g) {
            c0035g2.y("Waiting to bind to the service.", new Object[0]);
            arrayList.add(lVar);
        } else {
            lVar.run();
        }
    }

    public final Handler a() {
        Handler handler;
        HashMap hashMap = f751n;
        synchronized (hashMap) {
            try {
                if (!hashMap.containsKey(this.f754c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f754c, 10);
                    handlerThread.start();
                    hashMap.put(this.f754c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) hashMap.get(this.f754c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final void c(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f757f) {
            this.f756e.remove(taskCompletionSource);
        }
        a().post(new n(this, 0));
    }

    public final void d() {
        HashSet hashSet = this.f756e;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(new RemoteException(String.valueOf(this.f754c).concat(" : Binder has died.")));
        }
        hashSet.clear();
    }
}
