package com.google.android.recaptcha.internal;

import A.n;
import F2.l;
import F2.p;
import M2.d;
import P2.C0169t;
import P2.InterfaceC0147d0;
import P2.InterfaceC0157i0;
import P2.InterfaceC0166p;
import P2.InterfaceC0168s;
import P2.J;
import P2.Q;
import P2.r;
import P2.t0;
import P2.u0;
import P2.v0;
import P2.w0;
import T.b;
import X2.a;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.JobCancellationException;
import w2.InterfaceC0763d;
import w2.InterfaceC0766g;
import w2.InterfaceC0767h;
import w2.InterfaceC0768i;
import x2.EnumC0779a;

/* loaded from: classes.dex */
public final class zzbw implements J {
    private final /* synthetic */ InterfaceC0168s zza;

    public zzbw(InterfaceC0168s interfaceC0168s) {
        this.zza = interfaceC0168s;
    }

    @Override // P2.InterfaceC0157i0
    public final InterfaceC0166p attachChild(r rVar) {
        return this.zza.attachChild(rVar);
    }

    @Override // P2.J
    public final Object await(InterfaceC0763d interfaceC0763d) {
        Object j2 = ((C0169t) this.zza).j(interfaceC0763d);
        EnumC0779a enumC0779a = EnumC0779a.f6740a;
        return j2;
    }

    @Override // P2.InterfaceC0157i0
    public final void cancel(CancellationException cancellationException) {
        this.zza.cancel(cancellationException);
    }

    @Override // w2.InterfaceC0768i
    public final Object fold(Object obj, p operation) {
        w0 w0Var = (w0) this.zza;
        w0Var.getClass();
        j.e(operation, "operation");
        return operation.invoke(obj, w0Var);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0766g get(InterfaceC0767h interfaceC0767h) {
        w0 w0Var = (w0) this.zza;
        w0Var.getClass();
        return b.v(w0Var, interfaceC0767h);
    }

    @Override // P2.InterfaceC0157i0
    public final CancellationException getCancellationException() {
        return this.zza.getCancellationException();
    }

    @Override // P2.InterfaceC0157i0
    public final d getChildren() {
        return this.zza.getChildren();
    }

    @Override // P2.J
    public final Object getCompleted() {
        return ((C0169t) this.zza).s();
    }

    @Override // P2.J
    public final Throwable getCompletionExceptionOrNull() {
        return ((w0) this.zza).getCompletionExceptionOrNull();
    }

    @Override // w2.InterfaceC0766g
    public final InterfaceC0767h getKey() {
        return this.zza.getKey();
    }

    public final X2.b getOnAwait() {
        C0169t c0169t = (C0169t) this.zza;
        c0169t.getClass();
        u.a(3, t0.f1699a);
        u.a(3, u0.f1705a);
        return new n(c0169t, 25);
    }

    public final a getOnJoin() {
        w0 w0Var = (w0) this.zza;
        w0Var.getClass();
        u.a(3, v0.f1708a);
        return new n(w0Var, 24);
    }

    @Override // P2.InterfaceC0157i0
    public final InterfaceC0157i0 getParent() {
        return ((w0) this.zza).getParent();
    }

    @Override // P2.InterfaceC0157i0
    public final Q invokeOnCompletion(l lVar) {
        return this.zza.invokeOnCompletion(lVar);
    }

    @Override // P2.InterfaceC0157i0
    public final boolean isActive() {
        return this.zza.isActive();
    }

    @Override // P2.InterfaceC0157i0
    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    public final boolean isCompleted() {
        return !(((w0) this.zza).x() instanceof InterfaceC0147d0);
    }

    @Override // P2.InterfaceC0157i0
    public final Object join(InterfaceC0763d interfaceC0763d) {
        return this.zza.join(interfaceC0763d);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i minusKey(InterfaceC0767h interfaceC0767h) {
        return this.zza.minusKey(interfaceC0767h);
    }

    public final InterfaceC0157i0 plus(InterfaceC0157i0 interfaceC0157i0) {
        this.zza.getClass();
        return interfaceC0157i0;
    }

    @Override // P2.InterfaceC0157i0
    public final boolean start() {
        return this.zza.start();
    }

    public final /* synthetic */ void cancel() {
        ((w0) this.zza).cancel(null);
    }

    @Override // P2.InterfaceC0157i0
    public final Q invokeOnCompletion(boolean z3, boolean z4, l lVar) {
        return this.zza.invokeOnCompletion(z3, z4, lVar);
    }

    @Override // w2.InterfaceC0768i
    public final InterfaceC0768i plus(InterfaceC0768i interfaceC0768i) {
        return this.zza.plus(interfaceC0768i);
    }

    public final /* synthetic */ boolean cancel(Throwable th) {
        CancellationException jobCancellationException;
        w0 w0Var = (w0) this.zza;
        w0Var.getClass();
        if (th != null) {
            jobCancellationException = w0.N(w0Var, th);
        } else {
            jobCancellationException = new JobCancellationException(w0Var.n(), null, w0Var);
        }
        w0Var.l(jobCancellationException);
        return true;
    }
}
