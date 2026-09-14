package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.bc;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6321f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ v9 f6322g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ k7 f6323h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p7(k7 k7Var, AtomicReference atomicReference, v9 v9Var) {
        this.f6323h = k7Var;
        this.f6321f = atomicReference;
        this.f6322g = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        v2.c cVar;
        synchronized (this.f6321f) {
            try {
                try {
                } catch (RemoteException e10) {
                    this.f6323h.h().F().b("Failed to get app instance id", e10);
                    atomicReference = this.f6321f;
                }
                if (bc.a() && this.f6323h.m().t(s.H0) && !this.f6323h.l().M().q()) {
                    this.f6323h.h().K().a("Analytics storage consent denied; will not get app instance id");
                    this.f6323h.p().N(null);
                    this.f6323h.l().f5965l.b(null);
                    this.f6321f.set(null);
                    return;
                }
                cVar = this.f6323h.f6164d;
                if (cVar == null) {
                    this.f6323h.h().F().a("Failed to get app instance id");
                    return;
                }
                this.f6321f.set(cVar.W(this.f6322g));
                String str = (String) this.f6321f.get();
                if (str != null) {
                    this.f6323h.p().N(str);
                    this.f6323h.l().f5965l.b(str);
                }
                this.f6323h.e0();
                atomicReference = this.f6321f;
                atomicReference.notify();
            } finally {
                this.f6321f.notify();
            }
        }
    }
}
