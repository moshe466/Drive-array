package com.google.android.recaptcha.internal;

import N2.f;
import N2.n;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class zzeg {
    private zzeg() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int zzc(String str) {
        String L3 = n.L("18.6.1", ".", "");
        int T3 = f.T(L3, "-", 0, false, 6);
        if (T3 != -1) {
            L3 = L3.substring(0, T3);
            j.d(L3, "substring(...)");
        }
        return Integer.parseInt(L3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String zzd(String str) {
        return "cesdb".concat(f.c0("18.6.1", "-", ""));
    }

    public /* synthetic */ zzeg(kotlin.jvm.internal.f fVar) {
    }
}
