package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzom {
    private byte[] data;
    private int zzbgp;
    private int zzbgq = 0;
    private int zzbgr;

    public zzom(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.zzbgp = i;
        this.zzbgr = i2;
        zziy();
    }

    private final boolean zzbj(int i) {
        if (2 > i || i >= this.zzbgr) {
            return false;
        }
        byte[] bArr = this.data;
        return bArr[i] == 3 && bArr[i + (-2)] == 0 && bArr[i - 1] == 0;
    }

    private final int zzix() {
        int i = 0;
        while (!zziu()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? zzbh(i) : 0);
    }

    private final void zziy() {
        int i;
        int i2;
        int i3 = this.zzbgp;
        zzoc.checkState(i3 >= 0 && (i = this.zzbgq) >= 0 && i < 8 && (i3 < (i2 = this.zzbgr) || (i3 == i2 && i == 0)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0081, code lost:
    
        if (r0 == 8) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zzbh(int r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L4
            return r0
        L4:
            int r1 = r10 / 8
            r2 = 0
        L7:
            r3 = 255(0xff, float:3.57E-43)
            r4 = 8
            if (r0 >= r1) goto L44
            int r5 = r9.zzbgp
            int r5 = r5 + 1
            boolean r5 = r9.zzbj(r5)
            if (r5 == 0) goto L1c
            int r5 = r9.zzbgp
            int r5 = r5 + 2
            goto L20
        L1c:
            int r5 = r9.zzbgp
            int r5 = r5 + 1
        L20:
            int r6 = r9.zzbgq
            if (r6 == 0) goto L34
            byte[] r7 = r9.data
            int r8 = r9.zzbgp
            r8 = r7[r8]
            r8 = r8 & r3
            int r8 = r8 << r6
            r7 = r7[r5]
            r7 = r7 & r3
            int r4 = r4 - r6
            int r4 = r7 >>> r4
            r4 = r4 | r8
            goto L3a
        L34:
            byte[] r4 = r9.data
            int r6 = r9.zzbgp
            r4 = r4[r6]
        L3a:
            int r10 = r10 + (-8)
            r3 = r3 & r4
            int r3 = r3 << r10
            r2 = r2 | r3
            r9.zzbgp = r5
            int r0 = r0 + 1
            goto L7
        L44:
            if (r10 <= 0) goto L88
            int r0 = r9.zzbgq
            int r0 = r0 + r10
            int r10 = 8 - r10
            int r10 = r3 >> r10
            byte r10 = (byte) r10
            int r1 = r9.zzbgp
            int r1 = r1 + 1
            boolean r1 = r9.zzbj(r1)
            if (r1 == 0) goto L5d
            int r1 = r9.zzbgp
            int r1 = r1 + 2
            goto L61
        L5d:
            int r1 = r9.zzbgp
            int r1 = r1 + 1
        L61:
            byte[] r5 = r9.data
            int r6 = r9.zzbgp
            if (r0 <= r4) goto L79
            r6 = r5[r6]
            r6 = r6 & r3
            int r7 = r0 + (-8)
            int r6 = r6 << r7
            r5 = r5[r1]
            r3 = r3 & r5
            int r5 = 16 - r0
            int r3 = r3 >> r5
            r3 = r3 | r6
            r10 = r10 & r3
            r10 = r10 | r2
        L76:
            r9.zzbgp = r1
            goto L84
        L79:
            r5 = r5[r6]
            r3 = r3 & r5
            int r5 = 8 - r0
            int r3 = r3 >> r5
            r10 = r10 & r3
            r10 = r10 | r2
            if (r0 != r4) goto L84
            goto L76
        L84:
            r2 = r10
            int r0 = r0 % r4
            r9.zzbgq = r0
        L88:
            r9.zziy()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzom.zzbh(int):int");
    }

    public final void zzbi(int i) {
        int i2 = this.zzbgp;
        this.zzbgp = (i / 8) + i2;
        this.zzbgq += i % 8;
        int i3 = this.zzbgq;
        if (i3 > 7) {
            this.zzbgp++;
            this.zzbgq = i3 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzbgp) {
                zziy();
                return;
            } else if (zzbj(i2)) {
                this.zzbgp++;
                i2 += 2;
            }
        }
    }

    public final boolean zziu() {
        return zzbh(1) == 1;
    }

    public final int zziv() {
        return zzix();
    }

    public final int zziw() {
        int zzix = zzix();
        return (zzix % 2 == 0 ? -1 : 1) * ((zzix + 1) / 2);
    }
}
