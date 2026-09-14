package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n6 extends p6 {

    /* renamed from: i, reason: collision with root package name */
    protected final byte[] f5492i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n6(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.f5492i = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.d6
    public final boolean B() {
        int E = E();
        return qa.g(this.f5492i, E, f() + E);
    }

    @Override // com.google.android.gms.internal.measurement.p6
    final boolean D(d6 d6Var, int i10, int i11) {
        if (i11 > d6Var.f()) {
            int f10 = f();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i11);
            sb2.append(f10);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i11 > d6Var.f()) {
            int f11 = d6Var.f();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: 0, ");
            sb3.append(i11);
            sb3.append(", ");
            sb3.append(f11);
            throw new IllegalArgumentException(sb3.toString());
        }
        if (!(d6Var instanceof n6)) {
            return d6Var.l(0, i11).equals(l(0, i11));
        }
        n6 n6Var = (n6) d6Var;
        byte[] bArr = this.f5492i;
        byte[] bArr2 = n6Var.f5492i;
        int E = E() + i11;
        int E2 = E();
        int E3 = n6Var.E();
        while (E2 < E) {
            if (bArr[E2] != bArr2[E3]) {
                return false;
            }
            E2++;
            E3++;
        }
        return true;
    }

    protected int E() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.d6
    public byte c(int i10) {
        return this.f5492i[i10];
    }

    @Override // com.google.android.gms.internal.measurement.d6
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d6) || f() != ((d6) obj).f()) {
            return false;
        }
        if (f() == 0) {
            return true;
        }
        if (!(obj instanceof n6)) {
            return obj.equals(this);
        }
        n6 n6Var = (n6) obj;
        int C = C();
        int C2 = n6Var.C();
        if (C == 0 || C2 == 0 || C == C2) {
            return D(n6Var, 0, f());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.d6
    public int f() {
        return this.f5492i.length;
    }

    @Override // com.google.android.gms.internal.measurement.d6
    protected final int j(int i10, int i11, int i12) {
        return o7.a(i10, this.f5492i, E(), i12);
    }

    @Override // com.google.android.gms.internal.measurement.d6
    public final d6 l(int i10, int i11) {
        int y10 = d6.y(0, i11, f());
        return y10 == 0 ? d6.f5256g : new k6(this.f5492i, E(), y10);
    }

    @Override // com.google.android.gms.internal.measurement.d6
    protected final String u(Charset charset) {
        return new String(this.f5492i, E(), f(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d6
    public final void v(e6 e6Var) {
        e6Var.a(this.f5492i, E(), f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.d6
    public byte w(int i10) {
        return this.f5492i[i10];
    }
}
