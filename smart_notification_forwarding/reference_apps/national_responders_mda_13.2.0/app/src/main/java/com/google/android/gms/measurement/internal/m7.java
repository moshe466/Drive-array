package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.rf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f6227f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f6228g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ boolean f6229h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ v9 f6230i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ rf f6231j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ k7 f6232k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m7(k7 k7Var, String str, String str2, boolean z10, v9 v9Var, rf rfVar) {
        this.f6232k = k7Var;
        this.f6227f = str;
        this.f6228g = str2;
        this.f6229h = z10;
        this.f6230i = v9Var;
        this.f6231j = rfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        Bundle bundle = new Bundle();
        try {
            try {
                cVar = this.f6232k.f6164d;
                if (cVar == null) {
                    this.f6232k.h().F().c("Failed to get user properties; not connected to service", this.f6227f, this.f6228g);
                } else {
                    bundle = o9.E(cVar.r(this.f6227f, this.f6228g, this.f6229h, this.f6230i));
                    this.f6232k.e0();
                }
            } catch (RemoteException e10) {
                this.f6232k.h().F().c("Failed to get user properties; remote exception", this.f6227f, e10);
            }
        } finally {
            this.f6232k.k().Q(this.f6231j, bundle);
        }
    }
}
