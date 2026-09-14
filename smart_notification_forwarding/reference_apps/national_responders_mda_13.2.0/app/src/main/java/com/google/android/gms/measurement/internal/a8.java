package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f5810f = true;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ boolean f5811g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ ha f5812h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ v9 f5813i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ ha f5814j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ k7 f5815k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a8(k7 k7Var, boolean z10, boolean z11, ha haVar, v9 v9Var, ha haVar2) {
        this.f5815k = k7Var;
        this.f5811g = z11;
        this.f5812h = haVar;
        this.f5813i = v9Var;
        this.f5814j = haVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        cVar = this.f5815k.f6164d;
        if (cVar == null) {
            this.f5815k.h().F().a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f5810f) {
            this.f5815k.T(cVar, this.f5811g ? null : this.f5812h, this.f5813i);
        } else {
            try {
                if (TextUtils.isEmpty(this.f5814j.f6091f)) {
                    cVar.l0(this.f5812h, this.f5813i);
                } else {
                    cVar.r0(this.f5812h);
                }
            } catch (RemoteException e10) {
                this.f5815k.h().F().b("Failed to send conditional user property to the service", e10);
            }
        }
        this.f5815k.e0();
    }
}
