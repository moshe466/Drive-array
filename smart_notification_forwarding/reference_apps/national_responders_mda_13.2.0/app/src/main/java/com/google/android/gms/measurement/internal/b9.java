package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class b9 extends c9 {

    /* renamed from: c, reason: collision with root package name */
    private boolean f5875c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b9(e9 e9Var) {
        super(e9Var);
        this.f5912b.t(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean t() {
        return this.f5875c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u() {
        if (!t()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void v() {
        if (this.f5875c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        w();
        this.f5912b.l0();
        this.f5875c = true;
    }

    protected abstract boolean w();
}
