package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class z4 extends b2 {

    /* renamed from: b, reason: collision with root package name */
    private boolean f6659b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z4(t4 t4Var) {
        super(t4Var);
        this.f6381a.g(this);
    }

    protected void A() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean v() {
        return this.f6659b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w() {
        if (!v()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void x() {
        if (this.f6659b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (z()) {
            return;
        }
        this.f6381a.t();
        this.f6659b = true;
    }

    public final void y() {
        if (this.f6659b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        A();
        this.f6381a.t();
        this.f6659b = true;
    }

    protected abstract boolean z();
}
