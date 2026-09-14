package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b8 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f5868f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f5869g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f5870h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ String f5871i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f5872j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ v9 f5873k;

    /* renamed from: l, reason: collision with root package name */
    private final /* synthetic */ k7 f5874l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b8(k7 k7Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z10, v9 v9Var) {
        this.f5874l = k7Var;
        this.f5868f = atomicReference;
        this.f5869g = str;
        this.f5870h = str2;
        this.f5871i = str3;
        this.f5872j = z10;
        this.f5873k = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        v2.c cVar;
        AtomicReference atomicReference2;
        List<n9> K;
        synchronized (this.f5868f) {
            try {
                try {
                    cVar = this.f5874l.f6164d;
                } catch (RemoteException e10) {
                    this.f5874l.h().F().d("(legacy) Failed to get user properties; remote exception", r3.x(this.f5869g), this.f5870h, e10);
                    this.f5868f.set(Collections.emptyList());
                    atomicReference = this.f5868f;
                }
                if (cVar == null) {
                    this.f5874l.h().F().d("(legacy) Failed to get user properties; not connected to service", r3.x(this.f5869g), this.f5870h, this.f5871i);
                    this.f5868f.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.f5869g)) {
                    atomicReference2 = this.f5868f;
                    K = cVar.r(this.f5870h, this.f5871i, this.f5872j, this.f5873k);
                } else {
                    atomicReference2 = this.f5868f;
                    K = cVar.K(this.f5869g, this.f5870h, this.f5871i, this.f5872j);
                }
                atomicReference2.set(K);
                this.f5874l.e0();
                atomicReference = this.f5868f;
                atomicReference.notify();
            } finally {
                this.f5868f.notify();
            }
        }
    }
}
