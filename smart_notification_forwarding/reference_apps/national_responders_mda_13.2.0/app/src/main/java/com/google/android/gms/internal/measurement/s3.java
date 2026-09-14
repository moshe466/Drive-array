package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class s3<T> implements o3<T>, Serializable {

    /* renamed from: f, reason: collision with root package name */
    @NullableDecl
    private final T f5583f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s3(@NullableDecl T t10) {
        this.f5583f = t10;
    }

    public final boolean equals(@NullableDecl Object obj) {
        if (obj instanceof s3) {
            return l3.a(this.f5583f, ((s3) obj).f5583f);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5583f});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f5583f);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 22);
        sb2.append("Suppliers.ofInstance(");
        sb2.append(valueOf);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.measurement.o3
    public final T zza() {
        return this.f5583f;
    }
}
