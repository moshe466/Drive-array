package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.q0;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class ca {

    /* renamed from: a, reason: collision with root package name */
    String f5913a;

    /* renamed from: b, reason: collision with root package name */
    int f5914b;

    /* renamed from: c, reason: collision with root package name */
    Boolean f5915c;

    /* renamed from: d, reason: collision with root package name */
    Boolean f5916d;

    /* renamed from: e, reason: collision with root package name */
    Long f5917e;

    /* renamed from: f, reason: collision with root package name */
    Long f5918f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(String str, int i10) {
        this.f5913a = str;
        this.f5914b = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean b(double d10, com.google.android.gms.internal.measurement.o0 o0Var) {
        try {
            return h(new BigDecimal(d10), o0Var, Math.ulp(d10));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean c(long j10, com.google.android.gms.internal.measurement.o0 o0Var) {
        try {
            return h(new BigDecimal(j10), o0Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean d(Boolean bool, boolean z10) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean e(String str, com.google.android.gms.internal.measurement.o0 o0Var) {
        if (!k9.V(str)) {
            return null;
        }
        try {
            return h(new BigDecimal(str), o0Var, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static Boolean f(String str, q0.b bVar, boolean z10, String str2, List<String> list, String str3, r3 r3Var) {
        boolean startsWith;
        if (str == null) {
            return null;
        }
        if (bVar == q0.b.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z10 && bVar != q0.b.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (y9.f6645a[bVar.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z10 ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    if (r3Var != null) {
                        r3Var.I().b("Invalid regular expression in REGEXP audience filter. expression", str3);
                    }
                    return null;
                }
            case 2:
                startsWith = str.startsWith(str2);
                break;
            case 3:
                startsWith = str.endsWith(str2);
                break;
            case 4:
                startsWith = str.contains(str2);
                break;
            case 5:
                startsWith = str.equals(str2);
                break;
            case 6:
                startsWith = list.contains(str);
                break;
            default:
                return null;
        }
        return Boolean.valueOf(startsWith);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Boolean g(String str, com.google.android.gms.internal.measurement.q0 q0Var, r3 r3Var) {
        List<String> list;
        b2.p.k(q0Var);
        if (str == null || !q0Var.A() || q0Var.B() == q0.b.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        q0.b B = q0Var.B();
        q0.b bVar = q0.b.IN_LIST;
        if (B == bVar) {
            if (q0Var.I() == 0) {
                return null;
            }
        } else if (!q0Var.C()) {
            return null;
        }
        q0.b B2 = q0Var.B();
        boolean F = q0Var.F();
        String D = (F || B2 == q0.b.REGEXP || B2 == bVar) ? q0Var.D() : q0Var.D().toUpperCase(Locale.ENGLISH);
        if (q0Var.I() == 0) {
            list = null;
        } else {
            List<String> G = q0Var.G();
            if (!F) {
                ArrayList arrayList = new ArrayList(G.size());
                Iterator<String> it = G.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().toUpperCase(Locale.ENGLISH));
                }
                G = Collections.unmodifiableList(arrayList);
            }
            list = G;
        }
        return f(str, B2, F, D, list, B2 == q0.b.REGEXP ? D : null, r3Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0080, code lost:
    
        if (r3 != null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.Boolean h(java.math.BigDecimal r9, com.google.android.gms.internal.measurement.o0 r10, double r11) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ca.h(java.math.BigDecimal, com.google.android.gms.internal.measurement.o0, double):java.lang.Boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean i();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean j();
}
