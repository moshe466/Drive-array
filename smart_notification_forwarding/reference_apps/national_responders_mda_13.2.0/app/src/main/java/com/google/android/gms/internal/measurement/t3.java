package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class t3<T> implements o3<T> {

    /* renamed from: f, reason: collision with root package name */
    private volatile o3<T> f5612f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f5613g;

    /* renamed from: h, reason: collision with root package name */
    @NullableDecl
    private T f5614h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t3(o3<T> o3Var) {
        this.f5612f = (o3) n3.b(o3Var);
    }

    public final String toString() {
        Object obj = this.f5612f;
        if (obj == null) {
            String valueOf = String.valueOf(this.f5614h);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 25);
            sb2.append("<supplier that returned ");
            sb2.append(valueOf);
            sb2.append(">");
            obj = sb2.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 19);
        sb3.append("Suppliers.memoize(");
        sb3.append(valueOf2);
        sb3.append(")");
        return sb3.toString();
    }

    @Override // com.google.android.gms.internal.measurement.o3
    public final T zza() {
        if (!this.f5613g) {
            synchronized (this) {
                if (!this.f5613g) {
                    T zza = this.f5612f.zza();
                    this.f5614h = zza;
                    this.f5613g = true;
                    this.f5612f = null;
                    return zza;
                }
            }
        }
        return this.f5614h;
    }
}
