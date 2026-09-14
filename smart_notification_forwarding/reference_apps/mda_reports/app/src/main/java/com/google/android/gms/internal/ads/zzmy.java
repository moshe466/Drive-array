package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzmy extends zzmz {
    private static final int[] zzbds = new int[0];
    private final zznd zzbdt;
    private final AtomicReference<zzmx> zzbdu;

    public zzmy() {
        this(null);
    }

    private zzmy(zznd zzndVar) {
        this.zzbdt = null;
        this.zzbdu = new AtomicReference<>(new zzmx());
    }

    private static boolean zza(zzgw zzgwVar, String str) {
        return str != null && TextUtils.equals(str, zzoq.zzbl(zzgwVar.zzafv));
    }

    private static int zze(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    private static boolean zze(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x017d, code lost:
    
        if (r10 <= r11) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01e1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a3  */
    @Override // com.google.android.gms.internal.ads.zzmz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final com.google.android.gms.internal.ads.zzne[] a(com.google.android.gms.internal.ads.zzhe[] r37, com.google.android.gms.internal.ads.zzmr[] r38, int[][][] r39) {
        /*
            Method dump skipped, instructions count: 1106
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmy.a(com.google.android.gms.internal.ads.zzhe[], com.google.android.gms.internal.ads.zzmr[], int[][][]):com.google.android.gms.internal.ads.zzne[]");
    }
}
