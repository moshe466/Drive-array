package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g6 extends i6 {

    /* renamed from: f, reason: collision with root package name */
    private int f5332f = 0;

    /* renamed from: g, reason: collision with root package name */
    private final int f5333g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ d6 f5334h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g6(d6 d6Var) {
        this.f5334h = d6Var;
        this.f5333g = d6Var.f();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5332f < this.f5333g;
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final byte zza() {
        int i10 = this.f5332f;
        if (i10 >= this.f5333g) {
            throw new NoSuchElementException();
        }
        this.f5332f = i10 + 1;
        return this.f5334h.w(i10);
    }
}
