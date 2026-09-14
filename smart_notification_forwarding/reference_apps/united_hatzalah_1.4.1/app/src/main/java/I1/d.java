package I1;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.af;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: o, reason: collision with root package name */
    public static final HashMap f905o = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f906a;

    /* renamed from: b, reason: collision with root package name */
    public final y f907b;

    /* renamed from: c, reason: collision with root package name */
    public final String f908c;

    /* renamed from: g, reason: collision with root package name */
    public boolean f912g;

    /* renamed from: h, reason: collision with root package name */
    public final Intent f913h;
    public final B i;

    /* renamed from: m, reason: collision with root package name */
    public F1.p f917m;

    /* renamed from: n, reason: collision with root package name */
    public IInterface f918n;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f909d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HashSet f910e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final Object f911f = new Object();

    /* renamed from: k, reason: collision with root package name */
    public final F1.m f915k = new F1.m(this, 1);

    /* renamed from: l, reason: collision with root package name */
    public final AtomicInteger f916l = new AtomicInteger(0);

    /* renamed from: j, reason: collision with root package name */
    public final WeakReference f914j = new WeakReference(null);

    public d(Context context, y yVar, String str, Intent intent, B b4) {
        this.f906a = context;
        this.f907b = yVar;
        this.f908c = str;
        this.f913h = intent;
        this.i = b4;
    }

    public static /* bridge */ /* synthetic */ void b(d dVar, z zVar) {
        IInterface iInterface = dVar.f918n;
        y yVar = dVar.f907b;
        ArrayList arrayList = dVar.f909d;
        int i = 0;
        if (iInterface == null && !dVar.f912g) {
            yVar.b("Initiate binding to the service.", new Object[0]);
            arrayList.add(zVar);
            F1.p pVar = new F1.p(dVar, 1);
            dVar.f917m = pVar;
            dVar.f912g = true;
            if (!dVar.f906a.bindService(dVar.f913h, pVar, 1)) {
                yVar.b("Failed to bind to the service.", new Object[0]);
                dVar.f912g = false;
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((z) obj).a(new af());
                }
                arrayList.clear();
                return;
            }
            return;
        }
        if (dVar.f912g) {
            yVar.b("Waiting to bind to the service.", new Object[0]);
            arrayList.add(zVar);
        } else {
            zVar.run();
        }
    }

    public final Handler a() {
        Handler handler;
        HashMap hashMap = f905o;
        synchronized (hashMap) {
            try {
                if (!hashMap.containsKey(this.f908c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f908c, 10);
                    handlerThread.start();
                    hashMap.put(this.f908c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) hashMap.get(this.f908c);
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }

    public final void c(z zVar, TaskCompletionSource taskCompletionSource) {
        a().post(new A(this, zVar.c(), taskCompletionSource, zVar));
    }

    public final void d(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f911f) {
            this.f910e.remove(taskCompletionSource);
        }
        a().post(new c(this, 1));
    }

    public final void e() {
        HashSet hashSet = this.f910e;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(new RemoteException(String.valueOf(this.f908c).concat(" : Binder has died.")));
        }
        hashSet.clear();
    }
}
