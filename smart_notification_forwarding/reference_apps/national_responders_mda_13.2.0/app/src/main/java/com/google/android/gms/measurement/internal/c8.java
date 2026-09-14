package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.rf;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f5907f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f5908g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ v9 f5909h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ rf f5910i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ k7 f5911j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c8(k7 k7Var, String str, String str2, v9 v9Var, rf rfVar) {
        this.f5911j = k7Var;
        this.f5907f = str;
        this.f5908g = str2;
        this.f5909h = v9Var;
        this.f5910i = rfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        v2.c cVar;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            try {
                cVar = this.f5911j.f6164d;
                if (cVar == null) {
                    this.f5911j.h().F().c("Failed to get conditional properties; not connected to service", this.f5907f, this.f5908g);
                } else {
                    arrayList = o9.t0(cVar.m0(this.f5907f, this.f5908g, this.f5909h));
                    this.f5911j.e0();
                }
            } catch (RemoteException e10) {
                this.f5911j.h().F().d("Failed to get conditional properties; remote exception", this.f5907f, this.f5908g, e10);
            }
        } finally {
            this.f5911j.k().S(this.f5910i, arrayList);
        }
    }
}
