package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class g3<T> extends k3<T> {

    /* renamed from: f, reason: collision with root package name */
    static final g3<Object> f5327f = new g3<>();

    private g3() {
    }

    @Override // com.google.android.gms.internal.measurement.k3
    public final boolean b() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.k3
    public final T c() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final boolean equals(@NullableDecl Object obj) {
        return obj == this;
    }

    public final int hashCode() {
        return 2040732332;
    }

    public final String toString() {
        return "Optional.absent()";
    }
}
