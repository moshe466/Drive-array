package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class p3 extends q5 {

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicReference<String[]> f6306c = new AtomicReference<>();

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicReference<String[]> f6307d = new AtomicReference<>();

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReference<String[]> f6308e = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public p3(t4 t4Var) {
        super(t4Var);
    }

    private final boolean B() {
        return this.f6381a.J() && this.f6381a.h().C(3);
    }

    private static String x(String str, String[] strArr, String[] strArr2, AtomicReference<String[]> atomicReference) {
        String str2;
        b2.p.k(strArr);
        b2.p.k(strArr2);
        b2.p.k(atomicReference);
        b2.p.a(strArr.length == strArr2.length);
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (o9.B0(str, strArr[i10])) {
                synchronized (atomicReference) {
                    String[] strArr3 = atomicReference.get();
                    if (strArr3 == null) {
                        strArr3 = new String[strArr2.length];
                        atomicReference.set(strArr3);
                    }
                    if (strArr3[i10] == null) {
                        strArr3[i10] = strArr2[i10] + "(" + strArr[i10] + ")";
                    }
                    str2 = strArr3[i10];
                }
                return str2;
            }
        }
        return str;
    }

    private final String y(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        for (Object obj : objArr) {
            String u10 = obj instanceof Bundle ? u((Bundle) obj) : String.valueOf(obj);
            if (u10 != null) {
                if (sb2.length() != 1) {
                    sb2.append(", ");
                }
                sb2.append(u10);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String A(String str) {
        if (str == null) {
            return null;
        }
        if (!B()) {
            return str;
        }
        if (!str.startsWith("_exp_")) {
            return x(str, v2.k.f14632b, v2.k.f14631a, f6308e);
        }
        return "experiment_id(" + str + ")";
    }

    @Override // com.google.android.gms.measurement.internal.q5
    protected final boolean t() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String u(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!B()) {
            return bundle.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sb2.length() != 8) {
                sb2.append(", ");
            }
            sb2.append(z(str));
            sb2.append("=");
            Object obj = bundle.get(str);
            sb2.append(obj instanceof Bundle ? y(new Object[]{obj}) : obj instanceof Object[] ? y((Object[]) obj) : obj instanceof ArrayList ? y(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sb2.append("}]");
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String v(q qVar) {
        if (qVar == null) {
            return null;
        }
        if (!B()) {
            return qVar.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("origin=");
        sb2.append(qVar.f6335h);
        sb2.append(",name=");
        sb2.append(w(qVar.f6333f));
        sb2.append(",params=");
        p pVar = qVar.f6334g;
        sb2.append(pVar != null ? !B() ? pVar.toString() : u(pVar.s()) : null);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String w(String str) {
        if (str == null) {
            return null;
        }
        return !B() ? str : x(str, v2.i.f14629c, v2.i.f14627a, f6306c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String z(String str) {
        if (str == null) {
            return null;
        }
        return !B() ? str : x(str, v2.h.f14624b, v2.h.f14623a, f6307d);
    }
}
