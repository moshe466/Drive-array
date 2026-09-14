package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class r2 extends u1 {

    /* renamed from: b, reason: collision with root package name */
    protected final z2.m f4972b;

    public r2(int i10, z2.m mVar) {
        super(i10);
        this.f4972b = mVar;
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final void a(Status status) {
        this.f4972b.d(new a2.b(status));
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final void b(Exception exc) {
        this.f4972b.d(exc);
    }

    @Override // com.google.android.gms.common.api.internal.z2
    public final void c(l1 l1Var) {
        try {
            h(l1Var);
        } catch (DeadObjectException e10) {
            a(z2.e(e10));
            throw e10;
        } catch (RemoteException e11) {
            a(z2.e(e11));
        } catch (RuntimeException e12) {
            this.f4972b.d(e12);
        }
    }

    protected abstract void h(l1 l1Var);
}
