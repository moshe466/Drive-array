package com.google.android.gms.measurement.internal;

import android.util.Pair;
import com.google.android.gms.internal.measurement.bc;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;
import v1.a;

/* loaded from: classes.dex */
public final class k8 extends b9 {

    /* renamed from: d, reason: collision with root package name */
    private String f6170d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f6171e;

    /* renamed from: f, reason: collision with root package name */
    private long f6172f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k8(e9 e9Var) {
        super(e9Var);
    }

    @Deprecated
    private final Pair<String, Boolean> z(String str) {
        c();
        long b10 = f().b();
        if (this.f6170d != null && b10 < this.f6172f) {
            return new Pair<>(this.f6170d, Boolean.valueOf(this.f6171e));
        }
        this.f6172f = b10 + m().B(str);
        v1.a.d(true);
        try {
            a.C0300a b11 = v1.a.b(i());
            if (b11 != null) {
                this.f6170d = b11.a();
                this.f6171e = b11.b();
            }
            if (this.f6170d == null) {
                this.f6170d = "";
            }
        } catch (Exception e10) {
            h().M().b("Unable to get advertising id", e10);
            this.f6170d = "";
        }
        v1.a.d(false);
        return new Pair<>(this.f6170d, Boolean.valueOf(this.f6171e));
    }

    @Override // com.google.android.gms.measurement.internal.b9
    protected final boolean w() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Pair<String, Boolean> x(String str, v2.a aVar) {
        return (bc.a() && m().t(s.J0) && !aVar.o()) ? new Pair<>("", Boolean.FALSE) : z(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final String y(String str) {
        c();
        String str2 = (String) z(str).first;
        MessageDigest J0 = o9.J0();
        if (J0 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, J0.digest(str2.getBytes())));
    }
}
