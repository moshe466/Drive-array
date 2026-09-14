package com.google.android.gms.internal.common;

import F0.AbstractC0008a;

/* loaded from: classes.dex */
final class zzm extends zzl {
    private final char zza;

    public zzm(char c4) {
        this.zza = c4;
    }

    public final String toString() {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        int i = this.zza;
        for (int i3 = 0; i3 < 4; i3++) {
            cArr[5 - i3] = "0123456789ABCDEF".charAt(i & 15);
            i >>= 4;
        }
        String copyValueOf = String.copyValueOf(cArr);
        return AbstractC0008a.v(new StringBuilder(String.valueOf(copyValueOf).length() + 18), "CharMatcher.is('", copyValueOf, "')");
    }

    @Override // com.google.android.gms.internal.common.zzp
    public final boolean zza(char c4) {
        return c4 == this.zza;
    }
}
