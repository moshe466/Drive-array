package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
final class q3<T> implements o3<T>, Serializable {

    /* renamed from: f, reason: collision with root package name */
    private final o3<T> f5545f;

    /* renamed from: g, reason: collision with root package name */
    private volatile transient boolean f5546g;

    /* renamed from: h, reason: collision with root package name */
    @NullableDecl
    private transient T f5547h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q3(o3<T> o3Var) {
        this.f5545f = (o3) n3.b(o3Var);
    }

    public final String toString() {
        Object obj;
        if (this.f5546g) {
            String valueOf = String.valueOf(this.f5547h);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 25);
            sb2.append("<supplier that returned ");
            sb2.append(valueOf);
            sb2.append(">");
            obj = sb2.toString();
        } else {
            obj = this.f5545f;
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
        if (!this.f5546g) {
            synchronized (this) {
                if (!this.f5546g) {
                    T zza = this.f5545f.zza();
                    this.f5547h = zza;
                    this.f5546g = true;
                    return zza;
                }
            }
        }
        return this.f5547h;
    }
}
