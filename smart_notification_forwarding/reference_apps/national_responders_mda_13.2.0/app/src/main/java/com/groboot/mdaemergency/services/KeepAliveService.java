package com.groboot.mdaemergency.services;

import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import com.groboot.mdaemergency.ptt.p;
import w6.m;

/* loaded from: classes.dex */
public class KeepAliveService extends Service {

    /* renamed from: g, reason: collision with root package name */
    public static int f7982g = 983126;

    /* renamed from: f, reason: collision with root package name */
    public String f7983f = "com.groboot.mdaemergency.services.KeepAliveService.updateNotification";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        a(KeepAliveService keepAliveService) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    }

    private BroadcastReceiver a() {
        return new a(this);
    }

    public static void b(Context context) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        registerReceiver(a(), new IntentFilter(this.f7983f));
        p.n0();
        m.t();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        intent.getAction().equals(this.f7983f);
        boolean n02 = p.n0();
        boolean t10 = m.t();
        if (n02 || t10) {
            return 1;
        }
        ((NotificationManager) getSystemService("notification")).cancel(f7982g);
        stopSelf();
        return 1;
    }
}
