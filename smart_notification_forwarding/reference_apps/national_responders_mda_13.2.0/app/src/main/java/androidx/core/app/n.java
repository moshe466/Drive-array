package androidx.core.app;

import a.a;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.provider.Settings;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: d, reason: collision with root package name */
    private static String f2266d;

    /* renamed from: g, reason: collision with root package name */
    private static d f2269g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f2270a;

    /* renamed from: b, reason: collision with root package name */
    private final NotificationManager f2271b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f2265c = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static Set<String> f2267e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private static final Object f2268f = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements e {

        /* renamed from: a, reason: collision with root package name */
        final String f2272a;

        /* renamed from: b, reason: collision with root package name */
        final int f2273b;

        /* renamed from: c, reason: collision with root package name */
        final String f2274c;

        /* renamed from: d, reason: collision with root package name */
        final boolean f2275d = false;

        a(String str, int i10, String str2) {
            this.f2272a = str;
            this.f2273b = i10;
            this.f2274c = str2;
        }

        @Override // androidx.core.app.n.e
        public void a(a.a aVar) {
            if (this.f2275d) {
                aVar.R(this.f2272a);
            } else {
                aVar.A(this.f2272a, this.f2273b, this.f2274c);
            }
        }

        public String toString() {
            return "CancelTask[packageName:" + this.f2272a + ", id:" + this.f2273b + ", tag:" + this.f2274c + ", all:" + this.f2275d + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements e {

        /* renamed from: a, reason: collision with root package name */
        final String f2276a;

        /* renamed from: b, reason: collision with root package name */
        final int f2277b;

        /* renamed from: c, reason: collision with root package name */
        final String f2278c;

        /* renamed from: d, reason: collision with root package name */
        final Notification f2279d;

        b(String str, int i10, String str2, Notification notification) {
            this.f2276a = str;
            this.f2277b = i10;
            this.f2278c = str2;
            this.f2279d = notification;
        }

        @Override // androidx.core.app.n.e
        public void a(a.a aVar) {
            aVar.k0(this.f2276a, this.f2277b, this.f2278c, this.f2279d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f2276a + ", id:" + this.f2277b + ", tag:" + this.f2278c + "]";
        }
    }

    /* loaded from: classes.dex */
    private static class c {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f2280a;

        /* renamed from: b, reason: collision with root package name */
        final IBinder f2281b;

        c(ComponentName componentName, IBinder iBinder) {
            this.f2280a = componentName;
            this.f2281b = iBinder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d implements Handler.Callback, ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final Context f2282a;

        /* renamed from: b, reason: collision with root package name */
        private final HandlerThread f2283b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f2284c;

        /* renamed from: d, reason: collision with root package name */
        private final Map<ComponentName, a> f2285d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private Set<String> f2286e = new HashSet();

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a, reason: collision with root package name */
            final ComponentName f2287a;

            /* renamed from: c, reason: collision with root package name */
            a.a f2289c;

            /* renamed from: b, reason: collision with root package name */
            boolean f2288b = false;

            /* renamed from: d, reason: collision with root package name */
            ArrayDeque<e> f2290d = new ArrayDeque<>();

            /* renamed from: e, reason: collision with root package name */
            int f2291e = 0;

            a(ComponentName componentName) {
                this.f2287a = componentName;
            }
        }

        d(Context context) {
            this.f2282a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f2283b = handlerThread;
            handlerThread.start();
            this.f2284c = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(a aVar) {
            if (aVar.f2288b) {
                return true;
            }
            boolean bindService = this.f2282a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f2287a), this, 33);
            aVar.f2288b = bindService;
            if (bindService) {
                aVar.f2291e = 0;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to bind to listener ");
                sb2.append(aVar.f2287a);
                this.f2282a.unbindService(this);
            }
            return aVar.f2288b;
        }

        private void b(a aVar) {
            if (aVar.f2288b) {
                this.f2282a.unbindService(this);
                aVar.f2288b = false;
            }
            aVar.f2289c = null;
        }

        private void c(e eVar) {
            j();
            for (a aVar : this.f2285d.values()) {
                aVar.f2290d.add(eVar);
                g(aVar);
            }
        }

        private void d(ComponentName componentName) {
            a aVar = this.f2285d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f2285d.get(componentName);
            if (aVar != null) {
                aVar.f2289c = a.AbstractBinderC0000a.i(iBinder);
                aVar.f2291e = 0;
                g(aVar);
            }
        }

        private void f(ComponentName componentName) {
            a aVar = this.f2285d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void g(androidx.core.app.n.d.a r6) {
            /*
                r5 = this;
                java.lang.String r0 = "NotifManCompat"
                r1 = 3
                boolean r2 = android.util.Log.isLoggable(r0, r1)
                if (r2 == 0) goto L2b
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Processing component "
                r2.append(r3)
                android.content.ComponentName r3 = r6.f2287a
                r2.append(r3)
                java.lang.String r3 = ", "
                r2.append(r3)
                java.util.ArrayDeque<androidx.core.app.n$e> r3 = r6.f2290d
                int r3 = r3.size()
                r2.append(r3)
                java.lang.String r3 = " queued tasks"
                r2.append(r3)
            L2b:
                java.util.ArrayDeque<androidx.core.app.n$e> r2 = r6.f2290d
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L34
                return
            L34:
                boolean r2 = r5.a(r6)
                if (r2 == 0) goto L93
                a.a r2 = r6.f2289c
                if (r2 != 0) goto L3f
                goto L93
            L3f:
                java.util.ArrayDeque<androidx.core.app.n$e> r2 = r6.f2290d
                java.lang.Object r2 = r2.peek()
                androidx.core.app.n$e r2 = (androidx.core.app.n.e) r2
                if (r2 != 0) goto L4a
                goto L87
            L4a:
                boolean r3 = android.util.Log.isLoggable(r0, r1)     // Catch: android.os.RemoteException -> L68 android.os.DeadObjectException -> L78
                if (r3 == 0) goto L5d
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: android.os.RemoteException -> L68 android.os.DeadObjectException -> L78
                r3.<init>()     // Catch: android.os.RemoteException -> L68 android.os.DeadObjectException -> L78
                java.lang.String r4 = "Sending task "
                r3.append(r4)     // Catch: android.os.RemoteException -> L68 android.os.DeadObjectException -> L78
                r3.append(r2)     // Catch: android.os.RemoteException -> L68 android.os.DeadObjectException -> L78
            L5d:
                a.a r3 = r6.f2289c     // Catch: android.os.RemoteException -> L68 android.os.DeadObjectException -> L78
                r2.a(r3)     // Catch: android.os.RemoteException -> L68 android.os.DeadObjectException -> L78
                java.util.ArrayDeque<androidx.core.app.n$e> r2 = r6.f2290d     // Catch: android.os.RemoteException -> L68 android.os.DeadObjectException -> L78
                r2.remove()     // Catch: android.os.RemoteException -> L68 android.os.DeadObjectException -> L78
                goto L3f
            L68:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "RemoteException communicating with "
            L6f:
                r0.append(r1)
                android.content.ComponentName r1 = r6.f2287a
                r0.append(r1)
                goto L87
            L78:
                boolean r0 = android.util.Log.isLoggable(r0, r1)
                if (r0 == 0) goto L87
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Remote service has died: "
                goto L6f
            L87:
                java.util.ArrayDeque<androidx.core.app.n$e> r0 = r6.f2290d
                boolean r0 = r0.isEmpty()
                if (r0 != 0) goto L92
                r5.i(r6)
            L92:
                return
            L93:
                r5.i(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.n.d.g(androidx.core.app.n$d$a):void");
        }

        private void i(a aVar) {
            if (this.f2284c.hasMessages(3, aVar.f2287a)) {
                return;
            }
            int i10 = aVar.f2291e + 1;
            aVar.f2291e = i10;
            if (i10 <= 6) {
                int i11 = (1 << (i10 - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Scheduling retry for ");
                    sb2.append(i11);
                    sb2.append(" ms");
                }
                this.f2284c.sendMessageDelayed(this.f2284c.obtainMessage(3, aVar.f2287a), i11);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Giving up on delivering ");
            sb3.append(aVar.f2290d.size());
            sb3.append(" tasks to ");
            sb3.append(aVar.f2287a);
            sb3.append(" after ");
            sb3.append(aVar.f2291e);
            sb3.append(" retries");
            aVar.f2290d.clear();
        }

        private void j() {
            Set<String> e10 = n.e(this.f2282a);
            if (e10.equals(this.f2286e)) {
                return;
            }
            this.f2286e = e10;
            List<ResolveInfo> queryIntentServices = this.f2282a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (e10.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Permission present on component ");
                        sb2.append(componentName);
                        sb2.append(", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f2285d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Adding listener record for ");
                        sb3.append(componentName2);
                    }
                    this.f2285d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f2285d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Removing listener record for ");
                        sb4.append(next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        public void h(e eVar) {
            this.f2284c.obtainMessage(0, eVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                c((e) message.obj);
                return true;
            }
            if (i10 == 1) {
                c cVar = (c) message.obj;
                e(cVar.f2280a, cVar.f2281b);
                return true;
            }
            if (i10 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i10 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Connected to service ");
                sb2.append(componentName);
            }
            this.f2284c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Disconnected from service ");
                sb2.append(componentName);
            }
            this.f2284c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface e {
        void a(a.a aVar);
    }

    private n(Context context) {
        this.f2270a = context;
        this.f2271b = (NotificationManager) context.getSystemService("notification");
    }

    public static n d(Context context) {
        return new n(context);
    }

    public static Set<String> e(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f2265c) {
            if (string != null) {
                if (!string.equals(f2266d)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    f2267e = hashSet;
                    f2266d = string;
                }
            }
            set = f2267e;
        }
        return set;
    }

    private void h(e eVar) {
        synchronized (f2268f) {
            if (f2269g == null) {
                f2269g = new d(this.f2270a.getApplicationContext());
            }
            f2269g.h(eVar);
        }
    }

    private static boolean i(Notification notification) {
        Bundle a10 = k.a(notification);
        return a10 != null && a10.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            return this.f2271b.areNotificationsEnabled();
        }
        if (i10 < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f2270a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f2270a.getApplicationInfo();
        String packageName = this.f2270a.getApplicationContext().getPackageName();
        int i11 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i11), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void b(int i10) {
        c(null, i10);
    }

    public void c(String str, int i10) {
        this.f2271b.cancel(str, i10);
        if (Build.VERSION.SDK_INT <= 19) {
            h(new a(this.f2270a.getPackageName(), i10, str));
        }
    }

    public void f(int i10, Notification notification) {
        g(null, i10, notification);
    }

    public void g(String str, int i10, Notification notification) {
        if (!i(notification)) {
            this.f2271b.notify(str, i10, notification);
        } else {
            h(new b(this.f2270a.getPackageName(), i10, str, notification));
            this.f2271b.cancel(str, i10);
        }
    }
}
