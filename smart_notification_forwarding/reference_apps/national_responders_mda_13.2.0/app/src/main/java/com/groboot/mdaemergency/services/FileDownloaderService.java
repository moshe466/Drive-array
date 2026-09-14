package com.groboot.mdaemergency.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.groboot.mdaemergency.async.a;
import java.util.ArrayList;
import java.util.Iterator;
import w6.d0;
import w6.l0;

/* loaded from: classes.dex */
public class FileDownloaderService extends Service {

    /* renamed from: f, reason: collision with root package name */
    static boolean f7970f;

    /* renamed from: g, reason: collision with root package name */
    static ArrayList<com.groboot.mdaemergency.async.a> f7971g = new ArrayList<>();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (FileDownloaderService.this.d()) {
                FileDownloaderService.this.e();
                d0.a(5000L);
            }
            FileDownloaderService.this.stopSelf();
        }
    }

    public static void c(Context context, String str, String str2, String str3, String str4) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("addDownloaderTask ");
        sb2.append(str3);
        com.groboot.mdaemergency.async.a aVar = new com.groboot.mdaemergency.async.a(context, str, str2, str3, str4);
        Iterator<com.groboot.mdaemergency.async.a> it = f7971g.iterator();
        while (it.hasNext()) {
            com.groboot.mdaemergency.async.a next = it.next();
            if (l0.m(next.f7598f, aVar.f7598f) || l0.l(next.f7601i, aVar.f7601i)) {
                return;
            }
        }
        f7971g.add(aVar);
        if (f7970f) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) FileDownloaderService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        Iterator<com.groboot.mdaemergency.async.a> it = f7971g.iterator();
        while (it.hasNext()) {
            if (it.next().f7599g != a.b.success) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        ArrayList arrayList = new ArrayList();
        Iterator<com.groboot.mdaemergency.async.a> it = f7971g.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            com.groboot.mdaemergency.async.a next = it.next();
            if (i10 > 0) {
                d0.a(4000L);
            }
            i10++;
            a.b bVar = next.f7599g;
            if (bVar == a.b.none) {
                next.a();
                return;
            } else if (bVar == a.b.success || bVar == a.b.error) {
                arrayList.add(next);
            }
        }
        f7971g.removeAll(arrayList);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        startForeground(v5.a.f14661a, v5.a.a(getApplicationContext()));
        f7970f = true;
        new Thread(new a()).start();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f7970f = false;
    }
}
