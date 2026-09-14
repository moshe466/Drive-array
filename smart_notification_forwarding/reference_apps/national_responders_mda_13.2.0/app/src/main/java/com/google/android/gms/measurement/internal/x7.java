package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f6620f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ boolean f6621g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ q f6622h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ v9 f6623i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f6624j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ k7 f6625k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x7(k7 k7Var, boolean z10, boolean z11, q qVar, v9 v9Var, String str) {
        this.f6625k = k7Var;
        this.f6620f = z10;
        this.f6621g = z11;
        this.f6622h = qVar;
        this.f6623i = v9Var;
        this.f6624j = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        cVar = this.f6625k.f6164d;
        if (cVar == null) {
            this.f6625k.h().F().a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f6620f) {
            this.f6625k.T(cVar, this.f6621g ? null : this.f6622h, this.f6623i);
        } else {
            try {
                if (TextUtils.isEmpty(this.f6624j)) {
                    cVar.V(this.f6622h, this.f6623i);
                } else {
                    cVar.J(this.f6622h, this.f6624j, this.f6625k.h().O());
                }
            } catch (RemoteException e10) {
                this.f6625k.h().F().b("Failed to send event to the service", e10);
            }
        }
        this.f6625k.e0();
    }
}
