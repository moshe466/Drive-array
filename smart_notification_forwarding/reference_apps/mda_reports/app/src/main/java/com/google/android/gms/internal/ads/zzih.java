package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes.dex */
final class zzih implements zzhm {
    private int zzafo;
    private ByteBuffer zzajh;
    private int zzakk;
    private int[] zzakl;
    private boolean zzakm;
    private int[] zzakn;
    private ByteBuffer zzako;
    private boolean zzakp;

    public zzih() {
        ByteBuffer byteBuffer = zzhm.zzaha;
        this.zzako = byteBuffer;
        this.zzajh = byteBuffer;
        this.zzafo = -1;
        this.zzakk = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void flush() {
        this.zzajh = zzhm.zzaha;
        this.zzakp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final boolean isActive() {
        return this.zzakm;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void reset() {
        flush();
        this.zzako = zzhm.zzaha;
        this.zzafo = -1;
        this.zzakk = -1;
        this.zzakn = null;
        this.zzakm = false;
    }

    public final void zzb(int[] iArr) {
        this.zzakl = iArr;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final boolean zzb(int i, int i2, int i3) {
        boolean z = !Arrays.equals(this.zzakl, this.zzakn);
        this.zzakn = this.zzakl;
        if (this.zzakn == null) {
            this.zzakm = false;
            return z;
        }
        if (i3 != 2) {
            throw new zzhp(i, i2, i3);
        }
        if (!z && this.zzakk == i && this.zzafo == i2) {
            return false;
        }
        this.zzakk = i;
        this.zzafo = i2;
        this.zzakm = i2 != this.zzakn.length;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzakn;
            if (i4 >= iArr.length) {
                return true;
            }
            int i5 = iArr[i4];
            if (i5 >= i2) {
                throw new zzhp(i, i2, i3);
            }
            this.zzakm = (i5 != i4) | this.zzakm;
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final boolean zzeu() {
        return this.zzakp && this.zzajh == zzhm.zzaha;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final int zzez() {
        int[] iArr = this.zzakn;
        return iArr == null ? this.zzafo : iArr.length;
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

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void zzi(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int length = (((limit - position) / (this.zzafo * 2)) * this.zzakn.length) << 1;
        if (this.zzako.capacity() < length) {
            this.zzako = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.zzako.clear();
        }
        while (position < limit) {
            for (int i : this.zzakn) {
                this.zzako.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.zzafo << 1;
        }
        byteBuffer.position(limit);
        this.zzako.flip();
        this.zzajh = this.zzako;
    }
}
