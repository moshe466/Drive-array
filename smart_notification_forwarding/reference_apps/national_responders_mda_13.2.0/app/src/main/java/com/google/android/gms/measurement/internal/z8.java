package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z8 extends i {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ e9 f6671e;

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ a9 f6672f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z8(a9 a9Var, s5 s5Var, e9 e9Var) {
        super(s5Var);
        this.f6672f = a9Var;
        this.f6671e = e9Var;
    }

    @Override // com.google.android.gms.measurement.internal.i
    public final void b() {
        this.f6672f.y();
        this.f6672f.h().N().a("Starting upload from DelayedRunnable");
        this.f6671e.j0();
    }
}
