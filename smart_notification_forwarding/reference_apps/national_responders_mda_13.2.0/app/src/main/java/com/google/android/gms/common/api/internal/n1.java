package com.google.android.gms.common.api.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n1 {

    /* renamed from: a, reason: collision with root package name */
    private final b f4935a;

    /* renamed from: b, reason: collision with root package name */
    private final z1.c f4936b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n1(b bVar, z1.c cVar, m1 m1Var) {
        this.f4935a = bVar;
        this.f4936b = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof n1)) {
            n1 n1Var = (n1) obj;
            if (b2.o.a(this.f4935a, n1Var.f4935a) && b2.o.a(this.f4936b, n1Var.f4936b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return b2.o.b(this.f4935a, this.f4936b);
    }

    public final String toString() {
        return b2.o.c(this).a("key", this.f4935a).a("feature", this.f4936b).toString();
    }
}
