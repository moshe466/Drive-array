package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f6665f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f6666g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f6667h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ String f6668i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ v9 f6669j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ k7 f6670k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z7(k7 k7Var, AtomicReference atomicReference, String str, String str2, String str3, v9 v9Var) {
        this.f6670k = k7Var;
        this.f6665f = atomicReference;
        this.f6666g = str;
        this.f6667h = str2;
        this.f6668i = str3;
        this.f6669j = v9Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AtomicReference atomicReference;
        v2.c cVar;
        AtomicReference atomicReference2;
        List<ha> j02;
        synchronized (this.f6665f) {
            try {
                try {
                    cVar = this.f6670k.f6164d;
                } catch (RemoteException e10) {
                    this.f6670k.h().F().d("(legacy) Failed to get conditional properties; remote exception", r3.x(this.f6666g), this.f6667h, e10);
                    this.f6665f.set(Collections.emptyList());
                    atomicReference = this.f6665f;
                }
                if (cVar == null) {
                    this.f6670k.h().F().d("(legacy) Failed to get conditional properties; not connected to service", r3.x(this.f6666g), this.f6667h, this.f6668i);
                    this.f6665f.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.f6666g)) {
                    atomicReference2 = this.f6665f;
                    j02 = cVar.m0(this.f6667h, this.f6668i, this.f6669j);
                } else {
                    atomicReference2 = this.f6665f;
                    j02 = cVar.j0(this.f6666g, this.f6667h, this.f6668i);
                }
                atomicReference2.set(j02);
                this.f6670k.e0();
                atomicReference = this.f6665f;
                atomicReference.notify();
            } finally {
                this.f6665f.notify();
            }
        }
    }
}
