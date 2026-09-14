package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
final class zzkh implements zzkg {
    private final zzoj zzaul;
    private final int zzavf;
    private final int zzavg;
    private int zzavh;
    private int zzavi;

    public zzkh(zzkb zzkbVar) {
        this.zzaul = zzkbVar.zzaul;
        this.zzaul.zzbe(12);
        this.zzavg = this.zzaul.zzis() & 255;
        this.zzavf = this.zzaul.zzis();
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final int zzgq() {
        return this.zzavf;
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final int zzgr() {
        int i = this.zzavg;
        if (i == 8) {
            return this.zzaul.readUnsignedByte();
        }
        if (i == 16) {
            return this.zzaul.readUnsignedShort();
        }
        int i2 = this.zzavh;
        this.zzavh = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zzavi & 15;
        }
        this.zzavi = this.zzaul.readUnsignedByte();
        return (this.zzavi & 240) >> 4;
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final boolean zzgs() {
        return false;
    }
}
