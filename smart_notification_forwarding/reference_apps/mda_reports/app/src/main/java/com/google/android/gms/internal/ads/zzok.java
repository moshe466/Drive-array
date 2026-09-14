package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzok {
    private byte[] data;
    private int zzbgp;
    private int zzbgq;
    private int zzbgr;

    public zzok() {
    }

    public zzok(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzok(byte[] bArr, int i) {
        this.data = bArr;
        this.zzbgr = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
    
        if (r12 == 8) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzbh(int r12) {
        /*
            r11 = this;
            r0 = 0
            if (r12 != 0) goto L4
            return r0
        L4:
            int r1 = r12 / 8
            r2 = r12
            r12 = 0
            r3 = 0
        L9:
            r4 = 1
            r5 = 255(0xff, float:3.57E-43)
            r6 = 8
            if (r12 >= r1) goto L38
            int r7 = r11.zzbgq
            if (r7 == 0) goto L25
            byte[] r8 = r11.data
            int r9 = r11.zzbgp
            r10 = r8[r9]
            r10 = r10 & r5
            int r10 = r10 << r7
            int r9 = r9 + r4
            r8 = r8[r9]
            r8 = r8 & r5
            int r6 = r6 - r7
            int r6 = r8 >>> r6
            r6 = r6 | r10
            goto L2b
        L25:
            byte[] r6 = r11.data
            int r7 = r11.zzbgp
            r6 = r6[r7]
        L2b:
            int r2 = r2 + (-8)
            r5 = r5 & r6
            int r5 = r5 << r2
            r3 = r3 | r5
            int r5 = r11.zzbgp
            int r5 = r5 + r4
            r11.zzbgp = r5
            int r12 = r12 + 1
            goto L9
        L38:
            if (r2 <= 0) goto L6c
            int r12 = r11.zzbgq
            int r12 = r12 + r2
            int r1 = 8 - r2
            int r1 = r5 >> r1
            byte r1 = (byte) r1
            byte[] r2 = r11.data
            int r7 = r11.zzbgp
            if (r12 <= r6) goto L5d
            r8 = r2[r7]
            r8 = r8 & r5
            int r9 = r12 + (-8)
            int r8 = r8 << r9
            int r9 = r7 + 1
            r2 = r2[r9]
            r2 = r2 & r5
            int r5 = 16 - r12
            int r2 = r2 >> r5
            r2 = r2 | r8
            r1 = r1 & r2
            r1 = r1 | r3
        L59:
            int r7 = r7 + r4
            r11.zzbgp = r7
            goto L68
        L5d:
            r2 = r2[r7]
            r2 = r2 & r5
            int r5 = 8 - r12
            int r2 = r2 >> r5
            r1 = r1 & r2
            r1 = r1 | r3
            if (r12 != r6) goto L68
            goto L59
        L68:
            r3 = r1
            int r12 = r12 % r6
            r11.zzbgq = r12
        L6c:
            int r12 = r11.zzbgp
            if (r12 < 0) goto L7f
            int r1 = r11.zzbgq
            if (r1 < 0) goto L7f
            if (r1 >= r6) goto L7f
            int r2 = r11.zzbgr
            if (r12 < r2) goto L7e
            if (r12 != r2) goto L7f
            if (r1 != 0) goto L7f
        L7e:
            r0 = 1
        L7f:
            com.google.android.gms.internal.ads.zzoc.checkState(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzok.zzbh(int):int");
    }
}
