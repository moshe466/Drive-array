package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.nc;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class fa extends ca {

    /* renamed from: g, reason: collision with root package name */
    private com.google.android.gms.internal.measurement.p0 f6058g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ z9 f6059h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fa(z9 z9Var, String str, int i10, com.google.android.gms.internal.measurement.p0 p0Var) {
        super(str, i10);
        this.f6059h = z9Var;
        this.f6058g = p0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.ca
    public final int a() {
        return this.f6058g.D();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.ca
    public final boolean i() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.measurement.internal.ca
    public final boolean j() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k(Long l10, Long l11, com.google.android.gms.internal.measurement.l1 l1Var, boolean z10) {
        t3 I;
        String A;
        String str;
        Boolean g10;
        boolean z11 = nc.a() && this.f6059h.m().A(this.f5913a, s.f6393a0);
        boolean G = this.f6058g.G();
        boolean I2 = this.f6058g.I();
        boolean K = this.f6058g.K();
        boolean z12 = G || I2 || K;
        Boolean bool = null;
        bool = null;
        if (z10 && !z12) {
            this.f6059h.h().N().c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f5914b), this.f6058g.C() ? Integer.valueOf(this.f6058g.D()) : null);
            return true;
        }
        com.google.android.gms.internal.measurement.n0 F = this.f6058g.F();
        boolean I3 = F.I();
        if (l1Var.V()) {
            if (F.E()) {
                g10 = ca.c(l1Var.W(), F.F());
                bool = ca.d(g10, I3);
            } else {
                I = this.f6059h.h().I();
                A = this.f6059h.j().A(l1Var.R());
                str = "No number filter for long property. property";
                I.b(str, A);
            }
        } else if (!l1Var.X()) {
            if (l1Var.T()) {
                if (F.C()) {
                    g10 = ca.g(l1Var.U(), F.D(), this.f6059h.h());
                } else if (!F.E()) {
                    I = this.f6059h.h().I();
                    A = this.f6059h.j().A(l1Var.R());
                    str = "No string or number filter defined. property";
                } else if (k9.V(l1Var.U())) {
                    g10 = ca.e(l1Var.U(), F.F());
                } else {
                    this.f6059h.h().I().c("Invalid user property value for Numeric number filter. property, value", this.f6059h.j().A(l1Var.R()), l1Var.U());
                }
                bool = ca.d(g10, I3);
            } else {
                I = this.f6059h.h().I();
                A = this.f6059h.j().A(l1Var.R());
                str = "User property has no value, property";
            }
            I.b(str, A);
        } else if (F.E()) {
            g10 = ca.b(l1Var.Y(), F.F());
            bool = ca.d(g10, I3);
        } else {
            I = this.f6059h.h().I();
            A = this.f6059h.j().A(l1Var.R());
            str = "No number filter for double property. property";
            I.b(str, A);
        }
        this.f6059h.h().N().b("Property filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        this.f5915c = Boolean.TRUE;
        if (K && !bool.booleanValue()) {
            return true;
        }
        if (!z10 || this.f6058g.G()) {
            this.f5916d = bool;
        }
        if (bool.booleanValue() && z12 && l1Var.I()) {
            long J = l1Var.J();
            if (l10 != null) {
                J = l10.longValue();
            }
            if (z11 && this.f6058g.G() && !this.f6058g.I() && l11 != null) {
                J = l11.longValue();
            }
            if (this.f6058g.I()) {
                this.f5918f = Long.valueOf(J);
            } else {
                this.f5917e = Long.valueOf(J);
            }
        }
        return true;
    }
}
