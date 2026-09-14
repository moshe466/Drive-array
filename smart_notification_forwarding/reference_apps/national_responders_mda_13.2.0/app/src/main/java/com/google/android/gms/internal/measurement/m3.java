package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class m3<T> extends k3<T> {

    /* renamed from: f, reason: collision with root package name */
    private final T f5473f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m3(T t10) {
        this.f5473f = t10;
    }

    @Override // com.google.android.gms.internal.measurement.k3
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.k3
    public final T c() {
        return this.f5473f;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof m3) {
            return this.f5473f.equals(((m3) obj).f5473f);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5473f.hashCode() + 1502476572;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f5473f);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 13);
        sb2.append("Optional.of(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }
}
