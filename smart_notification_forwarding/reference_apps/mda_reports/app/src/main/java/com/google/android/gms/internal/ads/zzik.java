package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class zzik implements zzhm {
    private ByteBuffer zzajh;
    private ByteBuffer zzako;
    private boolean zzakp;
    private int zzakk = -1;
    private int zzafo = -1;
    private int zzaic = 0;

    public zzik() {
        ByteBuffer byteBuffer = zzhm.zzaha;
        this.zzako = byteBuffer;
        this.zzajh = byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void flush() {
        this.zzajh = zzhm.zzaha;
        this.zzakp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final boolean isActive() {
        int i = this.zzaic;
        return (i == 0 || i == 2) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void reset() {
        flush();
        this.zzako = zzhm.zzaha;
        this.zzakk = -1;
        this.zzafo = -1;
        this.zzaic = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final boolean zzb(int i, int i2, int i3) {
        if (i3 != 3 && i3 != 2 && i3 != Integer.MIN_VALUE && i3 != 1073741824) {
            throw new zzhp(i, i2, i3);
        }
        if (this.zzakk == i && this.zzafo == i2 && this.zzaic == i3) {
            return false;
        }
        this.zzakk = i;
        this.zzafo = i2;
        this.zzaic = i3;
        if (i3 != 2) {
            return true;
        }
        this.zzako = zzhm.zzaha;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final boolean zzeu() {
        return this.zzakp && this.zzajh == zzhm.zzaha;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final int zzez() {
        return this.zzafo;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final int zzfa() {
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void zzfb() {
        this.zzakp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final ByteBuffer zzfc() {
        ByteBuffer byteBuffer = this.zzajh;
        this.zzajh = zzhm.zzaha;
        return byteBuffer;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081 A[ADDED_TO_REGION, LOOP:2: B:24:0x0081->B:25:0x0083, LOOP_START, PHI: r0
  0x0081: PHI (r0v1 int) = (r0v0 int), (r0v2 int) binds: [B:10:0x0041, B:25:0x0083] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // com.google.android.gms.internal.ads.zzhm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(java.nio.ByteBuffer r8) {
        /*
            r7 = this;
            int r0 = r8.position()
            int r1 = r8.limit()
            int r2 = r1 - r0
            int r3 = r7.zzaic
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 3
            if (r3 == r5) goto L20
            if (r3 == r6) goto L21
            if (r3 != r4) goto L1a
            int r2 = r2 / 2
            goto L23
        L1a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L20:
            int r2 = r2 / r6
        L21:
            int r2 = r2 << 1
        L23:
            java.nio.ByteBuffer r3 = r7.zzako
            int r3 = r3.capacity()
            if (r3 >= r2) goto L3a
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocateDirect(r2)
            java.nio.ByteOrder r3 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r2 = r2.order(r3)
            r7.zzako = r2
            goto L3f
        L3a:
            java.nio.ByteBuffer r2 = r7.zzako
            r2.clear()
        L3f:
            int r2 = r7.zzaic
            if (r2 == r5) goto L81
            if (r2 == r6) goto L68
            if (r2 != r4) goto L62
        L47:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.zzako
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzako
            int r3 = r0 + 3
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 4
            goto L47
        L62:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>()
            throw r8
        L68:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.zzako
            r3 = 0
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzako
            byte r3 = r8.get(r0)
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 + (-128)
            byte r3 = (byte) r3
            r2.put(r3)
            int r0 = r0 + 1
            goto L68
        L81:
            if (r0 >= r1) goto L9c
            java.nio.ByteBuffer r2 = r7.zzako
            int r3 = r0 + 1
            byte r3 = r8.get(r3)
            r2.put(r3)
            java.nio.ByteBuffer r2 = r7.zzako
            int r3 = r0 + 2
            byte r3 = r8.get(r3)
            r2.put(r3)
            int r0 = r0 + 3
            goto L81
        L9c:
            int r0 = r8.limit()
            r8.position(r0)
            java.nio.ByteBuffer r8 = r7.zzako
            r8.flip()
            java.nio.ByteBuffer r8 = r7.zzako
            r7.zzajh = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzik.zzi(java.nio.ByteBuffer):void");
    }
}
