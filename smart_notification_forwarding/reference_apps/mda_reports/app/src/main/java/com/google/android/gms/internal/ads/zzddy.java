package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class zzddy<T> extends zzdej<T> {
    static final zzddy<Object> a = new zzddy<>();

    private zzddy() {
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

    @Override // com.google.android.gms.internal.ads.zzdej
    @NullableDecl
    public final T zzaqt() {
        return null;
    }
}
