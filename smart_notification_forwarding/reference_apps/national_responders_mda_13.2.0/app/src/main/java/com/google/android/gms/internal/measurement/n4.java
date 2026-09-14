package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
final class n4<E> extends v3<E> {

    /* renamed from: h, reason: collision with root package name */
    private final o4<E> f5491h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n4(o4<E> o4Var, int i10) {
        super(o4Var.size(), i10);
        this.f5491h = o4Var;
    }

    @Override // com.google.android.gms.internal.measurement.v3
    protected final E b(int i10) {
        return this.f5491h.get(i10);
    }
}
