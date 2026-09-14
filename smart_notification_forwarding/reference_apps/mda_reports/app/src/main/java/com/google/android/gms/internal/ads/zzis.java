package com.google.android.gms.internal.ads;

import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class zzis extends zzip {
    public long zzamd;
    public ByteBuffer zzcs;
    public final zzio zzamc = new zzio();
    private final int zzame = 0;

    public zzis(int i) {
    }

    private final ByteBuffer zzz(int i) {
        ByteBuffer byteBuffer = this.zzcs;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(44);
        sb.append("Buffer too small (");
        sb.append(capacity);
        sb.append(" < ");
        sb.append(i);
        sb.append(")");
        throw new IllegalStateException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzip
    public final void clear() {
        super.clear();
        ByteBuffer byteBuffer = this.zzcs;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final boolean zzgd() {
        return a(Ints.MAX_POWER_OF_TWO);
    }

    public final void zzy(int i) {
        ByteBuffer byteBuffer = this.zzcs;
        if (byteBuffer == null) {
            this.zzcs = zzz(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.zzcs.position();
        int i2 = i + position;
        if (capacity >= i2) {
            return;
        }
        ByteBuffer zzz = zzz(i2);
        if (position > 0) {
            this.zzcs.position(0);
            this.zzcs.limit(position);
            zzz.put(this.zzcs);
        }
        this.zzcs = zzz;
    }
}
