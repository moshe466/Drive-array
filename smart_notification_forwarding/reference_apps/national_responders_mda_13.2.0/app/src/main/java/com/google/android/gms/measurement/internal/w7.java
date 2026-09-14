package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.rf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ q f6601f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f6602g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ rf f6603h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ k7 f6604i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w7(k7 k7Var, q qVar, String str, rf rfVar) {
        this.f6604i = k7Var;
        this.f6601f = qVar;
        this.f6602g = str;
        this.f6603h = rfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        byte[] bArr = null;
        try {
            try {
                cVar = this.f6604i.f6164d;
                if (cVar == null) {
                    this.f6604i.h().F().a("Discarding data. Failed to send event to service to bundle");
                } else {
                    bArr = cVar.v(this.f6601f, this.f6602g);
                    this.f6604i.e0();
                }
            } catch (RemoteException e10) {
                this.f6604i.h().F().b("Failed to send event to the service to bundle", e10);
            }
        } finally {
            this.f6604i.k().U(this.f6603h, bArr);
        }
    }
}
