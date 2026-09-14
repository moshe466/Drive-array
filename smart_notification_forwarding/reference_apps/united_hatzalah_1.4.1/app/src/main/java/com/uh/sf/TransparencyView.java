package com.uh.sf;

import F0.Q2;
import F1.k;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class TransparencyView extends Activity {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f4407b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final k f4408a = new k(this, 2);

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        registerReceiver(this.f4408a, new IntentFilter("finish"));
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 27) {
            setShowWhenLocked(true);
            new Thread(new Q2(this, 11)).start();
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        try {
            unregisterReceiver(this.f4408a);
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter filter) {
        j.e(filter, "filter");
        if (Build.VERSION.SDK_INT >= 34 && getApplicationInfo().targetSdkVersion >= 34) {
            return registerReceiver(broadcastReceiver, filter, 2);
        }
        return super.registerReceiver(broadcastReceiver, filter);
    }
}
