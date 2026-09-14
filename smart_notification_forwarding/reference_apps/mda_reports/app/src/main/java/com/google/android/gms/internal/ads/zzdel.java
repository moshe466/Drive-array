package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdel<T> extends zzdej<T> {
    private final T zzcyy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdel(T t) {
        this.zzcyy = t;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof zzdel) {
            return this.zzcyy.equals(((zzdel) obj).zzcyy);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzcyy.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzcyy);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdej
    public final T zzaqt() {
        return this.zzcyy;
    }
}
