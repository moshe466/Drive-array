package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import b2.c;

/* loaded from: classes.dex */
public final class e8 implements ServiceConnection, c.a, c.b {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f5998a;

    /* renamed from: b, reason: collision with root package name */
    private volatile s3 f5999b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ k7 f6000c;

    /* JADX INFO: Access modifiers changed from: protected */
    public e8(k7 k7Var) {
        this.f6000c = k7Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean c(e8 e8Var, boolean z10) {
        e8Var.f5998a = false;
        return false;
    }

    public final void a() {
        if (this.f5999b != null && (this.f5999b.a() || this.f5999b.i())) {
            this.f5999b.p();
        }
        this.f5999b = null;
    }

    public final void b(Intent intent) {
        e8 e8Var;
        this.f6000c.c();
        Context i10 = this.f6000c.i();
        f2.a b10 = f2.a.b();
        synchronized (this) {
            if (this.f5998a) {
                this.f6000c.h().N().a("Connection attempt already in progress");
                return;
            }
            this.f6000c.h().N().a("Using local app measurement service");
            this.f5998a = true;
            e8Var = this.f6000c.f6163c;
            b10.a(i10, intent, e8Var, 129);
        }
    }

    public final void d() {
        this.f6000c.c();
        Context i10 = this.f6000c.i();
        synchronized (this) {
            if (this.f5998a) {
                this.f6000c.h().N().a("Connection attempt already in progress");
                return;
            }
            if (this.f5999b != null && (this.f5999b.i() || this.f5999b.a())) {
                this.f6000c.h().N().a("Already awaiting connection attempt");
                return;
            }
            this.f5999b = new s3(i10, Looper.getMainLooper(), this, this);
            this.f6000c.h().N().a("Connecting to remote service");
            this.f5998a = true;
            this.f5999b.v();
        }
    }

    @Override // b2.c.a
    public final void i(int i10) {
        b2.p.f("MeasurementServiceConnection.onConnectionSuspended");
        this.f6000c.h().M().a("Service connection suspended");
        this.f6000c.e().z(new i8(this));
    }

    @Override // b2.c.b
    public final void n(com.google.android.gms.common.a aVar) {
        b2.p.f("MeasurementServiceConnection.onConnectionFailed");
        r3 B = this.f6000c.f6381a.B();
        if (B != null) {
            B.I().b("Service connection failed", aVar);
        }
        synchronized (this) {
            this.f5998a = false;
            this.f5999b = null;
        }
        this.f6000c.e().z(new h8(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        e8 e8Var;
        b2.p.f("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f5998a = false;
                this.f6000c.h().F().a("Service connected with null binder");
                return;
            }
            v2.c cVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    cVar = queryLocalInterface instanceof v2.c ? (v2.c) queryLocalInterface : new m3(iBinder);
                    this.f6000c.h().N().a("Bound to IMeasurementService interface");
                } else {
                    this.f6000c.h().F().b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f6000c.h().F().a("Service connect failed to get IMeasurementService");
            }
            if (cVar == null) {
                this.f5998a = false;
                try {
                    f2.a b10 = f2.a.b();
                    Context i10 = this.f6000c.i();
                    e8Var = this.f6000c.f6163c;
                    b10.c(i10, e8Var);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f6000c.e().z(new d8(this, cVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        b2.p.f("MeasurementServiceConnection.onServiceDisconnected");
        this.f6000c.h().M().a("Service disconnected");
        this.f6000c.e().z(new g8(this, componentName));
    }

    @Override // b2.c.a
    public final void p(Bundle bundle) {
        b2.p.f("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.f6000c.e().z(new f8(this, this.f5999b.I()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f5999b = null;
                this.f5998a = false;
            }
        }
    }
}
