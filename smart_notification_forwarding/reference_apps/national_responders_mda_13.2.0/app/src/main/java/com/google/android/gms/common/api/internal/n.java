package com.google.android.gms.common.api.internal;

import a2.a;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import b2.c;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

/* loaded from: classes.dex */
public final class n implements a.f, ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    private final String f4923a;

    /* renamed from: b, reason: collision with root package name */
    private final String f4924b;

    /* renamed from: c, reason: collision with root package name */
    private final ComponentName f4925c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f4926d;

    /* renamed from: e, reason: collision with root package name */
    private final f f4927e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f4928f;

    /* renamed from: g, reason: collision with root package name */
    private final o f4929g;

    /* renamed from: h, reason: collision with root package name */
    private IBinder f4930h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4931i;

    /* renamed from: j, reason: collision with root package name */
    private String f4932j;

    private final void x() {
        if (Thread.currentThread() != this.f4928f.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    @Override // a2.a.f
    public final boolean a() {
        x();
        return this.f4930h != null;
    }

    @Override // a2.a.f
    public final boolean b() {
        return false;
    }

    @Override // a2.a.f
    public final Set<Scope> c() {
        return Collections.emptySet();
    }

    @Override // a2.a.f
    public final void e(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // a2.a.f
    public final void f(String str) {
        x();
        this.f4932j = str;
        p();
    }

    @Override // a2.a.f
    public final boolean g() {
        return false;
    }

    @Override // a2.a.f
    public final int h() {
        return 0;
    }

    @Override // a2.a.f
    public final boolean i() {
        x();
        return this.f4931i;
    }

    @Override // a2.a.f
    public final z1.c[] j() {
        return new z1.c[0];
    }

    @Override // a2.a.f
    public final String k() {
        String str = this.f4923a;
        if (str != null) {
            return str;
        }
        b2.p.k(this.f4925c);
        return this.f4925c.getPackageName();
    }

    @Override // a2.a.f
    public final String m() {
        return this.f4932j;
    }

    @Override // a2.a.f
    public final void n(b2.j jVar, Set<Scope> set) {
    }

    @Override // a2.a.f
    public final void o(c.e eVar) {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        this.f4928f.post(new Runnable() { // from class: com.google.android.gms.common.api.internal.a2
            @Override // java.lang.Runnable
            public final void run() {
                n.this.v(iBinder);
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f4928f.post(new Runnable() { // from class: com.google.android.gms.common.api.internal.z1
            @Override // java.lang.Runnable
            public final void run() {
                n.this.s();
            }
        });
    }

    @Override // a2.a.f
    public final void p() {
        x();
        String.valueOf(this.f4930h);
        try {
            this.f4926d.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.f4931i = false;
        this.f4930h = null;
    }

    @Override // a2.a.f
    public final Intent q() {
        return new Intent();
    }

    @Override // a2.a.f
    public final boolean r() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void s() {
        this.f4931i = false;
        this.f4930h = null;
        this.f4927e.i(1);
    }

    @Override // a2.a.f
    public final void t(c.InterfaceC0067c interfaceC0067c) {
        x();
        String.valueOf(this.f4930h);
        if (a()) {
            try {
                f("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.f4925c;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.f4923a).setAction(this.f4924b);
            }
            boolean bindService = this.f4926d.bindService(intent, this, b2.i.a());
            this.f4931i = bindService;
            if (!bindService) {
                this.f4930h = null;
                this.f4929g.n(new com.google.android.gms.common.a(16));
            }
            String.valueOf(this.f4930h);
        } catch (SecurityException e10) {
            this.f4931i = false;
            this.f4930h = null;
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void v(IBinder iBinder) {
        this.f4931i = false;
        this.f4930h = iBinder;
        String.valueOf(iBinder);
        this.f4927e.p(new Bundle());
    }

    public final void w(String str) {
    }
}
