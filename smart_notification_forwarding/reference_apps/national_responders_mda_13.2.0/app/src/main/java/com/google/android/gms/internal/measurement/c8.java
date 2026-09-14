package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public class c8 {

    /* renamed from: a, reason: collision with root package name */
    private volatile y8 f5237a;

    /* renamed from: b, reason: collision with root package name */
    private volatile d6 f5238b;

    static {
        y6.a();
    }

    private final y8 c(y8 y8Var) {
        if (this.f5237a == null) {
            synchronized (this) {
                if (this.f5237a == null) {
                    try {
                        this.f5237a = y8Var;
                        this.f5238b = d6.f5256g;
                    } catch (x7 unused) {
                        this.f5237a = y8Var;
                        this.f5238b = d6.f5256g;
                    }
                }
            }
        }
        return this.f5237a;
    }

    public final y8 a(y8 y8Var) {
        y8 y8Var2 = this.f5237a;
        this.f5238b = null;
        this.f5237a = y8Var;
        return y8Var2;
    }

    public final int b() {
        if (this.f5238b != null) {
            return this.f5238b.f();
        }
        if (this.f5237a != null) {
            return this.f5237a.b();
        }
        return 0;
    }

    public final d6 d() {
        if (this.f5238b != null) {
            return this.f5238b;
        }
        synchronized (this) {
            if (this.f5238b != null) {
                return this.f5238b;
            }
            this.f5238b = this.f5237a == null ? d6.f5256g : this.f5237a.a();
            return this.f5238b;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c8)) {
            return false;
        }
        c8 c8Var = (c8) obj;
        y8 y8Var = this.f5237a;
        y8 y8Var2 = c8Var.f5237a;
        return (y8Var == null && y8Var2 == null) ? d().equals(c8Var.d()) : (y8Var == null || y8Var2 == null) ? y8Var != null ? y8Var.equals(c8Var.c(y8Var.k())) : c(y8Var2.k()).equals(y8Var2) : y8Var.equals(y8Var2);
    }

    public int hashCode() {
        return 1;
    }
}
