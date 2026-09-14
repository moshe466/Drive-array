package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public final class x2 extends u1 {

    /* renamed from: b, reason: collision with root package name */
    private final v f5040b;

    /* renamed from: c, reason: collision with root package name */
    private final z2.m f5041c;

    /* renamed from: d, reason: collision with root package name */
    private final u f5042d;

    public x2(int i10, v vVar, z2.m mVar, u uVar) {
        super(i10);
        this.f5041c = mVar;
        this.f5040b = vVar;
        this.f5042d = uVar;
        if (i10 == 2 && vVar.c()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final void a(Status status) {
        this.f5041c.d(this.f5042d.a(status));
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final void b(Exception exc) {
        this.f5041c.d(exc);
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final void c(l1 l1Var) {
        try {
            this.f5040b.b(l1Var.v(), this.f5041c);
        } catch (DeadObjectException e10) {
            throw e10;
        } catch (RemoteException e11) {
            a(z2.e(e11));
        } catch (RuntimeException e12) {
            this.f5041c.d(e12);
        }
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final void d(b0 b0Var, boolean z10) {
        b0Var.d(this.f5041c, z10);
    }

    @Override // com.google.android.gms.common.api.internal.u1
    public final boolean f(l1 l1Var) {
        return this.f5040b.c();
    }

    @Override // com.google.android.gms.common.api.internal.u1
    public final z1.c[] g(l1 l1Var) {
        return this.f5040b.e();
    }
}
