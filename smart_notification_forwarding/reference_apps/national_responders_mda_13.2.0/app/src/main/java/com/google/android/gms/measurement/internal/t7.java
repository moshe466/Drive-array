package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t7 extends i {

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ k7 f6507e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t7(k7 k7Var, s5 s5Var) {
        super(s5Var);
        this.f6507e = k7Var;
    }

    @Override // com.google.android.gms.measurement.internal.i
    public final void b() {
        this.f6507e.h().I().a("Tasks have been queued for a long time");
    }
}
