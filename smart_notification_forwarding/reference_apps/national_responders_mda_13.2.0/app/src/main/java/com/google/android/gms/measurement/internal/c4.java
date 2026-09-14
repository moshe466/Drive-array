package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c4 extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private final e9 f5892a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5893b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5894c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c4(e9 e9Var) {
        b2.p.k(e9Var);
        this.f5892a = e9Var;
    }

    public final void b() {
        this.f5892a.i0();
        this.f5892a.e().c();
        if (this.f5893b) {
            return;
        }
        this.f5892a.i().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f5894c = this.f5892a.Y().A();
        this.f5892a.h().N().b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f5894c));
        this.f5893b = true;
    }

    public final void c() {
        this.f5892a.i0();
        this.f5892a.e().c();
        this.f5892a.e().c();
        if (this.f5893b) {
            this.f5892a.h().N().a("Unregistering connectivity change receiver");
            this.f5893b = false;
            this.f5894c = false;
            try {
                this.f5892a.i().unregisterReceiver(this);
            } catch (IllegalArgumentException e10) {
                this.f5892a.h().F().b("Failed to unregister the network broadcast receiver", e10);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        this.f5892a.i0();
        String action = intent.getAction();
        this.f5892a.h().N().b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.f5892a.h().I().b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean A = this.f5892a.Y().A();
        if (this.f5894c != A) {
            this.f5894c = A;
            this.f5892a.e().z(new f4(this, A));
        }
    }
}
