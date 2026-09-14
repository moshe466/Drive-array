package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class q5 extends r5 {

    /* renamed from: b, reason: collision with root package name */
    private boolean f6351b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q5(t4 t4Var) {
        super(t4Var);
        this.f6381a.j(this);
    }

    protected void o() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean p() {
        return this.f6351b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q() {
        if (!p()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void r() {
        if (this.f6351b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (t()) {
            return;
        }
        this.f6381a.t();
        this.f6351b = true;
    }

    public final void s() {
        if (this.f6351b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        o();
        this.f6381a.t();
        this.f6351b = true;
    }

    protected abstract boolean t();
}
