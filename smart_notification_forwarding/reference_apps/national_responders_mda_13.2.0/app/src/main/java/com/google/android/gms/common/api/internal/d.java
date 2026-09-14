package com.google.android.gms.common.api.internal;

import a2.a;
import a2.a.b;
import a2.j;
import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public abstract class d<R extends a2.j, A extends a.b> extends BasePendingResult<R> implements e<R> {

    /* renamed from: q, reason: collision with root package name */
    private final a.c<A> f4808q;

    /* renamed from: r, reason: collision with root package name */
    private final a2.a<?> f4809r;

    private void u(RemoteException remoteException) {
        v(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.e
    public /* bridge */ /* synthetic */ void a(Object obj) {
        super.h((a2.j) obj);
    }

    protected abstract void p(A a10);

    public final a2.a<?> q() {
        return this.f4809r;
    }

    public final a.c<A> r() {
        return this.f4808q;
    }

    protected void s(R r10) {
    }

    public final void t(A a10) {
        try {
            p(a10);
        } catch (DeadObjectException e10) {
            u(e10);
            throw e10;
        } catch (RemoteException e11) {
            u(e11);
        }
    }

    public final void v(Status status) {
        b2.p.b(!status.t(), "Failed result must not be success");
        R d10 = d(status);
        h(d10);
        s(d10);
    }
}
