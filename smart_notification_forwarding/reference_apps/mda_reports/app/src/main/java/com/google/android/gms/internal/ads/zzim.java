package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: classes.dex */
public final class zzim implements zzhm {
    private boolean zzakp;
    private zzin zzaky;
    private long zzala;
    private long zzalb;
    private float zzagc = 1.0f;
    private float zzagd = 1.0f;
    private int zzafo = -1;
    private int zzakk = -1;
    private ByteBuffer zzako = zzhm.zzaha;
    private ShortBuffer zzakz = this.zzako.asShortBuffer();
    private ByteBuffer zzajh = zzhm.zzaha;

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void flush() {
        this.zzaky = new zzin(this.zzakk, this.zzafo);
        this.zzaky.setSpeed(this.zzagc);
        this.zzaky.zzc(this.zzagd);
        this.zzajh = zzhm.zzaha;
        this.zzala = 0L;
        this.zzalb = 0L;
        this.zzakp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final boolean isActive() {
        return Math.abs(this.zzagc - 1.0f) >= 0.01f || Math.abs(this.zzagd - 1.0f) >= 0.01f;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void reset() {
        this.zzaky = null;
        this.zzako = zzhm.zzaha;
        this.zzakz = this.zzako.asShortBuffer();
        this.zzajh = zzhm.zzaha;
        this.zzafo = -1;
        this.zzakk = -1;
        this.zzala = 0L;
        this.zzalb = 0L;
        this.zzakp = false;
    }

    public final float zza(float f) {
        this.zzagc = zzoq.zza(f, 0.1f, 8.0f);
        return this.zzagc;
    }

    public final float zzb(float f) {
        this.zzagd = zzoq.zza(f, 0.1f, 8.0f);
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final boolean zzb(int i, int i2, int i3) {
        if (i3 != 2) {
            throw new zzhp(i, i2, i3);
        }
        if (this.zzakk == i && this.zzafo == i2) {
            return false;
        }
        this.zzakk = i;
        this.zzafo = i2;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final boolean zzeu() {
        if (!this.zzakp) {
            return false;
        }
        zzin zzinVar = this.zzaky;
        return zzinVar == null || zzinVar.zzfx() == 0;
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
        this.zzaky.zzfb();
        this.zzakp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final ByteBuffer zzfc() {
        ByteBuffer byteBuffer = this.zzajh;
        this.zzajh = zzhm.zzaha;
        return byteBuffer;
    }

    public final long zzfv() {
        return this.zzala;
    }

    public final long zzfw() {
        return this.zzalb;
    }

    @Override // com.google.android.gms.internal.ads.zzhm
    public final void zzi(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.zzala += remaining;
            this.zzaky.zza(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int zzfx = (this.zzaky.zzfx() * this.zzafo) << 1;
        if (zzfx > 0) {
            if (this.zzako.capacity() < zzfx) {
                this.zzako = ByteBuffer.allocateDirect(zzfx).order(ByteOrder.nativeOrder());
                this.zzakz = this.zzako.asShortBuffer();
            } else {
                this.zzako.clear();
                this.zzakz.clear();
            }
            this.zzaky.zzb(this.zzakz);
            this.zzalb += zzfx;
            this.zzako.limit(zzfx);
            this.zzajh = this.zzako;
        }
    }
}
