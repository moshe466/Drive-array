package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bc;
import com.google.android.gms.internal.measurement.rf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ v9 f6291f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ rf f6292g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ k7 f6293h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o7(k7 k7Var, v9 v9Var, rf rfVar) {
        this.f6293h = k7Var;
        this.f6291f = v9Var;
        this.f6292g = rfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        String str = null;
        try {
            try {
                if (bc.a() && this.f6293h.m().t(s.H0) && !this.f6293h.l().M().q()) {
                    this.f6293h.h().K().a("Analytics storage consent denied; will not get app instance id");
                    this.f6293h.p().N(null);
                    this.f6293h.l().f5965l.b(null);
                } else {
                    cVar = this.f6293h.f6164d;
                    if (cVar == null) {
                        this.f6293h.h().F().a("Failed to get app instance id");
                    } else {
                        str = cVar.W(this.f6291f);
                        if (str != null) {
                            this.f6293h.p().N(str);
                            this.f6293h.l().f5965l.b(str);
                        }
                        this.f6293h.e0();
                    }
                }
            } catch (RemoteException e10) {
                this.f6293h.h().F().b("Failed to get app instance id", e10);
            }
        } finally {
            this.f6293h.k().R(this.f6292g, null);
        }
    }
}
