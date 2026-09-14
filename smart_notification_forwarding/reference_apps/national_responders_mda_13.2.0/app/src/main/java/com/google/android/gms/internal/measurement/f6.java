package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* loaded from: classes.dex */
final class f6 implements Comparator<d6> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(d6 d6Var, d6 d6Var2) {
        int x10;
        int x11;
        d6 d6Var3 = d6Var;
        d6 d6Var4 = d6Var2;
        m6 m6Var = (m6) d6Var3.iterator();
        m6 m6Var2 = (m6) d6Var4.iterator();
        while (m6Var.hasNext() && m6Var2.hasNext()) {
            x10 = d6.x(m6Var.zza());
            x11 = d6.x(m6Var2.zza());
            int compare = Integer.compare(x10, x11);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(d6Var3.f(), d6Var4.f());
    }
}
