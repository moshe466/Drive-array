package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.List;

/* loaded from: classes.dex */
public final class n {
    public static final String a(la.c cVar) {
        y8.k.e(cVar, "<this>");
        List<la.e> h10 = cVar.h();
        y8.k.d(h10, "pathSegments()");
        return c(h10);
    }

    public static final String b(la.e eVar) {
        y8.k.e(eVar, "<this>");
        if (!d(eVar)) {
            String k10 = eVar.k();
            y8.k.d(k10, "asString()");
            return k10;
        }
        String k11 = eVar.k();
        y8.k.d(k11, "asString()");
        return y8.k.j(String.valueOf('`') + k11, "`");
    }

    public static final String c(List<la.e> list) {
        y8.k.e(list, "pathSegments");
        StringBuilder sb2 = new StringBuilder();
        for (la.e eVar : list) {
            if (sb2.length() > 0) {
                sb2.append(".");
            }
            sb2.append(b(eVar));
        }
        String sb3 = sb2.toString();
        y8.k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    private static final boolean d(la.e eVar) {
        boolean z10;
        if (eVar.s()) {
            return false;
        }
        String k10 = eVar.k();
        y8.k.d(k10, "asString()");
        if (!i.f11557a.contains(k10)) {
            int i10 = 0;
            while (true) {
                if (i10 >= k10.length()) {
                    z10 = false;
                    break;
                }
                char charAt = k10.charAt(i10);
                if ((Character.isLetterOrDigit(charAt) || charAt == '_') ? false : true) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            if (!z10) {
                return false;
            }
        }
        return true;
    }
}
