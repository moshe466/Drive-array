package com.google.android.gms.internal.measurement;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b2 extends b3 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f5186a;

    /* renamed from: b, reason: collision with root package name */
    private final o3<k3<p2>> f5187b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b2(Context context, o3<k3<p2>> o3Var) {
        Objects.requireNonNull(context, "Null context");
        this.f5186a = context;
        this.f5187b = o3Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.b3
    public final Context a() {
        return this.f5186a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.b3
    public final o3<k3<p2>> b() {
        return this.f5187b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b3) {
            b3 b3Var = (b3) obj;
            if (this.f5186a.equals(b3Var.a())) {
                o3<k3<p2>> o3Var = this.f5187b;
                o3<k3<p2>> b10 = b3Var.b();
                if (o3Var != null ? o3Var.equals(b10) : b10 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.f5186a.hashCode() ^ 1000003) * 1000003;
        o3<k3<p2>> o3Var = this.f5187b;
        return hashCode ^ (o3Var == null ? 0 : o3Var.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f5186a);
        String valueOf2 = String.valueOf(this.f5187b);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 46 + valueOf2.length());
        sb2.append("FlagsContext{context=");
        sb2.append(valueOf);
        sb2.append(", hermeticFileOverrides=");
        sb2.append(valueOf2);
        sb2.append("}");
        return sb2.toString();
    }
}
