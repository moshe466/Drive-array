package b2;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class j1 implements ServiceConnection, n1 {

    /* renamed from: a, reason: collision with root package name */
    private final Map f4022a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private int f4023b = 2;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4024c;

    /* renamed from: d, reason: collision with root package name */
    private IBinder f4025d;

    /* renamed from: e, reason: collision with root package name */
    private final i1 f4026e;

    /* renamed from: f, reason: collision with root package name */
    private ComponentName f4027f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ m1 f4028g;

    public j1(m1 m1Var, i1 i1Var) {
        this.f4028g = m1Var;
        this.f4026e = i1Var;
    }

    public final int a() {
        return this.f4023b;
    }

    public final ComponentName b() {
        return this.f4027f;
    }

    public final IBinder c() {
        return this.f4025d;
    }

    public final void d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f4022a.put(serviceConnection, serviceConnection2);
    }

    public final void e(String str, Executor executor) {
        f2.a aVar;
        Context context;
        Context context2;
        f2.a aVar2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j10;
        this.f4023b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (g2.l.l()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            m1 m1Var = this.f4028g;
            aVar = m1Var.f4038j;
            context = m1Var.f4035g;
            i1 i1Var = this.f4026e;
            context2 = m1Var.f4035g;
            boolean d10 = aVar.d(context, str, i1Var.c(context2), this, this.f4026e.a(), executor);
            this.f4024c = d10;
            if (d10) {
                handler = this.f4028g.f4036h;
                Message obtainMessage = handler.obtainMessage(1, this.f4026e);
                handler2 = this.f4028g.f4036h;
                j10 = this.f4028g.f4040l;
                handler2.sendMessageDelayed(obtainMessage, j10);
            } else {
                this.f4023b = 2;
                try {
                    m1 m1Var2 = this.f4028g;
                    aVar2 = m1Var2.f4038j;
                    context3 = m1Var2.f4035g;
                    aVar2.c(context3, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f4022a.remove(serviceConnection);
    }

    public final void g(String str) {
        Handler handler;
        f2.a aVar;
        Context context;
        handler = this.f4028g.f4036h;
        handler.removeMessages(1, this.f4026e);
        m1 m1Var = this.f4028g;
        aVar = m1Var.f4038j;
        context = m1Var.f4035g;
        aVar.c(context, this);
        this.f4024c = false;
        this.f4023b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f4022a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f4022a.isEmpty();
    }

    public final boolean j() {
        return this.f4024c;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f4028g.f4034f;
        synchronized (hashMap) {
            handler = this.f4028g.f4036h;
            handler.removeMessages(1, this.f4026e);
            this.f4025d = iBinder;
            this.f4027f = componentName;
            Iterator it = this.f4022a.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
            }
            this.f4023b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f4028g.f4034f;
        synchronized (hashMap) {
            handler = this.f4028g.f4036h;
            handler.removeMessages(1, this.f4026e);
            this.f4025d = null;
            this.f4027f = componentName;
            Iterator it = this.f4022a.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
            }
            this.f4023b = 2;
        }
    }
}
