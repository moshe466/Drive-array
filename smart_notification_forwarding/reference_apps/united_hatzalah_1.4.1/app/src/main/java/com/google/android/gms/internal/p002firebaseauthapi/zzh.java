package com.google.android.gms.internal.p002firebaseauthapi;

import e0.a;

/* loaded from: classes.dex */
final class zzh extends zzi {
    private final char zza;

    public zzh(char c4) {
        this.zza = c4;
    }

    public final String toString() {
        char c4 = this.zza;
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c4 & 15);
            c4 = (char) (c4 >> 4);
        }
        return a.e("CharMatcher.is('", String.copyValueOf(cArr), "')");
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzf
    public final boolean zza(char c4) {
        if (c4 == this.zza) {
            return true;
        }
        return false;
    }
}
